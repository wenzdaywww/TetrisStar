package com.www.gamemodel;

	/**
	 * ը��������
	 * @author wWw
	 *
	 */
public class BombShape extends BaseShape {
	/**
	 * ը���Ĺ��췽������ȡ�����������
	 * @param blockPanel �����������
	 */
	public BombShape() {
	}
	/**
	 * ��ʼ��ը�����ֵ�λ��
	 */
	@Override
	public void init() {
		whichTime=0;	//����ը����ʼ��̬
		canMove=true;	//���ÿ����ƶ�
		isBomb=true;	//����Ϊը����־
		shapeX[0]=8;shapeY[0]=1;	//��ʼը�����ֵ�����
	}
	/**
	 * ը��������
	 */
	@Override
	public void left() {
		notDraw();	
		if (canMove&&(shapeX[0]!=1)&&(GridBlock.xyList.get(shapeXYToInt(shapeX[0]-1, shapeY[0])).isDraw()==false)) { //���Ƶ�����
			shapeX[0]-=1;
		}
		setInitImage();	
		canDraw();	
	}
	/**
	 * ը��������
	 */
	@Override
	public void right() {
		notDraw();	
		if (canMove&&(shapeX[0]!=GridBlock.COL)&&(GridBlock.xyList.get(shapeXYToInt(shapeX[0]+1, shapeY[0])).isDraw()==false)) {	//���Ƶ�����
			shapeX[0]+=1;
		}
		setInitImage();	
		canDraw();	
	}
	/**
	 * ը������
	 */
	@Override
	public void down() {
		notDraw();	
		if (canMove) {
			switch (whichTime) {
			case 0:	//�ӳ�ʼλ�ñ仯һ���������ſ����ڵ�һ�г��֣������ڵڶ��г���
				whichTime=1;
				setInitImage();	
				canDraw();
				break;
			case 1:
				if ((shapeY[0]!=GridBlock.ROW)&&(GridBlock.xyList.get(shapeXYToInt(shapeX[0], (shapeY[0]+1))).isBottomBlock()==false)&&
						(GridBlock.xyList.get(shapeXYToInt(shapeX[0], (shapeY[0]+1))).isDraw()==false)) {	//���������
					shapeY[0]+=1;
					setInitImage();	
					canDraw();
				}else if ((shapeY[0]==GridBlock.ROW)||(GridBlock.xyList.get(shapeXYToInt(shapeX[0], (shapeY[0]+1))).isBottomBlock())){ //���׵�����
					canMove=false;
					GridBlock.xyList.get(shapeXYToInt(shapeX[0], (shapeY[0]))).setDraw(false);
					GridBlock.xyList.get(shapeXYToInt(shapeX[0], (shapeY[0]))).setBottomBlock(false);
				}
				break;
			default:
				break;
			}
		}
	}
	/**
	 * ��ʼ��ը����ͼƬ
	 */
	@Override
	protected void setInitImage() {
		GridBlock.xyList.get(shapeXYToInt(shapeX[0], shapeY[0])).setImage("image/bomb.png");
	}
	/**
	 * ը���ƶ�ǰ���ò��ɼ�
	 */
	@Override
	protected void notDraw() {
		GridBlock.xyList.get(shapeXYToInt(shapeX[0], shapeY[0])).setDraw(false);
	}
	/**
	 * ը���ƶ������ÿɼ�
	 */
	@Override
	protected void canDraw() {
		GridBlock.xyList.get(shapeXYToInt(shapeX[0], shapeY[0])).setDraw(true);
	}
	/**
	 * ը����ʼ�������ж���Ϸ����
	 */
	@Override
	public boolean initGameOver() {
		return false;
	}
}
