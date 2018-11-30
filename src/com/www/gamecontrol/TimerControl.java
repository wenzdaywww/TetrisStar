package com.www.gamecontrol;

import java.util.Timer;
import java.util.TimerTask;
import java.lang.reflect.Field;
import com.www.gameview.MainFrame;
import com.www.gamemodel.GridBlock;
import com.www.gamemodel.SoundModel;
/**
 * ��ʱ���¼�������
 * @author wWw
 *
 */
public class TimerControl extends TimerTask {
	/**@see ��ʱ��ִ������*/
	private long loopTime=500;		
	/**@see ���񷽿����*/
	private GridBlock gridBlock;
	/**@see ���������*/
	private MainFrame mainFrame;	
	/**@see ��������*/
	private SoundModel soundModel;	
	/**@see ���¿�ʼ��Ϸ״̬��trueΪ���¿�ʼ��Ϸ*/
	private boolean restartGame=false;
	/**@see ��Ϸ״̬��trueΪ��Ϸ��*/ 
	private boolean runningOrPause=false;
	/**
	 * ������ʱ�����вι��췽�������ݶ���
	 * @param mainFrame ���������
	 * @param soundModel ��������
	 * @param gridBlock ���񷽿����
	 */
	public TimerControl(MainFrame mainFrame,SoundModel soundModel,GridBlock gridBlock) {
		this.mainFrame=mainFrame;
		this.gridBlock=gridBlock;
		this.soundModel=soundModel;
		this.gridBlock.player1CreateShape(this.mainFrame.diyDialog.chckbxBoom.isSelected());	//����һ��ʼʱ���������һ������
		startTimer();	//��ʼ��ʱ��
	} 
	/**
	 * ������ʱ������Ϳ�ʼ��ʱ������
	 */
	private void startTimer(){ 
		Timer timer=new Timer();	//������ʱ������
		timer.schedule(this, 0, loopTime);	//��ʼ��ʱ��������
	}
	/**
	 * ͨ�������޸Ķ�ʱ����ִ������
	 */
	private void restartLevel() {  
		setDeclaredField(TimerTask.class, this, "period", loopTime);  
	}  
	/**
	 * ͨ���������޸Ķ�ʱ����ִ������
	 * @param clazz	�������
	 * @param obj	����Ķ���
	 * @param name	ָ���Ķ���
	 * @param value	�޸ĵ�ֵ
	 * @return	trueΪ����ɹ���falseΪ�����쳣
	 */
	private boolean setDeclaredField(Class<?> clazz, Object obj,  
			String name, Object value) {  
		try {  
			Field field = clazz.getDeclaredField(name);  //��ȡ���з���Ķ���
			//���˶���� accessible ��־����Ϊָʾ�Ĳ���ֵ��ֵΪ true ��ָʾ����Ķ�����ʹ��ʱӦ��ȡ�� Java ���Է��ʼ�顣
			//ֵΪ false ��ָʾ����Ķ���Ӧ��ʵʩ Java ���Է��ʼ�顣
			field.setAccessible(true); 
			//��ָ����������ϴ� Field �����ʾ���ֶ�����Ϊָ������ֵ������ײ��ֶε�����Ϊ�������ͣ������ֵ�����Զ������ 
			field.set(obj, value);  
			return true;  
		} catch (Exception ex) {  
			return false;  
		}  
	} 
	/**
	 * ��ʱ��������
	 */
	@Override
	public void run() {
		autoLevelUp();	//��Ϸģʽ�Ƿ��Զ�����
		if (mainFrame.godDialog.isVisible()||mainFrame.registerFrame.isVisible()||mainFrame.diyDialog.isVisible()||
				mainFrame.aboutDialog.isVisible()||mainFrame.explainDialog.isVisible()||mainFrame.messageDialog.isVisible()||
				mainFrame.gameMenu.isPopupMenuVisible()||mainFrame.helpMenu.isPopupMenuVisible()) {	//�򿪶Ի�����߲˵�����ͣ
			setRunningOrPause(false);
			mainFrame.btnPause.setBtnText("�������ո�");
		}
		if (GridBlock.COL==25) {	//˫��ģʽ
			doubleGame();
		}else {	//����ģʽ
			singleGame();
		}
	}
	/**
	 * ������Ϸ�еĸ����жϺ�ִ�в���
	 */
	private void singleGame(){
		if (runningOrPause) {	//���ڿ�����Ϸ��ͣ�ͼ�����trueΪ��Ϸ��
			if (restartGame) {	//���ڿ������¿�ʼ��Ϸ��trueΪ���¿�ʼ��Ϸ
				restartGame=false;	
				gridBlock.player1CreateShape(mainFrame.diyDialog.chckbxBoom.isSelected());	//���¿�ʼ��Ϸ����������һ������
				mainFrame.nextShowPanel.showNextShape(gridBlock.shapeNum, gridBlock.level);
				gridBlock.socre=0;//���¿�ʼ���������
				GridBlock.clearBlockPanel();	//���������·����
				gridBlock.player1SetGameOverToRestart();	//�����������ʱ��Ϸ�����ı�־
			}else {
				if (gridBlock.player1IsGameOver()) {	//���鵽����Ϸ������trueΪ��Ϸ����
					runningOrPause=false;	//��Ϸ��ͣ
					gridBlock.showGameOver();	//��ʾ��Ϸ��������
					mainFrame.blockPanel.repaint();
					soundModel.gameOverSound.play();	//��Ϸ������������
					mainFrame.btnPause.setVisible(false);	//���ء���ͣ/��������ť
					mainFrame.btnPause.setBtnText("��ͣ���ո�");	//�޸ġ���ͣ/��������ť�ı�
					showDialog();	//��ʾ��Ϸ����ʱ����ʾ��
				}else {
					if (gridBlock.player1IsCanMove()==false) {	//���鵽�ײ����ƶ���������һ�����飬falseΪ���鵽��
						if (gridBlock.blockDisappear()&&mainFrame.radioBtnSounds.isSelected()) {	//�ж����к��Ƿ񲥷�������Ч
							soundModel.blockDisappearSound.play();	//����������Ч
						}
						if (gridBlock.player1IsBomb()&&mainFrame.radioBtnSounds.isSelected()) {	//�ж��Ƿ����ը�����Ƿ𲥷�ը����Ч
							soundModel.bombSound.play();	//ը����Ч
						}
						mainFrame.setLabelScore(gridBlock.socre);	//��ȡ��Ϸ�÷֣�����ʾ
						if (mainFrame.radioBtnSounds.isSelected()) {	//�Ƿ񲥷ŷ��鵽����Ч
							soundModel.cantMoveSound.play();	//���鵽����Ч
						}
						gridBlock.player1CreateShape(mainFrame.diyDialog.chckbxBoom.isSelected());	//����һ������
						mainFrame.nextShowPanel.showNextShape(gridBlock.shapeNum, gridBlock.level);
						if (gridBlock.blockAutoUp(mainFrame.diyDialog.chckbxAutoUp.isSelected(),(int)mainFrame.diyDialog.spinnerAutoUpY.getValue())) {
							mainFrame.diyDialog.spinnerAutoUpY.setValue((int)mainFrame.diyDialog.spinnerAutoUpY.getValue()-1);
						}//�����Ƿ��Զ�����
						if (gridBlock.blockRandomOpen(mainFrame.diyDialog.chckbxRandomOpen.isSelected(),(int)mainFrame.diyDialog.spinnerRandomTime.getValue())) {
							mainFrame.diyDialog.spinnerRandomTime.setValue((int)mainFrame.diyDialog.spinnerRandomTime.getValue()-1);
							
						}//���������������Ϸ������
						mainFrame.diyDialog.slider.setValue((int) loopTime);	//ͬ����Ϸ�ٶȵ�������ǰֵ
					}else {
						gridBlock.player1Down();	//��������
					}
				}
			}
		}
		mainFrame.blockPanel.repaint();
	}
	/**
	 * ˫����Ϸ�еĸ����жϺ�ִ�в���
	 */
	private void doubleGame(){
		if (runningOrPause) {	//���ڿ�����Ϸ��ͣ�ͼ�����trueΪ��Ϸ��
			if (restartGame) {	//���ڿ������¿�ʼ��Ϸ��trueΪ���¿�ʼ��Ϸ
				restartGame=false;	
				gridBlock.player1CreateShape(mainFrame.diyDialog.chckbxBoom.isSelected());	//���1���¿�ʼ��Ϸ�������������һ������
				gridBlock.player2CreateShape(mainFrame.diyDialog.chckbxBoom.isSelected());	//���2���¿�ʼ��Ϸ�������������һ������
				mainFrame.nextShowPanel.showNextShape(gridBlock.shapeNum, gridBlock.level);
				gridBlock.socre=0;//���¿�ʼ���������
				GridBlock.clearBlockPanel();	//���������·����
				gridBlock.player1SetGameOverToRestart();	//�����������ʱ��Ϸ�����ı�־
				gridBlock.player2SetGameOverToRestart();	//�����������ʱ��Ϸ�����ı�־
			}else {	//�ж�2������Ƿ���һ����Ϸ����
				if (gridBlock.player1IsGameOver()||gridBlock.player2IsGameOver()) {	//���鵽����Ϸ������trueΪ��Ϸ����
					runningOrPause=false;	//��Ϸ��ͣ
					gridBlock.showGameOver();	//��ʾ��Ϸ��������
					mainFrame.blockPanel.repaint();
					soundModel.gameOverSound.play();	//��Ϸ������������
					mainFrame.btnPause.setVisible(false);	//���ء���ͣ/��������ť
					mainFrame.btnPause.setBtnText("��ͣ���ո�");	//�޸ġ���ͣ/��������ť�ı�
					showDialog();	//��ʾ��Ϸ����ʱ����ʾ��
				}else{	//������Ҷ�û����Ϸ������������жϵ������
					//���1�����2���鵽���ж��Ƿ�����
					if ((gridBlock.player1IsCanMove()==false)||(gridBlock.player2IsCanMove()==false)) {	
						if (gridBlock.blockDisappear()&&mainFrame.radioBtnSounds.isSelected()) {	//�ж����к��Ƿ񲥷�������Ч
							soundModel.blockDisappearSound.play();	//����������Ч
						}
						if (gridBlock.blockAutoUp(mainFrame.diyDialog.chckbxAutoUp.isSelected(),(int)mainFrame.diyDialog.spinnerAutoUpY.getValue())) {
							mainFrame.diyDialog.spinnerAutoUpY.setValue((int)mainFrame.diyDialog.spinnerAutoUpY.getValue()-1);
						}//�����Ƿ��Զ�����
						if (gridBlock.blockRandomOpen(mainFrame.diyDialog.chckbxRandomOpen.isSelected(),(int)mainFrame.diyDialog.spinnerRandomTime.getValue())) {
							mainFrame.diyDialog.spinnerRandomTime.setValue((int)mainFrame.diyDialog.spinnerRandomTime.getValue()-1);
							
						}//���������������Ϸ������
						if (mainFrame.radioBtnSounds.isSelected()) {	//�Ƿ񲥷ŷ��鵽����Ч
							soundModel.cantMoveSound.play();	//���鵽����Ч
						}
						mainFrame.diyDialog.slider.setValue((int) loopTime);	//ͬ����Ϸ�ٶȵ�������ǰֵ
					}
					//���1��������䣬�ж��Ƿ����ը�����Ƿ񲥷�ը����Ч
					if (gridBlock.player1IsCanMove()==false) {
						if (gridBlock.player1IsBomb()&&mainFrame.radioBtnSounds.isSelected()) {	
							soundModel.bombSound.play();	//���1ը����Ч
						}
						gridBlock.player1CreateShape(mainFrame.diyDialog.chckbxBoom.isSelected());
						mainFrame.nextShowPanel.showNextShape(gridBlock.shapeNum, gridBlock.level);
					}else {
						gridBlock.player1Down();
					}
					//���2��������䣬�ж��Ƿ����ը�����Ƿ񲥷�ը����Ч
					if (gridBlock.player2IsCanMove()==false) {
						if (gridBlock.player2IsBomb()&&mainFrame.radioBtnSounds.isSelected()) {	
							soundModel.bombSound.play();	//���2ը����Ч
						}
						gridBlock.player2CreateShape(mainFrame.diyDialog.chckbxBoom.isSelected());
						mainFrame.nextShowPanel.showNextShape(gridBlock.shapeNum, gridBlock.level);
					}else {
						gridBlock.player2Down();
					}
					mainFrame.setLabelScore(gridBlock.socre);	//��ȡ��Ϸ�÷֣�����ʾ
				}
			}
		}
		mainFrame.blockPanel.repaint();
	}
	/**
	 * ��/˫����Ϸ��ģʽ�Զ�������ѡ���Զ�����ģʽ�󣬽��ӳ�����ʼ���𣬷���ÿ����200��������һ���ȼ�
	 */
	private void autoLevelUp(){
		if (mainFrame.diyDialog.chckbxAutoLevel.isSelected()) {	//�Զ�����ģʽѡ��
			if (gridBlock.socre<200) {	//����С��200�����ڳ���ģʽ
				loopTime=500;	//���ó���ģʽ�����ٶ�Ϊ500ms
				restartLevel();	//���¿�ʼ��ʱ���µ�ִ������
				gridBlock.level="����ģʽ";	//����ģʽΪ����ģʽ
				mainFrame.setLabelLevel("����");	//��ǩ��ʾ��ǰ���ڳ���ģʽ
			}else if ((gridBlock.socre>=200)&&(gridBlock.socre<400)) {	//������200~400��֮�䴦���м�ģʽ
				loopTime=300;	//�����м�ģʽ�����ٶ�Ϊ300ms
				restartLevel();	//���¿�ʼ��ʱ���µ�ִ������
				gridBlock.level="�м�ģʽ";	//����ģʽΪ�м�ģʽ
				mainFrame.setLabelLevel("�м�");	//��ǩ��ʾ��ǰ�����м�ģʽ
			}else if ((gridBlock.socre>=400)&&(gridBlock.socre<600)) {	//������400~600��֮�䴦�ڸ߼�ģʽ
				loopTime=100;	//���ø߼�ģʽ�������ٶ�Ϊ100ms
				restartLevel();	//���¿�ʼ��ʱ���µ�ִ������
				gridBlock.level="�߼�ģʽ";	//����ģʽΪ�߼�ģʽ
				mainFrame.setLabelLevel("�߼�");	//��ǩ��ʾ��ǰ���ڸ߼�ģʽ
			}else if ((gridBlock.socre>=600)) {	//��������600�ִ��ڱ�̬ģʽ
				loopTime=50;	//���ñ�̬ģʽ����·�ٶ�
				restartLevel();	//���¿�ʼ��ʱ���µ�ִ������
				gridBlock.level="��̬ģʽ";	//���õ�ǰģʽΪ��̬ģʽ
				mainFrame.setLabelLevel("��̬");	//��ǩ��ʾ��ǰģʽΪ��̬ģʽ
			}
		}
	}
	/**
	 * ��/˫����Ϸ����ʱ����ʾ��ѡ��
	 */
	private void showDialog(){
		if (mainFrame.registerFrame.gameUserTextField.getText().equals("")) {	//��ǰû�����ע����ֻ������Ϸ������ʾ��
			showGameOverDialog();	//������Ϸ������ʾ��
		}else {	//�����ע��ʱ��Ϸ����ʱ
			if (gridBlock.socre>0) {	//��ҷ�������0����ʾ�Ƿ��ϴ�����
				showUploadScore();	//�ϴ�������ʾ��
			}else {
				showGameOverDialog();	//��ҷ�������0��ֻ������Ϸ������ʾ��
			}
		}
	}
	/**
	 * ��/˫����Ϸ������ʾ������
	 */
	private void showGameOverDialog(){
		mainFrame.messageDialog.setTitle("��Ϸ����");		//���ñ���
		mainFrame.messageDialog.labelMessage.setText("��ѽ����ô������ˣ�����");	//������ʾ����
		mainFrame.messageDialog.btnOk.setVisible(false);	//����ȷ����ť
		mainFrame.messageDialog.btnCancel.setBtnText("����");	//�޸�ȡ����ť�ı�Ϊ����
		mainFrame.messageDialog.setVisible(true);	//��ʾ��ʾ��
	}
	/**
	 * ��/˫���ϴ�������ʾ������
	 */
	private void showUploadScore(){
		mainFrame.messageDialog.setTitle("�ϴ�����");		//���ñ���
		mainFrame.messageDialog.labelMessage.setText("��Ϸ�������Ƿ��ϴ���Ϸ�÷֣�����");	//������ʾ����
		mainFrame.messageDialog.btnOk.setBtnText("�ϴ�");	//����ȷ����ť�ı�
		mainFrame.messageDialog.btnOk.setVisible(true);		//��ʾȷ����ť
		mainFrame.messageDialog.btnCancel.setBtnText("ȡ��");	//����ȡ����ť�ı�
		mainFrame.messageDialog.setVisible(true);	//��ʾ��ʾ��
	}
	/**
	 * ��ȡ������ִ������
	 * @return	������ִ������
	 */
	public long getLoopTime() {
		return loopTime;
	}
	/**
	 * �����µĶ�ʱ�����ڲ�ͨ�������޸��µ�ִ������
	 * @param gameLevel	�µĶ�ʱ������
	 */
	public void starNewLoopTime(long gameLevel) {
		setRunningOrPause(true);	//����Ϊ��Ϸ��
		this.loopTime = gameLevel;	//��ȡ�µ�ִ������
		restartLevel();	//��ʼ�µ�ִ������
	}
	/**
	 * ������Ϸ״̬��trueΪ��Ϸ�У�falseΪ��ͣ
	 * @param startGame ��Ϸ״̬,trueΪ��Ϸ�У�falseΪ��ͣ
	 */
	public void setRunningOrPause(boolean startGame) {
		this.runningOrPause = startGame;
	}
	/**
	 * ��ȡ��Ϸ״̬
	 * @return ��Ϸ״̬��trueΪ��Ϸ�У�falseΪ��ͣ
	 */
	public boolean getRunningOrPause(){
		return runningOrPause;
	}
	/**
	 * �������¿�ʼ��Ϸ�ı�־
	 * @param restartGame ���¿�ʼ��Ϸ�ı�־,trueΪ���¿�ʼ
	 */
	public void setRestartGame(boolean restartGame) {
		this.restartGame = restartGame;
	}
}
