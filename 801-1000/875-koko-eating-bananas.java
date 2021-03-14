class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = getMax(piles) + 1;
        while(left < right) {
            int mid = (left +  right) / 2;
            if (canFinish(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    boolean canFinish(int[] piles, int speed, int h) {
        int time = 0;
        for (int n: piles) {
            time += timeOf(n, speed);
        }
        return time <= h;
    }

    int timeOf(int n, int speed) {
        return n / speed + (n % speed > 0 ? 1 : 0);
    }

    int getMax(int[] piles) {
        int max = 0;
        for (int n: piles) {
            max = Math.max(max, n);
        }
        return max;
    }
}