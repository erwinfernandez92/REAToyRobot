import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ToyInputReader {
	
	private ArrayList<String> toyCommandList = new ArrayList<String>();
	private String fileName;
	
	public ToyInputReader (String fn) {
		fileName =fn;
	}
	
	public ToyInputReader() {
		//default filename for input is input.txt if not given
		fileName = "input.txt";
	}
	
	public void readInput() {
		String line;
		System.out.println("Reading input.txt");
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			while ( (line = bufferedReader.readLine())!= null) {
				toyCommandList.add(line);
			}
			
			bufferedReader.close();
		}
		catch(FileNotFoundException ex) {
			System.out.println("Unable to open file "+fileName);
		}
		catch(IOException ex) {
			System.out.println("Error reading file "+ fileName);
		}
	}

	public ArrayList<String> getToyCommandList() {
		return toyCommandList;
	}

	public String getFileName() {
		return fileName;
	}
	
}
