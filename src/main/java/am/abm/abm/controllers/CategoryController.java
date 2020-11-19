package am.abm.abm.controllers;

import am.abm.abm.models.ResponseModel;
import am.abm.abm.models.dtos.category.CategoryCreateDTO;
import am.abm.abm.models.dtos.category.CategoryDetailsDTO;
import am.abm.abm.models.dtos.category.CategoryPreviewDto;
import am.abm.abm.services.CategoryService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.activation.FileTypeMap;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@RestController
@RequestMapping("category/")
public class CategoryController extends BaseController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("list")
    public List<CategoryPreviewDto> categoryList() {
        return categoryService.getAll();
    }

    @PostMapping("add")
    public CategoryPreviewDto addCategory(@RequestBody CategoryCreateDTO category) {
        return categoryService.saveCategory(category);
    }

    @PostMapping("categoryAvatar")
    public ResponseModel uploadCategoryAvatar(@RequestParam("categoryAvatar") MultipartFile categoryAvatar, @RequestParam ("id") Long categoryId) {
        try {
            return createResult(categoryService.uploadCategoryAvatar(categoryAvatar, categoryId), "Category avatar was uploaded successfully");
        } catch (Exception e) {
            return createErrorResult(e);
        }
    }

    @PutMapping("edit/{id}")
    public boolean editCategory(@RequestBody CategoryCreateDTO category, @PathVariable Long id) {
        return categoryService.editCategory(category, id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }

    @GetMapping("details/{id}")
    public CategoryDetailsDTO details(@PathVariable Long id) {
        return categoryService.getCategoryDetails(id);
    }

}
