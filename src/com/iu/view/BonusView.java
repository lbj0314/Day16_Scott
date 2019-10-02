package com.iu.view;

import java.util.ArrayList;

import com.iu.bonus.BonusDTO;

public class BonusView {
	//bonus 정보 출력
	public void view(BonusDTO bonusDTO) {
		System.out.println("ename : " + bonusDTO.getEname());
		System.out.println("job : " + bonusDTO.getJob());
		System.out.println("sal : " + bonusDTO.getSal());
		System.out.println("comm : " + bonusDTO.getComm());
		System.out.println("--------------------------");
	}
	//bonus 전체 정보 출력
	public void view(ArrayList<BonusDTO> ar) {
		for(BonusDTO bonusDTO : ar) {
			this.view(bonusDTO);
		}
	}
	//메시지 출력
	public void view(String str) {
		System.out.println(str);
	}
}
