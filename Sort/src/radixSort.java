import java.io.*;
import java.util.*;

public class radixSort {
	public static void main(String [] args) throws IOException{
		Scanner scanner=new Scanner(System.in);		
//		char a[]=new char[s.length()];
//		s.getChars(0,s.length(),a,0);
//		ArrayList arraylist=new ArrayList();
//		for(int i=0;i<s.length();i++){
//			int arr=Integer.parseInt(s);//parseInt()只能string，而不能char，草尼玛
//			System.out.println(arr);
//			arraylist.add(arr);
//		}
//		System.out.println(arraylist.toArray());
		
		ArrayList<Integer> list=new ArrayList<Integer>();
//		while(true){ 			
//			if(scanner.hasNext()){
//				list.add(scanner.nextInt());
//				System.out.println(list.get(0));//只能读出get(0),后面的一概不认
//			}
//			else{
//				break;
//			}
//		}
		while(scanner.hasNextInt()){//无论是hasNext()还是hasNextInt()按enter了都没结束，hasNextInt按非int可以结束
//		String s=scanner.next();
//		int n=Integer.parseInt(s);
		int n=scanner.nextInt();
//		System.out.println(n);
		list.add(n);
//		System.out.println(list.size());

		}
		//先确认一遍输入的数字
		for(int i=0;i<list.size();i++){
			System.out.print(list.get(i)+" ");
		}	
		System.out.println();
		//过了两天才正式开始 radixSort--找出最大数字
		int max=list.get(0);
		for(int i=1;i<list.size();i++){			
			if(max<list.get(i)){
				max=list.get(i);
			}
		}
		//判断最大数字的位数,也就是确定排序的趟数
		int d=1;
		while(max>10){
			max=max/10;
			d++;
		}
//		System.out.print(d);
		int r=10;
		//初始化0~r的r个数组
		List<ArrayList> queue=new ArrayList<ArrayList>();//这个是为了说明arrayList里面也是arraylist而不是object？
//		ArrayList是List的子类，List有两个重要的实现类：ArrayList 和 LinkedList
		for(int i=0;i<r;i++){
			ArrayList<Integer>queue1=new ArrayList<Integer>();//因为要构造二维数组，先构造个q1，它在分配时期会被q2覆盖的
			queue.add(queue1);
		}
		//进行d次分配和收集
		for(int i=0;i<d;i++){
			//分配时期
			for(int j=0;j<list.size();j++){//先从0开始判断，尾数是不是0，是不是1，是不是2。。。是不是r？把待排序的数每个分别投入queue.get(i)
				int x=list.get(j)%(int)Math.pow(10, j+1)/(int)Math.pow(10,j);
				//Math.pow(x,y)这个函数是求x的y次方,x,y的值都是浮点类型的,所以必须在前面加(int)
//				ArrayList<Integer>queue2=(ArrayList<Integer>)queue.get(x);//cannot convert from Object to ArrayList<Integer>				
				ArrayList<Integer>queue2=queue.get(x);//有了List<ArrayList> queue=new ArrayList<ArrayList>();这个定义就不需要了(ArrayList<Integer>)
				queue2.add((int)list.get(j));
				queue.set(x,queue2);
			}//分配完
			//收集时期
			int count=0;//元素计数器
			for(int k=0;k<r;k++){
				System.out.print(queue.get(k).size()+" ");
				while(queue.get(k).size()>0){
					ArrayList<Integer>queue3=queue.get(k);
//					list.set(k,queue3.get(0));//这里我理解错了，并不是是在k插入，而是从0顺序插入，收集.
					list.set(count,queue3.get(0));
					queue3.remove(0);
					count++;
				};
				
			}//收集完
		}//分配收集完
		//输出排序结果
		System.out.println();
		for(int i=0;i<list.size();i++){
			System.out.print(list.get(i)+" ");
		}	
	}
	
	
}
