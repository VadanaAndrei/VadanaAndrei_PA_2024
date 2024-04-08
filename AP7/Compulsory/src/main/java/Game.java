import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Bag bag;
    private final List<Player> players = new ArrayList<>();

    public Game(int maxTileNumber) {
        this.bag = new Bag(maxTileNumber);
    }

    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
        player.setRunning(true);
    }

    public void play() {
        List<Thread> threads = new ArrayList<>();
        for (Player player : players) {
            Thread playerThread = new Thread(player);
            threads.add(playerThread);
            playerThread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Bag getBag() {
        return bag;
    }

    public static void main(String[] args) {
        int maxTileNumber = 5;
        Game game = new Game(maxTileNumber);
        game.addPlayer(new Player("Andrei"));
        game.addPlayer(new Player("Tudor"));
        game.addPlayer(new Player("Stefan"));
        game.play();
    }
}



