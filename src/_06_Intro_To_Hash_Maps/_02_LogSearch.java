package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class _02_LogSearch implements ActionListener {
	/*
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons.
	 * Button 1: Add Entry
	 *      When this button is clicked, use an input dialog to ask the user
	 *      to enter an ID number.
	 *      After an ID is entered, use another input dialog to ask the user
	 *      to enter a name. Add this information as a new entry to your
	 *      HashMap.
	 * 
	 * Button 2: Search by ID
	 *      When this button is clicked, use an input dialog to ask the user
	 *      to enter an ID number.
	 *      If that ID exists, display that name to the user.
	 *      Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 *      When this button is clicked, display the entire list in a message
	 *      dialog in the following format:
	 *      ID: 123  Name: Harry Howard
	 *      ID: 245  Name: Polly Powers
	 *      ID: 433  Name: Oliver Ortega
	 *      etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 *      When this button is clicked, prompt the user to enter an ID using
	 *      an input dialog.
	 *      If this ID exists in the HashMap, remove it. Otherwise, notify the
	 *      user that the ID is not in the list.
	 */
	HashMap<Integer,String> map = new HashMap<>();
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
	static JButton button = new JButton();
	static JButton button1 = new JButton();
	static JButton button2 = new JButton();
	static JButton button3 = new JButton();
	public void run() {
		frame.setVisible(true);
		frame.setSize(800,600);
		frame.add(panel);
		panel.add(button);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		button.setText("Add Entry");
		button1.setText("Search by ID");
		button2.setText("View List");
		button3.setText("Remove Entry");
		button.addActionListener(this);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == button) {
			String idnumberAsString = JOptionPane.showInputDialog("What is your ID number");
			int idnumber = Integer.parseInt(idnumberAsString);
			String name = JOptionPane.showInputDialog("Enter your name");
			map.put(idnumber, name);
		}
		if(e.getSource() == button1) {
			String searchidAsString = JOptionPane.showInputDialog("What ID number do you want to search up");
			int searchId = Integer.parseInt(searchidAsString);

			if(map.get(searchId)== null) {
				JOptionPane.showMessageDialog(null, "Your ID is not listed");
			}
			else {
				JOptionPane.showMessageDialog(null, "The name listed is " + map.get(searchId));
			}

		}
		if(e.getSource() == button2) {
			String list = "Guest List: \n";
			for(Integer i: map.keySet()) {
				list += "ID: " + i + " Name: " + map.get(i) + "\n";
			}
			JOptionPane.showMessageDialog(null, list);
		}
		if(e.getSource() == button3) {
			String searchIdasString = JOptionPane.showInputDialog("What ID number do you want to delete");
			int deleteId = Integer.parseInt(searchIdasString);
			if(map.keySet().contains(deleteId)) {
				map.remove(deleteId);
			}
			else {
				JOptionPane.showMessageDialog(null, "There is no ID by that");
			}
		}
	}

}
