package com.bank.cards.service;

import com.bank.cards.entity.CardResponse;
import io.reactivex.Single;

public interface CardService
{
    Single<CardResponse> getAllCardsByDocument(String documentNumber);
}
