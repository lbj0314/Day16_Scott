package com.iu.input;


import java.sql.Date;
import java.util.Scanner;

import com.iu.emp.EmpDTO;

public class EmpInput {
	private Scanner sc;
	public EmpInput(){
		sc = new Scanner(System.in);
	}
	//insert
	public EmpDTO insert() {
		EmpDTO empDTO = new EmpDTO();
		System.out.println("사원 번호를 입력하세요.");
		int empno = sc.nextInt();
		System.out.println("사원의 이름을 입력하세요.");
		String ename = sc.next();
		System.out.println("사원의 직업을 입력하세요.");
		String job = sc.next();
		System.out.println("사원의 매니저의 번호를 입력하세요.");
		int mgr = sc.nextInt();
//		System.out.println("사원의 입사일을 입력하세요.");
//		String hiredate = sc.next();
		System.out.println("사원의 급여를 입력하세요.");
		int sal = sc.nextInt();
		System.out.println("사원의 보너스를 입력하세요.");
		int comm = sc.nextInt();
		System.out.println("소속될 부서의 번호를 입력하세요.");
		int deptno = sc.nextInt();
		
		empDTO.setEmpno(empno);
		empDTO.setEname(ename);
		empDTO.setJob(job);
		empDTO.setMgr(mgr);
//		empDTO.setHiredate();
		empDTO.setSal(sal);
		empDTO.setComm(comm);
		empDTO.setDeptno(deptno);
		
		return empDTO;
	}
	
	//empnoInput
	//사원 번호 입력 return empno;
	public int empnoInput() {
		
		int empno = 0;
		System.out.println("사원 번호를 입력하세요.");
		empno = sc.nextInt();
		return empno;
		
	}
	
}
