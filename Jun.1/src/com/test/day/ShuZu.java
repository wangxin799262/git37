package com.test.day;

import java.util.Scanner;

public class ShuZu {

	public static void main(String[] args) {
		// �������������
		Scanner in = new Scanner(System.in);
		int num[] = { 4, 8, 6, 3, 11, 15 };
		System.out.println("����ǰ������Ϊ��");
		for (int z = 0; z < num.length; z++) {
			System.out.print(num[z] + " ");
		}
		System.out.println();
		System.out.println("������Ҫ�������ݵĸ�����");
		int t = in.nextInt();
		int nums[] = new int[6 + t];
		for (int x = 0; x < num.length; x++) {
			nums[x] = num[x];
		}
		boolean bool = false;
		int m = 0;
		for (int j = 0; j < t; j++) {
			System.out.println("������Ҫ�����" + (j + 1) + "λ���ݣ�");
			int l = in.nextInt();
			System.out.println("�������Ƿ����ĩβ��");
			String opinion = in.next();
			if (opinion.equals("��")) {
				System.out.println("�����������Ҫ�����λ��(��Ҫ����ĳλ����ǰ)��");
				int s = in.nextInt();
				for (int k = 0; k < nums.length; k++) {
					if (s == nums[k]) {
						bool = true;
						m = k;
					}
				}
				if (bool == true) {
					for (int a = nums.length - 1; a > m; a--) {
						nums[a] = nums[a - 1];
					}
					nums[m] = l;
				} else {
					System.out.println("δ���ҵ���λ��,ϵͳ�˳�");
					System.exit(0);
				}
			}
			if (opinion.equals("��")) {
				nums[6 + j] = l;
			}
		}
		System.out.println("����������Ϊ��");
		for (int y = 0; y < nums.length; y++) {
			System.out.print(nums[y] + " ");
		}
	}
}