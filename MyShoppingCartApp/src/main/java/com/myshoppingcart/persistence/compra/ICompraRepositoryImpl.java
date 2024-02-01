package com.myshoppingcart.persistence.compra;

import com.myshoppingcart.model.Compra;
import com.myshoppingcart.model.Producto;
import com.myshoppingcart.model.Usuario;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

//@Repository
public class ICompraRepositoryImpl implements ICompraRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public Compra insertCompra(Compra nuevaCompra) throws Exception {

        // verificamos la compra
        nuevaCompra.isValid();

        // recuperamos el usuario
        Usuario usuario = em.find(Usuario.class, nuevaCompra.getUsuario().getUid());

        // verificamos saldos y existencias
        if (usuario.getSaldo() < nuevaCompra.calcTotal()) {
            throw new RuntimeException("Saldo insuficiente en usuario:" + usuario.getSaldo() + "<" + nuevaCompra.calcTotal());
        }

        List<Producto> productos = nuevaCompra.getProductos();
        if (productos != null && productos.size() > 0) {
            List<Integer> pids = productos.stream().map(aP -> aP.getPid()).collect(Collectors.toList());

            TypedQuery<Producto> q = em.createQuery("SELECT p FROM Producto p WHERE p.pid IN :pids", Producto.class);
            q.setParameter("pids", pids);
            productos = q.getResultList();

            for (Producto producto : productos) {
                if (producto.getExistencias() - 1 <= 0) {
                    throw new RuntimeException("Producto SIN existencias suficientes: " + producto.getExistencias());
                }
            }

            // actualizamos los sados y existencias
            usuario.setSaldo(usuario.getSaldo() - nuevaCompra.calcTotal());
            nuevaCompra.setUsuario(usuario);

            for (Producto producto : productos) {
                producto.setExistencias(producto.getExistencias() - 1);
            }
            nuevaCompra.setProductos(productos);

            // persistimos
            em.persist(nuevaCompra);

            return nuevaCompra;

        } else {
            throw new RuntimeException("Compra sin productos");
        }

    }
}
