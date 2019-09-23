import java.util.Scanner;

public class MainMatriks {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        menu program = new menu();
        program.MenuUtama();
        program.InputOpsi();
        if (program.opsi == 1)
        {
            program.SubMenu1();
        } else if (program.opsi == 2)
        {
            program.SubMenu2();
        } else if (program.opsi == 3)
        {
            program.SubMenu3();
        } else if (program.opsi == 4)
        {
            int n;
            n = input.nextInt();
            matriks M = new matriks(n,n);
            M.BacaMatriks();
            double[][] C = new double[n][n];
            C = M.getMatriksCofactor(M.Mat, n);
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    System.out.print(C[i][j] + " ");
                }
                System.out.println();
            }
        }
    } 
}