class Solution {
    int mod = 1_000_000_007;
    public int numDecodings(String s) {
        // p is next result, i.e. dp[i+1]
        // np is next next result, i.e. dp[i+2]
        int p = 1, np = 1;
        boolean[] cur = new boolean[10];
        boolean[] next = new boolean[10];
        for(int i=s.length() - 1; i>=0; i--) {
            Arrays.fill(cur, false);
            Arrays.fill(next, false);
            int result = 0;
            char c = s.charAt(i);
            if(c != '*') cur[c-'0'] = true;
            else {
                for(int k=1; k<=9; k++) cur[k] = true;
            }
            if(i < s.length() - 1) {
                char nextChar = s.charAt(i+1);
                if(nextChar != '*') next[nextChar-'0'] = true;
                else {
                    for(int k=1; k<=9; k++) next[k] = true;
                }
            }
            for(int idx = 1; idx < 10; idx++) {
                if(!cur[idx]) continue;
                result = (result + p) % mod;
                for(int j=0; j<10; j++) {
                    if(!next[j]) continue;
                    if(idx == 1 || (idx == 2 && j < 7)) {
                        result = (result + np) % mod;
                    }
                }
            }
            np = p;
            p = result;
        }
        return p;
    }
}