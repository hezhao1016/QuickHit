package com.accp.ch5;

import java.util.Scanner;

/**
 * �����
 * @author ACCP7.0
 *
 */
public class Player {
	/**
	 * ��ǰ�����
	 */
	private int levelNo;
	/**
	 * ��һ���
	 */
	private int currScore;
	/**
	 * ��ǰ�ؿ���ʼʱ��
	 */
	private long startTime;
	/**
	 * ��ǰ�ؿ�����ʱ��
	 */
	private long elapsedTime;
	/**
	 * ���˼��Σ������ʱ�Ĵ�������2�ξ��˳���Ϸ
	 */
	private int overCount ;
	
	public int getOverCount() {
		return overCount;
	}
	public void setOverCount(int overCount) {
		this.overCount = overCount;
	}
	public int getLevelNo() {
		return levelNo;
	}
	public void setLevelNo(int levelNo) {
		this.levelNo = levelNo;
	}
	public int getCurrScore() {
		return currScore;
	}
	public void setCurrScore(int currScore) {
		this.currScore = currScore;
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getElapsedTime() {
		return elapsedTime;
	}
	public void setElapsedTime(long elapsedTime) {
		this.elapsedTime = elapsedTime;
	}
	/**
	 * �������Ϸ
	 */
	public void play(){
		//��ʼ�������ؿ���Ϊ1����ʼʱ��Ϊ��ǰʱ��
		this.levelNo = 1;
		long startTime =  System.currentTimeMillis();
		this.startTime =startTime;
		Game game = new Game(this);//��Ϸ����
		Scanner input = new Scanner(System.in); 
		//�������漸��
		for (int i = 1; i <= LevelParam.levels.length; i++) {
			//����ʼʱ�����
			this.startTime = System.currentTimeMillis();
			//��ǰ�ؿ��漸��
			int count = LevelParam.levels[this.levelNo-1].getStrCount();
			//�ڲ���Ƶ�ǰ�ؿ�������
			for (int j = 1; j <= count; j++) {
				//����Ϸ
				String out = game.printStr();
				System.out.println(out);
				String in = input.next();
				if(!game.printResult(out, in)){
					long endTime = System.currentTimeMillis();//����ʱ��
					System.out.println("���Ļ�����"+this.currScore+",�������"+((endTime-startTime)/1000)+"�롣");
					return;
				}
			}
			this.levelNo++;
		}
		long endTime = System.currentTimeMillis();//����ʱ��
		System.out.println("��ϲ�����سɹ����������Ļ�����"+this.currScore+",������"+((endTime-startTime)/1000)+"�롣");
	}
}
