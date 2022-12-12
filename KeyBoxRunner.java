import javax.swing.JFrame;

public class KeyBoxRunner extends JFrame
{
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 1000;

    public KeyBoxRunner()
    {
        super("Cat-tle Ship!!");

        setSize(WIDTH,HEIGHT);
        getContentPane().add((new MouseBob()));
        getContentPane().add( new KeyBox() );


        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main( String args[] )
    {
        KeyBoxRunner run = new KeyBoxRunner();
        //MouseBobRunner run2 = new MouseBobRunner();

    }
}