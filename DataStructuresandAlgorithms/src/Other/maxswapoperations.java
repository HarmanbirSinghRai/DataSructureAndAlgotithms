
public class maxswapoperations {
	static int[] arr;
	public static void main(String[] args){
		String s ="129814999";
		 arr=s.chars().map(c -> c-='0').toArray();
		
		//arr=new int[]{1,2,4,3};
		int swaps=4;
		findmx(arr,swaps);
		for(int i:arr){
			System.out.print(i);
		}
	}

	public static void findmx(int[] arr,int swaps){
		int[] mxarr=arr;
	    int arrlgth=arr.length;
	//	for(int s=0;s<swaps;s++)
		//{ 
			for(int i=0;i<swaps;i++){
				int maxpos=i;
			for(int j=i+1;j<arrlgth;j++){
				if(arr[j]>arr[maxpos]){
					maxpos=j;
				}
			}
			swap(i,maxpos);
			//break;
		}
		//}
		//return mxarr;
	}
	public static void swap(int i,int j){
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}
