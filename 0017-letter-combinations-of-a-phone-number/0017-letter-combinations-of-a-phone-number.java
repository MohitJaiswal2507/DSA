class Solution {

    private static final String[] map = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public static void combinationCall(String digits,List<String> ans,int index,String current) {
        // Base case
        if (index == digits.length()) {
            ans.add(current);
            return;
        }

        int ch = digits.charAt(index) - '0';
        String s = map[ch];

        for (int i = 0; i < s.length(); i++) {
            combinationCall(digits, ans, index + 1, current + s.charAt(i));
        }
    }

    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();
        // Edge case
        if (digits.length() == 0)
            return ans;

        combinationCall(digits, ans, 0, "");

        return ans;
    }
}