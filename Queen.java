//j. Vishwanath 20csu296.. 4/21/2022
//ADA 

import java.lang.Math;
import java.util.Arrays;
public class Queen {


    static int x[] = new int[8];
    public static boolean place(int k){
        for (int i = 0; i < k; i++) {
            if (x[i] == x[k]|| Math.abs(x[i]-x[k]) == Math.abs(i-k)) {
                return false;

            }


        }
        return true;
    }    


    public static void nqueen(int n){
        int k = 0;
        x[k]  = -1;
        int m= 0;
        while (true) {
            x[k]  = x[k] +1;
            while (x[k] <=n && ! place(k)) {
                x[k] = x[k] +1;


            }
            if (x[k]<n) {
                if (k == (n-1)) {
                    System.out.println(Arrays.toString(x));
                    m += 1;
                    System.out.println(m);
                    // return;
                }
                else{
                    k = k +1;
                    x[k] = -1;

                }

                

            }
            else{
                
                k = k-1;
            
            
            };
        }

    }

    

    public static void main(String[] args) {
        nqueen(8);
    }




}


//PS G:\My Drive\ADA> cd "g:\My Drive\ADA\" ; if ($?) { javac Queen.java } ; if ($?) { java Queen }
//[0, 4, 7, 5, 2, 6, 1, 3]