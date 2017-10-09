
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
