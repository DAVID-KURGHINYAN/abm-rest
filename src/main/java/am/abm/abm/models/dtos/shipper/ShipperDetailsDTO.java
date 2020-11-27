package am.abm.abm.models.dtos.shipper;

import am.abm.abm.models.enities.Shipper;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShipperDetailsDTO {
    private Long id;
    private String shipperName;

    public ShipperDetailsDTO(Shipper shipper) {
        id = shipper.getId();
        shipperName = shipper.getShipperName();
    }
}
