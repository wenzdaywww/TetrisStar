package com.www.gamemodel;

import com.www.gameview.BlockPanel;
	/**
	 * ���������
	 * @author wWw
	 *
	 */
public class BaseShape{
	/**@see ���鴦����һ����̬*/
	protected int whichTime=0;		
	/**@see ��Ϸ����״̬,trueΪ��Ϸ������falseΪ��Ϸ��*/
	public boolean gameOver;		
	/**@see trueΪը����falseΪ��������*/
	public boolean isBomb=false;	
	/**@see ��������ͼƬ*/
	protected String shapeImage;	
	/**@see ����Ϊ����ĸ�����ֵΪX����*/
	public int[] shapeX=new int[7];	
	/**@see ����Ϊ����ĸ�����ֵΪY����*/
	public int[] shapeY=new int[7];	
	/**@see �����Ƿ񵽵ף�falseΪ����*/
	protected boolean canMove=true;	
	/**@see ��������Ķ���*/
	protected BlockPanel blockPanel;
	/**
	 * �����ʼ��
	 */
	public void init(){}	
	/**
	 * ��������
	 */
	public void left(){}	
	/**
	 * ��������
	 */
	public void right(){}
	/**
	 * ��������
	 */
	public void down(){}
	/**
	 * ������ת
	 */
	public void rotate(){}	
	/**
	 * �жϷ����Ƿ񵽵�
	 * @return falseΪ���ײ���trueΪ�ƶ���
	 */
	public boolean isCanMove(){
		return canMove;
	}
	/**
	 * ���õ��ױ�־
	 * @param canMove falseΪ���ײ���trueΪ���ƶ�
	 */
	public void setCanMove(boolean canMove){
		this.canMove=canMove;
	}
	/**
	 * ��ȡ��Ϸ״̬
	 * @return ��Ϸ״̬��trueΪ��Ϸ������falseΪ��Ϸ��
	 */
	public boolean isGameOver(){
		return gameOver;
	}
	/**
	 * ��Ϸ��������������
	 * @param gameOver	������Ϸ״̬��trueΪ��Ϸ������falseΪ�ɿ�ʼ����Ϸ
	 */
	public void setGameOverToRestart(boolean gameOver){
		this.gameOver=gameOver;
	}
	/**
	 * ���÷���ͼƬ
	 * @param shapeImage ͼƬ����Ե�ַ
	 */
	public void setImage(String shapeImage) {
		this.shapeImage=shapeImage;
	}
	/**
	 * x,y����ת�������
	 * @param x	�����X����
	 * @param y	�����Y����
	 * @return	���ط������
	 */
	protected int shapeXYToInt(int x,int y){
		return GridBlock.shapeXYToInt(x, y);
	}
	/**
	 * ���÷����ʼͼƬ
	 */
	protected void setInitImage(){
		for (int i = 0; i < 4; i++) {
			GridBlock.xyList.get(shapeXYToInt(shapeX[i], shapeY[i])).setImage(shapeImage);
		}
	}
	/**
	 * ���ط��鲻�ɼ�
	 */
	protected void notDraw(){
		for (int i = 0; i < 4; i++) {
			GridBlock.xyList.get(shapeXYToInt(shapeX[i], shapeY[i])).setDraw(false);
		}
	}
	/**
	 * ���÷���ɼ�
	 */
	protected void canDraw(){
		for (int i = 0; i < 4; i++) {
			GridBlock.xyList.get(shapeXYToInt(shapeX[i], shapeY[i])).setDraw(true);
		}
	}
	/**
	 * ���÷��鵽�ײ�Ϊ�ײ�����
	 */
	protected void bottomBlock() {
		for (int i = 0; i < 4; i++) {
			GridBlock.xyList.get(shapeXYToInt(shapeX[i], shapeY[i])).setBottomBlock(true);;
		}
	}
	/**
	 * �ж�ÿ�η��������Ϸ�Ƿ����
	 * @return �ж��Ƿ���Ϸ������trueΪ��Ϸ������falseΪ��Ϸ�� 
	 */
	public boolean initGameOver(){
		if (GridBlock.xyList.get(shapeXYToInt(shapeX[0], shapeY[0])).isDraw()||	//�����ʼ���ֵ�λ���з����赲����Ϸ����
				GridBlock.xyList.get(shapeXYToInt(shapeX[1], shapeY[1])).isDraw()||
				GridBlock.xyList.get(shapeXYToInt(shapeX[2], shapeY[2])).isDraw()||
				GridBlock.xyList.get(shapeXYToInt(shapeX[3], shapeY[3])).isDraw()) {
			return true;
		}else {
			return false;
		}
	}
}
