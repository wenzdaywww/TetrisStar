package com.www.gamemodel;

import java.io.File;
import java.util.HashMap;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import javax.swing.JOptionPane;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.FileNotFoundException;
	/**
	 * �ļ���ȡд����
	 * @author wWw
	 *
	 */
public class RWScore {
	/**@see �ļ�����*/
	private File scoreFile;	
	/**@see ��ȡ�������*/
	private BufferedReader reader;	
	/**@see д�뻺�����*/
	private BufferedWriter writer;	
	/**@see �ļ�����������*/
	private FileInputStream fileInputStream;	
	/**@see �ļ����������*/
	private FileOutputStream fileOutputStream;	
	/**@see ��ȡ������*/
	private InputStreamReader inputStreamReader;	
	/**@see д�������*/
	private OutputStreamWriter outputStreamWriter;	
	/**@see ���ı���ȡ�����з������ݺ�Ļ��漯��*/
	private HashMap<Integer, String> scoreList=new HashMap<Integer, String>();	
	/**@see �������ģʽ�ķ������ݼ���*/
	public HashMap<Integer, String> simpleScoreList=new HashMap<Integer, String>();	
	/**@see �����м�ģʽ�ķ������ݼ���*/
	public HashMap<Integer, String> middleScoreList=new HashMap<Integer, String>();	
	/**@see ����߼�ģʽ�ķ������ݼ���*/
	public HashMap<Integer, String> seniorScoreList=new HashMap<Integer, String>();	
	/**@see �����̬ģʽ�ķ������ݼ���*/
	public HashMap<Integer, String> nonhumanScoreList=new HashMap<Integer, String>();	
	/**
	 * �����ļ������ж��ı��Ƿ����
	 */
	public RWScore() {
		scoreFile =new File("score.w");
		createScoreFile();
	}
	/**
	 * ��ȡ�ļ�����
	 */
	public void readerScore(){
		scoreList.clear();	//�����������
		if (scoreFile.exists()) {	//�ļ��������ȡ�ļ�
			int i=0;
			try {
				createInStream();	//����������
				String line;
				while ((line=reader.readLine())!=null) {	//�ȴ��ļ����ݶ�ȡ���
					scoreList.put(i++, line);	//����д�뼯����
				}
				reader.close();	//�ر�������
				inputStreamReader.close();
				fileInputStream.close();
				scoreGroup();	//�������ͷ���
			} catch (IOException e) {
				JOptionPane.showConfirmDialog(null, "�޷����ļ���ȡ��", "��ʾ", JOptionPane.CLOSED_OPTION);
			}
		}else {	//�ļ��������򴴽��ļ�
			createScoreFile();
			readerScore();
		}
	}
	/**
	 * �����յ������ݷ�����ڲ�ͬ�ļ�����
	 */
	private void scoreGroup(){
		try {
			int i=0; int j=0; int k=0; int z=0;
			simpleScoreList.clear();	//�����������
			middleScoreList.clear();
			seniorScoreList.clear();
			nonhumanScoreList.clear();
			for (int x = 0; x < scoreList.size(); x++) {
				if (scoreList.get(x).substring(scoreList.get(x).indexOf("Model:")+6, scoreList.get(x).indexOf("Score:")).equals("����ģʽ")) {
					simpleScoreList.put(i++, scoreList.get(x));	//���ճ���ģʽ��ҵ�����
				}else if (scoreList.get(x).substring(scoreList.get(x).indexOf("Model:")+6, scoreList.get(x).indexOf("Score:")).equals("�м�ģʽ")) {
					middleScoreList.put(j++, scoreList.get(x));	//�����м�ģʽ���������
				}else if (scoreList.get(x).substring(scoreList.get(x).indexOf("Model:")+6, scoreList.get(x).indexOf("Score:")).equals("�߼�ģʽ")) {
					seniorScoreList.put(k++, scoreList.get(x));	//���ո߼�ģʽ���������
				}else if (scoreList.get(x).substring(scoreList.get(x).indexOf("Model:")+6, scoreList.get(x).indexOf("Score:")).equals("��̬ģʽ")) {
					nonhumanScoreList.put(z++, scoreList.get(x));	//���ձ�̬ģʽ���������
				}
			}
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "�ļ����������ӸĶ����뱨��������", "��ʾ", JOptionPane.CLOSED_OPTION);
		}
	}
	/**
	 * д�����ݵ��ı���
	 *1�������Ϻ󲻹ر���������޷���txt��д������
	 *2�������Ϻ�ֻ�ر�����������¸�ֵ��������ֻ��д��һ��
	 *3�����¸�ֵ�������������ٹر����������д��û������
	 */
	public void writeScore(String str){
		if (scoreFile.exists()) {	//�ļ�������д������
			try {
				createOutStream();	//���������
				writer.write(str+"\n");	//д������
				writer.close();	//�ر������
				outputStreamWriter.close();
				fileOutputStream.close();
			} catch (IOException e) {
				JOptionPane.showConfirmDialog(null, "�޷����ļ�д�룡", "��ʾ", JOptionPane.CLOSED_OPTION);
			}
		}else {	//�ļ��������򴴽��ļ�
			createScoreFile();
			writeScore(str);
		}
	}
	/**
	 * ������������ð������
	 * 1������������뱣֤���һ��Ϊ�գ���ֻ�������һ�в���Ϊ��
	 */
	public void scoreRank(){
		readerScore();	//��ȡ�ı�����
		for (int i = 0; i < scoreList.size() -1; i++){    //ð�����������n-1������  
			for(int j = 0 ;j < scoreList.size()-i-1; j++){   
				int x=Integer.parseInt(scoreList.get(j).substring(scoreList.get(j).indexOf("Score:")+6, scoreList.get(j).length()));
				int y=Integer.parseInt(scoreList.get(j+1).substring(scoreList.get(j+1).indexOf("Score:")+6, scoreList.get(j+1).length()));
				if(x<y){ 
					String temp=scoreList.get(j);
					scoreList.put(j, scoreList.get(j+1));
					scoreList.put(j+1, temp);
				}  
			}   
		}
		scoreFile.delete();	//ɾ���ļ�
		createScoreFile();	//���´����ļ�
		for (int i = 0; i < scoreList.size(); i++) {
			writeScore(scoreList.get(i)); 	//����д������
		}
	}
	/**
	 * �ļ��������򴴽��ļ�
	 */
	private void createScoreFile(){
		if (!scoreFile.exists()) {
			try {
				scoreFile.createNewFile();
			} catch (IOException e) {
				JOptionPane.showConfirmDialog(null, "�޷������ļ���", "��ʾ", JOptionPane.CLOSED_OPTION);
			}
		}
	}
	/**
	 * �ļ����ڴ���������
	 */
	private void createInStream(){
		if (scoreFile.exists()) {
			try {
				fileInputStream=new FileInputStream(scoreFile);	//�����ļ�����������
				inputStreamReader=new InputStreamReader(fileInputStream);//��������������
				reader=new BufferedReader(inputStreamReader);	//������ȡ�������
			} catch (FileNotFoundException e) {
				JOptionPane.showConfirmDialog(null, "�޷�������������", "��ʾ", JOptionPane.CLOSED_OPTION);
			}
		}
	}
	/**
	 * �ļ����ڴ��������
	 */
	private void createOutStream(){
		if (scoreFile.exists()) {
			try {
				fileOutputStream=new FileOutputStream(scoreFile,true);	//�����ļ����������
				outputStreamWriter=new OutputStreamWriter(fileOutputStream);	//�������������
				writer=new BufferedWriter(outputStreamWriter);	//����д�뻺�����
			} catch (FileNotFoundException e) {
				JOptionPane.showConfirmDialog(null, "�޷������������", "��ʾ", JOptionPane.CLOSED_OPTION);
			}
		}
	}
}
