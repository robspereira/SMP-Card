package com.smp.card.repository;

import com.smp.card.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {

    public Card findByClientName(String clientName);

}
