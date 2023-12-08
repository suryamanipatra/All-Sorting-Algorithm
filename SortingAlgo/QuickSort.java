public class QuickSort {
    static void displayArray(int[] arr){
        for (int ans : arr){
            System.out.print(ans + " ");
        }
    }
    static void swap(int[] arr,int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    static int partition(int[] arr,int start,int end){
        int pivot = arr[start];
        int count = 0;
        for (int i = start+1; i <= end;i++){
            if (arr[i] <= pivot) count++;
        }
        int pivotIndex = start + count;
        swap(arr,start,pivotIndex);
        int i = start, j = end;
        while(i < pivotIndex && j > pivotIndex){
            while(arr[i] <= pivot) i++;
            while(arr[j] > pivot) j--;
            if (i < pivotIndex && j > pivotIndex){
                swap(arr,i,j);
                i++;
                j--;
            }
        }
        return pivotIndex;
    }
    static void quickSort(int[] arr,int start, int end){
        if (start >= end) return;
        int partitionIndex = partition(arr,start,end);
        quickSort(arr,start,partitionIndex-1);
        quickSort(arr,partitionIndex+1,end);

    }
    public static void main(String[] args) {
        int[] arr = {6,3,1,5,4,5,6};
        System.out.println("Array before sorting");
        displayArray(arr);
        System.out.println();
        quickSort(arr,0, arr.length - 1);
        System.out.println("Array after sorting");
        displayArray(arr);
    }
}
