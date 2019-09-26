// TUBES ALJABAR LINEAR DAN GEOMETRI 
// Nama Kelompok: Kelompok16_13518072_13518100_13518141

/*
BASIC:
    Buat nama yang meaningful
    Tulis comment seperlunya untuk membantu
*/
import java.io.*;
import java.util.Scanner;

public class matriks {
    Scanner input = new Scanner(System.in);

    /*** PROPERTIES ***/
    public double[][] Mat = new double[100][100];
    private int idxBaris = 0; /* banyaknya ukuran baris yg terdefinisi */
    private int idxKolom = 0; /* banyaknya ukuran kolom yg terdefinisi */
    private double determinan = 1;

    /*** METHOD ***/
    /* KONSTRUKTOR */
    public matriks() {
        /*
         * Membentuk object matriks dengan semua nilai properties berisi nilai default
         */
    }
    public matriks(int i, int j){
        this.Mat = new double[i][j];
        this.idxBaris = i;
        this.idxKolom = j;
    }
    
    public void matriks(int i, int j){
        this.Mat = new double[i][j];
        this.idxBaris = i;
        this.idxKolom = j;
    }
    
    /* SELEKTOR untuk Object matriks yang terdefinisi */
    public double getElement(int i, int j) {
        /* Mengirimkan element(i,j) pada property Mat[][] */
        return this.Mat[i][j];
    }

    public int getidxBaris() {
        /* Mengirimkan nilai property idxBaris yaitu jumlah baris pada matriks */
        return this.idxBaris;
    }

    public int getidxKolom() {
        /* Mengirimkan nilai property idxKolom yaitu jumlah kolom pada matriks */
        return this.idxKolom;
    }

    /* SETTER untuk menggasign properies pada Object */
    public void setidxBaris(int newidxBaris) {
        /*
         * Mengassign nilai property idxBaris pada object dengan nilai yang baru
         * newidxBaris I.S. Object terdefinisi F.S. Property idxBaris pada Object
         * berganti
         */
        this.idxBaris = newidxBaris;
    }

    public void setidxKolom(int newidxKolom) {
        /*
         * Mengassign nilai property idxKolom pada object dengan nilai yang baru
         * newidxKolom I.S. Object terdefinisi F.S. Property idxKolom pada Object
         * berganti
         */
        this.idxKolom = newidxKolom;
    }

    public void setidx(int newidxBaris, int newidxKolom) {
        /*
         * Mengasign nilai property idxBaris pada object dengan nwidxBaris dan nilai
         * property idxKolom dengan newidxKolom I.S. Object terdefinisi F.S. Property
         * idxBaris dan idxKolom pada Object berganti
         */
        this.setidxBaris(newidxBaris);
        this.setidxKolom(newidxKolom);
    }

    /* KELOMPOK BACA/TULIS */
    public void BacaMatriks() {
        /* I.S. Object matriks terdefinisi nilai idxBaris dan idxKolomnya */
        /*
         * F.S. M terdefinisi nilai semua elemennya, berukuran sesuai property objectnya
         * yaitu idxBaris x idxKolom
         */
        /*
         * Proses: Mengisi semua nilai elemen pada propety mat[][] sesuai yan terbaca
         * dari masukan keyboard
         */
        /* Selanjutnya membaca nilai elemen per baris dan kolom */
        /*
         * Contoh: Jika idxBaris = 3 dan idxKolom = 3, maka contoh cara membaca isi
         * matriks : 1 2 3 4 5 6 8 9 10
         */
        for (int i = 0; i < this.idxBaris; i++) {
            for (int j = 0; j < this.idxKolom; j++) {
                this.Mat[i][j] = input.nextDouble();
            }
        }
    }

    public void BacaMatriksFromFile(String f) {
        /* I.S. Object matriks terdefinisi nilai idxBaris dan idxKolomnya */
        /*
         * F.S. M terdefinisi nilai semua elemennya, berukuran sesuai property objectnya
         * yaitu idxBaris x idxKolom
         */
        /*
         * Proses: Mengisi semua nilai elemen pada propety mat[][] sesuai yang terbaca
         * dari file f
         */
        File file = new File(f);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;

            int i = 0;
            int kol = 0;
            while ((st = br.readLine()) != null) {
                String[] words = st.split("\\s+");
                for (int j = 0; j < words.length; j++) {
                    double d = Double.parseDouble(words[j]);
                    this.Mat[i][j] = d;
                }
                kol = words.length;
                i++;
            }
            this.idxBaris = i;
            this.idxKolom = kol;
        }
        // Kasus jika terjadi kegagalan dalam membaca file
        catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void TulisMatriks() {
        /* I.S. Object matriks terdefinisi semua */
        /*
         * F.S. Nilai property Mat[i][j] ditulis ke layar per baris per kolom,
         * masing-masing elemen per baris dipisahkan sebuah spasi
         */
        /*
         * Proses: Menulis nilai setiap elemen Mat ke layar dengan traversal per baris
         * dan per kolom
         */
        /*
         * Contoh: menulis matriks 3x3 (d akhir tiap baris tidak ada spasi dan diakhir
         * baris terdapat enter) 1 2 3 4 5 6 8 9 10
         */
        for (int i = 0; i < this.idxBaris; i++) {
            for (int j = 0; j < this.idxKolom; j++) {
                System.out.format("%.2f ", this.Mat[i][j]);
            }
            System.out.println();
        }
    }

    public void TulisMatriksToFile() {
        /* I.S. Object matriks terdefinisi semua */
        /*
         * F.S. Nilai property Mat[i][j] ditulis ke file per baris per kolom,
         * masing-masing elemen per baris dipisahkan sebuah spasi
         */
        /*
         * Proses: Menulis nilai setiap elemen Mat ke file dengan traversal per baris
         * dan per kolom
         */
        String fileName = input.nextLine();
        try {
            FileWriter fw = new FileWriter(fileName);
            for (int i = 0; i < this.idxBaris; i++) {
                for (int j = 0; j < this.idxKolom; j++) {
                    fw.write(Double.toString(this.Mat[i][j]));
                    if (j != this.idxKolom - 1) {
                        fw.write(" ");
                    }
                }
                if (i != this.idxBaris - 1) {
                    fw.write(String.format("%n"));
                }
            }
            fw.close();
        }
        // Kasus jika terjadi kegagalan dalam menulis ke file
        catch (Exception e) {
            System.out.println(e);
        }
    }

    /* KELOMPOK OPERASI PADA MATRIKS */
    public double[][] getCofactor(double matIn[][], int p, int q, int n) {
        /* Prekondisi: matIn terdefinisi ukurannya sebesar n X n dan isinya */
        /*
         * Fungsi getCofactor mengembalikan sebuah nlai double[][] yaitu sub matriks
         * untuk ekspansi kofaktor pada indeks p,q dari matIn
         */
        /*
         * Ket: fungsi ini tidak memanipulasi object matriks karena fungsi ini akan
         * dipakai di method yang lain (buat ngebenerin bug tadi)
         */
        double[][] matOut = new double[n - 1][n - 1]; // Ukuran matriks cofactor akan selalu n-1 X n-1
        int matOutBrs = 0, matOutKol = 0;
        int matInBrs, matInKol;

        for (matInBrs = 0; matInBrs < n; matInBrs++) {
            for (matInKol = 0; matInKol < n; matInKol++) {
                // Jika elemet berindeks [p,q] maka akan dilewati
                if (matInBrs != p && matInKol != q) {
                    matOut[matOutBrs][matOutKol++] = matIn[matInBrs][matInKol];

                    // Increment nilai matOutKol lalu matOutBrs
                    if (matOutKol == (n - 1)) {
                        matOutKol = 0;
                        matOutBrs++;
                    }
                }
            }
        }
        return matOut;
    }

    public double determinantOfMatrix(double mat[][], int n) {
        /* Prekondisi: matriks mat terdefinisi dengan ukuran sebesar n X n */
        /* Fungsi determinantOfMatrix mengembalikan nilai determinan dari matriks mat */
        /*
         * Untuk ngetes coba di
         * https://www.iotools.net/math/matrix-determinant-calculator
         */

        // Set hasil akhir determinan
        double D = 0;

        // Basis jika hanya satu elemen
        if (n == 1) {
            D += mat[0][0];
            return (D);
        } else {
            // Untuk mengganti-ganti tanda saat menghitung determinan
            int sign = 1;

            for (int f = 0; f < n; f++) {
                // Mendapatkan matriks cofactor pada mat[0][f]
                double temp[][];
                temp = getCofactor(mat, 0, f, n);

                // Menggunakan rumus mat[0][0]* cofactor mat[0][0] +-... + mat[0][f] * cofactor
                // mat[0][f]
                D += sign * mat[0][f] * determinantOfMatrix(temp, n - 1);

                // Nilai sign berganti antara 1 dan -1
                sign = -1 * sign;
            }
            return (D);
        }
    }

    public double[][] getMatriksCofactor(double matIn[][], int n) {
        /* Prekondisi: matIn terdefinisi isinya dan berukuran n X n */
        /*
         * Fungsi getMatriksCofactor mengembalikan sebuah double[][] yaitu matriks
         * kofaktor hasil peng-kofaktoran terhadap matIn
         */
        double temp[][] = new double[n - 1][n - 1];
        double matOut[][] = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp = getCofactor(matIn, i, j, n);
                if ((i + j) % 2 == 0) {
                    matOut[i][j] = determinantOfMatrix(temp, n - 1);
                } else {
                    matOut[i][j] = -1 * determinantOfMatrix(temp, n - 1);
                }
            }
        }
        return matOut;
    }

    public double[][] getTranspose(double[][] matIn, int n, int m) {
        /* Prekondisi: matIn terdefinisi isinya dan berukuran n x m */
        /*
         * Fungsi getTranspose menghasilkan matriks transpose dari matIn yang berukuran
         * m x n
         */
        double[][] matTranspose;
        int i, j;

        matTranspose = new double[m][n];
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                matTranspose[i][j] = matIn[j][i];
            }
        }
        return matTranspose;
    }

    public double[][] getAdjoin(double[][] matIn, int n) {
        /* Prekonsisi: matIn terdefinis dan berukuran n x n */
        /*
         * Fungsi getAdjoint mengembalikan matriks transpose dari matriks cofactor matIn
         * yang berukuran n x n
         */
        double[][] adjoin = new double[n][n];

        adjoin =  this.getMatriksCofactor(matIn,n);
        
        adjoin = this.getTranspose(adjoin,n,n);
        return adjoin;
    }

    public void GaussElimination(double[][] matriks1) {
        double c = 0;

        for (int j = 0; j < this.idxKolom - 1; j++) { // akses Eliminasi
            for (int i = 0; i < this.idxBaris; i++) { // Per Kolom yang mana j menyatakan kolom dan i menyatakan baris
                if (i > j) {
                    int idx = 0;
                    int l = 1;
                    if (matriks1[j][j] == 0) {
                        for (idx = 0; j + idx < this.idxKolom - 1 && l != this.idxBaris + 1; idx++) {
                            for (l = 1; l < this.idxBaris - i; l++) {
                                if (matriks1[j][j + idx] != 0) {
                                    l = this.idxBaris + 1;
                                } else {
                                    tukar(matriks1, j, j + l);
                                    determinan *= -1;
                                }
                            }
                        }
                    }
                    if (matriks1[j][j + idx] != 0) {
                        c = matriks1[i][j] / matriks1[j][j + idx];
                        for (int k = 0; k < this.idxKolom; k++) { // pengurangan matriks per baris
                            matriks1[i][k] = matriks1[i][k] - c * matriks1[j][k];
                            if (matriks1[i][k] == -0) {
                                matriks1[i][k] = 0;
                            }
                        }
                    }
                }
            }
        }
    }

    public void tukar(double[][] matriks, int Brs1, int Brs2)
    // I.S Brs1 adalah Baris yang ingin ditukar untuk berada pada Brs2 dengan elemen
    // Brs1 tidak berubah (hanya berubah letak saja)
    {
        double temp;
        for (int j = 0; j < idxKolom; j++) {
            temp = matriks[Brs1][j];
            matriks[Brs1][j] = matriks[Brs2][j];
            matriks[Brs2][j] = temp;
        }
    }

    public double GetDeterminanOBE(double[][] matriks1)
    // I.S Matriks sudah mengalami Eliminasi Gauss
    {
        double determinan = 1;
        for (int i = 0; i < this.idxBaris; i++) {
            determinan = determinan * matriks1[i][i];
        }
        return determinan;
    }

    public void GaussJordanElimination(double[][] matriks1)
    // I.S Matriks tidak boleh mengalami OBE SEBELUMNYA!!
    {
        double c;
        boolean a = true;
        for (int i = this.idxBaris - 1; i >= 0; i--) {
            a = true;
            for (int j = 0; j < this.idxKolom - 1 && a == true; j++) {
                if (matriks1[i][j] != 0) {
                    for (int l = 1; i - l >= 0; l++) {
                        c = matriks1[i - l][j] / matriks1[i][j];
                        for (int k = 0; k < this.idxKolom; k++) {
                            matriks1[i - l][k] -= c * matriks1[i][k];

                            if (matriks1[i][k] == -0.00) {
                                matriks1[i][k] = 0.00;
                            }
                        }
                    }
                    double pembagi = matriks1[i][j];
                    for (int k = 0; k < this.idxKolom; k++) {
                        matriks1[i][k] = matriks1[i][k] / pembagi;
                        if (matriks1[i][k] == -0.00) {
                            matriks1[i][k] = 0.00;
                        }
                    }
                    a = false;
                }
            }
        }
    }

    public void Interpolasi() {

        matriks MatIn = new matriks (this.getidxBaris(), this.getidxKolom());
        int N = MatIn.getidxBaris();
        for (int i = 0; i < N; i++) {
            double x = input.nextDouble();
            double y = input.nextDouble();
            for (int j = 0; j < N + 1; j++) {
                if (j != N) {
                    MatIn.Mat[i][j] = Math.pow(x, j);
                } else {
                    MatIn.Mat[i][j] = y;
                }
            }
        }
        matriks temp = new matriks(this.getidxBaris(), this.getidxKolom()-1);
        if (temp.getidxBaris() == temp.getidxKolom())
         {
             for (int i = 0; i < temp.getidxBaris(); i++)
             {
                 for (int j = 0; j < temp.getidxKolom(); j++)
                 {
                     temp.Mat[i][j] = MatIn.getElement(i, j);
                 }
            }
            double[] D = new double[temp.getidxKolom()];
            double[] solution = new double[temp.getidxKolom()];
            double D_awal;
            D_awal = determinantOfMatrix(temp.Mat, temp.getidxKolom());
            if (D_awal != 0) {
                for (int j = 0; j < temp.getidxKolom(); j++) {
                    for (int i = 0; i < temp.getidxBaris(); i++) {
                        temp.Mat[i][j] = MatIn.getElement(i, temp.getidxKolom());
                    }
                    D[j] = determinantOfMatrix(temp.Mat, temp.getidxKolom());

                    solution[j] = D[j] / D_awal;

                    // manual exchanging. Karena
                    for (int k = 0; k < temp.getidxBaris(); k++) {
                        for (int l = 0; l < temp.getidxBaris(); l++) {
                            temp.Mat[k][l] = MatIn.getElement(k, l);
                        }
                    }
                }

            }
            System.out.print("y = ");
            for (int k = 0; k < temp.getidxKolom(); k++) {
                if (k == 0) {
                    System.out.print(solution[k] + " + ");
                } 
                else if ((k == 1) && (k != temp.getidxKolom()-1)) {
                    System.out.print(solution[k] + "x" + " + ");
                }
                else if ((k == 1) && (k == temp.getidxKolom()-1)) {
                    System.out.println(solution[k] + "x");
                }
                else if ((k > 1) && (k != temp.getidxKolom()-1)) {
                    System.out.print(solution[k] + "x" + k + " + ");
                }
                else
                {
                    System.out.println(solution[k] + "x" + k);
                }
            }
        }

    }

    public void invers ()
    //I.S Masukan Matriks belum mengalami OBE (ELIMINASI GAUSS JORDAN)
    { 
        double temp;
        double [][] matriks1;
        matriks1=this.Mat;
        this.setidx(idxBaris,2*idxBaris);
        for (int i=0;i<idxBaris;i++){
            for (int j=0; j<idxBaris; j++){
                this.Mat[i][j]=matriks1[i][j];
            }
            for(int k=idxBaris; k<2*idxBaris;k++){
                if (k==idxBaris+i){
                    this.Mat[i][k]=1;
                }
                else{
                    this.Mat[i][k]=0;
                }
            }
        }
        GaussElimination(this.Mat);
        GaussJordanElimination(this.Mat);
        TulisMatriks();
        for (int i=0;i<idxBaris;i++){
            for (int j=0;j<idxBaris;j++){
                temp=this.Mat[i][j+idxBaris];
                this.Mat[i][j]=temp;
            }
        }
        setidx(idxBaris,idxBaris);
    }

    public double[][] KaliMatriks(double[][] matriks1, double[][] matriks2, int idxBrs1, int idxKol2) {
        double[][] matriks;
        matriks = new double[idxBrs1][idxKol2];
        for (int i = 0; i < idxBrs1; i++) {
            for (int j = 0; j < idxKol2; j++) {
                matriks[i][j] = 0;
                for (int k = 0; k < idxBrs1; k++) {
                    matriks[i][j] += matriks1[i][k] * matriks2[k][j];
                }
            }
        }
        return matriks;
    }

    public boolean IsHaveSolution(double[][] matriks)
    // Mengecek apakah sebuah SPL memiliki solusi dan matriks sudah mengalami
    // Eliminasi Gauss Jordan
    {
        int count = 0;
        for (int i = 0; i < idxBaris; i++) {
            count = 0;
            for (int j = 0; j < idxKolom - 1; j++) {
                if (matriks[i][j] == 0) {
                    count++;
                }
            }
            if ((count == idxKolom - 1) && (matriks[i][idxKolom - 1] != 0)) {
                return false;
            }
        }
        return true;
    }

    public boolean IsHaveManySolution(double[][] matriks)
    // Matriks sudah mengalami Eliminasi Gauss Jordan
    {
        int count = 0;
        for (int i = 0; i < idxBaris; i++) {
            count = 0;
            for (int j = 0; j < idxKolom - 1; j++) {
                if (matriks[i][j] != 0) {
                    count++;
                }
            }
            if (count > 0) {
                return true;
            }
        }
        return false;
    }

    public boolean IsFreeVariabel(double[][] matriks, int idx)
    // Untuk Mengecek Apakah variabel idx adalah free variabel dan matriks dalam
    // keadaan sudah mengalami Eliminasi Gauss Jordan
    {
        for (int i = idxBaris - 1; i >= 0; i--) {
            for (int j = 0; j < idxKolom - 1; j++) {
                if (matriks[i][j] == 1) {
                    if (j == idx) {
                        return false;
                    }
                    j = idxKolom;
                }
            }
        }
        return true;

    }

    public void TulisSPLGaussJordan(double[][] matriks)
    // I.S Matriks belum mengalami eliminasi Gauss
    // Menuliskan hasil SPL dengan menggunakan eliminasi Gauss
    {
        if (!IsHaveSolution(matriks)) {
            System.out.println("Matriks Tidak Memiliki Solusi");
        } else if (!IsHaveManySolution(matriks)) {
            for (int i = 0; i < idxBaris; i++) {
                if (i == idxBaris - 1) {
                    System.out.format("dan x%d=%.2f.", i + 1, matriks[i][idxKolom - 1]);
                } else {
                    System.out.format("x%d=%.2f,", i + 1, matriks[i][idxKolom - 1]);
                }
            }
        } else {
            StringBuffer variabel = new StringBuffer();
            char a;
            String temp = "";
            for (int j = 0; j < idxKolom - 1; j++) {
                temp += "a";
            }
            variabel.append(temp);
            for (int j = 0; j < idxKolom - 1; j++) {
                if (IsFreeVariabel(matriks, j)) {
                    System.out.format("Variabel x%d adalah free variabel beri masukannya: \n", j + 1);
                    a = input.next().charAt(0);
                    variabel.setCharAt(j, a);
                }
            }
            int b = 0;
            for (int k = 0; k < idxKolom - 1; k++) {
                if (IsFreeVariabel(matriks, k)) {
                    if (k != idxKolom - 2) {
                        System.out.format("x%d=%c,", k + 1, variabel.charAt(k));
                    } else {
                        System.out.format("dan x%d=%c.", k + 1, variabel.charAt(k));
                    }
                } else {
                    for (int i = 0 + b; i < idxBaris; i++) {
                        for (int j = 0; j < idxKolom - 1; j++) {
                            if (matriks[i][j] == 1) {
                                if (k != idxKolom - 2) {
                                    System.out.format("x%d=", k + 1);
                                } else {
                                    System.out.format("dan x%d=", k + 1);
                                }
                                for (int l = j + 1; l < idxKolom - 1; l++) {
                                    if (matriks[i][l] != 0) {
                                        if (l != idxKolom - 2) {
                                            System.out.format("%.2f%c+", matriks[i][l] * -1, variabel.charAt(l));
                                        } else {
                                            if (matriks[i][l + 1] != 0) {
                                                System.out.format("%.2f%c+", matriks[i][l] * -1, variabel.charAt(l));
                                            }
                                        }
                                    }
                                }
                                if (matriks[i][idxKolom - 1] != 0) {
                                    if (k != idxKolom - 2) {
                                        System.out.format("%.2f,", matriks[i][idxKolom - 1]);
                                    } else {
                                        System.out.format("%.2f.", matriks[i][idxKolom - 1]);
                                    }
                                }
                                j = idxKolom;
                                i = idxBaris;
                                b++;
                            }
                        }
                    }
                }

            }
        }
    }

    public void TulisGauss(double[][] matriks)
    // I.S Matriks sudah mengalami eliminasi Gauss
    {
        double pembagi;
        boolean bool=true;
        for(int i=this.idxBaris-1; i>=0 ;i--){
            bool=true;
            for (int j=0; j<this.idxKolom-1 && bool==true; j++){
                if (this.Mat[i][j]!=0){
                     bool=false;
                     pembagi=this.Mat[i][j];
                     for (int k=0; k<idxKolom; k++){
                          this.Mat[i][k]/=pembagi;
                     }
                }
            }
        }
        StringBuffer variabel = new StringBuffer();
        char a;
        String temp = "";
        for (int j = 0; j < idxKolom - 1; j++) {
            temp += "a";
        }
        variabel.append(temp);
        for (int j = 0; j < idxKolom - 1; j++) {
            System.out.format("Berikan Pemisalan variabel x%d: \n", j + 1);
            a = input.next().charAt(0);
            variabel.setCharAt(j, a);
        }
        int b = 0;
        for (int k = 0; k < idxKolom - 1; k++) {
            if (IsFreeVariabel(matriks, k)) {
                if (k != idxKolom - 2) {
                    System.out.format("x%d=%c,", k + 1, variabel.charAt(k));
                } else {
                    System.out.format("dan x%d=%c.", k + 1, variabel.charAt(k));
                }
            } else {
                for (int i = 0 + b; i < idxBaris; i++) {
                    for (int j = 0; j < idxKolom - 1; j++) {
                        if (matriks[i][j] == 1) {
                            if (k != idxKolom - 2) {
                                System.out.format("x%d=", k + 1);
                            } else {
                                System.out.format("dan x%d=", k + 1);
                            }
                            for (int l = j + 1; l < idxKolom - 1; l++) {
                                if (matriks[i][l] != 0) {
                                    if (l != idxKolom - 2) {
                                        System.out.format("%.2f%c+", matriks[i][l] * -1, variabel.charAt(l));
                                    } else {
                                        if (matriks[i][l + 1] != 0) {
                                            System.out.format("%.2f%c+", matriks[i][l] * -1, variabel.charAt(l));
                                        } else {
                                            if (k != idxKolom - 2) {
                                                System.out.format("%.2f%c,", matriks[i][l] * -1, variabel.charAt(l));
                                            } else {
                                                System.out.format("%.2f%c.", matriks[i][l] * -1, variabel.charAt(l));
                                            }
                                        }
                                    }
                                }
                            }
                            if (matriks[i][idxKolom - 1] != 0) {
                                if (k != idxKolom - 2) {
                                    System.out.format("%.2f,", matriks[i][idxKolom - 1]);
                                } else {
                                    System.out.format("%.2f.", matriks[i][idxKolom - 1]);
                                }
                            }
                            j = idxKolom;
                            i = idxBaris;
                            b++;
                        }
                    }
                }
            }

        }
        System.out.format("\n setelah dieliminasi maka didapatkan hasil: \n");
        GaussJordanElimination(matriks);
        if (!IsHaveSolution(matriks)) {
            System.out.println("Matriks Tidak Memiliki Solusi");
        } else if (!IsHaveManySolution(matriks)) {
            for (int i = 0; i < idxBaris; i++) {
                if (i == idxBaris - 1) {
                    System.out.format("dan x%d=%.2f.", i + 1, matriks[i][idxKolom - 1]);
                } else {
                    System.out.format("x%d=%.2f,", i + 1, matriks[i][idxKolom - 1]);
                }
            }
        } else {
            b = 0;
            for (int k = 0; k < idxKolom - 1; k++) {
                if (IsFreeVariabel(matriks, k)) {
                    if (k != idxKolom - 2) {
                        System.out.format("x%d=%c,", k + 1, variabel.charAt(k));
                    } else {
                        System.out.format("dan x%d=%c.", k + 1, variabel.charAt(k));
                    }
                } else{ 
                    for (int i=0+b; i<idxBaris; i++){   
                             for (int j=0; j<idxKolom-1; j++){
                                 if (matriks[i][j]==1){
                                     if(k!=idxKolom-2){    
                                         System.out.format("x%d=",k+1);
                                     }
                                     else{
                                         System.out.format("dan x%d=",k+1);
                                     }
                                     for (int l=j+1; l<idxKolom-1; l++){
                                         if(matriks[i][l]!=0){    
                                             if (l!=idxKolom-2){
                                                 System.out.format("%.2f%c+",matriks[i][l]*-1,variabel.charAt(l));
                                             }
                                             else{
                                                 if(matriks[i][l+1]!=0){
                                                     System.out.format("%.2f%c+",matriks[i][l]*-1,variabel.charAt(l));
                                                 }
                                                 else{
                                                     if(k!=idxKolom-2){
                                                         System.out.format("%.2f%c,",matriks[i][l]*-1,variabel.charAt(l));
                                                     }
                                                     else{
                                                         System.out.format("%.2f%c.",matriks[i][l]*-1,variabel.charAt(l));
                                                     }
                                                 }
                                             }
                                         }
                                     }
                                     if(matriks[i][idxKolom-1]!=0){
                                         if(k!=idxKolom-2){
                                             System.out.format("%.2f,",matriks[i][idxKolom-1]);
                                         }
                                         else{
                                             System.out.format("%.2f.",matriks[i][idxKolom-1]);
                                         }
                                     }
                                     j=idxKolom;  
                                     i=idxBaris;
                                     b++;
                                 }
                             }
                         }
                     }
                 
                 }
        }
     }
    
     public void getMatriksInvers()
     {
        double D = determinantOfMatrix(this.Mat, this.getidxBaris()); 
        this.Mat = getAdjoin(this.Mat, this.getidxBaris());
        for(int i = 0; i < this.getidxBaris(); i++)
        {
            for (int j = 0; j < this.getidxKolom(); j++)
            {
               this.Mat[i][j] = getElement(i, j) / D;
            }
        }
     }
     public double[][] getWithoutAugmented()
     {
        double[][] matriks_withoutAugmented = new double [this.getidxBaris()][this.getidxKolom()-1];
         
        for(int i = 0; i < this.getidxBaris(); i++ )
        {
            for(int j = 0; j < this.getidxKolom()-1; j++)
            {
                matriks_withoutAugmented[i][j] = this.getElement(i, j);
            }
        }
        return matriks_withoutAugmented;
     }
     public void TulisSPLMatriksBalikan ( )
     {
        int idxBarisInvers = this.idxBaris;
        int idxKolomInvers = this.idxKolom - 1;
        matriks matriks_invers = new matriks (idxBarisInvers, idxKolomInvers);
        matriks matriks_onlyAugmented = new matriks (idxBarisInvers , 1);
        matriks matriks_withoutAugmented = new matriks (idxBarisInvers , idxKolomInvers);
        matriks_withoutAugmented.Mat = this.getWithoutAugmented();
        
        matriks_onlyAugmented.Mat = OnlyAugmented(this.Mat);
        
        matriks_withoutAugmented.invers();

        matriks matriks_hasil = new matriks(idxBarisInvers,1);
        matriks_hasil.Mat = matriks_withoutAugmented.KaliMatriks(matriks_invers.Mat, matriks_onlyAugmented.Mat,idxBarisInvers,1);
        for (int i=0; i<idxBarisInvers; i++){
             if(i!=idxBarisInvers-1){
                 System.out.format("x%d=%.2f,",i+1,matriks_hasil.Mat[i][0]);
             }
             else{
                 System.out.format("dan x%d=%.2f.",i+1,matriks_hasil.Mat[i][0]);
                 System.out.println("");
             }
         }
     }
     public void TulisSPLMatriksBalikanCrammer()
     {
        int idxBarisInvers = this.idxBaris;
        int idxKolomInvers = this.idxKolom - 1;
        matriks matriks_invers = new matriks (idxBarisInvers, idxKolomInvers);
        matriks matriks_onlyAugmented = new matriks (idxBarisInvers , 1);
        matriks matriks_withoutAugmented = new matriks (idxBarisInvers , idxKolomInvers);
        matriks_withoutAugmented.Mat = this.getWithoutAugmented();
        
        matriks_onlyAugmented.Mat = OnlyAugmented(this.Mat);
        matriks_withoutAugmented.getMatriksInvers();
        matriks_invers = matriks_withoutAugmented;

        matriks matriks_hasil = new matriks(idxBarisInvers,1);
        matriks_hasil.Mat = matriks_withoutAugmented.KaliMatriks(matriks_invers.Mat, matriks_onlyAugmented.Mat,idxBarisInvers,1);
        for (int i=0; i<idxKolomInvers; i++){
             if(i!=idxKolomInvers){
                 System.out.format("x%d=%.2f,",i+1,matriks_hasil.Mat[i][0]);
             }
             else{
                 System.out.format("dan x%d=%.2f.",i+1,matriks_hasil.Mat[i][0]);
                 System.out.println("");
             }
         }
     }
    
     
     public double [][] OnlyAugmented (double[][] matriks) {
         double [][] matriks1= new double[this.idxBaris][1];
         for (int i=0; i<this.idxBaris; i++){
             matriks1[i][0]=matriks[i][idxKolom-1];
         }
         return matriks1;
     }

     public void TulisSPLCrammer()
     {
         matriks temp = new matriks (this.getidxBaris(), this.getidxKolom() - 1);
         if (temp.getidxBaris() == temp.getidxKolom())
         {
             for (int i = 0; i < temp.getidxBaris(); i++)
             {
                 for (int j = 0; j < temp.getidxKolom(); j++)
                 {
                     temp.Mat[i][j] = this.getElement(i, j);
                 }
            }
            double[] D = new double[temp.getidxKolom()];
            double[] solution = new double[temp.getidxKolom()];
            double D_awal;
            D_awal = determinantOfMatrix(temp.Mat, temp.getidxKolom());
            if (D_awal != 0) {
                for (int j = 0; j < temp.getidxKolom(); j++) {
                    for (int i = 0; i < temp.getidxBaris(); i++) {
                        temp.Mat[i][j] = this.getElement(i, temp.getidxKolom());
                    }
                    D[j] = determinantOfMatrix(temp.Mat, temp.getidxKolom());

                    solution[j] = D[j] / D_awal;

                    // manual exchanging. Karena
                    for (int k = 0; k < temp.getidxBaris(); k++) {
                        for (int l = 0; l < temp.getidxBaris(); l++) {
                            temp.Mat[k][l] = this.getElement(k, l);
                        }
                    }
                }

            }
            for (int k = 0; k < temp.getidxKolom(); k++) {
                if (k != temp.getidxKolom()) {
                    System.out.print("x" + k + " = " + solution[k] + ", ");
                } else {
                    System.out.println("dan x" + k + " = " + solution[k]);
                }
            }
        }

    }

    public void KaliMatriks(matriks matriks2) // tanpa augmented
    {
        if (this.idxKolom != matriks2.idxBaris)
            System.out.println("Kedua Matriks tidak dapat dikalikan.");
        else {
            double sum = 0;
            int i, j, k, l;
            i = this.idxBaris;
            j = this.idxKolom;

            k = matriks2.idxBaris;
            l = matriks2.idxKolom;
            int a, b, c;
            for (a = 0; a < i; a++) {
                for (b = 0; b < l; b++) {
                    for (c = 0; c < k; c++) {
                        sum = sum + this.getElement(a, c) * matriks2.getElement(c, b);
                    }
                }

                this.Mat[a][b] = sum;
                sum = 0;

            }

        }
    }

    /* End */
}
