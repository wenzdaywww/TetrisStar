package com.www.gamemodel;

	/**
	 * ֱ���η�����
	 * @author wWw
	 *
	 */
public class LineShape extends BaseShape {
	/**
	 * ֱ���η��鹹�췽�������������������
	 * @param GridBlock
	 */
	public LineShape() {
	}
	/**
	 * ֱ�߷���ĳ�ʼ��
	 */
	@Override
	public void init() {
		whichTime=0;	//ֱ�߷������̬0,��̬2��0һ��
		canMove=true;	//���ÿ����ƶ�
		shapeX[0]=6;shapeY[0]=1;	//ֱ�߷��������
		shapeX[1]=7;shapeY[1]=1;
		shapeX[2]=8;shapeY[2]=1;
		shapeX[3]=9;shapeY[3]=1;
	}
	/**
	 * ֱ�߷��������
	 */
	@Override
	public void left() {
		notDraw();
		if (canMove) {
			switch (whichTime) {
			case 0:	//��̬0�������������ƶ�
				if ((shapeX[0]!=1)&&(GridBlock.xyList.get(shapeXYToInt((shapeX[0]-1), shapeY[0])).isDraw()==false)) {
					shapeX[0]-=1;shapeX[1]-=1;shapeX[2]-=1;shapeX[3]-=1;
				}
				break;
			case 1:	//��̬1�������������ƶ�
				if ((shapeX[2]!=1) &&(GridBlock.xyList.get(shapeXYToInt((shapeX[0]-1), shapeY[0])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[1]-1), shapeY[1])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[2]-1), shapeY[2])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[3]-1), shapeY[3])).isDraw()==false)) {
					shapeX[0]-=1;shapeX[1]-=1;shapeX[2]-=1;shapeX[3]-=1;
				}
				break;
			case 2:	//��̬2�������������ƶ�
				if ((shapeX[0]!=1)&&(GridBlock.xyList.get(shapeXYToInt((shapeX[0]-1), shapeY[0])).isDraw()==false)) {
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
	 * ֱ�߷��������
	 */
	@Override
	public void right() {
		notDraw();
		if (canMove) {
			switch (whichTime) {
			case 0:	//��̬0�������������ƶ�
				if ((shapeX[3]!=GridBlock.COL)&&(GridBlock.xyList.get(shapeXYToInt((shapeX[3]+1), shapeY[0])).isDraw()==false)) {
					shapeX[0]+=1;shapeX[1]+=1;shapeX[2]+=1;shapeX[3]+=1;
				}
				break;
			case 1:	//��̬1�������������ƶ�
				if ((shapeX[2]!=GridBlock.COL) &&(GridBlock.xyList.get(shapeXYToInt((shapeX[0]+1), shapeY[0])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[1]+1), shapeY[1])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[2]+1), shapeY[2])).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt((shapeX[3]+1), shapeY[3])).isDraw()==false)) {
					shapeX[0]+=1;shapeX[1]+=1;shapeX[2]+=1;shapeX[3]+=1;
				}
				break;
			case 2:	//��̬2�������������ƶ�
				if ((shapeX[3]!=GridBlock.COL)&&(GridBlock.xyList.get(shapeXYToInt((shapeX[3]+1), shapeY[0])).isDraw()==false)) {
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
	 * ֱ�߷��������
	 */
	@Override
	public void down() {
		notDraw();
		if (canMove) {
			switch (whichTime) {
			case 0:	//ʹ��ʼλ���ڵ�һ��
				whichTime=2;
				canDraw();
				break;
			case 1:
				if ((shapeY[3]!=GridBlock.ROW) &&(GridBlock.xyList.get(shapeXYToInt(shapeX[3], (shapeY[3]+1))).isBottomBlock()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[3], (shapeY[3]+1))).isDraw()==false)) {	//��̬1�������������ƶ�
					shapeY[0]+=1;shapeY[1]+=1;shapeY[2]+=1;shapeY[3]+=1;
				}else if ((shapeY[3]==GridBlock.ROW) ||(GridBlock.xyList.get(shapeXYToInt(shapeX[3], (shapeY[3]+1))).isBottomBlock())){//��̬1�ĵ�������
					canMove=false;
					bottomBlock();
				}
				break;
			case 2:
				if ((shapeY[2]!=GridBlock.ROW)&&(GridBlock.xyList.get(shapeXYToInt(shapeX[0], (shapeY[0]+1))).isBottomBlock()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[0], (shapeY[0]+1))).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[1], (shapeY[1]+1))).isBottomBlock()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[1], (shapeY[1]+1))).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[2], (shapeY[2]+1))).isBottomBlock()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[2], (shapeY[2]+1))).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[3], (shapeY[3]+1))).isBottomBlock()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[3], (shapeY[3]+1))).isDraw()==false)) {	//��̬2�������������ƶ�
					shapeY[0]+=1;shapeY[1]+=1;shapeY[2]+=1;shapeY[3]+=1;
				}else if ((shapeY[2]==GridBlock.ROW)||(GridBlock.xyList.get(shapeXYToInt(shapeX[0], (shapeY[0]+1))).isBottomBlock())||
						(GridBlock.xyList.get(shapeXYToInt(shapeX[1], (shapeY[1]+1))).isBottomBlock())||
						(GridBlock.xyList.get(shapeXYToInt(shapeX[2], (shapeY[2]+1))).isBottomBlock())||
						(GridBlock.xyList.get(shapeXYToInt(shapeX[3], (shapeY[3]+1))).isBottomBlock())){	//��̬2�ĵ�������
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
	 * ֱ�߷������ת
	 */
	@Override
	public void rotate() {
		notDraw();
		if (canMove) {
			switch (whichTime) {
			case 0:	//��̬0��ת����̬1
				twoToOne();
				break;
			case 1:	//��̬1��ת����̬2
				oneToTwo();
				break;
			case 2:	//��̬2��ת����̬1
				twoToOne();
				break;
			default:
				break;
			}
		}
		setInitImage();
		canDraw();
	}
	/**
	 * ֱ�߷�����̬1
	 */
	private void twoToOne(){
		if ((shapeY[1]!=1)&&(shapeY[1]!=GridBlock.ROW)&&(shapeY[1]!=GridBlock.ROW-1)&&
				(GridBlock.xyList.get(shapeXYToInt(shapeX[0], (shapeY[0]-1))).isDraw()==false)&&
				(GridBlock.xyList.get(shapeXYToInt(shapeX[1], (shapeY[1]-1))).isDraw()==false)&&
				(GridBlock.xyList.get(shapeXYToInt(shapeX[1], (shapeY[1]+1))).isDraw()==false)&&
				(GridBlock.xyList.get(shapeXYToInt(shapeX[1], (shapeY[1]+2))).isDraw()==false)&&
				(GridBlock.xyList.get(shapeXYToInt(shapeX[2], (shapeY[2]+1))).isDraw()==false)&&
				(GridBlock.xyList.get(shapeXYToInt(shapeX[2], (shapeY[2]+2))).isDraw()==false)&&
				(GridBlock.xyList.get(shapeXYToInt(shapeX[3], (shapeY[3]+1))).isDraw()==false)&&
				(GridBlock.xyList.get(shapeXYToInt(shapeX[3], (shapeY[3]+2))).isDraw()==false)) {	//��ת����
			whichTime=1;
			shapeX[0]+=1;shapeY[0]-=1;
			shapeX[2]-=1;shapeY[2]+=1;
			shapeX[3]-=2;shapeY[3]+=2;
		}
	}
	/**
	 * ֱ�߷�����̬2
	 */
	private void oneToTwo(){
		if ((shapeX[1]!=1)&&(shapeX[1]!=GridBlock.COL)&&(shapeX[1]!=GridBlock.COL-1)&&
				(GridBlock.xyList.get(shapeXYToInt((shapeX[0]-1), shapeY[0])).isDraw()==false)&&
				(GridBlock.xyList.get(shapeXYToInt((shapeX[1]-1), shapeY[1])).isDraw()==false)&&
				(GridBlock.xyList.get(shapeXYToInt((shapeX[1]+1), shapeY[1])).isDraw()==false)&&
				(GridBlock.xyList.get(shapeXYToInt((shapeX[1]+2), shapeY[1])).isDraw()==false)&&
				(GridBlock.xyList.get(shapeXYToInt((shapeX[2]+1), shapeY[2])).isDraw()==false)&&
				(GridBlock.xyList.get(shapeXYToInt((shapeX[2]+2), shapeY[2])).isDraw()==false)&&
				(GridBlock.xyList.get(shapeXYToInt((shapeX[3]+1), shapeY[3])).isDraw()==false)&&
				(GridBlock.xyList.get(shapeXYToInt((shapeX[3]+2), shapeY[3])).isDraw()==false)) {	//��ת����
			whichTime=2;
			shapeX[0]-=1;shapeY[0]+=1;
			shapeX[2]+=1;shapeY[2]-=1;
			shapeX[3]+=2;shapeY[3]-=2;
		}
	}
}
