import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class GUI implements ActionListener{

    JFrame window = new JFrame("Jared mad bad");
    CardLayout cl = new CardLayout();
    JPanel startScreen = new JPanel(new GridLayout(2,1));
    JPanel gameScreen = new JPanel(new GridLayout(10,10));
    JPanel contPanel = new JPanel(cl);

    JLabel title = new JLabel();
    JButton startButton = new JButton("Start");

    ImageIcon titleImage = new ImageIcon("src/stratego.png");

    JLabel [][] boardLabels = new JLabel[10][10];

    Hole [] holeArray = new Hole[8];
    playerPiece [] playerPieceArray = new playerPiece[40];
    enemyPiece [] enemyPieceArray = new enemyPiece[40];

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
