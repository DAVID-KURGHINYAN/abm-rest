package am.abm.abm.controllers;


import am.abm.abm.exceptions.EntityNotFoundException;
import am.abm.abm.models.ResponseModel;
import am.abm.abm.models.dtos.product.ProductCreateDTO;
import am.abm.abm.models.dtos.product.ProductPreviewDTO;
import am.abm.abm.models.enities.Product;
import am.abm.abm.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product/")
public class ProductController extends BaseController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("list")
    public List<Product> productList() {
        return productService.getAll();
    }

    @PostMapping("add")
    public ProductPreviewDTO addProduct(@RequestBody ProductCreateDTO product) {
        return productService.saveProduct(product);
    }

    @PutMapping("edit/{id}")
    public boolean editProduct(@RequestBody ProductCreateDTO product, @PathVariable Long id) {
        return productService.editProduct(product, id);
    }

    @PutMapping("change/{productId}{categoryId}")
    public ProductPreviewDTO changeProductCategoryId(@PathVariable Long productId, @PathVariable Long categoryId) {
        return productService.changeProductCategoryId(productId, categoryId);
    }

    @DeleteMapping("delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("details/{id}")
    public ResponseModel details(@PathVariable Long id) {

        try {
            return createResult(productService.getProductDetails(id), "Product details was retrieved successfully");
        } catch (EntityNotFoundException e) {
            return createErrorResult(e);
        }
    }
}
