class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        // Step 1: Count the frequency of each integer
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Sort the integers by their frequency
        List<Integer> frequencies = new ArrayList<>(frequencyMap.values());
        Collections.sort(frequencies);

        // Step 3: Remove elements with the smallest frequency first
        int uniqueCount = frequencies.size();
        for (int freq : frequencies) {
            if (k >= freq) {
                k -= freq;
                uniqueCount--;
            } else {
                break;
            }
        }

        // Step 4: Return the number of remaining unique integers
        return uniqueCount;
    }
}