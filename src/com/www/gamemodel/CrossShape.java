package com.www.gamemodel;

	/**
	 * ʮ���η�����
	 * @author wWw
	 *
	 */
public class CrossShape extends BaseShape {
	/**
	 * ʮ���η���Ĺ��췽�������������������
	 * @param GridBlock �����������
	 */
	public CrossShape() {
	}
	/**
	 * ʮ���η���ĳ�ʼ��
	 */
	@Override
	public void init() {
		whichTime=0;	//ʮ���η�����̬0,��̬1��0һ��
		canMove=true;	//���ÿ����ƶ�
		shapeX[0]=8;shapeY[0]=1;	//����ʮ���η��������
		shapeX[1]=7;shapeY[1]=2;
		shapeX[2]=8;shapeY[2]=2;
		shapeX[3]=9;shapeY[3]=2;
		shapeX[4]=8;shapeY[4]=3;
	}
	/**
	 * ʮ���η��������
	 */
	@Override
	public void left() {
		notDraw();
		if (canMove&&(shapeX[1]!=1)&&(GridBlock.xyList.get(shapeXYToInt((shapeX[0]-1), shapeY[0])).isDraw()==false)&&	
				(GridBlock.xyList.get(shapeXYToInt((shapeX[1]-1), shapeY[1])).isDraw()==false)&&
				(GridBlock.xyList.get(shapeXYToInt((shapeX[4]-1), shapeY[4])).isDraw()==false)) {	//���Ƶ�����
			shapeX[0]-=1;shapeX[1]-=1;shapeX[2]-=1;shapeX[3]-=1;shapeX[4]-=1;
		} 
		setInitImage();
		canDraw();
	}
	/**
	 * ʮ���η��������
	 */
	@Override
	public void right() {
		notDraw();
		if (canMove&&(shapeX[3]!=GridBlock.COL)&&(GridBlock.xyList.get(shapeXYToInt((shapeX[0]+1), shapeY[0])).isDraw()==false)&&
				(GridBlock.xyList.get(shapeXYToInt((shapeX[3]+1), shapeY[3])).isDraw()==false)&&
				(GridBlock.xyList.get(shapeXYToInt((shapeX[4]+1), shapeY[4])).isDraw()==false)) {	//���Ƶ�����
			shapeX[0]+=1;shapeX[1]+=1;shapeX[2]+=1;shapeX[3]+=1;shapeX[4]+=1;
		} 
		setInitImage();
		canDraw();
	}
	/**
	 * ʮ���η��������
	 */
	@Override
	public void down() {
		notDraw();
		if (canMove) {
			switch (whichTime) {
			case 0:	//ʹ��ʼλ���ڵ�һ��
				whichTime=1;
				canDraw();
				break;
			case 1:	
				if ((shapeY[4]!=GridBlock.ROW)&&(GridBlock.xyList.get(shapeXYToInt(shapeX[1], (shapeY[1]+1))).isBottomBlock()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[1], (shapeY[1]+1))).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[4], (shapeY[4]+1))).isBottomBlock()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[4], (shapeY[4]+1))).isDraw()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[3], (shapeY[3]+1))).isBottomBlock()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[3], (shapeY[3]+1))).isDraw()==false)) {	//��̬1�������������ƶ�
					shapeY[0]+=1;shapeY[1]+=1;shapeY[2]+=1;shapeY[3]+=1;shapeY[4]+=1;
				}else if ((shapeY[4]==GridBlock.ROW)||(GridBlock.xyList.get(shapeXYToInt(shapeX[1], (shapeY[1]+1))).isBottomBlock())||
						(GridBlock.xyList.get(shapeXYToInt(shapeX[4], (shapeY[4]+1))).isBottomBlock())||
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
	/**
	 * ʮ���η����ͼƬ��ʼ��
	 */
	@Override
	protected void setInitImage() {
		for (int i = 0; i < 5; i++) {
			GridBlock.xyList.get(shapeXYToInt(shapeX[i], shapeY[i])).setImage(shapeImage);
		}
	}
	/**
	 * ʮ���η����ƶ�ǰ���ɼ�
	 */
	@Override
	protected void notDraw() {
		for (int i = 0; i < 5; i++) {
			GridBlock.xyList.get(shapeXYToInt(shapeX[i], shapeY[i])).setDraw(false);
		}
	}
	/**
	 * ʮ���η����ƶ���ɼ�
	 */
	@Override
	protected void canDraw() {
		for (int i = 0; i < 5; i++) {
			GridBlock.xyList.get(shapeXYToInt(shapeX[i], shapeY[i])).setDraw(true);
		}
	}
	/**
	 * ʮ���η��鵽�׺���Ϊ�ײ�����
	 */
	@Override
	protected void bottomBlock() {
		for (int i = 0; i < 5; i++) {
			GridBlock.xyList.get(shapeXYToInt(shapeX[i], shapeY[i])).setBottomBlock(true);
		}
	}
	/**
	 * ʮ���η���ÿ�γ����ж���Ϸ�Ƿ����
	 */
	@Override
	public boolean initGameOver() {
		if (GridBlock.xyList.get(shapeXYToInt(shapeX[0], shapeY[0])).isDraw()||
				GridBlock.xyList.get(shapeXYToInt(shapeX[1], shapeY[1])).isDraw()||
				GridBlock.xyList.get(shapeXYToInt(shapeX[2], shapeY[2])).isDraw()||
				GridBlock.xyList.get(shapeXYToInt(shapeX[3], shapeY[3])).isDraw()||
				GridBlock.xyList.get(shapeXYToInt(shapeX[4], shapeY[4])).isDraw()) {
			return true;
		}else {
			return false;
		}
	}
}
