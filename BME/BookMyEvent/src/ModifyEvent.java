import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;

public class ModifyEvent extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1933125796303574288L;
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
	private int eventId;
	private int cid1,cid2;
	private JTextField textField_11;
	private JTextField textField_12;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					//ModifyEvent frame = new ModifyEvent();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ModifyEvent(int id) {
		eventId = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(80, 10, 1200, 1010);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 220, 220));
		panel.setBounds(0, 0, 1182, 82);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MODIFY EXISTING EVENT");
		lblNewLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 34));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(366, 13, 463, 43);
		panel.add(lblNewLabel);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(436, 84, 1, 1);
		panel.add(layeredPane);
		
		JLabel label = new JLabel("Event ID: ");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(89, 136, 88, 27);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(193, 138, 227, 30);
		contentPane.add(textField);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(653, 136, 88, 27);
		contentPane.add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(757, 138, 227, 30);
		contentPane.add(textField_1);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDate.setBounds(89, 222, 88, 27);
		contentPane.add(lblDate);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(193, 224, 227, 30);
		contentPane.add(textField_2);
//		textField.setText("yyyy-mm-dd");
//		textField_2.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				textField_2.setText("");
//			}
//		});
		
		JLabel lblVenue = new JLabel("Venue: ");
		lblVenue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVenue.setForeground(Color.WHITE);
		lblVenue.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVenue.setBounds(653, 220, 88, 27);
		contentPane.add(lblVenue);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(757, 222, 227, 27);
		contentPane.add(textField_3);
		
		JLabel lblTime = new JLabel("Time: ");
		lblTime.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTime.setForeground(Color.WHITE);
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTime.setBounds(89, 299, 88, 27);
		contentPane.add(lblTime);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_4.setColumns(10);
		textField_4.setBounds(193, 301, 227, 34);
		contentPane.add(textField_4);
		
		JLabel lblResourcePerson = new JLabel("Resource Person: ");
		lblResourcePerson.setHorizontalAlignment(SwingConstants.RIGHT);
		lblResourcePerson.setForeground(Color.WHITE);
		lblResourcePerson.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblResourcePerson.setBounds(592, 297, 149, 27);
		contentPane.add(lblResourcePerson);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_5.setColumns(10);
		textField_5.setBounds(757, 299, 227, 30);
		contentPane.add(textField_5);
		
		JLabel lblFee = new JLabel("Fee: ");
		lblFee.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFee.setForeground(Color.WHITE);
		lblFee.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFee.setBounds(653, 392, 88, 27);
		contentPane.add(lblFee);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_6.setColumns(10);
		textField_6.setBounds(757, 394, 227, 34);
		contentPane.add(textField_6);
		
		JLabel label_7 = new JLabel("Rules: ");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_7.setBounds(89, 392, 88, 27);
		contentPane.add(label_7);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textArea.setBounds(193, 396, 350, 129);
		contentPane.add(textArea);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(220, 220, 220));
		panel_1.setBounds(0, 597, 1182, 52);
		contentPane.add(panel_1);
		
		JLabel lblModifyCoordinatorDetails = new JLabel("Modify Co-ordinator Details");
		lblModifyCoordinatorDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblModifyCoordinatorDetails.setFont(new Font("MS UI Gothic", Font.BOLD, 28));
		lblModifyCoordinatorDetails.setBounds(397, 13, 392, 29);
		panel_1.add(lblModifyCoordinatorDetails);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(508, 702, 200, 27);
		contentPane.add(textField_7);
		
		JLabel label_1 = new JLabel("Name:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(408, 702, 88, 27);
		contentPane.add(label_1);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(894, 704, 200, 27);
		contentPane.add(textField_8);
		
		JLabel lblContactNo = new JLabel("Contact No: ");
		lblContactNo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContactNo.setForeground(Color.WHITE);
		lblContactNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContactNo.setBounds(773, 702, 109, 27);
		contentPane.add(lblContactNo);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(508, 793, 200, 27);
		contentPane.add(textField_9);
		
		JLabel label_3 = new JLabel("Name:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_3.setBounds(408, 793, 88, 27);
		contentPane.add(label_3);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(894, 795, 200, 27);
		contentPane.add(textField_10);
		
		JLabel lblContactNo_1 = new JLabel("Contact No: ");
		lblContactNo_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContactNo_1.setForeground(Color.WHITE);
		lblContactNo_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContactNo_1.setBounds(773, 793, 109, 27);
		contentPane.add(lblContactNo_1);
		
		JButton btnModify = new JButton("MODIFY");
		btnModify.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnModify.setBackground(new Color(50, 205, 50));
		btnModify.setBounds(402, 899, 140, 34);
		contentPane.add(btnModify);
		
		JButton button_1 = new JButton("BACK");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPage A = new AdminPage();
				A.setVisible(true);
				setVisible(false);
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		button_1.setBackground(Color.RED);
		button_1.setBounds(645, 899, 132, 34);
		contentPane.add(button_1);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(154, 702, 200, 27);
		contentPane.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(154, 793, 200, 27);
		contentPane.add(textField_12);
		
		JLabel lblId = new JLabel("ID: ");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblId.setBounds(54, 702, 88, 27);
		contentPane.add(lblId);
		
		JLabel lblId_1 = new JLabel("ID: ");
		lblId_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId_1.setForeground(Color.WHITE);
		lblId_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblId_1.setBounds(54, 791, 88, 27);
		contentPane.add(lblId_1);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = null;
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyevent","root","qwerty");
			PreparedStatement pt,pt2;
			pt = conn.prepareStatement("select * from event where Event_id=?");
			pt2 = conn.prepareStatement("select * from coordinator where CID=(select CID from organizes where Event_id=?)");
			pt.setInt(1, eventId);
			pt2.setInt(1, eventId);
			ResultSet rs1 = pt.executeQuery();
			ResultSet rs2 = pt2.executeQuery();
			while(rs1.next()) {
				textField.setText(rs1.getString("Event_id"));
				textField_1.setText(rs1.getString("Event_name"));
				textField_2.setText(String.valueOf(rs1.getDate("Date")));
				textField_3.setText(rs1.getString("Venue"));
				textField_4.setText(rs1.getString("Time"));
				textField_5.setText(rs1.getString("Resource_person"));
				textField_6.setText(String.valueOf(rs1.getDouble("Fee")));
				textArea.setText(rs1.getString("rules"));
			}
			rs2.next();
			textField_11.setText(String.valueOf(rs2.getInt("CID")));
			textField_7.setText(rs2.getString("CName"));
			textField_8.setText(rs2.getString("CPhone"));
			
			
			if(rs2.next()) {
				textField_12.setText(String.valueOf(rs2.getInt("CID")));
				textField_9.setText(rs2.getString("CName"));
				textField_10.setText(rs2.getString("CPhone"));
			}
			 cid1 = Integer.valueOf(textField_11.getText());
			 //cid2 = Integer.valueOf(textField_12.getText());
			
		}catch(ClassNotFoundException | SQLException c) {
			JOptionPane.showMessageDialog(ModifyEvent.this, "Could not load details", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean flag = true;
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = null;
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyevent","root","qwerty");
					String q1,q2;
					PreparedStatement pt1,pt2;
					q1 = "update event set Event_id=?, Event_name=?, Date=?, Venue=?, Time=?, Resource_person=?, rules=?, Fee=? where Event_id=?";
					q2 = "update coordinator set CID=?,CName=?,CPhone=? where CID=?";
//					q3 = "select Name from club where Admin_id=(select Admin_id from admin where Email=?)";
//					q4 = "update organizes set CID=?,Name=?,Event_id=? where Event_id=?";
					pt1 = conn.prepareStatement(q1);
					pt2 = conn.prepareStatement(q2);
//					pt3 = conn.prepareStatement(q3);
//					pt4 = conn.prepareStatement(q4);
										
					int eId = Integer.valueOf(textField.getText());
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
				    String f = textField_6.getText();
				    if(f.equals("")) {
				    	JOptionPane.showMessageDialog(null,"Time of event cannot be empty");
				   		flag=false;
				    }	
				    String resper = textField_5.getText();
				    double fee = Double.valueOf(textField_6.getText());
				    String rules = textArea.getText();
				    String cname1 = textField_7.getText();
				    String cphone1 = textField_8.getText();
				    String cname2 = textField_9.getText();
				    String cphone2 = textField_10.getText();
				    int c1 = Integer.valueOf(textField_11.getText());
					//int c2 = Integer.valueOf(textField_12.getText());
				    
				    if(cname1.equals("")) {
				    	JOptionPane.showMessageDialog(ModifyEvent.this, "Each event must have at least 1 coordinator", "Error", JOptionPane.ERROR_MESSAGE);
				    }
				    else {
				    	pt1.setInt(1, eId);
					    pt1.setString(2, name);
					    pt1.setDate(3, date);
					    pt1.setString(4, venue);
					    pt1.setTime(5, time);
					    pt1.setDouble(8, fee);
					    pt1.setString(7, rules);
					    pt1.setString(6, resper);
					    pt1.setInt(9, eventId);
					    
					    pt2.setInt(1, c1);
					    pt2.setString(2, cname1);
					    pt2.setString(3, cphone1);
					    pt2.setInt(4, cid1);
					    
//					    pt3.setString(1, AdminLogin.textField.getText());
//					    if((rs1 = pt3.executeQuery())!=null) {
//					    	rs1.next();
//					    	String clubname = rs1.getString("Name");
//					    	
//					    	pt4.setInt(1, c1);
//					    	pt4.setString(2, clubname);
//					    	pt4.setInt(3, eId);
//					    	pt4.setInt(4, eId);					    	
//					    }
					    if((pt1.executeUpdate()!=0)&&(pt2.executeUpdate()!=0)) {
//					    	if(!(textField_11.getText()).equals("")) {
//					    		pt2.setInt(1, c2);
//							    pt2.setString(2, cname2);
//							    pt2.setString(3, cphone2);
//							    pt2.setInt(4, cid2);
//							    pt2.executeUpdate();
//					    	}
					    	JOptionPane.showMessageDialog(ModifyEvent.this, "Event updated successfully");
					    	AdminPage A = new AdminPage();
					    	A.setVisible(true);
					    	setVisible(false);
					    }
				    }					   
				}catch(ClassNotFoundException | SQLException c) {
					JOptionPane.showMessageDialog(ModifyEvent.this, "Could not update", "Error", JOptionPane.ERROR_MESSAGE);
					c.printStackTrace();
				}
			}
		});

		
	}
}
