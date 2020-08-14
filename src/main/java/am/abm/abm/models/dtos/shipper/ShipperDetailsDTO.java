package am.abm.abm.models.dtos.shipper;

import am.abm.abm.models.enities.Shipper;

public class ShipperDetailsDTO {
    private Long id;
    private String shipperName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShipperName() {
        return shipperName;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }

    public ShipperDetailsDTO(Shipper shipper) {
        id = shipper.getId();
        shipperName = shipper.getShipperName();
    }
}
