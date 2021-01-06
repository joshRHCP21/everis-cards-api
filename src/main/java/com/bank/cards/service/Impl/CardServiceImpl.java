package com.bank.cards.service.Impl;

import com.bank.cards.entity.Card;
import com.bank.cards.entity.CardResponse;
import com.bank.cards.service.CardService;
import io.reactivex.Single;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class CardServiceImpl implements CardService
{
    @Override
    public Single<CardResponse> getAllCardsByDocument(String documentNumber)
    {
        List<Card> cards = IntStream.rangeClosed(1, 6)
                                    .mapToObj(number ->
                                                new Card("111122223333444"+number,
                                                         number < 4 ? true : false))
                                    .collect(Collectors.toList());
        CardResponse cardResponse = new CardResponse(cards);
        return Single.just(cardResponse);
    }
}
