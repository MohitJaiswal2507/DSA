class Solution {
    private void helper(List<List<Integer>> ans, List<Integer> temp, int[] nums, boolean[] vis) {
        if(nums.length == temp.size()) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0;i<nums.length; i++) {
		
            if(vis[i]) continue; 
            if(i > 0 && ! vis[i-1] && nums[i] == nums[i-1]) continue; // if prev element and current element is equal, skip the element
            
            vis[i] = true;
            temp.add(nums[i]);
            
            helper(ans, temp, nums, vis); // recursive call
            
			// backtracking
            temp.remove(temp.size() - 1);
            vis[i] = false;
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>(); // ans list
        Arrays.sort(nums); // sort the array
		
		// create a boolean array which track the certain indexed integer is present in out temp list or not
        helper(ans, new ArrayList<>(), nums, new boolean[nums.length]); // helper method
		
        return ans; // return output
    }
}