package com.iu.input;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.iu.dept.DeptDTO;

public class DeptInput {
	
	private Scanner sc;
	
	public DeptInput() {
		sc = new Scanner(System.in);
	}
	
	public DeptDTO insert() {
		DeptDTO deptDTO = new DeptDTO();
		System.out.println("부서 번호를 입력하세요.");
		int deptno = sc.nextInt();
		System.out.println("부서 이름을 입력하세요.");
		String dname = sc.next();
		System.out.println("부서의 위치를 입력하세요.");
		String loc = sc.next();
		deptDTO.setDeptno(deptno);
		deptDTO.setDname(dname);
		deptDTO.setLoc(loc);
		
		return deptDTO;
	}
	
	public int deptInfo() {
		System.out.println("부서번호를 입력하세요.");
		int deptno = sc.nextInt();
		return deptno;
	}
	
	
}
