class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
     
        int x=helper(tops, bottoms, tops[0]);
        int y=helper(tops, bottoms, bottoms[0]);
      //  System.out.println(x+" "+y);
        if(x==-1&&y==-1){
            
            return -1;
        }else if(x==-1||y==-1){
            
            return Math.max(x,y);
        }else{
            
            return Math.min(x,y);
        }
         
        
    }


public int helper( int []tops, int bottoms[], int target){
     
    
     int first=0;
     int second=0;
     

   // System.out.println(first+" "+second + target);
    for( int i=0;i<tops.length;i++){
        
        if(tops[i]!=target&&bottoms[i]==target){
            
            first++;
            
        }else if(bottoms[i]!=target&&tops[i]==target){
            
            second++;
        }else if(bottoms[i]!=target&&tops[i]!=target){
            
           //System.out.println(first+" "+second + " * "+target+" "+i); 
            return -1;
        }
        
    }
    // System.out.println(first+" "+second + target);
    
   
    return Math.min(first, second);
    
}

}
