package com.test.day;

import java.util.Scanner;

public class ShuZu {

	public static void main(String[] args) {
		// 数组插入数功能
		Scanner in = new Scanner(System.in);
		int num[] = { 4, 8, 6, 3, 11, 15 };
		System.out.println("插入前的数组为：");
		for (int z = 0; z < num.length; z++) {
			System.out.print(num[z] + " ");
		}
		System.out.println();
		System.out.println("请输入要插入数据的个数：");
		int t = in.nextInt();
		int nums[] = new int[6 + t];
		for (int x = 0; x < num.length; x++) {
			nums[x] = num[x];
		}
		boolean bool = false;
		int m = 0;
		for (int j = 0; j < t; j++) {
			System.out.println("请输入要插入第" + (j + 1) + "位数据：");
			int l = in.nextInt();
			System.out.println("该数据是否插入末尾：");
			String opinion = in.next();
			if (opinion.equals("否")) {
				System.out.println("请输入该数据要插入的位置(想要插入某位数据前)：");
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
					System.out.println("未查找到该位置,系统退出");
					System.exit(0);
				}
			}
			if (opinion.equals("是")) {
				nums[6 + j] = l;
			}
		}
		System.out.println("插入后的数组为：");
		for (int y = 0; y < nums.length; y++) {
			System.out.print(nums[y] + " ");
		}
	}
}