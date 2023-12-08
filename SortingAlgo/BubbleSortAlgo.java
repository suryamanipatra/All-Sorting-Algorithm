public class BubbleSortAlgo {
    static void bubbleSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n-1; i++){
            for (int j = 0; j < n-i-1; j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                }
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {5,4,1,2,3,6,0};
        bubbleSort(arr);
        for (int i : arr){
            System.out.print(i + " ");
        }
    }
}
