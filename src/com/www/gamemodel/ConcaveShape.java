package com.www.gamemodel;

	/**
	 * ���η�����
	 * @author wWw
	 *
	 */
public class ConcaveShape extends BaseShape {
	/**
	 * ���η��鹹�췽���������������� ����
	 * @param GridBlock �������� ����
	 */
	public ConcaveShape() {
	}
	/**
	 * ��ʼ�����η���λ��
	 */
	@Override
	public void init() {
		whichTime=0;	//���ð��η���ĳ�ʼ��̬��־����̬0����̬4һ��
		canMove=true;	//���ÿ����ƶ�
		shapeX[0]=9;shapeY[0]=3;	//���ð��γ�ʼλ��
		shapeX[1]=7;shapeY[1]=3;
		shapeX[2]=9;shapeY[2]=2;
		shapeX[3]=7;shapeY[3]=2;
		shapeX[4]=9;shapeY[4]=1;
		shapeX[5]=8;shapeY[5]=1;
		shapeX[6]=7;shapeY[6]=1;
	}
	/**
	 * ���η�������
	 */
	@Override
	public void left() {
		notDraw();
		if (canMove) {
			switch (whichTime) {
			case 0:	//��ʼλ�õ������������ƶ�
				if ((shapeX[1]!=1)&&(GridBlock.xyList.get(shapeXYToInt((shapeX[1]-1), shapeY[1])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[3]-1), shapeY[3])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[0]-1), shapeY[0])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[2]-1), shapeY[2])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[6]-1), shapeY[6])).isDraw()==false)) {
					shapeX[0]-=1;shapeX[1]-=1;shapeX[2]-=1;shapeX[3]-=1;shapeX[4]-=1;shapeX[5]-=1;shapeX[6]-=1;
				}
				break;
			case 1:	//��̬1�������������ƶ�
				if ((shapeX[1]!=1) &&(GridBlock.xyList.get(shapeXYToInt((shapeX[1]-1), shapeY[1])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[5]-1), shapeY[5])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[0]-1), shapeY[0])).isDraw()==false)) {
					shapeX[0]-=1;shapeX[1]-=1;shapeX[2]-=1;shapeX[3]-=1;shapeX[4]-=1;shapeX[5]-=1;shapeX[6]-=1;
				}
				break;
			case 2:	//��̬2�������������ƶ�
				if ((shapeX[0]!=1)&&(GridBlock.xyList.get(shapeXYToInt((shapeX[0]-1), shapeY[0])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[2]-1), shapeY[2])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[1]-1), shapeY[1])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[3]-1), shapeY[3])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[4]-1), shapeY[4])).isDraw()==false)) {
					shapeX[0]-=1;shapeX[1]-=1;shapeX[2]-=1;shapeX[3]-=1;shapeX[4]-=1;shapeX[5]-=1;shapeX[6]-=1;
				}
				break;
			case 3:	//��̬3�������������ƶ�
				if ((shapeX[4]!=1)&&(GridBlock.xyList.get(shapeXYToInt((shapeX[4]-1), shapeY[4])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[5]-1), shapeY[5])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[6]-1), shapeY[6])).isDraw()==false)) {
					shapeX[0]-=1;shapeX[1]-=1;shapeX[2]-=1;shapeX[3]-=1;shapeX[4]-=1;shapeX[5]-=1;shapeX[6]-=1;
				}
				break;
			case 4:	//��̬4�������������ƶ�
				if ((shapeX[1]!=1)&&(GridBlock.xyList.get(shapeXYToInt((shapeX[1]-1), shapeY[1])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[3]-1), shapeY[3])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[0]-1), shapeY[0])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[2]-1), shapeY[2])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[6]-1), shapeY[6])).isDraw()==false)) {
					shapeX[0]-=1;shapeX[1]-=1;shapeX[2]-=1;shapeX[3]-=1;shapeX[4]-=1;shapeX[5]-=1;shapeX[6]-=1;
				}
				break;
			default:
				break;
			}
		}
		setInitImage();
		canDraw();
	}
	/**
	 * ���η��������
	 */
	@Override
	public void right() {
		notDraw();
		if (canMove) {
			switch (whichTime) {
			case 0:	//��̬0�������������ƶ�
				if ((shapeX[0]!=GridBlock.COL)&&(GridBlock.xyList.get(shapeXYToInt((shapeX[1]+1), shapeY[1])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[3]+1), shapeY[3])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[0]+1), shapeY[0])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[2]+1), shapeY[2])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[4]+1), shapeY[4])).isDraw()==false)) {
					shapeX[0]+=1;shapeX[1]+=1;shapeX[2]+=1;shapeX[3]+=1;shapeX[4]+=1;shapeX[5]+=1;shapeX[6]+=1;
				}
				break;
			case 1:	//��̬1�������������ƶ�
				if ((shapeX[5]!=GridBlock.COL) &&(GridBlock.xyList.get(shapeXYToInt((shapeX[4]+1), shapeY[4])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[5]+1), shapeY[5])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[6]+1), shapeY[6])).isDraw()==false)) {
					shapeX[0]+=1;shapeX[1]+=1;shapeX[2]+=1;shapeX[3]+=1;shapeX[4]+=1;shapeX[5]+=1;shapeX[6]+=1;
				}
				break;
			case 2:	//��̬2�������������ƶ�
				if ((shapeX[1]!=GridBlock.COL)&&(GridBlock.xyList.get(shapeXYToInt((shapeX[1]+1), shapeY[1])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[3]+1), shapeY[3])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[6]+1), shapeY[6])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[2]+1), shapeY[2])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[0]+1), shapeY[0])).isDraw()==false)) {
					shapeX[0]+=1;shapeX[1]+=1;shapeX[2]+=1;shapeX[3]+=1;shapeX[4]+=1;shapeX[5]+=1;shapeX[6]+=1;
				}
				break;	
			case 3:	//��̬3�������������ƶ�
				if ((shapeX[0]!=GridBlock.COL)&&(GridBlock.xyList.get(shapeXYToInt((shapeX[0]+1), shapeY[0])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[5]+1), shapeY[5])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[1]+1), shapeY[1])).isDraw()==false)) {
					shapeX[0]+=1;shapeX[1]+=1;shapeX[2]+=1;shapeX[3]+=1;shapeX[4]+=1;shapeX[5]+=1;shapeX[6]+=1;
				}
				break;
			case 4:	//��̬4�������������ƶ�
				if ((shapeX[0]!=GridBlock.COL)&&(GridBlock.xyList.get(shapeXYToInt((shapeX[1]+1), shapeY[1])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[3]+1), shapeY[3])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[0]+1), shapeY[0])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[2]+1), shapeY[2])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[4]+1), shapeY[4])).isDraw()==false)) {
					shapeX[0]+=1;shapeX[1]+=1;shapeX[2]+=1;shapeX[3]+=1;shapeX[4]+=1;shapeX[5]+=1;shapeX[6]+=1;
				}
				break;
			default:
				break;
			}
		}
		setInitImage();
		canDraw();
	}
	/**
	 * ���η��������
	 */
	@Override
	public void down() {
		notDraw();
		if (canMove) {
			switch (whichTime) {
			case 0:	//ʹ��ʼλ���ڵ�һ��
				whichTime=4;
				canDraw();
				break;
			case 1:	
				if ((shapeY[2]!=GridBlock.ROW)&&(GridBlock.xyList.get(shapeXYToInt(shapeX[0], (shapeY[0]+1))).isBottomBlock()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[0], (shapeY[0]+1))).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[2], (shapeY[2]+1))).isBottomBlock()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[2], (shapeY[2]+1))).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[4], (shapeY[4]+1))).isBottomBlock()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[4], (shapeY[4]+1))).isDraw()==false)) {	//��̬1�������������ƶ�
					shapeY[0]+=1;shapeY[1]+=1;shapeY[2]+=1;shapeY[3]+=1;shapeY[4]+=1;shapeY[5]+=1;shapeY[6]+=1;
				}else if ((shapeY[2]==GridBlock.ROW)||(GridBlock.xyList.get(shapeXYToInt(shapeX[0], (shapeY[0]+1))).isBottomBlock())||
						(GridBlock.xyList.get(shapeXYToInt(shapeX[2], (shapeY[2]+1))).isBottomBlock())||
						(GridBlock.xyList.get(shapeXYToInt(shapeX[4], (shapeY[4]+1))).isBottomBlock())){	//��̬1�ĵ��׵�����
					canMove=false;
					bottomBlock();
				}
				break;
			case 2:
				if ((shapeY[5]!=GridBlock.ROW)&&(GridBlock.xyList.get(shapeXYToInt(shapeX[4], (shapeY[4]+1))).isBottomBlock()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[4], (shapeY[4]+1))).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[5], (shapeY[5]+1))).isBottomBlock()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[5], (shapeY[5]+1))).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[6], (shapeY[6]+1))).isBottomBlock()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[6], (shapeY[6]+1))).isDraw()==false)) {	//��̬2�������������ƶ�
					shapeY[0]+=1;shapeY[1]+=1;shapeY[2]+=1;shapeY[3]+=1;shapeY[4]+=1;shapeY[5]+=1;shapeY[6]+=1;
				}else if ((shapeY[5]==GridBlock.ROW)||(GridBlock.xyList.get(shapeXYToInt(shapeX[4], (shapeY[4]+1))).isBottomBlock())||
						(GridBlock.xyList.get(shapeXYToInt(shapeX[5], (shapeY[5]+1))).isBottomBlock())||
						(GridBlock.xyList.get(shapeXYToInt(shapeX[6], (shapeY[6]+1))).isBottomBlock())) {	//��̬2�ĵ�������
					canMove=false;
					bottomBlock();
				}
				break;
			case 3:	
				if ((shapeY[3]!=GridBlock.ROW)&&(GridBlock.xyList.get(shapeXYToInt(shapeX[1], (shapeY[1]+1))).isBottomBlock()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[1], (shapeY[1]+1))).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[3], (shapeY[3]+1))).isBottomBlock()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[3], (shapeY[3]+1))).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[6], (shapeY[6]+1))).isBottomBlock()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[6], (shapeY[6]+1))).isDraw()==false)) {	//��̬3�������������ƶ�
					shapeY[0]+=1;shapeY[1]+=1;shapeY[2]+=1;shapeY[3]+=1;shapeY[4]+=1;shapeY[5]+=1;shapeY[6]+=1;
				}else if ((shapeY[3]==GridBlock.ROW)||(GridBlock.xyList.get(shapeXYToInt(shapeX[1], (shapeY[1]+1))).isBottomBlock())||
						(GridBlock.xyList.get(shapeXYToInt(shapeX[3], (shapeY[3]+1))).isBottomBlock())||
						(GridBlock.xyList.get(shapeXYToInt(shapeX[6], (shapeY[6]+1))).isBottomBlock())) {	//��̬3�ĵ�������
					canMove=false;
					bottomBlock();
				}
				break;
			case 4:
				if ((shapeY[1]!=GridBlock.ROW)&&(GridBlock.xyList.get(shapeXYToInt(shapeX[1], (shapeY[1]+1))).isBottomBlock()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[1], (shapeY[1]+1))).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[5], (shapeY[5]+1))).isBottomBlock()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[5], (shapeY[5]+1))).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[0], (shapeY[0]+1))).isBottomBlock()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[0], (shapeY[0]+1))).isDraw()==false)) {	//��̬4�������������ƶ�
					shapeY[0]+=1;shapeY[1]+=1;shapeY[2]+=1;shapeY[3]+=1;shapeY[4]+=1;shapeY[5]+=1;shapeY[6]+=1;
				}else if ((shapeY[1]==GridBlock.ROW)||(GridBlock.xyList.get(shapeXYToInt(shapeX[1], (shapeY[1]+1))).isBottomBlock()==false)||
						(GridBlock.xyList.get(shapeXYToInt(shapeX[5], (shapeY[5]+1))).isBottomBlock()==false)||
						(GridBlock.xyList.get(shapeXYToInt(shapeX[0], (shapeY[0]+1))).isBottomBlock()==false)){	//��̬4�ĵ�������
					canMove=false;
					bottomBlock();
				}
				break;
			default:
				break;
			}
		}
		setInitImage();
		canDraw();
	}
	/**
	 * ���η������ת
	 */
	@Override
	public void rotate() {
		notDraw();
		if (canMove) {
			switch (whichTime) {
			case 0:	//��̬0/4��ת����̬1
				fourToOne();
				break;
			case 1:	//��̬1��ת����̬2
				oneToTwo();
				break;
			case 2:	//��̬2��ת����̬3
				twoToThree();
				break;
			case 3:	//��̬3��ת����̬4
				threeToFour();
				break;
			case 4:	//��̬4��ת����̬1
				fourToOne();
				break;
			default:
				break;
			}
		}
		setInitImage();
		canDraw();
	}
	/**
	 * ��������̬1
	 */
	private void fourToOne(){
		if ((GridBlock.xyList.get(shapeXYToInt((shapeX[0]-1), shapeY[0])).isDraw()==false)) {	//��ת����
			whichTime=1;
			shapeX[0]-=2;
			shapeY[1]-=2;
			shapeX[2]-=1;shapeY[2]+=1;
			shapeX[3]+=1;shapeY[3]-=1;
			shapeY[4]+=2;
			shapeX[5]+=1;shapeY[5]+=1;
			shapeX[6]+=2;
		}
	}
	/**
	 * ��������̬2
	 */
	private void oneToTwo(){
		if ((GridBlock.xyList.get(shapeXYToInt(shapeX[0], shapeY[0]-1)).isDraw()==false)) {	//��ת����
			whichTime=2;
			shapeY[0]-=2;
			shapeX[1]+=2;
			shapeX[2]-=1;shapeY[2]-=1;
			shapeX[3]+=1;shapeY[3]+=1;
			shapeX[4]-=2;
			shapeX[5]-=1;shapeY[5]+=1;
			shapeY[6]+=2;
		}
	}
	/**
	 * ��������̬3
	 */
	private void twoToThree(){
		if ((GridBlock.xyList.get(shapeXYToInt((shapeX[0]+1), shapeY[0])).isDraw()==false)) {	//��ת����
			whichTime=3;
			shapeX[0]+=2;
			shapeY[1]+=2;
			shapeX[2]+=1;shapeY[2]-=1;
			shapeX[3]-=1;shapeY[3]+=1;
			shapeY[4]-=2;
			shapeX[5]-=1;shapeY[5]-=1;
			shapeX[6]-=2;
		}
	}
	/**
	 * ��������̬4
	 */
	private void threeToFour(){
		if ((GridBlock.xyList.get(shapeXYToInt(shapeX[0], (shapeY[0]+1))).isDraw()==false)) {	//��ת����
			whichTime=4;
			shapeY[0]+=2;
			shapeX[1]-=2;
			shapeX[2]+=1;shapeY[2]+=1;
			shapeX[3]-=1;shapeY[3]-=1;
			shapeX[4]+=2;
			shapeX[5]+=1;shapeY[5]-=1;
			shapeY[6]-=2;
		}
	}
	/**
	 * ��ʼ�����η����ͼƬ
	 */
	@Override
	protected void setInitImage() {
		for (int i = 0; i < 7; i++) {
			GridBlock.xyList.get(shapeXYToInt(shapeX[i], shapeY[i])).setImage(shapeImage);
		}
	}
	/**
	 * ���η����ƶ�ǰ���ɼ�
	 */
	@Override
	protected void notDraw() {
		for (int i = 0; i < 7; i++) {
			GridBlock.xyList.get(shapeXYToInt(shapeX[i], shapeY[i])).setDraw(false);
		}
	}
	/**
	 * ���η����ƶ���ɼ�
	 */
	@Override
	protected void canDraw() {
		for (int i = 0; i < 7; i++) {
			GridBlock.xyList.get(shapeXYToInt(shapeX[i], shapeY[i])).setDraw(true);
		}
	}
	/**
	 * ���η��鵽�׺���Ϊ�ײ�����
	 */
	@Override
	protected void bottomBlock() {
		for (int i = 0; i < 7; i++) {
			GridBlock.xyList.get(shapeXYToInt(shapeX[i], shapeY[i])).setBottomBlock(true);
		}
	}
	/**
	 * ���η���ÿ�γ����ж���Ϸ�Ƿ����
	 */
	@Override
	public boolean initGameOver() {
		if (GridBlock.xyList.get(shapeXYToInt(shapeX[0], shapeY[0])).isDraw()||
				GridBlock.xyList.get(shapeXYToInt(shapeX[1], shapeY[1])).isDraw()||
				GridBlock.xyList.get(shapeXYToInt(shapeX[2], shapeY[2])).isDraw()||
				GridBlock.xyList.get(shapeXYToInt(shapeX[3], shapeY[3])).isDraw()||
				GridBlock.xyList.get(shapeXYToInt(shapeX[4], shapeY[4])).isDraw()||
				GridBlock.xyList.get(shapeXYToInt(shapeX[5], shapeY[5])).isDraw()||
				GridBlock.xyList.get(shapeXYToInt(shapeX[6], shapeY[6])).isDraw()) {
			return true;
		}else {
			return false;
		}
	}
}
