package am.abm.abm.services;

import am.abm.abm.exceptions.EntityNotFoundException;
import am.abm.abm.models.dtos.product.ProductCreateDTO;
import am.abm.abm.models.dtos.product.ProductDetailsDTO;
import am.abm.abm.models.dtos.product.ProductPreviewDTO;
import am.abm.abm.models.dtos.product.ProductTranslationDTO;
import am.abm.abm.models.enities.*;
import am.abm.abm.models.enums.Language;
import am.abm.abm.repositories.CategoryRepository;
import am.abm.abm.repositories.ProductRepository;
import am.abm.abm.repositories.ProductTranslationRepository;
import am.abm.abm.repositories.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductTranslationRepository productTranslationRepository;
    private final CategoryRepository categoryRepository;
    private final SupplierRepository supplierRepository;

    public ProductService(ProductRepository productRepository, ProductTranslationRepository productTranslationRepository, CategoryRepository categoryRepository, SupplierRepository supplierRepository) {
        this.productRepository = productRepository;
        this.productTranslationRepository = productTranslationRepository;
        this.categoryRepository = categoryRepository;
        this.supplierRepository = supplierRepository;
    }

    public ProductDetailsDTO getProductDetails(Long id, Language language) throws EntityNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Optional<ProductTranslation> optionalProductTranslation = productTranslationRepository.findByProductAndLanguage(optionalProduct.get(), language);
            if (optionalProductTranslation.isPresent()) {
                ProductTranslation productTranslation = optionalProductTranslation.get();
                return new ProductDetailsDTO(productTranslation);
            }
        }
        throw new EntityNotFoundException();
    }

    public List<Product> getAll() {  //inchi hamara?
        return null;
    }

    public ProductPreviewDTO saveProduct(ProductCreateDTO productCreateDTO, Language language) {
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
        product.setUnit(productCreateDTO.getUnit());
        product.setPrice(productCreateDTO.getPrice());
        product = productRepository.save(product);

        List<ProductTranslation> translations = productCreateDTO.getProductTranslations(productCreateDTO.getTranslationDTOS(), product);
        for (ProductTranslation translation : translations) {
            productTranslationRepository.save(translation);
        }
        return new ProductPreviewDTO(productRepository.save(product),language, translations);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public boolean editProduct(ProductCreateDTO product, Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product oldProduct = optionalProduct.get();
            oldProduct.getTranslations().forEach(productTranslation -> {
                Optional<ProductTranslationDTO> ptr = product.getTranslationDTOS().stream().filter(productTranslationDTO ->
                        productTranslationDTO.getLanguage() == productTranslation.getLanguage()).findFirst();
                if (ptr.isPresent()) {
                    ProductTranslationDTO productTranslationDTO = ptr.get();
                    productTranslation.setProductName(productTranslationDTO.getProductName());
                    productTranslation.setDescription(productTranslationDTO.getDescription());
                    productTranslationRepository.save(productTranslation);
                }
            });
            productRepository.save(oldProduct);
            return true;
        }
        return false;
    }

    public ProductPreviewDTO changeProductCategoryId(Long productId, Long categoryId , Language language) throws EntityNotFoundException {  //news 03.09.2020

        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isEmpty()) {
            throw new EntityNotFoundException("Product was not found");
        }
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        if (optionalCategory.isEmpty()) {
            throw new EntityNotFoundException("Category was not found");
        }

        Product product = optionalProduct.get();
        product.setCategory(optionalCategory.get());
        return new ProductPreviewDTO(productRepository.save(product), language, new ArrayList<>(product.getTranslations()));
    }
}
