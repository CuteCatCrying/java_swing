package matriks4x4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import menu.MenuBar;
import determinan.Determinan;
import invers.Invers;

class Panel{
    Determinan D = new Determinan();
    Invers I = new Invers();

    JPanel panelMatriks4x4(){
        JPanel matriks4x4 = new JPanel();

        /* Penginputan*/
        JTextField a11 = new JTextField();
        JTextField a12 = new JTextField();
        JTextField a13 = new JTextField();
        JTextField a14 = new JTextField();
        /* ---------------------------- */
        JTextField a21 = new JTextField();
        JTextField a22 = new JTextField();
        JTextField a23 = new JTextField();
        JTextField a24 = new JTextField();
        /* ---------------------------- */
        JTextField a31 = new JTextField();
        JTextField a32 = new JTextField();
        JTextField a33 = new JTextField();
        JTextField a34 = new JTextField();
        /* ---------------------------- */
        JTextField a41 = new JTextField();
        JTextField a42 = new JTextField();
        JTextField a43 = new JTextField();
        JTextField a44 = new JTextField();

        /* Determinan */
        JLabel lblDet = new JLabel("Det =");
        JTextField txtDet = new JTextField();

        /* Adjoin */
        JLabel lblAdj = new JLabel("Adj =");
        JTextField adjA11 = new JTextField();
        JTextField adjA12 = new JTextField();
        JTextField adjA13 = new JTextField();
        JTextField adjA14 = new JTextField();
        /* ---------------------------- */
        JTextField adjA21 = new JTextField();
        JTextField adjA22 = new JTextField();
        JTextField adjA23 = new JTextField();
        JTextField adjA24 = new JTextField();
        /* ---------------------------- */
        JTextField adjA31 = new JTextField();
        JTextField adjA32 = new JTextField();
        JTextField adjA33 = new JTextField();
        JTextField adjA34 = new JTextField();
        /* ---------------------------- */
        JTextField adjA41 = new JTextField();
        JTextField adjA42 = new JTextField();
        JTextField adjA43 = new JTextField();
        JTextField adjA44 = new JTextField();

        /* Invers */
        JLabel lblInv = new JLabel("Inv =");
        JTextField invA11 = new JTextField();
        JTextField invA12 = new JTextField();
        JTextField invA13 = new JTextField();
        JTextField invA14 = new JTextField();
        /* ---------------------------- */
        JTextField invA21 = new JTextField();
        JTextField invA22 = new JTextField();
        JTextField invA23 = new JTextField();
        JTextField invA24 = new JTextField();
        /* ---------------------------- */
        JTextField invA31 = new JTextField();
        JTextField invA32 = new JTextField();
        JTextField invA33 = new JTextField();
        JTextField invA34 = new JTextField();
        /* ---------------------------- */
        JTextField invA41 = new JTextField();
        JTextField invA42 = new JTextField();
        JTextField invA43 = new JTextField();
        JTextField invA44 = new JTextField();

        /* Other */
        JButton btnHitung = new JButton("Hitung");

        /* Panel */
        matriks4x4.setLayout(null);
        matriks4x4.setBounds(26, 12, 323, 330);

        /* Text Field */
        a11.setBounds(23, 0, 39, 19);
        a12.setBounds(74, 0, 39, 19);
        a13.setBounds(125, 0, 39, 19);
        a14.setBounds(176, 0, 39, 19);
        /* ---------------------------- */
        a21.setBounds(23, 25, 39, 19);
        a22.setBounds(74, 25, 39, 19);
        a23.setBounds(125, 25, 39, 19);
        a24.setBounds(176, 25, 39, 19);
        /* ---------------------------- */
        a31.setBounds(23, 50, 39, 19);
        a32.setBounds(74, 50, 39, 19);
        a33.setBounds(125, 50, 39, 19);
        a34.setBounds(176, 50, 39, 19);
        /* ---------------------------- */
        a41.setBounds(23, 75, 39, 19);
        a42.setBounds(74, 75, 39, 19);
        a43.setBounds(125, 75, 39, 19);
        a44.setBounds(176, 75, 39, 19);
        /* ---------------------------- */
        matriks4x4.add(a11);
        matriks4x4.add(a12);
        matriks4x4.add(a13);
        matriks4x4.add(a14);
        /* ---------------------------- */
        matriks4x4.add(a21);
        matriks4x4.add(a22);
        matriks4x4.add(a23);
        matriks4x4.add(a24);
        /* ---------------------------- */
        matriks4x4.add(a31);
        matriks4x4.add(a32);
        matriks4x4.add(a33);
        matriks4x4.add(a34);
        /* ---------------------------- */
        matriks4x4.add(a41);
        matriks4x4.add(a42);
        matriks4x4.add(a43);
        matriks4x4.add(a44);

        adjA11.setBounds(55, 125, 53, 19);
        adjA12.setBounds(115, 125, 53, 19);
        adjA13.setBounds(175, 125, 53, 19);
        adjA14.setBounds(235, 125, 53, 19);
        /* ---------------------------- */
        adjA21.setBounds(55, 150, 53, 19);
        adjA22.setBounds(115, 150, 53, 19);
        adjA23.setBounds(175, 150, 53, 19);
        adjA24.setBounds(235, 150, 53, 19);
        /* ---------------------------- */
        adjA31.setBounds(55, 175, 53, 19);
        adjA32.setBounds(115, 175, 53, 19);
        adjA33.setBounds(175, 175, 53, 19);
        adjA34.setBounds(235, 175, 53, 19);
        /* ---------------------------- */
        adjA41.setBounds(55, 200, 53, 19);
        adjA42.setBounds(115, 200, 53, 19);
        adjA43.setBounds(175, 200, 53, 19);
        adjA44.setBounds(235, 200, 53, 19);
        // Center text //
        adjA11.setHorizontalAlignment(JTextField.CENTER);
        adjA12.setHorizontalAlignment(JTextField.CENTER);
        adjA13.setHorizontalAlignment(JTextField.CENTER);
        adjA14.setHorizontalAlignment(JTextField.CENTER);
        /* ---------------------------- */
        adjA21.setHorizontalAlignment(JTextField.CENTER);
        adjA22.setHorizontalAlignment(JTextField.CENTER);
        adjA23.setHorizontalAlignment(JTextField.CENTER);
        adjA24.setHorizontalAlignment(JTextField.CENTER);
        /* ---------------------------- */
        adjA31.setHorizontalAlignment(JTextField.CENTER);
        adjA32.setHorizontalAlignment(JTextField.CENTER);
        adjA33.setHorizontalAlignment(JTextField.CENTER);
        adjA34.setHorizontalAlignment(JTextField.CENTER);
        /* ---------------------------- */
        adjA41.setHorizontalAlignment(JTextField.CENTER);
        adjA42.setHorizontalAlignment(JTextField.CENTER);
        adjA43.setHorizontalAlignment(JTextField.CENTER);
        adjA44.setHorizontalAlignment(JTextField.CENTER);
        /* ---------------------------- */
        adjA11.setEditable(false);
        adjA12.setEditable(false);
        adjA13.setEditable(false);
        adjA14.setEditable(false);
        /* ---------------------------- */
        adjA21.setEditable(false);
        adjA22.setEditable(false);
        adjA23.setEditable(false);
        adjA24.setEditable(false);
        /* ---------------------------- */
        adjA31.setEditable(false);
        adjA32.setEditable(false);
        adjA33.setEditable(false);
        adjA34.setEditable(false);
        /* ---------------------------- */
        adjA41.setEditable(false);
        adjA42.setEditable(false);
        adjA43.setEditable(false);
        adjA44.setEditable(false);
        /* ---------------------------- */
        matriks4x4.add(adjA11);
        matriks4x4.add(adjA12);
        matriks4x4.add(adjA13);
        matriks4x4.add(adjA14);
        /* ---------------------------- */
        matriks4x4.add(adjA21);
        matriks4x4.add(adjA22);
        matriks4x4.add(adjA23);
        matriks4x4.add(adjA24);
        /* ---------------------------- */
        matriks4x4.add(adjA31);
        matriks4x4.add(adjA32);
        matriks4x4.add(adjA33);
        matriks4x4.add(adjA34);
        /* ---------------------------- */
        matriks4x4.add(adjA41);
        matriks4x4.add(adjA42);
        matriks4x4.add(adjA43);
        matriks4x4.add(adjA44);
        /* ---------------------------- */

        invA11.setBounds(55, 225, 53, 19);
        invA12.setBounds(115, 225, 53, 19);
        invA13.setBounds(175, 225, 53, 19);
        invA14.setBounds(235, 225, 53, 19);
        /* ---------------------------- */
        invA21.setBounds(55, 250, 53, 19);
        invA22.setBounds(115, 250, 53, 19);
        invA23.setBounds(175, 250, 53, 19);
        invA24.setBounds(235, 250, 53, 19);
        /* ---------------------------- */
        invA31.setBounds(55, 275, 53, 19);
        invA32.setBounds(115, 275, 53, 19);
        invA33.setBounds(175, 275, 53, 19);
        invA34.setBounds(235, 275, 53, 19);
        /* ---------------------------- */
        invA41.setBounds(55, 300, 53, 19);
        invA42.setBounds(115, 300, 53, 19);
        invA43.setBounds(175, 300, 53, 19);
        invA44.setBounds(235, 300, 53, 19);
        // Center TEXT //
        invA11.setHorizontalAlignment(JTextField.CENTER);
        invA12.setHorizontalAlignment(JTextField.CENTER);
        invA13.setHorizontalAlignment(JTextField.CENTER);
        invA14.setHorizontalAlignment(JTextField.CENTER);
        /* ---------------------------- */
        invA21.setHorizontalAlignment(JTextField.CENTER);
        invA22.setHorizontalAlignment(JTextField.CENTER);
        invA23.setHorizontalAlignment(JTextField.CENTER);
        invA24.setHorizontalAlignment(JTextField.CENTER);
        /* ---------------------------- */
        invA31.setHorizontalAlignment(JTextField.CENTER);
        invA32.setHorizontalAlignment(JTextField.CENTER);
        invA33.setHorizontalAlignment(JTextField.CENTER);
        invA34.setHorizontalAlignment(JTextField.CENTER);
        /* ---------------------------- */
        invA41.setHorizontalAlignment(JTextField.CENTER);
        invA42.setHorizontalAlignment(JTextField.CENTER);
        invA43.setHorizontalAlignment(JTextField.CENTER);
        invA44.setHorizontalAlignment(JTextField.CENTER);
        /* ---------------------------- */
        invA11.setEditable(false);
        invA12.setEditable(false);
        invA13.setEditable(false);
        invA14.setEditable(false);
        /* ---------------------------- */
        invA21.setEditable(false);
        invA22.setEditable(false);
        invA23.setEditable(false);
        invA24.setEditable(false);
        /* ---------------------------- */
        invA31.setEditable(false);
        invA32.setEditable(false);
        invA33.setEditable(false);
        invA34.setEditable(false);
        /* ---------------------------- */
        invA41.setEditable(false);
        invA42.setEditable(false);
        invA43.setEditable(false);
        invA44.setEditable(false);
        /* ---------------------------- */
        matriks4x4.add(invA11);
        matriks4x4.add(invA12);
        matriks4x4.add(invA13);
        matriks4x4.add(invA14);
        /* ---------------------------- */
        matriks4x4.add(invA21);
        matriks4x4.add(invA22);
        matriks4x4.add(invA23);
        matriks4x4.add(invA24);
        /* ---------------------------- */
        matriks4x4.add(invA31);
        matriks4x4.add(invA32);
        matriks4x4.add(invA33);
        matriks4x4.add(invA34);
        /* ---------------------------- */
        matriks4x4.add(invA41);
        matriks4x4.add(invA42);
        matriks4x4.add(invA43);
        matriks4x4.add(invA44);

        txtDet.setBounds(55, 100, 53, 19);
        txtDet.setHorizontalAlignment(JTextField.CENTER);
        txtDet.setEditable(false);
        matriks4x4.add(txtDet);

        /* Label */
        lblDet.setBounds(12, 100, 42, 15);
        matriks4x4.add(lblDet);

        lblAdj.setBounds(12, 125, 39, 15);
        matriks4x4.add(lblAdj);

        lblInv.setBounds(12, 225, 39, 15);
        matriks4x4.add(lblInv);

        /* Tombol */
        btnHitung.setBounds(230, 22, 81, 25);
        matriks4x4.add(btnHitung);

        /* Prose perhitungan determinan dan invers */
        btnHitung.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                /*Mengkonversikan dari text field ke int*/
                int konvA11 = Integer.valueOf(a11.getText());
                int konvA12 = Integer.valueOf(a12.getText());
                int konvA13 = Integer.valueOf(a13.getText());
                int konvA14 = Integer.valueOf(a14.getText());

                int konvA21 = Integer.valueOf(a21.getText());
                int konvA22 = Integer.valueOf(a22.getText());
                int konvA23 = Integer.valueOf(a23.getText());
                int konvA24 = Integer.valueOf(a24.getText());
                
                int konvA31 = Integer.valueOf(a31.getText());
                int konvA32 = Integer.valueOf(a32.getText());
                int konvA33 = Integer.valueOf(a33.getText());
                int konvA34 = Integer.valueOf(a34.getText());

                int konvA41 = Integer.valueOf(a41.getText());
                int konvA42 = Integer.valueOf(a42.getText());
                int konvA43 = Integer.valueOf(a43.getText());
                int konvA44 = Integer.valueOf(a44.getText());

                int[][] A = {
                    {konvA11,konvA12,konvA13,konvA14},
                    {konvA21,konvA22,konvA23,konvA24},
                    {konvA31,konvA32,konvA33,konvA34},
                    {konvA41,konvA42,konvA43,konvA44}
                };

                txtDet.setText(String.valueOf(D.cariDeterminan4x4(A)));

                int[][] B = I.adj4x4(A);
                adjA11.setText(String.valueOf(B[0][0]));
                adjA12.setText(String.valueOf(B[0][1]));
                adjA13.setText(String.valueOf(B[0][2]));
                adjA14.setText(String.valueOf(B[0][3]));

                adjA21.setText(String.valueOf(B[1][0]));
                adjA22.setText(String.valueOf(B[1][1]));
                adjA23.setText(String.valueOf(B[1][2]));
                adjA24.setText(String.valueOf(B[1][3]));

                adjA31.setText(String.valueOf(B[2][0]));
                adjA32.setText(String.valueOf(B[2][1]));
                adjA33.setText(String.valueOf(B[2][2]));
                adjA34.setText(String.valueOf(B[2][3]));

                adjA41.setText(String.valueOf(B[3][0]));
                adjA42.setText(String.valueOf(B[3][1]));
                adjA43.setText(String.valueOf(B[3][2]));
                adjA44.setText(String.valueOf(B[3][3]));

                String[][] C = I.inv4x4(A);
                invA11.setText(C[0][0]);
                invA12.setText(C[0][1]);
                invA13.setText(C[0][2]);
                invA14.setText(C[0][3]);

                invA21.setText(C[1][0]);
                invA22.setText(C[1][1]);
                invA23.setText(C[1][2]);
                invA24.setText(C[1][3]);

                invA31.setText(C[2][0]);
                invA32.setText(C[2][1]);
                invA33.setText(C[2][2]);
                invA34.setText(C[2][3]);

                invA41.setText(C[3][0]);
                invA42.setText(C[3][1]);
                invA43.setText(C[3][2]);
                invA44.setText(C[3][3]);
            }
        });

        return matriks4x4;
    }
}

class Window extends MenuBar{
    JFrame mainFrame;

    Panel P = new Panel();
    Window() {
        /* Main Frame */
        mainFrame = new JFrame();
        mainFrame.setTitle("Invers Determinan Matriks");
        mainFrame.setSize(361,410);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Menu */
        mainFrame.setJMenuBar(getMenuBar());
        mainFrame.add(P.panelMatriks4x4());
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