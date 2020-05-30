package RequiredItem;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.FlowLayout;

public class RequiredItemInfoGUI extends JPanel {
	private int id;
	private String unit;
	private int number;
	private int day;
	private int month;
	private int year;
	
	public RequiredItemInfoGUI(int id, String unit, int day, int month, int year) {
		this.id = id;
		this.unit = unit;
		this.day = day;
		this.month = month;
		this.year = year;
		
		this.setBounds(6, 6, 859, 85);
		setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblNewLabel = new JLabel("New label");
		add(lblNewLabel);
	}
}
