class Solution {
    LinkedList<List<Integer>> result = new LinkedList<>();
        
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrace(nums, track);
        return result;
    }

    public backtrace(int[] nums, List<Integer>track) {
        if (track.size() == nums.length) {
            result.add(track);
            return;
        }

        for (int num: nums) {
            if (track.contains(num))
                continue;
            track.add(num);
            backtrace(nums, track);
            track.removeLast();
        }
    }
}