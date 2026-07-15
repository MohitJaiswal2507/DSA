class Solution {
    public int[] singleNumber(int[] nums) {
        int n = nums.length;
        int XOR = 0;
        
        //Finding the xor of every element in the array as Xor has 2 different properties:
        //1. a ^ a = 0
        //2. a ^ 0 = a
        for(int i=0; i < n; i++) {
            XOR = XOR ^ nums[i];
        }
        
        //finding the rightmost set bit of XOR elements    
        int rightsetbit = (int)(XOR & (XOR - 1)) ^ (int)XOR;
        
        int XOR1 = 0, XOR2 = 0;
        
        for(int i=0; i < n; i++) {
            if((nums[i] & rightsetbit) != 0) {
                XOR1 = XOR1 ^ nums[i];
            }
            else {
                XOR2 = XOR2 ^ nums[i];
            }
        }
        
        // Returning Sorted array ans 
        if(XOR1 < XOR2) return new int[]{XOR1, XOR2};
        return new int[]{XOR2, XOR1};
    }
}