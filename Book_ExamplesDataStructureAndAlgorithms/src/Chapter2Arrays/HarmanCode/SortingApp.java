package Chapter2Arrays.HarmanCode;

public class SortingApp {
	int[] el;
	int nElems;
	int maxsize;
	
	SortingApp(int size){
		el=new int[size];
		nElems=0;
		maxsize=size;
	}
	
	public int size(){
		return nElems;
	}
	
	public void insert(int value){
		
		if(nElems>=maxsize-1){
			System.out.println("Array is full");
		}else{
		el[nElems++]=value;
		}
	}
	
	public void display(){
		for(int i=0;i<nElems;i++){
			System.out.print(el[i]+" ");	
		}
		System.out.println(" ");	
	}
	
	public void bubbleSort(){
		for(int i=nElems-1;i>1;i--){
			for(int j=0;j<i;j++){
				if (el[j]>el[j+1]){
					swap(j,j+1);
				}
			}
		}
		
	}
	
	public void swap(int one, int two){
		int temp =el[one];
		el[one]=el[two];
		el[two]=temp;
	}
	
 public void selectionSort(){
	 /** int min;
	 for(int i=0;i<nElems-1;i++){
		 min=i;
		 for(int j=i+1;j<nElems;j++){
			 if(el[j]<el[min]) {
				 min=j;
			 }
		 }
		 swap(i,min);
	 }**/
	 int max;
	 for(int i=nElems-1;i>0;i--){
		 max=0;
		 for(int j=1;j<=i;j++){
			 if(el[j]>el[max]) {
				 max=j;
			 }
		 }
		 swap(i,max);
	 }
 }
 
 public void insertionSort(){
	 
	 int i,j;
	 for( i=1;i<nElems;i++){
		 int temp=el[i];
		  j=i;
		  while(j>0 && el[j-1]>temp){
			el[j]=el[j-1];
				 --j; 
			 }
		    el[j]=temp;
		  }
	 }

	
	public static void main(String[] args){
		SortingApp ba=new SortingApp(10);
		ba.insert(21);
		ba.insert(11);
		ba.insert(2);
		ba.insert(97);
		ba.insert(45);
		ba.insert(54);
		ba.insert(38);
		ba.insert(101);
		ba.insert(100);
		ba.insert(76);
		ba.insert(23);
		
		ba.display();
		
		//ba.bubbleSort();
		//ba.selectionSort();
		ba.insertionSort();
		ba.display();
		
	}

}
