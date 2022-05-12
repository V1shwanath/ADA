import java.io.IOException;
import java.util.Scanner;

// import javax.swing.event.SwingPropertyChangeSupport;

class Greedy {
    private static final int IntM = 0;

    public static void main(String args[]) throws IOException {
        // knapsack_inputs();

        prim();
    }

    static void prim() {

        int IntM = Integer.MAX_VALUE;

        int cost[][] = { { IntM, 5, IntM, IntM, 3 },
                { 5, IntM, 2, 8, IntM },
                { IntM, 2, IntM, 9, 6 },
                { IntM, 8, 9, IntM, 4 },
                { 3, IntM, 6, 4, IntM } };

        prims_MST(cost);


    }

    static void prims_MST(int cost[][])

    {
        int INT_MAX = Integer.MAX_VALUE;
        int V = 5;
        boolean[] inMST = new boolean[V];

        inMST[0] = true;

        int edge_count = 0, mincost = 0;
        while (edge_count < V - 1) {

            // Find minimum weight valid edge.
            int min = INT_MAX, a = -1, b = -1;
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (cost[i][j] < min) {
                        if (validedge(i, j, inMST)) {
                            min = cost[i][j];
                            // System.out.println(min);
                            a = i;
                            b = j;
                        }
                    }
                }
            }

            if (a != -1 && b != -1) {
                System.out.printf("Edge %d:(%d, %d) cost: %d \n",
                        edge_count++, a, b, min);
                mincost = mincost + min;
                inMST[b] = inMST[a] = true;
            }
        }
        System.out.printf("\n Minimum cost = %d \n", mincost);
    }

    static boolean validedge(int i, int j, boolean[] inmst) {

        if (i == j)
            return false;
        if (inmst[i] == false && inmst[j] == false)
            return false;
        else if (inmst[i] == true && inmst[j] == true)
            return false;
        return true;
    }

    private static void knapsack_inputs() {
        try (Scanner sc = new Scanner(System.in)){

            // arr[0][i] = 4 8 2 6 1
            // arr[1][i] = 12 32 40 30 50

            // int[] array = new int[5]
            // array

            int i, max_qty, n;
            System.out.println("no of items");
            n = sc.nextInt();
            int array[][] = new int[2][n];

            System.out.println(" the weights");
            for (i = 0; i < n; i++)
                array[0][i] = sc.nextInt();

            System.out.println("values ");
            for (i = 0; i < n; i++)
                array[1][i] = sc.nextInt();

            System.out.println("capacity  :");
            max_qty = sc.nextInt();

            knapsack(max_qty, n, array);
            sc.close();
        }
    }

    private static void knapsack(int max_qty, int n, int[][] array) {
        float sum = 0;
        int m;
        int j = 0;
        m = max_qty;
        while (m > 0) {
            float max = 0;
            for (int i = 0; i < n; i++) {
                float v = ((float) array[1][i]) / ((float) array[0][i]);
                // 3 4 20 5 50
                // 5 4 2 3 1 ,

                if (v > max) {
                    max = v;
                    j = i;
                }
            }

            if (array[0][j] > m) {

                sum += m * max;
                m = -1;

            } else {
                m = m - array[0][j];
                sum += (float) array[1][j];
                array[1][j] = 0;

            }

        }
        System.out.println("sum " + sum);

    }

}
// PS G:\My Drive\ADA> cd "g:\My Drive\ADA\" ; if ($?) { javac Greedy.java } ; if ($?) { java Greedy }    
// no of items
// 5
//  the weights
// 5 4 2 3 1
// values
// 3 4 20 5 50
// capacity  :
// 10
// sum 79.0


// PS G:\My Drive\ADA> cd "g:\My Drive\ADA\" ; if ($?) { javac Greedy.java } ; if ($?) { java Greedy }
// Edge 0:(0, 4) cost: 3 
// Edge 1:(3, 4) cost: 4 
// Edge 2:(0, 1) cost: 5 
// Edge 3:(1, 2) cost: 2 