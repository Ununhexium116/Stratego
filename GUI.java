import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class GUI implements ActionListener, MouseListener {
    int count;
    private JFrame window = new JFrame("Noah's mom gay");
    private JFrame devWindow = new JFrame("Noah's dad gay");

    private CardLayout cl = new CardLayout();
    private CardLayout cl2 = new CardLayout();

    private JPanel startScreen = new JPanel(new GridLayout(2,1));
    private JPanel gameScreen = new JPanel(new GridLayout(10,10));
    private JPanel contPanel = new JPanel(cl);
    private JPanel devContPanel = new JPanel(cl2);
    private JPanel devPanel = new JPanel();

    private JLabel title = new JLabel();
    private JLabel[][] boardLabels = new JLabel[10][10];

    private JButton startButton = new JButton("Start");
    private JButton testButton = new JButton("Test");

    private ImageIcon titleImage = new ImageIcon("src/stratego.png");

    private Hole[] holeArray = new Hole[8];
    private playerPiece[] playerPieceArray = new playerPiece[40];
    private enemyPiece[] enemyPieceArray = new enemyPiece[40];

    private boolean finalPlaces = false;
    private boolean switchImminent = false;

    public GUI(){
        Font();
        window.add(contPanel);
        window.setVisible(true);
        window.setSize(1000,1000);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        devWindow.setVisible(true);
        devWindow.setSize(750, 1000);
        devWindow.setLocation(990,0);
        devWindow.add(devContPanel);

        startButton.addActionListener(this);

        contPanel.add(startScreen, "start");
        contPanel.add(gameScreen, "game");
        devContPanel.add(devPanel, "D1");
        cl2.show(devContPanel, "D1");
        devPanel.add(testButton);

        startScreen.add(title, BorderLayout.NORTH);
        startScreen.add(startButton, BorderLayout.SOUTH);

        gameScreen.setPreferredSize(new Dimension(1000,1000));

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                boardLabels[j][i] = new JLabel();
                boardLabels[j][i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                boardLabels[j][i].setOpaque(true);
                boardLabels[j][i].addMouseListener(this);
                gameScreen.add(boardLabels[j][i]);
            }
        }

        // Create "Pits" on board
        boardLabels[2][4].setBackground(Color.BLACK);
        holeArray[0] = new Hole(2, 4, 15, "hole");
        boardLabels[2][5].setBackground(Color.BLACK);
        holeArray[0] = new Hole(2, 5, 15, "hole");
        boardLabels[3][4].setBackground(Color.BLACK);
        holeArray[0] = new Hole(3, 4, 15, "hole");
        boardLabels[3][5].setBackground(Color.BLACK);
        holeArray[0] = new Hole(3, 5, 15, "hole");

        boardLabels[6][4].setBackground(Color.BLACK);
        holeArray[0] = new Hole(6, 4, 15, "hole");
        boardLabels[6][5].setBackground(Color.BLACK);
        holeArray[0] = new Hole(6, 5, 15, "hole");
        boardLabels[7][4].setBackground(Color.BLACK);
        holeArray[0] = new Hole(7, 4, 15, "hole");
        boardLabels[7][5].setBackground(Color.BLACK);
        holeArray[0] = new Hole(7, 5, 15, "hole");

        cl.show(contPanel,"start");

        // Add player and enemy pieces
        // Spies
        placePlayerPiece(0, 1, "Spy");
        placeEnemyPiece(0, 1, "Spy");

        // Scouts
        for (int i = 0; i < 8; i++) {
            placePlayerPiece(i+1, 2, "Scout");
            placeEnemyPiece(i+1, 2, "Scout");
        }

        // Miners
        for (int i = 0; i < 5; i++) {
            placePlayerPiece(i+9, 3, "Miner");
            placeEnemyPiece(i+9, 3, "Miner");
        }

        // Archers
        for (int i = 0; i < 4; i++) {
            placePlayerPiece(i+14, 4, "Archer");
            placeEnemyPiece(i+14, 4, "Archer");
        }

        // Lava Beasts
        for (int i = 0; i < 4; i++) {
            placePlayerPiece(i+18, 5, "Thicc Yeti");
            placeEnemyPiece(i+18, 5, "Lava Beast");
        }

        // Sorcerers
        for (int i = 0; i < 4; i++) {
            placePlayerPiece(i+22, 6, "Sorcerer");
            placeEnemyPiece(i+22, 6, "Sorcerer");
        }

        // Beast Riders
        for (int i = 0; i < 3; i++) {
            placePlayerPiece(i+26, 7, "Beast Rider");
            placeEnemyPiece(i+26, 7, "Beast Rider");
        }

        // Knights
        for (int i = 0; i < 2; i++) {
            placePlayerPiece(i+29, 8, "Knight");
            placeEnemyPiece(i+29, 8, "Knight");
        }

        // Mages
        placePlayerPiece(31, 9, "Mage");
        placeEnemyPiece(31, 9, "Mage");

        // Dragons
        placePlayerPiece(32, 10, "Dragon");
        placeEnemyPiece(32, 10, "Dragon");

        // Bombs
        for (int i = 0; i < 6; i++) {
            placePlayerPiece(i+33, 11, "Bomb");
            placeEnemyPiece(i+33, 11, "Bomb");
        }

        // Flags
        placePlayerPiece(39, 0, "Flag");
        placeEnemyPiece(39, 0, "Flag");

        System.out.println(playerPieceArray.length);

        for (int i = 0; i < playerPieceArray.length; i++) {
            boardLabels[playerPieceArray[i].getX()][playerPieceArray[i].getY()].setText(Integer.toString(playerPieceArray[i].getStrength()));
            boardLabels[playerPieceArray[i].getX()][playerPieceArray[i].getY()].setHorizontalAlignment(SwingConstants.CENTER);
            boardLabels[playerPieceArray[i].getX()][playerPieceArray[i].getY()].setFont(new Font("serif", Font.ITALIC, 36));
            boardLabels[playerPieceArray[i].getX()][playerPieceArray[i].getY()].setForeground(Color.WHITE);
            boardLabels[playerPieceArray[i].getX()][playerPieceArray[i].getY()].setBackground(Color.BLUE);
        }

        for (int i = 0; i < enemyPieceArray.length; i++) {
            boardLabels[enemyPieceArray[i].getX()][enemyPieceArray[i].getY()].setText(Integer.toString(enemyPieceArray[i].getStrength()));
            boardLabels[enemyPieceArray[i].getX()][enemyPieceArray[i].getY()].setHorizontalAlignment(SwingConstants.CENTER);
            boardLabels[enemyPieceArray[i].getX()][enemyPieceArray[i].getY()].setFont(new Font("serif", Font.PLAIN, 36));
            boardLabels[enemyPieceArray[i].getX()][enemyPieceArray[i].getY()].setForeground(Color.WHITE);
            boardLabels[enemyPieceArray[i].getX()][enemyPieceArray[i].getY()].setBackground(Color.RED);
        }
        for(int i = 0; i<10; i++){
            for(int j = 0; j<10; j++){
                switch (boardLabels[i][j].getText()){
                    case "0": boardLabels[i][j].setText("Flag"); break;
                    case "11": boardLabels[i][j].setText("Bomb"); break;
                    case "1": boardLabels[i][j].setText("Spy"); break;
                }
            }
        }
    }
    
    private void placePlayerPiece(int arrayLocation, int strength, String type) {
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
            playerPieceArray[arrayLocation] = new playerPiece(X, Y, strength, type);
        } else {
            placePlayerPiece(arrayLocation, strength, type);
        }
    }

    private void placeEnemyPiece(int arrayLocation, int strength, String type) {
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
            enemyPieceArray[arrayLocation] = new enemyPiece(X, Y, strength, "Enemy");
        } else {
            placeEnemyPiece(arrayLocation, strength, type);
        }
    }

    private void switchPieces(Piece piece, int i, int j, MouseEvent e) {
        int x;
        int y;
        int x2;
        int y2;
        if(e.getSource() == boardLabels[i][j] && count == 0){
            boardLabels[i][j].setBackground(Color.GREEN);
            x = i;
            y = j;
            count = 1;
        }
        if(e.getSource() ==  boardLabels[i][j] && count == 1){
            boardLabels[i][j].setBackground(Color.GREEN);
            x2 = i;
            y2 = j;
            count = 0;
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

    @Override
    public void mouseClicked(MouseEvent e) {
        if(!finalPlaces) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (e.getSource() == boardLabels[i][j] && !switchImminent) {
                        boardLabels[i][j].setBackground(Color.lightGray);
                        switchImminent = true;
                    }
                    if(e.getSource() == boardLabels[i][j] && switchImminent){

                        switchImminent = false;
                    }
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
