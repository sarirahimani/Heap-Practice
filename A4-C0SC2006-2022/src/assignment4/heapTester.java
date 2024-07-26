package assignment4;

public class heapTester {
	public static void main(String[] args){
		//Create a heap that stores integers
		heap myHeap=new heap();
		//Check if it is empty. This prints: Is the ListHeap empty? true
		System.out.println("Is the ListHeap empty? "+myHeap.isEmpty());
		//add integers to heap
	/*	myHeap.add(1);
		myHeap.add(2);
		myHeap.add(3);
		myHeap.add(70);
		myHeap.add(22);
		myHeap.add(31);
		//Test the toString and print the ListHeap
		System.out.println(myHeap);
		//Remove the root, test the removeMax method
		myHeap.removeMax();
		//Print list after removal
		System.out.println(myHeap);
		//Check if it is empty. This prints: Is the ListHeap empty? false
		System.out.println("Is the ListHeap empty? "+myHeap.isEmpty());
		//add more integers to the list
		myHeap.add(13);
		myHeap.add(25);
		myHeap.add(30);
		myHeap.add(79);
		myHeap.add(45);
		myHeap.add(54);
		//Print the ListHeap
		System.out.println(myHeap);
		//Remove the root, test the removeMax method
		myHeap.removeMax();
		//Print list after removal
		System.out.println(myHeap);
		
		//Get value in certain positions 
		System.out.println("Number at position 1: "+myHeap.numAt(1));
		System.out.println("Number at position 5: "+myHeap.numAt(5));
		System.out.println("Number at position 3: "+myHeap.numAt(3));
		System.out.println("Number at position 6: "+myHeap.numAt(6));
		System.out.println("Number at position 8: "+myHeap.numAt(8));*/
		
		
		myHeap.add(8);
		myHeap.add(3);
		myHeap.add(91);
		myHeap.add(24);
		myHeap.add(78);
		myHeap.add(64);
		
		myHeap.add(95);
		myHeap.add(53);
		myHeap.add(38);
		System.out.println(myHeap);
	}
}
