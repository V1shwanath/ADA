public class knapp20 {


    public static void main(String[] args) {
        
        int n = 6;
        int[] wt = {2,4,5,3,9};
        int[] pi = {3,5,8,4,10};
    
        int cap = 13;
    
    
        int dpp[][] = new int[n+1][cap+1];
    
    
    
        for (int i = 1; i < dpp.length; i++) {
            for (int j = 1; j < dpp.length; j++) {


                if (j < wt[i-1]) {
                    


                    dpp[i][j] = dpp[i-1][j];

                    





                }


                else{


                    dpp[i][j] = dpp[i-1][j];
                }




            }
        }
    }

    public static int max(int a , int b){

        if ( a>  b) {
            return a;
        }

        else{
            return b;
        }

    }


    
}
