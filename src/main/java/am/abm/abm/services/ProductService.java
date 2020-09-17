package am.abm.abm.services;

import am.abm.abm.exceptions.EntityNotFoundException;
import am.abm.abm.models.dtos.product.ProductCreateDTO;
import am.abm.abm.models.dtos.product.ProductDetailsDTO;
import am.abm.abm.models.dtos.product.ProductPreviewDTO;
import am.abm.abm.models.enities.Category;
import am.abm.abm.models.enities.Product;
import am.abm.abm.models.enities.Supplier;
import am.abm.abm.repositories.CategoryRepository;
import am.abm.abm.repositories.ProductRepository;
import am.abm.abm.repositories.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final SupplierRepository supplierRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository, SupplierRepository supplierRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.supplierRepository = supplierRepository;
    }

    public ProductDetailsDTO getProductDetails(Long id) throws EntityNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            return new ProductDetailsDTO(product);
        }
        else throw new EntityNotFoundException();
    }

    public List<Product> getAll() {  //inchi hamara?
        return null;
    }

    public ProductPreviewDTO saveProduct(ProductCreateDTO productCreateDTO) {
        Optional<Category> optionalCategory = categoryRepository.findById(productCreateDTO.getCategoryId());
        if (optionalCategory.isEmpty()) {
            return null;
        }
        Optional<Supplier> optionalSupplier = supplierRepository.findById(productCreateDTO.getSupplierId());
        if (optionalSupplier.isEmpty()) {
            return null;
        }
        Product product = new Product();
        product.setCategory(optionalCategory.get());
        product.setSupplier(optionalSupplier.get());
        product.setProductName(productCreateDTO.getProductName());
        product.setUnit(productCreateDTO.getUnit());
        product.setPrice(productCreateDTO.getPrice());

        return new ProductPreviewDTO(productRepository.save(product));
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public boolean editProduct(ProductCreateDTO product, Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product oldProduct = optionalProduct.get();
            oldProduct.setProductName(product.getProductName());
            oldProduct.setUnit(product.getUnit());
            oldProduct.setPrice(product.getPrice());
            productRepository.save(oldProduct);
            return true;
        }
        return false;
    }
    

    public ProductPreviewDTO changeProductCategoryId(Long productId, Long categoryId) {  //news 03.09.2020

        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isEmpty()){
            return null;
        }
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        if (optionalCategory.isEmpty()){
            return null;
        }

        Product product = optionalProduct.get();
        product.setCategory(optionalCategory.get());
        return new ProductPreviewDTO(productRepository.save(product));
    }
}
