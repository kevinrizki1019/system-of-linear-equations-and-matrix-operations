public class MainMatriks {
    public static void main(String[] args) {
        MakeMatriks M = new MakeMatriks(3,3);
        M.BacaMatriks();
        M.TulisMatriks();
        System.out.println("MENU");
        System.out.println("1. Sistem Persamaan Linier");
        System.out.println("2. Determinan");
        System.out.println("3. Matriks balikan");
        System.out.println("4. Matriks kofaktor");
        System.out.println("5. Adjoin");
        System.out.println("6. Interpolasi Polinom");
        System.out.println("7. Keluar");
    } 
}