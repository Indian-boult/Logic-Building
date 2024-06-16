class FU{
    int parent[], size[];
    FU(int n){
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            if(i < n - 1)   size[i] = 1;
            else            size[i] = 1000; //need to priorties nth element i.e., roof in union
        }
    }
    
    public void union(int x, int y){
        int px = find(x), py = find(y);
        if(px == py)    return;
        if(size[px] < size[py]){ //if union with nth elem always consider nth element don't consider size just choose nth elem as parent
            int t = px;
            px = py;
            py = t;
        }
        parent[py] = px;
        size[px] += size[py];
    }

    public int find(int x){
        if(parent[x] == x)  return x;
        return parent[x] = find(parent[x]);
    }
}
class Solution {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int n = grid.length, m = grid[0].length, res[] = new int[hits.length];
        for(int []hit: hits)    grid[hit[0]][hit[1]] = 3 - grid[hit[0]][hit[1]]; //if brick was existing val is 2 orelse 3
        FU fu = new FU(n * m + 1); //consider n * m th elem as roof (it denots the head of connect group)
        for(int i = 0; i < n; i++){ 
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    if(i == 0)    fu.union(j, n * m);       //if base brick add to roof set
                    else{
                        if(grid[i - 1][j] == 1){
                            fu.union(i * m + j, (i - 1) * m + j); //add its adjacent briks to its group 
                        }
                        if(j > 0 && grid[i][j - 1] == 1){
                            fu.union(i * m + j, i * m + (j - 1)); //add its adjacent briks to its group 
                        }
                    }
                }
            }
        }

        int adj[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for(int i = hits.length - 1; i > -1; i--){  
            int prevSize = fu.size[n * m], x = hits[i][0], y = hits[i][1];
            if(grid[x][y] == 3)     continue;   //if brick was not present don't add it, there is no change
            grid[x][y] = 1;
            if(x == 0)    fu.union(n * m, y);  //if base brick add to roof set
            //add its adjacent briks to its group 
            for(int cord[]: adj){
                int newX = x + cord[0], newY = y + cord[1];
                if(newX > -1 && newY > -1 && newX < n && newY < m && grid[newX][newY] == 1) fu.union(x * m + y, newX * m + newY);
            }
            //result = roof size - previous roof size - (1 ? new brick is part of roof group : 0 ? doesn't effect roof group i.e., it is unstable)
            res[i] = fu.size[n * m] - prevSize - (fu.find(x * m + y) == n * m ? 1 : 0); //last operand is if we got that elem in our connect set, if yes then only roof size will differ

        }
        return res;
    }
    
}