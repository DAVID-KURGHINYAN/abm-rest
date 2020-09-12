package am.abm.abm.models.dtos.shipper;

import am.abm.abm.models.enities.Shipper;

import java.util.List;
import java.util.stream.Collectors;

public class ShipperPreviewDTO {
    private Long shipperId;
    private int orderCount;
    private String fullName;

    public ShipperPreviewDTO(Shipper shipper) {
        setShipperId(shipper.getId());
        setOrderCount(shipper.getOrders().size());
        setFullName(shipper.getShipperName());
    }

    public Long getShipperId() {
        return shipperId;
    }

    public void setShipperId(Long shipperId) {
        this.shipperId = shipperId;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public static List<ShipperPreviewDTO> getShipperPreviewDTOS(List<Shipper> shippers){
        return shippers.stream().map(ShipperPreviewDTO::new).collect(Collectors.toList());
    }
}
