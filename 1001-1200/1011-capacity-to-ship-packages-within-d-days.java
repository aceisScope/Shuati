class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int left = getMax(weights), right = getSum(weights) + 1;
        
        while (left < right) {
            int mid = (right + left) / 2;
            if (canFinish(weights, mid, D)) {
                right = mid;
            } else {
                left = mid + 1;
             }
        }
        
        return left;
    }
    
    boolean canFinish(int[] weights, int cap, int D) {
        int i = 0;
        for (int day = 0; day < D; day++) {
            int max = cap;
            while ((max -= weights[i]) >= 0) {
                i++;
                if (i == weights.length) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    int getMax(int[] weights) {
        int max = 0;
        for (int n: weights) {
            max = Math.max(max, n);
        }

        return max;
    }
    
    int getSum(int[] weights) {
        int sum = 0;
        for (int n: weights) {
            sum += n;
        }

        return sum;
    }
}