package am.abm.abm.models.dtos.supplier;

import am.abm.abm.models.enities.Supplier;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupplierDetailsDTO {

    private Long id;
    private String supplierName;
    private String address;
    private int ordersCount;

    public SupplierDetailsDTO(Supplier supplier) {
        id = supplier.getId();
        supplierName = supplier.getSupplierName();
        address = supplier.getAddress();
        ordersCount = supplier.getProducts().size();
    }
}
