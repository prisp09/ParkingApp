package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import logical.Admin;
import logical.Customer;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class AdminLoggedInGui {

	private JFrame frame;
	private JTextField textEmail;
	private JPasswordField passwordField;
	private JTextField textFirst;
	private JTextField textLast;
	private JTextField textEmailr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLoggedInGui window = new AdminLoggedInGui();
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
	public AdminLoggedInGui() {
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
		
		JLabel lblWelcomeYourHighness = new JLabel("Welcome, your highness!");
		lblWelcomeYourHighness.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeYourHighness.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWelcomeYourHighness.setBounds(291, 26, 224, 36);
		frame.getContentPane().add(lblWelcomeYourHighness);
		
		JLabel lblRegisterOfficer = new JLabel("Register Officer");
		lblRegisterOfficer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRegisterOfficer.setBounds(35, 125, 144, 36);
		frame.getContentPane().add(lblRegisterOfficer);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(35, 202, 81, 36);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblNewPassword = new JLabel("Password:");
		lblNewPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewPassword.setBounds(35, 253, 81, 36);
		frame.getContentPane().add(lblNewPassword);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textEmail.setColumns(10);
		textEmail.setBounds(132, 205, 219, 30);
		frame.getContentPane().add(textEmail);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(132, 254, 219, 30);
		frame.getContentPane().add(passwordField);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFirstName.setBounds(20, 299, 96, 36);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName.setBounds(20, 346, 96, 36);
		frame.getContentPane().add(lblLastName);
		
		textFirst = new JTextField();
		textFirst.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFirst.setColumns(10);
		textFirst.setBounds(132, 302, 219, 30);
		frame.getContentPane().add(textFirst);
		
		textLast = new JTextField();
		textLast.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textLast.setColumns(10);
		textLast.setBounds(132, 349, 219, 30);
		frame.getContentPane().add(textLast);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textEmail.getText().equals(null) || textEmail.getText().trim().equals("")||passwordField.getText().equals(null) || passwordField.getText().trim().equals("") || textFirst.getText().equals(null) || textFirst.getText().trim().equals("") || textLast.getText().equals(null) || textLast.getText().trim().equals(""))
					JOptionPane.showMessageDialog(null, "Please enter valid information.", "Registration Error!",JOptionPane.ERROR_MESSAGE);
				else {
					try {
						if(Admin.addParkE(textEmail.getText(), passwordField.getText(), textFirst.getText(), textLast.getText())) {
							JOptionPane.showMessageDialog(null, "Officer has been successfully registered.", "Registration Successful!", JOptionPane.INFORMATION_MESSAGE);
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
		btnRegister.setBounds(189, 400, 102, 36);
		frame.getContentPane().add(btnRegister);
		
		JLabel lblRemoveOfficer = new JLabel("Remove Officer");
		lblRemoveOfficer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRemoveOfficer.setBounds(456, 125, 144, 36);
		frame.getContentPane().add(lblRemoveOfficer);
		
		JLabel lblEmailr = new JLabel("Email:");
		lblEmailr.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmailr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmailr.setBounds(456, 202, 81, 36);
		frame.getContentPane().add(lblEmailr);
		
		textEmailr = new JTextField();
		textEmailr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textEmailr.setColumns(10);
		textEmailr.setBounds(553, 205, 219, 30);
		frame.getContentPane().add(textEmailr);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
				MainGui.main(null);
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogout.setBounds(23, 443, 102, 36);
		frame.getContentPane().add(btnLogout);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textEmailr.getText().equals(null) || textEmailr.getText().trim().equals(""))
					JOptionPane.showMessageDialog(null, "Please enter valid information.", "Registration Error!",JOptionPane.ERROR_MESSAGE);
				else {
					try {
						if(Admin.removeParkE(textEmailr.getText())) {
							JOptionPane.showMessageDialog(null, "Officer has been successfully removed.", "Removal Successful!", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "The officer does not exist in the system!", "Registration Error!",JOptionPane.ERROR_MESSAGE);
						}
					}
					catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "File not found!", "Internal Error!",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRemove.setBounds(608, 400, 102, 36);
		frame.getContentPane().add(btnRemove);
	}
}
