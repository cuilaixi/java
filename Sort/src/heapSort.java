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
		//������ʼ��	
//		for(int i=array.length;i>0;i--){
//			sift(array,array.length/2,array.length);//�ܲ����ɵ�ƣ�������û��i��forѭ��ɶ���������ɵ�������ܲ����Լ��ˡ�
//		}
		for(int i=array.length/2;i>=1;i--){//�ѺͶ��������Ǵ�1��ʼ��
			sift(array,i,array.length);//������ʼ���ѵ�ʱ�򣬵�Ȼhigh����length.
		}
		//ɸѡ�Ѷ��㲢��������
		for(int i=array.length;i>=2;i--){
//			int temp=array[array.length-1];//һ���Ĵ��󣬲���û��i����ɵ��
			int temp=array[1];
			array[1]=array[i];
			array[i]=temp;
//			sift(array,i/2,i);//����1��Ӧ����ǰi-1��Ԫ�أ�������ǰi��Ԫ�ء�����2���һ���û����Ǵ�i/2��ʼ���Ǵ�1��ʼ
			sift(array,1,i-1);
		}
	}
	public static void sift(int [] array,int low,int high){
		//����Ҫ����żǵã����������sift(int []a,int i,int n) �����ɵ�����ܱȱ����
		int i=low;
		int j=i*2;//�����ǰ�����д��while���棬����ô���ѭ����//��ɵ�ƣ����ҲҪд���ȼ���for(int j=2*i;j<high;j=2*i)
		while(j<=high){
//			int j=i*2;//��Ͳ����ظ������ˣ���Ҫ�ø�ֵ
//			j=i*2;
			if(array[j+1]>array[j]&&j+1<=high){//���Ǽ�j+1<=high��
				j++;
			}
			if(array[j]>array[i]){
////				int temp=array[i];
				array[i]=array[j];
////				array[j]=temp;
				i=j;//ԭ�����ӽ��丸��㣬����������·��������̽��
				j=i*2;//ԭ����д������
				}
			else break;
		}//while(j<high)��
//		array[i]=array[j];//������д�ģ�����������
		array[i]=array[low];//�����������Ļ�����Ϊ�����low��û�б䣬����ԭ����j�����ڵ�i���������ڵص�ֵ����while�жϸտ�ʼ��ʱ��ĸ���㣨ֱϵ����㶼����׼ȷ����
	}
}
