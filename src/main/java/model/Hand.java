package model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import static model.CardValue.ACE;

public class Hand {

    private List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public Card addCard(Card card) {
        this.cards.add(card);
        return card;
    }

    public Integer getTotalValue() {
        return this.cards.stream().mapToInt(Card::getNumericValue).sum();
    }

    public boolean isBlackjack() {
        if (2 == this.cards.size() && 21 == this.getTotalValue()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isDoubleAces() {
        if (this.cards.size() == 2) {
            return 2 == this.cards.stream().filter(c -> c.getValue() == ACE).count();
        } else {
            return false;
        }
    }

    public boolean isBusted() {
        return this.getTotalValue() > 21;
    }

    public boolean stopDrawingCards() {
        return this.getTotalValue() >= 17;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ");
        this.cards.forEach(c -> {
            stringJoiner.add(c.getShortName());
        });
        return stringJoiner.toString();
    }
}
