class MedianFinder {

    private PriorityQueue<Integer> small; // Max-Heap
    private PriorityQueue<Integer> large; // Min-Heap

    /** initialize your data structure here. */
    public MedianFinder() {
        // Using a max-heap for the smaller half by inverting the order of the elements
        small = new PriorityQueue<>(Collections.reverseOrder());
        // Default is a min-heap for the larger half
        large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (small.isEmpty() || num <= small.peek()) {
            small.offer(num);
        } else {
            large.offer(num);
        }
        
        // Balance the heaps: either both have the same size or max-heap has one more element than min-heap
        if (small.size() > large.size() + 1) {
            large.offer(small.poll());
        } else if (large.size() > small.size()) {
            small.offer(large.poll());
        }
    }
    
    public double findMedian() {
        if (small.size() > large.size()) {
            return small.peek();
        } else if (small.size() < large.size()) {
            return large.peek();
        } else {
            return (small.peek() + large.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */