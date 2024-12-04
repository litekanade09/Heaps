import java.util.*;
public class insertioninHeaps {
    static class Heaps{
        ArrayList<Integer> arr = new ArrayList<>();
        public void add(int data){
            arr.add(data);
            int x = arr.size() - 1;
            int par = (x - 1)/2;

            while(arr.get(x) < arr.get(par)){
                int temp = arr.get(x);
                arr.set(x,arr.get(par));
                arr.set(par,temp);

                x=par;
                par = (x-1)/2;
            }
        }
        public int peek() {
            return arr.get(0);
        }
        public int remove(){
            int data = arr.get(0);

            //step1
            int temp = arr.get(0);
            arr.set(0,arr.get(arr.size() -1));
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
            if(minindx != i){
                int temp = arr.get(i);
                arr.set(i , arr.get(minindx));
                arr.set(minindx, temp);

                heapify(minindx);
            }
        }
        public boolean isEmpty(){
            return arr.size() == 0;
        }
    }

    public static void main(String[] args) {
        Heaps h = new Heaps();
        h.add(3);
        h.add(7);
        h.add(5);
        while(!h.isEmpty()){
            System.out.print(h.peek());
            h.remove();
        }
    }
}
