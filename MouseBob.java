import javax.swing.*;
import java.awt.event.KeyListener;
import java.util.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener; /*You must import this in your mouseListener!*/
import java.awt.event.MouseMotionListener; 

public class MouseBob extends JPanel implements Runnable ,MouseListener, MouseMotionListener, KeyListener
{

	private int mouse_x, mouse_y; /*these will store the location of Mouse cursor, with respect to the window, not the screen */
	private String mouse_button; /*this will store which button is clicked*/
	
	//private ArrayList<Bob> bobs;/*This is where we are going to put the Bobs*/
	public KeyBox( )
	{
		key = "NO KEY PRESSED YET";

		keys_typed = "";

		addKeyListener( this ); /*all keyListeners must have this in the constructor*/

		setFocusable( true );
	}

	public MouseBob ()
	{
		setBackground(Color.WHITE);
		
		mouse_x = 0;
		mouse_y = 0;
		mouse_button = "NO BUTTON CLICKED!";
		//bobs = new ArrayList<Bob>();
		
		
		
		addMouseListener(this); /*YOU MUST have this in the constructor of a MouseListener*/
		addMouseMotionListener(this); /*YOU MUST have this in the constructor of a MouseMotionListener*/
		new Thread(this).start(); /*You have to start a new Thread in a Runnable */
	}


	public void paintComponent( Graphics window )
	{
		Graphics2D g2 = (Graphics2D) window;
		/*

		Image board = Toolkit.getDefaultToolkit().getImage("board.png");
		g2.drawImage(board, 0, 0, 1000, 1000, this);

		Image blackCat = Toolkit.getDefaultToolkit().getImage("blackCat.png");
		g2.drawImage(blackCat, 100, 0, 100, 400, this);

		Image greyCat = Toolkit.getDefaultToolkit().getImage("greyCat.png");
		g2.drawImage(greyCat, 400, 400, 100, 400, this);

		Image pinkCat = Toolkit.getDefaultToolkit().getImage("pinkCat.png");
		g2.drawImage(pinkCat, 700, 100, 100, 400, this);

		Image orangeCat = Toolkit.getDefaultToolkit().getImage("orangeCat.png");
		g2.drawImage(orangeCat, 1000, 200, 100, 400, this);

		Image fishMiss = Toolkit.getDefaultToolkit().getImage("fishMiss.png");
		g2.drawImage(fishMiss, 0, 0, 100, 100, this);

		Image fishHit = Toolkit.getDefaultToolkit().getImage("fishHit.png");
		g2.drawImage(fishHit, 100, 0, 100, 100, this);

`

		Image board = Toolkit.getDefaultToolkit().getImage("startscreen.png");
		g2.drawImage(board, 0, 0, 1000, 1000, this);
*/
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
		
		/*This makes a new Bob on the mouse cursor*/
		//Bob b = new Bob(mouse_x, mouse_y, 50, 50);
		/*This paints the bob on the mouse cursor*/
		//b.paintComponent(window);
		
		
	}
	
	/*You MUST have these 5 methods in a MouseListener */
		
		/*1 mousePressed -- when mouse button is pressed*/
		public void mousePressed(MouseEvent e) { }
		/*2 mouseReleased -- when mouse button is released*/
		public void mouseReleased(MouseEvent e) { }
		/*3 mouseEntered -- when the mouse enters the window */
		public void mouseEntered(MouseEvent e) { }
		/*4 mouseExited -- when the mouse exits the window*/
		public void mouseExited(MouseEvent e) { }
		/*5 mouseClicked -- when the mouse button is pressed and released*/
		public void mouseClicked(MouseEvent e) { 
			
			if( e.getButton() == 1) {
				mouse_button = "LEFT CLICK";
				/* add a Bob to the list at this location */
				
			}
			else if( e.getButton() == 3) {
				mouse_button = "RIGHT CLICK";
			}
			
			/*Write the code to remove the clicked on Bobs*/
				
		}
	
	/*You MUST have these 2 methods in a MouseMotionListener*/
		/*1 mouseDragged -- when a mouse button is pressed and held down and moved*/
		public void mouseDragged(MouseEvent e){  }
		/*2 mouseMoved -- when mouse cursor is moved around the window*/
		public void mouseMoved(MouseEvent e){  		
	    	mouse_x = e.getX(); /*this updates the X coordinate of the mouse*/
	    	mouse_y = e.getY(); /*this updates the Y coordinate of the mouse*/
	    }
	
	/*This method must be in a Runnable object*/
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