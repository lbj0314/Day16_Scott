package com.iu.input;

import java.util.Scanner;

import com.iu.bonus.BonusDTO;

public class BonusInput {
	private Scanner sc;
	
	public BonusInput() {
		sc = new Scanner(System.in);
	}
	
	//bonus 정보 하나
	public String bonusInput() {
		String ename = null;
		System.out.println("사원의 이름을 입력하세요.");
		ename = sc.next();
		return ename;
	}//bonusInput
	
	//insert
	public BonusDTO insert() {
		BonusDTO bonusDTO = new BonusDTO();
		System.out.println("사원의 이름을 입력하세요.");
		String ename = sc.next();
		System.out.println("직업을 입력하세요.");
		String job = sc.next();
		System.out.println("급여를 입력하세요.");
		int sal = sc.nextInt();
		System.out.println("커미션을 입력하세요.");
		int comm = sc.nextInt();
		
		bonusDTO.setEname(ename);
		bonusDTO.setJob(job);
		bonusDTO.setSal(sal);
		bonusDTO.setComm(comm);
		
		return bonusDTO;
	}
	
	//bonus 삭제
	public String delete() {
		String dname = null;
		System.out.println("보너스를 삭제할 사원의 이름을 입력하세요.");
		dname = sc.next();
		return dname;
	}
	
}
