
import java.util.Scanner;
public class polinom extends matriks{
    
double hitungPolinom (double[] solution, double x)
{
    double y = 0;

    for(int i = 0; i < this.getidxBaris(); i++ )
    {
        y+= solution[i]*Math.pow(x,i);
    }
    return y;
}
public static void main(String[] args) {

    Scanner input = new Scanner (System.in);
    double x;
    double y;
    int a,b;
    a = input.nextInt();
    b = input.nextInt();
    polinom M = new polinom();
    polinom.matriks(a,b);
    M.BacaMatriks();
    x = input.nextDouble();
    y = M.hitungPolinom(M.Mat[1],x);
    System.out.println(y);
    }
}