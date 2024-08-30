package com.workintech.fswebs18challengemaven.util;

import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.entity.Type;
import com.workintech.fswebs18challengemaven.exceptions.CardException;
import org.springframework.http.HttpStatus;

import java.util.List;

public class CardValidation {

    public static void checkCard(Card card) {

        if(card == null) {
            throw new CardException("Card cannot be null!", HttpStatus.BAD_REQUEST);
        }

        if(card.getType() != null && card.getValue() != null) {
            throw new CardException("A card cannot have both type and value!", HttpStatus.BAD_REQUEST);
        }

        if(card.getType() == Type.JOKER && (card.getColor() != null || card.getValue() != null)) {
            throw new CardException("JOKER can have neither color nor value!", HttpStatus.BAD_REQUEST);
        }

    }

    public static void getterCheck(Card card) {
        if(card == null) {
            throw new CardException("Card not found!", HttpStatus.NOT_FOUND);
        }
    }

    public static void listGetterCheck(List<Card> list) {
        if(list.isEmpty()) {
            throw new CardException("Couldn't find any card matching with the request", HttpStatus.NOT_FOUND);
        }
    }

}
