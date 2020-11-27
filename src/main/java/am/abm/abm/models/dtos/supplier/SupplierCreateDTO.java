package am.abm.abm.models.dtos.supplier;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupplierCreateDTO {
    private String supplierName;
    private String contactName;
    private String address;
    private String city;
    private String postalCode;
    private String country;
    private Long phone;
    private int ordersCount;

}
