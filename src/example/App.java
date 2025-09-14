package example;

import java.util.Scanner;

import example.controller.ArticleController;
import example.controller.Controller;
import example.controller.MemberController;

public class App {

	public void run() {

		System.out.println("== 프로그램 시작 ==");

		Scanner sc = new Scanner(System.in);
		MemberController memberController = new MemberController(sc);
		ArticleController articleController = new ArticleController(sc);
		articleController.makeTestData();
		memberController.makeTestData();

		while (true) {

			System.out.printf("명령어) ");
			String cmd = sc.nextLine().trim(); // cmd가 정의된 곳

			if (cmd.length() == 0) {
				System.out.println("명령어를 입력해주세요.");
				continue;
			}

			if (cmd.equals("exit")) {

				break;
			}

			String[] cmdBits = cmd.split(" ");

			if (cmdBits.length == 1) {
				System.out.println("명령어를 확인하고 입력해주세요.");
				continue;
			}

			String controllerName = cmdBits[0]; // 변수선언과 동시에 초기화
			String methodName = cmdBits[1]; // 변수선언과 동시에 초기화

			String actionName = controllerName + "/" + methodName;

			switch (actionName) {
				case "article/write":
				case "article/modify":
				case "article/delete":
				case "member/join":
					if (Controller.isLogined() == false) {
						System.out.println("로그인 후 이용해주세요.");
					}
				case "member/login":
				case "member/logout":
					if (Controller.isLogined()) {
						System.out.println("로그아웃 후 이용해주세요.");
					}

			}

			Controller controller = null;

			if (controllerName.equals("member")) {
				controller = memberController;
			}

			else if (controllerName.equals("article")) {
				controller = articleController;
			}

			else {
				System.out.println("존재하지 않는 명령어입니다.");
				continue;
			}

			controller.doAction(cmd, methodName);

		}

		System.out.println("== 프로그램 끝 ==");

		sc.close();

	}

}
