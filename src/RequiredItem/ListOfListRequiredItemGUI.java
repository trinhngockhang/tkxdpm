package RequiredItem;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Models.ListRequiredItem;

import java.util.ArrayList;

import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Scrollbar;
import java.awt.ScrollPane;
import java.awt.Panel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListOfListRequiredItemGUI extends JPanel {
	ListOfListRequiredItemController LLIC;
	RequiredItemGUI requiredItemGUI;
	/**
	 * Create the panel.
	 */
	public ListOfListRequiredItemGUI(RequiredItemGUI requiredItemGUI) {
		this.requiredItemGUI = requiredItemGUI;
		init();
		
	}
	public void init() {
		this.setBounds(6, 6, 859, 546);
		removeAll();
		revalidate();
		repaint();
		setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
	
		// this.setAutoscrolls(true);
		
		LLIC = new ListOfListRequiredItemController();
		// get list
		ArrayList listArr = LLIC.getAllListOfList();
		
		// tao ds
		for (int counter = 0; counter < listArr.size(); counter++) { 		      
			ListRequiredItem LRI = (ListRequiredItem) listArr.get(counter);
			// Cac don hang can nhap
			JListOfList JList = new JListOfList(this, LRI.getId(), LRI.getName(), this);
			add(JList);
	    } 
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				requiredItemGUI.init();
			}
		});
		add(btnBack);
	}

}
