package V20;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import menu.MenuBar;

import java.sql.*;

class Windows extends MenuBar{
	JFrame mainFrame;
	JLabel lblAkun,lblUsername,lblPassword;
	JTextField txtAkun,txtUsername,txtPassword;
	JButton btnEntry,btnCheck;
	JTable tbl;
	JScrollPane sp;
	JOptionPane peringatan;

	Windows(){
		/* Main Frame */
		mainFrame = new JFrame();
		mainFrame.setTitle("Save my password V2");
		mainFrame.setSize(522,421);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
		mainFrame.getContentPane().setLayout(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* Menu */
		mainFrame.setJMenuBar(getMenuBar());

		/*Component Akun*/
		lblAkun = new JLabel("Akun");
		txtAkun = new JTextField();
		lblAkun.setBounds(65, 38, 35, 15);
		txtAkun.setBounds(108, 36, 150, 19);
		mainFrame.add(lblAkun);
		mainFrame.add(txtAkun);

		/*Component Username*/
		lblUsername = new JLabel("Username");
		txtUsername = new JTextField();
		lblUsername.setBounds(31, 70, 69, 15);
		txtUsername.setBounds(108, 68, 150, 19);
		mainFrame.add(lblUsername);
		mainFrame.add(txtUsername);

		/*Component Password*/
		lblPassword = new JLabel("Password");
		txtPassword = new JTextField();
		lblPassword.setBounds(35, 99, 65, 15);
		txtPassword.setBounds(108, 97, 150, 19);
		mainFrame.add(lblPassword);
		mainFrame.add(txtPassword);

		/*Component Button*/
		btnEntry = new JButton("Entry");
		btnCheck = new JButton("Check");
		btnEntry.setBounds(293, 33, 75, 25);
		btnCheck.setBounds(293, 65, 75, 25);
		mainFrame.add(btnEntry);
		mainFrame.add(btnCheck);

		btnEntry.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String akun,username,password;
				peringatan = new JOptionPane();

				akun = txtAkun.getText();
				username = txtUsername.getText();
				password = txtPassword.getText();

				if(akun.equals("") || username.equals("") || password.equals("")){
					peringatan.showMessageDialog(mainFrame,"Empty Data","Warning",JOptionPane.WARNING_MESSAGE);
				}else{
					try{
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","zera","mean123");

						Statement st = conn.createStatement();
						String sql = String.format("insert into accounts values ('%s','%s','%s')",akun,username,password);

						st.executeUpdate(sql);
						peringatan.showMessageDialog(mainFrame,"Successfully Updated","Alert",JOptionPane.WARNING_MESSAGE);
					}catch(Exception exc){
						peringatan.showMessageDialog(mainFrame,"Invalid data or Duplicate data","Warning",JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});

		btnCheck.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				try{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","zera","mean123");

					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery("select * from accounts order by akun asc");

					/*Component Table*/
				    String column[]={"Akun","Username","Password"};
				    int banyakData =0;
				    while(rs.next()){ // Untuk mengecek berapa banyak data
				    	banyakData++;
				    }

				    rs.beforeFirst(); // Mereset penunju ResultSet ke awal sebelum first yang arti nya kembali ke 0
				    String[][] data = new String[banyakData][4];
				    for(int i=1; i<=banyakData; i++){
			      		rs.next();
			      		for(int j=1; j<=3; j++){
							data[i-1][j-1] = rs.getString(j);
			      		}
				    }

				    tbl = new JTable(data,column);
					/*Componen Scroll Pane*/
					sp = new JScrollPane(tbl);
					sp.setBounds(35, 140, 450, 171);
					mainFrame.getContentPane().add(sp);
				}catch(Exception exc){
					System.out.println(exc);
				}

			}
		});
	}
}

public class Main{
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				new Windows();
			}
		});
	}
}