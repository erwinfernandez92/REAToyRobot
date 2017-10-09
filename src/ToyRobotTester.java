import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
	
	@Test
	public void testMoveUp() {
		ToyRobot trTest = new ToyRobot(0,2,ToyRobot.Direction.NORTH);
		trTest.move();
		assertEquals(3, trTest.getyPos());
	}
	
	@Test
	public void testMoveDown() {
		ToyRobot trTest = new ToyRobot(0,2,ToyRobot.Direction.SOUTH);
		trTest.move();
		assertEquals(1, trTest.getyPos());
	}
	
	@Test
	public void testMoveLeft() {
		ToyRobot trTest = new ToyRobot(1,2,ToyRobot.Direction.WEST);
		trTest.move();
		assertEquals(0, trTest.getxPos());
	}
	
	@Test
	public void testMoveRight() {
		ToyRobot trTest = new ToyRobot(3,2,ToyRobot.Direction.EAST);
		trTest.move();
		assertEquals(4, trTest.getxPos());
	}
	
	@Test
	public void testReport() {
		ToyRobot trTest = new ToyRobot(3,2,ToyRobot.Direction.EAST);
		trTest.report("output.txt");
		String line = null;
		
		try {
			FileReader fileReader = new FileReader("output.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			line = bufferedReader.readLine();
			
			bufferedReader.close();
		}
		catch(FileNotFoundException ex) {
			System.out.println("Unable to open file output.txt");
		}
		catch(IOException ex) {
			System.out.println("Error reading file output.txt");
		}
		assert(line.equals("3,2,EAST"));
	}
	
	@Test
	public void testFaceLeft() {
		ToyRobot trTest = new ToyRobot(3,2,ToyRobot.Direction.EAST);
		trTest.faceLeft();
		assertEquals(ToyRobot.Direction.NORTH, trTest.getFacing());
	}
	
	@Test
	public void testFaceRight() {
		ToyRobot trTest = new ToyRobot(3,2,ToyRobot.Direction.EAST);
		trTest.faceRight();
		assertEquals(ToyRobot.Direction.SOUTH, trTest.getFacing());
	}

}
