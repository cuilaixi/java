import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class QuickSort3 {
	public static void main(String [] args) throws IOException{
//	   int a[]={49,38};//出错 //加了两个if在递归处，现在不出错了。
		int a[]={49,38};
	   quickSort(a,0,a.length-1);  
	   for(int i=0;i<a.length;i++){  
	       System.out.print(a[i]+" ");  
	   }  			
	}
	public static void quickSort(int[] array,int low,int high){
		int l=low;
		int h=high;
		int temp=array[low];	
		if(low<high){
			while(l!=h){
//				while(l<h&&array[h]>temp)//这样就会错，难道是因为等于的时候h停止--，交换到a[l]去了，然后l
				while(l<h&&array[h]>=temp)
					h--;
					array[l]=array[h];	
				while(l<h&&array[l]<=temp)
					l++;
					array[h]=array[l];
			}//while(l!=h)完
			array[l]=temp;	
			if(l-1>=0){
				quickSort(array,low,l-1);
			}
			if(l+1<=high){
				quickSort(array,l+1,high);		
			}
		}//if(low<high)完
	}//quickSort完
}

