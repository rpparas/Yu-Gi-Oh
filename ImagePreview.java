import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;


//@SuppressWarnings("unchecked")
public class ImagePreview implements ListSelectionListener{
    private Vector cardNames;
    private JLabel picture;
    private JSplitPane splitPane;
    private JScrollPane listScrollPane;


    public ImagePreview(String cardNamesString, String[] list){
		ImageIcon firstImage;
		JScrollPane pictureScrollPane;
		Dimension minimumSize;

        cardNames = parseList(cardNamesString);

		// create list of player's cards
		createListBox(list);

        //Set up the picture label and put it in a scroll pane
        firstImage = new ImageIcon( "../deck/" + (String)cardNames.firstElement() );
        picture = new JLabel(firstImage);
        picture.setPreferredSize(new Dimension( firstImage.getIconWidth(),
        										firstImage.getIconHeight()) );
        pictureScrollPane = new JScrollPane(picture);

        //Create a split pane with the two scroll panes in it
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                                   listScrollPane, pictureScrollPane);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(280);

        //Provide a preferred size for the split pane
        splitPane.setPreferredSize(new Dimension(280, 520));
    }


    private void createListBox(String[] list){
		JList listBox;

		listBox = new JList(list);
		listBox.setFixedCellWidth(260);
		listBox.addListSelectionListener(this);
		listBox.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		listScrollPane = new JScrollPane(listBox,
							ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
							ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	}


    public void valueChanged(ListSelectionEvent e) {
        JList newList;
        ImageIcon newImage;

        if (e.getValueIsAdjusting())
            return;

        newList = (JList)e.getSource();

        if (newList.isSelectionEmpty())
            picture.setIcon(null);

        else{
            int index = newList.getSelectedIndex();
            newImage = new ImageIcon( "../deck/" + (String)cardNames.elementAt(index) );
            picture.setIcon(newImage);
            picture.setPreferredSize(new Dimension(newImage.getIconWidth(),
                                               newImage.getIconHeight() ));
            picture.revalidate();
		}
	}

	protected static Vector parseList(String fileNames) {
		Vector v = new Vector(50);
		StringTokenizer tokenizer = new StringTokenizer(fileNames, " ");

		while (tokenizer.hasMoreTokens()) {
			String image = tokenizer.nextToken();
			v.addElement(image);
		}

		return v;
   }

    public JSplitPane getSplitPane() {
		return splitPane;
	}
}