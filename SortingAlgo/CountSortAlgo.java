public class CountSortAlgo {
    static int findMaxInArray(int[] arr){
        int mx = Integer.MIN_VALUE;
        for (int i =0; i < arr.length; i++){
            if (arr[i] > mx){
                mx = arr[i];
            }
        }
        return mx;
    }
    static void basicCountSort(int[] arr){
        int maxValue = findMaxInArray(arr);
        int[] frequencyArr = new int[maxValue+1];
        for (int i = 0; i < arr.length; i++){
            frequencyArr[arr[i]]++;
         /*   0 0 3 0 1
            0 1 2 3 4
                    */
        }
        int k = 0;
        for (int i = 0; i < frequencyArr.length; i++){
            for (int j = 0; j < frequencyArr[i]; j++){
                arr[k++] = i;
            }
        }

    }
    static void display(int[] arr){
        for (int value : arr){
            System.out.print(value + " ");
        }
    }
    static void countSort(int[] arr){
        int n = arr.length;
        int[] outputArr = new int[n];
        int maxValue = findMaxInArray(arr);// find the largest element in the array
        int[] frequencyArr = new int[maxValue+1];
        for (int i=0; i < arr.length; i++){ // make frequency arr
            frequencyArr[arr[i]]++;
        }
        // make the prefix sum array of frequencyArr
        for (int i =1; i < frequencyArr.length; i++){
            frequencyArr[i]+= frequencyArr[i-1];
        }
        // find the index of each element of original array and put it in output array.
        for (int i = n-1; i >= 0; i--){
            int index =   frequencyArr[arr[i]] - 1;
            outputArr[index] = arr[i];
            frequencyArr[arr[i]]--;
        }
        for (int i = 0; i < n; i++){
            arr[i] = outputArr[i];
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,4,3,6,4,6,1};
        countSort(arr) ;
        display(arr);
        System.out.println();
        basicCountSort(arr);
        display(arr);
    }
}

