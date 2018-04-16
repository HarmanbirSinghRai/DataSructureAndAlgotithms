package Chapter5Lists;

public class FirstLastApp {
	public static void main(String[] args){
		FirstLastlist fll=new FirstLastlist();
		fll.insertFirst(50);
		fll.insertFirst(40);
		fll.insertFirst(30);
		fll.insertFirst(20);
		fll.insertFirst(10);
		fll.insertLast(60);
		fll.insertLast(70);
		fll.insertLast(80);
		fll.insertLast(90);
		fll.insertLast(100);
		fll.displayList();
		fll.deleteFirst();
		fll.displayList();
		fll.reverse();
		fll.displayList();
		fll.insertLast(5);
		fll.displayList();
		fll.reverse();
		fll.displayList();
	}

}
