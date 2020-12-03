package am.abm.abm.models.dtos.user;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
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

    @NotBlank(message = "Password is required")
    private String password;


}
