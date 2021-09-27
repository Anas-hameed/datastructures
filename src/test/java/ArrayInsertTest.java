import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Array.ArrayInsert.ArrayInsertion;


public class ArrayInsertTest {
	private final ByteArrayOutputStream Output = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;	
	//	For Checking the console output
	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(Output));
	}
	@After 
	public void restoreStreams() {
		System.setOut(originalOut);
	}

	//Verifying the insertion in the array using main output
	@Test
	public void insetTest() {	
		ArrayInsertion Arr= new ArrayInsertion();
		//		following values are inserted and verified after each step.
		//		insert(array,1,0);
		//		insert(array,5,2);
		//		insert(array,56,1);
		//		insert(array,12,4);
		//		insert(array,2,6);
		//		insert(array,90,3);
		//		insert(array,16,7);

		String Expected="After Inserting 1 at index 0: \r\n"
				+ "1 0 0 0 0 0 0 0 0 0 \r\n"
				+ "After Inserting 5 at index 2: \r\n"
				+ "1 0 5 0 0 0 0 0 0 0 \r\n"
				+ "After Inserting 56 at index 1: \r\n"
				+ "1 56 0 5 0 0 0 0 0 0 \r\n"
				+ "After Inserting 12 at index 4: \r\n"
				+ "1 56 0 5 12 0 0 0 0 0 \r\n"
				+ "After Inserting 2 at index 6: \r\n"
				+ "1 56 0 5 12 0 2 0 0 0 \r\n"
				+ "After Inserting 90 at index 3: \r\n"
				+ "1 56 0 90 5 12 0 0 0 0 \r\n"
				+ "After Inserting 16 at index 7: \r\n"
				+ "1 56 0 90 5 12 0 16 0 0 \r\n";
		ArrayInsertion.main(null);
		assertEquals(Expected, Output.toString());
	}

}
