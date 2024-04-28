class Solution {
    public int minAreaRect(int[][] points) {
        Set<String> pointSet = new HashSet<>();
        for (int[] point : points) {
            // Encode the point as a string "x:y" to store in the set for easy lookup
            String encodedPoint = point[0] + ":" + point[1];
            pointSet.add(encodedPoint);
        }

        int minArea = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                // Check if points[i] and points[j] form a diagonal of a rectangle
                if (points[i][0] != points[j][0] && points[i][1] != points[j][1]) {
                    // Check for the other two corners of the rectangle
                    if (pointSet.contains(points[i][0] + ":" + points[j][1]) &&
                        pointSet.contains(points[j][0] + ":" + points[i][1])) {
                        // Calculate area
                        int area = Math.abs(points[i][0] - points[j][0]) * Math.abs(points[i][1] - points[j][1]);
                        minArea = Math.min(minArea, area);
                    }
                }
            }
        }

        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }
}