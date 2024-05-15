package com.myshoppingcart.persistence;

import com.myshoppingcart.model.Compra;
import com.myshoppingcart.model.Producto;
import com.myshoppingcart.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    public List<Producto> findByCompras_Usuario_Uid(int id);
}
