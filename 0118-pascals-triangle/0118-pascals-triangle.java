class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> t = new ArrayList<>();
        t.add(1);
        res.add(t);
        
        for(int i =1; i < numRows; i++){
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(0,1);
            for(int j = 1; j < i; j++){
                tmp.add(res.get(i-1).get(j) + res.get(i-1).get(j-1));
            }
            tmp.add(1);
            res.add(tmp);
        }
        return res;
    }
}