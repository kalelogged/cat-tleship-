import java.awt.*;
import javax.swing.ImageIcon;
public class catShips {
    private Image catPic;
    private boolean isCatKilled;
    boolean isPlayer1;

    public catShips(boolean isPlayer){
        isPlayer1 = isPlayer;

        if (isPlayer1)
            catPic = new ImageIcon("100200cat.png").getImage();
        else
            catPic = new ImageIcon("100300cat.png").getImage();
        isCatKilled = false;

    }
    public void setShipImage(String file) {
        catPic = new ImageIcon(file).getImage();

    }

    public Image getShipImage() {
        return catPic;
    }
    public void destroy() {
        isPlayer1 = true;
        if (isPlayer1) {
            setShipImage("fishHit.png");
        } else {
            setShipImage("fishMiss.png");
        }
    }


    public boolean isDestroy() {
        return isCatKilled;
    }
}
