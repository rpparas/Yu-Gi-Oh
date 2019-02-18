import java.awt.*;
import javax.swing.*;

public class LoadDraw extends JFrame{
	Image image;
	Insets insets;
	
	public LoadDraw(String fileName){
		super(fileName);
		image = getToolkit().getImage(fileName);
	}
	
	public void paint(Graphics g){
		super.paint(g);
		if(insets == null){
			insets = getInsets();
		}
		g.drawImage(image, insets.left, insets.top, this);
		System.out.println("sulod diri");
	}
	
	public static void main(String a[]){
		Frame f = new LoadDraw("../images/labels/drawPhase.png");
		f.setSize(300, 275);
		f.setVisible(true);
		f.setVisible(false);
	}
}