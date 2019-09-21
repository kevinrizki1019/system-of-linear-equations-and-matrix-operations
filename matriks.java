import java.util.Scanner;

// ----- ----- Class 2: Matriks ----- -----


public class matriks 
{
    /**
     * Properties
     */
    public final static int BRS_MAX = 100;

    public final static int KOL_MAX = 100;
    

    public double[][] tabel = new double[BRS_MAX][KOL_MAX] ;
        /**
         * banyaknya/ukuran baris yg terdefinisi
         */
    public int NBrsEff = 0 ;
    
        /**
         * banyaknya/ukuran kolom yg terdefinisi
         */
    public int NKolEff = 0;

     /**
     * Konstruktor
     */


    public double getElement(int i, int j) 
    {
        return this.tabel[i][j] ;
    }
    
    

        public int getNBrsEff() 
        {
            return this.NBrsEff;
        }

        public int setNBrsEff(int newNBrsEff) 
        {
            return this.NBrsEff = newNBrsEff;
        }
    
        public int getNKolEff() 
        {
            return this.NKolEff;
        }
    
        public int setNKolEff(int newNKolEff) 
        {
            return this.NKolEff = newNKolEff;
        }

    /**
     * Determinan Cofactor
     */
    public void getCofactor(double temp[][], int p, int q, int n) 
    { 
        int i = 0, j = 0; 
      
        for (int row = 0; row < n; row++) 
        { 
            for (int col = 0; col < n; col++) 
            { 
                  
                // Jika elemet berindeks [p,q] maka akan dilewati
                if (row != p && col != q) 
                { 
                    temp[i][j++] = this.tabel[row][col]; 
      
                    // Row is filled, so increase  
                    // row index and reset col  
                    //index 
                    if (j == n - 1) 
                    { 
                        j = 0; 
                        i++; 
                    } 
                } 
            } 
        } 
    } 
      
    /* Recursive function for finding determinant 
    of matrix. n is current dimension of mat[][]. */
    public double determinantOfMatrix(double mat[][], int n) 
    { 
        int D = 0; // Set hasil akhir determinan
      
        // Hanya satu elemen
        if (n == 1) 
            return mat[0][0]; 
          
        // To store cofactors 
        double temp[][] = new double[getNBrsEff()][getNKolEff()];  
          
        // Untuk mengganti-ganti tanda saat menghitung determinan
        int sign = 1;  
      
        // Menggunakan rumus mat[0][0]* cofactor mat[0][0] + ... + mat[0][f] * cofactor mat[0][f]
        for (int f = 0; f < n; f++) 
        { 
            // Getting Cofactor of mat[0][f] 
            getCofactor(temp, 0, f, n); 
            D += sign * mat[0][f]  
               * determinantOfMatrix(temp, n - 1); 
      
            // terms are to be added with  
            // alternate sign 
            sign = -sign; 
        } 
      
        return D; 
    } 

    public void getMatriksCofactor(double result[][])
    {
        double temp [][] = result;
        for (int i = 0; i < getNBrsEff(); i++)
        {
            for (int j = 0; j < getNKolEff(); j++ )
            {
                this.getCofactor(temp, i, j, getNBrsEff());
                result [i][j] = determinantOfMatrix(temp, getNBrsEff() - 1);
            }
        }
    }
    public void getTranspose (double result[][])
    {

    }
    public void getAdjoin (double result[][])
    {
        matriks cofactor = new matriks();
        this.getMatriksCofactor(cofactor.tabel);
        getTranspose(cofactor.tabel);
        result = cofactor.tabel;
    }
}
