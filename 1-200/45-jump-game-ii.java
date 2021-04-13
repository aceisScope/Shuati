class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0, farthest = 0, jumps = 0;
        
        for (int i = 0; i < n - 1; i++) { // 注意此处i < n - 1 
            farthest = Math.max(nums[i] + i, farthest);
            if (end == i) { // 到了end，就需要跳跃一次
                jumps++;
                end = farthest;
            }
        }
        
        return jumps;
    }
}


// i 和 end 标记了可以选择的跳跃步数，farthest 标记了所有选择 [i..end] 中能够跳到的最远距离，jumps 记录了跳跃次数。