import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class DeleteEvent extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1136551501390162327L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteEvent frame = new DeleteEvent();
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
	public DeleteEvent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(80, 10, 1200, 810);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(220, 220, 220));
		panel.setBounds(0, 0, 1182, 82);
		contentPane.add(panel);
		
		JLabel lblRemoveAnEvent = new JLabel("REMOVE AN EVENT");
		lblRemoveAnEvent.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemoveAnEvent.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 34));
		lblRemoveAnEvent.setBounds(366, 13, 463, 43);
		panel.add(lblRemoveAnEvent);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(436, 84, 1, 1);
		panel.add(layeredPane);
		
		JLabel lblEnterEventId = new JLabel("Enter Event ID: ");
		lblEnterEventId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnterEventId.setForeground(Color.WHITE);
		lblEnterEventId.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblEnterEventId.setBounds(396, 145, 159, 27);
		contentPane.add(lblEnterEventId);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(590, 146, 200, 30);
		contentPane.add(textField);
		
		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		btnOk.setBackground(new Color(220, 220, 220));
		btnOk.setBounds(527, 215, 97, 33);
		contentPane.add(btnOk);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("MS UI Gothic", Font.BOLD, 24));
		textArea.setBounds(0, 307, 1182, 213);
		contentPane.add(textArea);
		textArea.setVisible(false);
		
		JButton btnDelete = new JButton("DELETE");
		
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDelete.setBackground(new Color(50, 205, 50));
		btnDelete.setBounds(405, 612, 140, 34);
		contentPane.add(btnDelete);
		
		JButton button_1 = new JButton("BACK");
		
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		button_1.setBackground(Color.RED);
		button_1.setBounds(648, 612, 132, 34);
		contentPane.add(button_1);
		
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setVisible(true);
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = null;
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyevent","root","qwerty");
					PreparedStatement pt;
					ResultSet rs;
					pt = conn.prepareStatement("select * from event where Event_id=?");
					pt.setInt(1, Integer.valueOf(textField.getText()));
					if((rs=pt.executeQuery()) == null) {
						JOptionPane.showMessageDialog(DeleteEvent.this, "Invalid ID", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else {
						rs.next();
						textArea.setText("Event Name: "+rs.getString("Event_name")+"\n");
						textArea.append("Date: "+String.valueOf(rs.getString("Date"))+"\n");
						textArea.append("Venue: "+ rs.getString("Venue")+"\n");
						textArea.append("Time: "+ rs.getString("Time")+"\n");
						textArea.append("Fee: "+String.valueOf(rs.getDouble("Fee"))+"\n");
						textArea.append("Rules:\n"+rs.getString("rules"));	
					}
				}catch(ClassNotFoundException | SQLException c) {
					JOptionPane.showMessageDialog(DeleteEvent.this, "Could not load details", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = null;
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyevent","root","qwerty");
					PreparedStatement pt;
					pt = conn.prepareStatement("delete from event where Event_id=?");
					pt.setInt(1, Integer.valueOf(textField.getText()));
					int action = JOptionPane.showConfirmDialog(DeleteEvent.this, "Are you sure you want to remove the event?", "Confirm", JOptionPane.YES_NO_OPTION);
					if(action == JOptionPane.YES_OPTION) {
						if(pt.executeUpdate() !=0) {
							JOptionPane.showMessageDialog(DeleteEvent.this,"Event removed Successfully");
						}
					}
				}catch(ClassNotFoundException | SQLException c) {
					JOptionPane.showMessageDialog(DeleteEvent.this, "Could not remove event!", "Error", JOptionPane.ERROR_MESSAGE);
					c.printStackTrace();
				}
			}
		});
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPage A = new AdminPage();
				A.setVisible(true);
				setVisible(false);
			}
		});
	}
}
