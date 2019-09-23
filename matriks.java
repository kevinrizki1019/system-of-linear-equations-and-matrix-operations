// TUBES ALJABAR LINEAR DAN GEOMETRI 
// Nama Kelompok: Kelompok16_13518072_13518100_13518141

/*
BASIC:
    Buat nama yang meaningful
    Tulis comment seperlunya untuk membantu
*/

import java.io.*;
import java.util.Scanner;

public class matriks 
{
    Scanner input = new Scanner(System.in);

    /*** PROPERTIES ***/
    public double[][] Mat;
    private int idxBaris = 0;     /* banyaknya ukuran baris yg terdefinisi */
    private int idxKolom = 0;     /* banyaknya ukuran kolom yg terdefinisi */
    private double determinan = 1;

    /*** METHOD ***/
    /* KONSTRUKTOR */    
    public matriks () {
    /* Membentuk object matriks dengan semua nilai properties berisi nilai default*/
    }

    public matriks (int i, int j) {
    /* Membentuk object matriks dengan nilai properties sesuai*/ 
        this.Mat = new double [i][j]; 
        this.idxBaris = i;
        this.idxKolom = j;
    }

    /* SELEKTOR untuk Object matriks yang terdefinisi */
    public double getElement(int i, int j) {
    /* Mengirimkan element(i,j) pada property Mat[][] */
        return this.Mat[i][j];
    }
    public int getidxBaris() {
    /* Mengirimkan nilai property idxBaris yaitu jumlah baris pada matriks */
        return this.idxBaris;
    }
    public int getidxKolom() {
    /* Mengirimkan nilai property idxKolom yaitu jumlah kolom pada matriks */
        return this.idxKolom;
    }
    
    /* SETTER untuk menggasign properies pada Object */
    public void setidxBaris(int newidxBaris) {
    /* Mengassign nilai property idxBaris pada object dengan nilai yang baru newidxBaris 
       I.S. Object terdefinisi
       F.S. Property idxBaris pada Object berganti*/
        this.idxBaris = newidxBaris;
    }
    public void setidxKolom(int newidxKolom) {
    /* Mengassign nilai property idxKolom pada object dengan nilai yang baru newidxKolom 
       I.S. Object terdefinisi
       F.S. Property idxKolom pada Object berganti*/
        this.idxKolom = newidxKolom;
    }
    public void setidx(int newidxBaris, int newidxKolom) {
    /* Mengasign nilai property idxBaris pada object dengan nwidxBaris dan nilai property idxKolom dengan newidxKolom 
       I.S. Object terdefinisi
       F.S. Property idxBaris dan idxKolom pada Object berganti */
        this.setidxBaris(newidxBaris);
        this.setidxKolom(newidxKolom);
    }

    /* KELOMPOK BACA/TULIS */
    public void BacaMatriks() {
    /* I.S. Object matriks terdefinisi nilai idxBaris dan idxKolomnya */
    /* F.S. M terdefinisi nilai semua elemennya, berukuran sesuai property objectnya
            yaitu idxBaris x idxKolom */
    /* Proses: Mengisi semua nilai elemen pada propety mat[][] sesuai yan terbaca dari masukan keyboard*/
    /* Selanjutnya membaca nilai elemen per baris dan kolom */
    /* Contoh: Jika idxBaris = 3 dan idxKolom = 3, maka contoh cara membaca isi matriks :
    1 2 3
    4 5 6
    8 9 10
    */
        for(int i=0; i<this.idxBaris; i++){
            for(int j=0; j<this.idxKolom; j++){
                this.Mat[i][j] = input.nextDouble();
            }
        }    
    } 
    public void BacaMatriksFromFile(String f) {
    /* I.S. Object matriks terdefinisi nilai idxBaris dan idxKolomnya */
    /* F.S. M terdefinisi nilai semua elemennya, berukuran sesuai property objectnya
            yaitu idxBaris x idxKolom */
    /* Proses: Mengisi semua nilai elemen pada propety mat[][] sesuai yang terbaca dari file f*/
        File file = new File(f);
    
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
    
            int i=0;
            int kol=0;
            while((st = br.readLine()) != null) {
                String[] words = st.split("\\s+");
                for (int j=0; j<words.length; j++) {
                    double d = Double.parseDouble(words[j]);
                    this.Mat[i][j] = d;
                }
                kol = words.length;
                i++;
            }
            this.idxBaris = i;
            this.idxKolom = kol;
        }
        // Kasus jika terjadi kegagalan dalam membaca file
        catch (FileNotFoundException e) {
            System.out.println(e);
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
    public void TulisMatriks() {
    /* I.S. Object matriks terdefinisi semua */
    /* F.S. Nilai property Mat[i][j] ditulis ke layar per baris per kolom, masing-masing elemen per baris
    dipisahkan sebuah spasi */
    /* Proses: Menulis nilai setiap elemen Mat ke layar dengan traversal per baris dan per kolom */
    /* Contoh: menulis matriks 3x3  (d akhir tiap baris tidak ada spasi dan diakhir baris terdapat enter)
    1 2 3
    4 5 6
    8 9 10
    */
        for(int i=0; i<this.idxBaris; i++){
            for(int j=0; j<this.idxKolom; j++){
                System.out.format("%.2f ",this.Mat[i][j]);
            }
            System.out.println();
        }
    }
    public void TulisMatriksToFile() {
    /* I.S. Object matriks terdefinisi semua */
    /* F.S. Nilai property Mat[i][j] ditulis ke file per baris per kolom, masing-masing elemen per baris
    dipisahkan sebuah spasi */
    /* Proses: Menulis nilai setiap elemen Mat ke file dengan traversal per baris dan per kolom */
        String fileName = input.nextLine();
        try {
            FileWriter fw = new FileWriter(fileName);
            for(int i=0; i<this.idxBaris; i++){
                for(int j=0; j<this.idxKolom; j++){
                    fw.write(Double.toString(this.Mat[i][j]));
                    if (j!= this.idxKolom-1) {
                        fw.write(" ");
                    }
                }
                if (i != this.idxBaris-1) {
                    fw.write(String.format("%n"));
                }
            }
            fw.close();
        }
        // Kasus jika terjadi kegagalan dalam menulis ke file
        catch (Exception e) {
            System.out.println(e);
        }
    }

    /* KELOMPOK OPERASI PADA MATRIKS*/
    public double[][] getCofactor(double matIn[][], int p, int q, int n) {
        // I.S. temp terdefinisi dan berukuran n-1 X n-1
        // F.s. temp berisi matriks cofactor p,q dari this.Mat 
        int i = 0, j = 0;

        double[][] matOut = new double[n-1][n-1]; 
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {

                // Jika elemet berindeks [p,q] maka akan dilewati
                if (row != p && col != q) {
                    matOut[i][j++] = matIn[row][col];

                    if (j == (n - 1)) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
        return matOut;
    }
    public double determinantOfMatrix(double mat[][], int n) {
        /* Prekondisi: matriks mat terdefinisi dengan ukuran sebesar n X n */
        /* Fungsi determinantOfMatrix mengembalikan nilai determinan dari matriks mat */
        /* Untuk ngetes coba di https://www.iotools.net/math/matrix-determinant-calculator */
        
        // Set hasil akhir determinan
        double D = 0; 

        // Basis jika hanya satu elemen
        if (n == 1) {
            D += mat[0][0];
            return (D);
        } else {
            // Untuk mengganti-ganti tanda saat menghitung determinan
            int sign = 1;

            for (int f = 0; f < n; f++) {
                // Mendapatkan matriks cofactor pada mat[0][f]
                double temp[][];
                temp = getCofactor(mat, 0, f, n);

                // Menggunakan rumus mat[0][0]* cofactor mat[0][0] +-... + mat[0][f] * cofactor mat[0][f]
                D += sign * mat[0][f] * determinantOfMatrix(temp, n-1);

                // Nilai sign berganti antara 1 dan -1
                sign = -1 * sign;
            }
            return (D);
        }
    }
    public double[][] getMatriksCofactor(double matIn[][], int n) {
        /* Prekondisi: matIn terdefinisi isinya dan berukuran n X n */
        /* Fungsi getMatriksCofactor mengembalikan sebuah double[][]
           yaitu matriks kofaktor hasil peng-kofaktoran terhadap matIn */
        double temp[][] = new double[n-1][n-1];
        double matOut[][] = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp = getCofactor(matIn, i, j, n);
                if ((i+j) % 2 == 0) {
                    matOut[i][j] = determinantOfMatrix(temp, n - 1);
                } else {
                    matOut[i][j] = -1 * determinantOfMatrix(temp, n - 1);    
                }
            }
        }
        return matOut;
    }
    public double[][] getTranspose(double[][] matIn, int n, int m) {
        double[][] matTranspose;
        int i,j;        
        
        matTranspose = new double[m][n];
        for (i=0; i<m; i++) {
            for (j=0; j<n; j++) {
                matTranspose[i][j] = this.Mat[j][i];
            }
        }
        return matTranspose;
    }

    public void getAdjoin(double result[][]) {
        matriks cofactor = new matriks();
        cofactor.Mat = getMatriksCofactor(this.Mat, idxBaris);
        getTranspose(cofactor.Mat, cofactor.idxBaris, cofactor.idxKolom);
        result = cofactor.Mat;
    }
    public void GaussElimination(double[][] matriks1)
    {
        double c=0;
        for(int j=0; j<this.idxKolom-1; j++){             //akses Eliminasi
            for(int i=0; i<this.idxBaris; i++){         //Per Kolom yang mana j menyatakan kolom dan i menyatakan baris
                if(i>j){
                    int idx=0;
                    int l=1;
                    if (matriks1[j][j]==0){
                        for (idx=0; j+idx<this.idxKolom-1 && l!=this.idxBaris+1; idx++){    
                            for (l=1; l<this.idxBaris-i;l++){
                                if(matriks1[j][j+idx]!=0){
                                    l=this.idxBaris+1;
                                }
                                else{
                                    tukar(matriks1,j,j+l);
                                    determinan*=-1;
                                }
                            }
                        }
                    }
                    if (matriks1[j][j+idx]!=0){
                        c=matriks1[i][j]/ matriks1[j][j+idx];
                        for(int k=0; k<this.idxKolom; k++){  //pengurangan matriks per baris
                            matriks1[i][k]=matriks1[i][k]-c*matriks1[j][k];
                            if(matriks1[i][k]==-0){
                                    matriks1[i][k]=0;
                                }
                         }
                    }
                }
            }
        }
    }

    public void tukar(double [][] matriks, int Brs1, int Brs2)
    //I.S Brs1 adalah Baris yang ingin ditukar untuk berada pada Brs2 dengan elemen Brs1 tidak berubah (hanya berubah letak saja)
    {
        double temp;
        for (int j=0; j<idxKolom; j++ ){
            temp=matriks[Brs1][j];
            matriks[Brs1][j]=matriks[Brs2][j];
            matriks[Brs2][j]=temp;
        }
    }

  public double GetDeterminanOBE(double[][] matriks1)
    //I.S Matriks sudah mengalami Eliminasi Gauss
    {   
        double determinan = 1;
        for (int i=0; i<this.idxBaris; i++){
            determinan = determinan* matriks1[i][i];
        }
        return determinan;
        
    }
  
  public void GaussJordanElimination(double[][] matriks1)
    // I.S Matriks tidak boleh mengalami OBE SEBELUMNYA!!
    {
        double c;
        boolean a=true;
        for(int i=this.idxBaris-1; i>=0; i--)
        {
            a=true;
            for (int j=0; j<this.idxKolom-1 && a==true; j++)
            {
                if(matriks1[i][j]!=0)
                {    
                    for (int l=1; i-l>=0 ;l++)
                    {
                        c=matriks1[i-l][j]/matriks1[i][j];
                        for (int k=0; k<this.idxKolom ; k++ )
                        {
                            matriks1[i-l][k]-=c*matriks1[i][k];

                            if (matriks1[i][k]==-0.00)
                            {
                                matriks1[i][k]=0.00;
                            }
                        }
                    }
                    double pembagi=matriks1[i][j];
                    for (int k=0; k<this.idxKolom ; k++ )
                    {
                        matriks1[i][k]=matriks1[i][k] / pembagi;
                        if (matriks1[i][k]==-0.00)
                        {
                            matriks1[i][k]=0.00;
                        }
                    }
                    a=false;
                }
            }
        }
    }
    
        public void Interpolasi() {
            int N = input.nextInt();
            double x,y;
    
            this.setidx(N, N+1);
            for (int i=0; i<N; i++) {
                x = input.nextDouble();
                y = input.nextDouble();
                for (int j=0; j<N+1; j++) {
                    if (j != N){
                        this.Mat[i][j] = Math.pow(x, j);
                    } else {
                        this.Mat[i][j] = y;
                    }
                }
            }
            this.TulisMatriks();
        }       
            
        public void KaliMatriks(matriks matriks2) // tanpa augmented
        {
            if (this.idxKolom != matriks2.idxBaris)
                System.out.println("The matrices can't be multiplied with each other.");
            else
            {
                double sum = 0;
                int i,j,k,l;
                i = this.idxBaris;
                j = this.idxKolom;

                k = matriks2.idxBaris;
                l = matriks2.idxKolom;
                int a,b,c;
                for ( a = 0; a < i; a++)
                {
                    for ( b = 0; b < l; b++)
                    {
                        for (c = 0; c < k; c++ )
                        {
                            sum = sum + this.getElement(a, c) * matriks2.getElement(c, b);
                        }
                    }   

                    this.Mat[a][b] = sum;
                    sum = 0;
                    
                }

            }
        }
        
        public void getSPLCrammer()
        {
            matriks temp = new matriks (this.getidxBaris(), this.getidxKolom() - 1);
            if (temp.getidxBaris() == temp.getidxKolom())
            {
                for (int i = 0; i < temp.getidxBaris(); i++)
                {
                    for (int j = 0; j < temp.getidxKolom(); j++)
                    {
                        temp.Mat[i][j] = this.getElement(i, j);
                    }
                }
                double [] D = new double [temp.getidxKolom()];
                double [] solution = new double [temp.getidxKolom()];
                D[0] = determinantOfMatrix(temp.Mat, temp.getidxKolom());
                if ( D[0] != 0)
                {
                    for(int j = 0; j < temp.getidxKolom(); j++)
                    {
                        for(int i = 0; i < temp.getidxKolom(); i++)
                        {
                            
                        }
                    }
                }
            }
            
        }
}
