package com.iu.view;

import java.util.List;

import com.iu.dept.DeptDTO;

public class DeptView {
	//전체
	public void view(List<DeptDTO> ar) {
		
		for(DeptDTO deptDTO : ar) {
			this.view(deptDTO);
		}
		
	}
	//하나
	public void view(DeptDTO deptDTO) {
		System.out.println("--------------------");
		System.out.println("Deptno : " + deptDTO.getDeptno());
		System.out.println("Dname : " + deptDTO.getDname());
		System.out.println("Loc : " + deptDTO.getLoc());
	}
	//에러처리
	public void view(String str) {
		System.out.println(str);
	}
}
