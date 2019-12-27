package kelasLatihanPenjumlahan;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;

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
				JFrame myWindow2 = new JFrame();
				JTextPane txtPaneAbout = new JTextPane();

				/*FRAME*/
				myWindow2.setSize(200,100);
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
				txtPaneAbout.setText("Author\nZukron Alviandy Rahmadhan\n22 Mei 2019");
				txtPaneAbout.setSize(200,52);
				txtPaneAbout.setEditable(false);
				txtPaneAbout.setOpaque(false); // transparan background
				myWindow2.add(txtPaneAbout);
			}
		});

		/*Fungsi menu tutorial*/
		i2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			}
		});
	}
}

/*Getter and Setter*/
class LevelClass{
	private int level;

	void setLevel(int level){
		this.level = level;
	}
	int getLevel(){
		return level;
	}
}

/*Getter and Setter*/
class RangeRandomClass{
	private int upperBound;
	private int lowerBound;

	void setUpperBound(int upperBound){
		this.upperBound = upperBound;
	}
	int getUpperBound(){
		return upperBound;
	}
	void setLowerBound(int lowerBound){
		this.lowerBound = lowerBound;
	}
	int getLowerBound(){
		return lowerBound;
	}
}

class AngkaClass{
	private int angka1;
	private int angka2;

	void setAngka1DanAngka2(int upperBound,int lowerBound){
		Random rand = new Random();
		this.angka1 = rand.nextInt(upperBound - lowerBound) + lowerBound;
		this.angka2 = rand.nextInt(upperBound - lowerBound) + lowerBound;
	}
	int getAngka1(){
		return angka1;
	}
	int getAngka2(){
		return angka2;
	}
}

class Window extends MenuBar{
	/*Deklarasi Objek*/
	Random rand = new Random();
	LevelClass L = new LevelClass();
	RangeRandomClass RR = new RangeRandomClass();
	AngkaClass A = new AngkaClass();

	JFrame myWindow;
	JButton btnLevel1,btnLevel2,btnLevel3,btnEnter;
	JLabel lblLevel,lblAngka;
	JTextField txtInput;
	JTextArea txtarHasil;
	JScrollPane scroll;

	Window(){
		/*Main Frame*/
		myWindow = new JFrame();
		myWindow.setTitle("Latihan Penjumlahan");
		myWindow.setSize(236,336);
		myWindow.setLocationRelativeTo(null);
		myWindow.setVisible(true);
		myWindow.setResizable(false);
		myWindow.setLayout(null);
		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*Button*/
		btnLevel1 = new JButton("1");
			btnLevel1.setBounds(33, 33, 42, 25);
			myWindow.add(btnLevel1);
		btnLevel2 = new JButton("2");
			btnLevel2.setBounds(92, 33, 42, 25);
			myWindow.add(btnLevel2);
		btnLevel3 = new JButton("3");
			btnLevel3.setBounds(152, 33, 42, 25);
			myWindow.add(btnLevel3);
		btnEnter = new JButton("Enter");
			btnEnter.setBounds(74, 99, 78, 25);
			myWindow.add(btnEnter);

		/*Label*/
		lblAngka = new JLabel("Angka");
			lblAngka.setBounds(54, 72, 66, 15);
			myWindow.add(lblAngka);
		lblLevel = new JLabel("Level");
			lblLevel.setBounds(94, 12, 44, 15);
			myWindow.add(lblLevel);

		/*Text Field*/
		txtInput = new JTextField();
			txtInput.setText("0");
			txtInput.setBounds(127, 70, 42, 19);
			myWindow.add(txtInput);

		/*Text Area*/
		txtarHasil = new JTextArea();
			txtarHasil.setEditable(false);

		/*Scroll*/
		scroll = new JScrollPane(txtarHasil);
			scroll.setBounds(12, 138, 205, 137);
			myWindow.add(scroll);

		btnLevel1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				L.setLevel(1);
				RR.setUpperBound(10);
				RR.setLowerBound(1);
				A.setAngka1DanAngka2(RR.getUpperBound(),RR.getLowerBound());
				lblAngka.setText(A.getAngka1()+" + "+A.getAngka2()+" =");
			}
		});
		
		btnLevel2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				L.setLevel(2);
				RR.setUpperBound(30);
				RR.setLowerBound(10);
				A.setAngka1DanAngka2(RR.getUpperBound(),RR.getLowerBound());
				lblAngka.setText(A.getAngka1()+" + "+A.getAngka2()+" =");
			}
		});

		btnLevel3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				L.setLevel(3);
				RR.setUpperBound(50);
				RR.setLowerBound(20);
				A.setAngka1DanAngka2(RR.getUpperBound(),RR.getLowerBound());
				lblAngka.setText(A.getAngka1()+" + "+A.getAngka2()+" =");
			}
		});

		btnEnter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(L.getLevel() == 0){
					txtarHasil.setText(null);
					txtarHasil.append("Level belum diset\n");
				}else{
					if(L.getLevel() == 1){
						int hasil = A.getAngka1() + A.getAngka2();

						System.out.println(Integer.valueOf(txtInput.getText()) + " hasil = " + hasil);
						if(Integer.valueOf(txtInput.getText()) == hasil){
							txtarHasil.append(A.getAngka1()+" + "+A.getAngka2()+" = "+txtInput.getText()+"\t(benar)\n");
							A.setAngka1DanAngka2(RR.getUpperBound(),RR.getLowerBound());
							lblAngka.setText(A.getAngka1()+" + "+A.getAngka2()+" =");
						}else{
							txtarHasil.append(A.getAngka1()+" + "+A.getAngka2()+" = "+txtInput.getText()+"\t(salah)\n");
						}
					}else if(L.getLevel() == 2){
						int hasil = A.getAngka1() + A.getAngka2();

						System.out.println(Integer.valueOf(txtInput.getText()) + " hasil = " + hasil);
						if(Integer.valueOf(txtInput.getText()) == hasil){
							txtarHasil.append(A.getAngka1()+" + "+A.getAngka2()+" = "+txtInput.getText()+"\t(benar)\n");
							A.setAngka1DanAngka2(RR.getUpperBound(),RR.getLowerBound());
							lblAngka.setText(A.getAngka1()+" + "+A.getAngka2()+" =");
						}else{
							txtarHasil.append(A.getAngka1()+" + "+A.getAngka2()+" = "+txtInput.getText()+"\t(salah)\n");
						}
					}else if(L.getLevel() == 3){
						int hasil = A.getAngka1() + A.getAngka2();

						System.out.println(Integer.valueOf(txtInput.getText()) + " hasil = " + hasil);
						if(Integer.valueOf(txtInput.getText()) == hasil){
							txtarHasil.append(A.getAngka1()+" + "+A.getAngka2()+" = "+txtInput.getText()+"\t(benar)\n");
							A.setAngka1DanAngka2(RR.getUpperBound(),RR.getLowerBound());
							lblAngka.setText(A.getAngka1()+" + "+A.getAngka2()+" =");
						}else{
							txtarHasil.append(A.getAngka1()+" + "+A.getAngka2()+" = "+txtInput.getText()+"\t(salah)\n");
						}
					}
				}
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