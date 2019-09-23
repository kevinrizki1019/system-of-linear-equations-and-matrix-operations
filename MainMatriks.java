import java.util.Scanner;

public class MainMatriks {
    public static void main(String[] args) {
        int n,m;
        Scanner input = new Scanner(System.in);
        
        n = input.nextInt();
        m = input.nextInt();
    
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

        double[][] AdjoinOfM = new double[n][n];
        AdjoinOfM = M.getAdjoin(M.Mat,n);
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(AdjoinOfM[i][j] + " ");
            }
            System.out.println();
        }
    } 
}