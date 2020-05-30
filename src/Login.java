import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Item.ItemGUI;
import RequiredItem.RequiredItemGUI;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

public class Login extends JPanel {
	private JTextField usernameInput;
	private JTextField passwordInput;

	/**
	 * Create the panel.
	 */
	public Login(application app) {
		setForeground(Color.GREEN);
		setLayout(null);
		
		passwordInput = new JTextField();
		passwordInput.setBounds(187, 149, 130, 26);
		add(passwordInput);
		passwordInput.setColumns(10);
		
		usernameInput = new JTextField();
		usernameInput.setBounds(187, 84, 130, 26);
		add(usernameInput);
		usernameInput.setColumns(10);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(85, 89, 90, 16);
		add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(85, 154, 61, 16);
		add(passwordLabel);
		
		JLabel wrongpassText = new JLabel("Mật khẩu sai");
		wrongpassText.setForeground(Color.RED);
		wrongpassText.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		wrongpassText.setBounds(169, 187, 80, 16);
		wrongpassText.setVisible(false);
		add(wrongpassText);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameInput.getText();
				String password = passwordInput.getText();
				
				if(password.equals("123456")) {
					RequiredItemGUI requiredItemGUI = new RequiredItemGUI();
					app.getFrame().getContentPane().removeAll();
					app.getFrame().repaint();
					if(username.equals("nvbh")) {
						System.out.println("Nhan vien ban hang dang nhap");
					    app.getFrame().getContentPane().add(requiredItemGUI);
					}
					if(username.equals("nvql")) {
						System.out.println("Nhan vien quan ly dang nhap");
						ItemGUI itemGUI = new ItemGUI();
					    app.getFrame().getContentPane().add(itemGUI);
					}
				} else {
					wrongpassText.setVisible(true);
				}
			}
		});
		btnLogin.setBounds(144, 213, 117, 29);
		add(btnLogin);
	}
}
