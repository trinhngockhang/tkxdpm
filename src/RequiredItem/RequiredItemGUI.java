package RequiredItem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Database.Mariadb;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RequiredItemGUI extends JPanel {
	RequiredItemGUI that;
	/**
	 * Create the panel.
	 */
	public RequiredItemGUI() {
		that = this;
		init();
	}
	public void init() {
		setLayout(null);
		
		removeAll();
		revalidate();
		repaint();
		JPanel thisPanel = this;
		
		JButton btnTaoDs = new JButton("Tạo DS");
		btnTaoDs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thisPanel.removeAll();
				// Danh sach cac list don hang
				AddListItemGUI addItemGUI = new AddListItemGUI(that);
				thisPanel.add(addItemGUI);
				thisPanel.revalidate();
				thisPanel.repaint();
			}
		});
		btnTaoDs.setBounds(374, 158, 88, 29);
		add(btnTaoDs);
		
		// Move to view list
		JButton btnXemDs = new JButton("Xem DS");
		btnXemDs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thisPanel.removeAll();
				// Danh sach cac list don hang
				ListOfListRequiredItemGUI LLRI = new ListOfListRequiredItemGUI(that);
				thisPanel.add(LLRI);
				thisPanel.revalidate();
				thisPanel.repaint();
			}
		});
		
		btnXemDs.setBounds(374, 293, 92, 29);
		add(btnXemDs);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(392, 424, 61, 16);
		add(lblNewLabel);
		this.setBounds(6, 6, 859, 546);
	}
}
