package com.smp.card.controller;

import com.smp.card.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cards")
public class CardController {

    private final CardService service;

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteCardByClientName(@RequestParam final String clientName){
        service.deleteCardByClientName(clientName);
        return ResponseEntity.accepted().build();
    }

}

