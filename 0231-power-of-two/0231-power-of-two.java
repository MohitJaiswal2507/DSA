class Solution {
    public boolean isPowerOfTwo(int n) {
        //Edge case
        if(n <= 0) return false;

        //using bitwise concept
        if ((n & (n - 1)) == 0) return true;
        else return false; 
    }
}