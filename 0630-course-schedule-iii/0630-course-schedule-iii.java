class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int currentTime = 0;  
        for (int[] course : courses) {
            int duration = course[0];
            int lastDay = course[1];
            if (currentTime + duration <= lastDay) {
                maxHeap.offer(duration);
                currentTime += duration;
            } else if (!maxHeap.isEmpty() && maxHeap.peek() > duration) {
                // If we can't take this course, check if we can replace a longer course
                // This helps to free up some time and potentially take more courses
                currentTime += duration - maxHeap.poll();
                maxHeap.offer(duration);
            }
        }
        return maxHeap.size();
    }
}