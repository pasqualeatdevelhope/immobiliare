package org.example.repository;

import org.example.entity.PromotionRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRequestRepository extends JpaRepository<PromotionRequest, String> {

	
	
}
