import java.awt.*;
import javax.swing.*;
public class images extends JPanel{
    public void paintComponent(Graphics window){
        Graphics2D g2 = (Graphics2D) window;

        Image board = Toolkit.getDefaultToolkit().getImage("board.png");
        g2.drawImage(board, 0, 0, 1440, 1440, this);

        Image blackCat = Toolkit.getDefaultToolkit().getImage("blackCat.png");
        g2.drawImage(blackCat, 144, 0, 144, 432, this);

        Image greyCat = Toolkit.getDefaultToolkit().getImage("greyCat.png");
        g2.drawImage(greyCat, 432, 432, 144, 432, this);

        Image pinkCat = Toolkit.getDefaultToolkit().getImage("pinkCat.png");
        g2.drawImage(pinkCat, 720, 144, 144, 432, this);

        Image orangeCat = Toolkit.getDefaultToolkit().getImage("orangeCat.png");
        g2.drawImage(orangeCat, 1008, 288, 144, 432, this);

        Image fishMiss = Toolkit.getDefaultToolkit().getImage("fishMiss.png");
        g2.drawImage(fishMiss, 0, 0, 144, 144, this);

        Image fishHit = Toolkit.getDefaultToolkit().getImage("fishHit.png");
        g2.drawImage(fishHit, 144, 0, 144, 144, this);
    }
}