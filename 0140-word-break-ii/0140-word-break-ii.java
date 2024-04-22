class Solution {
    private String s;
    private Map<Integer, String> substringMap;
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.s = s;
        substringMap = new HashMap<>();
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            substringMap.put(i, new String(array, i, array.length - i));
        }
        Set<String> wordSet = new HashSet<>(wordDict);
        Map<Integer, List<String>> memo = new HashMap<>();
        return dfs(s, 0, wordSet, memo);
    }
    private List<String> dfs(String s, int index, Set<String> wordSet, Map<Integer, List<String>> memo) {
        // terminating condition
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        // normal condition
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            result.add("");
            return result;
        }
        StringBuilder sb = new StringBuilder();
        for (String word : wordSet) {
            if (s.startsWith(word)) {
                List<String> nextResult = dfs(substringMap.get(index + word.length()), index + word.length(), wordSet, memo);
                for (String nextComponent : nextResult) {
                    sb.setLength(0);
                    sb.append(word).append(nextComponent.isEmpty() ? "" : " ").append(nextComponent);
                    result.add(sb.toString());
                }
            }
        }
        memo.put(index, result);
        return result;
    }
}