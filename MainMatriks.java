import java.util.Scanner;

public class MainMatriks {
    public static void main(String[] args) {
        int n,m;
        Scanner input = new Scanner(System.in);
        
        n = input.nextInt();
        m = input.nextInt();
<<<<<<< HEAD
    
        matriks M = new matriks(n,m);
        M.BacaMatriks();

        // double[][] c = new double[n][n];
        // c= M.getMatriksCofactor(n);

        // for (int i=0; i<n; i++) {
        //     for (int j=0; j<n; j++) {
        //         System.out.print(c[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        // double d = M.determinantOfMatrix(M.Mat,n);
        // System.out.println(d);
=======
        matriks M = new matriks(n,m);
        M.BacaMatriks();

        double[][] c = new double[n][n];
        c= M.getMatriksCofactor(M.Mat,n);
>>>>>>> 38dcc5e5e7d7f6f7889746785ac774c5e2848320

        double[][] AdjoinOfM = new double[n][n];
        AdjoinOfM = M.getAdjoin(M.Mat,n);
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(AdjoinOfM[i][j] + " ");
            }
            System.out.println();
        }
<<<<<<< HEAD
=======
        M.getSPLCrammer();
        
>>>>>>> 38dcc5e5e7d7f6f7889746785ac774c5e2848320
    } 
}