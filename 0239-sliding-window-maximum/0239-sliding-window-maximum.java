class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        if(k == 1)
            return nums;

        int n = nums.length;
        int[] arr = new int[n - k + 1];
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        //process 1st k elements
        for(int i = 0; i < k; i++){

            int num = nums[i];

            //for every element previous smaller element is useless,
            //So remove them.
            while(!dq.isEmpty() && num >= nums[dq.peekLast()])
                dq.removeLast();

            dq.addLast(i);    

        }

        //process elements from arr[k] to arr[n-1]
        int j = 0;
        for(int i = k; i < n; i++){

            arr[j] = nums[dq.peek()];
            j += 1;

            int num = nums[i];

            //remove those elements which are out of sliding window
            while( !dq.isEmpty() && dq.peek() <= i - k)
                dq.removeFirst();

            //Remove all the smaller elements then the currently added element 
            while(!dq.isEmpty() && nums[dq.peekLast()] <= num)
                dq.removeLast();

            dq.addLast(i);    

        }

        arr[j] = nums[dq.peek()];

        return arr;
    }
}