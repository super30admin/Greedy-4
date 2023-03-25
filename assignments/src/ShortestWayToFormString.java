// Approach: Two pointers and Greedy
// Time: O(n)
// Space: O(1)

class ShortestWayToFormString {
    public int shortestWay(String source, String target) {
        int [] chars = new int[26];

        for(char c : source.toCharArray()){
            chars[c - 'a'] += 1;
        }
        int i=0, j=0;
        int count = 1;
        while(j < target.length()){
            if(source.charAt(i) == target.charAt(j)){
                i++;
                j++;
            } else {
                i++;
                if(chars[target.charAt(j) - 'a']  == 0){
                    return -1;
                }
            }
            //new sequence. start scaning source again
            if(j != target.length() && i == source.length()){
                i=0;
                count++;
            }
        }
        return count;
    }
}