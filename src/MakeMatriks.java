package matriksDasar;

import java.util.Scanner;

public class MakeMatriks {
  Scanner input = new Scanner(System.in);
  private int idxBaris,idxKolom; // Akses idxBaris hanya bisa pada class MakeMatriks sehingga bila ingin mengubah besaran harus menggunakan fungsi SetIndeks dan ingin mengambil bisa menggunakan fungsi GetIndeks
  private double determinan=1;
   
  public void SetIndeks(int idxBrs, int idxKol)
   {
      idxBaris=idxBrs;
      idxKolom=idxKol;
   }
  
  public int GetIndeksBaris()
   {
       return idxBaris;
   }
   
  public int GetIndeksKolom()
   {
       return idxKolom;
   }
   
  public void BacaMatriks(double[][] matriks1) 
   {
       for(int i=0; i<idxBaris; i++){
           for(int j=0; j<idxKolom; j++){
               matriks1[i][j] = input.nextDouble();
           }
       }
       
   } 
  
  public void TulisMatriks(double[][] matriks1) 
   {
       for(int i=0; i<idxBaris; i++){
           for(int j=0; j<idxKolom; j++){
               System.out.format("%.2f ",matriks1[i][j]);
           }
           System.out.println();
       }
   }
  
  public void GaussElimination(double[][] matriks1)
    {
        double c=0;
        for(int j=0; j<idxKolom-1; j++){             //akses Eliminasi
            for(int i=0; i<idxBaris; i++){         //Per Kolom yang mana j menyatakan kolom dan i menyatakan baris
                if(i>j){
                    int idx=0;
                    int l=1;
                    if (matriks1[j][j]==0){
                        for (idx=0; j+idx<idxKolom-1 && l!=idxBaris+1; idx++){    
                            for (l=1; l<idxBaris-i;l++){
                                if(matriks1[j][j+idx]!=0){
                                    l=idxBaris+1;
                                }
                                else{
                                    tukar(matriks1,j,j+l);
                                    determinan*=-1;
                                }
                            }
                        }
                    }
                    if (matriks1[j][j+idx]!=0){
                        c=matriks1[i][j]/ matriks1[j][j+idx];
                        for(int k=0; k<idxKolom; k++){  //pengurangan matriks per baris
                            matriks1[i][k]=matriks1[i][k]-c*matriks1[j][k];
                            if(matriks1[i][k]==-0){
                                    matriks1[i][k]=0;
                                }
                         }
                    }
                }
            }
        }
    }

  public double GetDeterminanOBE(double[][] matriks1)
    //I.S Matriks sudah mengalami Eliminasi Gauss
    {   
        for (int i=0; i<idxBaris; i++){
            determinan= determinan* matriks1[i][i];
        }
        return determinan;
        
    }
  
  public void GaussJordanElimination(double[][] matriks1)
    // I.S Matriks tidak boleh mengalami OBE SEBELUMNYA!!
    {
        double c;
        boolean a=true;
        for(int i=idxBaris-1; i>=0; i--){
            a=true;
            for (int j=0; j<idxKolom-1 && a==true; j++){
                if(matriks1[i][j]!=0){    
                    for (int l=1; i-l>=0 ;l++){
                        c=matriks1[i-l][j]/matriks1[i][j];
                        for (int k=0; k<idxKolom ; k++ ){
                            matriks1[i-l][k]-=c*matriks1[i][k];
                            if (matriks1[i][k]==-0.00){
                                matriks1[i][k]=0.00;
                            }
                        }
                    }
                    double pembagi=matriks1[i][j];
                    for (int k=0; k<idxKolom ; k++ ){
                        matriks1[i][k]=matriks1[i][k] / pembagi;
                        if (matriks1[i][k]==-0.00){
                            matriks1[i][k]=0.00;
                        }
                    }
                    a=false;
                }
            }
        }
                
    }

  public void invers (double[][] matriks1)
   //I.S Masukan Matriks belum mengalami OBE (ELIMINASI GAUSS JORDAN)
   {
       double[][] matriks=new double [idxBaris] [2*(idxBaris)];
       for (int i=0;i<idxBaris;i++){
           for(int j=0; j<idxBaris;j++){
               matriks[i][j]=matriks1[i][j];
           }
           for(int k=idxBaris; k<2*idxBaris;k++){
               if (k==idxBaris+i){
                   matriks[i][k]=1;
               }
               else{
                   matriks[i][k]=0;
               }
           }
       }
       GaussElimination(matriks);
       GaussJordanElimination(matriks);
       for (int i=0;i<idxBaris;i++){
           for (int j=0;j<idxBaris;j++){
               matriks1[i][j]=matriks[i][j+idxBaris];
           }
       }
   }
   
   public void tukar(double [][] matriks, int Brs1, int Brs2)
   //I.S Brs1 adalah Baris yang ingin ditukar untuk berada pada Brs2 dengan elemen Brs1 tidak berubah (hanya berubah letak saja)
   {
       double temp;
       for (int j=0; j<idxKolom; j++ ){
           temp=matriks[Brs1][j];
           matriks[Brs1][j]=matriks[Brs2][j];
           matriks[Brs2][j]=temp;
       }
   }
   
   public double[][] KaliMatriks(double [][] matriks1, double [][] matriks2, int idxBrs1, int idxKol2)
   {
       double [][] matriks;
       matriks = new double [idxBrs1][idxKol2];
       for (int i=0; i<idxBrs1; i++){
           for (int j=0; j<idxKol2; j++){
               matriks[i][j]=0;
               for (int k=0; k<idxBrs1; k++){
                   matriks[i][j]+=matriks1[i][k]*matriks2[k][j];
               }
           }
       }
       return matriks;
   }

    public void BacaMatriksFromFile(String f) {
        File file = new File(f);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;

            int i=0;
            int kol=0;
            while((st = br.readLine()) != null) {
                String[] words = st.split("\\s+");
                for (int j=0; j<words.length; j++) {
                    double d = Double.parseDouble(words[j]);
                    this.Mat[i][j] = d;
                }
                kol = words.length;
                i++;
            }
            this.idxBaris = i;
            this.idxKolom = kol;
        }
        catch (FileNotFoundException e) {
            System.out.println(e);
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    public void TulisMatriksToFile() {
        String fileName = input.nextLine();
        try {
            FileWriter fw = new FileWriter(fileName);
            for(int i=0; i<idxBaris; i++){
                for(int j=0; j<idxKolom; j++){
                    fw.write(Double.toString(this.Mat[i][j]));
                    if (j!= idxKolom-1) {
                        fw.write(" ");
                    }
                }
                if (i != idxBaris-1) {
                    fw.write(String.format("%n"));
                }
            }
            fw.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
   
    public void Interpolasi() {
        int N = input.nextInt();
        double x,y;

        this.SetIndeks(N, N+1);
        for (int i=0; i<N; i++) {
            x = input.nextDouble();
            y = input.nextDouble();
            for (int j=0; j<N+1; j++) {
                if (j != N){
                    this.Mat[i][j] = Math.pow(x, j);
                } else {
                    this.Mat[i][j] = y;
                }
            }
        }
        this.TulisMatriks();
    }
  public boolean IsHaveManySolution (double [][] matriks) 
   // Matriks sudah mengalami Eliminasi Gauss Jordan
   {
       int count=0;
       for (int i=0; i<idxBaris; i++){
           count=0;
           for (int j=0; j<idxKolom-1; j++){
               if(matriks[i][j]!=0){
                   count++;
               }
            }
           if (count>0){
               return true;
           }
       }
       return false;
   }
   
   public boolean IsFreeVariabel (double[][] matriks, int idx)
   //Untuk Mengecek Apakah variabel idx adalah free variabel dan matriks dalam keadaan sudah mengalami Eliminasi Gauss Jordan
   {    
       for (int i=idxBaris-1; i>=0; i--){
           for (int j=0; j<idxKolom-1; j++){
               if(matriks[i][j]==1){
                   if(j==idx){
                       return false;
                   }
                   j=idxKolom;
               }
           }
       }
       return true;
       
   }
   
   public void TulisSPLGaussJordan (double [][] matriks)
   //I.S Matriks belum mengalami eliminasi Gauss
   //Menuliskan hasil SPL dengan menggunakan eliminasi Gauss
   {
       if (!IsHaveSolution(matriks)){
           System.out.println("Matriks Tidak Memiliki Solusi");
       }
       else if (!IsHaveManySolution(matriks)){
           for (int i=0;i<idxBaris; i++){
               if(i==idxBaris-1){
                   System.out.format("dan x%d=%.2f.",i+1,matriks[i][idxKolom-1]);
               }
               else{
                   System.out.format("x%d=%.2f,",i+1,matriks[i][idxKolom-1]);
               }
           }
       }
       else {
           StringBuffer variabel= new StringBuffer();
           char a;
           String temp="";
           for (int j=0; j<idxKolom-1; j++){
                temp+="a";
           }
           variabel.append(temp);
           for (int j=0; j<idxKolom-1; j++){
               if (IsFreeVariabel(matriks,j)){
                   System.out.format("Variabel x%d adalah free variabel beri masukannya: \n",j+1);
                   a=input.next().charAt(0);
                   variabel.setCharAt(j,a);
               }
           }
           int b=0;
           for (int k=0; k<idxKolom-1; k++){
               if (IsFreeVariabel(matriks,k)){
                    if(k!=idxKolom-2){    
                        System.out.format("x%d=%c,",k+1,variabel.charAt(k));
                    }
                    else{
                        System.out.format("dan x%d=%c.",k+1,variabel.charAt(k));
                    }
               }
               else{ 
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
    public void TulisGauss(double [][] matriks)
    //I.S Matriks sudah mengalami eliminasi Gauss
    {
           StringBuffer variabel= new StringBuffer();
           char a;
           String temp="";
           for (int j=0; j<idxKolom-1; j++){
                temp+="a";
           }
           variabel.append(temp);
           for (int j=0; j<idxKolom-1; j++){
                System.out.format("Berikan Pemisalan variabel x%d: \n",j+1);
                a=input.next().charAt(0);
                variabel.setCharAt(j,a);
           }
           int b=0;
           for (int k=0; k<idxKolom-1; k++){
               if (IsFreeVariabel(matriks,k)){
                    if(k!=idxKolom-2){    
                        System.out.format("x%d=%c,",k+1,variabel.charAt(k));
                    }
                    else{
                        System.out.format("dan x%d=%c.",k+1,variabel.charAt(k));
                    }
               }
               else{ 
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
           System.out.format("\n setelah dieliminasi maka didapatkan hasil: \n");
           GaussJordanElimination(matriks);
           if (!IsHaveSolution(matriks)){
                System.out.println("Matriks Tidak Memiliki Solusi");
            }
            else if (!IsHaveManySolution(matriks)){
                for (int i=0;i<idxBaris; i++){
                    if(i==idxBaris-1){
                        System.out.format("dan x%d=%.2f.",i+1,matriks[i][idxKolom-1]);
                    }
                    else{
                        System.out.format("x%d=%.2f,",i+1,matriks[i][idxKolom-1]);
                    }
                }
            }
            else {
                b=0;
                for (int k=0; k<idxKolom-1; k++){
                    if (IsFreeVariabel(matriks,k)){
                         if(k!=idxKolom-2){    
                             System.out.format("x%d=%c,",k+1,variabel.charAt(k));
                         }
                         else{
                             System.out.format("dan x%d=%c.",k+1,variabel.charAt(k));
                         }
                    }
                    else{ 
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
  public void TulisSPLMatriksBalikan (double [][] matriksInvers, double [][] onlyAugmented, int idxBarisInvers, int idxKolomAugmented )
    {
        double[][] matriks= new double[idxBarisInvers][idxKolomAugmented];
        matriks=KaliMatriks(matriksInvers,onlyAugmented,idxBarisInvers,idxKolomAugmented);
        for (int i=0; i<idxBarisInvers; i++){
            if(i!=idxBarisInvers-1){
                System.out.format("x%d=%.2f,",i+1,matriks[i][idxKolomAugmented]);
            }
            else{
                System.out.format("dan x%d=%.2f.",i+1,matriks[i][idxKolomAugmented]);
            }
        }
    } 
    
    public double [][] OnlyAugmented (double[][] matriks) {
        double [][] matriks1= new double[idxBaris][1];
        for (int i=0; i<idxBaris; i++){
            matriks1[i][1]=matriks[i][idxKolom-1];
        }
        return matriks1;
    }
     
}
