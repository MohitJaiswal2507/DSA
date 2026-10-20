class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int , int> index;

        for(int i=0 ; i<=nums.size(); i++){
            // need = target - nums[i]
            int need = target - nums[i];

            if(index.count(need)) {
                return {index[need],i};
            }
            index[nums[i]] = i;
        }
        return {};
    }
};