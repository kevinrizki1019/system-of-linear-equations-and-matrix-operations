import java.util.Scanner;

public class menu 
{
    Scanner input = new Scanner(System.in);
    int opsi;

    public void InputOpsi()
    {
        opsi = input.nextInt();
    }
    public void MenuUtama() 
    {
        System.out.println("MENU");
        System.out.println("1. Sistem Persamaan Linier");
        System.out.println("2. Determinan");
        System.out.println("3. Matriks balikan");
        System.out.println("4. Matriks kofaktor");
        System.out.println("5. Adjoin");
        System.out.println("6. Interpolasi Polinom");
        System.out.println("7. Keluar");   
    }

    public void SubMenu1() 
    {
        System.out.println("1. Metode elminasi Gauss");
        System.out.println("2. Metode eliminasi Gauss-Jordan");
        System.out.println("3. Metode matriks balikan");
        System.out.println("4. Kaiadah Cramer");
    }

    public void SubMenu2()
    {
        System.out.println("1. Metode ekspansi kofaktor");
        System.out.println("2. Metode operasi baris elementer");
    }
    
    public void SubMenu3()
    {
        System.out.println("1. Metode adjoint");
        System.out.println("2. Metode operasi baris elementer");
    }
}