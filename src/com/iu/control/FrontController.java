package com.iu.control;

import java.util.Scanner;

public class FrontController {

	private Scanner sc;
	private EmpController empController;
	private DeptController deptController;

	public FrontController() {
		sc = new Scanner(System.in);
		empController = new EmpController();
		deptController = new DeptController();
	}


	public void start() {
		boolean check = true;
		int select = 0;

		while (check) {
			System.out.println("1. 사원 관리");
			System.out.println("2. 부서 관리");
			System.out.println("3. 프로그램 종료");
			select = sc.nextInt();
			switch (select) {
			case 1:
				empController.start();
				break;
			case 2:
				deptController.start();
				break;
			default:
				check = !check;
			}

		}

	}


}
