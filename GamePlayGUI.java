import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class GamePlayGUI extends JPanel{
	private JFrame frame;
	
	private Image image;
	
	public GamePlayGUI(){
	}
	
	public void setPhase(String phase){
		String fileName = "..images/labels/" + phase + ".png";
		
		image = new ImageIcon(fileName).getImage();
	}

	public void paintComponent(Graphics g){
		g.drawImage(image, 300, 200, this);
		g.setColor(Color.blue);
		g.drawString("hello", 0, 0);

		System.out.println("paintComponent() called");
		repaint();
	}
	
	public static void main(String a[]){
		//frame = new JFrame().add( new GamePlayGUI() );
		//frame.setVisible(true);
	}
}