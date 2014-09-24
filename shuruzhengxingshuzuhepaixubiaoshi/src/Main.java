import java.util.*;
//	输入整型数组和排序标.  --曾经格式错误因为有要求最后一个输出没空格，没看到。
public class Main {
	public static void main(String [] args){
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();		
		int[] pIntegerArray=new int[n];
		for(int i=0;i<n;i++){
			pIntegerArray[i]=scanner.nextInt();
		}	
		for(int i=0;i<n;i++){
			for(int j=n-1-i;j>=1;j--){
				if(pIntegerArray[j]<pIntegerArray[j-1]){
					int temp=pIntegerArray[j-1];
					pIntegerArray[j-1]=pIntegerArray[j];
					pIntegerArray[j]=temp;
				}
			}
		}
		int iSortFlag=scanner.nextInt();

		if(iSortFlag==0){
			for(int i=0;i<=n-1;i++){
				if(i<=n-1-1){
					System.out.print(pIntegerArray[i]+" ");
				}else{
					System.out.print(pIntegerArray[i]);
				}
				
			}
		}else{
			for(int i=n-1;i>=0;i--){
				if(i>=1){
					System.out.print(pIntegerArray[i]+" ");
				}else{
					System.out.print(pIntegerArray[i]);
				}
			}
		}
	}
}
