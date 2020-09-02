package am.abm.abm.controllers;

import am.abm.abm.models.dtos.category.CategoryCreateDTO;
import am.abm.abm.models.dtos.category.CategoryDetailsDTO;
import am.abm.abm.models.enities.Category;
import am.abm.abm.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category/")
public class CategoryController {
    private final CategoryService categoryService;
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }
    @GetMapping("list")
    public List<Category> categoryList(){return categoryService.getAll();
    }
    @PostMapping("add")
    public Category addCategory(@RequestBody CategoryCreateDTO category){
        return categoryService.saveCategory(category);
    }
    @PutMapping("edit/{id}")
    public boolean editCategory (@RequestBody CategoryCreateDTO category, @PathVariable Long id){
        return categoryService.editCategory(category,id);
    }
    @DeleteMapping("delete/{id}")
    public void deleteCategory (@PathVariable Long id){
        categoryService.deleteCategory(id);
    }
    @GetMapping("details/{id}")
    public CategoryDetailsDTO details(@PathVariable Long id){
       return categoryService.getCategoryDetails(id);
    }
}
