package Milla.Graph;

public class NumberOfIsland {
    public static void main(String[] args) {
        char[][] grid = {
                {'0', '1', '1', '1', '0'},
                {'0', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};

        System.out.println(numIslands(grid));
    }
    public static int numIslands(char[][] grid) {
        int ans = 0;
        boolean v[][] = new boolean[grid.length][grid[0].length];
        int dir[][] = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.println("i"+i+", j"+j);
                if(!v[i][j] && grid[i][j] == '1') {
                    dfs(i,j,v,dir,grid);
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void dfs(int x, int y, boolean[][] v, int[][] dir, char[][] grid){
        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if(nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length || v[nx][ny] || grid[nx][ny] == '0') continue;
            v[nx][ny] = true;
            dfs(nx,ny,v,dir,grid);
        }
        return;
    }
}
