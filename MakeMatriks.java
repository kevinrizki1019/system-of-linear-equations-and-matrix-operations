
package matriksDasar;
import java.util.Scanner;
public class MakeMatriks {
  Scanner input = new Scanner(System.in);
   
   void BacaMatriks(double[][] matriks1, int idxBaris, int idxKolom) {
       for(int i=0; i<idxBaris; i++){
           for(int j=0; j<idxKolom; j++){
               matriks1[i][j] = input.nextFloat();
           }
       }
       
   } 
   void TulisMatriks(double[][] matriks1, int idxBaris, int idxKolom) {
       for(int i=0; i<idxBaris; i++){
           for(int j=0; j<idxKolom; j++){
               System.out.print(" "+matriks1[i][j]+" ");
           }
           System.out.println();
       }
   }
    void GaussElimination(double[][] matriks1, int idxBaris, int idxKolom){
        double c=0;
        for(int j=0; j<idxBaris; j++){             //akses Eliminasi
            for(int i=0; i<idxBaris; i++){         //Per Kolom yang mana j menyatakan kolom dan i menyatakan baris
                if(i>j){
                    c=matriks1[i][j]/ matriks1[j][j];
                    for(int k=0; k<idxKolom; k++){  //pengurangan matriks per baris
                        matriks1[i][k]=matriks1[i][k]-c*matriks1[j][k];
                    }
                }
            }
        }
    }
    double GetDeterminanOBE(double[][] matriks1, int idxBaris, int idxKolom){
        double determinan=1;
        for (int i=0; i<idxBaris; i++){
            determinan= determinan* matriks1[i][i];
        }
        return determinan;
        
    }
    void GaussJordanElimination(double[][] matriks1, int idxBaris, int idxKolom){
        double c;
        for(int i=0; i<idxBaris; i++){
            for (int j=0; j<idxBaris; j++){
                if (j>i){
                    c=matriks1[i][j]/ matriks1[j][j];
                    for(int k=0; k<idxKolom; k++){  //pengurangan matriks per baris
                            matriks1[i][k]=matriks1[i][k]-c*matriks1[j][k];
                    }
                }
            }
        }
        for(int i=0; i<idxBaris; i++){
            for (int j=idxBaris; j<idxKolom; j++){
                matriks1[i][j]/=matriks1[i][i];
            }
            matriks1[i][i]=1;
        }
    }
   void invers (double[][] matriks1, int idxBaris, int idxKolom){
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
       TulisMatriks(matriks,idxBaris,idxBaris*2);
       GaussElimination(matriks,idxBaris,idxBaris*2);
       GaussJordanElimination(matriks,idxBaris,idxBaris*2);
       for (int i=0;i<idxBaris;i++){
           for (int j=0;j<idxBaris;j++){
               matriks1[i][j]=matriks[i][j+idxBaris];
           }
       }
   }
        
        
        
    
   
    
}
