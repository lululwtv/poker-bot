// Simulates a player in the poker game
public class Player {
    private static Card card1;
    private static Card card2;
    private boolean bigBlind = false;
    private boolean smallBlind = false;
    private boolean isFolded;
    private boolean isAllIn;
    private int name; // 0 is player

    public Player(Card card1, Card card2, int name) {
        Player.card1 = card1;
        Player.card2 = card2;
        this.name = name;
    }

    public String getName() {
        return this.name == 0
            ? "You"
            : "NPC " + this.name;
    }

    public Card getCard1() {
        return card1;
    }

    public Card getCard2() {
        return card2;
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
        return card1.toString() + " " + card2.toString();
    }

    public void setCard1(Card card) {
        card1 = card;
    }

    public void setCard2(Card card) {
        card2 = card;
    }
}
