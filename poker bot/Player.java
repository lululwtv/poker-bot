import java.util.ArrayList;

// Simulates a player in the poker game
public class Player {
    private Card card1;
    private Card card2;
    private ArrayList<Card> hand = new ArrayList<>();
    private boolean bigBlind = false;
    private boolean smallBlind = false;
    private boolean isFolded;
    private boolean isAllIn;
    private int name; // 0 is player

    public Player(Card card1, Card card2, int name) {
        this.card1 = card1;
        this.card2 = card2;
        this.name = name;
    }

    public String getName() {
        return this.name == 0
            ? "You"
            : "NPC " + this.name;
    }

    public Card getCard1() {
        return this.card1;
    }

    public Card getCard2() {
        return this.card2;
    }

    public void toggleBigBlind() {
        this.bigBlind = !this.bigBlind;
    }

    public void toggleSmallBlind() {
        this.smallBlind = !this.smallBlind;
    }

    public boolean isBigBlind() {
        return this.bigBlind;
    }

    public boolean isSmallBlind() {
        return this.smallBlind;
    }

    public void fold() {
        this.isFolded = true;
    }

    public boolean isFolded() {
        return this.isFolded;
    }

    public void allIn() {
        this.isAllIn = true;
    }

    public boolean isAllIn() {
        return this.isAllIn;
    }

    public String toString() {
        return this.card1.toString() + " " + card2.toString();
    }

    public void setCard1(Card card) {
        this.card1 = card;
        this.hand.add(card);
    }

    public void setCard2(Card card) {
        this.card2 = card;
        this.hand.add(card);
    }

    public void addCard(Card card) {
        this.hand.add(card);
    }

    public ArrayList<Card> getHand() {
        return this.hand;
    }
}
