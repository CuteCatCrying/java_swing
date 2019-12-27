package kelasDendaPerpustakaan;

/*Fungsi yang mengoptimalasiasi program,
antrian peristiwa*/
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font; // Untuk Font

/*Package components*/
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

/*Package Menu*/
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/*Package untuk fungsi rata tengah*/
import javax.swing.text.StyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/*Package Waktu java*/
/*Package tambahan untuk menhitung perbedaan tanggal*/
import java.time.Period;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

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
	/*Deklarasi component*/
	JFrame myWindows = new JFrame();
	JButton btnGenerate = new JButton("Generate");
	JLabel lblTglPinjam = new JLabel("Tanggal pinjam");
	JLabel lblTglSekarang = new JLabel("Tanggal sekarang");
	JComboBox cmbTglPinjam = new JComboBox(bulan);
	JTextField txtTglPinjam = new JTextField();
	JTextField txtTglSekarang = new JTextField();
	JTextField txtHasilDenda = new JTextField();

	/*Deklarasi variable* menu*/
	JMenuBar menuBar = new JMenuBar();
	JMenu menu,menu2;
	JMenuItem i1,i2;

	Window(){
		/*Penyetingan Components*/
		/*Button*/
		btnGenerate.setBounds(110, 97, 114, 25);
		/*Label*/
		lblTglSekarang.setBounds(105, 42, 132, 15);
		lblTglPinjam.setBounds(33, 15, 106, 15);
		/*Combo box*/
		cmbTglPinjam.setBounds(204, 10, 100, 24);
		/*Text field*/
		txtTglPinjam.setBounds(168, 13, 27, 19);
		txtTglSekarang.setBounds(110, 57, 114, 19);
		txtTglSekarang.setEditable(false);
		txtHasilDenda.setBounds(110, 134, 114, 19);

		/*FRAME*/
		myWindows.setTitle("Denda perpustakaan");
		myWindows.setSize(330,214);
		myWindows.setLocationRelativeTo(null); // untuk posisi ditengah
		myWindows.setResizable(false);
		myWindows.setLayout(null);
		myWindows.setVisible(true);
		myWindows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*penambahan Components*/
		/*Button*/
		myWindows.add(btnGenerate);
		/*Label*/
		myWindows.add(lblTglPinjam);
		myWindows.add(lblTglSekarang);
		/*Textfield*/
		myWindows.add(txtTglPinjam);
		myWindows.add(txtHasilDenda);
		myWindows.add(txtTglSekarang);
		/*Combo box*/
		myWindows.add(cmbTglPinjam);

		/*MENU*/
		menu = new JMenu("File");
		menu2 = new JMenu("Help");
		i1 = new JMenuItem("About");
		i2 = new JMenuItem("Tutorial");

		menu.add(i1);
		menu2.add(i2);

		menuBar.add(menu);
		menuBar.add(menu2);

		myWindows.setJMenuBar(menuBar);

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

		/*FUNGSI FUNGSI PADA COMPONENT*/
		btnGenerate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtHasilDenda.setText(null);
				LocalDate tanggalSekarang = LocalDate.now();
				LocalDate tanggalPinjam;

				/*Sintaks-sintaks pengganti*/
				// String value = cmbTglPinjam.getItemAt(cmbTglPinjam.getSelectedIndex());
				// String value2 = cmbTglSekarang.getSelectedItem().toString();
				// int nilaiTglSekarang = Integer.valueOf(txtTglSekarang.getText());
				
				int nilaiTglPinjam = Integer.valueOf(txtTglPinjam.getText());
				int bulanPinjam = cmbTglPinjam.getSelectedIndex();
				/*Kerana indeks dimulai dari 0 jadi harus ditambah 1*/
				bulanPinjam += 1;
				int hasilDenda;

				/*Proses mencari perbedaan*/
				tanggalPinjam = LocalDate.of(Integer.valueOf(tanggalSekarang.getYear()),bulanPinjam,nilaiTglPinjam);
				long bedaHari = ChronoUnit.DAYS.between(tanggalPinjam,tanggalSekarang);

				if(bedaHari >= 7){
					hasilDenda = ((int) bedaHari-6) * 200;
					String hasil = String.format("Rp. %d",hasilDenda);
					txtHasilDenda.setText(String.valueOf(hasil));
				}else if(bedaHari < 0){
					txtHasilDenda.setText("Invalid Date");
				}else{
					hasilDenda = 0;
					String hasil = String.format("Rp. %d",hasilDenda);
					txtHasilDenda.setText(String.valueOf(hasil));
				}
				String tanggalSekarangFormat = tanggalSekarang.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
				txtTglSekarang.setText(tanggalSekarangFormat);
			}
		});
	}
}

public class Main{
	static void excute(){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				new Window();
			}
		});
	}
	public static void main(String[] args){
		excute();

	}
}