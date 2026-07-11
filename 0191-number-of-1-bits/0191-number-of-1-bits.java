class Solution {
    public int hammingWeight(int n) {
        int cnt = 0;

        // looping to find all the set bits and using & operator to eliminate that number till zero
        while( n != 0 ){
            n = n & (n-1);
            cnt++;
        }

        return cnt;
    }
}