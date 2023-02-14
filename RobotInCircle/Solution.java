// Time complexity:O(n)
// Space complexity:O(n)
class Solution {
    int UP=0;
        int LEFT=1;
        int DOWN=2;
        int RIGHT=3;
        final int ORIGINAL_DIRECTION=UP;
    public boolean isRobotBounded(String instructions) {
        int x=0,y=0;
        int curDir=ORIGINAL_DIRECTION;
        for(int i=0;i<instructions.length();i++){
            char pos = instructions.charAt(i);
            
            // G
            if(pos == 'G'){
                if(curDir==UP){
                    y++;
                } else if(curDir==DOWN){
                    y--;
                } else if(curDir==LEFT){
                    x--;
                } else {
                    x++;
                }
            }

            // L
            if(pos == 'L'){
                curDir++;
                if(curDir > RIGHT) curDir=UP;
            }

            // R
            if(pos == 'R') {
                curDir--;
                if(curDir < UP) curDir=RIGHT;
            }
        }

        // final checks
        boolean isNotOriginalPos = x != 0 || y != 0;
        if(!isNotOriginalPos) return true;
        if(curDir != ORIGINAL_DIRECTION) return true;

        return false;
    }
}
