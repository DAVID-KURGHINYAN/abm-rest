package am.abm.abm.models.dtos.supplier;

import am.abm.abm.models.enities.Supplier;

public class SupplierDetailsDTO {

    private Long id;
    private String supplierName;
    private String address;
    private int ordersCount;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getOrdersCount() {
        return ordersCount;
    }

    public void setOrdersCount(int ordersCount) {
        this.ordersCount = ordersCount;
    }

    public SupplierDetailsDTO(Supplier supplier) {
        id = supplier.getId();
        supplierName = supplier.getSupplierName();
        address = supplier.getAddress();
        ordersCount = supplier.getProducts().size();
    }
}
