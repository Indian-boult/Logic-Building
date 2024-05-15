class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return result;
        }
        backtrack(result, new StringBuilder(), num, target, 0, 0, 0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder path, String num, int target, int pos, long eval, long multed) {
        if (pos == num.length()) {
            if (target == eval) {
                result.add(path.toString());
            }
            return;
        }
        
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') break; // Skip numbers with leading zeros
            long cur = Long.parseLong(num.substring(pos, i + 1));
            int len = path.length();
            
            if (pos == 0) {
                // First number, we cannot add any operator
                backtrack(result, path.append(cur), num, target, i + 1, cur, cur);
                path.setLength(len);
            } else {
                // Addition
                backtrack(result, path.append("+").append(cur), num, target, i + 1, eval + cur, cur);
                path.setLength(len);
                
                // Subtraction
                backtrack(result, path.append("-").append(cur), num, target, i + 1, eval - cur, -cur);
                path.setLength(len);
                
                // Multiplication
                backtrack(result, path.append("*").append(cur), num, target, i + 1, eval - multed + multed * cur, multed * cur);
                path.setLength(len);
            }
        }
    }

    

}