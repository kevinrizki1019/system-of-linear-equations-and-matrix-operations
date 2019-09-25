
import java.util.Scanner;
import java.io.*;

public class menu  {
    matriks Matriks = new matriks();
    Scanner input = new Scanner(System.in);

    public void MenuSPLEliminasiGauss(){
        int idxBar,idxKol;
        ResetLayar();
        System.out.format("Metode Eliminasi Gauss\n");
        System.out.format("Akan dibuat Matriks Augmented dengan ukuran BarisxKolom \n");
        System.out.format("Masukkan Banyaknya Baris: ");
        idxBar=input.nextInt();
        System.out.println();
        System.out.format("Masukkan Banyaknya Kolom: ");
        idxKol=input.nextInt();
        System.out.println();
       matriks Matriks = new matriks(idxBar, idxKol);
        System.out.format("Masukkan Nilai Setiap Elemen pada Matriks: \n");
        Matriks.BacaMatriks();
        System.out.println();
        Matriks.GaussElimination(Matriks.Mat);
        Matriks.TulisGauss(Matriks.Mat);
    }
    
    public void MenuSPLEliminasiGaussJordan(){
        int idxBar,idxKol;
        ResetLayar();
        System.out.format("Metode Eliminasi Gauss Jordan\n");
        System.out.format("Akan dibuat Matriks Augmented dengan ukuran BarisxKolom \n");
        System.out.format("Masukkan Banyaknya Baris: ");
        idxBar=input.nextInt();
        System.out.println();
        System.out.format("Masukkan Banyaknya Kolom: ");
        idxKol=input.nextInt();
        System.out.println();
       matriks Matriks = new matriks(idxBar, idxKol);
        System.out.format("Masukkan Nilai Setiap Elemen pada Matriks: \n");
        Matriks.BacaMatriks();
        System.out.println();
        Matriks.GaussJordanElimination(Matriks.Mat);
        Matriks.TulisSPLGaussJordan(Matriks.Mat);
    }
    
    public void MenuSPLMatriksBalikan (){
        int idxBar,idxKol,opsi;
        boolean check=true;
        ResetLayar();
        System.out.format("Metode Matriks Balikan\n");
        System.out.format("Akan dibuat Matriks Augmented dengan ukuran BarisxKolom \n");
        System.out.format("Masukkan Kolom harus berukuran Baris+1\n");
        System.out.format("Masukkan Banyaknya Baris: ");
        idxBar=input.nextInt();
        System.out.println();
        System.out.format("Masukkan Banyaknya Kolom: ");
        idxKol=input.nextInt();
        System.out.println();
        if (idxKol!=idxBar+1){
            System.out.format("Matriks Tidak Bisa Diolah! Silahkan Pilih Opsi Selanjutnya\n1. Input Kembali Baris dan Kolom.\n2. Input Kembali Kolom\n3. Keluar.\n");
            System.out.format("Silahkan Input Opsi yang dipilih (input nomornya saja): ");
            opsi=input.nextInt();
            if (opsi==1){
                while (idxKol!=idxBar+1){
                    System.out.format("Masukkan Banyaknya Baris: ");
                    idxBar=input.nextInt();
                    System.out.println();
                    System.out.format("Masukkan Banyaknya Kolom: ");
                    idxKol=input.nextInt();
                    if(idxKol!=idxBar+1){
                        System.out.println("Masukkan Tetap Salah, Silahkan input kembali!");
                    }
                    else{
                       matriks Matriks = new matriks(idxBar, idxKol);
                    }
                }
            }
            else if (opsi==2){
                while (idxKol!=idxBar+1){
                    System.out.format("Masukkan Banyaknya Kolom: ");
                    idxKol=input.nextInt();
                    if(idxKol!=idxBar+1){
                        System.out.println("Masukkan Tetap Salah, Silahkan input kembali!");
                    }
                    else{
                       matriks Matriks = new matriks(idxBar, idxKol);
                    }
                }
            }
            else{
                check=false;
            }
        }
        if(check=true){
            System.out.println();
            System.out.format("Masukkan Nilai Setiap Elemen pada Matriks: \n");
            Matriks.BacaMatriks();
            ResetLayar();
            System.out.format("Silahkan pilih Metode invers Balikan\n1. Matriks Balikan OBE.\n2. Matriks Balikan Adjoin.\n ");
            System.out.format("Opsi yang Dipilih (Masukkan angka opsinya saja) : ");
            opsi=input.nextInt();
            System.out.println();
            if (opsi==1){
                double [][] matriks,augmented;
                matriks=new double [idxBar][idxKol];
                for (int i=0; i<idxBar; i++){
                    for (int j=0; j<idxKol; j++){
                        matriks[i][j]=Matriks.getElement(i,j);
                    }
                }
                Matriks.TulisSPLMatriksBalikan();
            }
            else if(opsi==2){
                double [][] matriks,augmented;
                matriks=new double [idxBar][idxKol];
                for (int i=0; i<idxBar; i++){
                    for (int j=0; j<idxKol; j++){
                        matriks[i][j]=Matriks.getElement(i,j);
                    }
                }
                Matriks.TulisSPLMatriksBalikanCrammer();
            }
        }
    }
    
    public void MenuSPLKaidahCramer (){
        int idxBar,idxKol;
        ResetLayar();
        System.out.format("Metode Kaidah Crammer\n");
        System.out.format("Akan dibuat Matriks Augmented dengan ukuran BarisxKolom \n");
        System.out.format("Masukkan Banyaknya Baris: ");
        idxBar=input.nextInt();
        System.out.println();
        System.out.format("Masukkan Banyaknya Kolom: ");
        idxKol=input.nextInt();
        System.out.println();
       matriks Matriks = new matriks(idxBar, idxKol);
        System.out.format("Masukkan Nilai Setiap Elemen pada Matriks: \n");
        Matriks.BacaMatriks();
        System.out.println();
        Matriks.TulisSPLCrammer();
    }
    
    public void MenuDeterminanOBE (){
        int idxBar,idxKol,opsi;
        boolean check=true;
        ResetLayar();
        System.out.format("Metode Determinan dengan Operasi Baris Elementer\n");
        System.out.format("Akan dibuat Matriks dengan ukuran Baris x Kolom \n");
        System.out.format("Matriks harus dalam bentuk Bujur Sangkar!\n");
        System.out.format("Masukkan Banyaknya Baris: ");
        idxBar=input.nextInt();
        System.out.println();
        System.out.format("Masukkan Banyaknya Kolom: ");
        idxKol=input.nextInt();
        if (idxKol!=idxBar){
            System.out.format("Matriks Tidak Bisa Diolah! Silahkan Pilih Opsi Selanjutnya\n1. Input Kembali Baris dan Kolom.\n2. Input Kembali Kolom\n3. Keluar.\n");
            System.out.format("Silahkan Input Opsi yang dipilih (input nomornya saja): ");
            opsi=input.nextInt();
            if (opsi==1){
                while (idxKol!=idxBar){
                    System.out.format("Masukkan Banyaknya Baris: ");
                    idxBar=input.nextInt();
                    System.out.println();
                    System.out.format("Masukkan Banyaknya Kolom: ");
                    idxKol=input.nextInt();
                    if(idxKol!=idxBar){
                        System.out.println("Masukkan Tetap Salah, Silahkan input kembali!");
                    }
                    else{
                       matriks Matriks = new matriks(idxBar, idxKol);
                    }
                }
            }
            else if (opsi==2){
                while (idxKol!=idxBar){
                    System.out.format("Masukkan Banyaknya Kolom: ");
                    idxKol=input.nextInt();
                    if(idxKol!=idxBar){
                        System.out.println("Masukkan Tetap Salah, Silahkan input kembali!");
                    }
                    else{
                       matriks Matriks = new matriks(idxBar, idxKol);
                    }
                }
            }
            else{
                check=false;
            }
        }
        if(check=true){
            System.out.println();
           matriks Matriks = new matriks(idxBar, idxKol);
            System.out.format("Masukkan Nilai Setiap Elemen pada Matriks: \n");
            Matriks.BacaMatriks();
            Matriks.setidxKolom(idxKol+1);
            Matriks.GaussElimination(Matriks.Mat);
            System.out.format("Dengan Menggunakan metode Operasi Baris Elementer maka didapatkan nilai determinan sebesar %.2f.\n",Matriks.GetDeterminanOBE(Matriks.Mat));            
        }
    }
    
    public void MenuDeterminanKofaktor (){
        
    }
    
    public void MenuInversOBE (){
        int idxBar,idxKol,opsi;
        boolean check=true;
        ResetLayar();
        System.out.format("Metode Invers/Matriks Balikan dengan Operasi Baris Elementer\n");
        System.out.format("Akan dibuat Matriks dengan ukuran Baris x Kolom \n");
        System.out.format("Matriks harus dalam bentuk Bujur Sangkar!\n");
        System.out.format("Masukkan Banyaknya Baris: ");
        idxBar=input.nextInt();
        System.out.println();
        System.out.format("Masukkan Banyaknya Kolom: ");
        idxKol=input.nextInt();
        if (idxKol!=idxBar){
            System.out.format("Matriks Tidak Bisa Diolah! Silahkan Pilih Opsi Selanjutnya\n1. Input Kembali Baris dan Kolom.\n2. Input Kembali Kolom\n3. Keluar.\n");
            System.out.format("Silahkan Input Opsi yang dipilih (input nomornya saja): ");
            opsi=input.nextInt();
            if (opsi==1){
                while (idxKol!=idxBar){
                    System.out.format("Masukkan Banyaknya Baris: ");
                    idxBar=input.nextInt();
                    System.out.println();
                    System.out.format("Masukkan Banyaknya Kolom: ");
                    idxKol=input.nextInt();
                    if(idxKol!=idxBar){
                        System.out.println("Masukkan Tetap Salah, Silahkan input kembali!");
                    }
                    else{
                       matriks Matriks = new matriks(idxBar, idxKol);
                    }
                }
            }
            else if (opsi==2){
                while (idxKol!=idxBar){
                    System.out.format("Masukkan Banyaknya Kolom: ");
                    idxKol=input.nextInt();
                    if(idxKol!=idxBar){
                        System.out.println("Masukkan Tetap Salah, Silahkan input kembali!");
                    }
                    else{
                       matriks Matriks = new matriks(idxBar, idxKol);
                    }
                }
            }
            else{
                check=false;
            }
        }
        if(check=true){
            System.out.println();
           matriks Matriks = new matriks(idxBar, idxKol);
            System.out.format("Masukkan Nilai Setiap Elemen pada Matriks: \n");
            Matriks.BacaMatriks();
            Matriks.invers(Matriks.Mat);
            ResetLayar();
            System.out.println("Hasil Matriks Balikan dengan metode Operasi Baris Elementer: ");
            Matriks.TulisMatriks();
        }
    }
    
    public void MenuInversAdjoint (){
        int idxBar,idxKol;
        ResetLayar();
        System.out.format("Mencari Matriks Inverse dengan metode Adjoint\n");
        System.out.format("Akan dibuat Matriks Koefisien dengan ukuran N x N \n");
        System.out.format("Masukkan N: ");
        
        idxBar=input.nextInt();
        idxKol = idxBar;

       matriks Matriks = new matriks(idxBar, idxKol);
        System.out.format("Masukkan Nilai Setiap Elemen pada Matriks: \n");
        Matriks.BacaMatriks();
        System.out.println();
        Matriks.getMatriksInvers();
        Matriks.TulisMatriks();
        System.out.println();
    }
    
    public void MenuMatriksKofaktor (){
        int idxBar,idxKol;
        ResetLayar();
        System.out.format("Mencari Matriks Adjoint\n");
        System.out.format("Akan dibuat Matriks Kofaktor dengan ukuran N x N \n");
        System.out.format("Masukkan N: ");
        
        idxBar=input.nextInt();
        idxKol = idxBar;

       matriks Matriks = new matriks(idxBar, idxKol);
        System.out.format("Masukkan Nilai Setiap Elemen pada Matriks: \n");
        Matriks.BacaMatriks();
        System.out.println();
        Matriks.Mat = Matriks.getMatriksCofactor(Matriks.Mat, idxBar);
    }
    
    public void MenuAdjoin (){
        int idxBar,idxKol;
        ResetLayar();
        System.out.format("Mencari Matriks Adjoint\n");
        System.out.format("Akan dibuat Matriks Koefisien dengan ukuran N x N \n");
        System.out.format("Masukkan N: ");
        
        idxBar=input.nextInt();
        idxKol = idxBar;

        matriks Matriks = new matriks(idxBar, idxKol);
        System.out.format("Masukkan Nilai Setiap Elemen pada Matriks: \n");
        Matriks.BacaMatriks();
        System.out.println();
        Matriks.Mat = Matriks.getAdjoin(Matriks.Mat, idxBar);
    }
    
    public void MenuInterpolasiPolinom (){
        ResetLayar();
        System.out.format("Interpolasi Polinom\n");
        System.out.format("Akan dibuat persamaan polinom yang melewati titik-titik uji \n");
        System.out.format("Masukkan Banyaknya titik uji: ");
        int N = input.nextInt();
        matriks Matriks = new matriks(N, N + 1);
        Matriks.Interpolasi();
    }
    
    public void ResetLayar (){
        for (int i=1 ; i<50; i++){
            System.out.println();
        }
    }
        
    
}
