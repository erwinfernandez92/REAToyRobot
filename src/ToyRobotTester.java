import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;


public class ToyRobotTester {

	@Test
	public void testGeneratorWithoutParameter() {
		ToyRobotTable trtTest= new ToyRobotTable(5,5);
		ToyRobot trTest = new ToyRobot(trtTest);
		assertEquals(0, trTest.getxPos());
		assertEquals(0, trTest.getyPos());
		assertEquals(ToyRobot.Direction.NORTH, trTest.getFacing());
	}
	
	@Test
	public void testGeneratorWithParameter() {
		ToyRobotTable trtTest= new ToyRobotTable(5,5);
		ToyRobot trTest = new ToyRobot(1,5,ToyRobot.Direction.WEST, trtTest);
		assertEquals(1, trTest.getxPos());
		assertEquals(5, trTest.getyPos());
		assertEquals(ToyRobot.Direction.WEST, trTest.getFacing());
	}
	
	@Test
	public void testMoveOutsideLeftBoundary() {
		ToyRobotTable trtTest= new ToyRobotTable(5,5);
		ToyRobot trTest = new ToyRobot(0,0,ToyRobot.Direction.WEST, trtTest);
		trTest.move();
		assertEquals(0, trTest.getxPos());
	}
	
	@Test
	public void testMoveOutsideRightBoundary() {
		ToyRobotTable trtTest= new ToyRobotTable(5,5);
		ToyRobot trTest = new ToyRobot(4,0,ToyRobot.Direction.EAST, trtTest);
		trTest.move();
		assertEquals(4, trTest.getxPos());
	}
	
	@Test
	public void testMoveOutsideBottomBoundary() {
		ToyRobotTable trtTest= new ToyRobotTable(5,5);
		ToyRobot trTest = new ToyRobot(0,0,ToyRobot.Direction.SOUTH, trtTest);
		trTest.move();
		assertEquals(0, trTest.getyPos());
	}
	
	@Test
	public void testMoveOutsideUpperBoundary() {
		ToyRobotTable trtTest= new ToyRobotTable(5,5);
		ToyRobot trTest = new ToyRobot(0,4,ToyRobot.Direction.NORTH, trtTest);
		trTest.move();
		assertEquals(4, trTest.getyPos());
	}
	
	@Test
	public void testMoveUp() {
		ToyRobotTable trtTest= new ToyRobotTable(5,5);
		ToyRobot trTest = new ToyRobot(0,2,ToyRobot.Direction.NORTH, trtTest);
		trTest.move();
		assertEquals(3, trTest.getyPos());
	}
	
	@Test
	public void testMoveDown() {
		ToyRobotTable trtTest= new ToyRobotTable(5,5);
		ToyRobot trTest = new ToyRobot(0,2,ToyRobot.Direction.SOUTH, trtTest);
		trTest.move();
		assertEquals(1, trTest.getyPos());
	}
	
	@Test
	public void testMoveLeft() {
		ToyRobotTable trtTest= new ToyRobotTable(5,5);
		ToyRobot trTest = new ToyRobot(1,2,ToyRobot.Direction.WEST, trtTest);
		trTest.move();
		assertEquals(0, trTest.getxPos());
	}
	
	@Test
	public void testMoveRight() {
		ToyRobotTable trtTest= new ToyRobotTable(5,5);
		ToyRobot trTest = new ToyRobot(3,2,ToyRobot.Direction.EAST, trtTest);
		trTest.move();
		assertEquals(4, trTest.getxPos());
	}
	
	@Test
	public void testReport() {
		ToyRobotTable trtTest= new ToyRobotTable(5,5);
		ToyRobot trTest = new ToyRobot(3,2,ToyRobot.Direction.EAST, trtTest);
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
		ToyRobotTable trtTest= new ToyRobotTable(5,5);
		ToyRobot trTest = new ToyRobot(3,2,ToyRobot.Direction.EAST, trtTest);
		trTest.faceLeft();
		assertEquals(ToyRobot.Direction.NORTH, trTest.getFacing());
	}
	
	@Test
	public void testFaceRight() {
		ToyRobotTable trtTest= new ToyRobotTable(5,5);
		ToyRobot trTest = new ToyRobot(3,2,ToyRobot.Direction.EAST, trtTest);
		trTest.faceRight();
		assertEquals(ToyRobot.Direction.SOUTH, trTest.getFacing());
	}
	
	@Test
	public void testAtTable() {
		ToyRobotTable trtTest= new ToyRobotTable(5,5);
		ToyRobot trTest = new ToyRobot(trtTest);
		assert(trTest.placeAtTable(3, 2, ToyRobot.Direction.EAST));
		assertEquals(ToyRobot.Direction.EAST, trTest.getFacing());
		assertEquals(3, trTest.getxPos());
		assertEquals(2, trTest.getyPos());
		assert(trTest.isAtTable());
	}
	
	@Test
	public void testNotAtTable() {
		ToyRobotTable trtTest= new ToyRobotTable(5,5);
		ToyRobot trTest = new ToyRobot(trtTest);
		assertFalse(trTest.placeAtTable(6, 20, ToyRobot.Direction.EAST));
		assertNotEquals(ToyRobot.Direction.EAST, trTest.getFacing());
		assertNotEquals(6, trTest.getxPos());
		assertNotEquals(20, trTest.getyPos());
		assertFalse(trTest.isAtTable());
	}

	@Test
	public void testDoCommands() {
		ToyRobotTable trtTest= new ToyRobotTable(5,5);
		ToyRobot trTest = new ToyRobot(trtTest);
		ArrayList<String> testCommands = new ArrayList<String>();
		testCommands.add("PLACE 1,1,NORTH");
		testCommands.add("MOVE");
		testCommands.add("LEFT");
		testCommands.add("MOVE");
		testCommands.add("RIGHT");
		testCommands.add("MOVE");
		testCommands.add("REPORT");
		trTest.doCommands(testCommands);
		
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
		assert(line.equals("0,3,NORTH"));
	}
}
