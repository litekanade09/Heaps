import java.util.*;
public class MaximumnooftimetofilltheNslots {
    public static void minTime(int arr[],int N,int k){
        Queue<Integer> q = new LinkedList<>();

        boolean vis[] = new boolean[N + 1];
        int time = 0;

        for(int i = 0;i < k;i++){
            q.add(arr[i]);
            vis[arr[i]] = true;
        }
        boolean allFilled = true;
        for (int i = 1; i <= N; i++) {
            if (!vis[i]) {
                allFilled = false;
                break;
            }
        }

        if (allFilled) {
            System.out.println(0);  // No time needed as all slots are initially filled
            return;
        }

        while(!q.isEmpty()){
            for(int i = 0;i < q.size();i++){
                int curr = q.poll();
                if(curr - 1 >= 1 && !vis[curr - 1]){
                    vis[curr - 1]= true;
                    q.add(curr - 1);
                }

                if(curr + 1 <= N && !vis[curr+1]){
                    vis[curr + 1]=true;
                    q.add(curr + 1);
                }
            }
            time++;
        }
        System.out.println(time - 1);
    }
    public static void main(String[] args) {
        int N = 6;
        int arr[] = {2,6};
        int k = arr.length;
        minTime(arr,N,k);

    }
}
