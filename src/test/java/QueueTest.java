import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import Queue.QueueImplementation.Queue;


public class QueueTest {

	private final ByteArrayOutputStream Output = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;	
	private Queue queue; 
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
	// case 1 : Adding 3   number to the queue
	// case 2 : Adding 4th number to exception on overflow buffer
	@Test 
	public void enqueueTest() {
		// Case 1
		try {
			queue.enqueue(0);
			queue.enqueue(1);
			queue.enqueue(2);

		}
		catch(Exception e){}
		clearBuffer();
		queue.display();
		String Expected1="Queue : 0 1 2 \r\n"; 
		assertEquals(Expected1,Output.toString());


	}

	// This test the enqueue thrown exception
	@Test(expected = Exception.class)
	public void enqueueTestException() throws Exception{
		queue= new Queue(0);
		queue.enqueue(4);		
	}


	// Testing the Dequeue functionality
	// case 1: Dequeue a full queue into empty it
	// case 2: Add two Element and remove one Element from it
	@Test 
	public void dequeueTest() {
		queue= new Queue(2);
		// Case 1
		try {
			queue.enqueue(0);
			queue.enqueue(1);
			queue.dequeue();
			queue.dequeue();

		}
		catch(Exception e){}
		assertTrue(queue.empty());  // Must be Empty        ==> [0]
		
		// case 2
		try {
			queue.enqueue(0);
			queue.enqueue(1);
			queue.dequeue();
			
		}catch(Exception err){}
		finally {
			assertFalse(queue.empty());// Must have Element ==> [1]
		}

	}


	// This test the dequeue thrown exception
	@Test(expected = Exception.class)
	public void dequeueTestException() throws Exception{
		queue= new Queue(0);
		queue.display();
		queue.dequeue();		
	}

}
