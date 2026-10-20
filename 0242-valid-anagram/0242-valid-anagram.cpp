class Solution {
public:
    bool isAnagram(string s, string t) {
    //Edge case 
    if(s.size() != t.size()) return false;

    //size is 26 cause 26 letters in alphabet
    int freq[26];

    // string s ke freq store karke freq mai add karenge
    for(char c : s){
        freq[c - 'a']++;
    }

    // string t ke freq ko minus karenge string s ke freq se
    for(char c : t){
        freq[c - 'a']--;
    }
    
    for(int count : freq){
        if(count != 0) return false;
    }
    
    return true;
    }
};