class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        // using sorting => O(nlog N)
        if(nums.empty()) return 0;

        sort(nums.begin() , nums.end());

        int i=0, curr = nums[0], streak = 0;
        int result = 0;

        while(i < nums.size()){
            if(curr != nums[i]){
                curr = nums[i];
                streak = 0;
            }

            //duplicate skip 
            while(i < nums.size() && nums[i]==curr){
                i++;
            }

            streak++;
            curr++;
            result = max(result, streak);
        }
        return result;
    }
};