package am.abm.abm.models.dtos.supplier;

import am.abm.abm.models.dtos.product.ProductPreviewDTO;
import am.abm.abm.models.enities.Supplier;
import am.abm.abm.models.enums.Language;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SupplierPreviewDTO {
    private Long supplierId;
    private String fullName;
    private String address;
    private Set<ProductPreviewDTO> products;

    public Set<ProductPreviewDTO> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductPreviewDTO> products) {
        this.products = products;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public SupplierPreviewDTO(Supplier supplier) {
        setSupplierId(supplier.getId());
        setFullName(supplier.getSupplierName());
        setAddress(supplier.getAddress());
        products = new HashSet<>();

//        Set<Product> productsDb = supplier.getProducts();
//        for (Product product : productsDb) {
//            ProductPreviewDTO previewDTO = new ProductPreviewDTO(product);
//            products.add(previewDTO);
//        }
            supplier.getProducts().forEach(item -> {
            products.add(new ProductPreviewDTO(item, Language.EN));
        });
    }

    public static List<SupplierPreviewDTO> supplierPreviewDTOS(List<Supplier> suppliers) {
        return suppliers.stream().map(SupplierPreviewDTO::new).collect(Collectors.toList());
    }
}
