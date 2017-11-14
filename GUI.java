import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI implements ActionListener{

    JFrame window = new JFrame("Jared mad bad");
    CardLayout cl = new CardLayout();
    JPanel startScreen = new JPanel(new GridLayout(2,1));
    JPanel gameScreen = new JPanel(new GridLayout(10,10));
    JPanel contPanel = new JPanel(cl);

    JLabel title = new JLabel();
    JButton startButton = new JButton("Start");

    ImageIcon titleImage = new ImageIcon("src/src/stratego.png");

    JLabel [][] boardLabels = new JLabel[10][10];

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
                boardLabels[i][j] = new JLabel();
                boardLabels[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                gameScreen.add(boardLabels[i][j]);
            }
        }

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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            cl.show(contPanel, "game");
        }
    }
}
