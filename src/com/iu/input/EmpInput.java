package com.iu.input;


import java.util.Scanner;

public class EmpInput {
	private Scanner sc;
	public EmpInput(){
		sc = new Scanner(System.in);
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
