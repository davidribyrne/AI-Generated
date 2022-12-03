// Write a Java program that uses a window to collect a name and an address and stores them in a text file.
// https://beta.openai.com/playground/p/xOCp85xphACc2VAEg8KJGRYM

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class NameAddressWindow extends JFrame {

	// GUI Components
	private JTextField nameField;
	private JTextField addressField;
	private JButton submitButton;

	// Constructor
	public NameAddressWindow() {
		super("Name and Address");

		// Get content pane and set its layout
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		// Create and add components
		nameField = new JTextField(20);
		addressField = new JTextField(20);
		submitButton = new JButton("Submit");
		contentPane.add(nameField, BorderLayout.NORTH);
		contentPane.add(addressField, BorderLayout.CENTER);
		contentPane.add(submitButton, BorderLayout.SOUTH);

		// Register an action listener on the submit button
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Get the name and address
				String name = nameField.getText().trim();
				String address = addressField.getText().trim();

				// Write the name and address to a file
				try {
					BufferedWriter writer = new BufferedWriter(
							new FileWriter("name_address.txt", true));
					writer.write(name);
					writer.newLine();
					writer.write(address);
					writer.newLine();
					writer.close();
					JOptionPane.showMessageDialog(NameAddressWindow.this,
							"Name and address saved successfully.");
				} catch (IOException ioe) {
					JOptionPane.showMessageDialog(NameAddressWindow.this,
							"Error saving name and address.",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		// Size the window to obtain a best fit for the components
		pack();

		// Center the window
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = getSize();
		setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.width) / 2);

		// Make the window visible
		setVisible(true);
	}

	// Main method
	public static void main(String[] args) {
		new NameAddressWindow();
	}
}