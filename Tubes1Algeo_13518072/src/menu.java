import java.util.Scanner;
import java.io.*;

public class menu  {
    matriks Matriks = new matriks();
    int opsi;
    Scanner input = new Scanner(System.in);

    public void PilihMetodeBaca() {
        // Prosedur untuk menampilkan interface pilih data matriks masuk dari mana
        System.out.println("Pilih metode masukkan data:");
        System.out.println("1. Keyboard");
        System.out.println("2. File Eksternal");
        System.out.print("Pilihan Menu: ");
    }

    public void BacaMatriksDariFile(matriks Matriks) {
        // Prosedur pembacaan nama file dan membaca isi matriks dalam file
        Scanner inputFile = new Scanner(System.in);
        String fileName;
        
        System.out.print("Masukkan nama file: ");
        fileName = inputFile.nextLine();
        Matriks.BacaMatriksFromFile(fileName);
    }

    /* SPL */
    public void MenuSPLEliminasiGauss(){
        int idxBar,idxKol;
        ResetLayar();
        System.out.format("Metode Eliminasi Gauss\n");
        System.out.format("Akan dibuat Matriks Augmented dengan ukuran Baris x Kolom \n");
        
        // Opsi untuk memilih metode baca file
        PilihMetodeBaca();
        opsi = input.nextInt();
        
        if (opsi == 1) {
            System.out.format("Masukkan Banyaknya Baris: ");
            idxBar=input.nextInt();
            System.out.println();
            System.out.format("Masukkan Banyaknya Kolom: ");
            idxKol=input.nextInt();
            System.out.println();
            Matriks.setidx(idxBar, idxKol);
            System.out.format("Masukkan Nilai Setiap Elemen pada Matriks: \n");
            Matriks.BacaMatriks();
            System.out.println();
            Matriks.GaussElimination(Matriks.Mat);
            Matriks.TulisGauss(Matriks.Mat);
        } else {
            // Membaca matriks dari file
            matriks Matriks = new matriks();
            BacaMatriksDariFile(Matriks);

            // Mengolah data matriks yang terbaca
            Matriks.GaussElimination(Matriks.Mat);
            Matriks.TulisGauss(Matriks.Mat);
            System.out.println();
        }
        
    }
    
    public void MenuSPLEliminasiGaussJordan(){
        int idxBar,idxKol;
        ResetLayar();
        System.out.format("Metode Eliminasi Gauss Jordan\n");
        System.out.format("Akan dibuat Matriks Augmented dengan ukuran BarisxKolom \n");
        
        // Opsi untuk memilih metode baca file
        PilihMetodeBaca();
        opsi = input.nextInt();
        
        if (opsi == 1) {
            System.out.format("Masukkan Banyaknya Baris: ");
            idxBar=input.nextInt();
            System.out.println();
            System.out.format("Masukkan Banyaknya Kolom: ");
            idxKol=input.nextInt();
            System.out.println();
            Matriks.setidx(idxBar, idxKol);
            System.out.format("Masukkan Nilai Setiap Elemen pada Matriks: \n");
            Matriks.BacaMatriks();
            System.out.println();
            Matriks.GaussElimination(Matriks.Mat);
            Matriks.GaussJordanElimination(Matriks.Mat);
            Matriks.TulisSPLGaussJordan(Matriks.Mat);
        }  else {
            // Membaca matriks dari file
            matriks Matriks = new matriks();
            BacaMatriksDariFile(Matriks);

            // Proses
            System.out.println();
            Matriks.GaussElimination(Matriks.Mat);
            Matriks.GaussJordanElimination(Matriks.Mat);
            Matriks.TulisSPLGaussJordan(Matriks.Mat);
            System.out.println();
        }
    }
    
    // MASIH SALAH, TOLONG DIBENERIN
    public void MenuSPLMatriksBalikan (){
        int idxBar,idxKol,opsi;
        boolean check=true;
        ResetLayar();

        // Opsi untuk memilih metode baca file    
        PilihMetodeBaca();
        opsi = input.nextInt();
        
        if (opsi == 1) {
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
                           Matriks.setidx(idxBar, idxKol);
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
                           Matriks.setidx(idxBar, idxKol);
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
                if (opsi==1){ // OBE
                    double [][] matriks,augmented;
                    matriks=new double [idxBar][idxKol];
                    for (int i=0; i<idxBar; i++){
                        for (int j=0; j<idxKol; j++){
                            matriks[i][j]=Matriks.getElement(i,j);
                        }
                    }
                    augmented=Matriks.OnlyAugmented(matriks);
                    Matriks.invers();
                    Matriks.TulisSPLMatriksBalikan(Matriks.Mat,augmented,idxBar,1);
                }
                else if(opsi==2){ // Adjoint
                    double [][] matriks,augmented;
                    matriks=new double [idxBar][idxKol];
                    for (int i=0; i<idxBar; i++){
                        for (int j=0; j<idxKol; j++){
                            matriks[i][j]=Matriks.getElement(i,j);
                        }
                    }
                    Matriks.TulisSPLMatriksBalikanCrammer();
                }
                System.out.println();
            } 
        } else {
            // Membaca matriks dari file
            matriks Matriks = new matriks();
            BacaMatriksDariFile(Matriks);

            // Proses            
        }
    }    
    
    // GAK BISA BUAT BEBERAPA TEST CASE
    public void MenuSPLKaidahCramer (){
        int idxBar,idxKol;
        ResetLayar();

        System.out.format("Metode Kaidah Crammer\n");
        System.out.format("Akan dibuat Matriks Augmented dengan ukuran BarisxKolom \n");

        // Opsi untuk memilih metode baca file    
        PilihMetodeBaca();
        opsi = input.nextInt();

        if (opsi == 1) {
            System.out.format("Masukkan Banyaknya Baris: ");
            idxBar=input.nextInt();
            System.out.println();
            System.out.format("Masukkan Banyaknya Kolom: ");
            idxKol=input.nextInt();
            System.out.println();
            Matriks.setidx(idxBar, idxKol);
            System.out.format("Masukkan Nilai Setiap Elemen pada Matriks: \n");
            Matriks.BacaMatriks();
            System.out.println();
            Matriks.TulisSPLCrammer();
        } else {
            // Membaca matriks dari file
            matriks Matriks = new matriks();
            BacaMatriksDariFile(Matriks);

            // Proses
            System.out.println();
            Matriks.TulisSPLCrammer();
        }
    }
    
    /* DETERMINAN */
    /* MASIH SALAH UNTUK MATRIKS 5 X 5 di testcase: "TestCase3Matriks5.txt" */
    public void MenuDeterminanOBE (){
        int idxBar,idxKol,opsi;
        boolean check=true;
        ResetLayar();
        System.out.format("Metode Determinan dengan Operasi Baris Elementer\n");
        System.out.format("Akan dibuat Matriks dengan ukuran Baris x Kolom \n");
        System.out.format("Matriks harus dalam bentuk Bujur Sangkar!\n");

        // Opsi untuk memilih metode baca file    
        PilihMetodeBaca();
        opsi = input.nextInt();

        if (opsi == 1) {
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
                            Matriks.setidx(idxBar,idxKol);
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
                            Matriks.setidx(idxBar,idxKol);
                        }
                    }
                }
                else{
                    check=false;
                }
            }
            if(check=true){
                System.out.println();
                Matriks.setidx(idxBar,idxKol);
                System.out.format("Masukkan Nilai Setiap Elemen pada Matriks: \n");
                Matriks.BacaMatriks();
                Matriks.GaussElimination(Matriks.Mat);
                System.out.format("Dengan Menggunakan metode Operasi Baris Elementer maka didapatkan nilai determinan sebesar %.2f.\n",Matriks.GetDeterminanOBE(Matriks.Mat));            
            }
            System.out.println();
        } else {
            // Membaca matriks dari file
            matriks Matriks = new matriks();
            BacaMatriksDariFile(Matriks);

            // Proses
            Matriks.GaussElimination(Matriks.Mat);
            System.out.format("Dengan Menggunakan metode Operasi Baris Elementer maka didapatkan nilai determinan sebesar %.2f.\n",Matriks.GetDeterminanOBE(Matriks.Mat));
        }
    }

    public void MenuDeterminanKofaktor (){
        int idxBar,idxKol,opsi;
        boolean check=true;
        ResetLayar();
        System.out.format("Metode Determinan dengan Operasi Baris Elementer\n");
        System.out.format("Akan dibuat Matriks dengan ukuran Baris x Kolom \n");
        System.out.format("Matriks harus dalam bentuk Bujur Sangkar!\n");
        
        // Opsi untuk memilih metode baca file    
        PilihMetodeBaca();
        opsi = input.nextInt();

        if (opsi == 1) {
            System.out.format("Masukkan Banyaknya Baris: ");
            idxBar=input.nextInt();
            System.out.println();
            System.out.format("Masukkan Banyaknya Kolom: ");
            idxKol=input.nextInt();

            System.out.println();
            Matriks.setidx(idxBar, idxKol);
            System.out.format("Masukkan Nilai Setiap Elemen pada Matriks: \n");
            Matriks.BacaMatriks();
            System.out.format("Dengan Menggunakan metode Ekspansi Kofaktor maka didapatkan nilai determinan sebesar %.2f",Matriks.determinantOfMatrix(Matriks.Mat, idxBar));            
        } else {
            // Membaca matriks dari file
            matriks Matriks = new matriks();
            BacaMatriksDariFile(Matriks);

            // Proses
            System.out.format("Dengan Menggunakan metode Ekspansi Kofaktor maka didapatkan nilai determinan sebesar %.2f",Matriks.determinantOfMatrix(Matriks.Mat, Matriks.getidxBaris())); 
        }
        System.out.println();
    }
    
    /* INVERS */
    public void MenuInversOBE (){
        int idxBar,idxKol,opsi;
        double [][] matriks;
        boolean check=true;
        ResetLayar();
        System.out.format("Metode Invers/Matriks Balikan dengan Operasi Baris Elementer\n");
        System.out.format("Akan dibuat Matriks dengan ukuran Baris x Kolom \n");
        System.out.format("Matriks harus dalam bentuk Bujur Sangkar!\n");
        
        // Opsi untuk memilih metode baca file    
        PilihMetodeBaca();
        opsi = input.nextInt();

        if (opsi == 1) {
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
                           Matriks.matriks(idxBar, idxKol);
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
                           Matriks.matriks(idxBar, idxKol);
                        }
                    }
                }
                else{
                    check=false;
                }
            }
            if(check=true){
                System.out.println();
                Matriks.matriks(idxBar, idxKol);
                System.out.format("Masukkan Nilai Setiap Elemen pada Matriks: \n");
                Matriks.BacaMatriks();
                matriks=Matriks.Mat;
                Matriks.GaussElimination(matriks);
                if(Matriks.GetDeterminanOBE(matriks)==0){
                    System.out.println("Determinan Matriks sama dengan nol. Matriks tidak memiliki matriks Balikan.\n");
                }
                else{
                    Matriks.invers();
                    System.out.println("Hasil Matriks Balikan dengan metode Operasi Baris Elementer: ");
                    Matriks.TulisMatriks();

                    System.out.println("Tulis hasil ke file? (1=ya, 0=tidak)");
                    opsi = input.nextInt();
                    if (opsi == 1) {
                        Scanner stringInput = new Scanner(System.in);
                        System.out.printf("Tulis nama file: ");
                        String fileName = stringInput.nextLine();
                        Matriks.TulisMatriksToFile(fileName);
                    }
                }
            }
            System.out.println();
        } else {
            // Membaca matriks dari file
            matriks Matriks = new matriks();
            BacaMatriksDariFile(Matriks);

            // Proses
            Matriks.invers();
            System.out.println("Hasil Matriks Balikan dengan metode Operasi Baris Elementer: ");
            Matriks.TulisMatriks();
            
            System.out.println("Tulis hasil ke file? (1=ya, 0=tidak)");
            opsi = input.nextInt();
            if (opsi == 1) {
                Scanner stringInput = new Scanner(System.in);
                System.out.printf("Tulis nama file: ");
                String fileName = stringInput.nextLine();
                Matriks.TulisMatriksToFile(fileName);
            }
        }
    }
    
    public void MenuInversAdjoint (){
        int idxBar,idxKol;
        ResetLayar();
        System.out.format("Mencari Matriks Inverse dengan metode Adjoint\n");
        System.out.format("Akan dibuat Matriks Koefisien dengan ukuran N x N \n");
        
        PilihMetodeBaca();
        opsi = input.nextInt();
        
        if (opsi == 1)  {
            System.out.format("Masukkan N: ");
            
            idxBar=input.nextInt();
            idxKol = idxBar;

            Matriks.setidx(idxBar, idxKol);
            System.out.format("Masukkan Nilai Setiap Elemen pada Matriks: \n");
            Matriks.BacaMatriks();
            System.out.println();
            Matriks.getMatriksInvers();
            System.out.format("Matriks Inversenya adalah: \n");
            Matriks.TulisMatriks();
            System.out.println();

            System.out.println("Tulis hasil ke file? (1=ya, 0=tidak)");
            opsi = input.nextInt();
            if (opsi == 1) {
                Scanner stringInput = new Scanner(System.in);
                System.out.printf("Tulis nama file: ");
                String fileName = stringInput.nextLine();
                Matriks.TulisMatriksToFile(fileName);
            }

        } else {
            // Membaca matriks dari file
            matriks Matriks = new matriks();
            BacaMatriksDariFile(Matriks);

            // Proses
            System.out.println();
            Matriks.getMatriksInvers();
            System.out.format("Matriks Inversenya adalah: \n");
            Matriks.TulisMatriks();
            System.out.println();

            System.out.println("Tulis hasil ke file? (1=ya, 0=tidak)");
            opsi = input.nextInt();
            if (opsi == 1) {
                Scanner stringInput = new Scanner(System.in);
                System.out.printf("Tulis nama file: ");
                String fileName = stringInput.nextLine();
                Matriks.TulisMatriksToFile(fileName);
            }

        }
    }
    
    /* KOFAKTOR */
    public void MenuMatriksKofaktor (){
        int idxBar,idxKol;
        ResetLayar();
        System.out.format("Mencari Matriks Adjoint\n");
        System.out.format("Akan dibuat Matriks Kofaktor dengan ukuran N x N \n");
        
        PilihMetodeBaca();
        opsi = input.nextInt();
        
        if (opsi == 1) {
            System.out.format("Masukkan N: ");
            
            idxBar=input.nextInt();
            idxKol = idxBar;

            Matriks.setidx(idxBar, idxKol);
            System.out.format("Masukkan Nilai Setiap Elemen pada Matriks: \n");
            Matriks.BacaMatriks();
            System.out.println();
            Matriks.Mat = Matriks.getMatriksCofactor(Matriks.Mat, idxBar);
            System.out.format("Matriks Kofaktornya adalah: \n");
            Matriks.TulisMatriks();
            System.out.println();

            System.out.println("Tulis hasil ke file? (1=ya, 0=tidak)");
            opsi = input.nextInt();
            if (opsi == 1) {
                Scanner stringInput = new Scanner(System.in);
                System.out.printf("Tulis nama file: ");
                String fileName = stringInput.nextLine();
                Matriks.TulisMatriksToFile(fileName);
            }

        } else {
            // Membaca matriks dari file
            matriks Matriks = new matriks();
            BacaMatriksDariFile(Matriks);

            // Proses
            System.out.println();
            Matriks.Mat = Matriks.getMatriksCofactor(Matriks.Mat, Matriks.getidxBaris());
            System.out.format("Matriks Kofaktornya adalah: \n");
            Matriks.TulisMatriks();
            System.out.println();

            System.out.println("Tulis hasil ke file? (1=ya, 0=tidak)");
            opsi = input.nextInt();
            if (opsi == 1) {
                Scanner stringInput = new Scanner(System.in);
                System.out.printf("Tulis nama file: ");
                String fileName = stringInput.nextLine();
                Matriks.TulisMatriksToFile(fileName);
            }

        }
    }
    
    /* ADJOINT */
    public void MenuAdjoin (){
        int idxBar,idxKol;
        ResetLayar();
        System.out.format("Mencari Matriks Adjoint\n");
        System.out.format("Akan dibuat Matriks Koefisien dengan ukuran N x N \n");
        
        PilihMetodeBaca();
        opsi = input.nextInt();

        if (opsi == 1) {
            System.out.format("Masukkan N: ");
            
            idxBar=input.nextInt();
            idxKol = idxBar;

            Matriks.setidx(idxBar, idxKol);
            System.out.format("Masukkan Nilai Setiap Elemen pada Matriks: \n");
            Matriks.BacaMatriks();
            System.out.println();
            Matriks.Mat = Matriks.getAdjoin(Matriks.Mat, idxBar);
            System.out.format("Matriks Adjointnya adalah: \n");
            Matriks.TulisMatriks();
            System.out.println();

            System.out.println("Tulis hasil ke file? (1=ya, 0=tidak)");
            opsi = input.nextInt();
            if (opsi == 1) {
                Scanner stringInput = new Scanner(System.in);
                System.out.printf("Tulis nama file: ");
                String fileName = stringInput.nextLine();
                Matriks.TulisMatriksToFile(fileName);
            }

        } else {
            // Membaca matriks dari file
            matriks Matriks = new matriks();
            BacaMatriksDariFile(Matriks);

            // Proses
            System.out.println();
            Matriks.Mat = Matriks.getAdjoin(Matriks.Mat, Matriks.getidxBaris());
            System.out.format("Matriks Adjointnya adalah: \n");
            Matriks.TulisMatriks();
            System.out.println();

            System.out.println("Tulis hasil ke file? (1=ya, 0=tidak)");
            opsi = input.nextInt();
            if (opsi == 1) {
                Scanner stringInput = new Scanner(System.in);
                System.out.printf("Tulis nama file: ");
                String fileName = stringInput.nextLine();
                Matriks.TulisMatriksToFile(fileName);
            }

        }
    }
    
    /* INTERPOLASI */
    /* JUMLAH ANGKA DI BELAKANG KOMA JADIIN 4! KURANG TAKSIRAN UNTUK X TERTENTU */
    public void MenuInterpolasiPolinom (){
        ResetLayar();
        System.out.format("Interpolasi Polinom\n");
        System.out.format("Akan dibuat persamaan polinom yang melewati titik-titik uji \n");

        PilihMetodeBaca();
        opsi = input.nextInt();

        if (opsi == 1) {
            System.out.format("Masukkan Banyaknya titik uji: ");
            int N = input.nextInt();
            Matriks.setidx(N, N+1);
            Matriks.Interpolasi();
            System.out.println();
        } else {

        }
    }
    
    public void ResetLayar (){
        for (int i=1 ; i<50; i++){
            System.out.println();
        }
    }
}
