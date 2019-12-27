package kelasEncodeDecodeBase64;

/*Package base64*/
import java.util.Base64;

/*Fungsi yang mengoptimalasiasi program,
antrian peristiwa*/
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.JFrame;
/*Package menu*/
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextPane;

/*Package untuk fungsi rata tengah*/
import javax.swing.text.StyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

class Window{
	Window(){
		/*Mendapatan Encoder*/
		Base64.Encoder encoder = Base64.getEncoder();
		/*Mendapatan Decoder*/
		Base64.Decoder decoder = Base64.getDecoder();

		JFrame myWindow = new JFrame();
		JTextArea txtArea1 = new JTextArea();
		JTextArea txtArea2 = new JTextArea();
		JLabel lblBase64 = new JLabel("Base 64");
		JButton btnEncode = new JButton("Encode");
		JButton btnDecode = new JButton("Decode");

		JMenuBar menuBar = new JMenuBar();
		JMenu menu,menu2;
		JMenuItem i1,i2;

		myWindow.setTitle("Encode Decode Base64");
		myWindow.setSize(450, 310);
		myWindow.setLocationRelativeTo(null);
		myWindow.setResizable(false);
		myWindow.setVisible(true);
		myWindow.setLayout(null);
		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*TEXT AREA*/
		txtArea1.setBounds(32, 12, 379, 99);
		txtArea1.setLineWrap(true);
		myWindow.add(txtArea1);
		txtArea2.setBounds(32, 150, 379, 99);
		txtArea2.setLineWrap(true);
		myWindow.add(txtArea2);

		/*LABEL*/
		lblBase64.setBounds(175, 123, 66, 15);
		myWindow.add(lblBase64);

		/*BUTTON*/
		btnEncode.setBounds(42, 118, 114, 25);
		myWindow.add(btnEncode);
		btnDecode.setBounds(259, 118, 114, 25);
		myWindow.add(btnDecode);

		/*Fungsi Button*/
		btnEncode.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String text1 = txtArea1.getText();
				String text1Encode = encoder.encodeToString(text1.getBytes());
				txtArea2.setText(text1Encode);
			}
		});

		btnDecode.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String text2 = txtArea2.getText();
				String text2Decode = new String(decoder.decode(text2));
				txtArea1.setText(text2Decode);
			}
		});

		/*MENU*/
		menu = new JMenu("File");
		menu2 = new JMenu("Help");
		i1 = new JMenuItem("About");
		i2 = new JMenuItem("Tutorial");

		menu.add(i1);
		menu2.add(i2);

		menuBar.add(menu);
		menuBar.add(menu2);

		myWindow.setJMenuBar(menuBar);

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
				txtPaneAbout.setText("Author\nZukron Alviandy Rahmadhan\n15 Mei 2019");
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

public class Main{
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				new Window();
			}
		});
	}
}