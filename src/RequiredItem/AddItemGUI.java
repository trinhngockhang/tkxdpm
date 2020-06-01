package RequiredItem;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Models.Item;
import Models.RequiredItem;

import javax.swing.JTextField;

public class AddItemGUI extends JPanel {
	private JTextField textUnit;
	private JComboBox cbItemName;
	private JTextField textNumber;
	private JTextField textDay;
	private JTextField textMonth;
	private JTextField textYear;
	String[] itemNameArr;
	int[] itemIdArr;
	
	private int id;
	private String unit;
	private int number;
	private int day;
	private int month;
	private int year;
	
	public int getId() {
		int index = cbItemName.getSelectedIndex();
		id = itemIdArr[index];
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUnit() {
		unit = textUnit.getText();
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getNumber() {
		number = Integer.parseInt(textNumber.getText());
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getDay() {
		day = Integer.parseInt(textDay.getText());
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		month = Integer.parseInt(textMonth.getText());
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		year = Integer.parseInt(textYear.getText());
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

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
		itemNameArr = new String[itemArr.size()];
		itemIdArr = new int[itemArr.size()];
		
		// attach to combobox
		for (int counter = 0; counter < itemArr.size(); counter++) { 		      
			Item item = (Item) itemArr.get(counter);
			itemNameArr[counter] = item.getName();
			itemIdArr[counter] = item.getId();
	    } 
		// comboBox id
		cbItemName = new JComboBox(itemNameArr);
		add(cbItemName);
		// Label Unit
		JLabel lblUnit = new JLabel(" Đơn vị");
		add(lblUnit);
		// Textfield Unit
		textUnit = new JTextField();
		add(textUnit);
		textUnit.setColumns(10);
		// Lable Number
		JLabel lblNumber = new JLabel("Số lượng");
		add(lblNumber);
		// TExtfield Number
		textNumber = new JTextField();
		add(textNumber);
		textNumber.setColumns(5);
		// label day
		JLabel lblDay = new JLabel("Ngày");
		add(lblDay);
		// textfield Day
		textDay = new JTextField();
		add(textDay);
		textDay.setColumns(5);
		// label month
		JLabel lblMonth = new JLabel("Tháng");
		add(lblMonth);
		// textField year
		textMonth = new JTextField();
		add(textMonth);
		textMonth.setColumns(5);
		
		JLabel lblYear = new JLabel("Năm");
		add(lblYear);
		
		textYear = new JTextField();
		add(textYear);
		textYear.setColumns(5);
	}

}
