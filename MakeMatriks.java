
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
               System.out.print(" "+matriks1[i][j]+" ");
           }
           System.out.println();
       }
   }
    public void GaussElimination(double[][] matriks1)
    {
        double c=0;
        for(int j=0; j<idxBaris; j++){             //akses Eliminasi
            for(int i=0; i<idxBaris; i++){         //Per Kolom yang mana j menyatakan kolom dan i menyatakan baris
                if(i>j){
                    for (int k=1; k<=idxBaris-i;k++){
                        if(matriks1[j][j]!=0){
                            k=idxBaris;
                        }
                        else{
                            tukar(matriks1,j,j+k);
                            determinan*=-1;
                        }
                    }   
                    if (matriks1[j][j]!=0){
                        c=matriks1[i][j]/ matriks1[j][j];
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
        for(int i=0; i<idxBaris; i++){
            for (int j=0; j<idxBaris; j++){
                if (j>i){
                    if(matriks1[j][j]!=0){    
                        c=matriks1[i][j]/ matriks1[j][j];
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
        for(int i=0; i<idxBaris; i++){
            if(matriks1[i][i]!=0){
            for (int j=idxBaris; j<idxKolom; j++){
                matriks1[i][j]/=matriks1[i][i];
                
            }
            matriks1[i][i]/=matriks1[i][i];
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
        
        
        
    
   
    
}
