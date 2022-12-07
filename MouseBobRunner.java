import java.awt.*;
import javax.swing.*;

public class MouseBobRunner extends JFrame
{
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 1000;

	public MouseBobRunner()
	{
		super("MouseBob Runner");

		setSize(WIDTH,HEIGHT);
		
		
		MouseBob mb = new MouseBob( );
		getContentPane().add( new KeyBox() );
		add( mb );	
       	
       
		
		setVisible(true);	

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	}

	public static void main( String args[] )
	{
		MouseBobRunner run = new MouseBobRunner();
		KeyBoxRunner r = new KeyBoxRunner();
	}
}