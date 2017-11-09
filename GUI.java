import java.awt.*;
import javax.swing.*;

public class GUI {

    JFrame window = new JFrame("Noah's Laptop Gaeey");
    CardLayout cl = new CardLayout();
    JPanel startScreen = new JPanel(new BorderLayout());
    JPanel gameScreen = new JPanel();
    JPanel contPanel = new JPanel(cl);

    JLabel title = new JLabel();
    JButton startButton = new JButton("Start");

    ImageIcon titleImage = new ImageIcon("Desktop//Kids Camp Week 3 Camp Photo//stratego.png");

    public GUI(){
        Font();
        window.add(contPanel);
        window.setVisible(true);
        window.setSize(500,500);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        contPanel.add(startScreen, "S1");
        contPanel.add(gameScreen, "S2");

        startScreen.add(title, BorderLayout.NORTH);
        startScreen.add(startButton, BorderLayout.SOUTH);

        cl.show(contPanel,"S1");
    }
    public void Font(){
        title.setForeground(Color.RED);
        title.setFont(new Font("Serif", Font.PLAIN, 36));
        title.setBackground(Color.GRAY);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setIcon(titleImage);
        startButton.setForeground(Color.CYAN);
        startButton.setFont(new Font("Serif", Font.PLAIN, 36));
        startButton.setBackground(Color.GRAY);
    }

}
