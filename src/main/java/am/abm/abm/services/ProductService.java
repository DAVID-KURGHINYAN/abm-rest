package am.abm.abm.services;

import am.abm.abm.models.dtos.product.ProductCreateDTO;
import am.abm.abm.models.dtos.product.ProductDetailsDTO;
import am.abm.abm.models.enities.Product;
import am.abm.abm.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }
    public ProductDetailsDTO getProductDetails(Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            return new ProductDetailsDTO(product);
        }
        return null;
    }
    public List<Product> getAll(){  //inchi hamara?
        return null;
    }
    public Product saveProduct(ProductCreateDTO productCreateDTO){
        Product product = new Product();
        product.setProductName(productCreateDTO.getProductName());
        product.setUnit(productCreateDTO.getUnit());
        product.setPrice(product.getPrice());
        return productRepository.save(product);
    }
    public void deleteProduct(Long id){productRepository.deleteById(id);}

    public boolean editProduct(ProductCreateDTO product, Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()){
            Product oldProduct = optionalProduct.get();
            oldProduct.setProductName(product.getProductName());
            oldProduct.setUnit(product.getUnit());
            oldProduct.setPrice(product.getPrice());
            productRepository.save(oldProduct);
            return true;
        }
        return false;
    }
}
