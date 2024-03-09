// Simulates a deck of cards

import java.util.ArrayList;

public class Deck {
    private Card[] cards = new Card[52];

    public Deck() {
        // Initialize the cards
        for (int i = 0; i < 52; i++) {
            int value = i % 13 + 1;
            String suit = "";
            if (i < 13) {
                suit = "Spades";
            } else if (i < 26) {
                suit = "Hearts";
            } else if (i < 39) {
                suit = "Clubs";
            } else {
                suit = "Diamonds";
            }
            cards[i] = new Card(value, suit);
        }
    }

    public void washShuffle() {
        // Wash shuffle the cards
        for (int i = 0; i < 52; i++) {
            int j = (int) (Math.random() * 52);
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
    }

    public void riffleShuffle() {
        // Riffle shuffle the cards
        Card[] temp = new Card[52];
        int i = 0;
        int j = 26;
        for (int k = 0; k < 52; k++) {
            if (k % 2 == 0) {
                temp[k] = cards[i];
                i++;
            } else {
                temp[k] = cards[j];
                j++;
            }
        }
        cards = temp;
    }

    public void stripShuffle() {
        // Strip shuffle the cards
        Card[] newBottom = new Card[26];
        Card[] newTop = new Card[13];
        Card[] newMiddle = new Card[13];

        for (int i = 0; i < 13; i++) {
            newTop[i] = cards[i];
        }

        for (int i = 13; i < 26; i++) {
            newMiddle[i - 13] = cards[i];
        }

        for (int i = 26; i < 52; i++) {
            newBottom[i - 26] = cards[i];
        }

        Card[] temp = new Card[52];
        
        for (int i = 0; i < 13; i++) {
            temp[i] = newMiddle[i];
        }

        for (int i = 13; i < 26; i++) {
            temp[i] = newTop[i - 13];
        }

        for (int i = 26; i < 52; i++) {
            temp[i] = newBottom[i - 26];
        }

        cards = temp;
    }

    public void cutShuffle() {
        // Cut shuffle the cards
        Card[] newBottom = new Card[26];
        Card[] newTop = new Card[26];

        for (int i = 0; i < 26; i++) {
            newTop[i] = cards[i];
        }

        for (int i = 26; i < 52; i++) {
            newBottom[i - 26] = cards[i];
        }

        Card[] temp = new Card[52];

        for (int i = 0; i < 26; i++) {
            temp[i] = newBottom[i];
        }

        for (int i = 26; i < 52; i++) {
            temp[i] = newTop[i - 26];
        }

        cards = temp;
    }

    public void shuffle() {
        // Shuffle the cards
        washShuffle();
        riffleShuffle();
        riffleShuffle();
        riffleShuffle();
        stripShuffle();
        cutShuffle();
    }

    public void deal(Table table) {
        // Deal the cards starting from the small blind
        int startIndex = table.getIndex(table.getSmallBlind()) + 1;
        int count = 0;
        for (int i = startIndex; count < table.getNumPlayers(); i++) {
            if (i >= table.getNumPlayers()) {
                i -= table.getNumPlayers();
            }
            table.setPlayerCard1(cards[count], i);
            table.setPlayerCard2(cards[count + table.getNumPlayers()], i);
            count++;
        }
    }
}
