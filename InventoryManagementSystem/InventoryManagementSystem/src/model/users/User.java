package model.users;

import model.enums.RoleEnum;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static Long idCnt = 0L;
    private Long id;
    private String username;
    private String password;
    private List<RoleEnum> role;
    private Long cartId;

    public User() {
    }

    public User(String username, String password) {
        setId();
        this.username = username;
        this.password = password;
        this.role = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    private void setId() {
        this.id = ++idCnt;
    }

    public String getUsername() {
        return username;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RoleEnum> getRole() {
        return role;
    }

    public void setRole(List<RoleEnum> role) {
        this.role = role;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }
}
