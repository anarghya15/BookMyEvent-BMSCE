import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class contact extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					contact frame = new contact();
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
	public contact() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 667, 499);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 649, 68);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CONTACT US");
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(252, 13, 158, 50);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(30, 144, 255));
		panel_1.setBounds(0, 70, 649, 382);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JTextArea txtrContactAnyOf = new JTextArea();
		txtrContactAnyOf.setWrapStyleWord(true);
		txtrContactAnyOf.setFont(new Font("Palatino Linotype", Font.PLAIN, 20));
		txtrContactAnyOf.setText("Contact any of the numbers given below if you have any queries.\r\nHope this platform made the registering easier and comfortable \r\nfor you.\r\nContacts:\r\nAnarghya- 8167549823\r\nLalitashree - 9745237165\r\nPannaga - 8713254368");
		txtrContactAnyOf.setBounds(12, 32, 625, 249);
		panel_1.add(txtrContactAnyOf);
		
		JButton btnNewButton = new JButton("Back to Home");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Homepage hmp=new Homepage();
				hmp.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(234, 306, 156, 42);
		panel_1.add(btnNewButton);
	}
}
