class Solution {
public:
    vector<int> sortByBits(vector<int>& arr) {
        // lambda function
        auto lambda = [&] (int &a, int &b){
            int count_a = __builtin_popcount(a);
            int count_b = __builtin_popcount(b);

            // in case of two or more integers have the same number of 1's 
            //sorting them in ascending order
            if(count_a == count_b) return a < b;

            return count_a < count_b;

        };

        //Sort function with an added lambda comparator
        sort(begin(arr), end(arr), lambda);

        return arr;
    }
};