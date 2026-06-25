class Solution {
    private double power(double x, long n) {
        // Base case
        if (n == 0) return 1.0;
        if (n == 1) return x;
        
        if (n % 2 == 0) {
            // Recursion call
            return power(x * x, n / 2);
        }

        return x * power(x, n - 1);
    }
    public double myPow(double x, int n) {
        long powerValue = n;

        if (powerValue < 0) {
            return 1.0 / power(x, -powerValue);
        }
        
        return power(x, powerValue);
    }
}