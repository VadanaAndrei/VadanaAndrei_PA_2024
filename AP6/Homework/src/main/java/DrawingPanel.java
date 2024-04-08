import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.awt.Point;
import java.awt.BasicStroke;
import java.util.Random;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

enum StoneColor {
    NONE, BLUE, RED
}

public class DrawingPanel extends JPanel {
    private final MainFrame frame;
    int rows, cols;
    int canvasWidth = 400, canvasHeight = 400;
    int boardWidth, boardHeight;
    int cellWidth, cellHeight;
    int padX, padY;
    int stoneSize = 20;

    private List<Stick> sticks = new ArrayList<>();
    private final Random rand = new Random();
    private StoneColor currentPlayer = StoneColor.BLUE;
    private StoneColor[][] stones;
    private int[][] adjacencyMatrix;
    private Point lastPlacedStone = null;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        init(frame.configPanel.getRows(), frame.configPanel.getCols());
    }

    final void init(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.padX = stoneSize + 10;
        this.padY = stoneSize + 10;
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;
        stones = new StoneColor[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                stones[r][c] = StoneColor.NONE;
            }
        }
        generateSticks();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                int col = (x - padX + cellWidth / 2) / cellWidth;
                int row = (y - padY + cellHeight / 2) / cellHeight;

                if (isValidMove(row, col)) {
                    if (col >= 0 && col < cols && row >= 0 && row < rows && stones[row][col] == StoneColor.NONE) {
                        stones[row][col] = currentPlayer;
                        lastPlacedStone = new Point(col, row);
                        currentPlayer = (currentPlayer == StoneColor.BLUE) ? StoneColor.RED : StoneColor.BLUE;
                        repaint();

                        if (!checkForValidMoves()) {
                            if (currentPlayer == StoneColor.BLUE)
                                JOptionPane.showMessageDialog(frame, "Game Over. RED is the winner!");
                            else if (currentPlayer == StoneColor.RED)
                                JOptionPane.showMessageDialog(frame, "Game Over. BLUE is the winner!");
                        }
                    }
                }
            }
        });

        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        repaint();
    }


    private void generateSticks() {
        Random rand = new Random();
        sticks.clear();

        adjacencyMatrix = new int[rows * cols][rows * cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int nodeIndex = row * cols + col;

                if (rand.nextBoolean() && col < cols - 1) {
                    sticks.add(new Stick(new Point(col, row), true));

                    int rightNodeIndex = nodeIndex + 1;
                    adjacencyMatrix[nodeIndex][rightNodeIndex] = 1;
                    adjacencyMatrix[rightNodeIndex][nodeIndex] = 1;
                }

                if (rand.nextBoolean() && row < rows - 1) {
                    sticks.add(new Stick(new Point(col, row), false));

                    int bottomNodeIndex = nodeIndex + cols;
                    adjacencyMatrix[nodeIndex][bottomNodeIndex] = 1;
                    adjacencyMatrix[bottomNodeIndex][nodeIndex] = 1;
                }
            }
        }
    }


    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, canvasWidth, canvasHeight);
        paintGrid(g);
        paintSticks(graphics);
        paintStones(g);
    }

    private void paintGrid(Graphics2D g) {
        g.setColor(Color.DARK_GRAY);
        for (int row = 0; row < rows; row++) {
            int x1 = padX;
            int y1 = padY + row * cellHeight;
            int x2 = padX + boardWidth;
            int y2 = y1;
            g.drawLine(x1, y1, x2, y2);
        }
        for (int col = 0; col < cols; col++) {
            int x1 = padX + col * cellWidth;
            int y1 = padY;
            int x2 = x1;
            int y2 = padY + boardHeight;
            g.drawLine(x1, y1, x2, y2);
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = padX + col * cellWidth;
                int y = padY + row * cellHeight;
                g.setColor(Color.LIGHT_GRAY);
                g.drawOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
            }
        }
    }

    private void paintSticks(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(3));

        for (Stick stick : sticks) {
            int x1 = padX + stick.location.x * cellWidth;
            int y1 = padY + stick.location.y * cellHeight;

            if (stick.horizontal) {
                int x2 = x1 + cellWidth;
                g.drawLine(x1, y1, x2, y1);
            } else {
                int y2 = y1 + cellHeight;
                g.drawLine(x1, y1, x1, y2);
            }
        }
    }


    private void paintStones(Graphics2D g) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (stones[row][col] != StoneColor.NONE) {
                    int x = padX + col * cellWidth - stoneSize / 2;
                    int y = padY + row * cellHeight - stoneSize / 2;
                    if (stones[row][col] == StoneColor.BLUE) {
                        g.setColor(Color.BLUE);
                    } else {
                        g.setColor(Color.RED);
                    }
                    g.fillOval(x, y, stoneSize, stoneSize);
                }
            }
        }
    }

    public void setCurrentPlayer(StoneColor player) {
        this.currentPlayer = player;
    }

    public void printMatrix() {
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean isValidMove(int row, int col) {
        if (lastPlacedStone == null) {
            return true;
        }
        int lastRow = lastPlacedStone.y;
        int lastCol = lastPlacedStone.x;

        return adjacencyMatrix[lastRow * cols + lastCol][row * cols + col] == 1;
    }

    private boolean checkForValidMoves() {
        if (lastPlacedStone == null) {
            return true;
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (stones[row][col] == StoneColor.NONE && isValidMove(row, col)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void resetGame() {
        lastPlacedStone = null;
        stones = new StoneColor[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                stones[r][c] = StoneColor.NONE;
            }
        }
        generateSticks();
        repaint();
    }

    public BufferedImage createImage() {
        BufferedImage bi = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = bi.createGraphics();
        this.printAll(g2);
        g2.dispose();
        return bi;
    }

    public void saveCanvasImage(ActionEvent e) {
        BufferedImage bi = frame.canvas.createImage();
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Specify a file to save");

            int userSelection = fileChooser.showSaveDialog(frame);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                if (!fileToSave.getAbsolutePath().endsWith(".png")) {
                    fileToSave = new File(fileToSave + ".png");
                }
                ImageIO.write(bi, "PNG", fileToSave);
                JOptionPane.showMessageDialog(frame, "Image saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error saving image!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public int getStoneSize() {
        return stoneSize;
    }

    public void setStoneSize(int stoneSize) {
        this.stoneSize = stoneSize;
    }

    public List<Stick> getSticks() {
        return sticks;
    }

    public void setSticks(List<Stick> sticks) {
        this.sticks = sticks;
    }

    public StoneColor getCurrentPlayer() {
        return currentPlayer;
    }

    public StoneColor[][] getStones() {
        return stones;
    }

    public void setStones(StoneColor[][] stones) {
        this.stones = stones;
    }
}

