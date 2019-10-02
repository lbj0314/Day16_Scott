package com.iu.input;

import java.util.Scanner;

import com.iu.salgrade.SalgradeDTO;

public class SalgradeInput {
	private Scanner sc;
	
	public SalgradeInput() {
		sc = new Scanner(System.in);
	}//생성자
	//salgrade 입력
	public int gradeInput() {
		int grade = 0;
		System.out.println("grade를 입력하세요.");
		grade = sc.nextInt();
		return grade;
	}
	//salgrade 추가
	public SalgradeDTO insert() {
		SalgradeDTO salgradeDTO = new SalgradeDTO();
		System.out.println("grade를 입력하세요.");
		int grade = sc.nextInt();
		System.out.println("losal를 입력하세요.");
		int losal = sc.nextInt();
		System.out.println("hisal를 입력하세요.");
		int hisal = sc.nextInt();
		
		salgradeDTO.setGrade(grade);
		salgradeDTO.setLosal(losal);
		salgradeDTO.setHisal(hisal);
		
		return salgradeDTO;
	}
	
	//salgrade 삭제
	public int delete() {
		int grade = 0;
		System.out.println("삭제할 grade를 입력하세요.");
		grade = sc.nextInt();
		return grade;
	}
	
}
