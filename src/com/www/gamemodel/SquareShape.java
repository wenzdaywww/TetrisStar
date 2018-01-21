package com.www.gamemodel;

	/**
	 * �����η�����
	 * @author wWw
	 *
	 */
public class SquareShape extends BaseShape {
	/**
	 * �����η��鹹�췽�������������������
	 * @param GridBlock
	 */
	public SquareShape() {
	}
	/**
	 * �����η���ĳ�ʼ��
	 */
	@Override
	public void init() {
		whichTime=0;	//�����η�����̬0,��̬1��0һ��
		canMove=true;	//���ÿ����ƶ�
		shapeX[0]=7;shapeY[0]=1;	//���ó�ʼ����
		shapeX[1]=8;shapeY[1]=1;
		shapeX[2]=7;shapeY[2]=2;
		shapeX[3]=8;shapeY[3]=2;
	}
	/**
	 * �����η��������
	 */
	@Override
	public void left(){
		notDraw();
		if (canMove&&(shapeX[0]!=1)&&(GridBlock.xyList.get(shapeXYToInt((shapeX[0]-1), shapeY[0])).isDraw()==false)&&
				(GridBlock.xyList.get(shapeXYToInt((shapeX[2]-1), shapeY[2])).isDraw()==false)) {	//��������
			shapeX[0]-=1;shapeX[1]-=1;shapeX[2]-=1;shapeX[3]-=1;
		} 
		setInitImage();
		canDraw();
	}
	/**
	 * �����η��������
	 */
	@Override
	public void right(){
		notDraw();
		if (canMove&&(shapeX[1]!=GridBlock.COL)&&(GridBlock.xyList.get(shapeXYToInt((shapeX[1]+1), shapeY[1])).isDraw()==false)&&
				(GridBlock.xyList.get(shapeXYToInt((shapeX[3]+1), shapeY[3])).isDraw()==false)) {	//��������
			shapeX[0]+=1;shapeX[1]+=1;shapeX[2]+=1;shapeX[3]+=1;
		} 
		setInitImage();
		canDraw();
	}
	/**
	 * �����η��������
	 */
	@Override
	public void down(){
		notDraw();
		if (canMove) {
			switch (whichTime) {
			case 0:	//ʹ��ʼλ���ڵ�һ��
				whichTime=1;
				canDraw();
				break;
			case 1:
				if ((shapeY[2]!=GridBlock.ROW)&&(GridBlock.xyList.get(shapeXYToInt(shapeX[2], (shapeY[2]+1))).isBottomBlock()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[2], (shapeY[2]+1))).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[3], (shapeY[3]+1))).isBottomBlock()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[3], (shapeY[3]+1))).isDraw()==false)) {	//��̬1�������������ƶ�
					shapeY[0]+=1;shapeY[1]+=1;shapeY[2]+=1;shapeY[3]+=1;
				}else 	if ((shapeY[2]==GridBlock.ROW)||(GridBlock.xyList.get(shapeXYToInt(shapeX[2], (shapeY[2]+1))).isBottomBlock())||
						(GridBlock.xyList.get(shapeXYToInt(shapeX[3], (shapeY[3]+1))).isBottomBlock())){	//��̬1�ĵ�������
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
}
