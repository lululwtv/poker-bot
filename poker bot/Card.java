// Represents a card in a deck of cards.
public class Card implements Comparable<Card> {
    private int value;
    private Suits suit;

    public Card(int value, String suit) {
        this.value = value;
        this.suit = new Suits(suit);
    }

    public int getValue() {
        return this.value;
    }

    public Suits getSuit() {
        return this.suit;
    }

    public String toString() {
        if (this.value == 1) {
            return "Ace of " + this.suit.toString();
        } else if (this.value == 11) {
            return "Jack of " + this.suit.toString();
        } else if (this.value == 12) {
            return "Queen of " + this.suit.toString();
        } else if (this.value == 13) {
            return "King of " + this.suit.toString();
        } else {
            return this.value + " of " + this.suit;
        }
    }

    public boolean equals(Card other) {
        return this.value == other.getValue() && this.suit.equals(other.getSuit());
    }

    @Override
    public int compareTo(Card o) {
        if (this.value == o.getValue()) {
            return this.suit.compareTo(o.getSuit());
        }
        return this.value - o.getValue();
    }
}
