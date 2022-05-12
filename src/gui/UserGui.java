package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import logical.Customer;

import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class UserGui {

	private JFrame frame;
	private JTextField textEmail;
	private JPasswordField passwordField;
	private JTextField textEmailreg;
	private JPasswordField passwordFieldreg;
	private JTextField textFirst;
	private JTextField textLast;
	protected static String cusemail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserGui window = new UserGui();
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
	public UserGui() {
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
		
		JLabel lblLoginLabel = new JLabel("Login");
		lblLoginLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLoginLabel.setBounds(53, 21, 110, 36);
		frame.getContentPane().add(lblLoginLabel);
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRegister.setBounds(449, 21, 110, 36);
		frame.getContentPane().add(lblRegister);
		
		JLabel lblUser = new JLabel("Email:");
		lblUser.setHorizontalAlignment(SwingConstants.TRAILING);
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUser.setBounds(23, 140, 81, 36);
		frame.getContentPane().add(lblUser);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(23, 191, 81, 36);
		frame.getContentPane().add(lblPassword);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textEmail.setBounds(125, 146, 219, 30);
		frame.getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(125, 197, 219, 30);
		frame.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textEmail.getText().equals(null) || textEmail.getText().trim().equals("")||passwordField.getText().equals(null) || passwordField.getText().trim().equals(""))
					JOptionPane.showMessageDialog(null, "Please enter a valid e-mail and password.", "Login Error!",JOptionPane.ERROR_MESSAGE);
				else {
					try {
						if(Customer.customerLogin(textEmail.getText(), passwordField.getText())) {
							frame.dispose(); 
							cusemail = textEmail.getText();
			                UserLoggedInGui.main(null);
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
		btnLogin.setBounds(125, 270, 102, 36);
		frame.getContentPane().add(btnLogin);
		
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
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(442, 140, 81, 36);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblNewPassword = new JLabel("Password:");
		lblNewPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewPassword.setBounds(442, 191, 81, 36);
		frame.getContentPane().add(lblNewPassword);
		
		textEmailreg = new JTextField();
		textEmailreg.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textEmailreg.setColumns(10);
		textEmailreg.setBounds(539, 143, 219, 30);
		frame.getContentPane().add(textEmailreg);
		
		passwordFieldreg = new JPasswordField();
		passwordFieldreg.setBounds(539, 192, 219, 30);
		frame.getContentPane().add(passwordFieldreg);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFirstName.setBounds(427, 237, 96, 36);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName.setBounds(427, 284, 96, 36);
		frame.getContentPane().add(lblLastName);
		
		textFirst = new JTextField();
		textFirst.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFirst.setColumns(10);
		textFirst.setBounds(539, 240, 219, 30);
		frame.getContentPane().add(textFirst);
		
		textLast = new JTextField();
		textLast.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textLast.setColumns(10);
		textLast.setBounds(539, 287, 219, 30);
		frame.getContentPane().add(textLast);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textEmailreg.getText().equals(null) || textEmailreg.getText().trim().equals("")||passwordFieldreg.getText().equals(null) || passwordFieldreg.getText().trim().equals("") || textFirst.getText().equals(null) || textFirst.getText().trim().equals("") || textLast.getText().equals(null) || textLast.getText().trim().equals(""))
					JOptionPane.showMessageDialog(null, "Please enter valid information.", "Registration Error!",JOptionPane.ERROR_MESSAGE);
				else {
					try {
						if(Customer.addCustomer(textEmailreg.getText(), passwordFieldreg.getText(), textFirst.getText(), textLast.getText())) {
							frame.dispose();
							UserGui.main(null);
							JOptionPane.showMessageDialog(null, "You have been successfully registered.", "Registration Successful!", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "The e-mail already exists in the system!", "Registration Error!",JOptionPane.ERROR_MESSAGE);
						}
					}
					catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "File not found!", "Internal Error!",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRegister.setBounds(539, 355, 102, 36);
		frame.getContentPane().add(btnRegister);
	}
	
	protected static String getEmail() {
		return cusemail;
	}
}
