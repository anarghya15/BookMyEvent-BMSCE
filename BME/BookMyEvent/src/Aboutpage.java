import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

class Aboutpage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2333898073250999950L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aboutpage frame = new Aboutpage();
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
	public Aboutpage() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 220, 220));
		panel.setBounds(0, 0, 932, 90);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ABOUT US");
		lblNewLabel.setBackground(new Color(255, 0, 204));
		lblNewLabel.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 34));
		lblNewLabel.setBounds(390, 13, 184, 32);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Apps\\My Workspace\\BookMyEvent\\images\\image1.jpg"));
		lblNewLabel_1.setBounds(0, 0, 99, 90);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(30, 144, 255));
		panel_1.setBounds(0, 90, 932, 394);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JTextArea txtrToDesignAnd = new JTextArea();
		txtrToDesignAnd.setEditable(false);
		txtrToDesignAnd.setBounds(0, 13, 932, 381);
		panel_1.add(txtrToDesignAnd);
		txtrToDesignAnd.setLineWrap(true);
		txtrToDesignAnd.setForeground(new Color(255, 255, 255));
		txtrToDesignAnd.setBackground(new Color(30, 144, 255));
		txtrToDesignAnd.setFont(new Font("Times New Roman", Font.BOLD, 24));
		txtrToDesignAnd.setText(" Hey folks! Welcome to BookMyEvent Platform!\r\n\r\n This is a platform  for online booking and registration of various events\r\n  held at BMSCE during the fests,by the numerous student clubs and departments present\r\n  in BMSCE.Find your desired event!\r\n\r\n You cannot resist yourself from registering if you have visited here.Hope you find the \r\n desired events you want , here, at the press of a button.\r\n\r\n\r\n");
		//txtrToDesignAnd.setBounds(12, 13, 698, 153);
	}
}
