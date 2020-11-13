//TC: O(n*m)
//SC: O(1)
//Facing issue with solution 2 of TLE with 19 testcases passing on leetcode
public class ShortestWayFormString {
    //Solution: 1
    public int shortestWay(String source, String target) {
        int s = 0;
        int t = 0;
        
        int result = 0;
        
        while (t < target.length()) {
            s = 0;
            // keeping track of the target pointer
            int prev = t;
            
            while (t < target.length() && s < source.length()) {
                // if current char is equal to the target increment target
                if (source.charAt(s) == target.charAt(t)) {
                    t += 1;
                }
                s += 1;
            }
            // if the target is not change the prev would be equal to target directly return -1
            if (prev == t) {
                return -1;
            }
            
            result += 1;
        }
        
        return result;
    }
    // Solution :2
    // public int shortestWay(String source, String target) {
    //     int lastIndex = 0;
    //     int count = 0;
    //     // Getting the count of occurence of source in target
    //     while(lastIndex != -1){
    //         lastIndex = target.indexOf(source,lastIndex);
    //         if(lastIndex != -1){
    //             count ++;
    //             lastIndex += source.length();
    //         }
    //     }
    //     // replacing all occurence of source with empty string
    //     target = target.replaceAll(source, "");
    //     // finding all possible subsequence of source
    //     findsubsequences(source, "");
    //     source = "";
    //     // checking the splitting points
    //     for(int i= 0; i<target.length(); i++){
    //         source += target.charAt(i);
    //         // if the current char is not in the set than directly return -1
    //         if(!al.contains(""+target.charAt(i))){
    //             return -1;
    //         }
    //         // checking if my set does not contain the substring which means we need to split
    //         else if(!al.contains(source)){
    //             count++;
    //             source = ""+target.charAt(i);
    //         }
    //     }
    //     // this is to take care for the last split
    //     if(source.length() > 0)
    //         count++;
    //     return count;
    // }
    // HashSet<String> al = new HashSet<>();
    // private void findsubsequences(String s, String ans)
    // {
    //     if (s.length() == 0) {
    //         al.add(ans);
    //         return;
    //     }
    //     findsubsequences(s.substring(1), ans + s.charAt(0));
    //     findsubsequences(s.substring(1), ans);
    // }
}
