package com.bank.cards.controller;

import com.bank.cards.entity.CardResponse;
import com.bank.cards.service.CardService;
import io.reactivex.Single;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/core/cards")
public class CardController
{
    @Autowired
    private final CardService cardService;

    @GetMapping
    public Single<com.bank.cards.entity.CardResponse> getAllCardsByDocumentNumber(@RequestParam(name = "documentNumber") String documentNumber)
    {
        return cardService.getAllCardsByDocument(documentNumber);
    }
}
