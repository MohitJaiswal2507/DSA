class Solution {
public:
    vector<int> countBits(int n) {
        vector<int> ans(n+1);
        ans[0] = 0;

        if(n == 0) return ans; //Edge case

        for(int i=1 ; i<=n; i++){
            //Odd number hai then last bit is always 1
            if(i % 2 == 1){
                ans[i] = ans[i/2] + 1;
            }else{ // if even number
                ans[i] = ans[i/2];
            }
        }
        return ans;
    }
};