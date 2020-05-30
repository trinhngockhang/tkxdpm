package RequiredItem;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JTable;

import Models.RequiredItem;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListRequiredItemGUI extends JPanel {
	private int id;
	private JTable table;
	/**
	 * Create the panel.
	 */
	public ListRequiredItemGUI(int id, ListOfListRequiredItemGUI LLRI) {
		this.id = id;
		
		this.setBounds(6, 6, 859, 546);
		
		// Lay thong tin cua 1 don hang tren id
		RequiredItemController requiredItemController = new RequiredItemController();
		ArrayList itemArr = requiredItemController.getAllListItem(id);
		
		// Object luu data
		Object[][] data = new Object[itemArr.size()][6];
		
		// tao ds
		for (int counter = 0; counter < itemArr.size(); counter++) { 		      
			RequiredItem requiredItem = (RequiredItem) itemArr.get(counter);
			// Cac don hang can nhap
			data[counter][0] = requiredItem.getId(); 
			data[counter][1] = requiredItem.getName();
			data[counter][2] = requiredItem.getUnit();
			data[counter][3] = requiredItem.getDay();
			data[counter][4] = requiredItem.getMonth();
			data[counter][5] = requiredItem.getYear();
		} 
		
		String[] columnName = {"Id", "Tên sản phẩm", "Đơn vị", "Ngày", "Tháng", "Năm"};
 		setLayout(new BorderLayout(0, 0));
 		JTable table = new JTable(data, columnName);
		
		add(table.getTableHeader(), BorderLayout.PAGE_START);
		add(table, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LLRI.init();
			}
		});
		panel.add(btnBack);
		
	}

}
