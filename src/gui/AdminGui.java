package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminGui {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminGui window = new AdminGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 820, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAdminLogin = new JLabel("Admin Login");
		lblAdminLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAdminLogin.setBounds(344, 22, 110, 36);
		frame.getContentPane().add(lblAdminLogin);
		
		JLabel lblUser = new JLabel("Email:");
		lblUser.setHorizontalAlignment(SwingConstants.TRAILING);
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUser.setBounds(119, 133, 81, 36);
		frame.getContentPane().add(lblUser);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(119, 200, 81, 36);
		frame.getContentPane().add(lblPassword);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainGui.main(null);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(23, 443, 102, 36);
		frame.getContentPane().add(btnBack);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(280, 139, 396, 30);
		frame.getContentPane().add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(280, 200, 396, 30);
		frame.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("admin") && passwordField.getText().equals("admin")) {
					frame.dispose();
					AdminLoggedInGui.main(null);
				}
				else {
					JOptionPane.showMessageDialog(null, "Login info incorrect. You don't belong here!", "Login Error!",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogin.setBounds(322, 285, 152, 72);
		frame.getContentPane().add(btnLogin);
	}

}
