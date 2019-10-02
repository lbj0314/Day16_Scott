package com.iu.control;

import java.util.ArrayList;
import java.util.Scanner;

import com.iu.emp.EmpDAO;
import com.iu.emp.EmpDTO;
import com.iu.input.EmpInput;
import com.iu.view.EmpView;

public class EmpController {
	//start
	//1. 사원전체정보출력
	//2. 사원검색출력
	//3. 종료
	private Scanner sc;
	private EmpDAO empDAO;
	private EmpView empView;
	private EmpInput empInput;
	private EmpDTO empDTO;

	public EmpController(){
		sc = new Scanner(System.in);
		empDAO = new EmpDAO();
		empView = new EmpView();
		empInput = new EmpInput();
		empDTO = new EmpDTO();
	}

	public void start() {

		boolean check = true;
		int select = 0;
		while (check) {
			System.out.println("1. 사원 전체 정보 출력");
			System.out.println("2. 사원 검색 출력");
			System.out.println("3. 사원 정보 추가");
			System.out.println("3. 종료");
			select = sc.nextInt();
			switch (select) {
			case 1:
				ArrayList<EmpDTO> ar = empDAO.getSelectList();
				if (ar.size() > 0) {
					empView.view(ar);
				} else {
					empView.view("데이터가 존재하지 않습니다.");
				}
//				empView.view(ar);
				break;
			case 2:
				select = empInput.empnoInput();
				empDTO = empDAO.getSelectOne(select);
				if(empDTO != null) {
					empView.view(empDTO);
				} else {
					empView.view("없는 사원의 번호입니다.");
				}
				break;
			case 3:
				empDTO = empInput.insert();
				select = empDAO.empInsert(empDTO);
				String s = "사원 정보 입력을 실패하였습니다.";
				if (select > 0) {
					s = "사원 정보 입력을 성공하였습니다.";
				} 
					empView.view(s);
				
				

			default:
				check = !check;

			}

		}



	}



}
