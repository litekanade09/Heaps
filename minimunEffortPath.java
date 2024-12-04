import java.util.PriorityQueue;

class MinimumEffortPath {
    public static int minEffort(int[][] heights) {
        int n = heights.length; // Number of rows
        int m = heights[0].length; // Number of columns

        // Directions for moving in the grid (down, up, right, left)
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // Priority queue to store (effort, x, y)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // 2D array to keep track of the minimum effort to reach each cell
        int[][] effort = new int[n][m];

        // Initialize effort array with max values
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                effort[i][j] = Integer.MAX_VALUE; // Set initial efforts to max
            }
        }

        // Start from the top-left corner with an initial effort of 0
        minHeap.offer(new int[]{0, 0, 0}); // {effort, x, y}
        effort[0][0] = 0; // Initial effort at the starting point

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int curEffort = current[0];
            int x = current[1];
            int y = current[2];

            // If we've reached the bottom-right corner, return the effort
            if (x == n - 1 && y == m - 1) {
                return curEffort; // This is the minimum effort path found
            }

            // Explore all four neighboring cells
            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                // Check if the neighbor is within bounds
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    // Calculate the effort to move to the neighbor
                    int newEffort = Math.max(curEffort, Math.abs(heights[nx][ny] - heights[x][y]));

                    // If the new effort is less than the previously recorded effort for this cell
                    if (newEffort < effort[nx][ny]) {
                        effort[nx][ny] = newEffort; // Update the minimum effort
                        minHeap.offer(new int[]{newEffort, nx, ny}); // Add to the priority queue
                    }
                }
            }
        }

        return -1; // If no path is found (shouldn't happen)
    }

    public static void main(String[] args) {
        int heights[][] = {
                {31, 100, 65, 12, 18},
                {10, 13, 47, 157, 6},
                {100, 113, 174, 11, 33},
                {88, 124, 41, 20, 140},
                {99, 32, 111, 41, 20}
        };
        System.out.println(minEffort(heights)); // Should output 327
    }
}
