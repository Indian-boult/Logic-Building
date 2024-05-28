class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] memo = new int[m][n];
        int maxPath = 1;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxPath = Math.max(maxPath, dfs(matrix, i, j, memo));
            }
        }
        
        return maxPath;
    }
    
    private int dfs(int[][] matrix, int i, int j, int[][] memo) {
        if (memo[i][j] != 0) return memo[i][j];
        
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int maxPath = 1;
        
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            
            if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] <= matrix[i][j])
                continue;
            
            int len = 1 + dfs(matrix, x, y, memo);
            maxPath = Math.max(maxPath, len);
        }
        
        memo[i][j] = maxPath;
        return maxPath;
    } 
}