package Recursion;

public class TowersOfHanoi {
	
	public static int nDisks=3;
    
	public static void main(String[] args){
		doTowers(nDisks,'A','B','C');
		
	}
	
	public static void doTowers(int nDisks,char from,char inter,char to){
		
		if(nDisks==1){
			System.out.println("Disk "+nDisks+" moves from "+from+" to "+to);
		}else{
		doTowers(nDisks-1,from,to,inter);
		
		System.out.println("Disk "+nDisks+" moves from "+from+" to "+to);
		
		doTowers(nDisks-1,inter,from,to);
		}
		
	}
} 
