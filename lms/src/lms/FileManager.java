package lms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileManager {

	private File file = new File("lms.txt");
	private FileWriter fw;
	private FileReader fr;
	private BufferedReader br;
	
	public File getFile() {
		return this.file;
	}
	
}
