package menu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JFrame;
import javax.swing.JTextPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.Font;

public class MenuBar{
	JMenuBar menuBar = new JMenuBar();

	void setMenuBar(JMenu setMenu){
		menuBar.add(setMenu);
	}

	public JMenuBar getMenuBar(){
		return menuBar;
	}

	public MenuBar(){
		JMenu menu,menu2;
		JMenuItem i1,i2;

		/*MENU*/
		menu = new JMenu("File");
		menu2 = new JMenu("Help");
		i1 = new JMenuItem("About");
		i2 = new JMenuItem("Tutorial");

		menu.add(i1);
		menu2.add(i2);

		setMenuBar(menu);
		setMenuBar(menu2);

		/*Fungsi menu About*/
		i1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JFrame myWindow2 = new JFrame();
				JTextPane txtPaneAbout = new JTextPane();
				JTextPane txtPaneAbout2 = new JTextPane();
				StringBuilder kalimat = new StringBuilder();

				/*FRAME*/
				myWindow2.setSize(400,300);
				myWindow2.setTitle("About");
				myWindow2.setLocationRelativeTo(null);
				myWindow2.setResizable(false);
				myWindow2.setLayout(null);
				myWindow2.setVisible(true);

				/*TEXT AREA*/
				/*Fungsi untuk membuat text rata tengah*/
				StyledDocument doc = txtPaneAbout.getStyledDocument();
				SimpleAttributeSet center = new SimpleAttributeSet();
				StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
				doc.setParagraphAttributes(0, doc.getLength(), center, false);

				txtPaneAbout.setFont(new Font("Noto Sans", Font.PLAIN, 12));
				txtPaneAbout.setText("Author\nZukron Alviandy Rahmadhan");
				txtPaneAbout.setBounds(0,0,400,50);
				txtPaneAbout.setEditable(false);
				txtPaneAbout.setOpaque(false); // transparan background
				myWindow2.add(txtPaneAbout);

				/*TEXT AREA 2*/
				txtPaneAbout2.setContentType("text/html"); // untuk mengeset text menjadi html
				txtPaneAbout2.setFont(new Font("Noto Sans", Font.PLAIN, 12));
				kalimat.append("<b>Update V2.0</b> - 15 Juli 2019 <br>");
				kalimat.append("First Version <br>");
				kalimat.append("<b>Update V2.1</b> - 20 Juli 2019 <br>");
				kalimat.append("- Penambahan Delete data");
				txtPaneAbout2.setText(String.valueOf(kalimat));
				txtPaneAbout2.setBounds(0,55,400,245);
				txtPaneAbout2.setEditable(false);
				txtPaneAbout2.setOpaque(false);
				myWindow2.add(txtPaneAbout2);
			}
		});

		/*Fungsi menu tutorial*/
		i2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			}
		});
	}
}