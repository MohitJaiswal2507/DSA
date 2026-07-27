class Solution {
public:
    int singleNumber(vector<int>& nums) {
        //Using Hashmap Mehthod 

        unordered_map<int , int> map;
        for(int i=0; i<nums.size(); i++){
            map[nums[i]]++;
        }

        // Iterating through the map
        for(auto it: map){
            if(it.second == 1){
                return it.first;
            }
        }
        return -1;
    }
};