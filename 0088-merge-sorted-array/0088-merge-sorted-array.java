class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }

            return;
        }

        if (n == 0) {
            return;
        }

        mergeArray(nums1, m, nums2, n);
    }

    public void mergeArray(int[] num1, int m, int[] num2, int n) {
        int size = num1.length - 1;
        n--;
        m--;

        while (n >= 0 && m >= 0) {
            if (num1[m] >= num2[n]) {
                num1[size--] = num1[m--];
            } else {
                num1[size--] = num2[n--];
            }
        }

        while (m >= 0) {
            num1[size--] = num1[m--];
        }

        while (n >= 0) {
            num1[size--] = num2[n--];
        }
    }
}