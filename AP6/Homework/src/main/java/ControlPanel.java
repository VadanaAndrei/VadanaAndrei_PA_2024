import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    private GameStateManager gameStateManager;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton exportBtn = new JButton("Export");
    JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        this.gameStateManager = new GameStateManager(frame);
        init();
    }

    private void init() {
        add(saveBtn);
        add(loadBtn);
        add(exportBtn);
        add(exitBtn);


        // Configure listeners
        saveBtn.addActionListener(e -> gameStateManager.saveGameState());
        loadBtn.addActionListener(e -> gameStateManager.loadGameState());
        exportBtn.addActionListener(e -> frame.getCanvas().saveCanvasImage(e));
        exitBtn.addActionListener(this::exitGame);

    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }

    private void saveCanvas(ActionEvent e) {

    }


}

