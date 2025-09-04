class Solution {
    public int findClosest(int x, int y, int z) {
        x = Math.abs(z-x);
        y = Math.abs(y -z);
        if (x> y){
            return 2;
        }else if( x< y){
            return 1;
        }else{
            return 0;
        }
    }
}
