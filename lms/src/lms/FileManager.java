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
	
	public void fw(String data) {
		try {
			fw = new FileWriter(this.file);
			
			fw.write(data);
			fw.close();
			
			System.out.println("파일 저장 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("파일 저장 실패");
		}
	}
	
	public void fr(File file) {		
		try {
			this.fr = new FileReader(this.file);
			this.br = new BufferedReader(this.fr);
			
			while(this.br.ready()) {
				String[] data = this.br.readLine().split(": ");
				data
				
				
				
				
				String[] info = data[0].split("/");
				int number = Integer.parseInt(info[0]);
				String name = info[1];
				
				Student2 student = new Student2(number, name);
				
				if(data.length > 1) {
					student.subCnt = data.length - 1;
					student.subjects = new Subject2[student.subCnt];
					
					for(int i = 1; i < data.length; i++) {
						info = data[i].split("/");
						
						Subject2 subject = new Subject2(info[0]);
						subject.score = Integer.parseInt(info[1]);
						
						student.subjects[i - 1] = subject;
					}
				}
				
				Student2[] temp = this.students;
				this.students = new Student2[this.cnt + 1];
				for(int i = 0; i < this.cnt; i++)
					this.students[i] = temp[i];
				this.students[this.cnt] = student;
				this.cnt++;
			}
			
			this.fr.close();
			this.br.close();
			
			System.out.println("파일 로드 성공");
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("파일 로드 실패");
		}
	}
	
}
