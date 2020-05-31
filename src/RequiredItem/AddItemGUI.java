package RequiredItem;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Models.Item;

public class AddItemGUI extends JPanel {
	/**
	 * Create the panel.
	 */
	public AddItemGUI() {
		RequiredItemController itemController = new RequiredItemController();
		this.setBounds(6, 6, 859, 97);
		setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblItemName = new JLabel("Item");
		add(lblItemName);
		
		// add data to combobox
		// get from database
		ArrayList itemArr = itemController.getAllItem();
		
		// save into Arr
		String[] itemNameArr = new String[itemArr.size()];
		int[] itemIdArr = new int[itemArr.size()];
		
		// attach to combobox
		for (int counter = 0; counter < itemArr.size(); counter++) { 		      
			Item item = (Item) itemArr.get(counter);
			itemNameArr[counter] = item.getName();
			itemIdArr[counter] = item.getId();
	    } 
		
		JComboBox cbItemName = new JComboBox(itemNameArr);
		add(cbItemName);
	}

}
