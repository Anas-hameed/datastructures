import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import Queue.DequeueImplementation.Dequeue;

public class DequeueTest {

	private final ByteArrayOutputStream Output = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;	
	private Dequeue queue; 
	//	For Checking the console output
	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(Output));
	}
	@After 
	public void restoreStreams() {
		System.setOut(originalOut);
	}
	public void clearBuffer() {
		Output.reset();
	}
	// 10 size queue is initialized for different operation before Each test.
	@Before 
	public void Intializelist() {
		queue= new Dequeue(3);
	}

	// addLeft Function:- To add elements in the left.
	// case 1:- Starting with adding one element to the left
	// case 2:- Again 3 more Element to the left
	@Test 
	public void addLeft() {
		// case 1 
		queue.addLeft(10);
		clearBuffer();
		queue.display();
		String Expected1= "DeQueue : 10 0 0 \r\n";
		assertEquals(Expected1, Output.toString());

		// case 2
		queue.addLeft(11);
		queue.addLeft(12);
		queue.addLeft(13);
		clearBuffer();
		queue.display();
		String Expected2= "DeQueue : 10 11 12 \r\n";
		assertEquals(Expected2, Output.toString());

	}

	// addRight Function:- To add elements in the Right.
	// case 1:- Starting with adding one element to the left
	// case 2:- Again 3 more Element to the left
	@Test
	public void addRight() {
		// case 1 
		queue.addRight(10);
		clearBuffer();
		queue.display();
		String Expected1= "DeQueue : 0 0 10 \r\n";
		assertEquals(Expected1, Output.toString());

		// case 2
		queue.addRight(11);
		queue.addRight(12);
		queue.addRight(13);
		clearBuffer();
		queue.display();
		String Expected2= "DeQueue : 12 11 10 \r\n";
		assertEquals(Expected2, Output.toString());

	}

}
