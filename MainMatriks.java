import java.util.Scanner;

public class MainMatriks {
    Scanner input = new Scanner(System.in);
    int opsi;
    menu jalankan = new menu();

    public void Menu1() {
        System.out.println("1. Metode elimiasi Gauss");
        System.out.println("2. Metode eliminasi Gauss-Jordan");
        System.out.println("3. Metode matriks balikan");
        System.out.println("4. Metode Cramer");
        opsi = input.nextInt();
        if (opsi == 1) {
            jalankan.MenuSPLEliminasiGauss();
        }
    }
    public void Menu2() {

    }
    public void MenuUtama() {
        System.out.println("MENU");
        opsi = input.nextInt();
        if (opsi == 1) {
            Menu1();
        } else if (opsi == 2) {

        } else if (opsi == 3) {

        } else if (opsi == 4) {

        } else if (opsi == 5) {
                
        } else if (opsi == 6) {

        } else if (opsi == 7) {

        } else {

        }
        
    }
    
    public static void main(String[] args) {
        MainMatriks start = new MainMatriks();
        start.MenuUtama();
    }
}