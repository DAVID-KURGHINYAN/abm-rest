package am.abm.abm.models.dtos.supplier;

import am.abm.abm.models.enities.Supplier;

public class SupplierDetailsDTO {

    private Long id;
    private String supplierName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public SupplierDetailsDTO(Supplier supplier) {
        id = supplier.getId();
        supplierName = supplier.getSupplierName();
    }
}
