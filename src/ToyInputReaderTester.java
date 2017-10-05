import static org.junit.Assert.*;

import org.junit.Test;

public class ToyInputReaderTester {

	@Test
	public void testGeneratorWithParameter() {
		ToyInputReader tirTester = new ToyInputReader("testInput.txt");
		assertEquals("testInput.txt", tirTester.getFileName());
	}
	
	@Test
	public void testGeneratorWithoutParameter() {
		ToyInputReader tirTester = new ToyInputReader();
		assertEquals("input.txt", tirTester.getFileName());
	}
	
	@Test
	public void testRead() {
		ToyInputReader tirTester = new ToyInputReader();
		tirTester.readInput();
		assertEquals(tirTester.getToyCommandList().get(0), "PLACE 0,0,NORTH");
		assertEquals(tirTester.getToyCommandList().get(1), "MOVE");
		assertEquals(tirTester.getToyCommandList().get(2), "LEFT");
		assertEquals(tirTester.getToyCommandList().get(3), "RIGHT");
		assertEquals(tirTester.getToyCommandList().get(4), "REPORT");
	}

}
