package com.oogie.miglayout;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class FrameTutorial extends JFrame {
	JLabel firstNameLabel = new JLabel("First Name");
	JLabel lastNameLabel = new JLabel("Last Name");
	JLabel addressLabel = new JLabel("Address");
	JTextField firstName = new JTextField();
	JTextField lastName = new JTextField();
	JTextField address= new JTextField();
	
	public FrameTutorial(String title) throws HeadlessException {
		super(title);
		initComponents();
	}
	
	private void initComponents() {
		JPanel panel = new JPanel(new MigLayout());

		panel.add(firstNameLabel);
		panel.add(firstName);
		panel.add(lastNameLabel, "gap unrelated");
		panel.add(lastName, "wrap");
		panel.add(addressLabel);
		panel.add(address, "span, grow");
		add(panel, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					JFrame frame = new FrameTutorial("Hello");
					
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.pack();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} 

}
