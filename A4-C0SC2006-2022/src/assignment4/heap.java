package assignment4;
import java.util.*;
/**
* This class is a Heap that is implemented 
* using an ArrayList. This class has one field
* aheap: which is an ArrayList that stores Integers. 
* @author Sahara Karima Mosin Rahimani
*
*/
public class heap{
	
	ArrayList<Integer> aheap;
	/**
	 * Unargumented constructor.
	 * This is an O(1) method
	 */
	public heap() {
	//Initialize the ArrayList aheap
	 aheap=new ArrayList<>();//1 operation
	}
	/**
	* This method pushes a value upwards to reestablish the heap property
	* Total number of operations if(numAt(par)<=numAt(pos)): 3+n+2+O(1)+6=O(n)
	* Total number of operations else: 3+n+2+2=O(n)
	* This is an O(n) method
	* 
	*/	
	public void heapifyUp() {
		//position that will be heapified upwards
		 int pos=aheap.size()-1;//3 operations
		 
		 while(pos!=0) {//n operations
			 //the parent of pos
			 int par=(pos-1)/2;//2 operations
			 //check if the rank at parent is less or equal to the rank at p
			 if(numAt(par)<=numAt(pos)) {//numAt() is an O(1) method and 4 operations
				 //swap by doing the following:
				 //if it is store the value in the parent index in a temporal variable
				 int temp=aheap.get(par);//2 operations
				 //set the value in the index pos in the par index
				 aheap.set(par, aheap.get(pos));//2 operations
				 //set the temp in the pos index
				 aheap.set(pos, temp);//1 operation
				 //make pos equal to the parent index
				 pos=par;	 //1 operation
			 }else {//1 operation
				 break;//1 operation
			 }
			 
		 }
	 }

	/**
	 * This method pushes a value downward to reestablish the heap property
	 * Total number of max operations: 1+2+n+3+3+2+1+4+1+4+2+2+2=O(n)
	 * This method is an O(n) method
	 */
	 public void heapifyDown() {
		 //position that will be heapified downward
		 int pos=0;//1 operation
		 //size of ArrayList
		 int size=aheap.size();//2 operations
		 while(2*pos+1<size) {//n operations
			 //position of the left child
			 int leftChild = 2*pos+1;//3 operations
			 //position of the right child
			 int rightChild = leftChild + 1;//3 operations
			 //position of the max child/the child with the highest value
			 int maxChild = leftChild; //2 operations
			 //check if there is a right child if there is
			 if (rightChild < size) {//1 operation
				 // Check if the value of the right child is greater than the value of the left child 
				if(numAt(rightChild) > numAt(leftChild)) {//numAt() is an O(1) method and this has 4 operations
					//change the maxChild to the position of the right child
					maxChild = rightChild;//1 operation
				 }
			 }
			//check if the value at pos is less or equal to the value at maxChild
			 if (numAt(pos) <= numAt(maxChild)) {// numAt() is an O(1) method there are 4 operations
				 //create a temporal variable and make it equal to the value at pos
				 int temp = aheap.get(pos);//2 operations
				 //set the value at maxChild in the index pos
				 aheap.set(pos, aheap.get(maxChild));//2 operations
				 //set temp at the maxChild index
				 aheap.set(maxChild, temp);//1 operation
			 }else {//1 operation
				 break;//1 operation
			 }
			 pos = maxChild;//1 operation
			  }
		 }
	 
	 /**
	  * This method adds ints in the next available position in
	  * the aheap and heapifies upward to restore the heap property.
	  * @param value is the value that will be added to the aheap
	  * @return true after the ticket is added to the aheap
	  * Big O notation: 1+1+O(n)=2+O(n)=O(n)
	  * This is an O(n) method
	  */
	 public boolean add(int value) {
		 //add the value to the ArrayList
		  aheap.add(value);//1 operation
		  //Heapify up
		  heapifyUp();//this is a O(n) method
		  //return true after adding and heapifying up
		  return true;//1 operation
	 }
	 /**
	  * Removes the root from the aheap
	  * and replaces it with the last leaf. The new root is then 
	  * heapified downward. 
	  * @return the value of the removed root
	  * big O notation if empty: O(1)+1+1+O(1)=O(1)
	  * Big O notation if filled: 1+2+3+2+3+O(n)+1=O(n)
	  * this is an O(n) method
	  * 
	  */
	 public int removeMax() {
		 //check if the ArrayList is empty 
		 if (isEmpty()) {//this is an O(1) method and 1 operation
			 //string with message that will be shown if heap is empty
			 String msg = "Heap is empty.";//1 operation
			 //exception that will be thrown if empty
			 throw new RuntimeException(msg);//This is an O(1) operation
		 }else{//if it is not empty, 1 operation
			  //get the value of root and store in value
			  int value = aheap.get(0);//2 operations
			  //Store the position of the last leaf in last
			  int last = aheap.size()-1;//3 operations
			  //Replace the root by last the leaf
			  aheap.set(0, aheap.get(last));//2 operations
			 
			  // Remove the last leaf
			  aheap.remove(aheap.size()-1);//3 operations
			  //heapify down
			  heapifyDown();//this method is an O(n) method
			  //return the value of removed root
			  return value;//1 operation
		}
	 }
	 /**
	  * Checks if the ArrayList is empty, 
	  * it does this by checking if the size of the 
	  * ArrayList is 0. 
	  * @return it returns a boolean if it is empty 
	  * it returns true, if it is not empty it returns false.
	  * This is an O(1) method
	  */
	public boolean isEmpty() {
		//checks if the size is equal to 0
		return aheap.size() == 0;//2 operations
	}
	/**
	 * This method gets the value in a specific 
	 * index of the ArrayList
	 * @param position is the position in which the value is 
	 * @return value in the position that was entered
	 * This is an O(1) method
	 */
	public int numAt(int index) {
		//return the value in that position
		return aheap.get(index); //2 operations
	}
	/**
	 * toString for easy printing
	 * @return a string with all the values in aheap
	 * if the aheap is empty it shows a message that states "Empty Heap!"
	 * Big O notation if empty: 1+O(1)+1+12+n=O(1)+12+n=O(n)
	 * Big O notation if not empty: 1+1+1+n+4+n=6+2n=O(n)
	 * This method is an O(n) method
	 */
	public String toString() {
		//create a StringBuilder
		StringBuilder out= new StringBuilder();//1 operation
		//if empty it will append Empty Heap
		if(isEmpty()) {//is is an O(1) Method and 1 operation
			out.append("Empty Heap!"+"\n");//12 characters added/appended
		}else {//one operation
			//for loop that will loop from 0 up to size()-1 of the arraylist to get all values in heap
			for(int i=0;i<aheap.size(); i++) {//n operations
				//append all values and their indexes
				out.append(aheap.get(i)+"-"+i+" ");//4 characters appended/added
			}
		}
		//convert out into a string and return
		return out.toString();//one operation and the method call toString() is n operations
	
	}
}
