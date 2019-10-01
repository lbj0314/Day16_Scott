package com.iu.scott;

import com.iu.emp.EmpDAO;
import com.iu.emp.EmpDTO;
import com.iu.input.EmpInput;
import com.iu.view.EmpView;

public class ScottMain {

	public static void main(String[] args) {
		EmpDAO empDAO = new EmpDAO();
		EmpDTO empDTO = null;
//		empDTO = empDAO.getSelectOne(7902);
		empDTO = empDAO.getSelectList();
//		EmpInput empInput = empInput.empnoInput(0);
		EmpView ev = new EmpView();
		
		
		
		if (empDTO != null) {
			ev.view(empDTO);
		} else {
			ev.view("");
		}
		
	}

}
