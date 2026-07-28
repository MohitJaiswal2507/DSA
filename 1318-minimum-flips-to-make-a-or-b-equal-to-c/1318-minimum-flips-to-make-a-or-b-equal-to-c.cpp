class Solution {
public:
    int minFlips(int a, int b, int c) {
        //Optimal Approach
        int result = ((a|b) ^ c); // No of set bits to flip which we can count 
        //if both a and b bits are 1 then
        int temp = (a&b);

        int result2 = (temp & result);
        return __builtin_popcount(result) +  __builtin_popcount(result2); // returning the count of number of set bits 

        //Directly we could have written 
        // return __builtin_popcount(((a|b) ^ c)) +  __builtin_popcount((a&b) & ((a|b) ^ c))
    }
};