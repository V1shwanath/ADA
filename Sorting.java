import java.util.Random;
import java.util.Scanner;


class Sorting {

    static void bubbleSort(int array[]) {
        int size = array.length;

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (array[j] > array[j + 1]) {

                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

    }

    static void insertionSort(int array[]) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    static void selectionSort(int array[]) {
        int n = array.length;
        int i = 0;
        while (i <= n - 1) {
            int min_index = i;
            int j = i + 1;
            while (j < n) {
                if (array[j] < array[min_index])
                    min_index = j;
                j++;
            }
            int temp = array[i];
            array[i] = array[min_index];
            array[min_index] = temp;
            i++;
        }

    }

    static void TimeComp(int array[]) {
        final long startTime = System.nanoTime();
        // bubbleSort(array);
        // insertionSort(array);
        // selectionSort(array);
        // quicksort(array);
            heapsort(array);
        final long endTime = System.nanoTime();
        System.out.println((endTime - startTime));
    }

    static void printarr(int array[]) {
        int n = array.length;
        for (int i = 0; i < n; ++i)
            System.out.print(array[i] + " ");
        System.out.println();
    }

    static void mergesort(int array[]) {

        int n = array.length;
        if (n < 2) {
            return;
        }
        int mid_index = array.length / 2;
        int[] leftHalf = new int[mid_index];
        int[] rightHalf = new int[n - mid_index];

        for (int i = 0; i < mid_index; i++) {
            leftHalf[i] = array[i];
        }

        for (int i = mid_index; i < n; i++) {
            rightHalf[i - mid_index] = array[i];
        }

        mergesort(rightHalf);
        mergesort(leftHalf);

        merge(array, leftHalf, rightHalf);

    }

    static void merge(int array[], int leftHalf[], int rightHalf[]) {
        int l_len = leftHalf.length;
        int r_len = rightHalf.length;

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < l_len && j < r_len) {
            if (leftHalf[i] <= rightHalf[j]) {
                array[k] = leftHalf[i];
                i++;
            } else {
                array[k] = rightHalf[j];
                j++;
            }
            k++;
        }
        while (i < l_len) {
            array[k] = leftHalf[i];
            i++;
            k++;
        }
        while (j < r_len) {
            array[k] = rightHalf[j];
            j++;
            k++;
        }
    }

    static void quicksort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    static void quicksort(int[] array, int lowIndex, int highIndex) {

        if (lowIndex >= highIndex) {
            return;
        }
        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, highIndex);
        int lp = lowIndex;
        int rp = highIndex;

        while (lp < rp) {


            //1 2 4 3  5
        
            while (array[lp] <= pivot && lp < rp) {
                lp++;
            }
            while (array[rp] >= pivot && lp < rp) {
                rp--;
            }

            swap(array, lp, rp);
        }
        swap(array, lp, highIndex);

        quicksort(array, lp + 1, highIndex);
        quicksort(array, lowIndex, lp - 1);
    }

    static void swap(int array[], int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    
    
    
    static void heapify(int array[], int n, int i) {
        
        int largest;
        int l = 2 * i +1;
        int r = 2 * i + 2;

        if (l < n && array[l] > array[i]) { 
            largest = l;     
        }
        else{
            largest = i;
        }
        if (r < n && array[r] > array[largest]) {
            largest = r;
            
        }

        if (largest != i) {
            swap(array, i,largest);
            heapify(array, n, largest);
        }

    }
    
    private static int max_heap(int[] array) {
        int n = array.length;
        for (int i = n -1/ 2; i >= 0; i--) {
            heapify(array, n, i);
        }
        return n;
    }
    
    static void heapsort(int array[]) {
        int n = max_heap(array);
    
            for (int i = n - 1; i > 0; i--) {
                int temp = array[i];
                array[i] = array[0];
                array[0] = temp;
                // swap(array, array[0], array[i]);
    
                heapify(array, i, 0);
            }
    }
    




 

    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of elements in an array: ");
        int num = scan.nextInt();

        int[] data = new int[num];
        for (int i = 0; i < num; i++) {
            data[i] = (int) (Math.random() * num);
            // System.out.print(data[i] + " ");
        }
        // System.out.println();

        while (true) {
            Input_statements();

            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Bubble");
                    bubbleSort(data);
                    printarr(data);
                    break;
                case 2:
                    System.out.println("insertion");
                    insertionSort(data);
                    printarr(data);
                    TimeComp(data);
                    break;
                case 3:
                    System.out.println("selection");
                    selectionSort(data);
                    printarr(data);
                    TimeComp(data);
                    break;
                case 4:
                    System.out.println("merge");
                    mergesort(data);
                    printarr(data);
                    TimeComp(data);
                    break;
                case 5:
                    System.out.println("quick");
                    quicksort(data);
                    // printarr(data);
                    TimeComp(data);
                    break;

                case 6:
                    System.out.println("Heap");
                    heapsort(data);
                    printarr(data);
                    // TimeComp(data);
                    break;
                case 9:
                    System.out.println("Exiting the application");
                    System.exit(0);
                default:
                    System.out.println("Incorrect input!!!");

            }

        }

    }

    private static void Input_statements() {
        System.out.println("\n");
        System.out.println("Bubble Enter value 1");
        System.out.println("Insertion Enter value 2");
        System.out.println("Selection Enter value 3");
        System.out.println("Merge Enter value 4");
        System.out.println("Quicksort Enter value 5");
        System.out.println("HeapSort Enter value 6");
        System.out.println("To Exit Enter value 9");
        System.out.println("Enter your choice: ");
    }

}
/* 
Bubble Enter value 1
Insertion Enter value 2
Selection Enter value 3
Merge Enter value 4
Quicksort Enter value 5
HeapSort Enter value 6
To Exit Enter value 9
Enter your choice:
4
merge
0 1 3 3 3 6 6 7 8 9
9800


Bubble Enter value 1
Insertion Enter value 2
Selection Enter value 3
Merge Enter value 4
Quicksort Enter value 5
HeapSort Enter value 6
To Exit Enter value 9
Enter your choice:
5
quick
9000
*/