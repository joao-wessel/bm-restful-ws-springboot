package com.bank.management.bankws.modules.cards.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.management.bankws.modules.cards.beans.Card;
import com.bank.management.bankws.modules.cards.dao.CardDaoImplementation;
import com.bank.management.bankws.modules.cards.exceptions.CardNotFoundException;

import jakarta.validation.Valid;

@RestController
public class CardController {

	@Autowired
	private CardDaoImplementation dao;

	public CardController(CardDaoImplementation dao) {
		this.dao = dao;
	}

	@GetMapping("/cards")
	public List<Card> returnAllCards() {
		return dao.returnAll();
	}

	@GetMapping("/cards/{id}")
	public Card returnOneCard(@PathVariable int id) {
		Card card = dao.returnOne(id);

		if (card == null) {
			throw new CardNotFoundException("id:" + id);
		}

		return card;
	}

	@PostMapping("/cards/create")
	public ResponseEntity<Card> createCard(@Valid @RequestBody Card card) {
		dao.create(card);

		return ResponseEntity.created(null).build();
	}

	@DeleteMapping("/cards/delete/{id}")
	public void deleteCard(@PathVariable int id) {
		dao.delete(id);
	}
}