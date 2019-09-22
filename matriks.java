import java.io.*;
import java.util.Scanner;


public class matriks {
    Scanner input = new Scanner(System.in);
    /**
     * Properties
     */
    public double[][] Mat;
    public int idxBaris = 0;

    /**
     * banyaknya/ukuran kolom yg terdefinisi
     */
    public int idxKolom = 0;

    /**
     * Konstruktor
     */
    public matriks (int i, int j)
    {
        double [][] this.Mat = new double [i][j]; 
        this.idxBaris = i;
        this.idxKolom = j;
    }

    public double getElement(int i, int j) {
        return this.Mat[i][j];
    }

    public int getidxBaris() {
        return this.idxBaris;
    }

    public int setidxBaris(int newidxBaris) {
        return this.idxBaris = newidxBaris;
    }

    public int getidxKolom() {
        return this.idxKolom;
    }

    public int setidxKolom(int newidxKolom) {
        return this.idxKolom = newidxKolom;
    }

    /**
     * Determinan Cofactor
     */
    public void getCofactor(double temp[][], int p, int q, int n) {
        int i = 0, j = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {

                // Jika elemet berindeks [p,q] maka akan dilewati
                if (row != p && col != q) {
                    temp[i][j++] = this.Mat[row][col];

                    // Row is filled, so increase
                    // row index and reset col
                    // index
                    if (j == n - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }

    /*
     * Recursive function for finding determinant of matrix. n is current dimension
     * of mat[][].
     */
    public double determinantOfMatrix(double mat[][], int n) {
        int D = 0; // Set hasil akhir determinan

        // Hanya satu elemen
        if (n == 1)
            return mat[0][0];

        // To store cofactors
        double temp[][] = new double[this.getidxBaris()][this.getidxKolom()];

        // Untuk mengganti-ganti tanda saat menghitung determinan
        int sign = 1;

        // Menggunakan rumus mat[0][0]* cofactor mat[0][0] + ... + mat[0][f] * cofactor
        // mat[0][f]
        for (int f = 0; f < n; f++) {
            // Getting Cofactor of mat[0][f]
            getCofactor(temp, 0, f, n);
            D += sign * mat[0][f] * determinantOfMatrix(temp, n - 1);

            // terms are to be added with
            // alternate sign
            sign = -sign;
        }

        return D;
    }

    public void getMatriksCofactor(double result[][]) {
        double temp[][] = result;
        for (int i = 0; i < getidxBaris(); i++) {
            for (int j = 0; j < getidxKolom(); j++) {
                this.getCofactor(temp, i, j, getidxBaris());
                result[i][j] = determinantOfMatrix(temp, getidxBaris() - 1);
            }
        }
    }

    public void getTranspose(double result[][]) 
    {

    }

    public void getAdjoin(double result[][]) {
        matriks cofactor = new matriks();
        this.getMatriksCofactor(cofactor.Mat);
        getTranspose(cofactor.Mat);
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

  public double GetDeterminanOBE(double[][] matriks1)
    //I.S Matriks sudah mengalami Eliminasi Gauss
    {   
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
        for(int i=this.idxBaris-1; i>=0; i--){
            a=true;
            for (int j=0; j<this.idxKolom-1 && a==true; j++){
                if(matriks1[i][j]!=0){    
                    for (int l=1; i-l>=0 ;l++){
                        c=matriks1[i-l][j]/matriks1[i][j];
                        for (int k=0; k<this.idxKolom ; k++ ){
                            matriks1[i-l][k]-=c*matriks1[i][k];
                            if (matriks1[i][k]==-0.00){
                                matriks1[i][k]=0.00;
                            }
                        }
                    }
                    double pembagi=matriks1[i][j];
                    for (int k=0; k<this.idxKolom ; k++ ){
                        matriks1[i][k]=matriks1[i][k] / pembagi;
                        if (matriks1[i][k]==-0.00){
                            matriks1[i][k]=0.00;
                        }
                    }
                    a=false;
                }
            }
        }
        public void BacaMatriks() 
        {
            for(int i=0; i<this.idxBaris; i++){
                for(int j=0; j<this.idxKolom; j++){
                    this.Mat[i][j] = input.nextDouble();
                }
            }    
        } 
    
        public void BacaMatriksFromFile(String f) {
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
            catch (FileNotFoundException e) {
                System.out.println(e);
            }
            catch (IOException e) {
                System.out.println(e);
            }
        }
        
        public void TulisMatriks() 
        {
            for(int i=0; i<this.idxBaris; i++){
                for(int j=0; j<this.idxKolom; j++){
                    System.out.format("%.2f ",this.Mat[i][j]);
                }
                System.out.println();
            }
        }
        
        public void TulisMatriksToFile() {
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
            catch (Exception e) {
                System.out.println(e);
            }
        }
    
        public void Interpolasi() {
            int N = input.nextInt();
            double x,y;
    
            this.SetIndeks(N, N+1);
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
}
