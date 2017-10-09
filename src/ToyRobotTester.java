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

}
