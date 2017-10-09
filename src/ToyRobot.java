import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

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
	
	//adding default position of 0,0 and facing 
	//north when no input was given
	public ToyRobot() {
		xPos=0;
		yPos=0;
		facing = Direction.NORTH;
	}
	public ToyRobot(int x, int y, Direction f) {
		xPos = x;
		yPos = y;
		facing = f;
	}
	
	public boolean placeAtTable(int x, int y, Direction f) {
		if((x>=0)&&(x<=4)&&(y>=0)&&(y<=4)) {
			xPos = x;
			yPos = y;
			facing = f;
			atTable =true;
			return true;
		}else {
			return false;
		}
	}
	
	public void move() {
		switch(facing) {
		case NORTH : {
			if (yPos<4) {
				yPos++;
			}
			break;
		}
		case SOUTH : {
			if (yPos>0) {
				yPos--;
			}
			break;
		}
		case EAST : {
			if (xPos<4) {
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
		case NORTH : facing = Direction.WEST;
		case WEST : facing = Direction.SOUTH;
		case SOUTH : facing = Direction.EAST;
		case EAST : facing = Direction.NORTH;
		}
	}
	
	public void faceRight() {
		switch(facing) {
		case NORTH : facing = Direction.EAST;
		case WEST : facing = Direction.NORTH;
		case SOUTH : facing = Direction.WEST;
		case EAST : facing = Direction.SOUTH;
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
		   try {writer.close();} catch (Exception ex) {/*ignore*/}
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
	
	
}
