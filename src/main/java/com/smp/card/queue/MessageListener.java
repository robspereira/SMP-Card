package com.smp.card.queue;

import com.smp.card.DTO.CardRequestDTO;
import com.smp.card.service.CardService;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Log4j2
@RequiredArgsConstructor
public class MessageListener {

    private final String CARD_REQUEST_QUEUE = "smp-card_create-client-card";

    private final CardService cardService;

    @SqsListener(value = CARD_REQUEST_QUEUE)
    public void receiveCardCreationRequest(@Payload CardRequestDTO dto) {
        log.info("Creating a new card for client {}", dto.getClientName());

        cardService.createNewCard(dto);
    }
}
