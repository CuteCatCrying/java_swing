package kelasSalinTerbalikTambahHapusArray;

import java.util.Scanner;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main{
	static int i;
	static int range = (90 - 20 +1)+20;
	static int[] a = new int[10];
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		Random rand = new Random();


		JFrame myWindow = new JFrame();

		/*Deklarasi Objek Array*/
		JLabel lblArray = new JLabel("Array");
		JTextField txtArray = new JTextField();
		JButton btnArray = new JButton("Generate");

		/*Deklarasi Objek salin terbalik*/
		JLabel lblSalinTerbalik = new JLabel("Salin terbalik");
		JTextField txtSalinTerbalik = new JTextField();
		JButton btnSalinTerbalik = new JButton("Generate");

		/*Deklarasi Objek tambah Array*/
		JLabel lblTambahArray = new JLabel("Tambah Array");
		JLabel lblNilai = new JLabel("Nilai");
		JTextField txtNilai = new JTextField();
		JLabel lblIndeksTambahArray = new JLabel("Indeks");
		JTextField txtIndeksTambahArray = new JTextField();
		JTextField txtTambahArray = new JTextField();
		JButton btnTambahArray = new JButton("Generate");

		/*Deklarasi Objek hapus array*/
		JLabel lblHapusArray = new JLabel("Hapus Array");
		JLabel lblIndeksHapusArray = new JLabel("Indeks");
		JTextField txtIndeksHapusArray = new JTextField();
		JTextField txtHapusArray = new JTextField();
		JButton btnHapusArray = new JButton("Generate");

		/*Window*/
		myWindow.setTitle("CRUD Array");
		myWindow.setSize(450, 277);
		myWindow.setVisible(true);
		myWindow.setLayout(null);
		myWindow.setResizable(false);
		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*Objek Array*/
		lblArray.setBounds(21, 12, 66, 15);
		txtArray.setBounds(78, 12, 227, 19);
		txtArray.setEditable(false);
		btnArray.setBounds(324, 12, 114, 19);
		myWindow.add(lblArray);
		myWindow.add(txtArray);
		myWindow.add(btnArray);

		/*Objek salin terbalik*/
		lblSalinTerbalik.setBounds(125, 40, 114, 15);
		txtSalinTerbalik.setBounds(78, 56, 227, 19);
		txtSalinTerbalik.setEditable(false);
		btnSalinTerbalik.setBounds(324, 56, 114, 19);
		myWindow.add(lblSalinTerbalik);
		myWindow.add(txtSalinTerbalik);
		myWindow.add(btnSalinTerbalik);

		/*Objek tambah array*/
		lblTambahArray.setBounds(125, 87, 96, 15);
		lblNilai.setBounds(42, 106, 45, 15);
		txtNilai.setBounds(78, 106, 54, 19);
		lblIndeksTambahArray.setBounds(204, 106, 45, 15);
		txtIndeksTambahArray.setBounds(251, 106, 54, 19);
		txtTambahArray.setBounds(42, 135, 263, 19);
		txtTambahArray.setEditable(false);
		btnTambahArray.setBounds(324, 135, 114, 19);
		myWindow.add(lblTambahArray);
		myWindow.add(lblNilai);
		myWindow.add(txtNilai);
		myWindow.add(lblIndeksTambahArray);
		myWindow.add(txtIndeksTambahArray);
		myWindow.add(txtTambahArray);
		myWindow.add(btnTambahArray);

		/*Objek hapus array*/
		lblHapusArray.setBounds(125, 166, 96, 15);
		lblIndeksHapusArray.setBounds(31, 182, 45, 15);
		txtIndeksHapusArray.setBounds(78, 182, 54, 19);
		txtHapusArray.setBounds(42, 213, 263, 19);
		txtHapusArray.setEditable(false);
		btnHapusArray.setBounds(324, 213, 114, 19);
		myWindow.add(lblHapusArray);
		myWindow.add(lblIndeksHapusArray);
		myWindow.add(txtIndeksHapusArray);
		myWindow.add(txtHapusArray);
		myWindow.add(btnHapusArray);

		/*Fungsi Button Array*/
		btnArray.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtArray.setText(null);
				for(i=0; i<10; i++){
					a[i] = rand.nextInt(range);
					txtArray.setText(txtArray.getText()+a[i]+" ");
				}
			}
		});

		/*Fungsi button salin terbalik*/
		btnSalinTerbalik.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int[] b = new int[10];
				int bantu = 10;

				txtSalinTerbalik.setText(null);
				for(i=0; i<10; i++){
					bantu -= 1;
					b[i] = a[bantu];
					txtSalinTerbalik.setText(txtSalinTerbalik.getText()+b[i]+" ");
				}
			}
		});

		/*Fungsi button tambah array*/
		btnTambahArray.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int nilai = Integer.valueOf(txtNilai.getText());
				int indeks = Integer.valueOf(txtIndeksTambahArray.getText());
				int[] b = new int[11];

				txtTambahArray.setText(null);
				for(i=0; i<indeks; i++){
					b[i] = a[i];
				}
				for(i=indeks; i<=indeks;i++){
					b[i] = nilai;
				}
				for(i=(indeks+1); i<11; i++){
					b[i] = a[i-1];
				}
				for(i=0; i<11; i++){
					txtTambahArray.setText(txtTambahArray.getText()+b[i]+" ");
				}
			}
		});

		/*Fungsi button hapus array*/
		btnHapusArray.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int indeks = Integer.valueOf(txtIndeksHapusArray.getText());
				int[] b = new int[9];

				txtHapusArray.setText(null);
				for(i=0; i<indeks; i++){
					b[i] = a[i];
				}
				for(i=indeks; i<9; i++){
					b[i] = a[i+1];
				}
				for(i=0; i<9; i++){
					txtHapusArray.setText(txtHapusArray.getText()+b[i]+" ");
				}
			}
		});
	}
}