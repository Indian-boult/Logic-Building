class Solution {
    public int findLengthOfLCIS(int[] nums) {
        
        int max = 1;
        int ans=1;
        
        for(int i = 0 ; i < nums.length-1 ;i++)
        {
            if(nums[i]<nums[i+1])
            {
                max++;  
            }
            else
            {
                max =1;      
            }
               if(max > ans)
                {
                     ans = max;
                }      
        }
        
     return ans;
        
    }
}