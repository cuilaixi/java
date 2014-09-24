import java.util.*;
import java.io.*;
//binarySearch -- O(lgn)
public class binarySearch {
	public static  void main(String [] args){
//	 草华为你马哥比，二分查找的前提是有序表啊！！！！！！！！！！我日啊啊啊啊啊啊啊啊啊啊
//	彻底弄清楚了  n/2最后的赋值是 <=(n/2)
		 int a[]={38,48,65,76,97};
		 System.out.println(BinarySearch(a,0,a.length-1,97)+" "+Arrays.toString(a)); 
	}
	public static  int BinarySearch(int [] array,int start,int end, int target){
	    int low=start,high=end;
		while(high>=low){
			int mid=(high+low)/2;
			if(target==array[mid]){
				return mid;
			}
			else if(target<array[mid]){
				high=mid-1;
			}
			else if(target>array[mid]){
				low=mid+1;
			}
		}
		return -1;
	}
}
