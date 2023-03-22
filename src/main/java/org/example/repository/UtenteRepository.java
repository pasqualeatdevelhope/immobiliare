package org.example.repository;

import java.util.Optional;

import org.example.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, String>{

	Optional<Utente> findByEmail(String email);

}
