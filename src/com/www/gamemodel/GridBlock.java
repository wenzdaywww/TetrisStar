package com.www.gamemodel;

import java.util.Random;
import java.util.HashMap;
import java.util.ArrayList;

public class GridBlock {
	/**@see ��Ϸ����*/
	public int socre=0;	
	/** @see ������ĵڼ�������*/
	public int shapeNum =0;
	/**@see ������������*/
	public static int COL=15;	
	/**@see ������������*/
	public static int ROW=25;	
	/**@see �����С*/
	public static final int SIZE=20;	
	/** @see ������ѡ����ͼƬ*/
	public static String shapeImage="";
	/** @see ��ǰ��������ķ������*/
	private BaseShape player1NowShape;
	/** @see ��ǰ��������ķ������*/
	private BaseShape player2NowShape;
	/**@see ���1�������*/
	public BaseShape player1BaseShape;	
	/**@see ���2�������*/
	public BaseShape player2BaseShape;	
	/** @see ����ģʽ*/
	public String level="����ģʽ";
	/**@see �Ƿ����������*/
	public static boolean helpLine=false;	
	/** @see ����ͼƬ����*/
	private ArrayList<String> imageList=new ArrayList<String>();
	/** @see ���1���з�����״����*/
	private ArrayList<BaseShape> player1ShapeList=new ArrayList<BaseShape>();
	/** @see ���2���з�����״����*/
	private ArrayList<BaseShape> player2ShapeList=new ArrayList<BaseShape>();
	/**@see ���ڴ���Ƿ��������ļ���*/
	public static HashMap<Integer, DrawArea> xyList=new HashMap<Integer, DrawArea>();
	/**
	 * ����ģ�͹��췽����ʼ�����1��2�ķ��鼯��
	 */
	public GridBlock() {
		clearBlockPanel();
		initShape();
	}
	/**
	 * ���������ʼ�����
	 */
	public static void clearBlockPanel(){
		xyList.clear();
		for (int i = 1; i <= COL*ROW; i++) {
			xyList.put(i, new DrawArea(intToShapeX(i),intToShapeY(i),false,"",false));
		}
	}
	/**
	 * ���1���ƶ����������еķ���
	 */
	public void player1Left(){
		player1BaseShape.left();
	}
	/**
	 * ���1���ƶ����������еķ���
	 */
	public void player1Right(){
		player1BaseShape.right();
	}
	/**
	 * ���1�ӿ����������з���������ٶ�
	 */
	public void player1Down(){
		player1BaseShape.down();
	}
	/**
	 * ���1��ת���������еķ���
	 */
	public void player1Rotate(){
		player1BaseShape.rotate();
	}
	/**
	 * ���1�ж����������еķ����Ƿ��ܼ����ƶ�
	 * @return
	 */
	public boolean player1IsCanMove(){
		return player1BaseShape.isCanMove();
	}
	/**
	 * ���1�ж���Ϸ�Ƿ����
	 * @return
	 */
	public boolean player1IsGameOver(){
		return player1BaseShape.isGameOver();
	}
	/**
	 * ���2���ƶ����������еķ���
	 */
	public void player2Left(){
		player2BaseShape.left();
	}
	/**
	 * ���2���ƶ����������еķ���
	 */
	public void player2Right(){
		player2BaseShape.right();
	}
	/**
	 * ���2�ӿ����������з���������ٶ�
	 */
	public void player2Down(){
		player2BaseShape.down();
	}
	/**
	 * ���2��ת���������еķ���
	 */
	public void player2Rotate(){
		player2BaseShape.rotate();
	}
	/**
	 * ���2�ж����������еķ����Ƿ��ܼ����ƶ�
	 * @return
	 */
	public boolean player2IsCanMove(){
		return player2BaseShape.isCanMove();
	}
	/**
	 * ���2�ж���Ϸ�Ƿ����
	 * @return
	 */
	public boolean player2IsGameOver(){
		return player2BaseShape.isGameOver();
	}
	/**
	 * ���1����������Ϸ��ʼ
	 */
	public void player1SetGameOverToRestart(){
		player1BaseShape.setGameOverToRestart(false);
	}
	/**
	 * ���2����������Ϸ��ʼ
	 */
	public void player2SetGameOverToRestart(){
		player2BaseShape.setGameOverToRestart(false);
	}
	/**
	 * ������ӵ�����������
	 * @param baseShape ���巽������
	 */
	private void player1InitBlock(BaseShape baseShape){
		this.player1BaseShape=baseShape;
		this.player1BaseShape.init();
		this.player1BaseShape.gameOver=this.player1BaseShape.initGameOver();
	}
	/**
	 * ������ӵ�����������
	 * @param baseShape ���巽������
	 */
	private void player2InitBlock(BaseShape baseShape){
		this.player2BaseShape=baseShape;
		this.player2BaseShape.init();
		for (int i = 0; i < this.player2BaseShape.shapeX.length; i++) {
			this.player2BaseShape.shapeX[i]+=10;
		}
		this.player2BaseShape.gameOver=this.player2BaseShape.initGameOver();
	}
	/**
	 * �������²������1����
	 */
	public void player1CreateShape(boolean haveBomb){
		player1NowShape=player1ShapeList.get(shapeNum);	//��ȡ���1�ķ���
		player1NowShape.setImage(shapeImage);	//���õ�ǰ����ͼƬ
		player1InitBlock(player1NowShape);	//��ʼ�����1�ķ���λ��
		randomShape(haveBomb);
	}
	/**
	 * �������²������2����
	 */
	public void player2CreateShape(boolean haveBomb){
		player2NowShape=player2ShapeList.get(shapeNum);	//��ȡ���2�ķ���
		player2NowShape.setImage(shapeImage);	//���õ�ǰ����ͼƬ
		player2InitBlock(player2NowShape);	//��ʼ�����2�ķ���λ��
		randomShape(haveBomb);
	}
	/**
	 * ���������ת���ɶ�ӦX����
	 * @param i	�������
	 * @return	X����
	 */
	private static int intToShapeX(int i){
		if ((i%COL)==0) {
			return COL;
		}else {
			return i%COL;
		}
	}
	/**
	 * ���������ת���ɶ�ӦY����
	 * @param i	�������
	 * @return	Y����
	 */
	private static int intToShapeY(int i){
		if ((i%COL)==0) {
			return i/COL;
		}else {
			return (i/COL)+1;
		}
	}
	/**
	 * ��xy����ת���ɶ�Ӧ�ķ������
	 * @param x	x����
	 * @param y	y����
	 * @return	�������
	 */
	public static int shapeXYToInt(int x,int y){
		return (x+COL*(y-1));
	}
	/**
	 * ���1����ը�������д���
	 * @return trueΪը����false��Ϊը��
	 */
	public boolean player1IsBomb(){
		if (!player1BaseShape.isCanMove()&&player1BaseShape.isBomb) {
			socre+=20;	//����+20
			for (int x = 1; x <=ROW; x++) {	//������1ը��������
				if (xyList.get(shapeXYToInt(player1BaseShape.shapeX[0], x)).isBottomBlock()) {
					xyList.get(shapeXYToInt(player1BaseShape.shapeX[0], x)).setDraw(false);
					xyList.get(shapeXYToInt(player1BaseShape.shapeX[0], x)).setBottomBlock(false);
				}
			}
			for (int y = 1; y <=COL; y++) {	//������1ը��������
				if (xyList.get(shapeXYToInt(y, player1BaseShape.shapeY[0])).isBottomBlock()) {
					xyList.get(shapeXYToInt(y, player1BaseShape.shapeY[0])).setDraw(false);
					xyList.get(shapeXYToInt(y, player1BaseShape.shapeY[0])).setBottomBlock(false);
				}
			}
			for (int x = 1; x <=COL; x++) {	//��������һ��
				for (int y = player1BaseShape.shapeY[0]-1; y >=1; y--) {
					if (xyList.get(shapeXYToInt(x, y)).isBottomBlock()) {
						xyList.get(shapeXYToInt(x, y)).setDraw(false);
						xyList.get(shapeXYToInt(x, y)).setBottomBlock(false);
						xyList.get(shapeXYToInt(x, y+1)).setDraw(true);
						xyList.get(shapeXYToInt(x, y+1)).setBottomBlock(true);
						xyList.get(shapeXYToInt(x, y+1)).setImage(xyList.get(shapeXYToInt(x, y)).getImage());
					}
				}
			}
		}
		return player1BaseShape.isBomb;
	}
	/**
	 * ���2����ը�������д���
	 * @return trueΪը����false��Ϊը��
	 */
	public boolean player2IsBomb(){
		if (!player2BaseShape.isCanMove()&&player2BaseShape.isBomb) {
			socre+=20;	//����+20
			for (int x = 1; x <=ROW; x++) {	//������2ը��������
				if (xyList.get(shapeXYToInt(player2BaseShape.shapeX[0], x)).isBottomBlock()) {
					xyList.get(shapeXYToInt(player2BaseShape.shapeX[0], x)).setDraw(false);
					xyList.get(shapeXYToInt(player2BaseShape.shapeX[0], x)).setBottomBlock(false);
				}
			}
			for (int y = 1; y <=COL; y++) {	//������2ը��������
				if (xyList.get(shapeXYToInt(y, player2BaseShape.shapeY[0])).isBottomBlock()) {
					xyList.get(shapeXYToInt(y, player2BaseShape.shapeY[0])).setDraw(false);
					xyList.get(shapeXYToInt(y, player2BaseShape.shapeY[0])).setBottomBlock(false);
				}
			}
			for (int x = 1; x <=COL; x++) {	//��������һ��
				for (int y = player2BaseShape.shapeY[0]-1; y >=1; y--) {
					if (xyList.get(shapeXYToInt(x, y)).isBottomBlock()) {
						xyList.get(shapeXYToInt(x, y)).setDraw(false);
						xyList.get(shapeXYToInt(x, y)).setBottomBlock(false);
						xyList.get(shapeXYToInt(x, y+1)).setDraw(true);
						xyList.get(shapeXYToInt(x, y+1)).setBottomBlock(true);
						xyList.get(shapeXYToInt(x, y+1)).setImage(xyList.get(shapeXYToInt(x, y)).getImage());
					}
				}
			}
		}
		return player2BaseShape.isBomb;
	}
	/**
	 * ��������������ɫ������shapeList��0~6λ��������
	 */
	public void randomShape(boolean haveBomb){
		Random random=new Random();
		if (level.equals("����ģʽ")) {
			if (haveBomb) {	//����ģʽѡ��ը��	
				player1ShapeList.set(7, new BombShape());//player1ShapeList�ĵ�8������Ϊը��
				player2ShapeList.set(7, new BombShape());//player2ShapeList�ĵ�8������Ϊը��
				shapeNum=random.nextInt(player1ShapeList.size()-2);
			}else {
				shapeNum=random.nextInt(player1ShapeList.size()-3);
			}
		}else if(level.equals("�м�ģʽ")){
			if (haveBomb) {	//�м�ģʽѡ��ը��
				player1ShapeList.set(7, new ConcaveShape());//player1ShapeList�ĵ�9������Ϊը��
				player1ShapeList.set(8, new BombShape());
				player2ShapeList.set(7, new ConcaveShape());//player2ShapeList�ĵ�9������Ϊը��
				player2ShapeList.set(8, new BombShape());
				shapeNum=random.nextInt(player1ShapeList.size()-1);
			}else {
				player1ShapeList.set(7, new ConcaveShape());
				player2ShapeList.set(7, new ConcaveShape());
				shapeNum=random.nextInt(player1ShapeList.size()-2);
			}
		}else if(level.equals("�߼�ģʽ")||level.equals("��̬ģʽ")){	//�߼�ģʽѡ��ը��
			if (haveBomb) {	
				player1ShapeList.set(7, new ConcaveShape());	//player1ShapeList�ĵ�10������Ϊը��
				player1ShapeList.set(8, new CrossShape());
				player1ShapeList.set(9, new BombShape()); 
				player2ShapeList.set(7, new ConcaveShape());	//player2ShapeList�ĵ�10������Ϊը��
				player2ShapeList.set(8, new CrossShape());
				player2ShapeList.set(9, new BombShape()); 
				shapeNum=random.nextInt(player1ShapeList.size());
			}else {
				player1ShapeList.set(7, new ConcaveShape());
				player1ShapeList.set(8, new CrossShape());
				player2ShapeList.set(7, new ConcaveShape());
				player2ShapeList.set(8, new CrossShape());
				shapeNum=random.nextInt(player1ShapeList.size()-1);
			}
		}
		shapeImage=imageList.get(random.nextInt(imageList.size()));	//�����ȡͼƬ
	}
	/**
	 * ��/˫����Ϸ�ķ����������
	 */
	public boolean blockRandomOpen(boolean isSelected,int randomTime){
		Random random=new Random();
		if (isSelected) {	//���������ѡ��ťѡ��
			if (randomTime!=0) {	
				for (int i =1; i <=20; i++) {
					int x=random.nextInt(xyList.size())+shapeXYToInt(1, 15);
					if (x<=xyList.size()) {
						xyList.get(x).setDraw(true);
						xyList.get(x).setBottomBlock(true);
						xyList.get(x).setImage(imageList.get(random.nextInt(imageList.size())));
					}
				}
				return true;
			}
		}
		return false;
	}
	/**
	 * �����Զ�����
	 */
	public boolean blockAutoUp(boolean isSelected,int upTime){
		Random random=new Random();
		if (isSelected) {	//�����Զ����ǵ�ѡ��ťѡ��
			if (upTime!=0) {	//��������һ��
				for (int y = 3; y <=ROW; y++) {
					for (int x = 1; x <=COL; x++) {
						if (xyList.get(shapeXYToInt(x, y)).isBottomBlock()) {
							xyList.get(shapeXYToInt(x, y)).setDraw(false);
							xyList.get(shapeXYToInt(x, y)).setBottomBlock(false);
							xyList.get(shapeXYToInt(x, y-1)).setDraw(true);
							xyList.get(shapeXYToInt(x, y-1)).setBottomBlock(true);
							xyList.get(shapeXYToInt(x, y-1)).setImage(xyList.get(shapeXYToInt(x, y)).getImage());
						}
					}
				}
				//���Ǻ���������䷽��
				for (int i = 1; i <=COL; i++) {
					int x=random.nextInt(COL)+1;
					xyList.get(shapeXYToInt(x,ROW)).setDraw(true);
					xyList.get(shapeXYToInt(x,ROW)).setBottomBlock(true);
					xyList.get(shapeXYToInt(x,ROW)).setImage(imageList.get(random.nextInt(imageList.size())));
				}
				return true;
			}
		}
		return false;
	}
	/**
	 * ��/˫����Ϸ�ķ��������жϴ���
	 * @return trueΪ�Ѿ����У�falseΪû����Ҫ���е�
	 */
	public boolean blockDisappear(){
		if ((player1BaseShape.isCanMove()==false)||(player2BaseShape.isCanMove()==false)) {
			int[] disappearY=new int[ROW];	//Ҫ��������
			boolean disappear=false;
			//���ж��ļ�����Ҫ������������disappearY�����У������е�ֵ��ӦҪ������Y����
			for (int i = 0; i < disappearY.length; i++) {
				disappearY[i]=0;
			}
			//�ж�һ���Ƿ�ȫ�з��飬canDrawXNum=COL��ʾ����ȫ���ɷ���
			for (int y = 1; y <= ROW; y++) {
				int canDrawXNum=0;
				for (int x = 1; x <= COL; x++) {	
					if (xyList.get(shapeXYToInt(x, y)).isDraw()) {
						canDrawXNum++;
					}
				}
				if (canDrawXNum==COL) {
					disappear=true;
					disappearY[y-1]=y;
				}
			}
			//�����е�ֵ��Ϊ0���м�ΪҪ������У�������Ϊ���ɻ��ƺͲ��ǵײ�����
			for (int y = ROW-1; y >=0; y--) {
				if (disappearY[y]!=0) {
					socre+=10;	//�����������������
					for (int x = 1; x <=COL; x++) {
						xyList.get(shapeXYToInt(x, disappearY[y])).setDraw(false);
						xyList.get(shapeXYToInt(x, disappearY[y])).setBottomBlock(false);
					}
				}
			}
			//�����������ƣ�����ǵײ����飬������
			for (int y = 0; y <ROW; y++) {	//���ϼ�����Ƿ�Ϊ��
				if (disappearY[y]!=0) {
					for (int x = 1; x <=COL; x++) {
						for (int i =  disappearY[y]-1; i >=1 ; i--) {
							if (xyList.get(shapeXYToInt(x, i)).isBottomBlock()) {	//�ж��Ƿ��ǵײ�����
								xyList.get(shapeXYToInt(x, i)).setDraw(false);
								xyList.get(shapeXYToInt(x, i)).setBottomBlock(false);
								xyList.get(shapeXYToInt(x, i+1)).setDraw(true);
								xyList.get(shapeXYToInt(x, i+1)).setBottomBlock(true);
								xyList.get(shapeXYToInt(x, i+1)).setImage(xyList.get(shapeXYToInt(x, i)).getImage());
							}
						}
					}
				}
			}
			return disappear;
		}else {
			return false;
		}
	}
	/**
	 * ��ʼ��������ַ������ɫ����
	 */
	private void initShape(){
		//��ʼ�����1 �ķ��鼯��
		player1ShapeList.add(0, new LeftLShape()); 	
		player1ShapeList.add(1, new RightLShape());
		player1ShapeList.add(2, new TShape());
		player1ShapeList.add(3, new LeftZShape());
		player1ShapeList.add(4, new RightZShape());
		player1ShapeList.add(5, new SquareShape());
		player1ShapeList.add(6, new LineShape());
		player1ShapeList.add(7, new ConcaveShape());
		player1ShapeList.add(8, new CrossShape());
		player1ShapeList.add(9, new BombShape()); 
		//��ʼ�����2 �ķ��鼯��
		player2ShapeList.add(0, new LeftLShape()); 
		player2ShapeList.add(1, new RightLShape());
		player2ShapeList.add(2, new TShape());
		player2ShapeList.add(3, new LeftZShape());
		player2ShapeList.add(4, new RightZShape());
		player2ShapeList.add(5, new SquareShape());
		player2ShapeList.add(6, new LineShape());
		player2ShapeList.add(7, new ConcaveShape());
		player2ShapeList.add(8, new CrossShape());
		player2ShapeList.add(9, new BombShape()); 
		imageList.add(0, "image/blue.png");
		imageList.add(1, "image/green.png");
		imageList.add(2, "image/purple.png");
		imageList.add(3, "image/red.png");
		imageList.add(4, "image/yellow.png");
	}
	/**
	 * ��Ϸ����ʱ����ƴ�ӳ�game over����
	 */
	public void showGameOver(){
		String gColor="image/blue.png";
		String aColor="image/green.png";
		String mColor="image/purple.png";
		String geColor="image/red.png";
		String oColor="image/yellow.png";
		String vColor="image/purple.png";
		String oeColor="image/green.png";
		String rColor="image/blue.png";
		clearBlockPanel();
		int[] gNum={shapeXYToInt(1, 2),shapeXYToInt(2, 2),shapeXYToInt(3, 2),shapeXYToInt(4, 2),shapeXYToInt(1, 3),shapeXYToInt(4, 3),
				shapeXYToInt(1, 4),shapeXYToInt(1, 5),shapeXYToInt(1, 6),shapeXYToInt(1, 7),
				shapeXYToInt(3, 7),shapeXYToInt(4, 7),shapeXYToInt(1, 8),shapeXYToInt(4, 8),
				shapeXYToInt(1, 9),shapeXYToInt(4, 9),shapeXYToInt(1, 10),shapeXYToInt(2, 10),shapeXYToInt(3, 10),shapeXYToInt(4, 10)};
		int[] aNum={shapeXYToInt(5, 6),shapeXYToInt(6, 6),shapeXYToInt(7, 6),shapeXYToInt(5, 7),shapeXYToInt(7, 7),shapeXYToInt(5, 8),
				shapeXYToInt(6, 8),shapeXYToInt(7, 8),shapeXYToInt(5, 9),shapeXYToInt(7, 9),
				shapeXYToInt(5, 10),shapeXYToInt(7, 10)};
		int[] mNum={shapeXYToInt(8, 6),shapeXYToInt(9, 6),shapeXYToInt(10, 6),shapeXYToInt(11, 6),shapeXYToInt(12, 6),shapeXYToInt(8, 7),shapeXYToInt(10, 7),
				shapeXYToInt(12, 7),shapeXYToInt(12, 7),shapeXYToInt(8, 8),shapeXYToInt(10, 8),
				shapeXYToInt(12, 8),shapeXYToInt(8, 9),shapeXYToInt(10, 9),shapeXYToInt(12, 9),
				shapeXYToInt(8, 10),shapeXYToInt(10, 10),shapeXYToInt(12, 10)};
		int[] geNum={shapeXYToInt(13, 6),shapeXYToInt(14, 6),shapeXYToInt(15, 6),shapeXYToInt(13, 7),shapeXYToInt(15, 7),shapeXYToInt(13, 8),
				shapeXYToInt(14, 8),shapeXYToInt(15, 8),shapeXYToInt(13, 9),shapeXYToInt(13, 10),shapeXYToInt(14, 10),
				shapeXYToInt(15, 10)};
		int[] oNum={shapeXYToInt(2, 13),shapeXYToInt(3, 13),shapeXYToInt(4, 13),shapeXYToInt(5, 13),shapeXYToInt(2, 14),shapeXYToInt(5, 14),
				shapeXYToInt(2, 15),shapeXYToInt(5, 15),shapeXYToInt(2, 16),shapeXYToInt(5, 16),
				shapeXYToInt(2, 17),shapeXYToInt(5, 17),shapeXYToInt(2, 18),shapeXYToInt(5, 18),
				shapeXYToInt(2, 19),shapeXYToInt(5, 19),shapeXYToInt(2, 20),shapeXYToInt(5, 20),shapeXYToInt(2, 21),shapeXYToInt(3, 21),shapeXYToInt(4, 21),shapeXYToInt(5, 21)};
		int[] vNum={shapeXYToInt(6, 17),shapeXYToInt(8, 17),shapeXYToInt(6, 18),shapeXYToInt(8, 18),
				shapeXYToInt(6, 19),shapeXYToInt(8, 19),shapeXYToInt(6, 20),shapeXYToInt(8, 20),shapeXYToInt(6, 21),shapeXYToInt(8, 21),
				shapeXYToInt(7, 21)};
		int[] oeNum={shapeXYToInt(9, 17),shapeXYToInt(10, 17),shapeXYToInt(11, 17),shapeXYToInt(9, 18),shapeXYToInt(11, 18),shapeXYToInt(9, 19),
				shapeXYToInt(10, 19),shapeXYToInt(11, 19),shapeXYToInt(9, 20),shapeXYToInt(10, 21),shapeXYToInt(9, 21),
				shapeXYToInt(11, 21)};
		int[] rNum={shapeXYToInt(12, 17),shapeXYToInt(13, 17),shapeXYToInt(14, 17),shapeXYToInt(12, 18),
				shapeXYToInt(14, 18),shapeXYToInt(12, 19),shapeXYToInt(12, 20),shapeXYToInt(12, 21)};
		for (int i = 0; i < gNum.length; i++) {
			xyList.get(gNum[i]).setDraw(true);
			xyList.get(gNum[i]).setImage(gColor);
		}
		for (int i = 0; i < aNum.length; i++) {
			xyList.get(aNum[i]).setDraw(true);
			xyList.get(aNum[i]).setImage(aColor);
		}
		for (int i = 0; i < mNum.length; i++) {
			xyList.get(mNum[i]).setDraw(true);
			xyList.get(mNum[i]).setImage(mColor);
		}
		for (int i = 0; i < geNum.length; i++) {
			xyList.get(geNum[i]).setDraw(true);
			xyList.get(geNum[i]).setImage(geColor);
		}
		for (int i = 0; i < oNum.length; i++) {
			xyList.get(oNum[i]).setDraw(true);
			xyList.get(oNum[i]).setImage(oColor);
		}
		for (int i = 0; i < vNum.length; i++) {
			xyList.get(vNum[i]).setDraw(true);
			xyList.get(vNum[i]).setImage(vColor);
		}
		for (int i = 0; i < oeNum.length; i++) {
			xyList.get(oeNum[i]).setDraw(true);
			xyList.get(oeNum[i]).setImage(oeColor);
		}
		for (int i = 0; i < rNum.length; i++) {
			xyList.get(rNum[i]).setDraw(true);
			xyList.get(rNum[i]).setImage(rColor);
		}
	}
}
