public class RadixSortAlgo {
    static int findMaxInArray(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length;i++){
            if (arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
    static void display(int[] arr){
        for (int value : arr){
            System.out.print(value + " ");
        }
    }
    static void countSort(int[] arr, int place){
        int n = arr.length;
        int[] outputArr = new int[n];
      //  int maxValue = findMaxInArray(arr);// find the largest element in the array
        int[] frequencyArr = new int[10];
        for (int i=0; i < arr.length; i++){ // make frequency arr
            frequencyArr[(arr[i]/place)%10]++;
        }
        // make the prefix sum array of frequencyArr
        for (int i =1; i < frequencyArr.length; i++){
            frequencyArr[i]+= frequencyArr[i-1];
        }
        // find the index of each element of original array and put it in output array.
        for (int i = n-1; i >= 0; i--){
            int index =   frequencyArr[(arr[i]/place)%10] - 1;
            outputArr[index] = arr[i];
            frequencyArr[(arr[i]/place)%10]--;
        }
        // copy of elements of output to arr
        for (int i = 0; i < n; i++){
            arr[i] = outputArr[i];
        }
    }
    static void radixSort(int[] arr){
        int max = findMaxInArray(arr);   // got max element
        // Apply count sort to sort elements based on the place value like i's, 10's,100's etc...
        for (int place = 1; max/place > 0; place += 10){
            countSort(arr,place);
        }
    }

    public static void main(String[] args) {
         int[] arr = {43,567,213,898,0,2,45};
         radixSort(arr);
         display(arr);
    }
}
