package lms;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Lms {
	Scanner scan;
	
	private String brand;
	
	private String[] subTitles = {"국어", "수학", "영어"};
	
	public Lms(String brand) {
		this.scan = new Scanner(System.in);
		this.brand = brand;
	}
	
	private ArrayList<Student> list = new ArrayList<>();
	
	public int printMenu() {
		System.out.println("[학생 컨트롤러]");
		System.out.println("[1] 추가");
		System.out.println("[2] 삭제");
		System.out.println("[3] 정렬");
		System.out.println("[4] 출력");
		System.out.println("[5] 저장");
		System.out.println("[6] 로드");
		System.out.println("[7] 종료");
		System.out.print("번호 입력: ");
		int sel = this.scan.nextInt();
		return sel;
	}
	
	public int printSubMenu() {
		System.out.println("1) 학생 등록: ");
		System.out.println("2) 수강 신청: ");
		System.out.println("3) 성적 입력: ");
		System.out.print("선택: ");
		int sel = this.scan.nextInt();
		return sel;
	}
	
	public int randomGenerator() {
		Random ran = new Random();
		
		int rNum = 0;
		
		boolean check = true;
		while(check) {
			check = false;
			rNum = ran.nextInt(9000) + 1000;
			for(Student s : list)
				if(s.getNumber() == rNum)
					check = true;
		}
		return rNum;
	}
	
	public void printSubjectTitle() {
		for(int i = 0; i < this.subTitles.length; i++)
			System.out.println((i + 1) + ") " + subTitles[i]);
	}
	
	public void addStudent() {
		System.out.println("등록할 학생명 입력: ");
		String name = scan.next();
		
		int num = randomGenerator();
		
		list.add(new Student(num, name));
		
		System.out.println(name + " 학생(" + num + "번) 등록완료");
	}
	
	public void addSubject() {
		System.out.print("학번 입력: ");
		int number = scan.nextInt();
		
		Student student = null;
		ArrayList<Subject> subject = null;
		
		int idx = -1;
		for(Student s : list) {
			if(number == s.getNumber()) {
				idx = list.indexOf(s);
				student = new Student(s.getNumber(), s.getName());
				subject = s.getSubList();
			}
		}
		
		if(idx != -1) {
			printSubjectTitle();
			System.out.print("신청할 과목 번호 입력: ");
			int subIdx = scan.nextInt() - 1;
			
			boolean check = true;
			for(Subject s : subject) {
				if(subTitles[subIdx].equals(s.getTitle()))
					check = false;
			}
			
			if(check) {
				subject.add(new Subject(subTitles[subIdx]));
				student.setSubList(subject);
				
				list.set(idx, student);
			} else {
				System.out.println("이미 신청한 과목입니다.");
			}
			
			
		} else {
			System.out.println("유효하지 않은 학번입니다.");
		}
	}
	
	public void updateScore() {
		System.out.print("학번 입력: ");
		int number = scan.nextInt();
		
		Student student = null;
		ArrayList<Subject> subject = null;
		
		int idx = -1;
		for(Student s : list) {
			if(number == s.getNumber()) {
				idx = list.indexOf(s);
				student = new Student(s.getNumber(), s.getName());
				subject = s.getSubList();
			}
		}
		
		if(idx != -1) {
			printSubjectTitle();
			System.out.print("수정할 과목 번호 입력: ");
			int subIdx = scan.nextInt() - 1;
			
			boolean check = true;
			for(Subject s : subject) {
				if(subTitles[subIdx].equals(s.getTitle()))
					check = false;
			}
			
			if(check) {
				subject.add(new Subject(subTitles[subIdx]));
				student.setSubList(subject);
				
				list.set(idx, student);
			} else {
				System.out.println("이미 신청한 과목입니다.");
			}
			
			
		} else {
			System.out.println("유효하지 않은 학번입니다.");
		}
		
		
		
		
		
	}
	
	public void run() {
		while(true) {
			int sel = printMenu();
			
			if(sel == 1) {
				sel = printSubMenu();
				
				if(sel == 1) {
					addStudent();
					
				} else if(sel == 2) {
					addSubject();
					
				} else if(sel == 3) {
					updateScore();
					
				} else {
					System.out.println("화면의 번호 중에 입력하세요.");
				}
				
			} else if(sel == 2) {
				
			} else if(sel == 3) {
				
			} else if(sel == 4) {
				
			} else if(sel == 5) {
				
			} else if(sel == 6) {
				
			} else if(sel == 7) {
				System.out.println("학생 컨트롤러를 종료합니다.");
				break;
			} else {
				System.out.println("화면의 번호 중에 입력하세요.");
			}
		}
	}
	
}
