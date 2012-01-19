import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.event.*;

public class CardPreview implements ActionListener{
	private JDialog dialog;
	private ImageIcon icon;
	private Card card;

	private boolean isTriggered;
	private boolean isUseCard;


	public CardPreview(Card card){
		this.card = card;
	}

	public void prepareDialog(){
		icon = new ImageIcon( "../deck/" + getFileName() + ".jpg" );
		resizeIcon();
		createDialog();
	}

	private String getFileName(){
		String fileName = card.getFileName();

		if( card instanceof MonsterCard )
			return "monster/" + fileName;
		else if( card instanceof MagicCard )
			return "magic/" + fileName;
		else
			return "trap/" + fileName;
	}

	public void resizeIcon(){
		Image image = icon.getImage();
		int width = icon.getIconWidth();
		int height = icon.getIconHeight();

		image = image.getScaledInstance(width, height, Image.SCALE_FAST);
		icon = new ImageIcon( image );
	}


	private void createDialog(){
		JButton summon = new JButton(Field.SUMMON);
		JButton nope = new JButton(Field.NOPE);
		summon.addActionListener(this);
		nope.addActionListener(this);

		JPanel panel = new JPanel();
		panel.setLayout( new FlowLayout(FlowLayout.CENTER) );
		panel.add( summon );
		panel.add( nope );

		dialog = new JDialog(new JFrame(), "Are you going to summon this Monster?");
		dialog.setLayout( new BorderLayout() );
		dialog.add( new JButton(icon), BorderLayout.CENTER );
		dialog.add( panel, BorderLayout.SOUTH );
	}

	public void actionPerformed(ActionEvent event){
		if( event.getActionCommand().equals(Field.SUMMON) ){
			isUseCard = true;
		}else{
			isUseCard = false;
		}

		isTriggered = true;
	}

	public void launchDialog(){
		dialog.setSize(icon.getIconWidth()+50, icon.getIconHeight()+100);
		dialog.setVisible(true);
		//dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

	}

	public boolean isTriggered(){
		return isTriggered;
	}

	public boolean isUseCard(){
		return isUseCard;
	}
}