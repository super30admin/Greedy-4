class Solution {
    public int shortestWay(String source, String target) {
        int p1=0;
        int p2=0;
        char v1[]=source.toCharArray();
        char v2[]=target.toCharArray();
        while(p2<v2.length){
            int searchLen=0;
            while(v1[p1%v1.length]!=v2[p2] && searchLen<v1.length){
                searchLen++;
                p1++;
            }
            if(searchLen==v1.length){
                return -1;
            }
            p2++;
            p1++;
        }
        return (p1+v1.length-1)/v1.length;
    }
}