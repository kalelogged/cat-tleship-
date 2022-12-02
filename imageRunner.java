import java.awt.*;
import javax.swing.*;

public class imageRunner extends JFrame
{
    private static final int WIDTH = 1440;
    private static final int HEIGHT = 1440;

    public imageRunner()
    {
        super("MouseBob Runner");

        setSize(WIDTH,HEIGHT);


        add( new images() );


        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main( String args[] )
    {
        imageRunner run = new imageRunner();
    }
}