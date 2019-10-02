package com.iu.control;

import java.util.List;
import java.util.Scanner;

import com.iu.dept.DeptDAO;
import com.iu.dept.DeptDTO;
import com.iu.input.DeptInput;
import com.iu.view.DeptView;

public class DeptController {
	private Scanner sc;
	private DeptDAO deptDAO;
	private DeptView deptView;
	private DeptInput deptInput;
	private DeptDTO deptDTO;
	
	public DeptController() {
		sc = new Scanner(System.in);
		deptDAO = new DeptDAO();
		deptView = new DeptView();
		deptInput = new DeptInput();
		deptDTO = new DeptDTO();
	}

	public void start() {
		boolean check = true;
		int select = 0;
		
		while(check){
			System.out.println("1. 부서 전체 정보 출력");
			System.out.println("2. 부서 검색 출력");
			System.out.println("3. 부서 정보 추가");
			System.out.println("4. 종료");

			select = sc.nextInt();
			switch (select) {
			case 1:
				List<DeptDTO> ar = deptDAO.deptSelectList();
				if(ar.size() > 0) {
					deptView.view(ar);
				} else {
					deptView.view("데이터가 존재하지 않습니다.");
				}
				deptView.view(ar);
				break;
			case 2:
				select = deptInput.deptInfo();
				deptDTO = deptDAO.deptSelectOne(select);
				if (deptDTO != null) {
					deptView.view(deptDTO);
				} else {
					deptView.view("없는 부서의 번호입니다.");
				}
				break;	
			case 3:
				deptDTO = deptInput.insert();
				select = deptDAO.deptInsert(deptDTO);
				String s = "입력 실패";
				if (select > 0) {
					s = "입력 성공";
				}
				deptView.view(s);
				break;
			default:
				check = !check;
			}


		}

	}

}
