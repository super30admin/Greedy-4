//Time Complexity : O(sLength * tLength)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Do not have access
//Any problem you faced while coding this : None
package com.s30.satish;

class Shortest_Way_to_Form_String_1055 {
	public int shortestWay(String source, String target)
	{
		int sLength = source.length();
		int tLength = target.length();
		int sPtr = 0;
		int tPtr = 0;
		int count = 0;
		while(tPtr < tLength)
		{
			count++;
			sPtr = 0;
			while(tPtr < tLength && sPtr < sLength)
			{
				if(source.charAt(sPtr) == target.charAt(tPtr))
				{	
					tPtr++;
					sPtr++;
				}
				else
					sPtr++;
			}
			if(tPtr == tLength-1)
				return -1;
		}
		return count;
	}
	public static void main(String[] args)
	{
		String source = "xyz";
		String target = "xzyxz";
		Shortest_Way_to_Form_String_1055 obj = new Shortest_Way_to_Form_String_1055();
		System.out.println(obj.shortestWay(source, target));
		source = "xyz";
		target = "xzyxza";
		System.out.println(obj.shortestWay(source, target));
	}
}
