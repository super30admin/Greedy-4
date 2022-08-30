//time O(mn)
//space O(1)

class Solution {
    public int shortestWay(String source, String target) {
        int count =1;
        int i=0, j=0;
        boolean flag= false;
        while(true)
        {  
            if(source.charAt(i)!=target.charAt(j))
            {
                i++;
            }
            else if(source.charAt(i)==target.charAt(j))
            {
                i++; j++;
                flag=true;
                
            }
            
            if(j>=target.length())
                break;
             if(i>=source.length())
                  {
                    if(flag==false)
                        return -1;
                    else
                     {
                       flag=false;
                       count++;
                        i=0;
                     }
                   }
         
        } 
        return count;
       
    }