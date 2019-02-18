import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class GameGUI extends JDialog{	
	private ImageIcon icon;
	private Image image;
	
	public GameGUI(String phase){
		String fileName = "../images/labels/" + phase + ".png";
		icon = new ImageIcon(fileName);
		image = icon.getImage();
		
	}
	
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.BLUE);
		g.drawImage(image, 100, 100, this);		
		
		System.out.println("called paint()");
	}
}