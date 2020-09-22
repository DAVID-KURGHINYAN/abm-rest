package am.abm.abm.models.dtos.user;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class UserCreateDTO {
    @NotBlank(message = "Address field not be null")
    @Min(3)
    @Max(55)
    private String address;
    @NotBlank(message = "City field not be null")
    @Min(2)
    @Max(20)
    private String city;
    @Min(1)
    @Max(15)
    private String contactName;
    @NotBlank(message = "This field can to be only Armenia")
    
    @Min(7)
    @Max(7)
    private String country;
    @NotBlank(message = "Customer name is required")
    private String customerName;
    @NotBlank(message = "Postal code is required")
    @Min(3)
    @Max(10)
    private String postalCode;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
