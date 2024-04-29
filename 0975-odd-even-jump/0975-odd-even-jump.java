class Solution {
    public int oddEvenJumps(int[] arr) {
        int n = arr.length;
        if (n == 1) return 1;

        boolean[] odd = new boolean[n];
        boolean[] even = new boolean[n];
        odd[n-1] = even[n-1] = true;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(arr[n-1], n-1);

        for (int i = n - 2; i >= 0; i--) {
            Integer oddNext = map.ceilingKey(arr[i]);
            Integer evenNext = map.floorKey(arr[i]);

            if (oddNext != null) {
                odd[i] = even[map.get(oddNext)];
            }
            if (evenNext != null) {
                even[i] = odd[map.get(evenNext)];
            }

            map.put(arr[i], i);
        }

        int goodStarts = 0;
        for (boolean b : odd) {
            if (b) goodStarts++;
        }

        return goodStarts;
    }
}