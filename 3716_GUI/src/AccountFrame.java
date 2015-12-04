import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class AccountFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public AccountFrame() throws IOException {
		setTitle("");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 852, 503);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		SocietyInventory societies = new SocietyInventory();
		societies.loadSocieties();
		ArrayList<Society> sList=societies.getSocietyList();
		ArrayList<String> strings = new ArrayList<String>();
		
	      for (int i =0; i<sList.size(); i++)
	      {
	         Society s = sList.get(i);
	         strings.add(s.getName());
		    
	      }
		 
		
	    String[] lineArray = strings.toArray(new String[]{});
 
		JComboBox society_list = new JComboBox(lineArray);
		society_list.setBounds(20, 119, 192, 29);
		contentPane.add(society_list);
		
		JLabel lblSelectASociety = new JLabel("Select a Society to Join");
		lblSelectASociety.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectASociety.setBounds(10, 94, 179, 14);
		contentPane.add(lblSelectASociety);
		
		JButton btnJoin = new JButton("Join!");
		btnJoin.setBounds(55, 162, 89, 23);
		contentPane.add(btnJoin);
		
		btnJoin.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			SocietyInventory societies = new SocietyInventory();
				societies.loadSocieties();
				System.out.println(societies.toString()); 
		  }
		});
		
		
	}
}
