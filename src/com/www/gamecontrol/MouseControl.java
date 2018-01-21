package com.www.gamecontrol;

import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import com.www.gamemodel.RWScore;
import java.awt.event.ActionEvent;

import com.www.gameview.BackgroupPanel;
import com.www.gameview.MainFrame;
import java.awt.event.WindowEvent;
import com.www.gamemodel.GridBlock;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import com.www.gamemodel.SoundModel;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeListener;
import java.awt.event.MouseMotionAdapter;
/**
 * �������¼�������
 * @author wWw
 *
 */
public class MouseControl{
	/**@see ��ȡ�����ק֮ǰ��X����*/
	private int mx=0;
	/**@see ��ȡ�����ק֮ǰ��Y����*/
	private int my=0;				
	/**@see ע�ᴰ���X����*/
	private int jfx=0;				
	/**@see ע�ᴰ���Y����*/
	private int jfy=0;			
	/**@see ���������ı�����*/
	private RWScore rwScore;	
	/**@see ���񷽿����*/
	private GridBlock gridBlock;
	/**@see ���������*/
	private MainFrame mainFrame;	
	/**@see ��������*/
	private SoundModel soundModel;	
	/**@see �����������������*/
	private MouseSound mouseSound;	
	/**@see ��ʱ������*/
	private TimerControl timerCtrl;	
	/**
	 * ���������Ƶ��вι��췽�������ݶ���
	 * @param mainFrame	���������
	 * @param timerCtrl ��ʱ������
	 * @param soundModel ��������
	 * @param gridBlock ���񷽿����
	 */ 
	public MouseControl(MainFrame mainFrame,TimerControl timerCtrl,SoundModel soundModel,GridBlock gridBlock) {
		this.mainFrame=mainFrame;
		this.gridBlock=gridBlock;
		this.timerCtrl=timerCtrl;
		this.soundModel=soundModel;
		mouseSound=new MouseSound();	//���������������������
		rwScore=new RWScore();			//���������ı�����
		rwScore.scoreRank();			//��������ı��еķ���
		clickCtrl();					//����¼�����
	}
	/**
	 * ���д��塢�Ի������������¼�����
	 **/
	private void clickCtrl(){
		itemClick();			//������˵����ĵ������
		messageClick();			//��ʾ�Ի���������
		diyDialogClick();		//�Զ���ģʽ�Կ�������
		componentSound();		//�����������Ч
		loginFrameClick();		//����Ի���������
		mainFrameBtnClick();	//�����尴ť��ǩ�������
	}
	/**
	 * ������ʾ�Ի���ĵ���������˳�ʱ����ʾ����Ϸ����ʱ�ϴ���������ʾ��
	 * �����ϴ��ɹ�����ʾ��
	 **/
	private void messageClick(){
		//==========ȷ����ť�ĵ������========
		mainFrame.messageDialog.btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (mainFrame.messageDialog.getTitle().equals("�˳���ʾ")) {		//����˳���ť����ʾ���ȷ������
					System.exit(0);		//�˳���Ϸ
				}else if (mainFrame.messageDialog.getTitle().equals("�ϴ�����")) {	//��Ϸ�������ϴ��������ѵ�ȷ������
					mainFrame.messageDialog.setVisible(false);	//������ʾ��
					//�ϴ��������ģʽ���������ı�
					rwScore.writeScore("User:"+mainFrame.registerFrame.gameUserTextField.getText()+"Model:"+
							gridBlock.level+"Score:"+Integer.toString(gridBlock.socre));
					rwScore.scoreRank();	//�����ı��ķ����������´η����Ķ�ȡ
					uploadSuccessDialog();	//�����ϴ��ɹ���ʾ��
				}
			}
		});
		//=========ȡ����ť�ĵ������=========
		mainFrame.messageDialog.btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainFrame.messageDialog.setVisible(false);	//������ʾ��
			}
		});
	}
	/**
	 * ���ע�ᴰ��ĵ������
	 **/
	private void loginFrameClick(){
		//==========ע�ᴰ��������ѱ����أ�����������ƶ�����=========
		mainFrame.registerFrame.loginPanel.addMouseMotionListener(new MouseMotionAdapter() {	//�������˶��������������ƶ�����
			@Override
			public void mouseDragged(MouseEvent e) {	//����϶��¼������ƶ�����
				mainFrame.registerFrame.setLocation(jfx+(e.getXOnScreen()-mx), jfy+(e.getYOnScreen()-my));	//�����ƶ��ĵ�λ���㷨
			}
		});
		//==========��ȡ�������������==========
		mainFrame.registerFrame.loginPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {	//��ȡ��������
				mx=e.getXOnScreen();				//��ȡ�����ק֮ǰ��X����
				my=e.getYOnScreen();				//��ȡ�����ק֮ǰ��Y����
				jfx=mainFrame.registerFrame.getX();	//��ȡ�����X����
				jfy=mainFrame.registerFrame.getY();	//��ȡ�����Y����
			}
		});
		//==========ע�ᴰ����˳�/ȡ����ť�¼�==========
		mainFrame.registerFrame.btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (mainFrame.registerFrame.btnExit.getBtnText().equals("ȡ��")) {	//��������ѡ��ע����Ҵ������Ƿ��ص�������
					mainFrame.registerFrame.gameUserTextField.setText("");		//ȡ��ע����������������
					mainFrame.registerFrame.setVisible(false);		//���ص������
				}else {		//����һ��ʼʱ�ǡ��˳���
					System.exit(0);
				}
			}
		});
		//==========ע�ᰴť�¼�=========
		mainFrame.registerFrame.btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (mainFrame.registerFrame.btnRegister.getBtnText().equals("������Ϸ")) {	//����һ��ʼʱ�ǡ�������Ϸ��
					mainFrame.setVisible(true);		//��ʾ������
					mainFrame.registerFrame.setVisible(false);	//����ע�ᴰ��
				}else {	//��������ѡ��ע�ᴰ���������������ֱ������ע�ᴰ��
					mainFrame.registerFrame.setVisible(false);
				}
			}
		});
		//=========������������볤��С��5���ַ�========
		mainFrame.registerFrame.gameUserTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (mainFrame.registerFrame.gameUserTextField.getText().length()<5) {
				}else {
					e.consume();	//API��ʹ�ô��¼����Ա㲻�ᰴ��Ĭ�ϵķ�ʽ�ɲ������¼���Դ������������¼��� 
				}
			}
		});
	}
	/**
	 * �Զ���Ի���������
	 **/
	private void diyDialogClick(){
		//==========�Զ���Ի����ȷ��===========
		mainFrame.diyDialog.btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (mainFrame.diyDialog.rdbtnSimple.isSelected()||mainFrame.diyDialog.rdbtnMiddle.isSelected()||
						mainFrame.diyDialog.rdbtnSenior.isSelected()) {
					if (mainFrame.diyDialog.rdbtnSimple.isSelected()) {	//��ѡ��ѡ�г���ģʽ
						gridBlock.level="����ģʽ";	//����Ϊ����ģʽ
					}else if (mainFrame.diyDialog.rdbtnMiddle.isSelected()) {	//��ѡ��ѡ�г���ģʽ
						gridBlock.level="�м�ģʽ";	//����Ϊ�м�ģʽ
					}else if (mainFrame.diyDialog.rdbtnSenior.isSelected()) {
						gridBlock.level="�߼�ģʽ";	//����Ϊ�߼�ģʽ
					}
					mainFrame.btnPause.setVisible(true);	//��ʾ����ͣ/��������ť
					mainFrame.btnRestart.setVisible(true);	//��ʾ�����¿�ʼ����ť
					mainFrame.setLabelLevel("�Զ���");	//��ʾ��ǰ��ϷΪ�Զ���ģʽ
					timerCtrl.starNewLoopTime(mainFrame.diyDialog.slider.getValue());	//��ȡ�������ٶ���ֵ�����䵽��ʱ��
				}
				timerCtrl.setRestartGame(true);	//����δ���¿�ʼ��Ϸ
				timerCtrl.setRunningOrPause(true);	//״̬��Ϊtrue������ͣ
				mainFrame.diyDialog.setVisible(false);	//�����Զ���Ի���
			}
		});
		//==========������״��ѡ�в���ʾ��ʼ��Ϸ��ť==========
		mainFrame.diyDialog.rdbtnSimple.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (mainFrame.diyDialog.rdbtnSimple.isSelected()) {
					mainFrame.diyDialog.btnOk.setVisible(true);
				}
			}
		});
		//==========������״��ѡ�в���ʾ��ʼ��Ϸ��ť==========
		mainFrame.diyDialog.rdbtnMiddle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (mainFrame.diyDialog.rdbtnMiddle.isSelected()) {
					mainFrame.diyDialog.btnOk.setVisible(true);
				}
			}
		});
		//==========������״��ѡ�в���ʾ��ʼ��Ϸ��ť==========
		mainFrame.diyDialog.rdbtnSenior.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (mainFrame.diyDialog.rdbtnSenior.isSelected()) {
					mainFrame.diyDialog.btnOk.setVisible(true);
				}
			}
		});
		//==========�Զ���Ի����ȡ��===========
		mainFrame.diyDialog.btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainFrame.diyDialog.setVisible(false);
			}
		});
		//==========������ѡ��==========
		mainFrame.diyDialog.chckbxHlepLine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (mainFrame.diyDialog.chckbxHlepLine.isSelected()) {	//ѡ�����߸�ѡ������ʾ���������������
					GridBlock.helpLine=true;
				}else {		//ȡ�������߸�ѡ������ʾ���������������
					GridBlock.helpLine=false;
				}
				mainFrame.blockPanel.repaint();
			}
		});
		//==========ѡ���Ƿ���ʾԤ������==========
		mainFrame.diyDialog.chckbxShowNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (mainFrame.diyDialog.chckbxShowNext.isSelected()) {	//��������ʾ��ѡ������ʾ����Ԥ��
					mainFrame.nextShowPanel.setVisible(true);
					mainFrame.labelNextShape.setVisible(true);
					mainFrame.diyDialog.chckbxChangeNext.setEnabled(true);
				}else {		//��������ʾ��ȡ������ʾ����Ԥ��
					mainFrame.nextShowPanel.setVisible(false);
					mainFrame.labelNextShape.setVisible(false);
					mainFrame.diyDialog.chckbxChangeNext.setEnabled(false);
				}
			}
		});
		//==========�Ƿ���Ը�����һ������İ�ť==========
		mainFrame.diyDialog.chckbxChangeNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (mainFrame.diyDialog.chckbxChangeNext.isSelected()) {	//���������顱ѡ������ʾ���������顱��ť
					mainFrame.btnChangeNext.setVisible(true);
				}else {		//���������顱ȡ������ʾ���������顱��ť
					mainFrame.btnChangeNext.setVisible(false);
				}
			}
		});
		//==========���Ʒ������������ٶȼӼ��İ�ť��ʾ==========
		mainFrame.diyDialog.chckbxCtrlSpeed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (mainFrame.diyDialog.chckbxCtrlSpeed.isSelected()) {		//�����������ٶȡ�ѡ������ʾ�ٶȰ�ť
					mainFrame.btnSpeedUp.setVisible(true);
					mainFrame.btnSpeedDown.setVisible(true);
				}else {		//�����������ٶȡ�ȡ������ʾ�ٶȰ�ť
					mainFrame.btnSpeedUp.setVisible(false);
					mainFrame.btnSpeedDown.setVisible(false);
				}
			}
		});
		//==========�޸���Ϸ������==========
		mainFrame.diyDialog.checkBoxChangeCol.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (mainFrame.diyDialog.checkBoxChangeCol.isSelected()) {
					GridBlock.COL=(int) mainFrame.diyDialog.spinnerPanelCol.getValue();	//��ȡ����
					mainFrame.changFrame();	//�ı䴰��
					timerCtrl.setRestartGame(true);	//����Ϊ���¿�ʼ
					timerCtrl.setRunningOrPause(true);	//����Ϊ������ͣ
					mainFrame.btnPause.setVisible(true); //��ʾ����ͣ/��������ť
					mainFrame.btnRestart.setVisible(true);	//��ʾ�����¿�ʼ����ť
					mainFrame.diyDialog.setVisible(false);
					mainFrame.btnPause.setBtnText("��ͣ���ո�"); //��ʾ����ͣ/��������ť���ı�
				}
			}
		});
		//==========����һ��ѡ��ť==========
		mainFrame.diyDialog.rdbtnStyle1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (mainFrame.diyDialog.rdbtnStyle1.isSelected()) {
					BackgroupPanel.backgroupImage="image/style1.jpg";
					mainFrame.repaint();
					mainFrame.diyDialog.repaint();
				}
			}
		});
		//==========�������ѡ��ť==========
		mainFrame.diyDialog.rdbtnStyle2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (mainFrame.diyDialog.rdbtnStyle2.isSelected()) {
					BackgroupPanel.backgroupImage="image/style2.jpg";
					mainFrame.repaint();
					mainFrame.diyDialog.repaint();
				}
			}
		});
		//==========��������ѡ��ť==========
		mainFrame.diyDialog.rdbtnStyle3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (mainFrame.diyDialog.rdbtnStyle3.isSelected()) {
					BackgroupPanel.backgroupImage="image/style3.jpg";
					mainFrame.repaint();
					mainFrame.diyDialog.repaint();
				}
			}
		});
	}
	/**
	 * �����尴ť�ͱ�ǩ����¼�����
	 **/
	private void mainFrameBtnClick(){
		//===========��ǩͼƬ�����ϵĵ��==========
		mainFrame.labelUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (timerCtrl.getRunningOrPause()) {	//��Ϸδ��ͣ������ת
					gridBlock.player1Rotate();
					mainFrame.blockPanel.repaint();
				}
			}
		});
		//==========��ǩͼƬ�����µĵ��===========
		mainFrame.labelDown.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (timerCtrl.getRunningOrPause()) {	//��Ϸδ��ͣ��������
					gridBlock.player1Down();
					mainFrame.blockPanel.repaint();
				}
			}
		});
		//===========��ǩͼƬ������ĵ��==========
		mainFrame.labelLeft.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (timerCtrl.getRunningOrPause()) {	//��Ϸδ��ͣ��������
					gridBlock.player1Left();
					mainFrame.blockPanel.repaint();
				}
			}
		});
		//==========��ǩͼƬ�����ҵĵ��============
		mainFrame.labelRight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (timerCtrl.getRunningOrPause()) {	//��Ϸδ��ͣ��������
					gridBlock.player1Right();
					mainFrame.blockPanel.repaint();
				}
			}
		});
		//==========������Ĺرհ�ť============
		mainFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				showExitDialog();	//�����˳���ʾ
			}
		});
		//===========��ť������һ������=============
		mainFrame.btnChangeNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gridBlock.randomShape(mainFrame.diyDialog.chckbxBoom.isSelected());	//���ѡ����һ������
				mainFrame.nextShowPanel.showNextShape(gridBlock.shapeNum, gridBlock.level);//����Ԥ������ʾ��һ������
			}
		});
		//===========��ͣ/����=========
		mainFrame.btnPause.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (timerCtrl.getRunningOrPause()==true) {	
					timerCtrl.setRunningOrPause(false);
					mainFrame.btnPause.setBtnText("�������ո�");
				}else if (timerCtrl.getRunningOrPause()==false) {
					timerCtrl.setRunningOrPause(true); 
					mainFrame.btnPause.setBtnText("��ͣ���ո�");
				}
			}
		});
		//==========��Ч��ѡ�����===========
		mainFrame.radioBtnSounds.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ImageIcon musicIcoOn=new ImageIcon("image/soundson.png");
				ImageIcon musicIcoOff=new ImageIcon("image/soundsoff.png");
				if (mainFrame.radioBtnSounds.isSelected()) {
					mainFrame.radioBtnSounds.setIcon(musicIcoOn);	//��ʾ��������ͼƬ
				}else {
					mainFrame.radioBtnSounds.setIcon(musicIcoOff);	//��ʾ�����ص�ͼƬ
				}
			}
		});
		//===========�������ֿ���==========
		mainFrame.radioBtnMusic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ImageIcon musicIcoOn=new ImageIcon("image/musicon.png");
				ImageIcon musicIcoOff=new ImageIcon("image/musicoff.png");
				if (mainFrame.radioBtnMusic.isSelected()) {
					soundModel.backgroupMusic.loop();
					mainFrame.radioBtnMusic.setIcon(musicIcoOn);	//��ʾ�������ֿ���ͼƬ
				}else {
					soundModel.backgroupMusic.stop();
					mainFrame.radioBtnMusic.setIcon(musicIcoOff);	//��ʾ�������ֿ���ͼƬ
				}
			}
		});
		//==========���¿�ʼ===========
		mainFrame.btnRestart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				timerCtrl.setRestartGame(true);	//����Ϊ���¿�ʼ
				timerCtrl.setRunningOrPause(true);	//����Ϊ������ͣ
				mainFrame.btnPause.setVisible(true); //��ʾ����ͣ/��������ť
				mainFrame.btnPause.setBtnText("��ͣ���ո�"); //��ʾ����ͣ/��������ť���ı�
			}
		});
		//==========�������������ٶȼ���=========
		mainFrame.btnSpeedUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (timerCtrl.getRunningOrPause()) {
					if (timerCtrl.getLoopTime()>50) {	//�����ٶ����ֻ����50ms
						timerCtrl.starNewLoopTime(timerCtrl.getLoopTime()-50);	//��ǰ�ٶ�-50ms
					}
				}
			}
		});
		//==========�������������ٶȼ���==========
		mainFrame.btnSpeedDown.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (timerCtrl.getRunningOrPause()) {
					if (timerCtrl.getLoopTime()<1000) {	//�����ٶ�����ֻ����1000ms
						timerCtrl.starNewLoopTime(timerCtrl.getLoopTime()+50);	//��ǰ�ٶ�+50ms
					}
				}
			}
		});
		//==========��ǩʵʱ��ʾ������ֵ===========
		mainFrame.diyDialog.slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				mainFrame.diyDialog.showLoopTime(mainFrame.diyDialog.slider.getValue());	//���ñ�ǩ���ı�
			}
		});
	}
	/**
	 * ������˵�������¼�����
	 **/
	private void itemClick() {
		//===========���˲˵�����ģʽѡ��ʼ=============
		mainFrame.singleSimpleRdbItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GridBlock.COL=15;				//������Ϸ��������
				mainFrame.changFrame();			//�ı䴰���С
				timerCtrl.setRestartGame(true);	//�������¿�ʼ
				gridBlock.level="����ģʽ";	//����Ϊ����ģʽ
				timerCtrl.starNewLoopTime(500);	//�����µĶ�ʱ��ִ������Ϊ500ms
				mainFrame.setLabelLevel("����");	//��ǩ��ʾ��ǰģʽ
				mainFrame.btnPause.setVisible(true);	//��ʾ����ͣ/��������ť
				mainFrame.btnRestart.setVisible(true);	//��ʾ�����¿�ʼ����ť
				mainFrame.btnPause.setBtnText("��ͣ���ո�"); 
				mainFrame.diyDialog.chckbxShowNext.setSelected(true);	//�Զ���Ի���ķ���Ԥ��ѡ��
				mainFrame.diyDialog.checkBoxChangeCol.setEnabled(true);
			}
		});
		//==========���˲˵��м�ģʽѡ��ʼ===========
		mainFrame.singleMiddleRdbItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GridBlock.COL=15;				//������Ϸ��������
				mainFrame.changFrame();			//�ı䴰���С
				timerCtrl.setRestartGame(true);	//�������¿�ʼ
				timerCtrl.starNewLoopTime(300);	//�����µĶ�ʱ��ִ������Ϊ300ms
				gridBlock.level="�м�ģʽ";	//����Ϊ�м�ģʽ
				mainFrame.setLabelLevel("�м�");	//��ǩ��ʾ��ǰģʽ
				mainFrame.btnPause.setVisible(true);	//��ʾ����ͣ/��������ť
				mainFrame.btnRestart.setVisible(true);	//��ʾ�����¿�ʼ����ť
				mainFrame.btnPause.setBtnText("��ͣ���ո�"); 
				mainFrame.diyDialog.chckbxShowNext.setSelected(true);	//�Զ���Ի���ķ���Ԥ��ѡ��
				mainFrame.diyDialog.checkBoxChangeCol.setEnabled(true);
			}
		});
		//===========���˲˵��߼�ģʽѡ��ʼ===========
		mainFrame.singleSeniorRdbItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GridBlock.COL=15;				//������Ϸ��������
				mainFrame.changFrame();			//�ı䴰���С
				timerCtrl.setRestartGame(true);	//�������¿�ʼ
				timerCtrl.starNewLoopTime(100);	//�����µĶ�ʱ��ִ������Ϊ100ms
				gridBlock.level="�߼�ģʽ";	//����Ϊ�߼�ģʽ
				mainFrame.setLabelLevel("�߼�");	//��ǩ��ʾ��ǰģʽ
				mainFrame.btnPause.setVisible(true);	//��ʾ����ͣ/��������ť
				mainFrame.btnRestart.setVisible(true);	//��ʾ�����¿�ʼ����ť
				mainFrame.btnPause.setBtnText("��ͣ���ո�"); 
				mainFrame.diyDialog.chckbxShowNext.setSelected(true);	//�Զ���Ի���ķ���Ԥ��ѡ��
				mainFrame.diyDialog.checkBoxChangeCol.setEnabled(true);
			}
		});
		//===========˫�˲˵�����ģʽѡ��ʼ=============
		mainFrame.doubleSimpleRdbItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GridBlock.COL=25;				//������Ϸ����������ֻ����˫����Ϸʱ����25
				mainFrame.changFrame();			//�ı䴰���С
				timerCtrl.setRestartGame(true);	//�������¿�ʼ
				gridBlock.level="����ģʽ";	//����Ϊ����ģʽ
				timerCtrl.starNewLoopTime(500);	//�����µĶ�ʱ��ִ������Ϊ500ms
				mainFrame.setLabelLevel("����");	//��ǩ��ʾ��ǰģʽ
				mainFrame.btnPause.setVisible(true);	//��ʾ����ͣ/��������ť
				mainFrame.btnRestart.setVisible(true);	//��ʾ�����¿�ʼ����ť
				mainFrame.btnPause.setBtnText("��ͣ���ո�"); 
				mainFrame.diyDialog.chckbxShowNext.setSelected(true);	//�Զ���Ի���ķ���Ԥ��ѡ��
				mainFrame.diyDialog.checkBoxChangeCol.setEnabled(false);
			}
		});
		//==========˫�˲˵��м�ģʽѡ��ʼ===========
		mainFrame.doubleMiddleRdbItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GridBlock.COL=25;				//������Ϸ����������ֻ����˫����Ϸʱ����25
				mainFrame.changFrame();			//�ı䴰���С
				timerCtrl.setRestartGame(true);	//�������¿�ʼ
				timerCtrl.starNewLoopTime(300);	//�����µĶ�ʱ��ִ������Ϊ300ms
				gridBlock.level="�м�ģʽ";	//����Ϊ�м�ģʽ
				mainFrame.setLabelLevel("�м�");	//��ǩ��ʾ��ǰģʽ
				mainFrame.btnPause.setVisible(true);	//��ʾ����ͣ/��������ť
				mainFrame.btnRestart.setVisible(true);	//��ʾ�����¿�ʼ����ť
				mainFrame.btnPause.setBtnText("��ͣ���ո�"); 
				mainFrame.diyDialog.chckbxShowNext.setSelected(true);	//�Զ���Ի���ķ���Ԥ��ѡ��
				mainFrame.diyDialog.checkBoxChangeCol.setEnabled(false);
			}
		});
		//===========˫�˲˵��߼�ģʽѡ��ʼ===========
		mainFrame.doubleSeniorRdbItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GridBlock.COL=25;				//������Ϸ����������ֻ����˫����Ϸʱ����25
				mainFrame.changFrame();			//�ı䴰���С
				timerCtrl.setRestartGame(true);	//�������¿�ʼ
				timerCtrl.starNewLoopTime(100);	//�����µĶ�ʱ��ִ������Ϊ100ms
				gridBlock.level="�߼�ģʽ";	//����Ϊ�߼�ģʽ
				mainFrame.setLabelLevel("�߼�");	//��ǩ��ʾ��ǰģʽ
				mainFrame.btnPause.setVisible(true);	//��ʾ����ͣ/��������ť
				mainFrame.btnRestart.setVisible(true);	//��ʾ�����¿�ʼ����ť
				mainFrame.btnPause.setBtnText("��ͣ���ո�"); 
				mainFrame.diyDialog.chckbxShowNext.setSelected(true);	//�Զ���Ի���ķ���Ԥ��ѡ��
				mainFrame.diyDialog.checkBoxChangeCol.setEnabled(false);
			}
		});
		//===========�˵������===========
		mainFrame.godItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rwScore.readerScore();	//�ӷ����ı��л�ȡ����
				showSimpleScore();	//��ʾ����������
				showMiddleScore();	//��ʾ�м�������
				showSeniorScore();	//��ʾ�߼�������
				showNonhumanScore();	//��ʾ��̬������
				mainFrame.godDialog.setVisible(true);	//��ʾ�����Ի���
			}
		});
		//==========�˵��Զ���ģʽ============
		mainFrame.setItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.diyDialog.setVisible(true);	//��ʾ�Զ���ģʽ�Ի���
			}
		});
		//=========���ע��˵�=========
		mainFrame.registerItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.registerFrame.btnRegister.setBtnText("ע��");	//�޸�ע���ע�ᰴť�ı�Ϊ��ע�ᡱ
				mainFrame.registerFrame.btnRegister.setBtnTextXY(40, 16);//�޸��ı�����ʾλ��Ϊ����
				mainFrame.registerFrame.btnExit.setBtnText("ȡ��");	//�޸�ע��İ�ťȡ���ı�Ϊ��ע�ᡱ
				mainFrame.registerFrame.setVisible(true);	//��ʾע�ᴰ��
			}
		});
		//=========�˳���Ϸ�˵�=========
		mainFrame.exitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showExitDialog();	//�����˳���ʾ��
			}
		});
		//=========���ڲ˵�=========
		mainFrame.aboutItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.aboutDialog.setVisible(true);	//��ʾ���ڶԻ���
			}
		});
		//=========��Ϸ˵���˵�=======
		mainFrame.explainItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.explainDialog.setVisible(true);	//��ʾ��Ϸ˵���Ի���
			}
		});
	}
	/**
	 * �������������Ч
	 **/
	private void componentSound(){
		//��ͣ��ť��Ч
		mainFrame.btnPause.addMouseListener(mouseSound);
		//������ٰ�ť��Ч
		mainFrame.btnSpeedUp.addMouseListener(mouseSound);
		//���¿�ʼ��ť��Ч
		mainFrame.btnRestart.addMouseListener(mouseSound);
		//������ٰ�ť��Ч
		mainFrame.btnSpeedDown.addMouseListener(mouseSound);
		//�������鰴ť��Ч
		mainFrame.btnChangeNext.addMouseListener(mouseSound);
		//�Զ���Ի���Ŀ�ʼ��Ϸ��ť��Ч
		mainFrame.diyDialog.btnOk.addMouseListener(mouseSound);
		//�Զ���Ի���ķ��ذ�ť��Ч
		mainFrame.diyDialog.btnCancel.addMouseListener(mouseSound);
		//ע�ᴰ���ע�ᰴť��Ч
		mainFrame.registerFrame.btnRegister.addMouseListener(mouseSound);
		//ע�ᴰ���ȡ����ť��Ч
		mainFrame.registerFrame.btnExit.addMouseListener(mouseSound);
		//��ʾ���ȷ����ť��Ч
		mainFrame.messageDialog.btnOk.addMouseListener(mouseSound);
		//��ʾ���ȡ����ť��Ч
		mainFrame.messageDialog.btnCancel.addMouseListener(mouseSound);
		//��ǩͼ�귽��������
		mainFrame.labelUp.addMouseListener(mouseSound);
		//��ǩͼ�귽��������
		mainFrame.labelDown.addMouseListener(mouseSound);
		//��ǩͼ�귽��������
		mainFrame.labelLeft.addMouseListener(mouseSound);
		//��ǩͼ�귽��������
		mainFrame.labelRight.addMouseListener(mouseSound);
		//���ֵ�ѡ�򿪹���Ч
		mainFrame.radioBtnMusic.addMouseListener(mouseSound);
		//����������Ч
		mainFrame.radioBtnSounds.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				soundModel.buttonSound.play();	//���������Ч
			}
			@Override
			public void mousePressed(MouseEvent e) {
				soundModel.rotateSound.play();	//���������Ч
			}
		});
	}
	/**
	 * �ϴ������ɹ���ʾ�Ի���Ĵ���
	 */
	private void uploadSuccessDialog(){
		mainFrame.messageDialog.setTitle("�ϴ���ʾ");		//�޸ı���
		mainFrame.messageDialog.labelMessage.setText("��ң�"+mainFrame.registerFrame.gameUserTextField.getText()+"  �����ϴ��ɹ���");//��ʾ����
		mainFrame.messageDialog.btnCancel.setBtnText("����");	//�޸�ȡ����ť�ı�
		mainFrame.messageDialog.btnOk.setVisible(false);	//����ȷ����ť
		mainFrame.messageDialog.setVisible(true);	//��ʾ�Ի���
	}
	/**
	 * ��Ϸ�˳���ʾ�Ի���Ĵ���
	 */
	private void showExitDialog(){
		mainFrame.messageDialog.setTitle("�˳���ʾ");	//�޸ı���
		mainFrame.messageDialog.labelMessage.setText("ȷ���˳���Ϸ�𣿣���");	//��ʾ����
		mainFrame.messageDialog.btnOk.setBtnText("ȷ��");	//�޸�ȷ����ť�ı�
		mainFrame.messageDialog.btnCancel.setBtnText("ȡ��");	//�޸�ȡ����ť�ı�
		mainFrame.messageDialog.btnOk.setVisible(true);	//��ʾȷ����ť
		mainFrame.messageDialog.setVisible(true);	//��ʾ�Ի���
	}
	/**
	 * ����ģʽ�������ˢ��
	 */
	private void showSimpleScore(){
		mainFrame.godDialog.simpleTextArea.setText(null);	//����ı�����
		if (rwScore.simpleScoreList.size()!=0) {	//�����Ϣˢ�µ��ı�����
			for (int i = 0; i < rwScore.simpleScoreList.size(); i++) {
				mainFrame.godDialog.simpleTextArea.append("��ң�"+
						rwScore.simpleScoreList.get(i).substring(rwScore.simpleScoreList.get(i).indexOf("User:")+5, 
								rwScore.simpleScoreList.get(i).indexOf("Model:"))+"\t������"+
								rwScore.simpleScoreList.get(i).substring(rwScore.simpleScoreList.get(i).indexOf("Score:")+6, 
										rwScore.simpleScoreList.get(i).length())+"\n");
			}
		}
		switch (rwScore.simpleScoreList.size()) {	//������ҵĸ�����ʾ��һ���ڶ������������һ��
		case 0:	//��ҵĸ���0��
			mainFrame.godDialog.simpleFirstUser.setText("");
			mainFrame.godDialog.simpleSecondUser.setText("");
			mainFrame.godDialog.simpleThirdUser.setText("");
			mainFrame.godDialog.simpleLastUser.setText("");
			break;
		case 1:	//��ҵĸ���ֻ��1��
			mainFrame.godDialog.simpleFirstUser.setText(rwScore.simpleScoreList.get(0).
					substring(rwScore.simpleScoreList.get(0).indexOf("User:")+5, rwScore.simpleScoreList.get(0).indexOf("Model:")));
			mainFrame.godDialog.simpleSecondUser.setText("");
			mainFrame.godDialog.simpleThirdUser.setText("");
			mainFrame.godDialog.simpleLastUser.setText("");
			break;
		case 2:	//��ҵĸ���ֻ��2��
			mainFrame.godDialog.simpleFirstUser.setText(rwScore.simpleScoreList.get(0).
					substring(rwScore.simpleScoreList.get(0).indexOf("User:")+5, rwScore.simpleScoreList.get(0).indexOf("Model:")));
			mainFrame.godDialog.simpleSecondUser.setText(rwScore.simpleScoreList.get(0).
					substring(rwScore.simpleScoreList.get(0).indexOf("User:")+5, rwScore.simpleScoreList.get(0).indexOf("Model:")));
			mainFrame.godDialog.simpleThirdUser.setText("");
			mainFrame.godDialog.simpleLastUser.setText("");
			break;
		case 3:	//��ҵĸ���ֻ��3��
			mainFrame.godDialog.simpleFirstUser.setText(rwScore.simpleScoreList.get(0).
					substring(rwScore.simpleScoreList.get(0).indexOf("User:")+5, rwScore.simpleScoreList.get(0).indexOf("Model:")));
			mainFrame.godDialog.simpleSecondUser.setText(rwScore.simpleScoreList.get(1).
					substring(rwScore.simpleScoreList.get(1).indexOf("User:")+5, rwScore.simpleScoreList.get(1).indexOf("Model:")));
			mainFrame.godDialog.simpleThirdUser.setText(rwScore.simpleScoreList.get(2).
					substring(rwScore.simpleScoreList.get(2).indexOf("User:")+5, rwScore.simpleScoreList.get(2).indexOf("Model:")));
			mainFrame.godDialog.simpleLastUser.setText("");
			break;
		case 4:	//��ҵĸ���ֻ��4��
			mainFrame.godDialog.simpleFirstUser.setText(rwScore.simpleScoreList.get(0).
					substring(rwScore.simpleScoreList.get(0).indexOf("User:")+5, rwScore.simpleScoreList.get(0).indexOf("Model:")));
			mainFrame.godDialog.simpleSecondUser.setText(rwScore.simpleScoreList.get(1).
					substring(rwScore.simpleScoreList.get(1).indexOf("User:")+5, rwScore.simpleScoreList.get(1).indexOf("Model:")));
			mainFrame.godDialog.simpleThirdUser.setText(rwScore.simpleScoreList.get(2).
					substring(rwScore.simpleScoreList.get(2).indexOf("User:")+5, rwScore.simpleScoreList.get(2).indexOf("Model:")));
			mainFrame.godDialog.simpleLastUser.setText(rwScore.simpleScoreList.get(3).
					substring(rwScore.simpleScoreList.get(3).indexOf("User:")+5, rwScore.simpleScoreList.get(3).indexOf("Model:")));
			break;
		default:	//��ҵĸ�������4��
			mainFrame.godDialog.simpleFirstUser.setText(rwScore.simpleScoreList.get(0).
					substring(rwScore.simpleScoreList.get(0).indexOf("User:")+5, rwScore.simpleScoreList.get(0).indexOf("Model:")));
			mainFrame.godDialog.simpleSecondUser.setText(rwScore.simpleScoreList.get(1).
					substring(rwScore.simpleScoreList.get(1).indexOf("User:")+5, rwScore.simpleScoreList.get(1).indexOf("Model:")));
			mainFrame.godDialog.simpleThirdUser.setText(rwScore.simpleScoreList.get(2).
					substring(rwScore.simpleScoreList.get(2).indexOf("User:")+5, rwScore.simpleScoreList.get(2).indexOf("Model:")));
			mainFrame.godDialog.simpleLastUser.setText(rwScore.simpleScoreList.get(rwScore.simpleScoreList.size()-1).
					substring(rwScore.simpleScoreList.get(rwScore.simpleScoreList.size()-1).indexOf("User:")+5, 
							rwScore.simpleScoreList.get(rwScore.simpleScoreList.size()-1).indexOf("Model:")));
			break;
		}
	}
	/**
	 * �м�ģʽ�������ˢ��
	 */
	private void showMiddleScore(){
		mainFrame.godDialog.middleTextArea.setText(null);	//����ı�����
		if (rwScore.middleScoreList.size()!=0) {	//�����Ϣˢ�µ��ı�����
			for (int i = 0; i < rwScore.middleScoreList.size(); i++) {
				mainFrame.godDialog.middleTextArea.append("��ң�"+
						rwScore.middleScoreList.get(i).substring(rwScore.middleScoreList.get(i).indexOf("User:")+5, 
								rwScore.middleScoreList.get(i).indexOf("Model:"))+"\t������"+
								rwScore.middleScoreList.get(i).substring(rwScore.middleScoreList.get(i).indexOf("Score:")+6, 
										rwScore.middleScoreList.get(i).length())+"\n");
			}
		}
		switch (rwScore.middleScoreList.size()) {	//������ҵĸ�����ʾ��һ���ڶ������������һ��
		case 0:	//��ҵĸ���0��
			mainFrame.godDialog.middleFirstUser.setText("");
			mainFrame.godDialog.middleSecondUser.setText("");
			mainFrame.godDialog.middleThirdUser.setText("");
			mainFrame.godDialog.middleLastUser.setText("");
			break;
		case 1:	//��ҵĸ���ֻ��1��
			mainFrame.godDialog.middleFirstUser.setText(rwScore.middleScoreList.get(0).
					substring(rwScore.middleScoreList.get(0).indexOf("User:")+5, rwScore.middleScoreList.get(0).indexOf("Model:")));
			mainFrame.godDialog.middleSecondUser.setText("");
			mainFrame.godDialog.middleThirdUser.setText("");
			mainFrame.godDialog.middleLastUser.setText("");
			break;
		case 2:	//��ҵĸ���ֻ��2��
			mainFrame.godDialog.middleFirstUser.setText(rwScore.middleScoreList.get(0).
					substring(rwScore.middleScoreList.get(0).indexOf("User:")+5, rwScore.middleScoreList.get(0).indexOf("Model:")));
			mainFrame.godDialog.middleSecondUser.setText(rwScore.middleScoreList.get(0).
					substring(rwScore.middleScoreList.get(0).indexOf("User:")+5, rwScore.middleScoreList.get(0).indexOf("Model:")));
			mainFrame.godDialog.middleThirdUser.setText("");
			mainFrame.godDialog.middleLastUser.setText("");
			break;
		case 3:	//��ҵĸ���ֻ��3��
			mainFrame.godDialog.middleFirstUser.setText(rwScore.middleScoreList.get(0).
					substring(rwScore.middleScoreList.get(0).indexOf("User:")+5, rwScore.middleScoreList.get(0).indexOf("Model:")));
			mainFrame.godDialog.middleSecondUser.setText(rwScore.middleScoreList.get(1).
					substring(rwScore.middleScoreList.get(1).indexOf("User:")+5, rwScore.middleScoreList.get(1).indexOf("Model:")));
			mainFrame.godDialog.middleThirdUser.setText(rwScore.middleScoreList.get(2).
					substring(rwScore.middleScoreList.get(2).indexOf("User:")+5, rwScore.middleScoreList.get(2).indexOf("Model:")));
			mainFrame.godDialog.middleLastUser.setText("");
			break;
		case 4:	//��ҵĸ���ֻ��4��
			mainFrame.godDialog.middleFirstUser.setText(rwScore.middleScoreList.get(0).
					substring(rwScore.middleScoreList.get(0).indexOf("User:")+5, rwScore.middleScoreList.get(0).indexOf("Model:")));
			mainFrame.godDialog.middleSecondUser.setText(rwScore.middleScoreList.get(1).
					substring(rwScore.middleScoreList.get(1).indexOf("User:")+5, rwScore.middleScoreList.get(1).indexOf("Model:")));
			mainFrame.godDialog.middleThirdUser.setText(rwScore.middleScoreList.get(2).
					substring(rwScore.middleScoreList.get(2).indexOf("User:")+5, rwScore.middleScoreList.get(2).indexOf("Model:")));
			mainFrame.godDialog.middleLastUser.setText(rwScore.middleScoreList.get(3).
					substring(rwScore.middleScoreList.get(3).indexOf("User:")+5, rwScore.middleScoreList.get(3).indexOf("Model:")));
			break;
		default:	//��ҵĸ�������4��
			mainFrame.godDialog.middleFirstUser.setText(rwScore.middleScoreList.get(0).
					substring(rwScore.middleScoreList.get(0).indexOf("User:")+5, rwScore.middleScoreList.get(0).indexOf("Model:")));
			mainFrame.godDialog.middleSecondUser.setText(rwScore.middleScoreList.get(1).
					substring(rwScore.middleScoreList.get(1).indexOf("User:")+5, rwScore.middleScoreList.get(1).indexOf("Model:")));
			mainFrame.godDialog.middleThirdUser.setText(rwScore.middleScoreList.get(2).
					substring(rwScore.middleScoreList.get(2).indexOf("User:")+5, rwScore.middleScoreList.get(2).indexOf("Model:")));
			mainFrame.godDialog.middleLastUser.setText(rwScore.middleScoreList.get(rwScore.middleScoreList.size()-1).
					substring(rwScore.middleScoreList.get(rwScore.middleScoreList.size()-1).indexOf("User:")+5, 
							rwScore.middleScoreList.get(rwScore.middleScoreList.size()-1).indexOf("Model:")));
			break;
		}
	}
	/**
	 * �߼�ģʽ�������ˢ��
	 */
	private void showSeniorScore(){
		mainFrame.godDialog.seniorTextArea.setText(null);	//����ı�����
		if (rwScore.seniorScoreList.size()!=0) {	//�����Ϣˢ�µ��ı�����
			for (int i = 0; i < rwScore.seniorScoreList.size(); i++) {
				mainFrame.godDialog.seniorTextArea.append("��ң�"+
						rwScore.seniorScoreList.get(i).substring(rwScore.seniorScoreList.get(i).indexOf("User:")+5, 
								rwScore.seniorScoreList.get(i).indexOf("Model:"))+"\t������"+
								rwScore.seniorScoreList.get(i).substring(rwScore.seniorScoreList.get(i).indexOf("Score:")+6, 
										rwScore.seniorScoreList.get(i).length())+"\n");
			}
		}
		switch (rwScore.seniorScoreList.size()) {	//������ҵĸ�����ʾ��һ���ڶ������������һ��
		case 0:	//��ҵĸ���0��
			mainFrame.godDialog.seniorFirstUser.setText("");
			mainFrame.godDialog.seniorSecondUser.setText("");
			mainFrame.godDialog.seniorThirdUser.setText("");
			mainFrame.godDialog.seniorLastUser.setText("");
			break;
		case 1:	//��ҵĸ���ֻ��1��
			mainFrame.godDialog.seniorFirstUser.setText(rwScore.seniorScoreList.get(0).
					substring(rwScore.seniorScoreList.get(0).indexOf("User:")+5, rwScore.seniorScoreList.get(0).indexOf("Model:")));
			mainFrame.godDialog.seniorSecondUser.setText("");
			mainFrame.godDialog.seniorThirdUser.setText("");
			mainFrame.godDialog.seniorLastUser.setText("");
			break;
		case 2:	//��ҵĸ���ֻ��2��
			mainFrame.godDialog.seniorFirstUser.setText(rwScore.seniorScoreList.get(0).
					substring(rwScore.seniorScoreList.get(0).indexOf("User:")+5, rwScore.seniorScoreList.get(0).indexOf("Model:")));
			mainFrame.godDialog.seniorSecondUser.setText(rwScore.seniorScoreList.get(0).
					substring(rwScore.seniorScoreList.get(0).indexOf("User:")+5, rwScore.seniorScoreList.get(0).indexOf("Model:")));
			mainFrame.godDialog.seniorThirdUser.setText("");
			mainFrame.godDialog.seniorLastUser.setText("");
			break;
		case 3:	//��ҵĸ���ֻ��3��
			mainFrame.godDialog.seniorFirstUser.setText(rwScore.seniorScoreList.get(0).
					substring(rwScore.seniorScoreList.get(0).indexOf("User:")+5, rwScore.seniorScoreList.get(0).indexOf("Model:")));
			mainFrame.godDialog.seniorSecondUser.setText(rwScore.seniorScoreList.get(1).
					substring(rwScore.seniorScoreList.get(1).indexOf("User:")+5, rwScore.seniorScoreList.get(1).indexOf("Model:")));
			mainFrame.godDialog.seniorThirdUser.setText(rwScore.seniorScoreList.get(2).
					substring(rwScore.seniorScoreList.get(2).indexOf("User:")+5, rwScore.seniorScoreList.get(2).indexOf("Model:")));
			mainFrame.godDialog.seniorLastUser.setText("");
			break;
		case 4:	//��ҵĸ���ֻ��4��
			mainFrame.godDialog.seniorFirstUser.setText(rwScore.seniorScoreList.get(0).
					substring(rwScore.seniorScoreList.get(0).indexOf("User:")+5, rwScore.seniorScoreList.get(0).indexOf("Model:")));
			mainFrame.godDialog.seniorSecondUser.setText(rwScore.seniorScoreList.get(1).
					substring(rwScore.seniorScoreList.get(1).indexOf("User:")+5, rwScore.seniorScoreList.get(1).indexOf("Model:")));
			mainFrame.godDialog.seniorThirdUser.setText(rwScore.seniorScoreList.get(2).
					substring(rwScore.seniorScoreList.get(2).indexOf("User:")+5, rwScore.seniorScoreList.get(2).indexOf("Model:")));
			mainFrame.godDialog.seniorLastUser.setText(rwScore.seniorScoreList.get(3).
					substring(rwScore.seniorScoreList.get(3).indexOf("User:")+5, rwScore.seniorScoreList.get(3).indexOf("Model:")));
			break;
		default:	//��ҵĸ�������4��
			mainFrame.godDialog.seniorFirstUser.setText(rwScore.seniorScoreList.get(0).
					substring(rwScore.seniorScoreList.get(0).indexOf("User:")+5, rwScore.seniorScoreList.get(0).indexOf("Model:")));
			mainFrame.godDialog.seniorSecondUser.setText(rwScore.seniorScoreList.get(1).
					substring(rwScore.seniorScoreList.get(1).indexOf("User:")+5, rwScore.seniorScoreList.get(1).indexOf("Model:")));
			mainFrame.godDialog.seniorThirdUser.setText(rwScore.seniorScoreList.get(2).
					substring(rwScore.seniorScoreList.get(2).indexOf("User:")+5, rwScore.seniorScoreList.get(2).indexOf("Model:")));
			mainFrame.godDialog.seniorLastUser.setText(rwScore.seniorScoreList.get(rwScore.seniorScoreList.size()-1).
					substring(rwScore.seniorScoreList.get(rwScore.seniorScoreList.size()-1).indexOf("User:")+5, 
							rwScore.seniorScoreList.get(rwScore.seniorScoreList.size()-1).indexOf("Model:")));
			break;
		}
	}
	/**
	 * ��̬ģʽ�������ˢ��
	 */
	private void showNonhumanScore(){
		mainFrame.godDialog.nonhumanTextArea.setText(null);	//����ı�����
		if (rwScore.nonhumanScoreList.size()!=0) {	//�����Ϣˢ�µ��ı�����
			for (int i = 0; i < rwScore.nonhumanScoreList.size(); i++) {
				mainFrame.godDialog.nonhumanTextArea.append("��ң�"+
						rwScore.nonhumanScoreList.get(i).substring(rwScore.nonhumanScoreList.get(i).indexOf("User:")+5, 
								rwScore.nonhumanScoreList.get(i).indexOf("Model:"))+"\t������"+
								rwScore.nonhumanScoreList.get(i).substring(rwScore.nonhumanScoreList.get(i).indexOf("Score:")+6, 
										rwScore.nonhumanScoreList.get(i).length())+"\n");
			}
		}
		switch (rwScore.nonhumanScoreList.size()) {	//������ҵĸ�����ʾ��һ���ڶ������������һ��
		case 0:	//��ҵĸ���0��
			mainFrame.godDialog.nonhumanFirstUser.setText("");
			mainFrame.godDialog.nonhumanSecondUser.setText("");
			mainFrame.godDialog.nonhumanThirdUser.setText("");
			mainFrame.godDialog.nonhumanLastUser.setText("");
			break;
		case 1:	//��ҵĸ���ֻ��1��
			mainFrame.godDialog.nonhumanFirstUser.setText(rwScore.nonhumanScoreList.get(0).
					substring(rwScore.nonhumanScoreList.get(0).indexOf("User:")+5, rwScore.nonhumanScoreList.get(0).indexOf("Model:")));
			mainFrame.godDialog.nonhumanSecondUser.setText("");
			mainFrame.godDialog.nonhumanThirdUser.setText("");
			mainFrame.godDialog.nonhumanLastUser.setText("");
			break;
		case 2:	//��ҵĸ���ֻ��2��
			mainFrame.godDialog.nonhumanFirstUser.setText(rwScore.nonhumanScoreList.get(0).
					substring(rwScore.nonhumanScoreList.get(0).indexOf("User:")+5, rwScore.nonhumanScoreList.get(0).indexOf("Model:")));
			mainFrame.godDialog.nonhumanSecondUser.setText(rwScore.nonhumanScoreList.get(0).
					substring(rwScore.nonhumanScoreList.get(0).indexOf("User:")+5, rwScore.nonhumanScoreList.get(0).indexOf("Model:")));
			mainFrame.godDialog.nonhumanThirdUser.setText("");
			mainFrame.godDialog.nonhumanLastUser.setText("");
			break;
		case 3:	//��ҵĸ���ֻ��3��
			mainFrame.godDialog.nonhumanFirstUser.setText(rwScore.nonhumanScoreList.get(0).
					substring(rwScore.nonhumanScoreList.get(0).indexOf("User:")+5, rwScore.nonhumanScoreList.get(0).indexOf("Model:")));
			mainFrame.godDialog.nonhumanSecondUser.setText(rwScore.nonhumanScoreList.get(1).
					substring(rwScore.nonhumanScoreList.get(1).indexOf("User:")+5, rwScore.nonhumanScoreList.get(1).indexOf("Model:")));
			mainFrame.godDialog.nonhumanThirdUser.setText(rwScore.nonhumanScoreList.get(2).
					substring(rwScore.nonhumanScoreList.get(2).indexOf("User:")+5, rwScore.nonhumanScoreList.get(2).indexOf("Model:")));
			mainFrame.godDialog.nonhumanLastUser.setText("");
			break;
		case 4:	//��ҵĸ���ֻ��4��
			mainFrame.godDialog.nonhumanFirstUser.setText(rwScore.nonhumanScoreList.get(0).
					substring(rwScore.nonhumanScoreList.get(0).indexOf("User:")+5, rwScore.nonhumanScoreList.get(0).indexOf("Model:")));
			mainFrame.godDialog.nonhumanSecondUser.setText(rwScore.nonhumanScoreList.get(1).
					substring(rwScore.nonhumanScoreList.get(1).indexOf("User:")+5, rwScore.nonhumanScoreList.get(1).indexOf("Model:")));
			mainFrame.godDialog.nonhumanThirdUser.setText(rwScore.nonhumanScoreList.get(2).
					substring(rwScore.nonhumanScoreList.get(2).indexOf("User:")+5, rwScore.nonhumanScoreList.get(2).indexOf("Model:")));
			mainFrame.godDialog.nonhumanLastUser.setText(rwScore.nonhumanScoreList.get(3).
					substring(rwScore.nonhumanScoreList.get(3).indexOf("User:")+5, rwScore.nonhumanScoreList.get(3).indexOf("Model:")));
			break;
		default:	//��ҵĸ�������4��
			mainFrame.godDialog.nonhumanFirstUser.setText(rwScore.nonhumanScoreList.get(0).
					substring(rwScore.nonhumanScoreList.get(0).indexOf("User:")+5, rwScore.nonhumanScoreList.get(0).indexOf("Model:")));
			mainFrame.godDialog.nonhumanSecondUser.setText(rwScore.nonhumanScoreList.get(1).
					substring(rwScore.nonhumanScoreList.get(1).indexOf("User:")+5, rwScore.nonhumanScoreList.get(1).indexOf("Model:")));
			mainFrame.godDialog.nonhumanThirdUser.setText(rwScore.nonhumanScoreList.get(2).
					substring(rwScore.nonhumanScoreList.get(2).indexOf("User:")+5, rwScore.nonhumanScoreList.get(2).indexOf("Model:")));
			mainFrame.godDialog.nonhumanLastUser.setText(rwScore.nonhumanScoreList.get(rwScore.nonhumanScoreList.size()-1).
					substring(rwScore.nonhumanScoreList.get(rwScore.nonhumanScoreList.size()-1).indexOf("User:")+5, 
							rwScore.nonhumanScoreList.get(rwScore.nonhumanScoreList.size()-1).indexOf("Model:")));
			break;
		}
	}
	/**
	 * ����¼��ڲ���
	 */
	private class MouseSound extends MouseAdapter{
		/**
		 * ����������ļ���
		 */
		@Override
		public void mouseEntered(MouseEvent e) {
			if (mainFrame.radioBtnSounds.isSelected()) {	//��Ч���ش��򲥷���Ч
				soundModel.buttonSound.play();	//���������Ч
			}
		}
		/**
		 * ���������ļ���
		 */
		@Override
		public void mousePressed(MouseEvent e) {
			if (mainFrame.radioBtnSounds.isSelected()) {	//��Ч���ش��򲥷���Ч
				soundModel.rotateSound.play();	//���������Ч
			}
		}
	}
}