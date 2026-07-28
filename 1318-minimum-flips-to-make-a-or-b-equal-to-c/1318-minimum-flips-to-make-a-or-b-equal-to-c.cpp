class Solution {
public:
    int minFlips(int a, int b, int c) {
        int flips =0;
        while(a != 0 || b != 0 || c!=0){
            //Right most bit of c=1
            if((c&1) == 1){
                if((a&1) == 0 && (b&1) == 0) flips++;
            }
            //check right most bit of c=0
            else{
                if((a&1) == 1 ) flips++;
                if((b&1) == 1 ) flips++;
            }

            //Rihgt shift every number 
            a>>=1;
            b>>=1;
            c>>=1;
        }

        return flips;
    }
};