class Solution {
    public List<List<Integer>> combine(int n, int k) {
        // declare a arrayList
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();

        // call a backtracking function
        backtracking(n, k, 1, result, currentCombination);

        // return a result
        return result;
    }

    public void backtracking(int n, int k, int start, List<List<Integer>>result, List<Integer> currentCombination) {

        // check the current combination size is equal to the k
        if (currentCombination.size() == k) {
            result.add(new ArrayList<Integer>(currentCombination));
            return;
        }

        // add a combination into the currentCombination
        for (int i = start; i <= n; i++) {
            currentCombination.add(i);
            backtracking(n, k, i+1, result, currentCombination);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}