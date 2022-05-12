package gui;

import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import logical.Customer;
import logical.ParkingSpace;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserLoggedInGui {

	private JFrame frame;
	private Customer cus;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLoggedInGui window = new UserLoggedInGui();
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
	public UserLoggedInGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			cus = new Customer(UserGui.getEmail());
			}
		catch (IOException e) {
			JOptionPane.showMessageDialog(null, "File not found!", "Internal Error!",JOptionPane.ERROR_MESSAGE);
		}
		
		frame = new JFrame();
		frame.setBounds(100, 100, 820, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome!");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWelcome.setBounds(340, 29, 110, 36);
		frame.getContentPane().add(lblWelcome);
		
		JLabel lblUser = new JLabel("Email:");
		lblUser.setHorizontalAlignment(SwingConstants.TRAILING);
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUser.setBounds(23, 140, 81, 36);
		frame.getContentPane().add(lblUser);
		
		JLabel lblEmail = new JLabel(cus.getEmail());
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(114, 140, 226, 36);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblFirstname = new JLabel("Firstname:");
		lblFirstname.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFirstname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFirstname.setBounds(23, 207, 81, 36);
		frame.getContentPane().add(lblFirstname);
		
		JLabel lblLastname = new JLabel("Lastname:");
		lblLastname.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLastname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastname.setBounds(23, 269, 81, 36);
		frame.getContentPane().add(lblLastname);
		
		JLabel lblFirst = new JLabel(cus.getFirst());
		lblFirst.setHorizontalAlignment(SwingConstants.LEFT);
		lblFirst.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFirst.setBounds(114, 207, 226, 36);
		frame.getContentPane().add(lblFirst);
		
		JLabel lblLast = new JLabel(cus.getLast());
		lblLast.setHorizontalAlignment(SwingConstants.LEFT);
		lblLast.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLast.setBounds(114, 269, 226, 36);
		frame.getContentPane().add(lblLast);
		
		JLabel lblBookSpot = new JLabel("Book Spot:");
		lblBookSpot.setHorizontalAlignment(SwingConstants.TRAILING);
		lblBookSpot.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBookSpot.setBounds(442, 140, 81, 36);
		frame.getContentPane().add(lblBookSpot);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(533, 146, 219, 30);
		frame.getContentPane().add(textField);
		
		JLabel lblNewLabel = new JLabel("(1-50)");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(762, 153, 34, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblCardNumber = new JLabel("Card Number:");
		lblCardNumber.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCardNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCardNumber.setBounds(377, 207, 146, 36);
		frame.getContentPane().add(lblCardNumber);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(533, 213, 219, 30);
		frame.getContentPane().add(textField_1);
		
		JLabel lblExpirymmyy = new JLabel("Expiry (MM/YY):");
		lblExpirymmyy.setHorizontalAlignment(SwingConstants.TRAILING);
		lblExpirymmyy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblExpirymmyy.setBounds(377, 269, 146, 36);
		frame.getContentPane().add(lblExpirymmyy);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(533, 275, 219, 30);
		frame.getContentPane().add(textField_2);
		
		JLabel lblCvv = new JLabel("CVV:");
		lblCvv.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCvv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCvv.setBounds(377, 325, 146, 36);
		frame.getContentPane().add(lblCvv);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(533, 325, 219, 30);
		frame.getContentPane().add(textField_3);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose(); 

                UserGui.main(null);
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogout.setBounds(23, 442, 102, 36);
		frame.getContentPane().add(btnLogout);
		
		JButton btnPayBook = new JButton("Pay & Book");
		btnPayBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(ParkingSpace.checkSpace(Integer.parseInt(textField.getText())) && cus.getSpots() < 3 && cus.addSpace(Integer.parseInt(textField.getText()))) {
						cus.setSpots(cus.getSpots() + 1);
						JOptionPane.showMessageDialog(null, "Spot successfully booked.", "Booking Successful!", JOptionPane.INFORMATION_MESSAGE);
						frame.dispose();
						
						UserLoggedInGui.main(null);
					}
					else {
						JOptionPane.showMessageDialog(null, "Reached maximum spot(3) / spot taken!", "Booking Error!",JOptionPane.ERROR_MESSAGE);
					}
				}
				catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "String contains char!", "Internal Error!",JOptionPane.ERROR_MESSAGE);
				}
				catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "File not found!", "Internal Error!",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnPayBook.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPayBook.setBounds(569, 387, 146, 55);
		frame.getContentPane().add(btnPayBook);
		
		JButton btnRemoveBookingFor = new JButton("Remove Booking for the given spot");
		btnRemoveBookingFor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(!(ParkingSpace.checkSpace(Integer.parseInt(textField.getText()))) && cus.removeSpace(Integer.parseInt(textField.getText()))) {
						JOptionPane.showMessageDialog(null, "Spot successfully removed.", "Unbooking Successful!", JOptionPane.INFORMATION_MESSAGE);
						frame.dispose();
						
						UserLoggedInGui.main(null);
					}
					else {
						JOptionPane.showMessageDialog(null, "Reached minimum spot(0) / spot closed!", "Booking Error!",JOptionPane.ERROR_MESSAGE);
					}
				}
				catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "String contains char!", "Internal Error!",JOptionPane.ERROR_MESSAGE);
				}
				catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "File not found!", "Internal Error!",JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnRemoveBookingFor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRemoveBookingFor.setBounds(465, 38, 287, 79);
		frame.getContentPane().add(btnRemoveBookingFor);
		
	}

}
