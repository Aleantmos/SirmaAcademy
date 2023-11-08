package service;

import exceptions.UserNotLoggedException;
import util.LoggedUser;

public class AllServices {
    private static final UserService userService = new UserService();
    private static final CartService cartService = new CartService();
    private static final AdminService adminService = new AdminService();
    private static final ProductService productService = new ProductService();
    private static final ShopService shopService = new ShopService();
    private static final CustomerShoppingService customerShoppingService = new CustomerShoppingService();


    public static UserService getUserService() {
        return userService;
    }
    public static CartService getCartService() {
        return cartService;
    }

    public static AdminService getAdminService() {
        return adminService;
    }

    public static ProductService getProductService() {
        return productService;
    }

    public static ShopService getShopService() {
        return shopService;
    }


    public static CustomerShoppingService getCustomerShoppingService() {
        return customerShoppingService;
    }
}
