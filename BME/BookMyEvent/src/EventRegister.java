import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.*;
import javax.mail.*;  
import javax.mail.internet.*;  
import javax.activation.*; 

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;

public class EventRegister extends JFrame {
	private static final long serialVersionUID = 5515712890933097612L;
	public EventRegister evFrame;
	public JPanel contentPane;
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	public JTextField textField_3;
	public JRadioButton rdbtnNewRadioButton;
	public JRadioButton rdbtnNewRadioButton_1;
	public JRadioButton rdbtnNewRadioButton_2;
	public JRadioButton rdbtnNewRadioButton_3;
	public final ButtonGroup buttonGroup = new ButtonGroup();

	// Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventRegister evFrame = new EventRegister();
					evFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Create the frame.
	 public EventRegister() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(80, 10, 1200, 810);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1182, 88);
		panel.setBackground(new Color(220, 220, 220));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblRegisterForAn = new JLabel(" REGISTER FOR AN EVENT");
		lblRegisterForAn.setForeground(new Color(0, 0, 0));
		lblRegisterForAn.setBackground(new Color(255, 51, 204));
		lblRegisterForAn.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisterForAn.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 34));
		lblRegisterForAn.setBounds(359, 13, 485, 41);
		panel.add(lblRegisterForAn);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\Apps\\My Workspace\\BookMyEvent\\images\\image1.jpg"));
		lblNewLabel.setBounds(0, 0, 98, 88);
		panel.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(729, 185, 69, 22);
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField.setBounds(725, 220, 238, 32);
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("");
			}
		});
		textField.setText("Enter your full name");
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("USN:");
		lblNewLabel_1.setBounds(125, 188, 56, 16);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_1.setBounds(125, 220, 207, 32);
		textField_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_1.setText("");
			}
		});
		textField_1.setText("Enter appropriate USN");
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Email:");
		lblNewLabel_2.setBounds(124, 290, 69, 22);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setForeground(Color.WHITE);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_2.setBounds(124, 325, 304, 32);
		textField_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_2.setText("");
			}
		});
		textField_2.setText("Enter a valid email ID");
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblSemester = new JLabel("Semester:");
		lblSemester.setBounds(125, 405, 87, 22);
		lblSemester.setForeground(Color.WHITE);
		lblSemester.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(lblSemester);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("1");
		rdbtnNewRadioButton.setBounds(124, 447, 49, 25);
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		rdbtnNewRadioButton.setBackground(new Color(30, 144, 255));
		rdbtnNewRadioButton.setForeground(Color.WHITE);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("3");
		rdbtnNewRadioButton_1.setBounds(124, 491, 56, 25);
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setForeground(Color.WHITE);
		rdbtnNewRadioButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		rdbtnNewRadioButton_1.setBackground(new Color(30, 144, 255));
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("5");
		rdbtnNewRadioButton_2.setBounds(124, 536, 49, 25);
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setForeground(Color.WHITE);
		rdbtnNewRadioButton_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		rdbtnNewRadioButton_2.setBackground(new Color(30, 144, 255));
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("7");
		rdbtnNewRadioButton_3.setBounds(124, 588, 49, 25);
		buttonGroup.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setForeground(Color.WHITE);
		rdbtnNewRadioButton_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		rdbtnNewRadioButton_3.setBackground(new Color(30, 144, 255));
		contentPane.add(rdbtnNewRadioButton_3);
		
		JLabel lblNewLabel_3 = new JLabel("Contact No :");
		lblNewLabel_3.setBounds(729, 290, 119, 22);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setForeground(Color.WHITE);
		contentPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField_3.setBounds(725, 325, 243, 32);
		textField_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_3.setText("");
			}
		});
		textField_3.setText("Enter a 10 digit contact number");
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(50, 205, 50));
		btnNewButton.setBounds(417, 664, 119, 29);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("Select Event:");
		label.setBounds(728, 400, 131, 27);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Payment Method:");
		label_1.setBounds(267, 407, 162, 19);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(label_1);
		
		JRadioButton radioButton = new JRadioButton("Cash");
		radioButton.setBounds(305, 447, 77, 25);
		radioButton.setForeground(Color.WHITE);
		radioButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		radioButton.setBackground(new Color(30, 144, 255));
		contentPane.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("Card");
		radioButton_1.setBounds(305, 491, 77, 25);
		radioButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Payment pay=new Payment();
				pay.setVisible(true);
			}
		});
		radioButton_1.setForeground(Color.WHITE);
		radioButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		radioButton_1.setBackground(new Color(30, 144, 255));
		contentPane.add(radioButton_1);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setForeground(new Color(255, 255, 255));
		btnCancel.setBackground(new Color(255, 0, 0));
		btnCancel.setBounds(629, 664, 118, 28);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Homepage h2 = new Homepage();
				h2.setVisible(true);
				setVisible(false);
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(btnCancel);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		comboBox.setBounds(728, 445, 240, 32);
//		DefaultComboBoxModel eventModel = new DefaultComboBoxModel();
//		eventModel.addElement("Codigo");
//		comboBox.setModel(eventModel);
//		comboBox.setSelectedIndex(0);
//		contentPane.add(comboBox);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=null;
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyevent","root","qwerty");
			PreparedStatement p1;
			ResultSet rs;
			String event[]=new String[30];
			String qu="select Event_name from event";
			p1=c.prepareStatement(qu);
			rs=p1.executeQuery();
			int i=0;
			while(rs.next()) {
				event[i]=rs.getString("Event_name");
				 comboBox.addItem(event[i]);
				 //System.out.println(event);
				 comboBox.setVisible(true);
			}
			//comboBox.setModel((ComboBoxModel) comboBox);
			comboBox.setSelectedIndex(0);
			contentPane.add(comboBox);
			
			JLabel lblNewLabel_5 = new JLabel("If paying through card,\r\nselect card and  Fill card details first,\r\nbefore entering other details.");
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_5.setBounds(97, 93, 951, 67);
			lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 22));
			lblNewLabel_5.setForeground(Color.WHITE);
			contentPane.add(lblNewLabel_5);
			
		}
		catch(ClassNotFoundException | SQLException c) {
			c.printStackTrace();
		}
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					boolean flag=true;
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=null;
				    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyevent","root","qwerty");
				    PreparedStatement pt,ps,p3;
				    ResultSet rs;
				    int id = 1;
				    String name=textField.getText();
				    if (name.equals("")) {
				    	
				    	JOptionPane.showMessageDialog(null,"Name cannot be empty");
				    	flag=false;
				    }
				    String usn=textField_1.getText();
				    if (usn.equals("")) {
				    	JOptionPane.showMessageDialog(null,"USN cannot be empty");
				    	flag=false;
				    }
				    if(usn.length()!=10) {
				    	char ch=usn.charAt(0);
				    	int len=usn.length();
				    	for(int i=0;i<len;i++) {
				    		if(Character.isLowerCase(ch))
				    			JOptionPane.showMessageDialog(null,"USN should be in uppercase");
				    		    flag=false;
				    	}
				    	JOptionPane.showMessageDialog(null, "USN should be 10 characters");
				    	flag=false;
				    }
				    String ph=textField_3.getText();
				    if (ph.equals("")) {
				    	
				    	JOptionPane.showMessageDialog(null,"Phone number cannot be empty");
				    }
				    if (ph.length()!=10) {
				    
			    		JOptionPane.showMessageDialog(null,"Phone number should contain 10 digits.");
			    		flag=false;
				    }
				    String mail=textField_2.getText();
				    if (mail.equals("")) {
				    	JOptionPane.showMessageDialog(null,"Mail cannot be empty");
				    }
				    if ((!mail.contains("@"))|| (!mail.contains(".")))
				    	JOptionPane.showMessageDialog(null,"Enter a valid email address.");
				    String sem=rdbtnNewRadioButton.getText();
				    if(rdbtnNewRadioButton_1.isSelected())
				    	sem=rdbtnNewRadioButton_1.getText();
				    if(rdbtnNewRadioButton_2.isSelected())
				    	sem=rdbtnNewRadioButton_2.getText();
				    if(rdbtnNewRadioButton_3.isSelected())
				    	sem=rdbtnNewRadioButton_3.getText();
				    if (sem.equals("")) {
				    	JOptionPane.showMessageDialog(null,"Semester cannot be empty");
				    }
				    String pay=radioButton.getText();
				    if (pay.equals("")) {
				    	JOptionPane.showMessageDialog(null,"Payment cannot be empty");
				    }
				    if(radioButton_1.isSelected())
				    	pay="Yes";
				    else
				    	pay="No";
				    String ev=comboBox.getSelectedItem().toString();
				    if (ev.equals("")) {
				    	JOptionPane.showMessageDialog(null,"Event list cannot be empty");
				    }
//				    String check="select USN from registered_student where USN=?";
//				    p4=conn.prepareStatement(check);
//				    p4.setString(1,usn);
//				    rs2=p4.executeQuery();
//				    if (rs2!=null) {
//				    	while(rs2.next()) {
//				    		textField.setText(rs2.getString("Name"));
//				    		textField_3.setText(rs2.getString("Phone"));
//				    		textField_2.setText(rs2.getString("Email_id"));
//				    		   
				    String q = "select Name from registered_student where USN=?";
				    PreparedStatement p = conn.prepareStatement(q);
				    String qu="insert into registered_student(USN,Name,Phone,Email_id,Sem) values (?,?,?,?,?)";
				    String qu2 = "select Event_id from event where Event_name=?";
				    String qu1="insert into participates_in(USN,Event_id,Paid) values(?,?,?)";
				    
				    pt=conn.prepareStatement(qu);
				    p3=conn.prepareStatement(qu2);
				    ps=conn.prepareStatement(qu1);
				    
				    pt.setString(1,usn);
				    pt.setString(2,name);
				    pt.setString(3,ph);
				    pt.setString(4,mail);
				    pt.setString(5,sem);
				    p3.setString(1, ev);
				    rs=p3.executeQuery();
				    if(rs.next())
				    	id=rs.getInt("Event_id");
				    ps.setString(1,usn);
				    ps.setInt(2,id);
				    ps.setString(3, pay);
				    p.setString(1, usn);
				    
				    ResultSet R; 
				    R=p.executeQuery();
				    if((R.next()) == false) {
					    if ((pt.executeUpdate()) !=0 && ps.executeUpdate()!=0 && flag==true) {
					    	JOptionPane.showMessageDialog(null,"Registration successful");
					    	Homepage H = new Homepage();
					    	H.setVisible(true);
					    	setVisible(false);
					    }
				    }
					else {
						if(ps.executeUpdate()!=0 && flag==true) {
							JOptionPane.showMessageDialog(null,"Registration successful");
							Homepage H = new Homepage();
							H.setVisible(true);
							setVisible(false);
						}
					}

				    	class SendMailUsingAuthentication                                                                               
				    	{                                                                                                                                            
				    	  private static final String SMTP_HOST_NAME = "smtp.gmail.com";  // for google                
				    	  private static final String SMTP_AUTH_USER = "projectevent21@gmail.com";             // Username                        
				    	  private static final String SMTP_AUTH_PWD  = "event@2019";          // Password                     
				    	                                                                                                                                             

				    	  // Add List of Email address to who email needs to be sent to                                               
				    	  public void postMail( String recipient, String subject,                                                       
				    	                            String message , String from) throws MessagingException                          
				    	  {                                                                                                                                         
				    	    boolean debug = false;                                                                                                       
				    	     //Set the host smtp address                                                                                               
				    	     Properties props = new Properties();                                                                                
				    	      props.put("mail.smtp.starttls.enable","true");                                                                     
				    	     props.put("mail.smtp.host", SMTP_HOST_NAME);                                                        
				    	     props.put("mail.smtp.auth", "true");                                                                                    

				    	    Authenticator auth = new SMTPAuthenticator();                                                                
				    	    Session session = Session.getDefaultInstance(props, auth);                                                 

				    	    session.setDebug(debug);                                                                                                  

				    	    // create a message                                                                                                            
				    	    Message msg = new MimeMessage(session);                                                                    

				    	    // set the from and to address                                                                                            
				    	    InternetAddress addressFrom = new InternetAddress(from);                                             
				    	    msg.setFrom(addressFrom);                                                                                             

				    	    InternetAddress addressTo = new InternetAddress(recipient);                             
				    	                                                                                                                          
				    	    msg.setRecipient(Message.RecipientType.TO, addressTo);                                             
				    	    // Setting the Subject and Content Type                                                                            
				    	    msg.setSubject(subject);                                                                                                  
				    	    msg.setContent(message, "text/plain");                                                                              
				    	    Transport.send(msg);                                                                                                       
				    	 }                                                                                                                                        


				    	/**                                                                                                                                      
				    	* SimpleAuthenticator is used to do simple authentication                                                     
				    	* when the SMTP server requires it.                                                                                    
				    	*/                                                                                                                                        
				    	class SMTPAuthenticator extends javax.mail.Authenticator                                        
				    	{                                                                                                                                          

				    	        @Override                                                                                                                   
				    	    public PasswordAuthentication getPasswordAuthentication()                                             
				    	    {                                                                                                                                      
				    	        String username = SMTP_AUTH_USER;                                                                    
				    	        String password = SMTP_AUTH_PWD;                                                                     
				    	        return new PasswordAuthentication(username, password);                                             
				    	    }                                                                                                                                       
				    	} 
				    	}
				    	String emailMsgTxt = "You have successfully registered for the event:"+ev;
				        String emailSubjectTxt = "Event registration";
				       String emailFromAddress = SendMailUsingAuthentication.SMTP_AUTH_USER;
				       String emailReceipeint=textField_2.getText();
				       SendMailUsingAuthentication smtpMailSender = new SendMailUsingAuthentication();
				        try {
				            smtpMailSender.postMail(emailReceipeint, emailSubjectTxt, emailMsgTxt, emailFromAddress);
				            System.out.println("Sucessfully Sent mail to registered student");
				        } catch (MessagingException ex) {
//				            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
				        	System.out.println("Cannot send email");
				        }
				        
				    	//JOptionPane.showMessageDialog(null,"Registration failed","Registration unsuccessfull",2);
				    
				}
				catch(ClassNotFoundException | SQLException c) {
					c.printStackTrace();
					JOptionPane.showMessageDialog(null,"Check all the details","Registration unsuccessfull",2);
				}
			}
		});
		
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String usn = textField_1.getText();
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = null;
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyevent","root","qwerty");
					PreparedStatement pt = conn.prepareStatement("select * from registered_student where USN=?");
					ResultSet rs;
					pt.setString(1,usn);
				    rs=pt.executeQuery();
				    if (rs !=null) {
				    	while(rs.next()) {
				    		textField.setText(rs.getString("Name"));
				    		textField_3.setText(rs.getString("Phone"));
				    		textField_2.setText(rs.getString("Email_id"));
				    		String sem = String.valueOf(rs.getInt("Sem"));
				    		if(sem.equals("1"))
				    			rdbtnNewRadioButton.setSelected(true);
				    		else if(sem.equals("3"))
				    			rdbtnNewRadioButton_1.setSelected(true);
				    		else if(sem.equals("5"))
				    			rdbtnNewRadioButton_2.setSelected(true);
				    		else if(sem.equals("7"))
				    			rdbtnNewRadioButton_3.setSelected(true);
				    	}
				    }
				}catch(ClassNotFoundException | SQLException c) {
					JOptionPane.showMessageDialog(EventRegister.this, "Could not load details", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});		
	}
}
