class Solution {

    public void findSubsets(int ind, int[] nums, List<Integer> ds, List<List<Integer>> ans) {

        // Base case
        if (ind == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        // Pick
        ds.add(nums[ind]);
        findSubsets(ind + 1, nums, ds, ans);

        // Backtrack
        ds.remove(ds.size() - 1);

        // Not Pick
        findSubsets(ind + 1, nums, ds, ans);
    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        findSubsets(0, nums, new ArrayList<>(), ans);

        return ans;
    }
}