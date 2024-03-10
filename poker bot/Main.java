import java.util.Scanner;

public class Main {
    private static int n; // number of players
    public static void main(String[] args) {
        // initialize a deck of cards
        Deck cards = new Deck();

        // shuffle the cards
        System.out.println("Shuffling the cards...");
        cards.shuffle();
        System.out.println("Cards shuffled.");

        boolean isInputCorrect = false;
        Scanner sc = new Scanner(System.in);

        while (!isInputCorrect) {
            // Take input for how many players are playing
            System.out.println("How many players are playing? ");
            n = sc.nextInt();
            if (n >= 2 && n <= 12) {
                isInputCorrect = true;
            } else {
                System.out.println("Please only input a number between 2 and 12.");
            }
        }


        // Set up the table for n players
        System.out.println("Setting up the table...");
        Table table = new Table(n);
        table.setFirstBigBlind();
        System.out.println("Table set up. The big blind is: " + table.getBigBlind().getName() + " and the small blind is: " + table.getSmallBlind().getName() + ".");
        System.out.println("The players are: \n\n" + table.printTableArrangement());

        // Deal the cards to the players
        System.out.println("Dealing the cards...");
        cards.deal(table);
        System.out.println("Cards dealt.");
        System.out.println("Your cards are: " + table.getUser().getCard1() + " and " + table.getUser().getCard2() + ".");

        // Set up the flop, turn, and river
        System.out.println("Setting up the flop");
        cards.flop(table);
        System.out.println("Flop set up: " + table.getFlop()[0] + ", " + table.getFlop()[1] + ", " + table.getFlop()[2] + ".");

        // // Take user input
        // System.out.println("What would you like to do? Raise, Call, or Fold? ");
        // String userAction = sc.next();
        // System.out.println("You chose to " + userAction + ".");
        
        // Set up the turn
        System.out.println("Setting up the turn");
        cards.turn(table);
        System.out.println("Turn set up: " + table.getTurn().toString() + ".");

        // Set up the river
        System.out.println("Setting up the river");
        cards.river(table);
        System.out.println("River set up: " + table.getRiver() + ".");

        // Set cards of player
        table.setCardsAfterRiver();

        WinLogic w = new WinLogic();

        // Determine user hand
        System.out.println("Your hand is: " + w.determineHand(table.getUser().getHand()));
    }
}
