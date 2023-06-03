import java.util.*;
public class StringFormCount {
    public int shortestWay(String source, String target) {
        int sl = source.length();
        int tl = target.length();
        int count = 1;
        int sp = 0;
        int tp = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<sl;i++){
            char c = source.charAt(i);
            set.add(c);
        }
        while(tp<tl){
            char sc = source.charAt(sp);
            char tc = target.charAt(tp);
            if(!set.contains(tc))return -1;
            if(sc==tc){
                sp++;
                tp++;
                if(tp==tl)return count;
            }
            else{
                sp++;
            }
            if(sp==sl){
                count+=1;
                sp=0;
            }
        }
        return count;
    }
}
