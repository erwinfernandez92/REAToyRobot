
public class ToyRobotTable {
	private int bottomLeftX;
	private int bottomLeftY;
	private int tableLength;
	private int tableWidth;

	public int getBottomLeftX() {
		return bottomLeftX;
	}

	public void setBottomLeftX(int bottomLeftX) {
		this.bottomLeftX = bottomLeftX;
	}

	public int getBottomLeftY() {
		return bottomLeftY;
	}

	public void setBottomLeftY(int bottomLeftY) {
		this.bottomLeftY = bottomLeftY;
	}

	public int getTableLength() {
		return tableLength;
	}

	public void setTableLength(int tableLength) {
		this.tableLength = tableLength;
	}

	public int getTableWidth() {
		return tableWidth;
	}

	public void setTableWidth(int tableWidth) {
		this.tableWidth = tableWidth;
	}

	//assuming bottom left of the table is at 0,0 when not given
	public ToyRobotTable (int length, int width) {
		bottomLeftX = 0;
		bottomLeftY = 0;
		tableLength = length;
		tableWidth = width;
	}
	
	public ToyRobotTable (int x, int y, int length, int width) {
		bottomLeftX = x;
		bottomLeftY = y;
		tableLength = length;
		tableWidth = width;
	}
}
