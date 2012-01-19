import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ImageDialog extends JFrame{
	Frame frame;
	
	public ImageDialog(){
		add( new JButton("test" ) );	
	}
	
	public void showDialog(){
  		JOptionPane pane = new JOptionPane();
  		pane.setIcon( new ImageIcon("../avatars/shinn.jpg") );
  		
  		JDialog dialog = pane.createDialog(this, "hello");
     	dialog.setVisible(true);
  		
	}
	
	public static void main(String args[]){
		ImageDialog id = new ImageDialog();
		id.showDialog();
		id.setSize(400, 400);
		id.setVisible(true);
	}
}