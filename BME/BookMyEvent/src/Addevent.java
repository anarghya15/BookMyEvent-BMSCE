import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Addevent extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9153644219160813208L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addevent frame = new Addevent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Addevent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(80, 10, 1200, 1010);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1182, 63);
		panel.setBackground(new Color(220, 220, 220));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD AN EVENT");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 30));
		lblNewLabel.setBounds(432, 13, 351, 45);
		panel.add(lblNewLabel);
		
		JLabel lblEventId = new JLabel("Event ID: ");
		lblEventId.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblEventId.setForeground(Color.WHITE);
		lblEventId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEventId.setBounds(75, 135, 88, 27);
		contentPane.add(lblEventId);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(179, 137, 200, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Event Name: ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(691, 135, 114, 27);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setBounds(814, 138, 200, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Date:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2.setBounds(75, 220, 88, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Venue:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_3.setBounds(703, 223, 96, 20);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setText("yyyy-mm-dd");
		textField_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_2.setText("");
			}
		});
		textField_2.setBounds(179, 224, 200, 30);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(814, 224, 200, 30);
		contentPane.add(textField_3);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTime.setForeground(Color.WHITE);
		lblTime.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTime.setBounds(75, 321, 88, 27);
		contentPane.add(lblTime);
		
		JLabel lblPerson = new JLabel("Resource Person: ");
		lblPerson.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPerson.setForeground(Color.WHITE);
		lblPerson.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPerson.setBounds(636, 321, 169, 27);
		contentPane.add(lblPerson);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_4.setColumns(10);
		textField_4.setBounds(179, 323, 200, 30);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_5.setColumns(10);
		textField_5.setBounds(814, 323, 200, 30);
		contentPane.add(textField_5);
		
		JLabel lblRules = new JLabel("Rules: ");
		lblRules.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRules.setForeground(Color.WHITE);
		lblRules.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblRules.setBounds(75, 402, 88, 27);
		contentPane.add(lblRules);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textArea.setBounds(179, 406, 350, 129);
		contentPane.add(textArea);
		
		JLabel lblFee = new JLabel("Fee:");
		lblFee.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFee.setForeground(Color.WHITE);
		lblFee.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblFee.setBounds(679, 402, 114, 27);
		contentPane.add(lblFee);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_6.setColumns(10);
		textField_6.setBounds(814, 406, 200, 30);
		contentPane.add(textField_6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(220, 220, 220));
		panel_1.setBounds(0, 579, 1182, 52);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblAddCoordinators = new JLabel("Add Co-ordinator Details");
		lblAddCoordinators.setBounds(395, 13, 396, 29);
		lblAddCoordinators.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddCoordinators.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 28));
		panel_1.add(lblAddCoordinators);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblName.setBounds(387, 688, 88, 27);
		contentPane.add(lblName);
		
		JLabel lblContactNo = new JLabel("Contact No: ");
		lblContactNo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContactNo.setForeground(Color.WHITE);
		lblContactNo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblContactNo.setBounds(755, 688, 114, 27);
		contentPane.add(lblContactNo);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_7.setColumns(10);
		textField_7.setBounds(506, 689, 200, 27);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_8.setColumns(10);
		textField_8.setBounds(506, 780, 200, 27);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_9.setColumns(10);
		textField_9.setBounds(891, 689, 200, 27);
		contentPane.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_10.setColumns(10);
		textField_10.setBounds(891, 780, 200, 27);
		contentPane.add(textField_10);
		
		JLabel label = new JLabel("Name:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Times New Roman", Font.BOLD, 18));
		label.setBounds(387, 779, 88, 27);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Contact No: ");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		label_1.setBounds(755, 779, 114, 27);
		contentPane.add(label_1);
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_11.setColumns(10);
		textField_11.setBounds(148, 689, 200, 27);
		contentPane.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_12.setColumns(10);
		textField_12.setBounds(148, 780, 200, 27);
		contentPane.add(textField_12);
		
		JLabel lblId = new JLabel("ID: ");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblId.setBounds(48, 688, 88, 27);
		contentPane.add(lblId);
		
		JLabel label_2 = new JLabel("ID: ");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		label_2.setBounds(48, 785, 88, 27);
		contentPane.add(label_2);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean flag = true;
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = null;
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyevent","root","qwerty");
					String q1,q2,q3,q4,q5;
				    PreparedStatement pt1,pt2,pt3,pt4,pt5;
				    ResultSet rs;
				    String clubname;
				    q1 = "insert into event(Event_id,Event_name,Date,Venue,Time,Fee,rules,Resource_person) values(?,?,?,?,?,?,?,?)";
				    q2 = "insert into coordinator(CID,CName,CPhone) values(?,?,?)";
				    q3 = "select * from coordinator where CID=?";
				    q4 = "select Name from club where Admin_id=(select Admin_id from admin where Email=?)";
				    q5 = "insert into organizes(CID,Name,Event_id) values(?,?,?)";
				    int event_id = Integer.valueOf(textField.getText());
				    PreparedStatement pt0 = conn.prepareStatement("select * from event where Event_id=?");
				    pt0.setInt(1, event_id);
				    rs = pt0.executeQuery();
				    if(rs.next() == true)				    
				    	JOptionPane.showMessageDialog(Addevent.this, "Event already exists", "Error", JOptionPane.ERROR_MESSAGE);			    
				    else {
					    String name = textField_1.getText();
					    if (name.equals("")) {
					    	
					    	JOptionPane.showMessageDialog(null,"Name cannot be empty");
					    	flag=false;
					    }
					    String venue = textField_3.getText();
					    if (venue.equals("")) {					    	
					   		JOptionPane.showMessageDialog(null,"Venue cannot be empty");
					   		flag=false;
					   	}
					    String d = textField_2.getText();					    
					    if (d.equals("")) {					    	
				    		JOptionPane.showMessageDialog(null,"Date cannot be empty");
				    		flag=false;
				    	}
					    Date date = Date.valueOf(textField_2.getText());
					    String t = textField_4.getText();					    	
					    if (t.equals("")) {					    	
					   		JOptionPane.showMessageDialog(null,"Time of event cannot be empty");
					   		flag=false;
					   	}
					    Time time = Time.valueOf(textField_4.getText());
					    String resper = textField_5.getText();
					    String f = textField_6.getText();
					    if(f.equals("")) {
					    	JOptionPane.showMessageDialog(null,"Time of event cannot be empty");
					   		flag=false;
					    }
					    double fee = Double.valueOf(textField_6.getText());
					    String rules = textArea.getText();
					    int cid = Integer.valueOf(textField_11.getText());
					    String cname = textField_7.getText();
					    String cphone = textField_9.getText();
					    pt1 = conn.prepareStatement(q1);
					    pt2 = conn.prepareStatement(q2);
					    pt3 = conn.prepareStatement(q3);
					    pt4 = conn.prepareStatement(q4);
					    pt5 = conn.prepareStatement(q5);
					    
					    if(cname.equals("")) {
					    	JOptionPane.showMessageDialog(Addevent.this, "Each event must have at least 1 coordinator", "Error", JOptionPane.ERROR_MESSAGE);
					    	flag=false;
					    }
					    else {
					   
					    pt1.setInt(1, event_id);
					    pt1.setString(2, name);
					    pt1.setDate(3, date);
					    pt1.setString(4, venue);
					    pt1.setTime(5, time);
					    pt1.setDouble(6, fee);
					    pt1.setString(7, rules);
					    pt1.setString(8, resper);					    
					    
					    if((pt1.executeUpdate()) !=0 && flag==true) {
					    	pt1.close();
					    	pt3.setInt(1,cid);
					    	if((rs = pt3.executeQuery()) == null) {
					    		pt3.close();
					    		pt2.setInt(1, cid);
							    pt2.setString(2, cname);
							    pt2.setString(3, cphone);
					    		if((pt2.executeUpdate())!=0)
									pt2.close();
					    	}
					    	pt4.setString(1, AdminLogin.textField.getText());
							if((rs = pt4.executeQuery())!=null) {
								rs.next();
								clubname = rs.getString("Name");
								pt4.close();
								pt5.setInt(1, cid);
								pt5.setString(2, clubname);
								pt5.setInt(3, event_id);
								if((pt5.executeUpdate()) !=0 && flag==true) {
									String c2 = textField_8.getText();
									if(!(c2.equals(""))) {
										int cid2 = Integer.valueOf(textField_12.getText());
										String cname2 = textField_8.getText();
										String cphone2 = textField_10.getText();
										pt2 = conn.prepareStatement(q2);
										pt2.setInt(1, cid2);
										pt2.setString(2,cname2);
										pt2.setString(3, cphone2);
										pt3 = conn.prepareStatement(q3);
										pt3.setInt(1, cid2);
										rs = pt3.executeQuery();
										if(rs != null) {
											pt3.close();
									    	if((pt2.executeUpdate())!=0 && flag == true)
												pt2.close();
										}
										pt5.setInt(1,cid2);
										pt5.setString(2, clubname);
										pt5.setInt(3, event_id);
										if((pt5.executeUpdate())!=0 && flag==true) {
											System.out.println("Added 2 coordinators");
											pt5.close();
										}
									}
									JOptionPane.showMessageDialog(Addevent.this,"Event added");
								}				    		
							}
					    }
					 					    
				    }}
				}catch(ClassNotFoundException | SQLException c) {
					JOptionPane.showMessageDialog(Addevent.this, "Could not add the event", "Error", JOptionPane.ERROR_MESSAGE);
					c.printStackTrace();
				}
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAdd.setBackground(new Color(50, 205, 50));
		btnAdd.setBounds(389, 897, 140, 34);
		contentPane.add(btnAdd);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPage A = new AdminPage();
				A.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBackground(new Color(255, 0, 0));
		btnBack.setBounds(632, 897, 132, 34);
		contentPane.add(btnBack);
		
		
	}
}
