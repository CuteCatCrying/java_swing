import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import menu.MenuBar;

import java.text.DecimalFormat;
import java.math.RoundingMode;

class Window extends MenuBar{
	JFrame mainFrame;
	JComboBox<String> cmbxAtas;
	JTextField txtAtas;
	JComboBox<String> cmbxBawah;
	JTextField txtBawah;

	String[] satuanPanjang = {"KM (Kilo Meter)",
	"HM (Hekto Meter)",
	"DAM (Deka Meter)",
	"M (Meter)",
	"DM (Desi Meter)",
	"CM (Centi Meter)",
	"MM (Mili Meter)"};

	Window(){
		/* Main Frame */
		mainFrame = new JFrame();
		mainFrame.setTitle("Konversi Satuan Panjang");
		mainFrame.setSize(354,186);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
		mainFrame.getContentPane().setLayout(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* Menu Bar */
		mainFrame.setJMenuBar(getMenuBar());

		/* Combo Box */
		cmbxAtas = new JComboBox<>(satuanPanjang);
		cmbxAtas.setBounds(37, 12, 277, 24);
		mainFrame.getContentPane().add(cmbxAtas);

		cmbxBawah = new JComboBox<>(satuanPanjang);
		cmbxBawah.setBounds(37, 73, 277, 24);
		mainFrame.getContentPane().add(cmbxBawah);

		/* Text Field */
		txtAtas = new JTextField();
		txtAtas.setBounds(37, 42, 277, 19);
		mainFrame.getContentPane().add(txtAtas);

		txtBawah = new JTextField();
		txtBawah.setEditable(false);
		txtBawah.setBounds(37, 103, 277, 19);
		mainFrame.getContentPane().add(txtBawah);

		cmbxBawah.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				/* Konversi txt to integer */
				int valueAtas  = Integer.valueOf(txtAtas.getText());

				/* get value from combo box atas and bawah */
				int valueCmbxAtas  = cmbxAtas.getSelectedIndex();
				int valueCmbxBawah = cmbxBawah.getSelectedIndex();

				/* Perhitungan */
				int selisih;
				int x = 1;
				double valueAtasFloat;
				String hasil;

				selisih = valueCmbxAtas < valueCmbxBawah ? (valueCmbxBawah-valueCmbxAtas) : (valueCmbxAtas-valueCmbxBawah);
				for(int i=1; i<=selisih; i++){
					x *= 10;
				}

				if(valueCmbxAtas < valueCmbxBawah){
					valueAtas = valueAtas * x;
					hasil = String.valueOf(valueAtas);
				}else{
					/* Membulatkan decimal menggunakan formatter*/
					DecimalFormat df = new DecimalFormat("#.########");
					df.setRoundingMode(RoundingMode.CEILING); // Pembualatan keatas

					valueAtasFloat = (float)valueAtas / x;
					hasil = String.valueOf(df.format(valueAtasFloat));
				}

				txtBawah.setText(hasil);
			}
		});

		cmbxAtas.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				/* Konversi txt to integer */
				int valueAtas  = Integer.valueOf(txtAtas.getText());

				/* get value from combo box atas and bawah */
				int valueCmbxAtas  = cmbxAtas.getSelectedIndex();
				int valueCmbxBawah = cmbxBawah.getSelectedIndex();

				/* Perhitungan */
				int selisih;
				int x = 1;
				double valueAtasFloat;
				String hasil;

				selisih = valueCmbxAtas < valueCmbxBawah ? (valueCmbxBawah-valueCmbxAtas) : (valueCmbxAtas-valueCmbxBawah);
				for(int i=1; i<=selisih; i++){
					x *= 10;
				}

				if(valueCmbxAtas < valueCmbxBawah){
					valueAtas = valueAtas * x;
					hasil = String.valueOf(valueAtas);
				}else{
					/* Membulatkan decimal menggunakan formatter*/
					DecimalFormat df = new DecimalFormat("#.########");
					df.setRoundingMode(RoundingMode.CEILING); // Pembualatan keatas

					valueAtasFloat = (float)valueAtas / x;
					hasil = String.valueOf(df.format(valueAtasFloat));
				}

				txtBawah.setText(hasil);
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