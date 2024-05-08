package com.myshoppingcart.configuration;

import com.myshoppingcart.persistence.ICompraRepository;
import com.myshoppingcart.service.IShoppingCart;
import com.myshoppingcart.service.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan({"com.myshoppingcart.service"})
public class ServicesConfig {

    @Autowired
    ICompraRepository compraRepository;

    @Bean
    IShoppingCart getCart(){
        ShoppingCart sc = new ShoppingCart();
        sc.setRepoCompras(compraRepository);
        return sc;
    }
}
