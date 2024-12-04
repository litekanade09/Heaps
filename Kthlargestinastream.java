import java.util.*;
public class Kthlargestinastream {
    static class kthlargest implements Comparable<kthlargest>{
        int val;
        public kthlargest(int val){
            this.val = val;
        }
        @Override
        public int compareTo(kthlargest k2){
            return this.val - k2.val;
        }
    }
    public static void main(String[] args) {
        int nums[] = {10, 20, 11, 70, 50, 40, 100, 5};
        int k = 3;

        PriorityQueue<kthlargest> pq = new PriorityQueue<>();
        List<Integer> output = new ArrayList<>();

        for(int num : nums){
            pq.add(new kthlargest(num));
            if(pq.size() > k){
                pq.poll();
            }
            if(pq.size() < k){
                output.add(null);
            }else{
                output.add(pq.peek().val);
            }
        }

        for(Integer val : output){
            if(val == null){
                System.out.print("_");
            }else{
                System.out.print(val +" ");
            }
        }
        System.out.println();
    }
}
