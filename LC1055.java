// TC: O(M+N)
// SC: O(1)

public class LC1055 {
    public int shortestWay(String source, String target) {
        int m = source.length();
        int n = target.length();
        boolean tracker[] = new boolean[26];
        for(int i=0;i<m;i++){
            tracker[source.charAt(i)-'a'] = true;
        }
        for(int i=0;i<n;i++){
            if(!tracker[target.charAt(i)-'a']) return -1;
        }
        int i=0, j=0;
        int ans = 0;
        while(j<n){
            char ch1 = source.charAt(i%m);
            char ch2 = target.charAt(j);
            if(i%m==0) ans++;
            if(ch2==ch1) j++;
            i++;
        }
        return ans;
    }
}
