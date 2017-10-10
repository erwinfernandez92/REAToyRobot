import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

public class ToyRobot {
	
	public enum Direction{
		NORTH,
		SOUTH,
		WEST,
		EAST;
	}
	
	private int xPos;
	private int yPos;
	private Direction facing;
	private boolean atTable;
	private ToyRobotTable trTable;
	
	//adding default position of 0,0 and facing 
	//north when no input was given
	public ToyRobot(ToyRobotTable toyRobotTable) {
		xPos=0;
		yPos=0;
		facing = Direction.NORTH;
		trTable = toyRobotTable;
		atTable = false;
	}
	
	public ToyRobot(int x, int y, Direction f, ToyRobotTable toyRobotTable) {
		xPos = x;
		yPos = y;
		facing = f;
		trTable = toyRobotTable;
		atTable = false;
	}
	
	public boolean placeAtTable(int x, int y, Direction f) {
		if((x>=trTable.getBottomLeftX())&&
				(x<=(trTable.getBottomLeftX()+trTable.getTableWidth()-1))&&
				(y>=trTable.getBottomLeftY())&&
				(y<=(trTable.getBottomLeftY()+trTable.getTableLength()-1))) {
			xPos = x;
			yPos = y;
			facing = f;
			setAtTable(true);
			return true;
		}else {
			return false;
		}
	}
	
	public void move() {
		switch(facing) {
		case NORTH : {
			if (yPos<(trTable.getBottomLeftY()+trTable.getTableLength()-1)) {
				yPos++;
			}
			break;
		}
		case SOUTH : {
			if (yPos>trTable.getBottomLeftY()) {
				yPos--;
			}
			break;
		}
		case EAST : {
			if (xPos<(trTable.getBottomLeftX()+trTable.getTableWidth()-1)) {
				xPos++;
			}
			break;
		}
		case WEST : {
			if (xPos>0) {
				xPos--;
			}
			break;
		}
		
		}
	}
	
	public void faceLeft() {
		switch(facing) {
		case NORTH : facing = Direction.WEST;break;
		case WEST : facing = Direction.SOUTH;break;
		case SOUTH : facing = Direction.EAST;break;
		case EAST : facing = Direction.NORTH;break;
		}
	}
	
	public void faceRight() {
		switch(facing) {
		case NORTH : facing = Direction.EAST;break;
		case WEST : facing = Direction.NORTH;break;
		case SOUTH : facing = Direction.WEST;break;
		case EAST : facing = Direction.SOUTH;break;
		}
	}
	
	public void report(String outLoc) {
		Writer writer = null;
		try {
		    writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream(outLoc), "utf-8"));
		    writer.write(xPos + "," + yPos + ","+facing);
		} catch (IOException ex) {
		  System.out.println("file error, filename: "+ outLoc);
		} finally {
		   try {writer.close();
		   } 
		   catch (Exception ex) {
			   System.out.println("error closing output file");
		   }
		}
	}
	
	public void doCommands(ArrayList<String> toyCommands) {
		String[] toyCommand;
		
		//going through command list, execute valid command
		//and ignoring all invalid command.
		for(int i=0;i<toyCommands.size();i++) {
			toyCommand = toyCommands.get(i).split(" ");
			if (toyCommand[0].equals("PLACE")) {
				//executing place command only if it is
				//accompanied by valid input
				try {
					String[] placeInput = toyCommand[1].split(",");
					int x = Integer.valueOf( placeInput[0]);
					int y = Integer.valueOf( placeInput[1]);
					Direction f = Direction.valueOf(placeInput[2]);
					placeAtTable(x,y,f);
				}catch (Exception e) {
					continue;
				}
			}else if (toyCommand[0].equals("MOVE") && atTable) {
				move();
			}else if (toyCommand[0].equals("LEFT") && atTable) {
				faceLeft();
			}else if (toyCommand[0].equals("RIGHT") && atTable) {
				faceRight();
			}else if (toyCommand[0].equals("REPORT")) {
				report("output.txt");
			}
		}
	}
	
	public int getxPos() {
		return xPos;
	}
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	public int getyPos() {
		return yPos;
	}
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	public Direction getFacing() {
		return facing;
	}
	public void setFacing(Direction facing) {
		this.facing = facing;
	}
	public boolean isAtTable() {
		return atTable;
	}
	public void setAtTable(boolean atTable) {
		this.atTable = atTable;
	}
	
	
}
