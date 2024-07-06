package _00_Intro_To_ArrayLists;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
    /*
     * Create a GUI with two buttons. One button reads "Add Name" and the other
     * button reads "View Names". When the add name button is clicked, display
     * an input dialog that asks the user to enter a name. Add that name to an
     * ArrayList. When the "View Names" button is clicked, display a message
     * dialog that displays all the names added to the list. Format the list as
     * follows:
     * Guest #1: Bob Banders
     * Guest #2: Sandy Summers
     * Guest #3: Greg Ganders
     * Guest #4: Donny Doners
     */
	
	
	
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton button1 = new JButton();
		JButton button2 = new JButton();
		ArrayList<String> names = new ArrayList();
		
		
	
		
	
	public static void main(String[] args) {
		_02_GuestBook guestbook = new _02_GuestBook();
		guestbook.run();
	}
	
	
	void run() {
		panel.setPreferredSize(new Dimension(400,400));
		frame.add(panel);
		frame.pack();
		button1.setText("Add Name");
		button2.setText("View Names");
		panel.add(button1);
		panel.add(button2);
		button1.addActionListener(this);
		button2.addActionListener(this);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(button1 == e.getSource()) {
			 String name = JOptionPane.showInputDialog(null, "What name do you want to add");
			 names.add(name);
		}
		if(button2 == e.getSource()) {
			String theNames = "";
			for(int i = 0; i < names.size(); i++) {
				theNames += "Guest " + (i+1) + ":" + names.get(i) + "\n";
				
			}
			JOptionPane.showMessageDialog(null, "Your guest's names are \n" + theNames);
			
		}
		
	}


}
