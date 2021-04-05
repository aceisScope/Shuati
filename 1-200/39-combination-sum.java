class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        dfs(res, tmp, candidates, 0, 0, target);

        return res;
    }

    void dfs(List<List<Integer>> res, List<Integer> tmp, int[] candidates, int start, int sum, int target) {
        if (sum > target) return;
        if (sum == target) {
            res.add(tmp);
            return;
        }

        for (int i = start; i < candidates.length(); i++) {
            int candidate = candidates[i];
            if (candidate > target) return;

            sum += candidate;
            if (sum > target) return;

            tmp.add(candidate);
            dfs(res, tmp, candidates, i, sum, target);

            sum -= candidate;
            tmp.remove(tmp.size() - 1);
        }
    }
}