import java.io.*;
import java.util.Scanner;
import java.util.Collections;
public class heapSort3 {
	public static void main(String [] args) throws IOException{
		   int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,101,56,17,18,23,34,15,35,25,53,51};
		   HeapSort3(a);  
		   for(int i=0;i<a.length;i++){  
		       System.out.print(a[i]+" ");  
		   }  			
	}
	
	public static void HeapSort3(int [] array){
		//构建初始堆	
		for(int i=(array.length)/2;i>=0;i--){
			sift(array,i,array.length-1);
		}
		//筛选堆顶点并存入数组
		for(int i=array.length-1;i>=1;i--){
			exchangeElements(array,0,i);
			sift(array,0,i-1);
		}
	}
	public static void sift(int [] array,int ParentIndex,int lastIndex){
		/*
		 * 假设某个元素为序号为i(Java数组从0开始,i为0到n-1), 如果它有左子树，那么左子树的位置是2i+1，
		 * 如果有右子树，右子树的位置是2i+2，如果有父节点，父节点的位置是(n-1)/2取整。
		 */	
		int largest=ParentIndex;
		int left=ParentIndex*2+1;
		int right=ParentIndex*2+2;
		
		if(left<=lastIndex&&array[left]>array[ParentIndex]){
				largest=left;
			}
		if(right<=lastIndex&&array[right]>array[largest]){//最后一个检查出来的错误是array[ParentIndex]			
				largest=right;
			}
		if(ParentIndex!=largest){
			exchangeElements(array,largest,ParentIndex);
			//下面的递归我忘记了。。。。
			sift(array,largest,lastIndex);//沿着子节点查过去
		}
	}
	
	public static void exchangeElements(int[] array, int index1, int index2) {  
        int temp = array[index1];  
        array[index1] = array[index2];  
        array[index2] = temp;  
    }  
}
