class Solution {
    public int singleNumber(int[] nums) {
        int Xor = 0;
        for(int i=0; i<nums.length; i++){
            Xor = Xor ^ nums[i]; // 2^2 = 0 ^ 1 => 1
        }
        return Xor;
    }
}