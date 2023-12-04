//TC will be O(n)
//SC will be O(1)

class DominoRotations {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        if(tops == null || tops.length == 0){
            return -1;
        }
        int answer = finMinimumRotations(tops, bottoms, tops[0]);
        if(answer != -1){
            return answer;
        }
        return finMinimumRotations(tops, bottoms, bottoms[0]);
    }

    private int finMinimumRotations(int[] tops, int[] bottoms, int target){
        int topRotations = 0;
        int bottomRotations = 0;
        for(int i = 0; i < tops.length; i++){
            if(tops[i]!= target && bottoms[i] != target){
                return -1;
            }

            if(tops[i] != target){
                topRotations++;
            }
            if(bottoms[i] != target){
                bottomRotations++;
            }
        }
        return Math.min(topRotations, bottomRotations);
    }

    public static void main(String[] args){
        int[] tops = {2,1,2,4,2,2};
        int[] bottoms = {5,2,6,2,3,2};
        DominoRotations obj = new DominoRotations();
        System.out.println(obj.minDominoRotations(tops,bottoms));
    }
}
