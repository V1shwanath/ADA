public class fkp
{
    public static void main(String[] args)
    {
        float[][] arr={{25, 36, 10, 50, 29}, {7, 7, 9, 2, 5}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
       
        fk(arr, 15);
    }

    private static void fk(float[][] arr, int s)
    {
        int i, Weight=0, profit=0, n=0;
       
       
        for (i=0; i<5; i++)
        {
            arr[2][i]=arr[0][i]/arr[1][i];
        }
       
        sort(arr);
       
        for (i=0; i<5; i++)
        {
            if ((s-Weight)>=arr[1][i])
            {
                arr[3][i]=1;
                Weight+=arr[1][i];
                profit+=arr[0][i]*arr[3][i];
                n++;
            }
           
            else
            {
                arr[3][i]=(s-Weight)/arr[1][i];
                Weight+=arr[3][i]*arr[1][i];;
                profit+=arr[3][i]*arr[0][i];
                n++;
                break;
            }
        }
        System.out.println();
        printarr(arr);
        System.out.println("\nThe Profit and number of Items is "+profit+" and "+n);
       
       
    }
   
    private static void printarr(float[][] arr)
    {
        int i,j;
       
        for (i=0; i<4; i++)
        {
            for (j=0; j<5; j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void sort(float[][] arr)
    {
        int i, j, n=arr[0].length;
       
        for (i=0; i<n; i++)
        {
            for (j=0; j<n-1; j++)
            {
                if (arr[2][j]<arr[2][j+1])
                {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    private static void swap(float[][] arr, int i, int j)
    {
        int k;
       
        for (k=0; k<4; k++)
        {
            float temp=arr[k][i];
            arr[k][i]=arr[k][j];
            arr[k][j]=temp;
        }
    }
}