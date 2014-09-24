import java.io.*;
import java.util.*;

public class QuickSort {
	public static void main(String [] args) throws IOException{
	   int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,101,56,17,18,23,34,15,35,25,53,51};
	   quickSort(a,0,a.length-1);  
	    for(int i=0;i<a.length;i++){  
	       System.out.print(a[i]+" ");  
	    }  			
	}
	public static void quickSort(int []array,int low,int high){
		int l=low;
		int h=high;//原来还需要多两个变量l和h,我根本就没写，个煞笔逻辑怎么敲代码
//		int temp=array[0];//这个我大错特错啊
		int temp=array[low];	
		if(low<high){//如果array元素个数是0或1，则返回
			while(l!=h){
				//从左向右扫描
	//			while(array[h]<temp){
	//				array[l]=array[h];
	//				h--;//而我这么写成了如果小于temp，就交换且下一个，如果不小于，那么就不管去从右向左扫描去了。悲哀。
	//			}
	//			//从右向左扫描
	//			while(array[l]>temp){
	//				array[h]=array[l];
	//				l++;//假如这个时候刚才h才--到使h=l了，
	//			}
				while(l<h&&array[h]>temp){
					h--;
				}//当发现一个小于temp的左半区元素时，跳出while循环，h也停在这个特定的h上。
		
					array[l]=array[h];
	
				while(l<h&&array[l]<temp){
					l++;
				}
					array[h]=array[l];
	
			}//跳出while(l<h)循环的此时low=high了已经
			array[l]=temp;//这个差点忘记了赋值，还是理解不够。
	
	//		quickSort(array,0,l-1);//前半部分递归，感觉好像不对啊，到底是不是array.length？草 
	//		quickSort(array,low+1,array.length);//后半部分递归，感觉好像不对啊，到底是不是array.length？草 
			quickSort(array,low,l-1);
			quickSort(array,l+1,high);
		}//if(low<high)完
	}//quickSort完
}
