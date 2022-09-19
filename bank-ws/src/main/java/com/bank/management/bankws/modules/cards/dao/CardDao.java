package com.bank.management.bankws.modules.cards.dao;

import java.util.List;

import com.bank.management.bankws.modules.cards.beans.Card;

public interface CardDao {

	public List<Card> returnAll();

	public Card returnOne(int id);

	public Card create(Card card);

	public void delete(int id);
}