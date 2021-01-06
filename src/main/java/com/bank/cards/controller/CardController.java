package com.bank.cards.controller;

import com.bank.cards.entity.CardResponse;
import com.bank.cards.service.CardService;
import io.reactivex.Single;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/core/cards")
@Api("/core/cards")
public class CardController
{
    @Autowired
    private final CardService cardService;

    @GetMapping
    @ApiOperation(value = "Find Cards by Document Number", notes = "Retrieving a collection of cards", response = CardResponse.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = CardResponse.class)
    })
    public Single<com.bank.cards.entity.CardResponse> getAllCardsByDocumentNumber(@RequestParam(name = "documentNumber") String documentNumber)
    {
        return cardService.getAllCardsByDocument(documentNumber);
    }
}
