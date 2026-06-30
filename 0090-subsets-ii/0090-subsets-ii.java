class Solution {
    
    public static void findSubsets(int ind, int[] nums, List<Integer> ds, List<List<Integer>> ans){
        // Adding the ds which will be saved in the ans list
        ans.add(new ArrayList<>(ds));

        for(int i=ind; i<nums.length; i++){
            if(i != ind && nums[i] == nums[i-1]) continue;

            ds.add(nums[i]);
            findSubsets(i+1 , nums, ds, ans);

            //Removing the added value 
            ds.remove(ds.size() - 1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        findSubsets(0, nums, new ArrayList<>(), ans);

        return ans; 
    }
}