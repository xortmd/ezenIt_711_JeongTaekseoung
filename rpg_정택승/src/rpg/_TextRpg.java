package rpg;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

class MainGame {
	static Scanner scan = new Scanner(System.in);
	static Random ran = new Random();

	public MainGame() {
		Player player = new Player();
		Shop shop = new Shop();
		FileData fileData = new FileData();
		System.out.println("tsRPG에 오신 것을 환영합니다.");
		System.out.println("길드를 모집하여 최종목표에 도전하세요.");
		while (true) {
			System.out.println("=============== [메인메뉴] ================");
			System.out.println("[1.길드관리] [2.상점] [3.인벤토리] [4.던전입장]");
			System.out.println("[5.저장] [6.로드] [0.종료]");
			int sel = scan.nextInt();
			
			if (sel == 1) {
				player.guildMenu();
			} else if (sel == 2) {
				shop.shopMng();
			} else if (sel == 3) {
				player.inventoryMenu();
			} else if (sel == 4) {
				player.dungeonMenu();
			} else if (sel == 5) {
				try {
					fileData.save();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (sel == 6) {
				try {
					fileData.loadData();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("게임을 종료 합니다.");
				break;
			}
		}
		MainGame.scan.close();
	}
}

public class _TextRpg {
	public static void main(String[] args) {
		new MainGame();
	}
}