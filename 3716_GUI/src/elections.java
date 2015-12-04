import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class elections extends JFrame {

	private JPanel contentPane;
	SocietyInventory societies = new SocietyInventory();


	
	public elections(Account acc,Society soc) {
		  final Account a = acc;
		  final Society s = soc;
		  final SocietyInventory hold = new SocietyInventory();
		  hold.loadSocieties();
		setTitle("Cast your vote!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		
		ArrayList<String> vPstrings = new ArrayList<String>();
		ArrayList<Account> vPCandids=s.getvPCand();
	      for (int i =0; i<vPCandids.size(); i++)
	      {
	         Account accHold = vPCandids.get(i);
	         vPstrings.add(accHold.getStudent().getName());
		    
	      }
		ArrayList<String> secStrings = new ArrayList<String>();
		ArrayList<Account> secCandids=s.getSecCan();
		    for (int i =0; i<secCandids.size(); i++)
		    {
		      Account accHold = secCandids.get(i);
		      secStrings.add(accHold.getStudent().getName());
			    
		    }
		 
			ArrayList<String> trEstrings = new ArrayList<String>();
			ArrayList<Account> trECandids=s.getTreCan();
		      for (int i =0; i<trECandids.size(); i++)
		      {
		         Account accHold = trECandids.get(i);
		         trEstrings.add(accHold.getStudent().getName());
			    
		      }
		    
	    String[] presListArray = vPstrings.toArray(new String[]{});
	    String[] secListArray = secStrings.toArray(new String[]{});
	    String[] treasListArray = trEstrings.toArray(new String[]{});
		
	    final JComboBox comboBoxTest = new JComboBox(presListArray);
		comboBoxTest.setBounds(46, 54, 89, 49);
		contentPane.add(comboBoxTest);
		
		final JComboBox comboBox = new JComboBox(secListArray);
		comboBox.setBounds(160, 54, 89, 49);
		contentPane.add(comboBox);
		
		final JComboBox comboBox_1 = new JComboBox(treasListArray);
		comboBox_1.setBounds(273, 54, 89, 49);
		contentPane.add(comboBox_1);
		
		JButton btnNewButton = new JButton("Vote");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 Account a = new Account();
				  String selected = (String)comboBoxTest.getSelectedItem();

				  ArrayList<Account> vPL = s.getvPCand();
				  for (int i=0; i<vPL.size(); i++) {
				       
					  	if (vPL.get(i).getStudent().getName().equals(selected)) {
				        	a = vPL.get(i);
				  
				         }
					  	
				        } 
				s.getvPvotes().put(a, ((int)s.getvPvotes().get(a))+1);
			    societies = new SocietyInventory();
				societies=hold;
			    societies.saveSocieties();
			    System.out.println("vote cast for "+ a.getStudent().getName());
				
			}
		});
		btnNewButton.setBounds(46, 114, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("Vote");
		button.setBounds(160, 114, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Vote");
		button_1.setBounds(273, 114, 89, 23);
		contentPane.add(button_1);
		
		JLabel lblVicePresident = new JLabel("Vice president");
		lblVicePresident.setHorizontalAlignment(SwingConstants.CENTER);
		lblVicePresident.setBounds(46, 29, 89, 14);
		contentPane.add(lblVicePresident);
		
		JLabel lblSecretary = new JLabel("Secretary");
		lblSecretary.setHorizontalAlignment(SwingConstants.CENTER);
		lblSecretary.setBounds(160, 29, 89, 14);
		contentPane.add(lblSecretary);
		
		JLabel lblTreasurer = new JLabel("Treasurer");
		lblTreasurer.setHorizontalAlignment(SwingConstants.CENTER);
		lblTreasurer.setBounds(273, 29, 89, 14);
		contentPane.add(lblTreasurer);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(160, 227, 89, 23);
		contentPane.add(btnBack);
		
		button.addActionListener(new ActionListener()
		{
		 public void actionPerformed(ActionEvent e)
		 	
		{
			 Account a = new Account();
			  String selected = (String)comboBox.getSelectedItem();

			  ArrayList<Account> sL = s.getSecCan();
			  for (int i=0; i<sL.size(); i++) {
			       
				  	if (sL.get(i).getStudent().getName().equals(selected)) {
			        	a = sL.get(i);
			  
			         }
				  	
			        } 
			s.getsVotes().put(a, ((int)s.getsVotes().get(a))+1);
		    societies = new SocietyInventory();
			societies=hold;
		    societies.saveSocieties();
		   
		    System.out.println("vote cast for "+ a.getStudent().getName());

		}
		 });
		
		button_1.addActionListener(new ActionListener()
		{
		 public void actionPerformed(ActionEvent e)
		 	
		{
			 Account a = new Account();
			  String selected = (String)comboBox_1.getSelectedItem();

			  ArrayList<Account> tL = s.getTreCan();
			  for (int i=0; i<tL.size(); i++) {
			       
				  	if (tL.get(i).getStudent().getName().equals(selected)) {
			        	a = tL.get(i);
			  
			         }
				  	
			        } 
			s.gettVotes().put(a, ((int)s.gettVotes().get(a))+1);
		    societies = new SocietyInventory();
			societies=hold;
		    societies.saveSocieties();
		    System.out.println("vote cast for "+ a.getStudent().getName());
			
		

		}
		 });
		
		btnBack.addActionListener(new ActionListener()
		{
		 public void actionPerformed(ActionEvent e)
		 	
		 {			
			 EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							JFrameSociety frame = new JFrameSociety(s,a);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			 dispose();
		 }
		 
		});
	}
}
