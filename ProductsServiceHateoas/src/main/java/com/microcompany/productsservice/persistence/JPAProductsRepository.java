package com.microcompany.productsservice.persistence;

import com.microcompany.productsservice.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class JPAProductsRepository implements IProductsRepository{

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Product> findAll() {
        Query query = em.createQuery("SELECT p FROM Product p");
        return (List<Product>) query.getResultList();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Product> findByNameContaining(String name) {
        return null;
    }

    @Override
    public Product findByName(String name) {
        return null;
    }

    @Override
    @Transactional
    public Product save(Product aProduct) {
        em.persist(aProduct);
        return aProduct;
    }

    @Override
    public void deleteById(Long id) {

    }
}
