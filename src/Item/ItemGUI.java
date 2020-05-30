package Item;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ItemGUI extends JPanel {

	/**
	 * Create the panel.
	 */
	public ItemGUI() {
		setLayout(null);
		
		JButton btnToDs = new JButton("Tạo DS");
		btnToDs.setBounds(385, 283, 88, 29);
		add(btnToDs);
		
		JButton btnXemDs = new JButton("Xem DS");
		btnXemDs.setBounds(381, 169, 92, 29);
		add(btnXemDs);
		
		JLabel lblNewLabel = new JLabel("Nhan vien quan ly");
		lblNewLabel.setBounds(375, 80, 113, 16);
		add(lblNewLabel);
		this.setBounds(6, 6, 859, 546);
	}

}
