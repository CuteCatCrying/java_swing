package invers;
import determinan.Determinan;

public class Invers{
	Determinan D = new Determinan();

	/*Membuat bilangan desimal ke rasional*/
	public String rasional(int num, int denum){
		int i,gcd = 1;
		double kecil,numHasil,denumHasil;
		String hasil;

		/* Jika num dan denum sama negatif, maka cari yang angka negatif yang mendekati nol */
		if(num < 0 && denum < 0){
			kecil = (num < denum) ? denum : num;
		}else{
			kecil = (num < denum) ? num : denum;
		}
		
		/* Kecil harus di absolutkan, karena jika kecil bernilai negatif
		for akan break */
		for(i=1; i<=Math.abs(kecil); i++){
			if(num%i == 0 && denum%i == 0){
				gcd = i;
			}
		}
		numHasil = (double)num/gcd;
		denumHasil = (double)denum/gcd;

		if(num == 0){
			/* Jika num 0 */
			hasil = "0";
		}else{
			if(numHasil < 0 && denumHasil < 0){
				/* Jika num dan denum sama negatif, dijadikan positif */
				hasil = String.format("%.0f/%.0f", (-1*numHasil), (-1*denumHasil));
			}else{
				hasil = String.format("%.0f/%.0f", numHasil, denumHasil);
			}
		}
		return hasil;
	}

	public int[][] adj2x2(int[][] a){
		/*Variable untuk adjoin matriks*/
		int[][] b = new int[2][2];
	
		/*Matriks a akan disalin ke b*/
		/*B11*/ b[0][0] = a[1][1];
		/*B12*/ b[0][1] = (-1)*a[0][1];
		
		/*B21*/ b[1][0] = (-1)*a[1][0];
		/*B22*/ b[1][1] = a[0][0];
		
		return b;
	}

	public String[][] inv2x2(int[][] a){
		int det = D.cariDeterminan2x2(a);
		int[][] b = adj2x2(a);
		int i,j;

		/*Menyalin dari b ke c yang sudah dirasionalkan, kenapa d harus string, karena fungsi pada rasional mengembalikan
		nilai String*/
		String[][] c = new String[2][2];
		for(i=0; i<2; i++){
			for(j=0; j<2; j++){
				c[i][j] = rasional(b[i][j],det);
			}
		}

		return c;
	}

	public int[][] adj3x3(int[][] a){
		int i,j;
		int[][] b = new int[3][3];
		int[][] c = new int[2][2]; /* Matrik untuk menampung elemen yang akan
		dideterminankan, setelah itu hasilnya akan disalin ke matriks b */
		int[][] d = new int[3][3]; /* Matrik untuk mentransposkan matrik b */

		/* Metode minor dan kofaktor */
		/* Menentukan minor */
		/* Minor dari B00 */
		for(i=0; i<2; i++){
			for(j=0; j<2; j++){
				c[i][j] = a[i+1][j+1];
			}
		}
		b[0][0] = D.cariDeterminan2x2(c);

		/* Minor dari B01 */
		for(i=0; i<2; i++){
			for(j=0; j<2; j++){
				if(j == 0){
					c[i][j] = a[i+1][j];
				}else{
					c[i][j] = a[i+1][j+1];
				}
			}
		}
		b[0][1] = D.cariDeterminan2x2(c);

		/* Minor dari B02 */
		for(i=0; i<2; i++){
			for(j=0; j<2; j++){
				c[i][j] = a[i+1][j];
			}
		}
		b[0][2] = D.cariDeterminan2x2(c);

		/* Minor dari B10 */
		for(i=0; i<2; i++){
			for(j=0; j<2; j++){
				if(i == 1){
					c[i][j] = a[i+1][j+1];
				}else{
					c[i][j] = a[i][j+1];
				}
			}
		}
		b[1][0] = D.cariDeterminan2x2(c);
		
		/* Minor dari B11 */
		c[0][0] = a[0][0];
		c[0][1] = a[0][2];
		c[1][0] = a[2][0];
		c[1][1] = a[2][2];
		b[1][1] = D.cariDeterminan2x2(c);
		
		/* Minor dari B12 */
		for(i=0; i<2; i++){
			for(j=0; j<2; j++){
				if(i == 1){
					c[i][j] = a[i+1][j];
				}else{
					c[i][j] = a[i][j];
				}
			}
		}
		b[1][2] = D.cariDeterminan2x2(c);
		
		/* Minor dari B20 */
		for(i=0; i<2; i++){
			for(j=0; j<2; j++){
				c[i][j] = a[i][j+1];
			}
		}
		b[2][0] = D.cariDeterminan2x2(c);
		
		/* Minor dari B21 */
		for(i=0; i<2; i++){
			for(j=0; j<2; j++){
				if(j == 1){
					c[i][j] = a[i][j+1];
				}else{
					c[i][j] = a[i][j];
				}
			}
		}
		b[2][1] = D.cariDeterminan2x2(c);
		
		/* Minor dari B22 */
		for(i=0; i<2; i++){
			for(j=0; j<2; j++){
				c[i][j] = a[i][j];
			}
		}
		b[2][2] = D.cariDeterminan2x2(c);

		/* Mencari kofaktor dengan cara */
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				if((i+j)%2 == 0){
					b[i][j] = 1*b[i][j];
				}else{
					b[i][j] = (-1)*b[i][j];
				}
			}
		}

		/* Mencari adjoin dengan cara mentranspos */
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
					d[i][j] = b[j][i];
			}
		}
		return d;
	}

	public String[][] inv3x3(int[][] a){
		int det = D.cariDeterminan3x3(a);
		int i,j;
		int[][] d = adj3x3(a);
		String[][] e = new String[3][3]; /* Matrik hasil */

		/* Mencari invers */
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				e[i][j] = rasional(d[i][j], det);
			}
		}

		return e;
	}

	public int[][] adj4x4(int[][] a){
		int i,j;
		
		/* METODE SARRUS */
		int[][] b = new int[4][4];/* Matriks yang berfungsi untuk menyimpan hasil dari determinan-determinan
		elemen pada matriks c */
		int[][] c = new int[3][3];/* Matriks yang berfungsi untuk menyimpan hasil dari minor matriks a */
		int[][] d = new int[4][4];/* Matirks untuk mentransposkan matriks b hasil determinan */

		/* B00 */
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				c[i][j] = a[i+1][j+1];
			}
		}
		b[0][0] = D.cariDeterminan3x3(c);
		
		/* B01 */
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				if(j >= 1){
					c[i][j] = a[i+1][j+1];
				}else{
					c[i][j] = a[i+1][j];
				}
			}
		}
		b[0][1] = D.cariDeterminan3x3(c);
		
		/* B02 */
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				if(j >= 2){
					c[i][j] = a[i+1][j+1];
				}else{
					c[i][j] = a[i+1][j];
				}
			}
		}
		b[0][2] = D.cariDeterminan3x3(c);
		
		/* B03 */
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				c[i][j] = a[i+1][j];
			}
		}
		b[0][3] = D.cariDeterminan3x3(c);
		
		/* B10 */
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				if(i >= 1){
					c[i][j] = a[i+1][j+1];
				}else{
					c[i][j] = a[i][j+1];
				}
			}
		}
		b[1][0] = D.cariDeterminan3x3(c);
		
		/* B11 */
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				if(i == 0){
					if(j < 1){
						c[i][j] = a[i][j];
					}else{
						c[i][j] = a[i][j+1];
					}
				}else if(i == 1){
					if(j < 1){
						c[i][j] = a[i+1][j];
					}else{
						c[i][j] = a[i+1][j+1];
					}
				}else{
					if(j < 1){
						c[i][j] = a[i+1][j];
					}else{
						c[i][j] = a[i+1][j+1];
					}
				}
			}
		}
		b[1][1] = D.cariDeterminan3x3(c);
		
		/* B12 */
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				if(i == 0){
					if(j < 2){
						c[i][j] = a[i][j];
					}else{
						c[i][j] = a[i][j+1];
					}
				}else if(i == 1){
					if(j < 2){
						c[i][j] = a[i+1][j];
					}else{
						c[i][j] = a[i+1][j+1];
					}
				}else{
					if(j < 2){
						c[i][j] = a[i+1][j];
					}else{
						c[i][j] = a[i+1][j+1];
					}
				}
			}
		}
		b[1][2] = D.cariDeterminan3x3(c);
		
		/* B13 */
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				if(i < 1){
					c[i][j] = a[i][j];
				}else{
					c[i][j] = a[i+1][j];
				}
			}
		}
		b[1][3] = D.cariDeterminan3x3(c);
		
		/* B20 */
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				if(i < 2){
					c[i][j] = a[i][j+1];
				}else{
					c[i][j] = a[i+1][j+1];
				}
			}
		}
		b[2][0] = D.cariDeterminan3x3(c);
		
		/* B21 */
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				if(i == 0){
					if(j < 1){
						c[i][j] = a[i][j];
					}else{
						c[i][j] = a[i][j+1];
					}
				}else if(i == 1){
					if(j < 1){
						c[i][j] = a[i][j];
					}else{
						c[i][j] = a[i][j+1];
					}
				}else{
					if(j < 1){
						c[i][j] = a[i+1][j];
					}else{
						c[i][j] = a[i+1][j+1];
					}
				}
			}
		}
		b[2][1] = D.cariDeterminan3x3(c);
		
		/* B22 */
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				if(i == 0){
					if(j < 2){
						c[i][j] = a[i][j];
					}else{
						c[i][j] = a[i][j+1];
					}
				}else if(i == 1){
					if(j < 2){
						c[i][j] = a[i][j];
					}else{
						c[i][j] = a[i][j+1];
					}
				}else{
					if(j < 2){
						c[i][j] = a[i+1][j];
					}else{
						c[i][j] = a[i+1][j+1];
	   				}
				}
			}
		}
		b[2][2] = D.cariDeterminan3x3(c);
		
		/* B23 */
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				if(i < 2){
					c[i][j] = a[i][j];
				}else{
					c[i][j] = a[i+1][j];
				}
			}
		}
		b[2][3] = D.cariDeterminan3x3(c);
		
		/* B30 */
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				c[i][j] = a[i][j+1];
			}
		}
		b[3][0] = D.cariDeterminan3x3(c);
		
		/* B31 */
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				if(j < 1){
					c[i][j] = a[i][j];
				}else{
					c[i][j] = a[i][j+1];
				}
			}
		}
		b[3][1] = D.cariDeterminan3x3(c);
		
		/* B32 */
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				if(j < 2){
					c[i][j] = a[i][j];
				}else{
					c[i][j] = a[i][j+1];
				}
			}
		}
		b[3][2] = D.cariDeterminan3x3(c);
		
		/* B33 */
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				c[i][j] = a[i][j];
			}
		}
		b[3][3] = D.cariDeterminan3x3(c);

		/* Mencari kofaktor dengan cara */
		for(i=0; i<4; i++){
			for(j=0; j<4; j++){
				if((i+j)%2 == 0){
					b[i][j] = 1*b[i][j];
				}else{
					b[i][j] = (-1)*b[i][j];
				}
			}
		}
		
		/* Mentransposkan matriks b atau adjoin*/
		for(i=0; i<4; i++){
			for(j=0; j<4; j++){
				d[i][j] = b[j][i];
			}
		}

		return d;
	}

	public String[][] inv4x4(int[][] a){
		int i,j;
		int det = D.cariDeterminan4x4(a);
		int[][] d = adj4x4(a);

		String[][] e = new String[4][4];/* Matriks hasil */

		/* Proses final */
		for(i=0; i<4; i++){
			for(j=0; j<4; j++){
				e[i][j] = rasional(d[i][j], det);
			}
		}
		return e;
	}
}