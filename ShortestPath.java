import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Time Complexity: O(mlogk)
//Space Complexity:O(n)

// We build a map of all character positions in source to help us search faster.
// For each character in target, we binary search the next valid position in source.
// If we run out of source, we reset and count one subsequence used, repeating until target is formed.
public class ShortestPath {
    public int shortestWay(String source, String target)
    {
        HashMap<Character,List<Integer>> map = new HashMap<>();

        for(int i=0;i<source.length();i++)
        {
            char c = source.charAt(i);
            map.putIfAbsent(c,new ArrayList<>());
            map.get(c).add(i);
        }

        int i = 0, j = 0;
        int count = 0;

        while (j<target.length()) {
            char tchar = target.charAt(j);

            if(!map.containsKey(tchar)) return -1;
            List<Integer> list = map.get(tchar);
            int idx = binarysearch(list,i);
            if(idx == list.size())
            {
                i = list.get(0);
                count++;
            }
            else{
                
                i = list.get(idx);
                i++;j++;
                if(j==target.length()) return count+1;
            }

            if(i==source.length())
            {
                i=0;
                count++;
            }

        }
        return -1;
    }

    private int binarysearch(List<Integer> list, int target)
    {
        int low= 0, high = list.size()-1;
        while(low <= high)
        {
            int mid = low+(high-low)/2;
            if(list.get(mid) == target) return mid;
            else if(list.get(mid)>target) high = mid -1;
            else low = mid+1;

        }
        return low;
    }
}
