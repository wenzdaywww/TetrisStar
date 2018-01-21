package com.www.gamecontrol;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import com.www.gameview.MainFrame;
import com.www.gamemodel.GridBlock;
import com.www.gamemodel.SoundModel;
/**
 * ���̼���������
 * @author wWw
 *
 */
public class KeyControl extends KeyAdapter {
	/**@see ���񷽿����*/
	private GridBlock gridBlock;
	/**@see ���������*/
	private MainFrame mainFrame;
	/**@see ��������*/
	private SoundModel soundModel;	
	/**@see ��ʱ������*/
	private TimerControl timerCtrl;
	/**
	 * ���������вι��췽�������ݶ���
	 * @param mainFrame	���������
	 * @param timerControl	��������
	 * @param soundModel	��ʱ������
	 * @param gridBlock ���񷽿����
	 */
	public KeyControl(MainFrame mainFrame,TimerControl timerControl,SoundModel soundModel,GridBlock gridBlock) {
		this.gridBlock=gridBlock;
		this.mainFrame=mainFrame;
		this.soundModel=soundModel;
		this.timerCtrl=timerControl;
		this.mainFrame.addKeyListener(this); //����������Ӽ��̼���
	}
	/**
	 * ���̼��������¼�
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:	//���1�������ת
			if (timerCtrl.getRunningOrPause()) { //�ж��Ƿ���ͣ��falseΪ��ͣ
				gridBlock.player1Rotate();    //�������ת
				if (mainFrame.radioBtnSounds.isSelected()) {	//��������Ч��ѡ��ѡ�в��з�����ת��Ч
					soundModel.rotateSound.play();	//������ת��Ч
				}
			}
			break;
		case KeyEvent.VK_DOWN:	//���1�����ֶ��������
			if (timerCtrl.getRunningOrPause()) {	//�ж��Ƿ���ͣ��falseΪ��ͣ
				gridBlock.player1Down();	//��������
			}
			break;
		case KeyEvent.VK_LEFT:	//���1��������
			if (timerCtrl.getRunningOrPause()) {	//�ж��Ƿ���ͣ��falseΪ��ͣ
				gridBlock.player1Left();	//��������
			}
			break;
		case KeyEvent.VK_RIGHT:	//���1��������
			if (timerCtrl.getRunningOrPause()) {	//�ж��Ƿ���ͣ��falseΪ��ͣ
				gridBlock.player1Right();	//��������
			}
			break;
		case KeyEvent.VK_W:	//���2�������ת
			if (GridBlock.COL==25) {
				if (timerCtrl.getRunningOrPause()) { //�ж��Ƿ���ͣ��falseΪ��ͣ
					gridBlock.player2Rotate();    //�������ת
					if (mainFrame.radioBtnSounds.isSelected()) {	//��������Ч��ѡ��ѡ�в��з�����ת��Ч
						soundModel.rotateSound.play();	//������ת��Ч
					}
				}
			}
			break;
		case KeyEvent.VK_S:	//���2�����ֶ��������
			if (GridBlock.COL==25) {
				if (timerCtrl.getRunningOrPause()) {	//�ж��Ƿ���ͣ��falseΪ��ͣ
					gridBlock.player2Down();	//��������
				}
			}
			break;
		case KeyEvent.VK_A:	//���2��������
			if (GridBlock.COL==25) {
				if (timerCtrl.getRunningOrPause()) {	//�ж��Ƿ���ͣ��falseΪ��ͣ
					gridBlock.player2Left();	//��������
				}
			}
			break;
		case KeyEvent.VK_D:	//���2��������
			if (GridBlock.COL==25) {
				if (timerCtrl.getRunningOrPause()) {	//�ж��Ƿ���ͣ��falseΪ��ͣ
					gridBlock.player2Right();	//��������
				}
			}
			break;
		case KeyEvent.VK_SPACE:	//��Ϸ��ͣ/�����Ŀ���
			if (timerCtrl.getRunningOrPause()==true) {	
				timerCtrl.setRunningOrPause(false);	//��Ϸ��ͣ
				mainFrame.btnPause.setBtnText("�������ո�");	//������ͣ��ť���ı�
			}else if (timerCtrl.getRunningOrPause()==false) {
				timerCtrl.setRunningOrPause(true);		//������Ϸ
				mainFrame.btnPause.setBtnText("��ͣ���ո�");	//������ͣ��ť���ı�
			}
			break;
		case KeyEvent.VK_Q:	//����Ԥ������һ������
			if (mainFrame.diyDialog.chckbxChangeNext.isSelected()) {	//�Զ���ģʽ�С��������顱ѡ�в��������
				gridBlock.randomShape(mainFrame.diyDialog.chckbxBoom.isSelected());	//�����һ������
				mainFrame.nextShowPanel.showNextShape(gridBlock.shapeNum, gridBlock.level);
			}
			break;
		case KeyEvent.VK_E:	//���������������
			if (mainFrame.diyDialog.chckbxCtrlSpeed.isSelected()&&timerCtrl.getRunningOrPause()) {
				if (timerCtrl.getLoopTime()>50) {	//�����ٶ����ֻ����50ms
					timerCtrl.starNewLoopTime(timerCtrl.getLoopTime()-50);	//��ǰ�ٶ�-50ms
				}
			}
			break;
		case KeyEvent.VK_R:	//���������������
			if (mainFrame.diyDialog.chckbxCtrlSpeed.isSelected()&&timerCtrl.getRunningOrPause()) {
				if (timerCtrl.getLoopTime()<1000) {	//�����ٶ�����ֻ����1000ms
					timerCtrl.starNewLoopTime(timerCtrl.getLoopTime()+50);	//��ǰ�ٶ�+50ms
				}
			}
			break;
		case KeyEvent.VK_T://���¿�ʼ
			timerCtrl.setRestartGame(true);	//�������¿�ʼ
			timerCtrl.setRunningOrPause(true);	//����Ϊ��Ϸ���Լ���
			mainFrame.btnPause.setVisible(true); //��ʾ����ͣ/��������ť
			mainFrame.btnPause.setBtnText("��ͣ���ո�");//���á���ͣ/��������ť�ı�
			break;
		default:
			break;
		}
		mainFrame.blockPanel.repaint();
	}
}
