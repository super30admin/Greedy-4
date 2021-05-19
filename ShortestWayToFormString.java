// "static void main" must be defined in a public class.
public class Main {
    public static int shortestWay(String source, String target){
        int s = source.length();
        int t = target.length();
        
        //declaring the source and target pointers
        int sp = 0;
        int tp = 0;
        
        int count = 0;
        
        //iterating until the target string is exhausted
        while(tp < t){
            sp = 0;//reset sp to starting index every time
            int prev = tp;
            while(tp < t && sp < s){//iterating through the souce string
                if(source.charAt(sp) == target.charAt(tp)){//if the character matches then we can increment target pointer
                    tp++;
                }
                sp++;//moving source pointer to next index
            }
            if(prev == tp){//the character is not found in source
                return -1;
            }
            count++;
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(shortestWay("abc", "abcbc"));
        System.out.println(shortestWay("abc", "acdbc"));
        System.out.println(shortestWay("xyz", "xzyxz"));
    }
}

// Time Complexity: O(st)
//Space Complexity: O(1)