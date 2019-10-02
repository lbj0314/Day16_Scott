package com.iu.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.iu.bonus.BonusDAO;
import com.iu.bonus.BonusDTO;
import com.iu.input.BonusInput;
import com.iu.view.BonusView;

public class BonusController {
	private Scanner sc;
	private BonusDAO bonusDAO;
	private BonusView bonusView;
	private BonusInput bonusInput;
	private BonusDTO bonusDTO;

	public BonusController() {
		sc = new Scanner(System.in);
		bonusDAO = new BonusDAO();
		bonusView = new BonusView();
		bonusInput = new BonusInput();
		bonusDTO = new BonusDTO();
	}

	public void start() {
		boolean check = true;
		int select = 0;
		while (check) {
			System.out.println("1. 보너스 받는 사원 전체 정보 출력");
			System.out.println("2. 보너스 받는 사원 검색 ");
			System.out.println("3. 보너스 받는 사원 추가");
			System.out.println("4. 보너스 받는 사원 삭제");
			System.out.println("5. 종료");
			select = sc.nextInt();
			switch (select) {
			case 1:
				ArrayList<BonusDTO> ar = bonusDAO.bonusSelectList();
				if (ar.size() > 0) {
					bonusView.view(ar);
				}
				break;
			case 2:
				String str = bonusInput.bonusInput();
				bonusDTO = bonusDAO.bonusSelectOne(str);
				if (bonusDTO != null) {
					bonusView.view(bonusDTO);
				} else {
					bonusView.view("없는 사원의 이름입니다.");
				}
				break;
			case 3:
				bonusDTO = bonusInput.insert();
				select = bonusDAO.bonusInsert(bonusDTO);
				String s = "보너스 받을 사원 정보 입력을 실패했습니다.";
				if (select > 0) {
					s = "보너스 받을 사원 정보 입력을 성공했습니다.";
				}
				bonusView.view(s);
				break;
			case 4:
				str = bonusInput.bonusInput();
				int result = bonusDAO.bonusDelete(str);
				s = "보너스 받을 사원 정보 삭제에 실패했습니다.";
				if (result > 0) {
					s = "보너스 받을 사원 정보 삭제에 성공했습니다.";
				}
				bonusView.view(s);
				break;
			default:
				check = !check;
				
			}
		}
	}//start
}//class bonusController
