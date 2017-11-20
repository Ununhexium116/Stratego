import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class GUI implements ActionListener{

    private JFrame window = new JFrame("Jared mad bad");
    private CardLayout cl = new CardLayout();
    private JPanel startScreen = new JPanel(new GridLayout(2,1));
    private JPanel gameScreen = new JPanel(new GridLayout(10,10));
    private JPanel contPanel = new JPanel(cl);

    private JLabel title = new JLabel();
    private JButton startButton = new JButton("Start");

    private ImageIcon titleImage = new ImageIcon("src/stratego.png");

    private JLabel[][] boardLabels = new JLabel[10][10];

    private Hole[] holeArray = new Hole[8];
    private playerPiece[] playerPieceArray = new playerPiece[40];
    private enemyPiece[] enemyPieceArray = new enemyPiece[40];

    public GUI(){
        Font();
        window.add(contPanel);
        window.setVisible(true);
        window.setSize(1000,500);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        startButton.addActionListener(this);

        contPanel.add(startScreen, "start");
        contPanel.add(gameScreen, "game");

        startScreen.add(title, BorderLayout.NORTH);
        startScreen.add(startButton, BorderLayout.SOUTH);

        gameScreen.setPreferredSize(new Dimension(1000,1000));

        for(int i = 0; i<10; i++){
            for(int j=0; j<10; j++){
                boardLabels[j][i] = new JLabel();
                boardLabels[j][i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                boardLabels[j][i].setOpaque(true);
                gameScreen.add(boardLabels[j][i]);
            }
        }

        // Create "Pits" on board
        boardLabels[2][4].setBackground(Color.BLACK);
        holeArray[0] = new Hole(2, 4, 15);
        boardLabels[2][5].setBackground(Color.BLACK);
        holeArray[0] = new Hole(2, 5, 15);
        boardLabels[3][4].setBackground(Color.BLACK);
        holeArray[0] = new Hole(3, 4, 15);
        boardLabels[3][5].setBackground(Color.BLACK);
        holeArray[0] = new Hole(3, 5, 15);

        boardLabels[6][4].setBackground(Color.BLACK);
        holeArray[0] = new Hole(6, 4, 15);
        boardLabels[6][5].setBackground(Color.BLACK);
        holeArray[0] = new Hole(6, 5, 15);
        boardLabels[7][4].setBackground(Color.BLACK);
        holeArray[0] = new Hole(7, 4, 15);
        boardLabels[7][5].setBackground(Color.BLACK);
        holeArray[0] = new Hole(7, 5, 15);

        cl.show(contPanel,"start");

        // Add player and enemy pieces
        // Spies
        placePlayerPiece(0, 1);
        placeEnemyPiece(0, 1);

        // Scouts
        for (int i = 0; i < 8; i++) {
            placePlayerPiece(i+1, 2);
            placeEnemyPiece(i+1, 2);
        }

        // Miners
        for (int i = 0; i < 5; i++) {
            placePlayerPiece(i+9, 3);
            placeEnemyPiece(i+9, 3);
        }

        // Archers
        for (int i = 0; i < 4; i++) {
            placePlayerPiece(i+14, 4);
            placeEnemyPiece(i+14, 4);
        }

        // Lava Beasts
        for (int i = 0; i < 4; i++) {
            placePlayerPiece(i+18, 5);
            placeEnemyPiece(i+18, 5);
        }

        // Sorcerers
        for (int i = 0; i < 4; i++) {
            placePlayerPiece(i+22, 6);
            placeEnemyPiece(i+22, 6);
        }

        // Beast Riders
        for (int i = 0; i < 3; i++) {
            placePlayerPiece(i+26, 7);
            placeEnemyPiece(i+26, 7);
        }

        // Knights
        for (int i = 0; i < 2; i++) {
            placePlayerPiece(i+29, 8);
            placeEnemyPiece(i+29, 8);
        }

        // Mages
        placePlayerPiece(31, 9);
        placeEnemyPiece(31, 9);

        // Dragons
        placePlayerPiece(32, 10);
        placeEnemyPiece(32, 10);

        // Bombs
        for (int i = 0; i < 6; i++) {
            placePlayerPiece(i+33, 11);
            placeEnemyPiece(i+33, 11);
        }

        // Flags
        placePlayerPiece(39, 0);
        placeEnemyPiece(39, 0);

        System.out.println(playerPieceArray.length);

        for (int i = 0; i < playerPieceArray.length; i++) {
            boardLabels[playerPieceArray[i].getX()][playerPieceArray[i].getY()].setText(Integer.toString(playerPieceArray[i].getStrength()));
        }

        for (int i = 0; i < enemyPieceArray.length; i++) {
            boardLabels[enemyPieceArray[i].getX()][enemyPieceArray[i].getY()].setText(Integer.toString(enemyPieceArray[i].getStrength()));
        }
    }
    
    private void placePlayerPiece(int arrayLocation, int strength) {
        boolean canPlace = true;
        int X = randomInt(0, 9);
        int Y = randomInt(6, 9);
        // Check to see if another piece exists at the current position
        for (int i = 0; i < playerPieceArray.length; i++) {
            if (playerPieceArray[i] != null) {
                if (X == playerPieceArray[i].getX() && Y == playerPieceArray[i].getY()) {
                    canPlace = false;
                }
            }
        }
        if (canPlace) {
            playerPieceArray[arrayLocation] = new playerPiece(X, Y, strength);
        } else {
            placePlayerPiece(arrayLocation, strength);
        }
    }

    private void placeEnemyPiece(int arrayLocation, int strength) {
        boolean canPlace = true;
        int X = randomInt(0, 9);
        int Y = randomInt(0, 3);
        // Check to see if another piece exists at the current position
        for (int i = 0; i < enemyPieceArray.length; i++) {
            if (enemyPieceArray[i] != null) {
                if (X == enemyPieceArray[i].getX() && Y == enemyPieceArray[i].getY()) {
                    canPlace = false;
                }
            }
        }
        if (canPlace) {
            enemyPieceArray[arrayLocation] = new enemyPiece(X, Y, strength);
        } else {
            placeEnemyPiece(arrayLocation, strength);
        }
    }

    public void Font(){
        title.setForeground(Color.RED);
        title.setFont(new Font("Helvetica", Font.PLAIN, 36));
        title.setBackground(Color.GRAY);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setIcon(titleImage);
        startButton.setForeground(Color.CYAN);
        startButton.setFont(new Font("Helvetica", Font.PLAIN, 36));
        startButton.setBackground(Color.GRAY);
    }

    private int randomInt(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            cl.show(contPanel, "game");
            gameScreen.updateUI();
        }
    }
}
