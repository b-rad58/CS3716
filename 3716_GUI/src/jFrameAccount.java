	import java.awt.BorderLayout;
	import java.awt.EventQueue;
	import java.awt.List;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.io.BufferedReader;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;
	import java.awt.Color;
	import javax.swing.JComboBox;
	import javax.swing.JLabel;
	import javax.swing.SwingConstants;
	import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JTextPane;

	public class jFrameAccount extends JFrame{
		private JPanel contentPane;
		private Account user;
		private JTextField txtName;
		private JTextField txtDes;
		private Society s;
		SocietyInventory societies = new SocietyInventory();
	
		


		public jFrameAccount(Account u) throws IOException {
			user=u;
			setTitle("Welcome to your portal " + u.getStudent().getName());
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 852, 503);
			contentPane = new JPanel();
			contentPane.setBackground(Color.GREEN);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			societies.loadSocieties();
			final ArrayList<Society> sList=societies.getSocietyList();
			ArrayList<String> strings = new ArrayList<String>();
			
		      for (int i =0; i<sList.size(); i++)
		      {
		         Society s = sList.get(i);
		         strings.add(s.getName());
			    
		      }
			 
			
		    String[] socListArray = strings.toArray(new String[]{});
		    String[] socSelArray = strings.toArray(new String[]{});
	 
			final JComboBox society_list = new JComboBox(socListArray);
			society_list.setBounds(20, 119, 192, 29);
			contentPane.add(society_list);
			
			JLabel lblSelectASociety = new JLabel("Select a Society to Join");
			lblSelectASociety.setHorizontalAlignment(SwingConstants.CENTER);
			lblSelectASociety.setBounds(30, 94, 179, 14);
			contentPane.add(lblSelectASociety);
			
			JButton btnJoin = new JButton("Join!");
			btnJoin.setBounds(55, 162, 89, 23);
			contentPane.add(btnJoin);
			
			JLabel lblCreateYourOwn = new JLabel("Create your own Society!");
			lblCreateYourOwn.setHorizontalAlignment(SwingConstants.CENTER);
			lblCreateYourOwn.setBounds(533, 94, 220, 14);
			contentPane.add(lblCreateYourOwn);
			
			txtName = new JTextField();
			txtName.setBounds(604, 128, 86, 20);
			contentPane.add(txtName);
			txtName.setColumns(10);
			
			txtDes = new JTextField();
			txtDes.setBounds(604, 163, 86, 20);
			contentPane.add(txtDes);
			txtDes.setColumns(10);
			
			JButton btnCreate = new JButton("Create");
			btnCreate.setBounds(604, 194, 89, 23);
			contentPane.add(btnCreate);
			
			JLabel lblName = new JLabel("Name:");
			lblName.setHorizontalAlignment(SwingConstants.TRAILING);
			lblName.setBounds(548, 131, 46, 14);
			contentPane.add(lblName);
			
			JLabel lblDescription = new JLabel("Description:");
			lblDescription.setHorizontalAlignment(SwingConstants.TRAILING);
			lblDescription.setBounds(508, 166, 86, 14);
			contentPane.add(lblDescription);
			
			
			final JComboBox socSel = new JComboBox(socSelArray);
			socSel.setBounds(10, 228, 202, 29);
			contentPane.add(socSel);
			
			JButton btnViewGroup = new JButton("View Group");
			btnViewGroup.setBounds(55, 268, 89, 23);
			contentPane.add(btnViewGroup);
			
			JButton btnBack = new JButton("Back");
			btnBack.setBounds(720, 430, 89, 23);
			contentPane.add(btnBack);
			
			final JLabel lblMCheck = new JLabel("");
			lblMCheck.setBounds(222, 126, 46, 14);
			contentPane.add(lblMCheck);
			
			JLabel lblViewAllSocieties = new JLabel("View all Societies");
			lblViewAllSocieties.setHorizontalAlignment(SwingConstants.CENTER);
			lblViewAllSocieties.setBounds(10, 198, 187, 14);
			contentPane.add(lblViewAllSocieties);
			

			

		
			
			btnBack.addActionListener(new ActionListener()
			{
			 public void actionPerformed(ActionEvent e)
			 	
			{

				 	
			      SocietyInventory societies = new SocietyInventory();
			      AccountInventory accounts = new AccountInventory();
			      societies.loadSocieties();
			      societies.saveSocieties();
			      accounts.loadAccounts();
			      accounts.saveAccounts();


			      

			      EventQueue.invokeLater(new Runnable() {
			 			public void run() {
			 				try {
			 					mainframe frame = new mainframe();
			 					frame.setVisible(true);
			 				} catch (Exception e) {
			 					e.printStackTrace();
			 				}
			 			}
			 		});
			      dispose();


			      System.out.println("Welcome to MUN Society ");

			}
			 });
			
			
			btnViewGroup.addActionListener(new ActionListener()
			{
				 public void actionPerformed(ActionEvent e)
				 
				 {		
					  {		
						  String selected = (String)socSel.getSelectedItem();

						  ArrayList<Society> sL = societies.getSocietyList();
						  for (int i=0; i<sL.size(); i++) {
						       
							  	if (sL.get(i).getName().equals(selected)) {
						        	s = sL.get(i).getSociety();
						  
						         }
							  	
						        }
						  System.out.println("now opening the " + s.getName()+ " society page");
						    Society sHold = s;
						  	
						    sHold.loadMembers();
						  	s = new Society();
						  	s=sHold;
						  	try {
								s.saveMembers();
							} catch (FileNotFoundException | UnsupportedEncodingException e1) {
								
								e1.printStackTrace();
							}

					  }
					 
					 EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									JFrameSociety frame = new JFrameSociety(s,user);
									frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
				 dispose(); 
				 }
			});
			
			btnJoin.addActionListener(new ActionListener()
			{
			  public void actionPerformed(ActionEvent e)
			  {		
				 final SocietyInventory hold = new SocietyInventory();
				  hold.loadSocieties();
				  String selected = (String)society_list.getSelectedItem();
				  ArrayList<Society> sL = hold.getSocietyList();
				  for (int i = 0; i<sL.size(); i++) {
					  System.out.println(i);
				         if (sL.get(i).getName().equals(selected)) {
				        	 for(int k=0;k<sL.get(i).getMemberList().size();k++){
				        	 if(sL.get(i).getMemberList().get(k).getStudent().getStuNum().equals(user.getStudent().getStuNum())&& 
				        			 sL.get(i).getMemberList().get(k).getStudent().getName().equals(user.getStudent().getName())){
				        		 
				        		 lblMCheck.setText("Already a member");
				        		 repaint();
				        		 System.out.println("Already a member");
				        		 dispose();
							      
							      EventQueue.invokeLater(new Runnable() {
										public void run() {
											try {
												jFrameAccount frame = new jFrameAccount(user);
												frame.setVisible(true);
											} catch (Exception e) {
												e.printStackTrace();
											}
										}
									});

				        		 break;
				        	 }
				        	 else{
				        	 
				        	 user.getStudent().setPos("Member");
				        	
				        	 sL.get(i).addMember(user);
				        	 
				        	 
				        	 System.out.println(sList.get(i).getName()+" has been joined by "+ user.getStudent().getName());
				        	 break;

				        	 
				        	 }
				        	 }
				 
				         }
				         
				        }
				    societies = new SocietyInventory();
					societies=hold;
				    societies.saveSocieties();
				
			  }
			});
			
			btnCreate.addActionListener(new ActionListener()
			{
			  public void actionPerformed(ActionEvent e)
			  {		
				  SocietyInventory hold = new SocietyInventory();
				  hold.loadSocieties();
				  System.out.println("button worked");
			      Society soc = new Society(txtName.getText(), txtDes.getText(),user);
			      user.getStudent().setPos("President");
			      soc.addMember(user);
			      
			      hold.addSociety(soc);
			      System.out.println("number of members: "+soc.numMembers());
			      
			      dispose();
			      
			      EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								jFrameAccount frame = new jFrameAccount(user);
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});

					
					
				    societies = new SocietyInventory();
					societies=hold;
				    societies.saveSocieties();
				    
				    
					
			  }

			});

		}
	}
	

