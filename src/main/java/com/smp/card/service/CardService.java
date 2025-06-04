package com.smp.card.service;

import com.smp.card.DTO.CardRequestDTO;
import com.smp.card.exception.CardNotFoundException;
import com.smp.card.model.Card;
import com.smp.card.repository.CardRepository;
import com.smp.card.util.YearMonthAttributeConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository repository;

    private final YearMonthAttributeConverter converter;

    public void createNewCard(CardRequestDTO dto){

        repository.save(Card.builder()
                        .cardNumber(generateCardNumber())
                        .securityNumber(generateSecurityNumber())
                        .expirationDate(generateExpirationDate())
                        .clientId(dto.getClientId())
                        .clientName(dto.getClientName())
                        .companyId(dto.getCompanyId())
                        .companyName(dto.getCompanyName())
                        .balance(0.0)
                .build());

    }

    public void deleteCardByClientName(String clientName) {
        Card cardToDelete = repository.findByClientName(clientName);
        if(cardToDelete == null) {
            throw new CardNotFoundException("No card was found for client " + clientName);

        } else {
            repository.delete(cardToDelete);
        }

    }

    public String generateCardNumber() {
        Random random = new Random();
        StringBuilder cardNumber = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            cardNumber.append(random.nextInt(10));
        }
        return cardNumber.toString();
    }

    private String generateSecurityNumber() {
        Random random = new Random();
        int number = random.nextInt(900) + 100;
        return String.valueOf(number);
    }

    public YearMonth generateExpirationDate() {
        return YearMonth.now().plusYears(5);
    }
}
