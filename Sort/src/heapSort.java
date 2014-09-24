import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class heapSort {
	public static void main(String [] args) throws IOException{
		   int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,101,56,17,18,23,34,15,35,25,53,51};
		   heapSort(a);  
		   for(int i=0;i<a.length;i++){  
		       System.out.print(a[i]+" ");  
		   }  			
	}
	
	public static void heapSort(int [] array){
		//构建初始堆	
//		for(int i=array.length;i>0;i--){
//			sift(array,array.length/2,array.length);//曹操你个傻逼，参数都没有i，for循环啥玩意儿？个傻逼老子受不了自己了。
//		}
		for(int i=array.length/2;i>=1;i--){//堆和二叉树都是从1开始的
			sift(array,i,array.length);//构建初始化堆的时候，当然high得是length.
		}
		//筛选堆顶点并存入数组
		for(int i=array.length;i>=2;i--){
//			int temp=array[array.length-1];//一样的错误，参数没有i，个傻逼
			int temp=array[1];
			array[1]=array[i];
			array[i]=temp;
//			sift(array,i/2,i);//问题1：应该是前i-1个元素，而不是前i个元素。问题2：我还是没理解是从i/2开始还是从1开始
			sift(array,1,i-1);
		}
	}
	public static void sift(int [] array,int low,int high){
		//还是要翻书才记得，老子想的是sift(int []a,int i,int n) 我这个傻逼真能比编程吗？
		int i=low;
		int j=i*2;//个耳鼻把这行写在while后面，还怎么深层循环？//个傻逼，外边也要写，等价于for(int j=2*i;j<high;j=2*i)
		while(j<=high){
//			int j=i*2;//这就不能重复定义了，而要用赋值
//			j=i*2;
			if(array[j+1]>array[j]&&j+1<=high){//忘记加j+1<=high了
				j++;
			}
			if(array[j]>array[i]){
////				int temp=array[i];
				array[i]=array[j];
////				array[j]=temp;
				i=j;//原来的子结点变父结点，继续在这条路径上往下探索
				j=i*2;//原来该写在这里
				}
			else break;
		}//while(j<high)完
//		array[i]=array[j];//这是我写的，明显有问题
		array[i]=array[low];//如果发生调变的话，因为这里的low并没有变，就是原来的j，现在的i的索引所在地的值等于while判断刚开始的时候的父结点（直系父结点都还不准确）？
	}
}
