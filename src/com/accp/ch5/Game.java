package com.accp.ch5;

import java.util.Random;

/**
 * ��Ϸ��
 * @author ACCP7.0
 *
 */
public class Game {
	private Player player;//��ǰ���
	
	public Game(Player p){
		this.player = p;
	}
	
	/**
	 * ��������ַ�
	 * @return
	 */
	public String printStr(){
		//��ǰ��Ҽ���
		int levelNo = this.player.getLevelNo();
		//Ҫ���ɵ��ַ�����
		int strLength = LevelParam.levels[levelNo-1].getStrLength();
		String [] strs = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","1","2","3","4","5","6","7","8","9","-","_","=","+",";",":","'","\"",",",".","<",">","/","?","`","~","[","]","{","}","\\","|","!","@","#","$","%","^","&","*","(",")"};
		String gameStr = "";
		//ѭ�������ַ�
		for (int i = 0; i < strLength; i++) {
			//�����
			Random r = new Random();
			int randInt = r.nextInt(strs.length);
			//int randWord = randInt+97;
			//������ת����char��a = 97��z = 122��
			//gameStr += (char)randWord;
			gameStr += strs[randInt];
		}
		return gameStr;
	}
	/**
	 * ��֤�������
	 * @param out
	 * @param in
	 * @return boolean
	 */
	public boolean printResult(String out,String in){
		//��ǰ��Ҽ���
		int levelNo = this.player.getLevelNo();
		//��ǰ�ؿ�ʱ������
		int timeLimit = LevelParam.levels[levelNo-1].getTimeLimit()*1000;
		//��ǰ�ؿ���ʼʱ��
		long startTime = this.player.getStartTime();
		//����ʱ��
		long usedTime = System.currentTimeMillis()-startTime;
		this.player.setElapsedTime(usedTime/1000);
		//���������ȷ
		if (out.equals(in)) {
			//���û��ʱ
			if (usedTime<=timeLimit) {
				//����Ҽӷ�
				this.player.setCurrScore(this.player.getCurrScore()+LevelParam.levels[levelNo-1].getPerScore());
				System.out.println("������ȷ�����ļ�����"+this.player.getLevelNo()+"�����Ļ�����"+this.player.getCurrScore()+"������ʱ��"+this.player.getElapsedTime()+"�롣");
				return true;
			}else {
			//�����ʱ
				this.player.setOverCount(this.player.getOverCount()+1);//over������1
				//�����ʱ��������2�����˳���Ϸ
				if (this.player.getOverCount()>=2) {
					System.out.print("������̫���ˣ��Ѿ���ʱ����Ϸ������");
					//System.exit(1); //�˳�Java�����
					return false;
				}else {
					System.out.println("������̫���ˡ��㻹��"+(3-this.player.getOverCount())+"�λ��ᣡ");
					return true;
				}
				
			}
		}else {
		//����������
			this.player.setOverCount(this.player.getOverCount()+1);//over������1
			//�����������������2�����˳���Ϸ
			if (this.player.getOverCount()>2) {
				System.out.print("������˼����������������Ϸ������");
				//System.exit(1); //�˳�Java�����
				return false;
			}else {
				System.out.println("�������������㻹��"+(3-this.player.getOverCount())+"�λ��ᣡ");
				return true;
			}
		}
	}
}
