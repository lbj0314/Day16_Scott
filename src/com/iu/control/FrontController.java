package com.iu.control;

import java.util.Scanner;

public class FrontController {

	private Scanner sc;
	private EmpController empController;
	private DeptController deptController;
	private SalgradeController salgradeController;
	private BonusController bonusController;
	
	
	public FrontController() {
		sc = new Scanner(System.in);
		empController = new EmpController();
		deptController = new DeptController();
		salgradeController = new SalgradeController();
		bonusController = new BonusController();
	}


	public void start() {
		boolean check = true;
		int select = 0;

		while (check) {
			System.out.println("1. 사원 관리");
			System.out.println("2. 부서 관리");
			System.out.println("3. 등급 관리");
			System.out.println("4. 보너스 관리");
			System.out.println("5. 프로그램 종료");
			select = sc.nextInt();
			switch (select) {
			case 1:
				empController.start();
				break;
			case 2:
				deptController.start();
				break;
			case 3:
				salgradeController.start();
				break;
			case 4:
				bonusController.start();
				break;
			default:
				check = !check;
			}

		}

	}


}
