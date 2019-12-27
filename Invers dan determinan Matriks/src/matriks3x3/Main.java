package matriks3x3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import menu.MenuBar;
import determinan.Determinan;
import invers.Invers;

class Panel{
    Determinan D = new Determinan();
    Invers I = new Invers();

    JPanel panelMatriks3x3(){
        JPanel matriks3x3 = new JPanel();

        /* Penginputan*/
        JTextField a11 = new JTextField();
        JTextField a12 = new JTextField();
        JTextField a13 = new JTextField();
        /* ---------------------------- */
        JTextField a21 = new JTextField();
        JTextField a22 = new JTextField();
        JTextField a23 = new JTextField();
        /* ---------------------------- */
        JTextField a31 = new JTextField();
        JTextField a32 = new JTextField();
        JTextField a33 = new JTextField();

        /* Determinan */
        JLabel lblDet = new JLabel("Det =");
        JTextField txtDet = new JTextField();

        /* Adjoin */
        JLabel lblAdj = new JLabel("Adj =");
        JTextField adjA11 = new JTextField();
        JTextField adjA12 = new JTextField();
        JTextField adjA13 = new JTextField();
        /* ---------------------------- */
        JTextField adjA21 = new JTextField();
        JTextField adjA22 = new JTextField();
        JTextField adjA23 = new JTextField();
        /* ---------------------------- */
        JTextField adjA31 = new JTextField();
        JTextField adjA32 = new JTextField();
        JTextField adjA33 = new JTextField();

        /* Invers */
        JLabel lblInv = new JLabel("Inv =");
        JTextField invA11 = new JTextField();
        JTextField invA12 = new JTextField();
        JTextField invA13 = new JTextField();
        /* ---------------------------- */
        JTextField invA21 = new JTextField();
        JTextField invA22 = new JTextField();
        JTextField invA23 = new JTextField();
        /* ---------------------------- */
        JTextField invA31 = new JTextField();
        JTextField invA32 = new JTextField();
        JTextField invA33 = new JTextField();

        /* Other */
        JButton btnHitung = new JButton("Hitung");

        /* Panel */
        matriks3x3.setLayout(null);
        matriks3x3.setBounds(27, 10, 283, 259);

        /* Text Field */
        a11.setBounds(23, 0, 39, 19);
        a12.setBounds(74, 0, 39, 19);
        a13.setBounds(125, 0, 39, 19);
        /* ---------------------------- */
        a21.setBounds(23, 25, 39, 19);
        a22.setBounds(74, 25, 39, 19);
        a23.setBounds(125, 25, 39, 19);
        /* ---------------------------- */
        a31.setBounds(23, 50, 39, 19);
        a32.setBounds(74, 50, 39, 19);
        a33.setBounds(125, 50, 39, 19);
        /* ---------------------------- */
        matriks3x3.add(a11);
        matriks3x3.add(a12);
        matriks3x3.add(a13);
        /* ---------------------------- */
        matriks3x3.add(a21);
        matriks3x3.add(a22);
        matriks3x3.add(a23);
        /* ---------------------------- */
        matriks3x3.add(a31);
        matriks3x3.add(a32);
        matriks3x3.add(a33);

        adjA11.setBounds(55, 100, 53, 19);
        adjA12.setBounds(115, 100, 53, 19);
        adjA13.setBounds(175, 100, 53, 19);
        adjA21.setBounds(55, 125, 53, 19);
        adjA22.setBounds(115, 125, 53, 19);
        adjA23.setBounds(175, 125, 53, 19);
        adjA31.setBounds(55, 150, 53, 19);
        adjA32.setBounds(115, 150, 53, 19);
        adjA33.setBounds(175, 150, 53, 19);
        // Center text //
        adjA11.setHorizontalAlignment(JTextField.CENTER);
        adjA12.setHorizontalAlignment(JTextField.CENTER);
        adjA13.setHorizontalAlignment(JTextField.CENTER);
        adjA21.setHorizontalAlignment(JTextField.CENTER);
        adjA22.setHorizontalAlignment(JTextField.CENTER);
        adjA23.setHorizontalAlignment(JTextField.CENTER);
        adjA31.setHorizontalAlignment(JTextField.CENTER);
        adjA32.setHorizontalAlignment(JTextField.CENTER);
        adjA33.setHorizontalAlignment(JTextField.CENTER);
        adjA11.setEditable(false);
        adjA12.setEditable(false);
        adjA13.setEditable(false);
        adjA21.setEditable(false);
        adjA22.setEditable(false);
        adjA23.setEditable(false);
        adjA31.setEditable(false);
        adjA32.setEditable(false);
        adjA33.setEditable(false);
        matriks3x3.add(adjA11);
        matriks3x3.add(adjA12);
        matriks3x3.add(adjA13);
        matriks3x3.add(adjA21);
        matriks3x3.add(adjA22);
        matriks3x3.add(adjA23);
        matriks3x3.add(adjA31);
        matriks3x3.add(adjA32);
        matriks3x3.add(adjA33);

        invA11.setBounds(55, 175, 53, 19);
        invA12.setBounds(116, 175, 53, 19);
        invA13.setBounds(175, 175, 53, 19);
        invA21.setBounds(55, 200, 53, 19);
        invA22.setBounds(116, 200, 53, 19);
        invA23.setBounds(175, 200, 53, 19);
        invA31.setBounds(55, 225, 53, 19);
        invA32.setBounds(116, 225, 53, 19);
        invA33.setBounds(175, 225, 53, 19);
        // Center TEXT //
        invA11.setHorizontalAlignment(JTextField.CENTER);
        invA12.setHorizontalAlignment(JTextField.CENTER);
        invA13.setHorizontalAlignment(JTextField.CENTER);
        invA21.setHorizontalAlignment(JTextField.CENTER);
        invA22.setHorizontalAlignment(JTextField.CENTER);
        invA23.setHorizontalAlignment(JTextField.CENTER);
        invA31.setHorizontalAlignment(JTextField.CENTER);
        invA32.setHorizontalAlignment(JTextField.CENTER);
        invA33.setHorizontalAlignment(JTextField.CENTER);
        invA11.setEditable(false);
        invA12.setEditable(false);
        invA13.setEditable(false);
        invA21.setEditable(false);
        invA22.setEditable(false);
        invA23.setEditable(false);
        invA31.setEditable(false);
        invA32.setEditable(false);
        invA33.setEditable(false);
        matriks3x3.add(invA11);
        matriks3x3.add(invA12);
        matriks3x3.add(invA13);
        matriks3x3.add(invA21);
        matriks3x3.add(invA22);
        matriks3x3.add(invA23);
        matriks3x3.add(invA31);
        matriks3x3.add(invA32);
        matriks3x3.add(invA33);

        txtDet.setBounds(55, 75, 39, 19);
        txtDet.setHorizontalAlignment(JTextField.CENTER);
        txtDet.setEditable(false);
        matriks3x3.add(txtDet);

        /* Label */
        lblDet.setBounds(12, 75, 42, 15);
        matriks3x3.add(lblDet);

        lblAdj.setBounds(12, 100, 39, 15);
        matriks3x3.add(lblAdj);

        lblInv.setBounds(12, 175, 39, 15);
        matriks3x3.add(lblInv);

        /* Tombol */
        btnHitung.setBounds(187, 19, 81, 25);
        matriks3x3.add(btnHitung);

        /* Prose perhitungan determinan dan invers */
        btnHitung.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                /*Mengkonversikan dari text field ke int*/
                int konvA11 = Integer.valueOf(a11.getText());
                int konvA12 = Integer.valueOf(a12.getText());
                int konvA13 = Integer.valueOf(a13.getText());

                int konvA21 = Integer.valueOf(a21.getText());
                int konvA22 = Integer.valueOf(a22.getText());
                int konvA23 = Integer.valueOf(a23.getText());
                
                int konvA31 = Integer.valueOf(a31.getText());
                int konvA32 = Integer.valueOf(a32.getText());
                int konvA33 = Integer.valueOf(a33.getText());

                int[][] A = {
                    {konvA11,konvA12,konvA13},
                    {konvA21,konvA22,konvA23},
                    {konvA31,konvA32,konvA33}
                };

                txtDet.setText(String.valueOf(D.cariDeterminan3x3(A)));

                int[][] B = I.adj3x3(A);
                adjA11.setText(String.valueOf(B[0][0]));
                adjA12.setText(String.valueOf(B[0][1]));
                adjA13.setText(String.valueOf(B[0][2]));

                adjA21.setText(String.valueOf(B[1][0]));
                adjA22.setText(String.valueOf(B[1][1]));
                adjA23.setText(String.valueOf(B[1][2]));

                adjA31.setText(String.valueOf(B[2][0]));
                adjA32.setText(String.valueOf(B[2][1]));
                adjA33.setText(String.valueOf(B[2][2]));

                String[][] C = I.inv3x3(A);
                invA11.setText(C[0][0]);
                invA12.setText(C[0][1]);
                invA13.setText(C[0][2]);

                invA21.setText(C[1][0]);
                invA22.setText(C[1][1]);
                invA23.setText(C[1][2]);

                invA31.setText(C[2][0]);
                invA32.setText(C[2][1]);
                invA33.setText(C[2][2]);
            }
        });

        return matriks3x3;
    }
}

class Window extends MenuBar{
    JFrame mainFrame;

    Panel P = new Panel();
    Window() {
        /* Main Frame */
        mainFrame = new JFrame();
        mainFrame.setTitle("Invers Determinan Matriks");
        mainFrame.setSize(335,332);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Menu */
        mainFrame.setJMenuBar(getMenuBar());
        mainFrame.add(P.panelMatriks3x3());
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