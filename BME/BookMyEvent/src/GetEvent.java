import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class GetEvent extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3018938171248340198L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JButton okButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GetEvent dialog = new GetEvent();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GetEvent() {
		setTitle("Enter the event ID");
		setBounds(100, 100, 450, 227);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 191, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(getParent());
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Event ID: ");
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setBounds(92, 47, 81, 22);
			contentPanel.add(lblNewLabel);
		}
		{
			textField = new JTextField();
			textField.setBounds(205, 47, 134, 27);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(0, 191, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnNewButton = new JButton("CANCEL");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						AdminPage A = new AdminPage();
						A.setVisible(true);
						setVisible(false);
					}
				});
				btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
				buttonPane.add(btnNewButton);
			}
			{
				okButton = new JButton("OK");
				okButton.setFont(new Font("Tahoma", Font.BOLD, 18));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.valueOf(textField.getText());
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = null;
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyevent","root","qwerty");
					ResultSet rs;
					int evId[] = new int[10];
					int i=0;
					boolean f=false;
					PreparedStatement pt0 = conn.prepareStatement("select Event_id from organizes where Name=(select Name from club where Admin_id=(select Admin_id from admin where Email=?))");
					pt0.setString(1, AdminLogin.textField.getText());
					if((rs = pt0.executeQuery()) != null) {
						while(rs.next()) {
							evId[i] = rs.getInt("Event_id");
							i++;
						}
					}
					for(i=0;i<evId.length;i++) {
						if(id==evId[i]) {
							f=true;
							break;
						}
					}
					if(f) {
						PreparedStatement pt = conn.prepareStatement("select * from event where Event_id=?");
						pt.setInt(1, id);
						if(pt.executeQuery() == null) {
							JOptionPane.showMessageDialog(GetEvent.this, "Invalid ID", "Error", JOptionPane.ERROR_MESSAGE); 
						}
						else {
							ModifyEvent frame = new ModifyEvent(id);
							frame.setVisible(true);
							setVisible(false);
						}
					}
					else {
						JOptionPane.showMessageDialog(GetEvent.this, "Cannot modify the mentioned event!", "Access Denied", JOptionPane.ERROR_MESSAGE);
					}
				}catch(ClassNotFoundException | SQLException c) {
					c.printStackTrace();
				}				
			}
		});
	}

}
