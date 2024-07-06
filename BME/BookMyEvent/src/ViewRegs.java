import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

import javax.swing.border.LineBorder;

import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.awt.event.ActionEvent;

public class ViewRegs extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6847558167284034106L;
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JFileChooser fileChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewRegs frame = new ViewRegs();
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
	public ViewRegs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(80, 10, 1200, 1010);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		fileChooser = new JFileChooser();
		fileChooser.addChoosableFileFilter(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1182, 90);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VIEW REGISTRATIONS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(new Color(220, 220, 220));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(397, 13, 398, 36);
		panel.add(lblNewLabel);
		//DefaultTableModel model = new DefaultTableModel(new String[] {"USN","Name","Phone","Email id","Semester","Event Name","Paid"},0);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(61, 92, 1049, 560);
		contentPane.add(scrollPane);
		
			
		table = new JTable();
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setRowHeight(30);
		BorderLayout bl_table = new BorderLayout();
		bl_table.setVgap(5);
		bl_table.setHgap(5);
		table.setLayout(bl_table);
			
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = null;
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyevent","root","qwerty");
			PreparedStatement pt;
			ResultSet rs;
			String query = "select r.USN,Name,Phone,Email_id,Sem,Event_name,Paid from registered_student r, event e,participates_in p where r.USN=p.USN and e.Event_id=p.Event_id and p.Event_id in(select Event_id from organizes where Name=(select Name from club where Admin_id=(select Admin_id from admin where Email=?)))";
			pt=conn.prepareStatement(query);
			pt.setString(1, AdminLogin.textField.getText());
			rs=pt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			JButton btnNewButton = new JButton("SAVE");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (fileChooser.showSaveDialog(ViewRegs.this) == JFileChooser.APPROVE_OPTION) {
						try {
							File file = fileChooser.getSelectedFile();
							if(!file.exists())
								file.createNewFile();
							FileWriter fw = new FileWriter(file.getAbsoluteFile());
							BufferedWriter bw = new BufferedWriter(fw);
							for(int i =0;i<table.getRowCount();i++) {
								for(int j=0;j<table.getColumnCount();j++)
									bw.write((String.valueOf(table.getModel().getValueAt(i, j)+"\t")));
								bw.write("\n");
							}
							bw.close();
							fw.close();
							JOptionPane.showMessageDialog(ViewRegs.this, "Saved successfully");
						}catch(Exception ex) {
							JOptionPane.showMessageDialog(ViewRegs.this, "Could not save file","Error",JOptionPane.ERROR_MESSAGE);
							//ex.printStackTrace();
						}
					}
				}
			});
			btnNewButton.setBackground(new Color(50, 205, 50));
			btnNewButton.setForeground(new Color(255, 255, 255));
			btnNewButton.setBounds(406, 729, 111, 36);
			contentPane.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("BACK");
			btnNewButton_1.setForeground(new Color(255, 255, 255));
			btnNewButton_1.setBounds(646, 729, 111, 36);
			contentPane.add(btnNewButton_1);
			
			btnNewButton_1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					AdminPage A = new AdminPage();
					A.setVisible(true);
					setVisible(false);					
				}
				
			});
			
		}catch(ClassNotFoundException | SQLException c) {
			JOptionPane.showMessageDialog(ViewRegs.this, "Could not load details", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}	
}
