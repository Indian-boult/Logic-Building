class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
      if (nums == null || nums.length == 0) {
            return 0;
        }
        long[] prefixSums = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }
        return countRangeSumRecursive(prefixSums, 0, prefixSums.length, lower, upper);
    }
    private int countRangeSumRecursive(long[] prefixSums, int start, int end, int lower, int upper) {
        if (end - start <= 1) {
            return 0;
        }
        int mid = (start + end) / 2;
        int count = countRangeSumRecursive(prefixSums, start, mid, lower, upper) 
                  + countRangeSumRecursive(prefixSums, mid, end, lower, upper);
        int j = mid, k = mid, t = mid;
        long[] cache = new long[end - start];
        int cacheIndex = 0;
        for (int i = start; i < mid; i++) {
            while (k < end && prefixSums[k] - prefixSums[i] < lower) k++;
            while (j < end && prefixSums[j] - prefixSums[i] <= upper) j++;
            while (t < end && prefixSums[t] < prefixSums[i]) cache[cacheIndex++] = prefixSums[t++];
            cache[cacheIndex++] = prefixSums[i];
            count += j - k;
        }
        System.arraycopy(cache, 0, prefixSums, start, t - start);
        return count;
    }
}