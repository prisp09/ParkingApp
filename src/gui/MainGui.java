package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGui {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGui window = new MainGui();
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
	public MainGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setBounds(100, 100, 820, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnCustomer = new JButton("Customer");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose(); 

                UserGui.main(null);
				
			}
		});
		btnCustomer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCustomer.setBounds(89, 203, 136, 56);
		frame.getContentPane().add(btnCustomer);
		
		JLabel lblLoginLabel = new JLabel("Please select your access level");
		lblLoginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLoginLabel.setBounds(256, 10, 298, 50);
		frame.getContentPane().add(lblLoginLabel);
		
		JButton btnParkingAuthority = new JButton("Officer");
		btnParkingAuthority.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ParkEGui.main(null);
			}
		});
		btnParkingAuthority.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnParkingAuthority.setBounds(342, 203, 136, 56);
		frame.getContentPane().add(btnParkingAuthority);
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
				AdminGui.main(null);
			}
		});
		btnAdmin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdmin.setBounds(590, 203, 136, 56);
		frame.getContentPane().add(btnAdmin);
		
		JLabel lblNewLabel = new JLabel("Made by Priyanshu Patel - psp09@my.yorku.ca");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(567, 442, 229, 51);
		frame.getContentPane().add(lblNewLabel);
	}
}
