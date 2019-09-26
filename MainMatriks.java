import java.util.Scanner;
public class MainMatriks {
    Scanner input = new Scanner(System.in);
    int opsi;
    menu jalankan = new menu();

    public void MenuUtama() {
        System.out.println();
        System.out.println("MENU");
        System.out.println("1. Sistem Persamaan Linier");
        System.out.println("2. Determinan");
        System.out.println("3. Matriks balikan");
        System.out.println("4. Matriks kofaktor");
        System.out.println("5. Adjoin");
        System.out.println("6. Interpolasi Polinom");
        System.out.println("7. Keluar");
        System.out.print("Pilihan Menu: ");
        opsi = input.nextInt();
        if (opsi == 1) {
            Menu1();
            MenuUtama();
        } else if (opsi == 2) {
            Menu2();
            MenuUtama();
        } else if (opsi == 3) {
            Menu3();
            MenuUtama();
        } else if (opsi == 4) {
            Menu4();
            MenuUtama();
        } else if (opsi == 5) {
            Menu5();
            MenuUtama();
        } else if (opsi == 6) {
            Menu6();
            MenuUtama();
        } else if (opsi == 7) {
            Menu7();
            MenuUtama();
        } else {
            MenuUtama();
        }
    }
    public void Menu1() {
        System.out.println();
        System.out.println("SISTEM PERSAMAAN LINIER");
        System.out.println("1. Metode eliminasi Gauss");
        System.out.println("2. Metode eliminasi Gauss-Jordan");
        System.out.println("3. Metode matriks balikan");
        System.out.println("4. Metode Cramer");
        System.out.print("Pilihan Menu: ");
        opsi = input.nextInt();
        if (opsi == 1) {
            jalankan.MenuSPLEliminasiGauss();
            MenuUtama();
        } else if (opsi == 2) {
            jalankan.MenuSPLEliminasiGaussJordan();
            MenuUtama();
        } else if (opsi == 3) {
            jalankan.MenuSPLMatriksBalikan();
            MenuUtama();
        } else if (opsi == 4) {
            jalankan.MenuSPLKaidahCramer();
            MenuUtama();
        } else {
            System.out.println("Input tidak tepat, masukkan hanya angka yang valid");
            MenuUtama();
        }
    }
    public void Menu2() {
        System.out.println("DETERMINAN");
        System.out.println("1. Operasi Baris Elementer");
        System.out.println("2. Ekspansi Kofaktor");
        System.out.print("Pilihan Menu: ");
        opsi = input.nextInt();
        if (opsi == 1) {
            jalankan.MenuDeterminanOBE();
            MenuUtama();
        } else if (opsi == 2) {
            jalankan.MenuDeterminanKofaktor();
            MenuUtama();
        }
    }
    public void Menu3() {
        System.out.println("MATRIKS BALIKAN");
        System.out.println("1. Operasi Baris Elementer");
        System.out.println("2. Adjoint");
        System.out.print("Pilihan Menu: ");
        opsi = input.nextInt();
        if (opsi == 1) {
            jalankan.MenuInversOBE();
            MenuUtama();
        } else if (opsi == 2) {
            jalankan.MenuInversAdjoint();
            MenuUtama();
        }
    }
    public void Menu4() {
        jalankan.MenuMatriksKofaktor();
        MenuUtama();
    }
    public void Menu5() {
        jalankan.MenuAdjoin();
        MenuUtama();
    }
    public void Menu6() {
        jalankan.MenuInterpolasiPolinom();
        MenuUtama();
    }
    public void Menu7() {
        System.out.println("Anda yakin ingin keluar?");
        System.out.print("Pilihan Menu: ");
        opsi = input.nextInt();
        if (opsi == 0) {
            System.out.println("Kembali ke Menu Utama");
            MenuUtama();
        }
        System.out.println("Sampai Jumpa");
    }

    
    public static void main(String[] args) {
        MainMatriks start = new MainMatriks();
        start.MenuUtama();
    }
}
