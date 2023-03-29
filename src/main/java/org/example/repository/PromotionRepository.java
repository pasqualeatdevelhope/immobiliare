package org.example.repository;

import org.example.entity.PromotionRequest;
import org.example.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PromotionRepository extends JpaRepository<PromotionRequest,Long> {
    Optional<PromotionRequest> findByUtente(Utente utente);
}
