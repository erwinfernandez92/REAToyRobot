import static org.junit.Assert.*;

import org.junit.Test;

public class ToyRobotTableTester {

	@Test
	public void testgeneratorWithBottomLeft() {
		ToyRobotTable trtTest = new ToyRobotTable(1,2,3,4);
		assertEquals(1, trtTest.getBottomLeftX());
		assertEquals(2, trtTest.getBottomLeftY());
		assertEquals(3, trtTest.getTableLength());
		assertEquals(4, trtTest.getTableWidth());
	}

	@Test
	public void testGeneratorWithoutBottomLeft() {
		ToyRobotTable trtTest = new ToyRobotTable(5,4);
		assertEquals(0, trtTest.getBottomLeftX());
		assertEquals(0, trtTest.getBottomLeftY());
		assertEquals(5, trtTest.getTableLength());
		assertEquals(4, trtTest.getTableWidth());
	}

}
