package am.abm.abm.services;

import am.abm.abm.exceptions.EntityNotFoundException;
import am.abm.abm.models.dtos.category.CategoryCreateDTO;
import am.abm.abm.models.dtos.category.CategoryDetailsDTO;
import am.abm.abm.models.dtos.category.CategoryPreviewDto;
import am.abm.abm.models.dtos.category.CategoryTranslationDTO;
import am.abm.abm.models.enities.Category;
import am.abm.abm.models.enities.CategoryTranslation;
import am.abm.abm.models.enums.Language;
import am.abm.abm.repositories.CategoryRepository;
import am.abm.abm.repositories.CategoryTranslateRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryTranslateRepository categoryTranslateRepository;

    public CategoryService(CategoryRepository categoryRepository, CategoryTranslateRepository categoryTranslateRepository) {
        this.categoryRepository = categoryRepository;
        this.categoryTranslateRepository = categoryTranslateRepository;
    }

    public CategoryDetailsDTO getCategoryDetails(Long id, Language language) {
        Optional<Category> optional = categoryRepository.findById(id);
        if (optional.isPresent()) {
            Optional<CategoryTranslation> translation = categoryTranslateRepository.findByCategoryAndLanguage(optional.get(), language);
            if (translation.isPresent()) {
                CategoryTranslation categoryTranslation = translation.get();
                return new CategoryDetailsDTO(categoryTranslation);
            }
        }
        return null;
    }

    public List<CategoryPreviewDto> getAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(CategoryPreviewDto::new).collect(Collectors.toList());
    }

    public CategoryPreviewDto saveCategory(CategoryCreateDTO categoryCreateDTO) {
        Category category = new Category();
        category = categoryRepository.save(category);
        List<CategoryTranslation> translations = categoryCreateDTO.getTranslations(categoryCreateDTO.getTranslations(), category);
        for (CategoryTranslation translation : translations) {
            categoryTranslateRepository.save(translation);
        }
        return new CategoryPreviewDto(category);
    }

    public CategoryPreviewDto uploadCategoryAvatar(MultipartFile categoryAvatar, Long categoryId) throws EntityNotFoundException, IOException {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        if (optionalCategory.isEmpty()) {
            throw new EntityNotFoundException();
        }
        Category category = optionalCategory.get();
        category.setCategoryAvatar(write(categoryAvatar));
        return new CategoryPreviewDto(categoryRepository.save(category));
    }

    public String write(MultipartFile file) throws IOException {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss-"));
        String fileName = date + file.getOriginalFilename();
        String filePath = "src/main/resources/media/" + fileName;
        Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
        return fileName;
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    public boolean editCategory(CategoryCreateDTO category, Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            Category oldCategory = optionalCategory.get();
            oldCategory.getTranslations().forEach(translation -> {
                Optional<CategoryTranslationDTO> tr = category.getTranslations().stream().filter(categoryTranslationDTO ->
                        categoryTranslationDTO.getLanguage() == translation.getLanguage()).findFirst();
                if (tr.isPresent()) {
                    CategoryTranslationDTO translationDTO = tr.get();
                    translation.setCategoryName(translationDTO.getCategoryName());
                    translation.setDescription(translationDTO.getDescription());
                    categoryTranslateRepository.save(translation);
                }
            });
            categoryRepository.save(oldCategory);
            return true;
        }
        return false;
    }

}
