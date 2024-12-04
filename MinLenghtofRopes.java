import java.util.*;
public class MinLenghtofRopes {
    public static void main(String[] args) {
        int length[] = {2,3,3,4,6};

        PriorityQueue<Integer> ropes = new PriorityQueue<>();
        for(int i = 0;i < length.length;i++){
            ropes.add(length[i]);
        }
        int cost = 0;
        while(ropes.size() > 1){
            int min1 = ropes.remove();
            int min2 = ropes.remove();
            cost += min1 + min2;
            ropes.add(min1+ min2);
        }
        System.out.print("The Minimun lenghtof the ropes is " + cost);

    }
}
