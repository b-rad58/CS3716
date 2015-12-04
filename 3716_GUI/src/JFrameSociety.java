import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class JFrameSociety extends JFrame {

	private JPanel contentPane;
	private Society soc;
	private Account acc;
	private JTable eventTable;
	private JTextField enameTxt;
	private JTextField eDesTxt;
	private JTextField edateTxt;
	SocietyInventory societies = new SocietyInventory();
	private JTextField banBox;
	private JTextField eventDeletetxt;
	private boolean activeElection;



	/**
	 * Create the frame.
	 * @throws UnsupportedEncodingException 
	 * @throws FileNotFoundException 
	 */
	public JFrameSociety(Society s,Account a) throws FileNotFoundException, UnsupportedEncodingException {
		  final SocietyInventory hold = new SocietyInventory();
		  hold.loadSocieties();
		
		acc=a;

		for(int i = 0;i<hold.getSocietyList().size();i++){
			if(hold.getSocietyList().get(i).getName().equals(s.getName())){
				soc=hold.getSocietyList().get(i);
			}
		}

		activeElection=soc.getAe();
		
		setBackground(Color.WHITE);
		System.out.println("president is " + soc.getPresident().getStudent().getName() );

		
		
		if(soc.getPresident().getUsername().equals(acc.getUsername())){
			System.out.println(activeElection);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 1146, 779);
			contentPane = new JPanel();
			contentPane.setBackground(Color.RED);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			if(soc.getSanctioned()==true){
				setTitle(soc.getName()+" - "+ soc.getDescription()+"---- Welcome President " +acc.getStudent().getName()+" This society is Sanctioned!" );
			}
			else{
			setTitle(soc.getName()+" - "+ soc.getDescription()+"---- Welcome President " +acc.getStudent().getName() );
			}
			enameTxt = new JTextField();
			enameTxt.setBounds(677, 401, 86, 20);
			contentPane.add(enameTxt);
			enameTxt.setColumns(10);
			
			eDesTxt = new JTextField();
			eDesTxt.setBounds(677, 432, 86, 20);
			contentPane.add(eDesTxt);
			eDesTxt.setColumns(10);
			
			edateTxt = new JTextField();
			edateTxt.setBounds(677, 463, 86, 20);
			contentPane.add(edateTxt);
			edateTxt.setColumns(10);
			
			JButton btnCreateEvent = new JButton("Create Event");
			btnCreateEvent.setBounds(634, 494, 181, 23);
			contentPane.add(btnCreateEvent);
			
			JLabel lbltitleLabel = new JLabel("Title:");
			lbltitleLabel.setHorizontalAlignment(SwingConstants.TRAILING);
			lbltitleLabel.setBounds(621, 404, 46, 14);
			contentPane.add(lbltitleLabel);
			
			JLabel deslbl = new JLabel("Description:");
			deslbl.setHorizontalAlignment(SwingConstants.TRAILING);
			deslbl.setBounds(592, 435, 75, 14);
			contentPane.add(deslbl);
			
			JLabel datelbl = new JLabel("date:");
			datelbl.setHorizontalAlignment(SwingConstants.TRAILING);
			datelbl.setBounds(621, 466, 46, 14);
			contentPane.add(datelbl);
	        
			JButton btnBack = new JButton("Back");
			btnBack.setBounds(657, 681, 89, 23);
			contentPane.add(btnBack);
			
			eventDeletetxt = new JTextField();
			eventDeletetxt.setBounds(677, 545, 86, 20);
			contentPane.add(eventDeletetxt);
			eventDeletetxt.setColumns(10);
			
			JButton btnDeleteEvent = new JButton("Delete Event");
			btnDeleteEvent.setBounds(655, 567, 132, 23);
			contentPane.add(btnDeleteEvent);
			
			
			JButton addVP = new JButton("Add");
			addVP.setBounds(471, 544, 54, 23);
			contentPane.add(addVP);
			
			JButton addS = new JButton("Add");
			addS.setBounds(471, 579, 54, 23);
			contentPane.add(addS);
			
			JButton addT = new JButton("Add");
			addT.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			addT.setBounds(471, 610, 54, 23);
			contentPane.add(addT);
			
			JLabel lblNominate = new JLabel("Nominate");
			lblNominate.setHorizontalAlignment(SwingConstants.CENTER);
			lblNominate.setBounds(430, 528, 75, 14);
			contentPane.add(lblNominate);
			

			
			
			JButton btnEnableElections = new JButton("Enable Elections");
			if(activeElection==false){
				btnEnableElections.setEnabled(true);
			}
			else{
				btnEnableElections.setEnabled(false);
			}
			btnEnableElections.setBounds(377, 462, 140, 23);
			contentPane.add(btnEnableElections);
			
			JButton btnDisableElections = new JButton("Disable Elections");
			if(activeElection==true){
			btnDisableElections.setEnabled(true);
			}
			else{
				btnDisableElections.setEnabled(false);
			}
			btnDisableElections.setBounds(377, 494, 140, 23);
			contentPane.add(btnDisableElections);
			
			JButton btnEndElection = new JButton("End Election");
			if(activeElection==true){
				btnEndElection.setEnabled(true);
				}
				else{
					btnEndElection.setEnabled(false);
				}
			btnEndElection.setBounds(400, 658, 105, 23);
			contentPane.add(btnEndElection);
			
			btnEndElection.addActionListener(new ActionListener()
			{
			 public void actionPerformed(ActionEvent e)
			 	
			 {	
				 soc.setAe(false);
				 soc.getResults();
				 dispose();
				 
				    societies = new SocietyInventory();
					societies=hold;
				    societies.saveSocieties();
				 EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								JFrameSociety frame = new JFrameSociety(soc,acc);
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
			 }
			 
			});


			btnEnableElections.addActionListener(new ActionListener()
			{
			 public void actionPerformed(ActionEvent e)
			 	
			 {	
				 soc.setAe(true);
				 soc.setSecretary(null);
				 soc.setTreasurer(null);
				 soc.setVicePresident(null);
			
				 dispose();
				 
				    societies = new SocietyInventory();
					societies=hold;
				    societies.saveSocieties();
				 EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								JFrameSociety frame = new JFrameSociety(soc,acc);
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
			 }
			 
			});
			
			btnDisableElections.addActionListener(new ActionListener()
			{
			 public void actionPerformed(ActionEvent e)
			 	
			 {			
				 soc.setAe(false);
				 System.out.println(activeElection);
				    societies = new SocietyInventory();
					societies=hold;
				    societies.saveSocieties();
				 dispose();
				 
				 EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								JFrameSociety frame = new JFrameSociety(soc,acc);
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
			 }
			 
			});
			
			btnBack.addActionListener(new ActionListener()
			{
			 public void actionPerformed(ActionEvent e)
			 	
			 {			
				 EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								jFrameAccount frame = new jFrameAccount(acc);
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}); 
				 dispose();
			 }
			 
			});
			
			btnCreateEvent.addActionListener(new ActionListener()
			{
			 public void actionPerformed(ActionEvent e)
			 	
			 {
				 SocietyEvent se = new SocietyEvent(enameTxt.getText(),edateTxt.getText(),eDesTxt.getText());
				 soc.addEvent(se);
				 System.out.print(se.getName()+ " "+ se.getDescription()+" "+ se.getTime());
				 
				 dispose();
				 
				 EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								JFrameSociety frame = new JFrameSociety(soc,acc);
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
			
			JButton btnBanHammer = new JButton("Remove");
			btnBanHammer.setBounds(190, 494, 89, 23);
			contentPane.add(btnBanHammer);
			
			btnBanHammer.addActionListener(new ActionListener()
			{
			 public void actionPerformed(ActionEvent e)
			 	
			 {			
				 Account toDelete=new Account();
				 System.out.println("starting remove procedure");
				 ArrayList<Account> mList = soc.getMemberList();
				 for(int i = 0; i<mList.size();i++){
				 System.out.println(mList.get(i).getStudent().getStuNum());
					 if(mList.get(i).getStudent().getStuNum().equals(banBox.getText())){
						 toDelete=mList.get(i);
					 }
				 }
				 soc.removeAccount(toDelete);
				 
                 dispose();
				 
				 EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								JFrameSociety frame = new JFrameSociety(soc,acc);
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
			
			btnDeleteEvent.addActionListener(new ActionListener()
			{
			 public void actionPerformed(ActionEvent e)
			 	
			 {			
				 SocietyEvent toDelete=new SocietyEvent();
				 System.out.println("starting remove procedure");
				 ArrayList<SocietyEvent> eList = soc.getEventList();
				 for(int i = 0; i<eList.size();i++){
				 System.out.println(eList.get(i).getName());
					 if(eList.get(i).getName().equals(eventDeletetxt.getText())){
						 toDelete=eList.get(i);
					 }
				 }
				 soc.removeEvent(toDelete);
				 
                 dispose();
				 
				 EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								JFrameSociety frame = new JFrameSociety(soc,acc);
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
			
			ArrayList<String> strings = new ArrayList<String>();
			ArrayList<Account> mList=soc.getMemberList();
		      for (int i =0; i<mList.size(); i++)
		      {
		         Account acc = mList.get(i);
		         strings.add(acc.getStudent().getName());
			    
		      }
			 
			
		    String[] presListArray = strings.toArray(new String[]{});
		    String[] secListArray = strings.toArray(new String[]{});
		    String[] treasListArray = strings.toArray(new String[]{});
			
			
			banBox = new JTextField();
			banBox.setBounds(190, 463, 86, 20);
			contentPane.add(banBox);
			banBox.setColumns(10);
			

			
			JLabel lblTitleToBe = new JLabel("Event to be deleted:");
			lblTitleToBe.setHorizontalAlignment(SwingConstants.TRAILING);
			lblTitleToBe.setBounds(552, 548, 115, 14);
			contentPane.add(lblTitleToBe);
			
			JLabel lblStudentNumberTo = new JLabel("Student number to be removed:");
			lblStudentNumberTo.setHorizontalAlignment(SwingConstants.TRAILING);
			lblStudentNumberTo.setBounds(10, 456, 170, 34);
			contentPane.add(lblStudentNumberTo);
			
			final JComboBox vicePresBox = new JComboBox(presListArray);
			vicePresBox.setBounds(400, 545, 69, 20);
			contentPane.add(vicePresBox);
			
			final JComboBox secComBox = new JComboBox(secListArray);
			secComBox.setBounds(400, 580, 69, 20);
			contentPane.add(secComBox);
			
			final JComboBox treasComBox = new JComboBox(treasListArray);
			treasComBox.setBounds(400, 611, 69, 20);
			contentPane.add(treasComBox);
			
			JLabel lblNewLabel = new JLabel("Secretary:");
			lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNewLabel.setBounds(314, 583, 76, 14);
			contentPane.add(lblNewLabel);
			
			JLabel lblTreasurer = new JLabel("Treasurer:");
			lblTreasurer.setHorizontalAlignment(SwingConstants.TRAILING);
			lblTreasurer.setBounds(324, 614, 66, 14);
			contentPane.add(lblTreasurer);
			
			JLabel lblVicePresident = new JLabel("Vice President:");
			lblVicePresident.setHorizontalAlignment(SwingConstants.TRAILING);
			lblVicePresident.setBounds(304, 548, 86, 14);
			contentPane.add(lblVicePresident);
			
			addVP.addActionListener(new ActionListener()
			{
			 public void actionPerformed(ActionEvent e)
			 	
			 {
				 Account a = new Account();
				  String selected = (String)vicePresBox.getSelectedItem();

				  ArrayList<Account> aL = soc.getMemberList();
				  for (int i=0; i<aL.size(); i++) {
				       
					  	if (aL.get(i).getStudent().getName().equals(selected)) {
				        	a = aL.get(i);
				  
				         }
					  	
				        }

				    Account aHold = a;
				  	
				  	a=aHold;
				  	
				 soc.getvPvotes().put(a,0);	
				 soc.getvPCand().add(a);
				 
				 dispose();
				 
				 EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								JFrameSociety frame = new JFrameSociety(soc,acc);
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
			
			addS.addActionListener(new ActionListener()
			{
			 public void actionPerformed(ActionEvent e)
			 	
			 {
				 Account a = new Account();
				  String selected = (String)secComBox.getSelectedItem();

				  ArrayList<Account> aL = soc.getMemberList();
				  for (int i=0; i<aL.size(); i++) {
				       
					  	if (aL.get(i).getStudent().getName().equals(selected)) {
				        	a = aL.get(i);
				  
				         }
					  	
				        }
				    Account aHold = a;
				  	
				  	a=aHold;
				 
				 soc.getsVotes().put(a,0);	
				 soc.getSecCan().add(a);
				 
				 dispose();
				 
				 EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								JFrameSociety frame = new JFrameSociety(soc,acc);
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
			
			addT.addActionListener(new ActionListener()
			{
			 public void actionPerformed(ActionEvent e)
			 	
			 {
				 Account a = new Account();
				  String selected = (String)treasComBox.getSelectedItem();

				  ArrayList<Account> aL = soc.getMemberList();
				  for (int i=0; i<aL.size(); i++) {
				       
					  	if (aL.get(i).getStudent().getName().equals(selected)) {
				        	a = aL.get(i);
				  
				         }
					  	
				        }
				    Account aHold = a;
				  	
				  	a=aHold;

				 soc.gettVotes().put(a,0);
				 soc.getTreCan().add(a);
				 
				 dispose();
				 
				 EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								JFrameSociety frame = new JFrameSociety(soc,acc);
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
		else{
			if(soc.getSanctioned()==true){
				setTitle(s.getName()+" - "+ s.getDescription()+" This society is Sanctioned!" );
			}
			else{
				setTitle(s.getName()+" - "+ s.getDescription());
			}
			
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 1146 , 483);
			contentPane = new JPanel();
			contentPane.setBackground(Color.RED);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
		
			JButton btnBack = new JButton("Back");
			btnBack.setBounds(669, 405, 89, 23);
			contentPane.add(btnBack);
			
			btnBack.addActionListener(new ActionListener()
			{
			 public void actionPerformed(ActionEvent e)
			 	
			 {			
				 EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								jFrameAccount frame = new jFrameAccount(acc);
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


		
		JLabel lblMembersList = new JLabel("Members List");
		lblMembersList.setHorizontalAlignment(SwingConstants.CENTER);
		lblMembersList.setBounds(147, 56, 106, 14);
		contentPane.add(lblMembersList);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 82, 469, 289);
		contentPane.add(scrollPane);
	
		
		
		JTable  memberTable = new JTable();

		
        String[] colName = { "Name", "Student Number", "Position"};
        memberTable.getTableHeader().setBackground(Color.WHITE);
        memberTable.getTableHeader().setForeground(Color.BLUE);
        System.out.println(soc.getMemberList().toString());
        ArrayList<Account> memList = soc.getMemberList();
        
        Object[][] object = new Object[100][100];
            for (int i=0;i<memList.size();i++) {
                Account ac = memList.get(i); 
                object[i][0] = ac.getStudent().getName();
                object[i][1] = ac.getStudent().getStuNum();
                object[i][2] = ac.getStudent().getPos();
                  
              }
        memberTable = new JTable(object, colName);
        scrollPane.setViewportView(memberTable);
        

		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(552, 82, 302, 289);
		contentPane.add(scrollPane_1);
		
		eventTable = new JTable();
		
        String[] colNames = { "Title", "Description", "Time"};
        eventTable.getTableHeader().setBackground(Color.WHITE);
        eventTable.getTableHeader().setForeground(Color.BLUE);
        ArrayList<SocietyEvent> eList = soc.getEventList();

        Object[][] obj = new Object[100][100];
            for (int i=0;i<eList.size();i++) {
                SocietyEvent se = eList.get(i); 
                obj[i][0] = se.getName();
                obj[i][1] = se.getDescription();
                obj[i][2] = se.getTime();
                  
              }
        eventTable = new JTable(obj, colNames);
        scrollPane_1.setViewportView(eventTable);
		
		JLabel lblEvents = new JLabel("Events");
		lblEvents.setHorizontalAlignment(SwingConstants.CENTER);
		lblEvents.setBounds(677, 56, 46, 14);
		contentPane.add(lblEvents);
		
		JButton btnLeave = new JButton("Leave");
		btnLeave.setBounds(164, 405, 89, 23);
		contentPane.add(btnLeave);
		
		btnLeave.addActionListener(new ActionListener()
		{
		 public void actionPerformed(ActionEvent e)
		 	
		 {			
			 System.out.println("starting leave procedure");
			 if(acc.getUsername().equals(soc.getPresident().getUsername())&& acc.getStudent().getStuNum().equals(soc.getPresident().getStudent().getStuNum())){
				 System.out.println("The president can not leave");
			 }
			 else{
				 
			 
			 soc.removeAccount(acc);
			 
			 dispose();
			 
			 EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							JFrameSociety frame = new JFrameSociety(soc,acc);
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
		 }
		 
		});
		
		JButton btnElections = new JButton("Elections");
		if(activeElection==true){
		btnElections.setEnabled(true);
		}else{
		btnElections.setEnabled(false);
		}
		btnElections.setBounds(400, 405, 89, 23);
		contentPane.add(btnElections);
		
		JLabel lblNewLabel_1 = new JLabel(soc.getPresident().getStudent().getName());
		lblNewLabel_1.setBounds(978, 89, 142, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel();
		if(soc.getSecretary()!=null){
			label.setText(soc.getSecretary().getStudent().getName());
		}
		label.setBounds(978, 114, 142, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel();
		if(soc.getVicePresident()!=null){
			label_1.setText(soc.getVicePresident().getStudent().getName());
		}
		label_1.setBounds(978, 139, 142, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel();
		if(soc.getTreasurer()!=null){
			label_2.setText(soc.getTreasurer().getStudent().getName());
		}
		label_2.setBounds(978, 164, 142, 14);
		contentPane.add(label_2);
		
		JLabel lblBoardMembers = new JLabel("Board Members");
		lblBoardMembers.setHorizontalAlignment(SwingConstants.CENTER);
		lblBoardMembers.setBounds(915, 56, 115, 14);
		contentPane.add(lblBoardMembers);
		
		JLabel label_3 = new JLabel("Vice President:");
		label_3.setHorizontalAlignment(SwingConstants.TRAILING);
		label_3.setBounds(864, 114, 86, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Secretary:");
		label_4.setHorizontalAlignment(SwingConstants.TRAILING);
		label_4.setBounds(874, 139, 76, 14);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Treasurer:");
		label_5.setHorizontalAlignment(SwingConstants.TRAILING);
		label_5.setBounds(884, 164, 66, 14);
		contentPane.add(label_5);
		
		JLabel lblPresident = new JLabel("President:");
		lblPresident.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPresident.setBounds(884, 89, 66, 14);
		contentPane.add(lblPresident);
		


		

		
		btnElections.addActionListener(new ActionListener()
		{
		 public void actionPerformed(ActionEvent e)
		 	
		{
		      

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							elections frame = new elections(acc,soc);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
		      dispose();


		   

		}
		 });
		
	    societies = new SocietyInventory();
		societies=hold;
	    societies.saveSocieties();
		

		}
	}

