package Recursion;

public class MergeSortApp {
	private int[] theArray;
	private int nElemns;
	public static void main(String[] args){
		MergeSortApp msp=new MergeSortApp(10);
		msp.insert(10);
		msp.insert(33);
		msp.insert(13);
		msp.insert(58);
		msp.insert(98);
		msp.insert(3);
		msp.insert(25);
		msp.insert(15);
		msp.insert(101);
		msp.insert(66);
		
		msp.display();
		msp.doMergeSort();
		msp.display();
		
	}
	
	public MergeSortApp(int max){
		theArray= new int[max];
		nElemns=0;
	}
	
	public void insert(int a){
		theArray[nElemns++]=a;
	}
	
	public void display(){
		for(int i=0;i<nElemns;i++){
		System.out.print(theArray[i]+" ");
		}
		System.out.println(" ");
	}
	
	public void doMergeSort(){
		int[] workspace=new int[nElemns];
		recMergeSort(workspace,0,nElemns-1);
	}

	public void recMergeSort(int[] workspace,int lowerbound,int upperbound){
		
		if(lowerbound==upperbound)
			return;
		else{
			int mid=(lowerbound+upperbound)/2;
			
			recMergeSort(workspace,lowerbound,mid);
			
			recMergeSort(workspace,mid+1,upperbound);
			
			merge(workspace,lowerbound,mid+1,upperbound);
		}
	}
	
	public void merge(int[] workspace,int lowPtr,int highptr,int upperbound){
		
		int j=0;
		int lowebound=lowPtr;
		int mid=highptr-1;
		//int count=upperbound-lowebound+1;
		
		
		while(lowPtr<=mid && highptr<=upperbound ){
			if(theArray[lowPtr]<theArray[highptr]){
				workspace[j++]=theArray[lowPtr++];
			}else{
				workspace[j++]=theArray[highptr++];
			}
		}
		
		while(lowPtr<=mid){
			workspace[j++]=theArray[lowPtr++];
		}
		
		while(highptr<=upperbound){
			workspace[j++]=theArray[highptr++];
		}
		
		for(int i=0;i<j;i++){
			theArray[lowebound+i]=workspace[i];
		}
		
	}
}


