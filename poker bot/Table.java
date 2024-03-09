import java.util.HashMap;

public class Table {
    private static HashMap<Integer, Player> players;
    private static Player user;
    private static Player bigBlind;
    private static Player smallBlind;
    private static String[] tableArray;

    // Constructor for the table
    // Creates n players and sets the user to be the first player
    public Table(int num) {
        players = new HashMap<>();
        user = new Player(null, null, 0);
        players.put(0, new Player(null, null, 0));
        for (int i = 1; i < num; i++) {
            players.put(i, new Player(null, null, i));
        }
    }

    public void setFirstBigBlind() {
        int randomPlayer = (int) (Math.random() * players.size());
        players.get(randomPlayer).toggleBigBlind();
        bigBlind = players.get(randomPlayer);

        // If the big blind is the first player, then the small blind is the last player
        if (randomPlayer == 0) {
            players.get(players.size() - 1).toggleSmallBlind();
            smallBlind = players.get(players.size() - 1);
        } else {
            players.get(randomPlayer - 1).toggleSmallBlind();
            smallBlind = players.get(randomPlayer - 1);
        }
    }

    public int getIndex(Player player) {
        return player.getName().equals("You") ? 0 : player.getName().charAt(4) - '0';
    }

    public String[] getTableArray() {
        return tableArray;
    }

    public Player getPlayers(int index) {
        return players.get(index);
    }

    public int getNumPlayers() {
        return players.size();
    }

    public Player getUser() {
        return user;
    }

    public Player getBigBlind() {
        return bigBlind;
    }

    public Player getSmallBlind() {
        return smallBlind;
    }

    public void setPlayerCard1(Card card, int playerIndex) {
        players.get(playerIndex).setCard1(card);
    }

    public void setPlayerCard2(Card card, int playerIndex) {
        players.get(playerIndex).setCard2(card);
    }

    public String printTableArrangement() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < players.size(); i++) {
            result.append(players.get(i).getName());
            if (players.get(i).isBigBlind()) {
                result.append(" (Big Blind)");
            } else if (players.get(i).isSmallBlind()) {
                result.append(" (Small Blind)");
            }
            result.append("\n");
        }
        tableArray = result.toString().split("\n");
        return result.toString();
    }
}
