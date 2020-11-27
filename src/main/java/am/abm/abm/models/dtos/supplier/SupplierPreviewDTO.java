package am.abm.abm.models.dtos.supplier;

import am.abm.abm.models.dtos.product.ProductPreviewDTO;
import am.abm.abm.models.enities.Supplier;
import am.abm.abm.models.enums.Language;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class SupplierPreviewDTO {
    private Long supplierId;
    private String fullName;
    private String address;
    private Set<ProductPreviewDTO> products;

    public SupplierPreviewDTO(Supplier supplier) {
        setSupplierId(supplier.getId());
        setFullName(supplier.getSupplierName());
        setAddress(supplier.getAddress());
        products = new HashSet<>();

            supplier.getProducts().forEach(item -> {
            products.add(new ProductPreviewDTO(item, Language.EN));
        });
    }

    public static List<SupplierPreviewDTO> supplierPreviewDTOS(List<Supplier> suppliers) {
        return suppliers.stream().map(SupplierPreviewDTO::new).collect(Collectors.toList());
    }
}
