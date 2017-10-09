import static org.junit.Assert.*;
import org.junit.Test;


public class ToyRobotTester {

	@Test
	public void testGeneratorWithoutParameter() {
		ToyRobot trTest = new ToyRobot();
		assertEquals(0, trTest.getxPos());
		assertEquals(0, trTest.getyPos());
		assertEquals(ToyRobot.Direction.NORTH, trTest.getFacing());
	}
	
	@Test
	public void testGeneratorWithParameter() {
		ToyRobot trTest = new ToyRobot(1,5,ToyRobot.Direction.WEST);
		assertEquals(1, trTest.getxPos());
		assertEquals(5, trTest.getyPos());
		assertEquals(ToyRobot.Direction.WEST, trTest.getFacing());
	}
	
	@Test
	public void testMoveOutsideLeftBoundary() {
		ToyRobot trTest = new ToyRobot(0,0,ToyRobot.Direction.WEST);
		trTest.move();
		assertEquals(0, trTest.getxPos());
	}
	
	@Test
	public void testMoveOutsideRightBoundary() {
		ToyRobot trTest = new ToyRobot(4,0,ToyRobot.Direction.EAST);
		trTest.move();
		assertEquals(4, trTest.getxPos());
	}
	
	@Test
	public void testMoveOutsideBottomBoundary() {
		ToyRobot trTest = new ToyRobot(0,0,ToyRobot.Direction.SOUTH);
		trTest.move();
		assertEquals(0, trTest.getyPos());
	}
	
	@Test
	public void testMoveOutsideUpperBoundary() {
		ToyRobot trTest = new ToyRobot(0,4,ToyRobot.Direction.NORTH);
		trTest.move();
		assertEquals(4, trTest.getyPos());
	}

}
