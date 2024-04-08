import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Bag {
    private final Queue<Tile> tiles = new LinkedList<>();

    public Bag(int maxTileNumber) {
        List<Tile> tempList = new ArrayList<>();
        for (int i = 1; i <= maxTileNumber; i++) {
            for (int j = 1; j <= maxTileNumber; j++) {
                if (i != j) {
                    tempList.add(new Tile(i, j));
                }
            }
        }
        Collections.shuffle(tempList, new Random());
        tiles.addAll(tempList);
    }

    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        for (int i = 0; i < howMany && !tiles.isEmpty(); i++) {
            extracted.add(tiles.poll());
        }
        return extracted;
    }
}
