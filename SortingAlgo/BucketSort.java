import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    static void bucketSort(float[] arr){
        int n = arr.length;
        // create  buckets
        ArrayList<Float>[] buckets = new ArrayList[n];
        // create empty buckets
        for (int i = 0; i < n; i++){
            buckets[i] = new ArrayList<Float>();
            }
        // add elements into buckets
        for (int i = 0; i < n; i++){
            int bucketIndex = (int) arr[i] * n;
            buckets[bucketIndex].add(arr[i]);
        }
        // sort each bucket individually
        for (int  i = 0; i < buckets.length; i++){
            Collections.sort(buckets[i]);
        }
        // arrange all buckets to get find the sorted array
        int index = 0;
        for (int i = 0; i < buckets.length;i++){
            ArrayList<Float> currentBucket = buckets[i];
            for (int j = 0; j<currentBucket.size(); j++){
                arr[index++] = currentBucket.get(j);
            }
        }

    }

    public static void main(String[] args) {
        float[] arr = {0.5f,0.4f,0.3f,0.2f,0.1f};
        bucketSort(arr);
        for (float ans : arr){
            System.out.print(ans + " ");
        }

    }
}
