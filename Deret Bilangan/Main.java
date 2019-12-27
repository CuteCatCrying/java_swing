package kelasDeretBilangan;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main{
	public static void main(String[] args) {
		JFrame myWindow = new JFrame();
		JLabel lblBeda = new JLabel("Beda");
		JTextField txtBeda = new JTextField();
		JLabel lblBanyak = new JLabel("Banyak Deret");
		JTextField txtBanyak = new JTextField();
		JLabel lblPeringatan = new JLabel("Maksimal banyak deret 18");

		JTextField txtHasil = new JTextField("Deret hasil");
		JButton btnCek = new JButton("Cek");

		/*Frame*/
		myWindow.setTitle("Deret Bilangan");
		myWindow.setSize(411, 200);
		myWindow.setVisible(true);
		myWindow.setLayout(null);
		myWindow.setResizable(false);
		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*Beda*/
		lblBeda.setBounds(85, 24, 66, 15);
		txtBeda.setBounds(134, 22, 124, 19);
		myWindow.add(lblBeda);
		myWindow.add(txtBeda);

		/*Banyak deret*/
		lblBanyak.setBounds(29, 57, 104, 15);
		txtBanyak.setBounds(134, 55, 69, 19);
		myWindow.add(lblBanyak);
		myWindow.add(txtBanyak);

		/*Peringatan*/
		lblPeringatan.setBounds(29,86,300,19);
		myWindow.add(lblPeringatan);

		/*Hasil dan Cek*/
		txtHasil.setBounds(29, 120, 350, 19);
		txtHasil.setEditable(false);
		btnCek.setBounds(304, 33, 77, 63);
		myWindow.add(txtHasil);
		myWindow.add(btnCek);

		/*Proses tombol cek*/
		btnCek.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int interval = Integer.valueOf(txtBeda.getText());
				int n = Integer.valueOf(txtBanyak.getText());
				int hasilDeret = 0;

				txtHasil.setText(null);
				if(n<=18){
					for(int i=1; i<=n; i++){
						txtHasil.setText(txtHasil.getText()+hasilDeret+" ");
						hasilDeret += interval;
					}
				}else{
					txtHasil.setText("Kelebihan batas");
				}
			}
		});
	}
}