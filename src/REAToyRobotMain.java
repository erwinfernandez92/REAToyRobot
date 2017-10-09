import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class REAToyRobotMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ToyInputReader tir = new ToyInputReader();
		tir.readInput();
		ToyRobot tr = new ToyRobot();
		tr.doCommands(tir.getToyCommandList());
	}

}
