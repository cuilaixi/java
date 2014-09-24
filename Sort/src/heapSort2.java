import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class heapSort2 {
	public static void main(String [] args) throws IOException{
		   int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,101,56,17,18,23,34,15,35,25,53,51};
		   heapSort2(a);  
		   for(int i=0;i<a.length;i++){  
		       System.out.print(a[i]+" ");  
		   }  			
	}
	
	public static void heapSort2(int [] array){
		//构建初始堆	

		for(int i=array.length/2;i>=1;i--){//堆和二叉树都是从1开始的
			sift(array,i,array.length-1);//构建初始化堆的时候，当然high得是length.
		}
		//筛选堆顶点并存入数组
//		for(int i=array.length;i>=2;i--){//这个n应该是lastindex，而不是length。
		for(int i=array.length-1;i>=2;i--){
			int temp=array[1];
			array[1]=array[i];
			array[i]=temp;
			sift(array,1,i-1);
		}
	}
	public static void sift(int [] array,int low,int high){//high是最后一个节点lastIndex，而sift要从最后一个结点的父结点开始
		//首先要理解 low 是  开始调整的那个父结点。
		int i=low;
		int j=i*2;//这部分说明了low必须至少为1,
		int tmp=array[i];
		while(j<high){//如果j<high，才能存在j+1,即才能存在右子结点
			if(j+1<=high&&array[j+1]>array[j]){
				j++;
			}
			if(array[j]<tmp){
				
				array[i]=array[j];
				i=j;
				j=i*2;
				}
			else break;
		}
		array[i]=tmp;//被筛选结点的值放入最终位置
	}
}
