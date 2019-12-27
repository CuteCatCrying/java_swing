import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main{
	public static void main(String[] args){
		JFrame myWindow = new JFrame(); // Jendela
		JButton button = new JButton("Click"); // Tombol
		JLabel label = new JLabel("Java Swing GUI");
		JTextField text = new JTextField();

		/*Jendela*/
		// Set title
		myWindow.setTitle("Project 1");

		// Ukuran Jendela
		myWindow.setSize(400,500); // 400 width, 500 height

		// Visibility
		myWindow.setVisible(true);

		// Using no layout manager
		myWindow.setLayout(null);

		// Memberhentikan program jika diclose
		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Text Field
		text.setBounds(20,20,150,50);
		button.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				text.setText("Welcome to ...");
			}
		}); 

		/*Tombol*/
		button.setBounds(100,100,50, 50);//x axis, y axis, width, height  
        myWindow.add(button);//adding button in JFrame  

        /*Label*/
        label.setBounds(70,50,150,50);
        myWindow.add(label);

        /*Text Field*/
        myWindow.add(text);
	}
}