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
	public EmpController(){
		sc = new Scanner(System.in);
	}
	
	public void start() {
		EmpDAO empDAO = new EmpDAO();
		EmpDTO empDTO = new EmpDTO();
		ArrayList<EmpDTO> ar = new ArrayList<EmpDTO>();
		EmpInput ei = new EmpInput();
		EmpView ev = new EmpView();
		boolean check = true;
		
		while (check) {
			System.out.println("1. 사원 전체 정보 출력");
			System.out.println("2. 사원 검색 출력");
			System.out.println("3. 종료");
			int select = sc.nextInt();
			switch (select) {
			case 1:
//				if (ar != null) {
//					ev.view(ar);
//				} else {
//					ev.view("");
//				}
				ev.view(ar);
				break;
			case 2:
				ei.empnoInput();
				break;
			case 3:
				check = !check;
				break;
			
			}
			
		}
		
		
		
	}
	
	
	
}
