import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Club1 extends JFrame {
	private static final long serialVersionUID = -8475991280785853438L;
	private JPanel contentPane;
	private JTable table;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Club1 frame = new Club1();
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
	public Club1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(80, 10, 1200, 1010);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
			
		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 220, 220));
		panel.setBounds(0, 0, 1182, 90);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\Apps\\My Workspace\\BookMyEvent\\images\\image1.jpg"));
		lblNewLabel.setBounds(0, 0, 98, 90);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("LIST OF EVENTS");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 34));
		lblNewLabel_1.setBounds(464, 18, 331, 40);
		panel.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 550, 1182, 250);
		contentPane.add(scrollPane);
		
				
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		table.setFillsViewportHeight(true);
		table.setRowHeight(30);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		BorderLayout bl_table = new BorderLayout();
		bl_table.setVgap(5);
		bl_table.setHgap(5);
		table.setLayout(bl_table);
		
		JButton btnNewButton = new JButton("ISE STUDENT CLUB");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
		        {
		            Class.forName("com.mysql.jdbc.Driver");
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyevent","root","qwerty");
		            String sql="select Event_name,Date,Venue,Time,Fee,rules from event natural join organizes where name=?";
		            PreparedStatement pstmt =conn.prepareStatement(sql);
		            pstmt.setString(1,btnNewButton.getText()); 
		            ResultSet rs = pstmt.executeQuery();
		            table.setModel(DbUtils.resultSetToTableModel(rs));
		        }
		        catch(Exception e1)
		        {
		            e1.printStackTrace();
		        }
			}
		});
		buttonGroup.add(btnNewButton);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(72, 159, 159, 36);
		contentPane.add(btnNewButton);
		
		
		JButton btnAddix = new JButton("DANCE ADDIX");
		btnAddix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
		        {
		            Class.forName("com.mysql.jdbc.Driver");
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyevent","root","qwerty");
		            String sql="select Event_name,Date,Venue,Time,Fee,rules from event natural join organizes where name=?";
		            PreparedStatement pstmt =conn.prepareStatement(sql);
		            pstmt.setString(1,btnAddix.getText()); 
		            ResultSet rs = pstmt.executeQuery();
		            table.setModel(DbUtils.resultSetToTableModel(rs));
		        }
		        catch(Exception e1)
		        {
		            e1.printStackTrace();
		        }
			}
		});
		buttonGroup.add(btnAddix);
		btnAddix.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnAddix.setForeground(new Color(0, 0, 0));
		btnAddix.setBackground(new Color(255, 255, 255));
		btnAddix.setBounds(346, 159, 159, 36);
		contentPane.add(btnAddix);
		
		JButton btnFac = new JButton("FAC");
		btnFac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
		        {
		            Class.forName("com.mysql.jdbc.Driver");
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyevent","root","qwerty");
		            String sql="select Event_name,Date,Venue,Time,Fee,rules from event natural join organizes where name=?";
		            PreparedStatement pstmt =conn.prepareStatement(sql);
		            pstmt.setString(1,btnFac.getText()); 
		            ResultSet rs = pstmt.executeQuery();
		            table.setModel(DbUtils.resultSetToTableModel(rs));
		        }
		        catch(Exception e1)
		        {
		            JOptionPane.showMessageDialog(null,e1);
		        }
			}
		});
		buttonGroup.add(btnFac);
		btnFac.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnFac.setForeground(new Color(0, 0, 0));
		btnFac.setBackground(new Color(255, 255, 255));
		btnFac.setBounds(629, 159, 159, 36);
		contentPane.add(btnFac);
		
		JButton btnCodeIo = new JButton("CODE IO");
		btnCodeIo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
		        {
		            Class.forName("com.mysql.jdbc.Driver");
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyevent","root","qwerty");
		            String sql="select Event_name,Date,Venue,Time,Fee,rules from event natural join organizes where name=?";
		            PreparedStatement pstmt =conn.prepareStatement(sql);
		            pstmt.setString(1,btnCodeIo.getText()); 
		            ResultSet rs = pstmt.executeQuery();
		            table.setModel(DbUtils.resultSetToTableModel(rs));
		        }
		        catch(Exception e1)
		        {
		            JOptionPane.showMessageDialog(null,e1);
		        }
			}
		});
		buttonGroup.add(btnCodeIo);
		btnCodeIo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnCodeIo.setForeground(new Color(0, 0, 0));
		btnCodeIo.setBackground(new Color(255, 255, 255));
		btnCodeIo.setBounds(924, 159, 159, 36);
		contentPane.add(btnCodeIo);
		
		JButton btnIeee = new JButton("IEEE");
		btnIeee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
		        {
		            Class.forName("com.mysql.jdbc.Driver");
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyevent","root","qwerty");
		            String sql="select Event_name,Date,Venue,Time,Fee,rules from event natural join organizes where name=?";
		            PreparedStatement pstmt =conn.prepareStatement(sql);
		            pstmt.setString(1,btnIeee.getText()); 
		            ResultSet rs = pstmt.executeQuery();
		            table.setModel(DbUtils.resultSetToTableModel(rs));
		        }
		        catch(Exception e1)
		        {
		            JOptionPane.showMessageDialog(null,e1);
		        }
			}
		});
		buttonGroup.add(btnIeee);
		btnIeee.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnIeee.setForeground(new Color(0, 0, 0));
		btnIeee.setBackground(new Color(255, 255, 255));
		btnIeee.setBounds(72, 238, 159, 36);
		contentPane.add(btnIeee);
		
		JButton btnNinaad = new JButton("NINAAD");
		btnNinaad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
		        {
		            Class.forName("com.mysql.jdbc.Driver");
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyevent","root","qwerty");
		            String sql="select Event_name,Date,Venue,Time,Fee,rules from event natural join organizes where name=?";
		            PreparedStatement pstmt =conn.prepareStatement(sql);
		            pstmt.setString(1,btnNinaad.getText()); 
		            ResultSet rs = pstmt.executeQuery();
		            table.setModel(DbUtils.resultSetToTableModel(rs));
		        }catch(Exception e1)
		        {
		            JOptionPane.showMessageDialog(null,e1);
		        }
			}
		});
		buttonGroup.add(btnNinaad);
		btnNinaad.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNinaad.setForeground(new Color(0, 0, 0));
		btnNinaad.setBackground(new Color(255, 255, 255));
		btnNinaad.setBounds(346, 238, 159, 36);
		contentPane.add(btnNinaad);
		
		JButton btnFashionClub = new JButton("FASHION CLUB");
		btnFashionClub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
		        {
		            Class.forName("com.mysql.jdbc.Driver");
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyevent","root","qwerty");
		            String sql="select Event_name,Date,Venue,Time,Fee,rules from event natural join organizes where name=?";
		            PreparedStatement pstmt =conn.prepareStatement(sql);
		            pstmt.setString(1,btnFashionClub.getText()); 
		            ResultSet rs = pstmt.executeQuery();
		            table.setModel(DbUtils.resultSetToTableModel(rs));
		        }catch(Exception e1)
		        {
		            JOptionPane.showMessageDialog(null,e1);
		        }
			}
		});
		buttonGroup.add(btnFashionClub);
		btnFashionClub.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnFashionClub.setForeground(new Color(0, 0, 0));
		btnFashionClub.setBackground(new Color(255, 255, 255));
		btnFashionClub.setBounds(629, 238, 159, 36);
		contentPane.add(btnFashionClub);
		
		JButton btnElsoc = new JButton("ELSOC");
		btnElsoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
		        {
		            Class.forName("com.mysql.jdbc.Driver");
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyevent","root","qwerty");
		            String sql="select Event_name,Date,Venue,Time,Fee,rules from event natural join organizes where name=?";
		            PreparedStatement pstmt =conn.prepareStatement(sql);
		            pstmt.setString(1,btnElsoc.getText()); 
		            ResultSet rs = pstmt.executeQuery();
		            table.setModel(DbUtils.resultSetToTableModel(rs));
		        }catch(Exception e1)
		        {
		            JOptionPane.showMessageDialog(null,e1);
		        }
			}
		});
		buttonGroup.add(btnElsoc);
		btnElsoc.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnElsoc.setForeground(new Color(0, 0, 0));
		btnElsoc.setBackground(new Color(255, 255, 255));
		btnElsoc.setBounds(924, 238, 159, 36);
		contentPane.add(btnElsoc);
		
		JButton btnQuizClub = new JButton("QUIZ CLUB");
		btnQuizClub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
		        {
		            Class.forName("com.mysql.jdbc.Driver");
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyevent","root","qwerty");
		            String sql="select Event_name,Date,Venue,Time,Fee,rules from event natural join organizes where name=?";
		            PreparedStatement pstmt =conn.prepareStatement(sql);
		            pstmt.setString(1,btnQuizClub.getText()); 
		            ResultSet rs = pstmt.executeQuery();
		            table.setModel(DbUtils.resultSetToTableModel(rs));
		        }catch(Exception e1)
		        {
		            JOptionPane.showMessageDialog(null,e1);
		        }
			}
		});
		buttonGroup.add(btnQuizClub);
		btnQuizClub.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnQuizClub.setForeground(new Color(0, 0, 0));
		btnQuizClub.setBackground(new Color(255, 255, 255));
		btnQuizClub.setBounds(72, 312, 159, 36);
		contentPane.add(btnQuizClub);
		
		JButton btnEdc = new JButton("EDC");
		btnEdc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
		        {
		            Class.forName("com.mysql.jdbc.Driver");
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyevent","root","qwerty");
		            String sql="select Event_name,Date,Venue,Time,Fee,rules from event natural join organizes where name=?";
		            PreparedStatement pstmt =conn.prepareStatement(sql);
		            pstmt.setString(1,btnEdc.getText()); 
		            ResultSet rs = pstmt.executeQuery();
		            table.setModel(DbUtils.resultSetToTableModel(rs));
		        }catch(Exception e1)
		        {
		            JOptionPane.showMessageDialog(null,e1);
		        }
			}
		});
		buttonGroup.add(btnEdc);
		btnEdc.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnEdc.setForeground(new Color(0, 0, 0));
		btnEdc.setBackground(new Color(255, 255, 255));
		btnEdc.setBounds(346, 312, 159, 36);
		contentPane.add(btnEdc);
		
		JButton btnPentagram = new JButton("PENTAGRAM");
		btnPentagram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
		        {
		            Class.forName("com.mysql.jdbc.Driver");
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyevent","root","qwerty");
		            String sql="select Event_name,Date,Venue,Time,Fee,rules from event natural join organizes where name=?";
		            PreparedStatement pstmt =conn.prepareStatement(sql);
		            pstmt.setString(1,btnPentagram.getText()); 
		            ResultSet rs = pstmt.executeQuery();
		            table.setModel(DbUtils.resultSetToTableModel(rs));
		        }catch(Exception e1)
		        {
		            JOptionPane.showMessageDialog(null,e1);
		        }
			}
		});
		buttonGroup.add(btnPentagram);
		btnPentagram.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnPentagram.setForeground(new Color(0, 0, 0));
		btnPentagram.setBackground(new Color(255, 255, 255));
		btnPentagram.setBounds(629, 312, 159, 36);
		contentPane.add(btnPentagram);
		
		JButton btnInksanity = new JButton("INKSANITY");
		btnInksanity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
		        {
		            Class.forName("com.mysql.jdbc.Driver");
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyevent","root","qwerty");
		            String sql="select Event_name,Date,Venue,Time,Fee,rules from event natural join organizes where name=?";
		            PreparedStatement pstmt =conn.prepareStatement(sql);
		            pstmt.setString(1,btnInksanity.getText()); 
		            ResultSet rs = pstmt.executeQuery();
		            table.setModel(DbUtils.resultSetToTableModel(rs));
		        }catch(Exception e1)
		        {
		            JOptionPane.showMessageDialog(null,e1);
		        }
			}
		});
		buttonGroup.add(btnInksanity);
		btnInksanity.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnInksanity.setForeground(new Color(0, 0, 0));
		btnInksanity.setBackground(new Color(255, 255, 255));
		btnInksanity.setBounds(924, 312, 159, 36);
		contentPane.add(btnInksanity);
		
		JButton btnPhptography = new JButton("PHOTOGRAPHY");
		btnPhptography.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
		        {
		            Class.forName("com.mysql.jdbc.Driver");
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyevent","root","qwerty");
		            String sql="select Event_name,Date,Venue,Time,Fee,rules from event natural join organizes where name=?";
		            PreparedStatement pstmt =conn.prepareStatement(sql);
		            pstmt.setString(1,btnPhptography.getText()); 
		            ResultSet rs = pstmt.executeQuery();
		            table.setModel(DbUtils.resultSetToTableModel(rs));
		        }catch(Exception e1)
		        {
		            JOptionPane.showMessageDialog(null,e1);
		        }
			}
		});
		buttonGroup.add(btnPhptography);
		btnPhptography.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnPhptography.setForeground(new Color(0, 0, 0));
		btnPhptography.setBackground(new Color(255, 255, 255));
		btnPhptography.setBounds(72, 388, 159, 36);
		contentPane.add(btnPhptography);
		
		JButton btnInksanity_1 = new JButton("PARAMVAH");
		btnInksanity_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
		        {
		            Class.forName("com.mysql.jdbc.Driver");
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyevent","root","qwerty");
		            String sql="select Event_name,Date,Venue,Time,Fee,rules from event natural join organizes where name=?";
		            PreparedStatement pstmt =conn.prepareStatement(sql);
		            pstmt.setString(1,btnInksanity_1.getText()); 
		            ResultSet rs = pstmt.executeQuery();
		            table.setModel(DbUtils.resultSetToTableModel(rs));
		        }catch(Exception e1)
		        {
		            JOptionPane.showMessageDialog(null,e1);
		        }
			}
		});
		buttonGroup.add(btnInksanity_1);
		btnInksanity_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnInksanity_1.setForeground(new Color(0, 0, 0));
		btnInksanity_1.setBackground(new Color(255, 255, 255));
		btnInksanity_1.setBounds(346, 388, 159, 36);
		contentPane.add(btnInksanity_1);
		
		JButton btnGamingClub = new JButton("GAMING CLUB");
		btnGamingClub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
		        {
		            Class.forName("com.mysql.jdbc.Driver");
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyevent","root","qwerty");
		            String sql="select Event_name,Date,Venue,Time,Fee,rules from event natural join organizes where name=?";
		            PreparedStatement pstmt =conn.prepareStatement(sql);
		            pstmt.setString(1,btnGamingClub.getText()); 
		            ResultSet rs = pstmt.executeQuery();
		            table.setModel(DbUtils.resultSetToTableModel(rs));
		        }catch(Exception e1)
		        {
		            JOptionPane.showMessageDialog(null,e1);
		        }
			}
		});
		buttonGroup.add(btnGamingClub);
		btnGamingClub.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnGamingClub.setForeground(new Color(0, 0, 0));
		btnGamingClub.setBackground(new Color(255, 255, 255));
		btnGamingClub.setBounds(629, 388, 159, 36);
		contentPane.add(btnGamingClub);
		
		JButton btnMountaneering = new JButton("MOUNTANEERING");
		btnMountaneering.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
		        {
		            Class.forName("com.mysql.jdbc.Driver");
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyevent","root","qwerty");
		            String sql="select Event_name,Date,Venue,Time,Fee,rules from event natural join organizes where name=?";
		            PreparedStatement pstmt =conn.prepareStatement(sql);
		            pstmt.setString(1,btnMountaneering.getText()); 
		            ResultSet rs = pstmt.executeQuery();
		            table.setModel(DbUtils.resultSetToTableModel(rs));
		        }catch(Exception e1)
		        {
		            JOptionPane.showMessageDialog(null,e1);
		        }
			}
		});
		buttonGroup.add(btnMountaneering);
		btnMountaneering.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnMountaneering.setForeground(new Color(0, 0, 0));
		btnMountaneering.setBackground(new Color(255, 255, 255));
		btnMountaneering.setBounds(924, 388, 159, 36);
		contentPane.add(btnMountaneering);
		
		JButton btnChrantana = new JButton("CHRANTANA");
		btnChrantana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
		        {
		            Class.forName("com.mysql.jdbc.Driver");
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyevent","root","qwerty");
		            String sql="select Event_name,Date,Venue,Time,Fee,rules from event natural join organizes where name=?";
		            PreparedStatement pstmt =conn.prepareStatement(sql);
		            pstmt.setString(1,btnChrantana.getText()); 
		            ResultSet rs = pstmt.executeQuery();
		            table.setModel(DbUtils.resultSetToTableModel(rs));
		        }catch(Exception e1)
		        {
		            JOptionPane.showMessageDialog(null,e1);
		        }
			}
		});
		buttonGroup.add(btnChrantana);
		btnChrantana.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnChrantana.setForeground(new Color(0, 0, 0));
		btnChrantana.setBackground(new Color(255, 255, 255));
		btnChrantana.setBounds(346, 466, 159, 36);
		contentPane.add(btnChrantana);
		
		JButton btnPravruthi = new JButton("PRAVRUTHI");
		btnPravruthi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
		        {
		            Class.forName("com.mysql.jdbc.Driver");
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyevent","root","qwerty");
		            String sql="select Event_name,Date,Venue,Time,Fee,rules from event natural join organizes where name=?";
		            PreparedStatement pstmt =conn.prepareStatement(sql);
		            pstmt.setString(1,btnPravruthi.getText()); 
		            ResultSet rs = pstmt.executeQuery();
		            table.setModel(DbUtils.resultSetToTableModel(rs));
		        }catch(Exception e1)
		        {
		            JOptionPane.showMessageDialog(null,e1);
		        }
			}
		});
		buttonGroup.add(btnPravruthi);
		btnPravruthi.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnPravruthi.setForeground(new Color(0, 0, 0));
		btnPravruthi.setBackground(new Color(255, 255, 255));
		btnPravruthi.setBounds(629, 466, 159, 36);
		contentPane.add(btnPravruthi);
		
		
		
		JButton btnNewButton_1 = new JButton("REGISTER");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventRegister E = new EventRegister();
				E.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBackground(new Color(50, 205, 50));
		btnNewButton_1.setBounds(377, 868, 128, 36);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("BACK");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Homepage H = new Homepage();
				H.setVisible(true);
				setVisible(false);				
			}
		});
		btnNewButton_2.setBounds(629, 868, 122, 36);
		contentPane.add(btnNewButton_2);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblName.setBounds(12, 535, 128, 16);
		contentPane.add(lblName);
		
		JLabel lblDate = new JLabel("DATE");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblDate.setBounds(187, 535, 128, 16);
		contentPane.add(lblDate);
		
		JLabel lblVenue = new JLabel("VENUE");
		lblVenue.setHorizontalAlignment(SwingConstants.CENTER);
		lblVenue.setForeground(Color.WHITE);
		lblVenue.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblVenue.setBounds(377, 535, 128, 16);
		contentPane.add(lblVenue);
		
		JLabel lblTime = new JLabel("TIME");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setForeground(Color.WHITE);
		lblTime.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTime.setBounds(573, 535, 128, 16);
		contentPane.add(lblTime);
		
		JLabel lblFee = new JLabel("FEE");
		lblFee.setHorizontalAlignment(SwingConstants.CENTER);
		lblFee.setForeground(Color.WHITE);
		lblFee.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblFee.setBounds(789, 535, 128, 16);
		contentPane.add(lblFee);
		
		JLabel lblRules = new JLabel("RULES");
		lblRules.setHorizontalAlignment(SwingConstants.CENTER);
		lblRules.setForeground(Color.WHITE);
		lblRules.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblRules.setBounds(1001, 535, 128, 16);
		contentPane.add(lblRules);
	}
}
