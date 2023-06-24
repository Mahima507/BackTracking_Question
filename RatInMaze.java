// Rat in a Maze (Rat Move to Up , Left, Right, Down)
import java.util.ArrayList;
import java.util.Arrays;

public class RatInMaze {
    static int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    static String str = "RLDU";

    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans = new ArrayList<>();
        if (m[0][0] == 0)
            return ans;
        String path = "";
        boolean[][] vis = new boolean[n][n];
        for (boolean[] row : vis)
            Arrays.fill(row, false);
        vis[0][0] = true;
        f(0, 0, path, vis, m, n, ans);
        return ans;
    }

    public static void f(int row, int col, String path, boolean[][] vis, int[][] m, int n, ArrayList<String> ans) {
        if (row == n - 1 && col == n - 1) {
            ans.add(path);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nr = row + directions[i][0];
            int nc = col + directions[i][1];

            if (nr >= 0 && nc >= 0 && nr < n && nc < n && vis[nr][nc] == false && m[nr][nc] == 1) {
                vis[nr][nc] = true;
                f(nr, nc, path + str.charAt(i), vis, m, n, ans);
                vis[nr][nc] = false;
            }
        }
    }

    public static void main(String args[]) {
        int[][] maze = { 
            { 1, 0, 0, 0 },
            { 1, 1, 0, 1 },
            { 0, 1, 0, 0 },
            { 1, 1, 1, 1 } 
        };

        int size = maze.length;
        ArrayList<String> paths = findPath(maze, size);

        if (paths.isEmpty()) {
            System.out.println("No paths found in the maze.");
        } else {
            System.out.println("Paths found in the maze:");
            for (String path : paths) {
                System.out.println(path);
            }
        }
    }
}
