import java.util.Scanner;

public class MainMatriks {
    public static void main(String[] args) {
        int n,m;
        Scanner input = new Scanner(System.in);
        
        n = input.nextInt();
        m = input.nextInt();
        matriks M = new matriks(n,m);
        M.BacaMatriks();


        M.getSPLCrammer();
        
    } 
}