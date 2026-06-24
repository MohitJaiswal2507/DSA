class Solution {
    public int fib(int n) {
        // 2nd approach
        if(n <= 1) return n;
        return fib(n-1) + fib(n-2);
    }
}
