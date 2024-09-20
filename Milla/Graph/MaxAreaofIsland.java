package Milla.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaofIsland {

    static int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};

    public static void main(String[] args) {
        System.out.println(maxAreaOfIsland(new int[][]{{0,1,1,0,1},
                {1,0,1,0,1},
                {0,1,1,0,1},
                {0,1,0,0,1}}));
    }
    public static int maxAreaOfIsland(int[][] grid) {
        int max = Integer.MIN_VALUE;
        boolean v[][] = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(!v[i][j] && grid[i][j] == 1) {
                    max = Math.max(bfs(i,j,grid,v),max);
                }
            }
        }
        return max;
    }

    public static int bfs(int x, int y, int[][] grid, boolean[][] v){
        v[x][y] = true;
        Queue<Dots> q = new LinkedList();
        q.add(new Dots(x,y));
        int cnt = 0;

        while (!q.isEmpty()){
            Dots dots = q.poll();
            x = dots.x;
            y = dots.y;
            cnt++;

            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if(nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length) continue;
                if(v[nx][ny] || grid[nx][ny] == 0) continue;
                q.add(new Dots(nx,ny));
                v[nx][ny] = true;
            }
        }
        return cnt;
    }

    static class Dots{
        int x;
        int y;
        public Dots(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
