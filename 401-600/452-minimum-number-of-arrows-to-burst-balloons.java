class Solution {
    public int findMinArrowShots(int[][] points) { 
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> (Integer.compare(a[1], b[1])));
        
        int end = points[0][1];
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            int[] curr = points[i];
            if (Integer.compare(curr[0], end) > 0) {
                end = curr[1];
                count++;
            }
        }
        return count;
    }
}