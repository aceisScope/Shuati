class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // 按宽度升序排列，如果宽度一样，则按高度降序排列
        Arrays.sort(envelopes, new Comparator<int[]> () {
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
            }
        });

        int[] height = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            height[i] = envelopes[i][1];
        }
        return lengthOfLIS(height);
    }

    public int lengthOfLIS(int[] nums) {
        int[] top = new int[nums.length];

        int piles = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = 0, right = piles;
            int poker = nums[i];

            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            if (left == piles) piles++;
            top[left] = poker;
        }

        return piles;
    }
}