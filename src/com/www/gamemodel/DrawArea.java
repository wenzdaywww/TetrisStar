package com.www.gamemodel;
	/**
	 * �������λ����
	 * @author wWw
	 *
	 */
public class DrawArea {
	/**@see �������������x����*/
	private int x;			
	/**@see �������������y����*/
	private int y;			
	/**@see ��������Ҫ��ʾ��ͼƬ��Ե�ַ*/
	private String image;	
	/**@see ���������Ƿ��з�����ʾ*/
	private boolean isDraw;	
	/**@see ���������ѵ���ײ��ķ��飬trueΪ�ײ�����*/
	private boolean isBottomBlock;	
	/**
	 * @param x	Ҫ����x����
	 * @param y	Ҫ����y����
	 * @param isDraw	�Ƿ��з��飬trueΪ�з��飬falseΪû�з���
	 * @param image		Ҫ����ͼƬ
	 * @param isBottomBlock ���������еķ��� ��trueΪ�ײ����飬falseΪ�ƶ��еķ��� 
	 */
	public DrawArea(int x,int y,boolean isDraw,String image,boolean isBottomBlock){
		this.x=x;
		this.y=y;
		this.image=image;
		this.isDraw=isDraw;
		this.isBottomBlock=isBottomBlock;
	}
	/**
	 * ����X����
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * ����Y����
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * ��ȡX����
	 * @return X����
	 */
	public int getX() {
		return x;
	}
	/**
	 * ��ȡY����
	 * @return Y����
	 */
	public int getY() {
		return y;
	}
	/**
	 * ��ȡ�Ƿ��з���
	 * @return trueΪ�з��飬falseΪû�з���
	 */
	public boolean isDraw() {
		return isDraw;
	}
	/**
	 * �����Ƿ��������޷���
	 * @param isDraw trueΪ�з��飬falseΪû�з���
	 */
	public void setDraw(boolean isDraw) {
		this.isDraw = isDraw;
	}
	/**
	 * ��������ͼƬ
	 * @param image	ͼƬ����Ե�ַ
	 */
	public void setImage(String image){
		this.image=image;
	}
	/**
	 * ��ȡͼƬ����Ե�ַ
	 */
	public String getImage(){
		return image;
	}
	/**
	 * ��ȡ�ǲ��ǵײ�����
	 */
	public boolean isBottomBlock() {
		return isBottomBlock;
	}
	/**
	 * ��ȡ���÷����ǲ��ǵײ�
	 */
	public void setBottomBlock(boolean isBottomBlock) {
		this.isBottomBlock = isBottomBlock;
	}
	
}
