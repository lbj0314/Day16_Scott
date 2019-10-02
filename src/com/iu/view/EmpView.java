package com.iu.view;

import java.util.ArrayList;

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
		System.out.println("----------------------------");
	}//view
	
	public void view(ArrayList<EmpDTO> ar) {
		for (EmpDTO empDTO : ar) {
			this.view(empDTO);
		}
		
	}//view
	public void view(String str) {
		System.out.println(str);
		
	}
}
