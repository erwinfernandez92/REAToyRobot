
public class REAToyRobotMain {

	public static void main(String[] args) {
		ToyInputReader tir = new ToyInputReader();
		tir.readInput();
		ToyRobotTable trt = new ToyRobotTable(5,5);
		ToyRobot tr = new ToyRobot(trt);
		tr.doCommands(tir.getToyCommandList());
		
	}

}
