class Solution {
    public int shortestWay(String source, String target) {
        
        HashSet<Character> hs= new HashSet<>();
        
        for( int i=0;i<source.length();i++){
            
            hs.add(source.charAt(i));
            
        }
        int count=0;
        
        int ps=0;
        int pt=0;
        
        while(pt!=target.length()){
         //   System.out.println(source.charAt(ps));
            if(!hs.contains(target.charAt(pt))){
                return -1;
                
            }
            
            
            if(target.charAt(pt)==source.charAt(ps)){
            
                pt++;
                ps++;
                
                
            }else{
                ps++;
            }
            
            
            
            if(ps>=source.length()&&pt<=target.length()-1){ps=0;count++;}
           else if  (ps>=source.length()){ps=0;}
        }
        
        
        
     return count+1;   
    }
}
