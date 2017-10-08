
public class ToyRobot {
	private int xPos;
	private int yPos;
	private String facing;
	
	public ToyRobot() {
		xPos=0;
		yPos=0;
		facing = "NORTH";
	}
	public ToyRobot(int x, int y, String f) {
		xPos = x;
		yPos = y;
		facing = f;
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
	public String getFacing() {
		return facing;
	}
	public void setFacing(String facing) {
		this.facing = facing;
	}
	
}
