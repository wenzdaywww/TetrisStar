package com.www.gameview;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.util.HashMap;
import javax.swing.JPanel;
import com.www.gamemodel.DrawArea;
import com.www.gamemodel.GridBlock;
/**
 * ����Ԥ��������
 * @author wWw
 *
 */
@SuppressWarnings("serial")
public class NextShowPanel extends JPanel {
	/** @see Ԥ�����򷽿鼯��*/
	private HashMap<Integer, DrawArea> nextxyList=new HashMap<Integer, DrawArea>();	
	/**
	 * ��ʼ������
	 */
	public NextShowPanel() {
		setBounds(GridBlock.SIZE*2, GridBlock.SIZE*2, GridBlock.SIZE*4,GridBlock.SIZE*3);
		setOpaque(false);
		setBackground(null);
		clearNextShowPanel();
	}
	public void showNextShape(int shapeNum,String level){
		switch (shapeNum) {
		case 0:
			showLeftLShape(GridBlock.shapeImage);
			break;
		case 1:
			showRightLShape(GridBlock.shapeImage);
			break;
		case 2:
			showTShape(GridBlock.shapeImage);
			break;
		case 3:
			showLeftZShape(GridBlock.shapeImage);
			break;
		case 4:
			showRightZShape(GridBlock.shapeImage);
			break;
		case 5:
			showSquareShape(GridBlock.shapeImage);
			break;
		case 6:
			showLineShape(GridBlock.shapeImage);
			break;
		case 7:
			if (level.equals("����ģʽ")) {
				showBombShape("image/bomb.png");
			}else {
				showConcaveShape(GridBlock.shapeImage);
			}
			break;
		case 8:
			if (level.equals("�м�ģʽ")) {
				showBombShape("image/bomb.png");
			}else {
				showCrossShape(GridBlock.shapeImage);
			}

			break;
		case 9:
			showBombShape("image/bomb.png");
			break;
		default:
			break;
		}
	}
	/**
	 * ���Ԥ����
	 */
	private void clearNextShowPanel() {
		clearNextShow();
		this.repaint();
	}
	/**
	 * ���÷��鼯��
	 */
	private void clearNextShow(){
		for (int i = 1; i <= 12; i++) {
			nextxyList.put(i, new DrawArea(intToShapeX(i), intToShapeY(i), false, "",false));
		}
	}
	/**
	 * ��ʾ���η���
	 * @param shapeImage ����ͼƬ
	 */
	private void showConcaveShape(String shapeImage){
		clearNextShow();
		nextxyList.get(shapeXYToInt(1, 1)).setDraw(true);
		nextxyList.get(shapeXYToInt(1, 2)).setDraw(true);
		nextxyList.get(shapeXYToInt(1, 3)).setDraw(true);
		nextxyList.get(shapeXYToInt(2, 1)).setDraw(true);
		nextxyList.get(shapeXYToInt(3, 1)).setDraw(true);
		nextxyList.get(shapeXYToInt(3, 2)).setDraw(true);
		nextxyList.get(shapeXYToInt(3, 3)).setDraw(true);
		nextxyList.get(shapeXYToInt(1, 1)).setImage(shapeImage);
		nextxyList.get(shapeXYToInt(1, 2)).setImage(shapeImage);
		nextxyList.get(shapeXYToInt(1, 3)).setImage(shapeImage);
		nextxyList.get(shapeXYToInt(2, 1)).setImage(shapeImage);
		nextxyList.get(shapeXYToInt(3, 1)).setImage(shapeImage);
		nextxyList.get(shapeXYToInt(3, 2)).setImage(shapeImage);
		nextxyList.get(shapeXYToInt(3, 3)).setImage(shapeImage);
		this.repaint();
	}
	/**
	 * ��ʾʮ���η���
	 * @param shapeImage ����ͼƬ
	 */
	private void showCrossShape(String shapeImage){
		clearNextShow();
		nextxyList.get(shapeXYToInt(2, 1)).setDraw(true);
		nextxyList.get(shapeXYToInt(1, 2)).setDraw(true);
		nextxyList.get(shapeXYToInt(2, 2)).setDraw(true);
		nextxyList.get(shapeXYToInt(2, 3)).setDraw(true);
		nextxyList.get(shapeXYToInt(3, 2)).setDraw(true);
		nextxyList.get(shapeXYToInt(2, 1)).setImage(shapeImage);
		nextxyList.get(shapeXYToInt(1, 2)).setImage(shapeImage);
		nextxyList.get(shapeXYToInt(2, 2)).setImage(shapeImage);
		nextxyList.get(shapeXYToInt(2, 3)).setImage(shapeImage);
		nextxyList.get(shapeXYToInt(3, 2)).setImage(shapeImage);
		this.repaint();
	}
	/**
	 * ��ʾ��L����
	 * @param shapeImage ����ͼƬ
	 */
	private void showLeftLShape(String shapeImage){
		clearNextShow();
		nextxyList.get(shapeXYToInt(1, 1)).setDraw(true);
		nextxyList.get(shapeXYToInt(1, 2)).setDraw(true);
		nextxyList.get(shapeXYToInt(2, 2)).setDraw(true);
		nextxyList.get(shapeXYToInt(3, 2)).setDraw(true);
		nextxyList.get(shapeXYToInt(1, 1)).setImage(shapeImage);
		nextxyList.get(shapeXYToInt(1, 2)).setImage(shapeImage);
		nextxyList.get(shapeXYToInt(2, 2)).setImage(shapeImage);
		nextxyList.get(shapeXYToInt(3, 2)).setImage(shapeImage);
		this.repaint();
	}
	/**
	 * ��ʾ��Z����
	 * @param shapeImage ����ͼƬ
	 */
	private void showLeftZShape(String shapeImage){
		clearNextShow();
		nextxyList.get(shapeXYToInt(1, 1)).setDraw(true);
		nextxyList.get(shapeXYToInt(2, 1)).setDraw(true);
		nextxyList.get(shapeXYToInt(2, 2)).setDraw(true);
		nextxyList.get(shapeXYToInt(3, 2)).setDraw(true);
		nextxyList.get(shapeXYToInt(1, 1)).setImage(shapeImage);
		nextxyList.get(shapeXYToInt(2, 1)).setImage(shapeImage);
		nextxyList.get(shapeXYToInt(2, 2)).setImage(shapeImage);
		nextxyList.get(shapeXYToInt(3, 2)).setImage(shapeImage);
		this.repaint();
	}
	/**
	 * ��ʾֱ���η���
	 * @param shapeImage ����ͼƬ
	 */
	private void showLineShape(String shapeImage){
		clearNextShow();
		nextxyList.get(shapeXYToInt(1, 1)).setDraw(true);
		nextxyList.get(shapeXYToInt(2, 1)).setDraw(true);
		nextxyList.get(shapeXYToInt(3, 1)).setDraw(true);
		nextxyList.get(shapeXYToInt(4, 1)).setDraw(true);
		nextxyList.get(shapeXYToInt(1, 1)).setImage(shapeImage);
		nextxyList.get(shapeXYToInt(2, 1)).setImage(shapeImage);
		nextxyList.get(shapeXYToInt(3, 1)).setImage(shapeImage);
		nextxyList.get(shapeXYToInt(4, 1)).setImage(shapeImage);
		this.repaint();
	}
	/**
	 * ��ʾ��L����
	 * @param shapeImage ����ͼƬ
	 */
	private void showRightLShape(String shapeImage){
		clearNextShow();
		nextxyList.get(shapeXYToInt(3, 1)).setDraw(true);
		nextxyList.get(shapeXYToInt(1, 2)).setDraw(true);
		nextxyList.get(shapeXYToInt(2, 2)).setDraw(true);
		nextxyList.get(shapeXYToInt(3, 2)).setDraw(true);
		nextxyList.get(shapeXYToInt(3, 1)).setImage(shapeImage);
		nextxyList.get(shapeXYToInt(1, 2)).setImage(shapeImage);
		nextxyList.get(shapeXYToInt(2, 2)).setImage(shapeImage);
		nextxyList.get(shapeXYToInt(3, 2)).setImage(shapeImage);
		this.repaint();
	}
	/**
	 * ��ʾ��Z����
	 * @param shapeImage ����ͼƬ
	 */
	private void showRightZShape(String shapeImage){
		clearNextShow();
		nextxyList.get(shapeXYToInt(3, 1)).setDraw(true);
		nextxyList.get(shapeXYToInt(2, 1)).setDraw(true);
		nextxyList.get(shapeXYToInt(2, 2)).setDraw(true);
		nextxyList.get(shapeXYToInt(1, 2)).setDraw(true);
		nextxyList.get(shapeXYToInt(3, 1)).setImage(shapeImage);
		nextxyList.get(shapeXYToInt(2, 1)).setImage(shapeImage);
		nextxyList.get(shapeXYToInt(2, 2)).setImage(shapeImage);
		nextxyList.get(shapeXYToInt(1, 2)).setImage(shapeImage);
		this.repaint();
	}
	/**
	 * ���������η���
	 * @param shapeImage ����ͼƬ
	 */
	private void showSquareShape(String shapeImage){
		clearNextShow();
		nextxyList.get(shapeXYToInt(1, 1)).setDraw(true);
		nextxyList.get(shapeXYToInt(2, 1)).setDraw(true);
		nextxyList.get(shapeXYToInt(2, 2)).setDraw(true);
		nextxyList.get(shapeXYToInt(1, 2)).setDraw(true);
		nextxyList.get(shapeXYToInt(1, 1)).setImage(shapeImage);
		nextxyList.get(shapeXYToInt(2, 1)).setImage(shapeImage);
		nextxyList.get(shapeXYToInt(2, 2)).setImage(shapeImage);
		nextxyList.get(shapeXYToInt(1, 2)).setImage(shapeImage);
		this.repaint();
	}
	/**
	 * ��ʾT�η���
	 * @param shapeImage ����ͼƬ
	 */
	private void showTShape(String shapeImage){
		clearNextShow();
		nextxyList.get(shapeXYToInt(2, 1)).setDraw(true);
		nextxyList.get(shapeXYToInt(2, 2)).setDraw(true);
		nextxyList.get(shapeXYToInt(1, 2)).setDraw(true);
		nextxyList.get(shapeXYToInt(3, 2)).setDraw(true);
		nextxyList.get(shapeXYToInt(2, 1)).setImage(shapeImage);
		nextxyList.get(shapeXYToInt(2, 2)).setImage(shapeImage);
		nextxyList.get(shapeXYToInt(1, 2)).setImage(shapeImage);
		nextxyList.get(shapeXYToInt(3, 2)).setImage(shapeImage);
		this.repaint();
	}
	/**
	 * ��ʾը��
	 * @param shapeImage ����ͼƬ
	 */
	private void showBombShape(String shapeImage){
		clearNextShow();
		nextxyList.get(shapeXYToInt(2, 2)).setDraw(true);
		nextxyList.get(shapeXYToInt(2, 2)).setImage(shapeImage);
		this.repaint();
	}
	/**
	 * �����ػ�
	 */
	@Override
	protected void paintComponent(Graphics g) {
		for (int i = 1; i <= nextxyList.size(); i++) {
			if (nextxyList.get(i).isDraw()) {
				Image image=Toolkit.getDefaultToolkit().getImage(nextxyList.get(i).getImage());
				g.drawImage(image, (nextxyList.get(i).getX()-1)*GridBlock.SIZE, (nextxyList.get(i).getY()-1)*GridBlock.SIZE, this);
			}
		}
	}
	/**
	 * �������ת����X����
	 * @param i ����X����
	 * @return �������
	 */
	private int intToShapeX(int i){
		if ((i%4)==0) {
			return 4;
		}else {
			return i%4;
		}
	}
	/**
	 * �������ת����Y����
	 * @param i ����Y����
	 * @return �������
	 */
	private int intToShapeY(int i){
		if ((i%4)==0) {
			return i/4;
		}else {
			return (i/4)+1;
		}
	}
	/**
	 * xy����ת���ɷ������
	 * @param x ����X����
	 * @param y ����Y����
	 * @return �������
	 */
	private int shapeXYToInt(int x,int y){
		return (x+4*(y-1));
	}
}
