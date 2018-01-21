package com.www.gamemodel;

	/**
	 * ��L�η�����
	 * @author wWw
	 *
	 */
public class RightLShape extends BaseShape{
	/**
	 * ��L�η��鹹�췽�������������������
	 * @param GridBlock
	 */
	public RightLShape() {
	}
	/**
	 * ��L�����ʼ��
	 */
	@Override
	public void init(){
		whichTime=0;	//��L�������̬0
		canMove=true;	//���ÿ����ƶ�
		shapeX[0]=9;shapeY[0]=1;	//��L���������
		shapeX[1]=9;shapeY[1]=2;
		shapeX[2]=8;shapeY[2]=2;
		shapeX[3]=7;shapeY[3]=2;
	}
	/**
	 * ��L���������
	 */
	@Override
	public void left(){
		notDraw();
		if (canMove) {
			switch (whichTime) {
			case 0:	//��̬0�������������ƶ�
				if ((shapeX[3]!=1)&&(GridBlock.xyList.get(shapeXYToInt((shapeX[0]-1), shapeY[0])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[3]-1), shapeY[3])).isDraw()==false)) {
					shapeX[0]-=1;shapeX[1]-=1;shapeX[2]-=1;shapeX[3]-=1;
				}
				break;
			case 1:	//��̬1�������������ƶ�
				if ((shapeX[2]!=1) &&(GridBlock.xyList.get(shapeXYToInt((shapeX[1]-1), shapeY[1])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[2]-1), shapeY[2])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[3]-1), shapeY[3])).isDraw()==false)) {
					shapeX[0]-=1;shapeX[1]-=1;shapeX[2]-=1;shapeX[3]-=1;
				}
				break;
			case 2:	//��̬2�������������ƶ�
				if ((shapeX[1]!=1)&&(GridBlock.xyList.get(shapeXYToInt((shapeX[0]-1), shapeY[0])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[1]-1), shapeY[1])).isDraw()==false)) {
					shapeX[0]-=1;shapeX[1]-=1;shapeX[2]-=1;shapeX[3]-=1;
				}
				break;
			case 3:	//��̬3�������������ƶ�
				if ((shapeX[0]!=1)&&(GridBlock.xyList.get(shapeXYToInt((shapeX[0]-1), shapeY[0])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[2]-1), shapeY[2])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[3]-1), shapeY[3])).isDraw()==false)) {
					shapeX[0]-=1;shapeX[1]-=1;shapeX[2]-=1;shapeX[3]-=1;
				}
				break;
			case 4:	//��̬4�������������ƶ�
				if ((shapeX[3]!=1)&&(GridBlock.xyList.get(shapeXYToInt((shapeX[0]-1), shapeY[0])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[3]-1), shapeY[3])).isDraw()==false)) {
					shapeX[0]-=1;shapeX[1]-=1;shapeX[2]-=1;shapeX[3]-=1;
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
	 * ��L���������
	 */
	@Override
	public void right(){
		notDraw();
		if (canMove) {
			switch (whichTime) {
			case 0:	//��̬0�������������ƶ�
				if ((shapeX[1]!=GridBlock.COL)&&(GridBlock.xyList.get(shapeXYToInt((shapeX[0]+1), shapeY[0])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[1]+1), shapeY[1])).isDraw()==false)) {
					shapeX[0]+=1;shapeX[1]+=1;shapeX[2]+=1;shapeX[3]+=1;
				}
				break;
			case 1:	//��̬1�������������ƶ�
				if ((shapeX[0]!=GridBlock.COL)&&(GridBlock.xyList.get(shapeXYToInt((shapeX[0]+1), shapeY[0])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[2]+1), shapeY[2])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[3]+1), shapeY[3])).isDraw()==false)) {
					shapeX[0]+=1;shapeX[1]+=1;shapeX[2]+=1;shapeX[3]+=1;
				}
				break;
			case 2:	//��̬2�������������ƶ�
				if ((shapeX[3]!=GridBlock.COL)&&(GridBlock.xyList.get(shapeXYToInt((shapeX[0]+1), shapeY[0])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[3]+1), shapeY[3])).isDraw()==false)) {
					shapeX[0]+=1;shapeX[1]+=1;shapeX[2]+=1;shapeX[3]+=1;
				}
				break;
			case 3:	//��̬3�������������ƶ�
				if ((shapeX[2]!=GridBlock.COL)&&(GridBlock.xyList.get(shapeXYToInt((shapeX[1]+1), shapeY[1])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[2]+1), shapeY[2])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[3]+1), shapeY[3])).isDraw()==false)) {
					shapeX[0]+=1;shapeX[1]+=1;shapeX[2]+=1;shapeX[3]+=1;
				}
				break;
			case 4:	//��̬4�������������ƶ�
				if ((shapeX[1]!=GridBlock.COL)&&(GridBlock.xyList.get(shapeXYToInt((shapeX[0]+1), shapeY[0])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[1]+1), shapeY[1])).isDraw()==false)) {
					shapeX[0]+=1;shapeX[1]+=1;shapeX[2]+=1;shapeX[3]+=1;
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
	 * ��L���������
	 */
	@Override
	public void down(){
		notDraw();
		if (canMove) {
			switch (whichTime) {
			case 0:	//ʹ��ʼλ���ڵ�һ��
				whichTime=4;
				canDraw();
				break;
			case 1:
				if ((shapeY[1]!=GridBlock.ROW)&&(GridBlock.xyList.get(shapeXYToInt(shapeX[0], (shapeY[0]+1))).isBottomBlock()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[0], (shapeY[0]+1))).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[1], (shapeY[1]+1))).isBottomBlock()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[1], (shapeY[1]+1))).isDraw()==false)) {	//��̬1�������������ƶ�
					shapeY[0]+=1;shapeY[1]+=1;shapeY[2]+=1;shapeY[3]+=1;
				}else if ((shapeY[1]==GridBlock.ROW)||(GridBlock.xyList.get(shapeXYToInt(shapeX[0], (shapeY[0]+1))).isBottomBlock())||
						(GridBlock.xyList.get(shapeXYToInt(shapeX[1], (shapeY[1]+1))).isBottomBlock())){	//��̬1�ĵ�������
					canMove=false;
					bottomBlock();
				}
				break;
			case 2:
				if ((shapeY[0]!=GridBlock.ROW)&&(GridBlock.xyList.get(shapeXYToInt(shapeX[0], (shapeY[0]+1))).isBottomBlock()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[0], (shapeY[0]+1))).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[2], (shapeY[2]+1))).isBottomBlock()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[2], (shapeY[2]+1))).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[3], (shapeY[3]+1))).isBottomBlock()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[3], (shapeY[3]+1))).isDraw()==false)) {	//��̬2�������������ƶ�
					shapeY[0]+=1;shapeY[1]+=1;shapeY[2]+=1;shapeY[3]+=1;
				}else if ((shapeY[0]==GridBlock.ROW)||(GridBlock.xyList.get(shapeXYToInt(shapeX[0], (shapeY[0]+1))).isBottomBlock())||
						(GridBlock.xyList.get(shapeXYToInt(shapeX[2], (shapeY[2]+1))).isBottomBlock())||
						(GridBlock.xyList.get(shapeXYToInt(shapeX[3], (shapeY[3]+1))).isBottomBlock())){	//��̬2�ĵ�������
					canMove=false;
					bottomBlock();
				}
				break;
			case 3:
				if ((shapeY[3]!=GridBlock.ROW)&&(GridBlock.xyList.get(shapeXYToInt(shapeX[0], (shapeY[0]+1))).isBottomBlock()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[0], (shapeY[0]+1))).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[3], (shapeY[3]+1))).isBottomBlock()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[3], (shapeY[3]+1))).isDraw()==false)) {	//��̬3�������������ƶ�
					shapeY[0]+=1;shapeY[1]+=1;shapeY[2]+=1;shapeY[3]+=1;
				}else if ((shapeY[3]==GridBlock.ROW)||(GridBlock.xyList.get(shapeXYToInt(shapeX[0], (shapeY[0]+1))).isBottomBlock())||
						(GridBlock.xyList.get(shapeXYToInt(shapeX[3], (shapeY[3]+1))).isBottomBlock())) {	//��̬3�ĵ�������
					canMove=false;
					bottomBlock();
				}
				break;
			case 4:
				if ((shapeY[2]!=GridBlock.ROW)&&(GridBlock.xyList.get(shapeXYToInt(shapeX[1], (shapeY[1]+1))).isBottomBlock()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[1], (shapeY[1]+1))).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[2], (shapeY[2]+1))).isBottomBlock()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[2], (shapeY[2]+1))).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[3], (shapeY[3]+1))).isBottomBlock()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[3], (shapeY[3]+1))).isDraw()==false)) {	//��̬4�������������ƶ�
					shapeY[0]+=1;shapeY[1]+=1;shapeY[2]+=1;shapeY[3]+=1;
				}else if ((shapeY[2]==GridBlock.ROW)||(GridBlock.xyList.get(shapeXYToInt(shapeX[1], (shapeY[1]+1))).isBottomBlock())||
						(GridBlock.xyList.get(shapeXYToInt(shapeX[2], (shapeY[2]+1))).isBottomBlock())||
						(GridBlock.xyList.get(shapeXYToInt(shapeX[3], (shapeY[3]+1))).isBottomBlock())) {	//��̬4�ĵ�������
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
	 * ��L�������ת
	 */
	@Override
	public void rotate(){
		notDraw();
		if (canMove) {
			switch (whichTime) {
			case 0:	//��̬0��ת����̬1
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
	 * ��L������̬1
	 */
	private void fourToOne(){
		if ((shapeY[2]!=GridBlock.ROW)&&(GridBlock.xyList.get(shapeXYToInt((shapeX[2]+1), (shapeY[2]+1))).isDraw()==false)&&
				(GridBlock.xyList.get(shapeXYToInt(shapeX[2], (shapeY[2]+1))).isDraw()==false)&&
				(GridBlock.xyList.get(shapeXYToInt(shapeX[2], (shapeY[2]-1))).isDraw()==false)&&
				(GridBlock.xyList.get(shapeXYToInt(shapeX[3], (shapeY[3]-1))).isDraw()==false)) {	//��ת����
			whichTime=1;
			shapeY[0]+=2;
			shapeX[1]-=1;shapeY[1]+=1;
			shapeX[3]+=1;shapeY[3]-=1;
		}
	}
	/**
	 * ��L������̬2
	 */
	private void oneToTwo(){
		if ((shapeX[2]!=1)&&(GridBlock.xyList.get(shapeXYToInt((shapeX[2]-1), (shapeY[2]+1))).isDraw()==false)&&
				(GridBlock.xyList.get(shapeXYToInt((shapeX[2]-1), shapeY[2])).isDraw()==false)&&
				(GridBlock.xyList.get(shapeXYToInt((shapeX[2]+1), shapeY[2])).isDraw()==false)&&
				(GridBlock.xyList.get(shapeXYToInt(shapeX[3]+1, shapeY[3])).isDraw()==false)) {	//��ת����
			whichTime=2;
			shapeX[0]-=2;
			shapeX[1]-=1;shapeY[1]-=1;
			shapeX[3]+=1;shapeY[3]+=1;
		}
	}
	/**
	 * ��L������̬3
	 */
	private void twoToThree(){
		if ((GridBlock.xyList.get(shapeXYToInt((shapeX[2]-1), (shapeY[2]-1))).isDraw()==false)&&
				(GridBlock.xyList.get(shapeXYToInt(shapeX[2], (shapeY[2]-1))).isDraw()==false)&&
				(GridBlock.xyList.get(shapeXYToInt(shapeX[2], (shapeY[2]+1))).isDraw()==false)&&
				(GridBlock.xyList.get(shapeXYToInt(shapeX[3], (shapeY[3]+1))).isDraw()==false)) {	//��ת����
			whichTime=3;
			shapeY[0]-=2;
			shapeX[1]+=1;shapeY[1]-=1;
			shapeX[3]-=1;shapeY[3]+=1;
		}
	}
	/**
	 * ��L������̬4
	 */
	private void threeToFour(){
		if ((shapeX[2]!=GridBlock.COL) &&(GridBlock.xyList.get(shapeXYToInt((shapeX[2]+1), (shapeY[2]-1))).isDraw()==false)&&
				(GridBlock.xyList.get(shapeXYToInt((shapeX[2]+1), shapeY[2])).isDraw()==false)&&
				(GridBlock.xyList.get(shapeXYToInt((shapeX[2]-1), shapeY[2])).isDraw()==false)&&
				(GridBlock.xyList.get(shapeXYToInt((shapeX[3]-1), shapeY[3])).isDraw()==false)) {	//��ת����
			whichTime=4;
			shapeX[0]+=2;
			shapeX[1]+=1;shapeY[1]+=1;
			shapeX[3]-=1;shapeY[3]-=1;
		}
	}
}
