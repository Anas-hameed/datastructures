import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Queue.QueuewithArray.Queue;


public class QueueWithArray {

	private final ByteArrayOutputStream Output = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;	
	public Queue queue; 
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
	// 3 size queue is initialized for different operation before Each test.
	@Before 
	public void Intializelist() {
		queue= new Queue(3);
	}

	// testing the enqueue functionality 
	// case 1 : Adding 4 Element to the queue
	@Test 
	public void enqueueTest() {
		// Case 1
		Queue.enqueue(0);
		Queue.enqueue(1);
		Queue.enqueue(2);
		Queue.enqueue(3);
		clearBuffer();
		Queue.display();
		String Expected1="Queue : 0 1 2 \r\n"; 
		assertEquals(Expected1,Output.toString());
	}

	// Testing the Dequeue functionality
	// case 1: Dequeue a Empty Queue.
	// case 2: Dequeue a Queue with 1-number
	// case 3: Dequeue a full queue to empty queue
	@Test 
	public void dequeueTest() {
		queue= new Queue(2);
		//case 1
		Queue.dequeue();
		clearBuffer();
		Queue.display();
		String Expected1 ="Empty Queue.\r\n";
		assertEquals(Expected1, Output.toString());

		// Case 2
		Queue.enqueue(0);
		int Expected2= Queue.dequeue();
		assertEquals(Expected2, 0);

		// case 3
		Queue.enqueue(0);
		Queue.enqueue(1);
		int Expectted3a= Queue.dequeue();
		int Expectted3b= Queue.dequeue();
		assertEquals(Expectted3a, 0);
		assertEquals(Expectted3b, 1);	

	}
}