package org.example.repository;

import org.example.entity.Ruolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuoloRepository extends JpaRepository<Ruolo, Integer>{

	Ruolo findByNomeRuolo(String string);

}
