package RequiredItem;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class AddListItemGUI extends JPanel {

	/**
	 * Create the panel.
	 */
	public AddListItemGUI(RequiredItemGUI requiredItemGUI) {
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setBounds(6, 6, 859, 546);
		System.out.println("DIT ME ECLIPSE");
		JLabel lblAdadd = new JLabel("adadd");
		add(lblAdadd);
	}

}
