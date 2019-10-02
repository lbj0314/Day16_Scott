package com.iu.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.iu.input.SalgradeInput;
import com.iu.salgrade.SalgradeDAO;
import com.iu.salgrade.SalgradeDTO;
import com.iu.view.SalgradeView;

public class SalgradeController {
	private Scanner sc;
	private SalgradeDAO salgradeDAO;
	private SalgradeView salgradeView;
	private SalgradeInput salgradeInut;
	private SalgradeDTO salgradeDTO;

	public SalgradeController() {
		sc = new Scanner(System.in);
		salgradeDAO = new SalgradeDAO();
		salgradeView = new SalgradeView();
		salgradeInut = new SalgradeInput();
		salgradeDTO = new SalgradeDTO();
	}

	public void start() {
		boolean check = true;
		int select = 0;
		while (check) {
			System.out.println("1. 전체 등급 정보 출력");
			System.out.println("2. 등급별 정보 검색");
			System.out.println("3. 등급 추가");
			System.out.println("4. 등급 삭제");
			System.out.println("5. 종료");
			select = sc.nextInt();
			switch (select) {
			case 1:
				ArrayList<SalgradeDTO> ar = salgradeDAO.getselectList();
				if (ar.size() > 0) {
					salgradeView.view(ar);
				}
				break;
			case 2:
				select = salgradeInut.gradeInput();
				salgradeDTO = salgradeDAO.salgradeSelectOne(select);
				if (salgradeDTO != null) {
					salgradeView.view(salgradeDTO);
				} else {
					salgradeView.view("없는 등급입니다.");
				}
				break;
			case 3:
				salgradeDTO = salgradeInut.insert();
				select = salgradeDAO.SalgradeInsert(salgradeDTO);
				String s = "등급 정보 입력을 실패하였습니다.";
				if (select > 0) {
					s = "등급 정보 입력을 성공하였습니다.";
				}
				salgradeView.view(s);
				break;
			case 4:
				select = salgradeInut.gradeInput();
				int result = salgradeDAO.salgradeDelete(select);
				s = "등급 정보 삭제에 실패하였습니다.";
				if (select > 0) {
					s = "등급 정보 삭제에 성공하였습니다.";
				}
				salgradeView.view(s);
				break;
			default:
				check = !check;
			}
		}
	}//start 


}//class SalgradeController
