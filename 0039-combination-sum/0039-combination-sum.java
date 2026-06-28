class Solution {
    //ans ds =>  to store the final ds(data structure) combinations
    public void findCombinationSum(int index, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds){
        //Base cases
        if(index == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        //Pick recursion call
        if(arr[index] <= target){
            ds.add(arr[index]);
            findCombinationSum(index, arr, target - arr[index], ans, ds);

            //during backtracking delete the arr[index]
            ds.remove(ds.size() - 1);
        }
        //Not pick call
        findCombinationSum(index+1, arr, target, ans, ds);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinationSum(0, candidates, target, ans , new ArrayList<>() );
        return ans;
    }
}