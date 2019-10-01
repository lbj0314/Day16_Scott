package com.iu.view;

import com.iu.emp.EmpDTO;

public class EmpView {
	public void view(EmpDTO empDTO) {
		System.out.println("empno : "+empDTO.getEmpno());
		System.out.println("ename : "+empDTO.getEname());
		System.out.println("job : "+empDTO.getJob());
		System.out.println("mgr : "+empDTO.getMgr());
		System.out.println("hiredate : "+empDTO.getHiredate());
		System.out.println("sal : "+empDTO.getSal());
		System.out.println("comm : "+empDTO.getComm());
		System.out.println("deptno : "+empDTO.getDeptno());
	}//view
	
	public void view(String str) {
		System.out.println("없는 사원입니다.");
		
	}
}
