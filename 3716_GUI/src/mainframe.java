import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JLayeredPane;
import javax.swing.JPasswordField;

public class mainframe extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JTextField txtName;
	private JTextField txtNum;
	private JTextField txtDob;
	private JTextField txtUname;
	private JTextField txtPwd;
	private JLabel lblName;
	private JLabel lblStudent;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnRegister;
    AccountInventory accounts = new AccountInventory();
    SocietyInventory societies = new SocietyInventory();
    Account user = null;
    private JTextField regInfo;
    private JPasswordField logPass;


	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
	}*/

	/**
	 * Create the frame.
	 */
	public mainframe() {
		setTitle("Please login or register");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 659, 404);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnTest = new JButton("Login");
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnTest.setBounds(137, 202, 89, 23);
		contentPane.add(btnTest);
		
		
		btnTest.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			    societies.loadSocieties();
			    societies.saveSocieties();
			    accounts.loadAccounts();
			    accounts.saveAccounts();
		   System.out.println("Please login in to continue");
           System.out.println("login: ");
           String username = txtUsername.getText();
           System.out.print("password: ");
           char[] pass = logPass.getPassword();
           String password = new String(pass);
           

           int i = accounts.login(username, password);
           if (i != -1) {
              user = accounts.getAccounts().get(i);
              dispose();
           }
		  }
		  
		});
		
		txtUsername = new JTextField();
		txtUsername.setBounds(137, 142, 86, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		lblUsername = new JLabel("Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.TRAILING);
		lblUsername.setBounds(38, 145, 89, 14);
		contentPane.add(lblUsername);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPassword.setBounds(65, 174, 62, 14);
		contentPane.add(lblPassword);
		
		txtName = new JTextField();
		txtName.setBounds(434, 142, 86, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtNum = new JTextField();
		txtNum.setBounds(434, 171, 86, 20);
		contentPane.add(txtNum);
		txtNum.setColumns(10);
		
		txtDob = new JTextField();
		txtDob.setBounds(434, 203, 86, 20);
		contentPane.add(txtDob);
		txtDob.setColumns(10);
		
		txtUname = new JTextField();
		txtUname.setBounds(434, 234, 86, 20);
		contentPane.add(txtUname);
		txtUname.setColumns(10);
		
		txtPwd = new JTextField();
		txtPwd.setBounds(434, 265, 86, 20);
		contentPane.add(txtPwd);
		txtPwd.setColumns(10);
		
		lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblName.setBounds(378, 145, 46, 14);
		contentPane.add(lblName);
		
		lblStudent = new JLabel("Student#:");
		lblStudent.setHorizontalAlignment(SwingConstants.TRAILING);
		lblStudent.setBounds(354, 174, 70, 14);
		contentPane.add(lblStudent);
		
		lblNewLabel = new JLabel("DOB:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(378, 206, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setBounds(354, 237, 70, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setBounds(335, 268, 89, 14);
		contentPane.add(lblNewLabel_2);
		
		regInfo = new JTextField();
		regInfo.setBounds(354, 330, 245, 20);
		contentPane.add(regInfo);
		regInfo.setColumns(10);
		
		btnRegister = new JButton("Register");
		btnRegister.setBounds(431, 296, 89, 23);
		contentPane.add(btnRegister);

		
		btnRegister.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  System.out.println("button worked");
		      Student stu = new Student(txtName.getText(),txtNum.getText(),txtDob.getText(),"student");
		      System.out.println(stu.toString());
		      Account acc = new Account(stu,txtUname.getText(),txtPwd.getText());
		      System.out.println(acc.toString());
		      regInfo.setText("Registration complete!");
		      accounts.addAccount(acc);
			    accounts.loadAccounts();
			    accounts.saveAccounts();
			    
		  }
		});
		
		JLabel lblAlreadyAMemeber = new JLabel("Already a memeber?");
		lblAlreadyAMemeber.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlreadyAMemeber.setBounds(103, 120, 158, 14);
		contentPane.add(lblAlreadyAMemeber);
		
		JLabel lblNewToThe = new JLabel("New to the System?");
		lblNewToThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewToThe.setBounds(427, 120, 114, 14);
		contentPane.add(lblNewToThe);
		
		logPass = new JPasswordField();
		logPass.setEchoChar('*');
		logPass.setBounds(137, 171, 86, 20);
		contentPane.add(logPass);
		

	}
}
