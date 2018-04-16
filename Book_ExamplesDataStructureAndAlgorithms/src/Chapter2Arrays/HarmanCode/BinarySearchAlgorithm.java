package Chapter2Arrays.HarmanCode;

public class BinarySearchAlgorithm {
       int[] a;
      int nelemns;
    		   
    BinarySearchAlgorithm(int size){
    	a=new int[size];
    	nelemns=0;
       }
    
    public void delete(int value){
    	int val=find(value);
    	if(val==-1){
    		System.out.println("No Such value");
    	}else{
    		for(int k=val;k<nelemns-1;k++){
    			a[k]=a[k+1];
    		}
    	}
    	nelemns--;
    }
	public int find(int value){
		int upbound=nelemns-1;
		int lobound=0;
		int curr=0;
		while(true){
			curr=(lobound+upbound)/2;
			if(a[curr]==value)
				return curr;
			if(lobound>upbound){
				return -1;
			}else{
				if(value<a[curr])
					upbound=curr-1;
				if(value>a[curr]){
					lobound=curr+1;
				}
			}
			
		}
		
		
		
	}
	public void insert(int value){
		int j;
		int k;
		if(find(value)==-1){
			if(a.length==nelemns){
				System.out.println("Array is full ");
			}else{
		             for( j=0;j<nelemns;j++){
			       if(a[j]>value)
			                  	break;
		                }
		     for( k=nelemns;k>j;k--){
			          a[k]=a[k-1];
		            }
		         a[j]=value;
		          nelemns++;
			}
		}else{
			System.out.println("Duplicate key "+ value);	
		}
	}
	
	public void display(){
		for(int i=0;i<nelemns;i++){
			System.out.print(a[i]+" ");	
		}
		System.out.println(" ");	
	}
	
	public static void main(String[] args){
		BinarySearchAlgorithm ba=new BinarySearchAlgorithm(10);
		ba.insert(21);
		ba.insert(11);
		ba.insert(2);
		ba.insert(97);
		ba.insert(45);
		ba.insert(54);
		ba.insert(38);
		ba.insert(101);
		ba.insert(101);
		ba.insert(76);
		ba.insert(23);
		
		ba.display();
		
		ba.delete(54);
		ba.delete(23);
		ba.display();
		ba.insert(55);
		ba.insert(55);
		ba.display();
		
		
	}
}
