package RequiredItem;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Panel;

public class JListOfList extends JPanel {
	private String name;
	private int id;
	JPanel mainPanel;
	ListOfListRequiredItemGUI LLRI;
	JListOfList that;
	/**
	 * Create the panel.
	 */
	public JListOfList(JPanel mainPanel, int id, String name, ListOfListRequiredItemGUI LLRI) {
		this.name = name;
		that = this;
		this.LLRI = LLRI;
		this.mainPanel = mainPanel;
		this.id = id;
		init();
	}
	public void init() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(panel, BorderLayout.EAST);
		
		JButton btnViewList = new JButton("Xem");
		btnViewList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListRequiredItemGUI LRIG = new ListRequiredItemGUI(id, LLRI);
				mainPanel.removeAll();
				mainPanel.add(LRIG);
				mainPanel.revalidate();
				mainPanel.repaint();
			}
		});
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.add(btnViewList);
		
		JButton btnEditList = new JButton("Sửa");
		panel.add(btnEditList);
		
		JButton btnDelete = new JButton("Xoá");
		panel.add(btnDelete);
		
		Panel namePanel = new Panel();
		add(namePanel, BorderLayout.WEST);
		JLabel lbName = new JLabel("New label");
		namePanel.add(lbName);
		lbName.setHorizontalAlignment(SwingConstants.LEFT);
		lbName.setVerticalAlignment(SwingConstants.TOP);
		lbName.setText(name);
	}
}