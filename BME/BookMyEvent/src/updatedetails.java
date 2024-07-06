import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class updatedetails extends JFrame {

	private static final long serialVersionUID = -4029395059098499011L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updatedetails frame = new updatedetails();
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
	public updatedetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(80, 10, 949, 533);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 220, 220));
		panel.setBounds(0, 0, 1182, 87);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UPDATE REGISTRATIONS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 34));
		lblNewLabel.setBounds(263, 16, 438, 41);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Apps\\My Workspace\\BookMyEvent\\images\\image1.jpg"));
		lblNewLabel_2.setBounds(0, 0, 97, 87);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 191, 255));
		panel_1.setBounds(0, 89, 931, 397);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Enter the student USN:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_1.setBounds(197, 56, 259, 33);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(468, 59, 200, 33);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("UPDATE");
		btnNewButton.setBackground(new Color(50, 205, 50));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
				String usn=textField.getText();
				if (usn.length()!=10)
					JOptionPane.showMessageDialog(null,"USN should be 10 digits");
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn=null;
			    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyevent","root","qwerty");
			    PreparedStatement p1;
			    int rs;
			    String query="update participates_in set paid='yes' where USN=?";
			    p1=conn.prepareStatement(query);
			    p1.setString(1, usn);
			    rs=p1.executeUpdate();
			    if(rs>0) {
			    		JOptionPane.showMessageDialog(null,"Updated successfully");
			    }
				}
			    catch(ClassNotFoundException | SQLException c) {
					c.printStackTrace();
					JOptionPane.showMessageDialog(null,"Update unsucessful");
				}
				}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnNewButton.setBounds(285, 142, 129, 30);
		panel_1.add(btnNewButton);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPage A = new AdminPage();
				A.setVisible(true);
				setVisible(false);
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnCancel.setBackground(new Color(255, 0, 0));
		btnCancel.setBounds(468, 142, 137, 30);
		panel_1.add(btnCancel);
	}
}
