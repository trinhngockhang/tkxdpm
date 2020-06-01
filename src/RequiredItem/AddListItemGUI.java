package RequiredItem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Models.RequiredItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddListItemGUI extends JPanel {
	AddListItemGUI that;
	RequiredItemGUI requiredItemGUI;
	ArrayList listItemArr;
	JTextField textFieldName ;
	RequiredItemController requiredItemController;
	/**
	 * Create the panel.
	 */
	public AddListItemGUI(RequiredItemGUI requiredItemGUI) {
		that = this;
		requiredItemController = new RequiredItemController();
		this.requiredItemGUI = requiredItemGUI;
		setLayout(new BorderLayout(0, 0));
		init();
		
	}
	void init() {
		this.setBounds(6, 6, 859, 546);
		listItemArr = new ArrayList();
		Panel btnPanel = new Panel();
		add(btnPanel, BorderLayout.SOUTH);
		
			JButton btnAddItem = new JButton("Add item");
			btnPanel.add(btnAddItem);
			
			JButton btnSave = new JButton("Save");
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String listName = textFieldName.getText();
					boolean check = requiredItemController.saveListItem(listName, listItemArr);
					if(check) {
						int input = JOptionPane.showOptionDialog(null, "Tao thành công", "Thông báo", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

						if(input == JOptionPane.OK_OPTION)
						{
							requiredItemGUI.init();
						}
					} else {
						int input = JOptionPane.showOptionDialog(null, "Tao không thành công", "Thông báo", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

						if(input == JOptionPane.OK_OPTION)
						{
							requiredItemGUI.init();
						}
					}
					
				}
			});
			btnPanel.add(btnSave);
			
			JButton btnBack = new JButton("Back");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					requiredItemGUI.init();
				}
			});
			btnPanel.add(btnBack);
			
			Panel nameListPanel = new Panel();
			add(nameListPanel, BorderLayout.NORTH);
			
			JLabel lblListName = new JLabel("Tên đơn hàng");
			nameListPanel.add(lblListName);
			
			// Ten don hang
			textFieldName = new JTextField();
			textFieldName.setColumns(12);
			nameListPanel.add(textFieldName);
			
			Panel listPanel = new Panel();
			add(listPanel, BorderLayout.CENTER);
			listPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
			
			// first item
			AddItemGUI addItemGUI = new AddItemGUI();
			listPanel.add(addItemGUI);
			listItemArr.add(addItemGUI);
			
			btnAddItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AddItemGUI addItemGUI = new AddItemGUI();
					listPanel.add(addItemGUI);
					listItemArr.add(addItemGUI);
					that.revalidate();
					that.repaint();
				}
			});
	}
}
