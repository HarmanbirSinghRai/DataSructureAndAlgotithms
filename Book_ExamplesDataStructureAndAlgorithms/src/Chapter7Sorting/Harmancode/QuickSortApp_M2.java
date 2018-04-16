package Chapter7Sorting.Harmancode;

public class QuickSortApp_M2 {
	
	public static void main(String[] args){
		
		int count=20;
		ArrayQS2 arr=new ArrayQS2(count);
		for(int i=0;i<count;i++){
			int a=(int)(Math.random()*999);
			arr.insert(a);
		}
		
		arr.display();
		arr.recQuickSort(0, count-1);
		arr.display();
	}

}

class ArrayQS2{
	int[] arrsh;
	int nElemns;
	
	public ArrayQS2(int size){
		arrsh=new int[size];
		nElemns=0;
	}
	
	public void insert(int a){
		arrsh[nElemns++]=a;
	}
	
	public void display(){
		for(int i=0;i<nElemns;i++){
			System.out.print(arrsh[i]+" ");
		}
		System.out.println("");
	}
	
	public void recQuickSort(int left,int right){
		
		int size=right-left +1;
		if(size<=3){
		//	manualSort(left,right,size);
		insertionSort(left,right);
		}else{
			int pivot=median3(left,right);
			int partition=partitionIt(left,right,pivot);
			recQuickSort(left,partition-1);
			recQuickSort(partition+1,right);
			
		}
	}
	
	public void manualSort(int left, int right,int size){
		if(size==1){
			return;
		}else if(size==2){
			if(arrsh[left]>arrsh[right]){
				swap(left,right);
			}
		}else{
			if(arrsh[left]>arrsh[right-1]){
				swap(left,right-1);
			}
			if(arrsh[left]>arrsh[right]){
				swap(left,right);
			}
			if(arrsh[right-1]>arrsh[right]){
				swap(right-1,right);
			}
		}
		
	}
	
	public int median3(int left,int right){
		int center=(left+right)/2;
		
	      if(arrsh[left]>arrsh[center]){
	    	  swap(left,center);
	      }
	      if(arrsh[left]>arrsh[right]){
	    	  swap(left,right);
	      }if(arrsh[center]>arrsh[right]){
	    	  swap(center,right);
	      }
	      swap(center,right-1);
	      return arrsh[right-1];
	}
	
	public void swap(int a,int b){
	 int temp=arrsh[a];
	 arrsh[a]=arrsh[b];
	 arrsh[b]=temp;
	}
	
	public int partitionIt(int left,int right,int pivot){
		int leftptr=left;
		int rightptr=right-1;
		while(true){
			while(arrsh[++leftptr]<pivot);
			
			while(arrsh[--rightptr]>pivot);
			
			if(leftptr>=rightptr){
				break;
			}else{
			swap(leftptr,rightptr);	
			}
		}
		swap(leftptr,right-1);
		return leftptr;
	}
	
	public void insertionSort(int left,int right){
		int in,out;
		
		for(out=left+1;out<=right;out++){
			int temp=arrsh[out];
			in=out;
			while(in>left && arrsh[in-1]>temp){
				arrsh[in]=arrsh[in-1];
				--in;
			}
			arrsh[in]=temp;
		}
	}
}

