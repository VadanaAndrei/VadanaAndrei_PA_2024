import javax.swing.*;
import java.io.*;

public class GameStateManager {
    private MainFrame frame;

    public GameStateManager(MainFrame frame) {
        this.frame = frame;
    }

    public void saveGameState() {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save game state");
            int userSelection = fileChooser.showSaveDialog(frame);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                if (!fileToSave.getAbsolutePath().endsWith(".ser")) {
                    fileToSave = new File(fileToSave + ".ser");
                }

                GameState gameState = new GameState(
                        frame.getCanvas().getSticks(),
                        frame.getCanvas().getStones(),
                        frame.getCanvas().getCurrentPlayer()
                );

                FileOutputStream fileOut = new FileOutputStream(fileToSave);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(gameState);
                out.close();
                fileOut.close();

                JOptionPane.showMessageDialog(frame, "Game state saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error saving game state!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void loadGameState() {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Load game state");
            int userSelection = fileChooser.showOpenDialog(frame);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToLoad = fileChooser.getSelectedFile();

                FileInputStream fileIn = new FileInputStream(fileToLoad);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                GameState gameState = (GameState) in.readObject();
                in.close();
                fileIn.close();

                frame.getCanvas().setSticks(gameState.getSticks());
                frame.getCanvas().setStones(gameState.getStones());
                frame.getCanvas().setCurrentPlayer(gameState.getCurrentPlayer());
                frame.getCanvas().repaint();

                JOptionPane.showMessageDialog(frame, "Game state loaded successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error loading game state!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
