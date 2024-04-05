import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        add(saveBtn);
        add(exitBtn);

        // Configure listeners
        exitBtn.addActionListener(this::exitGame);
        saveBtn.addActionListener(this::saveCanvas);
    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }

    private void saveCanvas(ActionEvent e) {

    }
}
