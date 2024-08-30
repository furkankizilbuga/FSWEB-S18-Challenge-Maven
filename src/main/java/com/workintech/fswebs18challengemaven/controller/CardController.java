package com.workintech.fswebs18challengemaven.controller;

import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.entity.Color;
import com.workintech.fswebs18challengemaven.entity.Type;
import com.workintech.fswebs18challengemaven.repository.CardRepository;
import com.workintech.fswebs18challengemaven.util.CardValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {

    private CardRepository cardRepository;

    @Autowired
    public CardController(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @GetMapping
    public List<Card> getAll() {
        List<Card> list = cardRepository.findAll();
        CardValidation.listGetterCheck(list);
        return list;
    }

    @GetMapping("/{id}")
    public Card getById(@PathVariable long id) {
        CardValidation.getterCheck(cardRepository.findById(id));
        return cardRepository.findById(id);
    }

    @PostMapping
    public Card save(@RequestBody Card card) {
        CardValidation.checkCard(card);
        return cardRepository.save(card);
    }

    @PutMapping("/")
    public Card update(@RequestBody Card card) {
        CardValidation.checkCard(card);
        return cardRepository.update(card);
    }

    @DeleteMapping("/{id}")
    public Card delete(@PathVariable long id) {
        return cardRepository.remove(id);
    }

    @GetMapping("/byColor/{color}")
    public List<Card> getByColor(@PathVariable String color) {
        List<Card> list = cardRepository.findByColor(color);
        CardValidation.listGetterCheck(list);
        return list;
    }

    @GetMapping("/byValue/{value}")
    public List<Card> getByValue(@PathVariable Integer value) {
        List<Card> list = cardRepository.findByValue(value);
        CardValidation.listGetterCheck(list);
        return list;
    }

    @GetMapping("/byType/{type}")
    public List<Card> getByType(@PathVariable String type) {
        List<Card> list = cardRepository.findByType(type);
        CardValidation.listGetterCheck(list);
        return list;
    }



}
