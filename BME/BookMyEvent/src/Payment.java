import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Payment extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment frame = new Payment();
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
	public Payment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 597);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 220, 220));
		panel.setBounds(0, 0, 932, 77);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblPayThroughCard = new JLabel("Pay Through Card");
		lblPayThroughCard.setBackground(new Color(0, 0, 0));
		lblPayThroughCard.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 30));
		lblPayThroughCard.setForeground(new Color(0, 0, 0));
		lblPayThroughCard.setHorizontalAlignment(SwingConstants.CENTER);
		lblPayThroughCard.setBounds(320, 13, 290, 29);
		panel.add(lblPayThroughCard);
		
		JLabel lblSelectCardType = new JLabel("Select Card type:");
		lblSelectCardType.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblSelectCardType.setForeground(Color.WHITE);
		lblSelectCardType.setBounds(34, 105, 157, 24);
		contentPane.add(lblSelectCardType);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Credit Card");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setForeground(new Color(255, 255, 255));
		rdbtnNewRadioButton.setFont(new Font("Times New Roman", Font.BOLD, 21));
		rdbtnNewRadioButton.setBackground(new Color(30, 144, 255));
		rdbtnNewRadioButton.setBounds(34, 138, 141, 25);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Debit Card");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setForeground(new Color(255, 255, 255));
		rdbtnNewRadioButton_1.setFont(new Font("Times New Roman", Font.BOLD, 21));
		rdbtnNewRadioButton_1.setBackground(new Color(30, 144, 255));
		rdbtnNewRadioButton_1.setBounds(231, 138, 127, 25);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JLabel lblEnterCardDetails = new JLabel("Enter Card Details:");
		lblEnterCardDetails.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lblEnterCardDetails.setForeground(new Color(255, 255, 255));
		lblEnterCardDetails.setBounds(34, 212, 182, 24);
		contentPane.add(lblEnterCardDetails);
		
		JLabel lblNewLabel = new JLabel("Card Number:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(49, 268, 127, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name On the Card:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(494, 272, 166, 17);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Expiry Date:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(49, 346, 126, 22);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CVV:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBounds(604, 349, 56, 16);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(206, 268, 182, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(686, 267, 182, 30);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(206, 347, 182, 30);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(686, 347, 182, 30);
		contentPane.add(textField_3);
		
		JButton btnNewButton_1 = new JButton("DONE");
		btnNewButton_1.setBackground(new Color(230, 230, 250));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=null;
				    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyevent","root","qwerty"); 
				    String type=rdbtnNewRadioButton.getText();
				    if(rdbtnNewRadioButton_1.isSelected())
				    	type=rdbtnNewRadioButton_1.getText();
				    if(type.equals(""))
				    	JOptionPane.showMessageDialog(null,"Type cannot be empty");
				    String cnum=textField.getText();
				    if(cnum.equals(""))
				    	JOptionPane.showMessageDialog(null,"Card number cannot be empty");
				    String cname=textField_1.getText();
				    if (cname.equals(""))
				    	JOptionPane.showMessageDialog(null,"name cannot be empty");
				    String date=textField_2.getText();
				    if (date.equals(""))
				    	JOptionPane.showMessageDialog(null,"date cannot be empty");
				    String cvv=textField_3.getText();
				    if (cvv.equals(""))
				    	JOptionPane.showMessageDialog(null,"cvv cannot be empty");
				    PreparedStatement p1;
				    String query="insert into card_details(card_type,cardnum,namecard,expiry,cvv) values(?,?,?,?,?)";
				    p1=conn.prepareStatement(query);
				    p1.setString(1,type);
				    p1.setString(2, cnum);
				    p1.setString(3, cname);
				    p1.setString(4, date);
				    p1.setString(5, cvv);
				    if(p1.executeUpdate()!=0)
				    	JOptionPane.showMessageDialog(null,"Successful");
				    setVisible(false);
				}
				catch(ClassNotFoundException | SQLException c) {
					c.printStackTrace();
					JOptionPane.showMessageDialog(null,"Check all the details");
				}				
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_1.setBounds(411, 481, 97, 34);
		contentPane.add(btnNewButton_1);
	}
}
