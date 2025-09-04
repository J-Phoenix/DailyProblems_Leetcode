class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if(mat == null || mat.length == 0) return new int[0];
        
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];
        int row = 0, col = 0, d = 0; // d = 0 -> up-right, d = 1 -> down-left
        int[][] dirs = {{-1, 1}, {1, -1}}; // directions for zigzag
        
        for(int i = 0; i < m * n; i++) {
            result[i] = mat[row][col];
            
            // move in current direction
            row += dirs[d][0];
            col += dirs[d][1];
            
            // check boundaries
            if(row >= m) { row = m - 1; col += 2; d = 1 - d; }       // bottom border
            if(col >= n) { col = n - 1; row += 2; d = 1 - d; }       // right border
            if(row < 0)  { row = 0; d = 1 - d; }                     // top border
            if(col < 0)  { col = 0; d = 1 - d; }                     // left border
        }
        
        return result;
    }
}
