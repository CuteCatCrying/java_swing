package matriks2x2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import invers.Invers;
import determinan.Determinan;
import menu.MenuBar;

class Panel{
    Determinan D = new Determinan();
    Invers I = new Invers();

    JPanel panelMatriks2x2(){
        JPanel matriks2x2 = new JPanel();

        /* Penginputan*/
        JTextField a11 = new JTextField();
        JTextField a12 = new JTextField();
        JTextField a21 = new JTextField();
        JTextField a22 = new JTextField();

        /* Determinan */
        JLabel lblDet = new JLabel("Det =");
        JTextField txtDet = new JTextField();

        /* Adjoin */
        JLabel lblAdj = new JLabel("Adj =");
        JTextField adjA11 = new JTextField();
        JTextField adjA12 = new JTextField();
        JTextField adjA21 = new JTextField();
        JTextField adjA22 = new JTextField();

        /* Invers */
        JLabel lblInv = new JLabel("Inv =");
        JTextField invA11 = new JTextField();
        JTextField invA12 = new JTextField();
        JTextField invA21 = new JTextField();
        JTextField invA22 = new JTextField();

        /* Other */
        JButton btnHitung = new JButton("Hitung");

        /* Panel */
        matriks2x2.setLayout(null);
        matriks2x2.setBounds(27, 10, 241, 183);

        /* Text Field */
        a11.setBounds(23, 0, 39, 19);
        a12.setBounds(74, 0, 39, 19);
        a21.setBounds(23, 25, 39, 19);
        a22.setBounds(74, 25, 39, 19);
        matriks2x2.add(a11);
        matriks2x2.add(a12);
        matriks2x2.add(a21);
        matriks2x2.add(a22);

        adjA11.setBounds(43, 82, 53, 19);
        adjA12.setBounds(104, 82, 53, 19);
        adjA21.setBounds(43, 107, 53, 19);
        adjA22.setBounds(104, 107, 53, 19);
        // Center text //
        adjA11.setHorizontalAlignment(JTextField.CENTER);
        adjA12.setHorizontalAlignment(JTextField.CENTER);
        adjA21.setHorizontalAlignment(JTextField.CENTER);
        adjA22.setHorizontalAlignment(JTextField.CENTER);
        adjA11.setEditable(false);
        adjA12.setEditable(false);
        adjA21.setEditable(false);
        adjA22.setEditable(false);
        matriks2x2.add(adjA11);
        matriks2x2.add(adjA12);
        matriks2x2.add(adjA21);
        matriks2x2.add(adjA22);

        invA11.setBounds(43, 135, 53, 19);
        invA12.setBounds(104, 135, 53, 19);
        invA21.setBounds(43, 160, 53, 19);
        invA22.setBounds(104, 160, 53, 19);
        invA11.setHorizontalAlignment(JTextField.CENTER);
        invA12.setHorizontalAlignment(JTextField.CENTER);
        invA21.setHorizontalAlignment(JTextField.CENTER);
        invA22.setHorizontalAlignment(JTextField.CENTER);
        invA11.setEditable(false);
        invA12.setEditable(false);
        invA21.setEditable(false);
        invA22.setEditable(false);
        matriks2x2.add(invA11);
        matriks2x2.add(invA12);
        matriks2x2.add(invA21);
        matriks2x2.add(invA22);

        txtDet.setBounds(43, 56, 53, 19);
        txtDet.setHorizontalAlignment(JTextField.CENTER);
        txtDet.setEditable(false);
        matriks2x2.add(txtDet);

        /* Label */
        lblDet.setBounds(0, 56, 42, 15);
        matriks2x2.add(lblDet);

        lblAdj.setBounds(0, 82, 39, 15);
        matriks2x2.add(lblAdj);

        lblInv.setBounds(0, 135, 39, 15);
        matriks2x2.add(lblInv);

        /* Tombol */
        btnHitung.setBounds(148, 12, 81, 25);
        matriks2x2.add(btnHitung);

        /* Prose perhitungan determinan dan invers */
        btnHitung.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                /* Mengkonversi dari text field ke integer */
                int konvA11 = Integer.valueOf(a11.getText());
                int konvA12 = Integer.valueOf(a12.getText());
                int konvA21 = Integer.valueOf(a21.getText());
                int konvA22 = Integer.valueOf(a22.getText());
                int[][] A = {
                    {konvA11,konvA12},
                    {konvA21,konvA22}
                };

                txtDet.setText(String.valueOf(D.cariDeterminan2x2(A)));

                int[][] B = I.adj2x2(A);
                adjA11.setText(String.valueOf(B[0][0]));
                adjA12.setText(String.valueOf(B[0][1]));
                adjA21.setText(String.valueOf(B[1][0]));
                adjA22.setText(String.valueOf(B[1][1]));

                String[][] C = I.inv2x2(A);
                invA11.setText(C[0][0]);
                invA12.setText(C[0][1]);
                invA21.setText(C[1][0]);
                invA22.setText(C[1][1]);
            }
        });

        return matriks2x2;
    }
}

class Window extends MenuBar{
    JPanel mainPanel;
    JLabel lblMatriks;
    JFrame mainFrame;

    Panel P = new Panel();

    Window() {
        /* Main Frame */
        mainFrame = new JFrame();
        mainFrame.setTitle("Invers Determinan Matriks");
        mainFrame.setSize(300,254);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Menu */
        mainFrame.setJMenuBar(getMenuBar());
        mainFrame.add(P.panelMatriks2x2());
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