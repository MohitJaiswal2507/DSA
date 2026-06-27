class Solution {

    public void generate(int index, int[] nums, List<Integer> ds, List<List<Integer>> ans) {

        // Base case
        if (index == nums.length) {
            ans.add(new ArrayList<>(ds)); // Store current subset
            return;
        }

        // Take
        ds.add(nums[index]);
        generate(index + 1, nums, ds, ans);

        // Not Take then backtrack
        ds.remove(ds.size() - 1);
        generate(index + 1, nums, ds, ans);
    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        generate(0, nums, ds, ans);

        return ans;
    }
}