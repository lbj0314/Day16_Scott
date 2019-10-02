package com.iu.view;

import java.util.ArrayList;

import com.iu.salgrade.SalgradeDTO;

public class SalgradeView {
	//salgrade 출력
	public void view(SalgradeDTO salgradeDTO) {
		System.out.println("grade : " + salgradeDTO.getGrade());
		System.out.println("losal : " + salgradeDTO.getLosal());
		System.out.println("hisal : " + salgradeDTO.getHisal());
		System.out.println("---------------------------------");
	}//view
	//전체 출력
	public void view(ArrayList<SalgradeDTO> ar) {
		for(SalgradeDTO salgradeDTO : ar) {
			this.view(salgradeDTO);
		}
	}
	//메시지 출력
	public void view(String str) {
		System.out.println(str);
	}
	
}//class SalgradeView
