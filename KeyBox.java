import javax.swing.*;
import java.awt.*; /*this must be imported to use Graphics */
import java.awt.event.*;/*must be imported to use KeyEvents */
import java.awt.event.KeyListener; /*must be imported in the KeyListener*/


// this is only to test if the keys are pressed.
public class KeyBox extends Canvas implements KeyListener,Runnable ,MouseListener, MouseMotionListener
{
    private String keys_typed;
    private String key;
    private int mouse_x, mouse_y;

    private String mouse_button;

    //this is the constructors

    public KeyBox( )
    {
        key = "NO KEY PRESSED YET";
        mouse_x = 0;
        mouse_y = 0;
        mouse_button = "NO BUTTON CLICKED!";
        keys_typed = "";

        addKeyListener( this ); /*all keyListeners must have this in the constructor*/
        addMouseListener(this); /*YOU MUST have this in the constructor of a MouseListener*/
        addMouseMotionListener(this); /*YOU MUST have this in the constructor of a MouseMotionListener*/
        new Thread(this).start(); /*You have to start a new Thread in a Runnable */
        setFocusable( true );
    }


    public void paint( Graphics window )
    {

        Graphics2D g2 = (Graphics2D) window;
        Image start = Toolkit.getDefaultToolkit().getImage("startscreen.png");
        g2.drawImage(start, 0, 0, 1000, 1000, this);


        //window.setColor(Color.red);
        window.drawString( "Please type something!", 250, 100 );

        if(keys_typed.length()!=0)
        {
            window.setColor(Color.black);
            window.fillRect(90, 130, keys_typed.length()*7 + 20, 30);
        }

        window.setColor(Color.green);
        window.drawString( keys_typed, 100, 150 );

        window.setColor(new Color( 100, 0, 100 ));
        window.drawString( key, 250, 200 );

        window.setColor(Color.WHITE);
        window.drawString("Mouse  coordinates " + "(" + MouseInfo.getPointerInfo().getLocation().x + "   " + MouseInfo.getPointerInfo().getLocation().y + ")", 250, 30 );

        window.setColor(Color.RED);
        window.drawString("Mouse  coordinates " + "(" + mouse_x + "   " + mouse_y + ")", 250, 50 );

        window.setColor(Color.green);
        window.drawString(mouse_button, 250, 70 );

    }

    /*KeyListeners must have these 3 methods:
     * You do not have to have code in any of these, they can be empty.
     * But they all must be in your KeyListener for it to work.
     */

    /*1 */
    public void keyTyped(KeyEvent e)
    {
        keys_typed += "" + e.getKeyChar();
        repaint();
    }

    /*2*/
    public void keyPressed(KeyEvent e)
    {
        /*KeyEvent key codes: https://docs.oracle.com/javase/7/docs/api/java/awt/event/KeyEvent.html */
        if(e.getKeyCode() == KeyEvent.VK_RIGHT ) {
            key = ">>>>>>";
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT ) {
            key = "<<<<<<";
        }
        //add another else if to check if another key was pressed..
        else {
            key = "Key " + e.getKeyCode() + " is pressed!";
        }
        repaint();
    }

    /*3*/
    public void keyReleased(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT ) {
            key = "The right arrow key was released!";
        }
        else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            JFrame jf3 = new JFrame();
            setVisible(false);
            jf3.setPreferredSize(new Dimension(1000, 1000));
            jf3.pack();
            jf3.setLocationRelativeTo(null);
            jf3.add(new JLabel(new ImageIcon("board.png")));
            jf3.show();

        }

        else if(e.getKeyCode() == KeyEvent.VK_I) {
            JFrame jf2 = new JFrame();
            setVisible(false);
            jf2.setPreferredSize(new Dimension(1000, 1000));
            jf2.pack();
            jf2.setLocationRelativeTo(null);
            jf2.add(new JLabel(new ImageIcon("instruct.png")));
            jf2.show();

        }
        //add another else if to check if another key was released..
        else{
            key = "Key "+ e.getKeyCode() +" was released!";
        }
        repaint();

    }



    @Override
    public void mouseClicked(MouseEvent e) {
        if( e.getButton() == 1) {
            mouse_button = "LEFT CLICK";
            /* add a Bob to the list at this location */

        }
        else if( e.getButton() == 3) {
            mouse_button = "RIGHT CLICK";
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

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e){
        mouse_x = e.getX(); /*this updates the X coordinate of the mouse*/
        mouse_y = e.getY(); /*this updates the Y coordinate of the mouse*/
    }

    @Override
    public void run()
    {

        try
        {
            while( true )
            {
                Thread.sleep(50);
                repaint();
            }
        }
        catch( Exception e )
        {

        }

    }
}