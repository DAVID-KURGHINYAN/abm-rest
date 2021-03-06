package am.abm.abm.models.dtos.user;

import am.abm.abm.models.enities.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserPreviewDTO {
    private Long userId;
    private int orderCount;
    private String userName;
    private String address;
    private String avatar;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UserPreviewDTO(User user) {
        setUserId(user.getId());
        setAddress(user.getAddress());
        if (user.getOrders() != null)
            setOrderCount(user.getOrders().size());

    }

    public static List<UserPreviewDTO> getUsers(List<User> users) {
        return users.stream().map(UserPreviewDTO::new).collect(Collectors.toList());
    }
}
