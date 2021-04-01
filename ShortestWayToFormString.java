/*
method1 - using 2 pointers
TC:O(n^2)

method2 - greedy technique of reverse indexing
TC: O(m) + O(n)
*/

class Solution {
//     public int shortestWay(String source, String target) {
        
//         int ptr1 = 0;
//         int ptr2 = 0;
//         int count = 0;
//         while(ptr2 < target.length()){
            
//             count+= 1;
//             ptr1 = 0;
//             int curr = ptr2;
            
//             while(ptr1 < source.length() && ptr2 < target.length()){
//                 if(source.charAt(ptr1) == target.charAt(ptr2)){
//                     ptr1++;
//                     ptr2++;
//                 }
                
//                 else if(source.charAt(ptr1) != target.charAt(ptr2)){
//                     ptr1++;
//                 }
//             }
//             if(curr == ptr2){
//                 return -1;
//             }
//         }
//         return count; 
//     }
    
    public int shortestWay(String source, String target){
        
        
        //build a hasmap of source
        HashMap<Integer, HashMap<Character,Integer>> map = new HashMap<>();
        
        
        
        //adding last char to map first 
        int n = source.length();
        HashMap<Character, Integer> curr = new HashMap<>();
        curr.put(source.charAt(n-1), n-1);
        map.put(n-1,curr);
            
            
        
        for(int i = source.length()-2; i >= 0 ;i--){
            char ch = source.charAt(i);
            
            //get the the previous  Map at previous character
            HashMap<Character,Integer> previous = map.get(i+1);
            
            //if the map contains the curr char then just updte the index
            if(map.containsKey(ch)){
                HashMap<Character, Integer> temp = map.get(ch);
                temp.put(ch, i);
                map.put(i,temp);
            }
            else{
                //else add the previous map itself to curr by just adding curr char to it
                HashMap<Character,Integer>newmap = new HashMap<>(previous);
                newmap.put(ch, i);
                map.put(i, newmap);
            }
        }
        
        //after building the map, traverse the target string
        
        int index = 0;
        int result = 1;
        for(char ch : target.toCharArray()){
            
        
            //check if the map at char 0 contains all characters. if not, return -1;
            if(!map.get(0).containsKey(ch)){
                return -1;
            }
            
            //char srcCh = source.charAt(index);
            
            if(index == source.length() || !map.get(index).containsKey(ch)){
                result += 1;
                index = 0;
            }
            
            index = map.get(index).get(ch) +1;
        }
        return result;
    }
}