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
    }
}
