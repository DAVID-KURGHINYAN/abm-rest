package am.abm.abm.models.dtos.supplier;

import am.abm.abm.models.enities.Supplier;

import java.util.List;
import java.util.stream.Collectors;

public class SupplierPreviewDTO {
    private Long supplierId;
    private int ordersCount;
    private String fullName;

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public int getOrdersCount() {
        return ordersCount;
    }

    public void setOrdersCount(int ordersCount) {
        this.ordersCount = ordersCount;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public SupplierPreviewDTO(Supplier supplier) {
        setSupplierId(supplier.getId());
        setOrdersCount(supplier.getProducts().size());
    }
    public static List<SupplierPreviewDTO> supplierPreviewDTOS(List<Supplier> suppliers){
        return suppliers.stream().map(SupplierPreviewDTO::new).collect(Collectors.toList());
    }
}
