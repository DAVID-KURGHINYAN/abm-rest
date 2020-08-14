package am.abm.abm.models.dtos.shipper;

public class ShipperCreateDTO {
    private String shipperName;
    private Long phone;

    public String getShipperName() {
        return shipperName;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
}
