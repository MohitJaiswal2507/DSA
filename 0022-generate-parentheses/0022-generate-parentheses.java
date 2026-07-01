class Solution {
    public static void backtrack(String s, int left, int right, List<String>ans, int n){
        //Base case => if n=2 then the string formed will always be twice its n 
        if(s.length() == n*2){
            ans.add(s);
            return;
        }

        if(left < n) backtrack(s+"(", left+1, right, ans, n);

        if(right < left) backtrack(s+")", left, right+1, ans, n);
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack("",0,0,ans,n);
        return ans;
    }
}