package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import logical.Customer;
import logical.ParkingEnforcer;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ParkEGui {

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
					ParkEGui window = new ParkEGui();
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
	public ParkEGui() {
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
		
		JLabel lblOfficerLogin = new JLabel("Officer Login");
		lblOfficerLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblOfficerLogin.setBounds(51, 24, 142, 36);
		frame.getContentPane().add(lblOfficerLogin);
		
		JLabel lblUser = new JLabel("Email:");
		lblUser.setHorizontalAlignment(SwingConstants.TRAILING);
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUser.setBounds(21, 143, 81, 36);
		frame.getContentPane().add(lblUser);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(21, 194, 81, 36);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(123, 149, 219, 30);
		frame.getContentPane().add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(123, 200, 219, 30);
		frame.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals(null) || textField.getText().trim().equals("")||passwordField.getText().equals(null) || passwordField.getText().trim().equals(""))
					JOptionPane.showMessageDialog(null, "Please enter a valid e-mail and password.", "Login Error!",JOptionPane.ERROR_MESSAGE);
				else {
					try {
						if(ParkingEnforcer.parkELogin(textField.getText(), passwordField.getText())) {
							frame.dispose();
			                ParkELoggedInGui.main(null);
						}
						else {
							JOptionPane.showMessageDialog(null, "Login info incorrect.", "Login Error!",JOptionPane.ERROR_MESSAGE);
						}
					}
					catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "File not found!", "Internal Error!",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogin.setBounds(123, 273, 102, 36);
		frame.getContentPane().add(btnLogin);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainGui.main(null);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(21, 446, 102, 36);
		frame.getContentPane().add(btnBack);
	}
}
