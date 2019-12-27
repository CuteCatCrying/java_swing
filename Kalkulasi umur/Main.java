package kelasKalkulasiUmur;

/*Fungsi yang mengoptimalasiasi program,
antrian peristiwa*/
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font; // Untuk Font

/*Package Menu*/
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/*Package untuk fungsi rata tengah*/
import javax.swing.text.StyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/*Package components*/
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

/*Pacakage untuk fungsi button generate*/
import java.time.Period;
import java.time.LocalDate;

class Window{
	String[] bulan = {
		"Januari",
		"Feburari",
		"Maret",
		"April",
		"Mei",
		"Juni",
		"Juli",
		"Agustus",
		"September",
		"Oktober",
		"November",
		"Desember"
	};

	/*Deklarasi variable components*/
	JFrame myWindow = new JFrame();
	JLabel lblTglLahir = new JLabel("Tanggal lahir");
	JTextField txtTglLahir = new JTextField();
	JTextField txtTahunLahir = new JTextField();
	JComboBox cmbBlnLahir = new JComboBox(bulan);
	JLabel lblHari = new JLabel("Hari");
	JTextField txtHari = new JTextField();
	JLabel lblBulan = new JLabel("Bulan");
	JTextField txtBulan = new JTextField();
	JLabel lblTahun = new JLabel("Tahun");
	JTextField txtTahun = new JTextField();
	JLabel lblUmurAnda = new JLabel("Umur anda");
	JButton btnGenerate = new JButton("Generate");

	/*Deklarasi variable* menu*/
	JMenuBar menuBar = new JMenuBar();
	JMenu menu,menu2;
	JMenuItem i1,i2;

	Window(){
		/*Penyetingan components*/
		/*Main Frame*/
		myWindow.setTitle("Kalkulasi umur");
		myWindow.setSize(350,193);
		myWindow.setLocationRelativeTo(null);
		myWindow.setVisible(true);
		myWindow.setLayout(null);
		myWindow.setResizable(false);
		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*Combo box*/
		cmbBlnLahir.setBounds(166, 10, 97, 24);

		/*Label*/
		lblTglLahir.setBounds(28, 15, 100, 15);
		lblHari.setBounds(67, 61, 35, 15);
		lblBulan.setBounds(121, 61, 45, 15);
		lblTahun.setBounds(195, 61, 54, 15);
		lblUmurAnda.setBounds(100, 42, 81, 15);

		/*Text Field*/
		txtTglLahir.setBounds(132, 13, 26, 19);
		txtTahunLahir.setBounds(275, 13, 42, 19);
		txtHari.setBounds(69, 76, 26, 19);
		txtBulan.setBounds(131, 76, 26, 19);
		txtTahun.setBounds(205, 76, 26, 19);

		/*Button*/
		btnGenerate.setBounds(101, 107, 114, 25);

		/*Penambahan components ke Main Frame*/
		/*Combo box*/
		myWindow.add(cmbBlnLahir);

		/*Label*/
		myWindow.add(lblTglLahir);
		myWindow.add(lblHari);
		myWindow.add(lblBulan);
		myWindow.add(lblTahun);
		myWindow.add(lblUmurAnda);

		/*Text Field*/
		myWindow.add(txtTglLahir);
		myWindow.add(txtTahunLahir);
		myWindow.add(txtHari);
		myWindow.add(txtBulan);
		myWindow.add(txtTahun);

		/*Button*/
		myWindow.add(btnGenerate);

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
				txtPaneAbout.setText("Author\nZukron Alviandy Rahmadhan\n14 Mei 2019");
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

		/*Fungsi button generate*/
		btnGenerate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtHari.setText(null);
				txtBulan.setText(null);
				txtTahun.setText(null);
				LocalDate tglSekarang = LocalDate.now();
				LocalDate tglLahir;
				Period perbedaanTgl;

				int hariLahir = Integer.valueOf(txtTglLahir.getText());
				int blnLahir = cmbBlnLahir.getSelectedIndex();
				int thnLahir = Integer.valueOf(txtTahunLahir.getText());
				blnLahir +=1;

				tglLahir = LocalDate.of(thnLahir,blnLahir,hariLahir);
				perbedaanTgl = Period.between(tglLahir,tglSekarang);

				txtHari.setText(String.valueOf(perbedaanTgl.getDays()));
				txtBulan.setText(String.valueOf(perbedaanTgl.getMonths()));
				txtTahun.setText(String.valueOf(perbedaanTgl.getYears()));
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