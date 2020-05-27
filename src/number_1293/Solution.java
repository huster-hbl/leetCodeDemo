package number_1293;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][][] visited = new boolean[m][n][k + 1];
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 0));
        visited[0][0][0] = true;

        int distance = 0;
        while (!queue.isEmpty()) {
            distance++;
            int size = queue.size();

            while (size-- > 0) {
                Point point = queue.poll();
                int x = point.x;
                int y = point.y;
                int z = point.z;

                if (x == m - 1 && y == n - 1) {
                    return distance - 1;
                }

                for (int[] dir : dirs) {
                    int tmpX = x + dir[0];
                    int tmpY = y + dir[1];
                    int tmpZ = z;

                    if (tmpX < 0 || tmpX >= m || tmpY < 0 || tmpY >= n) {
                        continue;
                    }

                    if (grid[tmpX][tmpY] == 1) {
                        if (z < k) {
                            tmpZ = z + 1;
                        } else {
                            continue;
                        }
                    }

                    if (!visited[tmpX][tmpY][tmpZ]) {
                        queue.add(new Point(tmpX, tmpY, tmpZ));
                        visited[tmpX][tmpY][tmpZ] = true;
                    }
                }


            }
        }
        return -1;
    }

    class Point {
        int x;
        int y;
        int z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0}, {1, 1, 0}, {0, 0, 0}, {0, 1, 1}, {0, 0, 0}};
        new Solution().shortestPath(grid, 1);
    }
}
