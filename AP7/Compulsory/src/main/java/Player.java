import java.util.ArrayList;
import java.util.List;

public class Player implements Runnable {
    private String name;
    private Game game;
    private boolean running;
    private List<Tile> tiles = new ArrayList<>();

    public Player(String name) { this.name = name; }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public void run() {
        while (running) {
            List<Tile> extractedTiles = game.getBag().extractTiles(1);
            if (extractedTiles.isEmpty()) {
                break;
            } else {
                tiles.addAll(extractedTiles);
                System.out.println(name + " extracted: " + extractedTiles);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(name + " extracted " + tiles.size() + " tiles");
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
