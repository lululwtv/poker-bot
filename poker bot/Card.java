// Represents a card in a deck of cards.
public class Card {
    private int value;
    private String suit;

    public Card(int value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        return this.value;
    }

    public String getSuit() {
        return this.suit;
    }

    public String toString() {
        return this.value + " of " + this.suit;
    }

    public boolean equals(Card other) {
        return this.value == other.getValue() && this.suit.equals(other.getSuit());
    }
}
