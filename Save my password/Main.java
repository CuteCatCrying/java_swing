package kelasSaveMyPassword;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

class MenuBar{
	JMenu menu,menu2;
	JMenuItem i1,i2;
	JMenuBar menuBar = new JMenuBar();
	MenuBar(){
		/*MENU*/
		menu = new JMenu("File");
		menu2 = new JMenu("Help");
		i1 = new JMenuItem("About");
		i2 = new JMenuItem("Tutorial");

		menu.add(i1);
		menu2.add(i2);

		menuBar.add(menu);
		menuBar.add(menu2);

		/*Fungsi menu About*/
		i1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JFrame myWindows2 = new JFrame();
				JTextPane txtPaneAbout = new JTextPane();

				/*FRAME*/
				myWindows2.setSize(200,100);
				myWindows2.setTitle("About");
				myWindows2.setLocationRelativeTo(null);
				myWindows2.setResizable(false);
				myWindows2.setLayout(null);
				myWindows2.setVisible(true);

				/*TEXT AREA*/
				/*Fungsi untuk membuat text rata tengah*/
				StyledDocument doc = txtPaneAbout.getStyledDocument();
				SimpleAttributeSet center = new SimpleAttributeSet();
				StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
				doc.setParagraphAttributes(0, doc.getLength(), center, false);

				txtPaneAbout.setFont(new Font("Noto Sans", Font.PLAIN, 12));
				txtPaneAbout.setText("Author\nZukron Alviandy Rahmadhan\n20 Mei 2019");
				txtPaneAbout.setSize(200,52);
				txtPaneAbout.setEditable(false);
				txtPaneAbout.setOpaque(false); // transparan background
				myWindows2.add(txtPaneAbout);
			}
		});

		/*Fungsi menu tutorial*/
		i2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			}
		});
	}
}

class Window extends MenuBar{
	static void cekFile(){
		File cekFileData;
		cekFileData = new File("Data.txt");
		if(cekFileData.exists()){
		}else{
			try{
				new File("Data.txt").createNewFile();
			}catch(Exception e){}
		}
	}

	/*Deklarasi objek*/
	JFrame myWindow = new JFrame();
	JLabel lblAkun = new JLabel("Akun");
	JTextField txtAkun = new JTextField();
	JLabel lblUsername = new JLabel("Username");
	JTextField txtUsername = new JTextField();
	JLabel lblPassword = new JLabel("Passowrd");
	JTextField txtPassword = new JTextField();
	JButton btnEntry = new JButton("Entry");
	JButton btnCheck = new JButton("Check");
	JTextArea txtarMain = new JTextArea();
	JScrollPane scroll = new JScrollPane(txtarMain);

	Window(){
		/*Frame*/
		myWindow.setTitle("Save My Password");
		myWindow.setSize(407, 421);
		myWindow.setResizable(false);
		myWindow.setLocationRelativeTo(null);
		myWindow.setLayout(null);
		myWindow.setVisible(true);
		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*Proses buat file*/
		cekFile();

		/*Menu*/
		myWindow.setJMenuBar(menuBar);

		/*Component Akun*/
		lblAkun.setBounds(65, 38, 35, 15);
		txtAkun.setBounds(108, 36, 150, 19);
		myWindow.add(lblAkun);
		myWindow.add(txtAkun);

		/*Component Username*/
		lblUsername.setBounds(31, 70, 69, 15);
		txtUsername.setBounds(108, 68, 150, 19);
		myWindow.add(lblUsername);
		myWindow.add(txtUsername);

		/*Component Password*/
		lblPassword.setBounds(35, 99, 65, 15);
		txtPassword.setBounds(108, 97, 150, 19);
		myWindow.add(lblPassword);
		myWindow.add(txtPassword);

		/*Component Button*/
		btnEntry.setBounds(293, 33, 75, 25);
		btnCheck.setBounds(293, 65, 75, 25);
		myWindow.add(btnEntry);
		myWindow.add(btnCheck);

		/*Component Scroll & Text Area*/
		txtarMain.setEditable(false);
		scroll.setBounds(35, 149, 333, 220);
		myWindow.add(scroll);

		btnEntry.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String akun,username,password;
				akun = txtAkun.getText();
				username = txtUsername.getText();
				password = txtPassword.getText();

				try{
					PrintWriter pw = new PrintWriter(new FileWriter("Data.txt",true));
					pw.println("========================");
					pw.println("Akun\t: "+akun);
					pw.println("Username\t: "+username);
					pw.println("Password\t: "+password);
					pw.flush();
				}catch(Exception e){}
			}
		});
		btnCheck.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				try{
					FileReader fr = new FileReader("Data.txt");
					BufferedReader in = new BufferedReader(fr);
					String line;

					while((line = in.readLine()) != null){
						txtarMain.append(line);
						txtarMain.append("\n");
					}
				}catch(Exception e){}
			}
		});
	}
}

public class Main{
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				new Window();
			}
		});
	}
}