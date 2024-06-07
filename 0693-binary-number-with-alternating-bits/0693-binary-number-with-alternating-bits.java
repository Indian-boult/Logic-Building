class Solution {
    public boolean hasAlternatingBits(int n) {
        //Solution 1 very fast
        // String test = Integer.toBinaryString(n);

        // for(int i = 1;i < test.length();i++)
        //     if(test.charAt(i) == test.charAt(i - 1))
        //         return false;
        
        // return true;

        int test = n ^ (n >> 1);
        return (test & (test + 1)) == 0;
    }
}