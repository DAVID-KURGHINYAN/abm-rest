package am.abm.abm.services;

import am.abm.abm.models.dtos.category.CategoryCreateDTO;
import am.abm.abm.models.dtos.category.CategoryDetailsDTO;
import am.abm.abm.models.dtos.category.CategoryPreviewDto;
import am.abm.abm.models.enities.Category;
import am.abm.abm.models.enities.OrderDetail;
import am.abm.abm.models.enities.Product;
import am.abm.abm.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryDetailsDTO getCategoryDetails(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            return new CategoryDetailsDTO(category);
        }
        return null;
    }

    public List<CategoryPreviewDto> getAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(CategoryPreviewDto::new).collect(Collectors.toList());
    }

    public CategoryPreviewDto saveCategory(CategoryCreateDTO categoryCreateDTO) {
        Category category = new Category();
        category.setCategoryName(categoryCreateDTO.getCategoryName());
        category.setDescription(categoryCreateDTO.getDescription());
        return new CategoryPreviewDto(categoryRepository.save(category));
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    public boolean editCategory(CategoryCreateDTO category, Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            Category oldCategory = optionalCategory.get();
            oldCategory.setCategoryName(category.getCategoryName());
            oldCategory.setDescription(category.getDescription());
            categoryRepository.save(oldCategory);
            return true;
        }
        return false;
    }

}
