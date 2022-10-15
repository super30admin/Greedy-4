//Approach - 1: 2. Pointers, HashSet
//Time Complexity : O(m*n)
//Space Complexity : O(1)

class Solution {
    public int shortestWay(String source, String target) {
        //we have to form subseq of target from source
        int sourceLen = source.length();
        int targetLen = target.length();
        
        HashSet<Character> set = new HashSet<>();
        for(int i=0; i<sourceLen; i++){
            set.add(source.charAt(i));
        }
        
        int targetPointer = 0;
        int sourcePointer = 0;
        int count = 1;
        while(targetPointer < targetLen){
            char sChar = source.charAt(sourcePointer);
            char tChar = target.charAt(targetPointer);
            
            if(!set.contains(tChar)) return -1;
            
            if(sChar == tChar){
                targetPointer++;
                sourcePointer++;
                if(targetPointer == targetLen) return count;
            }
            else{
                sourcePointer++;
            }
            
            if(sourcePointer == sourceLen){
                //reset the count, after froming a subsequence
                sourcePointer = 0;
                count++;
            }
        }
        return count;
    }
}



//Approach - 2: 2 Pointers, HahsMap, BinarySearch
//Time Complexity : O(nlog(k))
//Space Complexity : O(1)

class Solution {
    public int shortestWay(String source, String target) {
        //we have to form subseq of target from source
        int sourceLen = source.length();
        int targetLen = target.length();
        
        HashMap<Character, List<Integer>> map = new HashMap<>();
        //Add all the chars in Source to HashMap
        for(int i=0; i<sourceLen; i++){
            char c = source.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, new ArrayList<>());
            }
            map.get(c).add(i);
        }
        
        int targetPointer = 0;
        int sourcePointer = 0;
        int count = 1;
        
        while(targetPointer < targetLen){
            char tChar = target.charAt(targetPointer);
            if(!map.containsKey(tChar)) return -1;
            
            List<Integer> li = map.get(tChar); 
            
            int k = Collections.binarySearch(li, sourcePointer);
            
            if(k<0){
                //if the element is not in the list
                //sourcePointer = 13
                //[0,1,3,4,17,19] => Collection gives k = -5 ==> i.e, -4-1
                //k = -k-1 ; -(-5)-1 = 4
                // At 4th index 13 can be inserted
                
                //sourcePointer = 19
                //[0,1,3,4,17,19] => k = 5
                //Gives exact postive index of it. 
                
                k = -k-1;
                
            }
            if(k == li.size()){
                count++;
                sourcePointer = li.get(0);    
            }
            else{
                //if the element is in the list
                sourcePointer = li.get(k);
            } 
            sourcePointer++;
            targetPointer++;
        }
        return count;
    }
}
