package am.abm.abm.models.dtos.user_dtos;

import am.abm.abm.models.enities.User;

public class UserDetailsDTO {
    private Long id;
    private String customerName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public UserDetailsDTO(User user)
    {
        id = user.getId();
        customerName = user.getCustomerName();
    }
}
