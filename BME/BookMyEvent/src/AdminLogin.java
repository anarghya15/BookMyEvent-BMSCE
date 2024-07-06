import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AdminLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3685878676026090874L;
	private JPanel contentPane;
	static JTextField textField;
	private JPasswordField passwordField;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AdminLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 813, 531);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(220, 220, 220));
		panel.setBounds(0, 0, 795, 83);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAdminLogin = new JLabel("ADMIN LOGIN");
		lblAdminLogin.setBackground(new Color(255, 255, 255));
		lblAdminLogin.setForeground(new Color(0, 0, 0));
		lblAdminLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminLogin.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 30));
		lblAdminLogin.setBounds(275, 13, 242, 37);
		panel.add(lblAdminLogin);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\Apps\\My Workspace\\BookMyEvent\\images\\image1.jpg"));
		lblNewLabel.setBounds(0, 0, 94, 83);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(30, 144, 255));
		panel_1.setBounds(228, 128, 319, 270);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblEmail.setBounds(12, 13, 56, 16);
		panel_1.add(lblEmail);
		
		textField = new JTextField();
		textField.setBounds(12, 40, 283, 34);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPassword.setBounds(12, 108, 89, 16);
		panel_1.add(lblPassword);
		passwordField = new JPasswordField();
		passwordField.setBounds(12, 137, 283, 30);
		panel_1.add(passwordField);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=null;
				    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyevent","root","qwerty");
				    PreparedStatement pt;
				    ResultSet rs;
				    String mail=textField.getText();
				    String psw=String.valueOf(passwordField.getPassword());
				    String query="select * from admin where Email=? AND Login_psw=?";
				    pt=conn.prepareStatement(query);
				    pt.setString(1,mail);
				    pt.setString(2,psw);
				    rs=pt.executeQuery();
				    if (rs.next()) {
				    	JOptionPane.showMessageDialog(AdminLogin.this,"Login successfull");
				    	AdminPage adframe = new AdminPage();
				    	adframe.setVisible(true);
				    	setVisible(false);
				    }
				    else {
				    	JOptionPane.showMessageDialog(AdminLogin.this,"Invalid username/password","Login error",2);				    	
				    }
				}
				catch(ClassNotFoundException | SQLException c) {
					c.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(50, 205, 50));
		btnNewButton.setBounds(12, 225, 106, 30);
		panel_1.add(btnNewButton);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Homepage h = new Homepage();
				h.setVisible(true);
				setVisible(false);
			}
		});
		btnCancel.setForeground(new Color(255, 255, 255));
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnCancel.setBackground(new Color(255, 0, 0));
		btnCancel.setBounds(181, 225, 114, 30);
		panel_1.add(btnCancel);
		
		
	}
}
