//timecomplexity:- O(t string length).
//spacecomplexity:- O(1).

import java.util.*;

public class Main {
    public static void main(String[] args) {
        solution sb=new solution();
        System.out.println(sb.shortestway("abc","axcbc"));
    }

    public  static class solution{
        public int shortestway(String S, String T){
            int count=0;
            int scount=0;
            int tcount=0;
            while(tcount<T.length()){
                scount=0;
                int prev=tcount;
                while(scount<S.length()&& tcount<T.length()){
                    if(S.charAt(scount)==T.charAt(tcount)){// tpointer increases only when there is a match in two sentences.
                        tcount++;
                    }
                    scount++;
                }
                if(prev==tcount){
                    return -1;// stopping conditions if any character is not same to break infinity loop.
                }
                count++;// for every match iteration count will be incremented.
            }
            return count;
        }
    }
}