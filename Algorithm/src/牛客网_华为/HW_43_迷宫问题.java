package 牛客网_华为;

import java.util.*;

public class HW_43_迷宫问题 {
    private int n;
    private int m;
    private int[][] maze;
    private class Pair {
        int i;
        int j;
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
        public String toString() {
            return "(" + i + "," + j + ")";
        }
    }

    public HW_43_迷宫问题(int n, int m, int[][] maze) {
        this.n = n;
        this.m = m;
        this.maze = maze;
    }

    private boolean dfs(int[][] maze, int i, int j, Stack<Pair>paths) {
        if (maze[i][j] != 0) return false;
        paths.push(new Pair(i, j));
        // at the end point
        if (i == n - 1 && j == m - 1) return true;
        // go down
        if (i + 1 < n && dfs(maze, i+1, j, paths)) {
            return true;
        }
        // go right
        if (j + 1 < m && dfs(maze, i, j+1, paths)) {
            return true;
        }
        paths.pop();
        return false;
    }

    public void solve() {
        Stack<Pair> paths = new Stack<>();
        dfs(maze, 0, 0, paths);
        for (Pair point : paths) {
            System.out.println(point);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] maze = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    maze[i][j] = in.nextInt();
                }
            }
            HW_43_迷宫问题 solution = new HW_43_迷宫问题(n, m, maze);
            solution.solve();
        }
    }
}
