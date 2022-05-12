// j vishwanath
//20csu296
// 0-1 knapsack
import java.util.Scanner;
public class knapsack01{

    public static void main(String[] args) {


        knappy();
    

        
    }

    private static void knappy() {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();  //number of integers
        int[] vals = new int[n];
        int[] wts = new int[n];

        for (int i = 0; i < vals.length; i++) {
            vals[i] = scn.nextInt(); //profits

        }

        for (int i = 0; i < wts.length; i++) {
            wts[i] = scn.nextInt(); // coresponding weights

        }
        int cap = scn.nextInt(); // capacity of the knapsACK

        int[][] dp = new int[n + 1][cap + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                if (j >= wts[i - 1]) {

                    int rcap = j - wts[i - 1];

                    if (dp[i - 1][rcap] + vals[i - 1] > dp[i - 1][j]) {
                        dp[i][j] = dp[i - 1][rcap] + vals[i - 1];
                    }

                    else{
                        dp[i][j] = dp[i-1][j];
                    }

                }
                else{
                    dp[i][j] = dp[i-1][j];
                }

            }
        }

        System.out.println(dp[n][cap]);

        for (int i = n; i > 0; i--) {
            if (dp[i][cap]!= dp[i-1][cap]) {
                System.out.println(i + "contributing");   
                cap = cap - wts[i-1];
            }
            else{
                System.out.println(i + "not contributing");
            }
        }


        scn.close();
    }




    

}

// //PS G:\My Drive\ADA> cd "g:\My Drive\ADA\" ; if ($?) { javac knapsack01.java } ; if ($?) { java knapsack01 }
// 5 
// 3 5 8 4 10
// 2 4 5 3 9
// 12
// 17
// 5 not contributing
// 4 contributing
// 3 contributing
// 2 contributing
// 1 not contributing