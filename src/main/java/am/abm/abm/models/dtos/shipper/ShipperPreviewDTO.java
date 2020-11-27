package am.abm.abm.models.dtos.shipper;

import am.abm.abm.models.enities.Shipper;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ShipperPreviewDTO {
    private Long shipperId;
    private int ordersCount;
    private String fullName;

    public ShipperPreviewDTO(Shipper shipper) {
        setShipperId(shipper.getId());
        setOrdersCount(shipper.getOrders().size());
        setFullName(shipper.getShipperName());
    }

    public static List<ShipperPreviewDTO> getShipperPreviewDTOS(List<Shipper> shippers){
        return shippers.stream().map(ShipperPreviewDTO::new).collect(Collectors.toList());
    }
}
