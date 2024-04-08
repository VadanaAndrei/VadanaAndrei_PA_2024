import java.io.Serializable;
import java.util.List;

public class GameState implements Serializable {
    private List<Stick> sticks;
    private StoneColor[][] stones;
    private StoneColor currentPlayer;

    public GameState(List<Stick> sticks, StoneColor[][] stones, StoneColor currentPlayer) {
        this.sticks = sticks;
        this.stones = stones;
        this.currentPlayer = currentPlayer;
    }

    public List<Stick> getSticks() {
        return sticks;
    }

    public StoneColor[][] getStones() {
        return stones;
    }

    public StoneColor getCurrentPlayer() {
        return currentPlayer;
    }

    public void setSticks(List<Stick> sticks) {
        this.sticks = sticks;
    }

    public void setStones(StoneColor[][] stones) {
        this.stones = stones;
    }

    public void setCurrentPlayer(StoneColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}

