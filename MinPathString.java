//Tc = O(mn)
//SC = O(1)
class Solution {
    public int shortestWay(String source, String target) {
        int count = 0;
        String remaining = target;
        while(remaining.length() > 0){
            StringBuilder subseq = new StringBuilder();
            int i = 0;
            int j = 0;
            while(i<source.length() && j<remaining.length()){
                if(source.charAt(i++) == remaining.charAt(j)){
                    subseq.append(remaining.charAt(j++));
                }
            }
            if(subseq.length() == 0){
                return -1;
            }
            count++;
            remaining = remaining.substring(subseq.length());
        }
        return count;
    }
}