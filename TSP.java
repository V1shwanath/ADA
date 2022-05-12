public class TSP {

    int N[] = {1,2,4,5};
    int cost[][] = new int [5][5];
    int visited[] = {0,0,0,0,0};
    
    int dist[][] = {
        {100,2,6,4,3}, 
        {2,100,5,7,9},
        {6,5,100,11,8}, 
        {9,7,11,100,12},
        {3,9,8,12,100}};
        
    public static void tsp(int[] N , int s, int visited){

        
        visited[0] = s;
        int k = 0;

        if (N.length == 2 && k != s) {
            cost(N,k);

        }


    }
    
                


    


    



    public static void main(String[] args) {

    }

}