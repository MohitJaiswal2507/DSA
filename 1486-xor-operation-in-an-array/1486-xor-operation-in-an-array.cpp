class Solution {
public:
    int xorTillN(int n) {
        if (n % 4 == 0)
            return n;
        else if (n % 4 == 1)
            return 1;
        else if (n % 4 == 2)
            return n + 1;
        else
            return 0;
    }
    int xorOperation(int n, int start) {
        int s = start >> 1;

        int x = xorTillN(s + n - 1) ^ xorTillN(s - 1);

        int lastBit = (start & 1) & (n & 1);

        return (x << 1) | lastBit;   
    }
};