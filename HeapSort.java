import java.util.*;
public class HeapSort {
    public static void heapsort(int arr[]){    //Time complexity O(nlogn)
        //step1 = build maxheap
        int n = arr.length;
        for(int i = n/2;i >= 0;i--){
            heapify(i,n,arr);
        }

        //step2 = push largest at end
        for(int i = n -1;i >0;i --){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(0,i,arr);
        }
    }
    public static void heapify(int i,int size,int arr[]){
        int left = 2*i+1;
        int right = 2*i+2;
        int maxheap = i;

        //to make decending ,change the sign of arr[left ,right] as "<" rest is same

        if(left < size && arr[left] > arr[maxheap]){
            maxheap = left;
        }
        if(right < size  && arr[right] > arr[maxheap]){
            maxheap= right;
        }
        if(maxheap != i){
            int temp = arr[i];
            arr[i] = arr[maxheap];
            arr[maxheap] = temp;

            heapify(maxheap,i,arr);
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,3,5,2,4};
        heapsort(arr);
        for(int i= 0;i<arr.length;i++){
            System.out.println(arr[i]);

        }
    }
}
