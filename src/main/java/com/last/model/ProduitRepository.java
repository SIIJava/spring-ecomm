package com.last.model;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {

	public Produit findByNomproduit(String nomproduit);
	
	public List<Produit> findByTarifBetween(BigDecimal min, BigDecimal max);

}
