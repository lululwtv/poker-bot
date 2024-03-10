import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class WinLogic {
    public enum HandType {
        HIGH_CARD,
        PAIR,
        TWO_PAIR,
        THREE_OF_A_KIND,
        STRAIGHT,
        FLUSH,
        FULL_HOUSE,
        FOUR_OF_A_KIND,
        STRAIGHT_FLUSH,
        ROYAL_FLUSH
    }

    public HandType determineHand(ArrayList<Card> playerCards) {
        Collections.sort(playerCards);

        if (hasRoyalFlush(playerCards)) {
            return HandType.ROYAL_FLUSH;
        }

        if (hasStraightFlush(playerCards)) {
            return HandType.STRAIGHT_FLUSH;
        }

        if (hasFourOfAKind(playerCards)) {
            return HandType.FOUR_OF_A_KIND;
        }

        if (hasFullHouse(playerCards)) {
            return HandType.FULL_HOUSE;
        }

        if (hasFlush(playerCards)) {
            return HandType.FLUSH;
        }

        if (hasStraight(playerCards)) {
            return HandType.STRAIGHT;
        }

        if (hasThreeOfAKind(playerCards)) {
            return HandType.THREE_OF_A_KIND;
        }

        if (hasTwoPair(playerCards)) {
            return HandType.TWO_PAIR;
        }

        if (hasPair(playerCards)) {
            return HandType.PAIR;
        }

        return HandType.HIGH_CARD;
    }

    private boolean hasRoyalFlush(List<Card> cards) {
        return hasStraightFlush(cards) && 
            (cards.get(0).getValue() == 10);
    }

    private boolean hasStraightFlush(List<Card> cards) {
        return hasStraight(cards) && hasFlush(cards);
    }

    private boolean hasFourOfAKind(List<Card> cards) {
        for (int i = 0; i <= cards.size() - 4; i++) {
            if (cards.get(i).getValue() == cards.get(i + 1).getValue() &&
                cards.get(i).getValue() == cards.get(i + 2).getValue() &&
                cards.get(i).getValue() == cards.get(i + 3).getValue()) {
                return true;
            }
        }
        return false;
    }

    private boolean hasFullHouse(List<Card> cards) {
        return hasThreeOfAKind(cards) && hasPair(cards);
    }

    private boolean hasFlush(List<Card> cards) {
        for (int i = 0; i < cards.size() - 1; i++) {
            if (!cards.get(i).getSuit().equals(cards.get(i + 1).getSuit())) {
                return false;
            }
        }
        return true;
    }

    private boolean hasStraight(List<Card> cards) {
        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i).getValue() != cards.get(i + 1).getValue() - 1) {
                return false;
            }
        }
        return true;
    }

    private boolean hasThreeOfAKind(List<Card> cards) {
        for (int i = 0; i <= cards.size() - 3; i++) {
            if (cards.get(i).getValue() == cards.get(i + 1).getValue() &&
                cards.get(i).getValue() == cards.get(i + 2).getValue()) {
                return true;
            }
        }
        return false;
    }

    private boolean hasTwoPair(List<Card> cards) {
        int numPairs = 0;
        for (int i = 0; i <= cards.size() - 2; i++) {
            if (cards.get(i).getValue() == cards.get(i + 1).getValue()) {
                numPairs++;
                i++;
            }
        }
        return numPairs == 2;
    }

    private boolean hasPair(List<Card> cards) {
        for (int i = 0; i <= cards.size() - 2; i++) {
            if (cards.get(i).getValue() == cards.get(i + 1).getValue()) {
                return true;
            }
        }
        return false;
    }
}
