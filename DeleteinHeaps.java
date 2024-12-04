import java.util.*;
public class DeleteinHeaps {
    static class Heaps{
        ArrayList<Integer> arr = new ArrayList<>();
        public int remove(){
            int data = arr.get(0);

            //step1
            int temp = arr.get(0);
            arr.set(0,arr.size() - 1);
            arr.set(arr.size() - 1,temp);

            //step2
            arr.remove(arr.size() -1);

            //step3
            heapify(0);
            return data;
        }
        public void heapify(int i){
            int left = 2*i+1;
            int right = 2*i+2;
            int minindx = i;
            if(left< arr.size() && arr.get(minindx) > arr.get(left)){
                minindx = left;
            }
            if(right< arr.size() && arr.get(minindx) > arr.get(right)){
                minindx = right;
            }
            if(minindx != 1){
                int temp = arr.get(i);
                arr.set(i , arr.get(minindx));
                arr.set(arr.get(minindx), temp);

                heapify(i);
            }

        }
    }

    public static void main(String[] args) {

    }
}
