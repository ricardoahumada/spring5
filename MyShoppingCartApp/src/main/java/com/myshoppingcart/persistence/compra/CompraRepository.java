package com.myshoppingcart.persistence.compra;

import com.myshoppingcart.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.MANDATORY)
public interface CompraRepository extends JpaRepository<Compra, Integer>, ICompraRepository {
}
