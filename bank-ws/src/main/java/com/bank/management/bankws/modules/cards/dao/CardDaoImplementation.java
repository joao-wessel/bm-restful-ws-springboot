package com.bank.management.bankws.modules.cards.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.bank.management.bankws.modules.cards.beans.Card;

@Component
public class CardDaoImplementation implements CardDao {

	private static List<Card> cards = new ArrayList<>();

	private static int idCounter = 0;

	static {
		cards.add(new Card(++idCounter, "1234 5678 9123 4567", 2000.00, "senha"));
	}

	@Override
	public List<Card> returnAll() {
		return cards;
	}

	@Override
	public Card returnOne(int id) {
		Predicate<? super Card> predicate = card -> card.getId().equals(id);
		return cards.stream().filter(predicate).findFirst().orElse(null);
	}

	@Override
	public Card create(Card card) {
		card.setId(++idCounter);
		cards.add(card);
		return card;
	}

	@Override
	public void delete(int id) {
		Predicate<? super Card> predicate = card -> card.getId().equals(id);
		cards.removeIf(predicate);
	}
}