public class domino {
        public int minDominoRotations(int[] tops, int[] bottoms) {
            if(tops.length != bottoms.length)
            {
                return -1;
            }
            int target=findRotations(tops, bottoms,tops[0]);
            if(target!=-1)
                return target;
            return findRotations(tops, bottoms,bottoms[0]);
        }
        private int findRotations(int[]tops, int[] bottoms, int target)
        {
            int trotate=0;
            int brotate=0;
            for(int i=0; i<tops.length; i++)
            {
                if(tops[i]!=target && bottoms[i]!=target)
                {
                    return -1;
                }
                if(bottoms[i]!=target)
                {
                    brotate++;
                }
                if(tops[i]!=target)
                {
                    trotate++;
                }
            }
            int ans= Math.min(trotate,brotate);
            return ans;
        }
    }
