import javax.swing.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner spinner, spinner2;
    JButton generateButton;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        label = new JLabel("Grid size:");
        spinner = new JSpinner(new SpinnerNumberModel(10, 2, 10, 1));
        spinner2 = new JSpinner(new SpinnerNumberModel(10, 2, 10, 1));
        generateButton = new JButton("Generate");
        generateButton.addActionListener(e -> generateGrid());

        add(label);
        add(spinner);
        add(spinner2);
        add(generateButton);
    }

    public int getRows() {
        return (int) spinner.getValue();
    }

    public int getCols() {
        return (int) spinner2.getValue();
    }

    private void generateGrid() {
        int rows = (int) spinner.getValue();
        int cols = (int) spinner2.getValue();
        frame.canvas.init(rows, cols);
        frame.canvas.setCurrentPlayer(StoneColor.BLUE);
        frame.canvas.resetGame();
    }
}

