class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int distance = 0;
        for (int i = 0; i < n; i++) {
            distance = Math.max(distance, i + nums[i]);
            if (distance <= i) return false; // 可能碰到了 0，无法前进
        }
        
        return distance >= n - 1;
    }
}

// 计算一下从当前位置最远能够跳到哪里，然后和一个全局最优的最远位置 farthest 做对比，通过每一步的最优解，更新全局最优解