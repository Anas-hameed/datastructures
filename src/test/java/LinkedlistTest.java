import static org.junit.Assert.*;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import LinkedList.LinkedList.LinkedList;

public class LinkedlistTest {

	private final ByteArrayOutputStream Output = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;	
	private LinkedList list; 
	//	For Checking the console output
	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(Output));
	}
	@After 
	public void restoreStreams() {
		System.setOut(originalOut);
	}

	@Before 
	public void Intializelist() {
		list= new LinkedList();
	}
	@After
	public void Intialize() {
		list= null;
	}

	public void clearBuffer() {
		Output.reset();
	}
	//	Testing inserting at front.
	@Test
	public void pushFrontTest() {
		// case 1-> Pushing 1 at start to empty list
		// case 2-> Pushing 2 at start to that  list
		// case 3-> pushing 3,4,5 at start then asserted

		//assert 1
		LinkedList.pushFront(1);
		clearBuffer();
		LinkedList.display();
		String Expected1= "LinkedList : 1 \r\n";
		assertEquals(Expected1, Output.toString());

		//assert 2
		LinkedList.pushFront(2);
		clearBuffer();
		LinkedList.display();
		String Expected2= "LinkedList : 2 1 \r\n";
		assertEquals(Expected2, Output.toString());

		//Assert 3
		LinkedList.pushFront(3);
		LinkedList.pushFront(4);
		LinkedList.pushFront(5);
		clearBuffer();
		LinkedList.display();
		String Expected3= "LinkedList : 5 4 3 2 1 \r\n";
		assertEquals(Expected3, Output.toString());
	}

	@Test 
	public void pushBackTest(){
		//	Pushing 1 at end to empty list
		// 	Pushing 2 at end to that  list
		// pushing 3,4,5 at end then asserted

		//assert 1
		LinkedList.pushBack(1);
		clearBuffer();
		LinkedList.display();
		String Expected1= "LinkedList : 1 \r\n";
		assertEquals(Expected1, Output.toString());

		//assert 2
		LinkedList.pushBack(2);
		clearBuffer();
		LinkedList.display();
		String Expected2= "LinkedList : 1 2 \r\n";
		assertEquals(Expected2, Output.toString());

		//Assert 3
		LinkedList.pushBack(3);
		LinkedList.pushBack(4);
		LinkedList.pushBack(5);
		clearBuffer();
		LinkedList.display();
		String Expected3= "LinkedList : 1 2 3 4 5 \r\n";
		assertEquals(Expected3, Output.toString());		
	}

	//	Initializing an list 	
	private void intializeListWithRange(int start, int end) {
		LinkedList.display();
		for(int i=start; i<=end ; i++ ) {
			LinkedList.pushBack(i);
		}
	}


	//  case 1-> popFront in empty Linked list
	//	case 2-> Initialize Array(0 1 2 3 4 5 6 7 8 9) and popFront.
	@Test
	public void popFrontTest() {
		// Case 1
		LinkedList.popFront();
		clearBuffer();
		LinkedList.display();
		String Expected1= "LinkedList :  \r\n";
		assertEquals(Expected1, Output.toString());

		// Case 2
		intializeListWithRange(0,9);
		LinkedList.popFront();
		clearBuffer();
		LinkedList.display();
		String Expected3= "LinkedList : 1 2 3 4 5 6 7 8 9 \r\n";
		assertEquals(Expected3, Output.toString());	

	}

	//  case 1-> popBack in empty 
	//  case 2-> popBack in 1 element list.
	//	case 3-> Initialize list(0 1 2 3 4 5 6 7 8 9) and popFront.

	@Test
	public void popBackTest() {
		// Case 1
		LinkedList.popBack();
		clearBuffer();
		String Expected1= "";    					// Empty list not printing anything
		assertEquals(Expected1, Output.toString());


		// Case 2
		LinkedList.pushBack(0);
		LinkedList.popBack();
		clearBuffer();
		String Expected2= "";  						// Empty list not printing anything
		assertEquals(Expected2, Output.toString());


		//case 3
		intializeListWithRange(0,9);		
		LinkedList.popBack();
		clearBuffer();
		LinkedList.display();
		String Expected3= "LinkedList : 0 1 2 3 4 5 6 7 8 \r\n";
		assertEquals(Expected3, Output.toString());

	}

	//	Check pop at a given position 
	// case 1: pop one element from the start  of an  empty linked list
	// case 2: pop one element from the start  of the linked list
	// case 3: pop one element from the center of the linked list
	// case 4: pop one element from the end    of the linked list
	@Test 
	public void popTest() {
		// Case 1
		LinkedList.pop(0);
		clearBuffer();
		String Expected1= "";    					// Empty list not printing anything
		assertEquals(Expected1, Output.toString());


		// Case 2
		LinkedList.pushBack(0);
		LinkedList.pop(0);
		clearBuffer();
		String Expected2= "";  						// Empty list not printing anything
		assertEquals(Expected2, Output.toString());


		//case 3
		intializeListWithRange(0,9);		
		LinkedList.pop(4);
		clearBuffer();
		LinkedList.display();
		String Expected3= "LinkedList : 0 1 2 3 5 6 7 8 9 \r\n";
		assertEquals(Expected3, Output.toString());
		
		//case 4
		LinkedList.pop(8);
		clearBuffer();
		LinkedList.display();
		String Expected4= "LinkedList : 0 1 2 3 5 6 7 8 \r\n";
		assertEquals(Expected4, Output.toString());
	}
}
