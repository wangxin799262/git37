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

		// ����
		for (int i = 0; i < 30; i++)
			System.out.print("��");
		System.out.println(
				"\n�ļ�����: ����ɱ��������ļ��ָ�����\n����������óѧԺ4�Ž�ѧ¥305����ר���ļ��ָ�����\nǰ��:\n�����ڼ����װ��ԭϵͳ֮ǰװ�˶������.\n�˶��������Ϊ: �Բ����U���ļ��е�һ��Ŀ¼ִ��ϵͳ�������ļ�����, ��ͨ��������ִ���ļ��Ŀ�ݷ�ʽ����Ĭ�Ͽ�ִ�г����ͼ��Ϊ�ļ��е�ͼ��.\nʳ�÷���:\n����㷢�����U���ļ����ļ��ж������.exe, ��ô�����ֶ�ɾ����Щ�ļ�, �˳����������ĵ�����ִ��, ��Ϊ������ڱ���Ⱦ�ĵ������������ǲ����Ե�.\nѡ������������:\n1. �ַ�����( ʡ���, ���п� )\n2. ���ڽ���( ���� ) <-- ��δ����");
		for (int i = 0; i < 30; i++)
			System.out.print("��");
		System.out.println();

		// ��ȡĿ¼�б�
		System.out.println("������U�̸�Ŀ¼:");
		Scanner input = new Scanner(System.in);
		String fileList = input.next(); // ��ȡ�ļ�·��
		File file = new File(fileList);
		String[] fileNameList = file.list(); // ����ļ��б�

		// ��ȡ�ļ����б�
		System.out.println("��ȡ�ļ��б�:");
		for (int i = 0; i < 30; i++)
			System.out.print("�z");
		System.out.println();

		// ����bat�ļ�
		File creatFile = new File(fileList + "\\cmdStr.bat");

		// ����ļ�����
		if (creatFile.length() > 0) {
			try {

				// ����ļ�����
				FileWriter fileWriter = new FileWriter(creatFile);
				fileWriter.write("");
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}

		for (int i = 0; i < fileNameList.length; i++) {

			// �����ļ�������
			if (fileNameList[i] == "cmdStr.bat" || fileNameList[i] == "JavaCallBatFile.exe")
				fileNameList[i] = null;

			System.out.println(fileNameList[i]);
			try {

				// д��ָ��
				FileWriter cmdWriter = new FileWriter(creatFile, true); // ����׷������
				BufferedWriter bufferedWriter = new BufferedWriter(cmdWriter);
				bufferedWriter.append("attrib " + file.getAbsolutePath() + "\\" + fileNameList[i] + " -S" + " -H");
				bufferedWriter.newLine(); // ����
				bufferedWriter.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		for (int i = 0; i < 30; i++)
			System.out.print("�z");
		System.out.println();

		String exeFilePath = "";
		try {

			// ����Exe����
			File exeFile = new File("JavaCallBatFile.exe");
			FileInputStream fileCopy = new FileInputStream(exeFile);

			// ճ���ļ���batĿ¼��
			FileOutputStream filePaste = new FileOutputStream(fileList + "\\" + exeFile);
			exeFilePath = fileList + "\\" + exeFile;

			// �����ļ�����
			int n = 0;
			while ((n = fileCopy.read()) != -1) {
				filePaste.write(n);
			}

			// �ر��ļ���
			filePaste.flush();
			fileCopy.close();
			filePaste.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// �ȴ�3��
		System.out.println("�ȴ�3��");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// �����ⲿ����
		try {
			Runtime.getRuntime().exec(exeFilePath);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println("ִ�����");
	}
}
