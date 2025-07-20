package com.smp.card.repository;

import com.smp.card.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Long> {

    Card findByClientName(String clientName);

    Optional<Card> findByClientId(Long clientId);

}
