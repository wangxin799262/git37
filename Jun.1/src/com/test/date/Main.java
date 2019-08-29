package com.test.date;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public Main() {

	}

	public static void main(String args[]) {

		// 界面
		for (int i = 0; i < 30; i++)
			System.out.print("■");
		System.out.println(
				"\n文件类型: 类似杀毒软件的文件恢复工具\n陕西国际商贸学院4号教学楼305教室专用文件恢复工具\n前言:\n有人在计算机装还原系统之前装了恶意程序.\n此恶意程序行为: 对插入的U盘文件夹第一层目录执行系统级隐藏文件保护, 并通过创建可执行文件的快捷方式更改默认可执行程序的图标为文件夹的图标.\n食用方法:\n如果你发现你的U盘文件和文件夹都变成了.exe, 那么请你手动删除这些文件, 此程序必须在你的电脑上执行, 因为如果你在被感染的电脑上运行那是不可以的.\n选择程序界面类型:\n1. 字符界面( 省电费, 运行快 )\n2. 窗口界面( 美观 ) <-- 暂未开放");
		for (int i = 0; i < 30; i++)
			System.out.print("■");
		System.out.println();

		// 读取目录列表
		System.out.println("请输入U盘根目录:");
		Scanner input = new Scanner(System.in);
		String fileList = input.next(); // 获取文件路径
		File file = new File(fileList);
		String[] fileNameList = file.list(); // 输出文件列表

		// 获取文件夹列表
		System.out.println("读取文件列表:");
		for (int i = 0; i < 30; i++)
			System.out.print("▃");
		System.out.println();

		// 创建bat文件
		File creatFile = new File(fileList + "\\cmdStr.bat");

		// 如果文件存在
		if (creatFile.length() > 0) {
			try {

				// 清空文件内容
				FileWriter fileWriter = new FileWriter(creatFile);
				fileWriter.write("");
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}

		for (int i = 0; i < fileNameList.length; i++) {

			// 调试文件不保存
			if (fileNameList[i] == "cmdStr.bat" || fileNameList[i] == "JavaCallBatFile.exe")
				fileNameList[i] = null;

			System.out.println(fileNameList[i]);
			try {

				// 写入指令
				FileWriter cmdWriter = new FileWriter(creatFile, true); // 允许追加内容
				BufferedWriter bufferedWriter = new BufferedWriter(cmdWriter);
				bufferedWriter.append("attrib " + file.getAbsolutePath() + "\\" + fileNameList[i] + " -S" + " -H");
				bufferedWriter.newLine(); // 换行
				bufferedWriter.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		for (int i = 0; i < 30; i++)
			System.out.print("▃");
		System.out.println();

		String exeFilePath = "";
		try {

			// 复制Exe程序
			File exeFile = new File("JavaCallBatFile.exe");
			FileInputStream fileCopy = new FileInputStream(exeFile);

			// 粘贴文件到bat目录下
			FileOutputStream filePaste = new FileOutputStream(fileList + "\\" + exeFile);
			exeFilePath = fileList + "\\" + exeFile;

			// 复制文件数据
			int n = 0;
			while ((n = fileCopy.read()) != -1) {
				filePaste.write(n);
			}

			// 关闭文件流
			filePaste.flush();
			fileCopy.close();
			filePaste.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// 等待3秒
		System.out.println("等待3秒");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 调用外部程序
		try {
			Runtime.getRuntime().exec(exeFilePath);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println("执行完成");
	}
}
