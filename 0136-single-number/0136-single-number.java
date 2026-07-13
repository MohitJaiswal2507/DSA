class Solution {
    public int singleNumber(int[] nums) {
        //Edge case
        if(nums.length == 0) return 0;

        int Xor = 0;
        for(int i=0; i<nums.length; i++){
            Xor = Xor ^ nums[i]; // 2^2 = 0 ^ 1 => 1
        }
        return Xor;
    }
}