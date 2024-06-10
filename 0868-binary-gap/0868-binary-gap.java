class Solution {
    public int binaryGap(int n) {
        String binaryString=Integer.toBinaryString(n);
        int idx=0, max=-1;
        for(int i=0;i<binaryString.length();i++){
            char c=binaryString.charAt(i);
            if(c=='1'){
                int curmax=i-idx;
                max=Math.max(curmax,max);
                idx=i;
            }
            
        }
        return max;
    }
}