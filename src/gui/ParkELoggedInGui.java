package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import logical.Admin;
import logical.ParkingEnforcer;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ParkELoggedInGui {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParkELoggedInGui window = new ParkELoggedInGui();
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
	public ParkELoggedInGui() {
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
		
		JLabel lblWelcomeOfficer = new JLabel("Welcome, Officer!");
		lblWelcomeOfficer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWelcomeOfficer.setBounds(320, 27, 175, 36);
		frame.getContentPane().add(lblWelcomeOfficer);
		
		JLabel lblParkingSpot = new JLabel("Parking Spot:");
		lblParkingSpot.setHorizontalAlignment(SwingConstants.TRAILING);
		lblParkingSpot.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblParkingSpot.setBounds(33, 135, 207, 36);
		frame.getContentPane().add(lblParkingSpot);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(270, 141, 274, 30);
		frame.getContentPane().add(textField);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ParkEGui.main(null);
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogout.setBounds(22, 441, 102, 36);
		frame.getContentPane().add(btnLogout);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals(null) || textField.getText().trim().equals(""))
					JOptionPane.showMessageDialog(null, "Please enter valid information.", "Registration Error!",JOptionPane.ERROR_MESSAGE);
				else {
					try {
						if(ParkingEnforcer.addSpace(Integer.parseInt(textField.getText()))) {
							JOptionPane.showMessageDialog(null, "Spot has been successfully added.", "Modification Successful!", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "The spot was never removed in the system!", "Modification Error!",JOptionPane.ERROR_MESSAGE);
						}
					}
					catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "File not found!", "Internal Error!",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdd.setBounds(234, 223, 102, 36);
		frame.getContentPane().add(btnAdd);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals(null) || textField.getText().trim().equals(""))
					JOptionPane.showMessageDialog(null, "Please enter valid information.", "Registration Error!",JOptionPane.ERROR_MESSAGE);
				else {
					try {
						if(ParkingEnforcer.removeSpace(Integer.parseInt(textField.getText()))) {
							JOptionPane.showMessageDialog(null, "Spot has been successfully removed.", "Modification Successful!", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "The spot is occupied in the system!", "Modification Error!",JOptionPane.ERROR_MESSAGE);
						}
					}
					catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "File not found!", "Internal Error!",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRemove.setBounds(474, 223, 102, 36);
		frame.getContentPane().add(btnRemove);
	}

}
