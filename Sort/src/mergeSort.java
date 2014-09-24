import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
public class mergeSort {
		public static void main(String [] args){
			 int a[]={25,38};
			 MergeSort(a);  
			 System.out.println(Arrays.toString(a)); 
		}
		
		public static void MergeSort(int array[]){
			//两路归并 自底向上
			int length;
//			mergePass(array,1,);
			for(length=1;length<array.length;length=2*length){
				mergePass(array,length,array.length);
			}
		}
		
		public static void mergePass(int array[],int childlength,int length){
			int i;
			for(i=0;i+2*childlength-1<length;i=i+2*childlength){
				merge(array,i,i+childlength-1,i+2*childlength-1);
			}
			if(i+childlength-1<length){//恰好最后的时候还剩两个子表，而i+2*childlength-1会大于等于length
				merge(array,i,i+childlength-1,length-1);
			}
		}
		
		public static void merge(int []array,int start,int seperate,int end){
			//array1[]在array[0~seperate],array2[]在array[seperate+1~end-1]
			int s=start;
			int ss=seperate+1;
			int arraysort[]=new int[end-start+1];
			int sss=0;
			while(s<=seperate&&ss<=end){
				if(array[s]>=array[ss]){
					arraysort[sss]=array[s];
					s++;
					sss++;
				}
				else{
					arraysort[sss]=array[ss];
					ss++;
					sss++;
				}
			}
			
			while(s<=seperate){
				arraysort[sss]=array[s];
				s++;
				sss++;
			}
			while(ss<=end){
				arraysort[sss]=array[ss];
				ss++;
				sss++;
			}
			//将中间数组中的内容复制回原数组 
//			for(int i=0;i<=end;i++){
			for(int i=start;i<=end;i++){
				array[i]=arraysort[i-start];
			}
		}//merge   end
}
