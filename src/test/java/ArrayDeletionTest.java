import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Array.ArrayDeletion.ArrayDeletion;

public class ArrayDeletionTest {

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
	@Test 
	public void deleteTest() {

		//		Testing using the Main since private method cann't be called from outside the classes
		//		int [] array = {1,6,34,0,2,43};
		//		System.out.println("Before Deletion : ");
		//		display(array);
		//		array = delete(array,3);
		//		System.out.println("After Deletion of 3rd element : ");
		//		display(array);
		
		String Expected = "Before Deletion : \r\n"
				+ "1 6 34 0 2 43 \r\n"
				+ "After Deletion of 3rd element : \r\n"
				+ "1 6 34 2 43 -1 \r\n";
		ArrayDeletion.main(null);
		assertEquals(Expected, Output.toString());

	}
}
