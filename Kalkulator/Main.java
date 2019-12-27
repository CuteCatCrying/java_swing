package kelasKalkulator;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.lang.NumberFormatException;

public class Main{
	public static void main(String[] args) {
		JFrame myWindow = new JFrame();
		JLabel lblNilaiA = new JLabel("Nilai A");
		JTextField txtNilaiA = new JTextField();
		JLabel lblNilaiB = new JLabel("Nilai B");
		JTextField txtNilaiB = new JTextField();

		JLabel lblHasil = new JLabel("Hasil");

		JButton btnHitungTambah = new JButton("+");
		JButton btnHitungKurang = new JButton("-");
		JButton btnHitungKali = new JButton("X");
		JButton btnHitungBagi = new JButton("/");
		JButton btnHitungMod = new JButton("Mod");

		/*Frame*/
		myWindow.setTitle("Kalkulator");
		myWindow.setSize(385,205);
		myWindow.setVisible(true);
		myWindow.setLayout(null);
		myWindow.setResizable(false); // Agar tidak ada resizing
		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*Label*/
		lblNilaiA.setBounds(28,38,66,15);
		myWindow.add(lblNilaiA);
		lblNilaiB.setBounds(28,65,66,15);
		myWindow.add(lblNilaiB);
		lblHasil.setBounds(280,36,78,44);
		myWindow.add(lblHasil);

		/*Text Field*/
		txtNilaiA.setBounds(90,36,124,19);
		myWindow.add(txtNilaiA);
		txtNilaiB.setBounds(90,63,124,19);
		myWindow.add(txtNilaiB);

		/*Button Tambah*/
		btnHitungTambah.setBounds(65,105,45,45);
		myWindow.add(btnHitungTambah);

		/*Button Kurang*/
		btnHitungKurang.setBounds(120,105,45,45);
		myWindow.add(btnHitungKurang);

		/*Button Kali*/
		btnHitungKali.setBounds(175,105,45,45);
		myWindow.add(btnHitungKali);

		/*Button Bagi*/
		btnHitungBagi.setBounds(230,105,45,45);
		myWindow.add(btnHitungBagi);

		/*Button Button Mod*/
		btnHitungMod.setBounds(285,105,65,45);
		myWindow.add(btnHitungMod);

			/*Fungsi Button Tambah*/
			btnHitungTambah.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					int nilaiA = Integer.valueOf(txtNilaiA.getText());
					int nilaiB = Integer.valueOf(txtNilaiB.getText());
					int hasil = nilaiA + nilaiB;

					lblHasil.setText(String.valueOf(hasil));
				}
			});

			/*Fungsi Button Kurang*/
			btnHitungKurang.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					int nilaiA = Integer.valueOf(txtNilaiA.getText());
					int nilaiB = Integer.valueOf(txtNilaiB.getText());
					int hasil = nilaiA - nilaiB;

					lblHasil.setText(String.valueOf(hasil));
				}
			});

			/*Fungsi Button Kali*/
			btnHitungKali.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					int nilaiA = Integer.valueOf(txtNilaiA.getText());
					int nilaiB = Integer.valueOf(txtNilaiB.getText());
					int hasil = nilaiA * nilaiB;

					lblHasil.setText(String.valueOf(hasil));
				}
			});

			/*Fungsi Button Bagi*/
			btnHitungBagi.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					double nilaiA = Double.valueOf(txtNilaiA.getText());
					double nilaiB = Double.valueOf(txtNilaiB.getText());
					double hasil = nilaiA / nilaiB;
					String hasilFormat = String.format("%.2f",hasil);

					lblHasil.setText(String.valueOf(hasilFormat));
				}
			});

			/*Fungsi Button Mod*/
			btnHitungMod.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					int nilaiA = Integer.valueOf(txtNilaiA.getText());
					int nilaiB = Integer.valueOf(txtNilaiB.getText());
					int hasil = nilaiA % nilaiB;

					lblHasil.setText(String.valueOf(hasil));
				}
			});
	}
}