package com.accp.ch5;

import java.util.Scanner;

/**
 * ������
 * @author ACCP7.0
 *
 */
public class Test {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); 
		System.out.println("-----------------��ӭ����QuickHit��Ϸ-----------------");
		System.out.println("��Ϸ����\n�ڹ涨ʱ��������������ͬ���ַ�����6�أ�\nÿ����ȷһ�ξ�Ӯ����Ӧ���֣�ȫ��������ȷ�����سɹ���\n��һ����3�λ��ᡣ");
		System.out.println("��ʼ���ذɣ�");
		long startTime = System.currentTimeMillis();
		while (true) {
			if (System.currentTimeMillis()-startTime >2000) {//��������2���ʼ��Ϸ
				Player player = new Player();
				player.play();
				input.next();
				break;
			}
		}
	}
}
