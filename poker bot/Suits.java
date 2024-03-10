import java.util.HashMap;

public class Suits implements Comparable<Suits>{
    public static final String HEARTS = "Hearts";
    public static final String DIAMONDS = "Diamonds";
    public static final String CLUBS = "Clubs";
    public static final String SPADES = "Spades";

    private String suit;

    public Suits(String suit) {
        this.suit = suit;
    }

    public static final HashMap<String, Integer> suits = new HashMap<String, Integer>() {{
        put(DIAMONDS, 0);
        put(CLUBS, 1);
        put(HEARTS, 2);
        put(SPADES, 3);
    }};

    public String toString() {
        return this.suit;
    }

    @Override
    public int compareTo(Suits o) {
        return suits.get(this.suit) - suits.get(o.suit);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Suits)) {
            return false;
        }
        Suits other = (Suits) obj;
        return this.suit.equals(other.suit);
    }
}
