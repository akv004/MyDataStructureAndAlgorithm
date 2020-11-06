package my.code.dfs;

public class NumberOfIslands {
    public static void main(String args[]){
        char[][] grid = {
                {'1','1','1',},
                {'0','0','0',},
                {'1','0','1',},
                {'1','0','1',},
        };
        Solution s = new Solution();
        int i = s.numberOfIslands(grid);
        System.out.println(i);
    }
}

class Solution {


    int numberOfIslands(char[][] grid){
        int count =0;

        int nr = grid.length;
        int nc = grid[0].length;

        if(grid ==null){
         return count;
        }
        for(int r=0; r<nr; r++){
            for(int c=0; c<nc; c++){
                if(grid[r][c]=='1') {
                    dfc(grid,r,c);
                    ++count;
                }

            }
        }
        return count;
    }

    private void dfc(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;
        if(r<0|| c<0|| r>=nr||c>=nc || grid[r][c]== '0'){
            return;
        }
        grid[r][c] = '0'; // make it visited
        dfc(grid,r-1,c);
        dfc(grid,r+1,c);
        dfc(grid,r,c-1);
        dfc(grid,r,c+1);
    }
}
