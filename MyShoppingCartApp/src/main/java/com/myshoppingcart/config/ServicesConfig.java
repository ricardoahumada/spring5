package com.myshoppingcart.config;

import com.myshoppingcart.persistence.ICompraRepository;
import com.myshoppingcart.service.IShoppingCart;
import com.myshoppingcart.service.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicesConfig {
    @Autowired
    ICompraRepository compraRepo;

    @Bean
    public IShoppingCart getShoppingCart() {
        ShoppingCart cart = new ShoppingCart();
        cart.setRepoCompras(compraRepo);
        return cart;
    }

}
