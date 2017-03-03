package com.last.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenteOuLocationRepository extends JpaRepository<VenteOuLocation, Integer> {

	//public VenteOuLocation findByIdventeOuLoc(Integer id);
}
