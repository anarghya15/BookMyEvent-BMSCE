import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AdminPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1824601485048297256L;
	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage frame = new AdminPage();
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
	public AdminPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1170, 729);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(220, 220, 220));
		panel.setBounds(0, 0, 1152, 83);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 37));
		lblNewLabel.setBounds(468, 13, 224, 41);
		panel.add(lblNewLabel);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.setForeground(new Color(255, 255, 255));
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogout.setBackground(new Color(255, 0, 0));
		btnLogout.setBounds(1030, 13, 110, 25);
		panel.add(btnLogout);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Apps\\My Workspace\\BookMyEvent\\images\\image1.jpg"));
		lblNewLabel_1.setBounds(0, 0, 95, 83);
		panel.add(lblNewLabel_1);
		
		JButton btnAddAnEvent = new JButton("   1. Add an Event");
		btnAddAnEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Addevent addEvent = new Addevent();
				addEvent.setVisible(true);
				setVisible(false);
			}
		});
		btnAddAnEvent.setHorizontalAlignment(SwingConstants.LEFT);
		btnAddAnEvent.setForeground(Color.WHITE);
		btnAddAnEvent.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnAddAnEvent.setBorder(new LineBorder(new Color(255,255,255),3));
		btnAddAnEvent.setBackground(new Color(255, 140, 0));
		btnAddAnEvent.setBounds(45, 125, 1072, 58);
		contentPane.add(btnAddAnEvent);
		
		JButton btnModifyExistingEvents = new JButton("   2. Modify Existing Events");
		btnModifyExistingEvents.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GetEvent g = new GetEvent();
				g.setVisible(true);
				setVisible(false);
			}
		});
		btnModifyExistingEvents.setHorizontalAlignment(SwingConstants.LEFT);
		btnModifyExistingEvents.setForeground(Color.WHITE);
		btnModifyExistingEvents.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnModifyExistingEvents.setBorder(new LineBorder(new Color(255,255,255),3));
		btnModifyExistingEvents.setBackground(new Color(255, 140, 0));
		btnModifyExistingEvents.setBounds(45, 232, 1072, 58);
		contentPane.add(btnModifyExistingEvents);
		
		JButton btnRemoveEvents = new JButton("   3. Remove Events");
		btnRemoveEvents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteEvent D = new DeleteEvent();
				D.setVisible(true);
				setVisible(false);
			}
		});
		btnRemoveEvents.setHorizontalAlignment(SwingConstants.LEFT);
		btnRemoveEvents.setForeground(Color.WHITE);
		btnRemoveEvents.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnRemoveEvents.setBorder(new LineBorder(new Color(255,255,255),3));
		btnRemoveEvents.setBackground(new Color(255, 140, 0));
		btnRemoveEvents.setBounds(45, 332, 1072, 58);
		contentPane.add(btnRemoveEvents);
		
		JButton btnViewRegistrations = new JButton("   4. View Registrations");
		btnViewRegistrations.setHorizontalAlignment(SwingConstants.LEFT);
		btnViewRegistrations.setForeground(Color.WHITE);
		btnViewRegistrations.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnViewRegistrations.setBorder(new LineBorder(new Color(255,255,255),3));
		btnViewRegistrations.setBackground(new Color(255, 140, 0));
		btnViewRegistrations.setBounds(45, 445, 1072, 58);
		contentPane.add(btnViewRegistrations);
		
		JButton btnUpdateRegistration = new JButton("   5. Update Registration Details");
		btnUpdateRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatedetails U = new updatedetails();
				U.setVisible(true);
				setVisible(false);
			}
		});
		btnUpdateRegistration.setHorizontalAlignment(SwingConstants.LEFT);
		btnUpdateRegistration.setForeground(Color.WHITE);
		btnUpdateRegistration.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnUpdateRegistration.setBorder(new LineBorder(new Color(255,255,255),3));
		btnUpdateRegistration.setBackground(new Color(255, 140, 0));
		btnUpdateRegistration.setBounds(45, 550, 1072, 58);
		contentPane.add(btnUpdateRegistration);
		
		btnViewRegistrations.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ViewRegs v = new ViewRegs();
				v.setVisible(true);
				setVisible(false);
			}
			
		});
		
		btnLogout.addActionListener(new ActionListener() {
						
			@Override
			public void actionPerformed(ActionEvent e) {
				Homepage H = new Homepage();
				H.setVisible(true);
				setVisible(false);
			}
		});
	}
}
