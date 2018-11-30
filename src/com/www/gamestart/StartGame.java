package com.www.gamestart;

import javax.swing.UIManager;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import com.www.gameview.MainFrame;
import com.www.gamemodel.GridBlock;
import com.www.gamemodel.SoundModel;
import com.www.gamecontrol.KeyControl;
import com.www.gamecontrol.TimerControl;
import com.www.gamecontrol.MouseControl;
import javax.swing.UnsupportedLookAndFeelException;
	/**
	 * ��������󴴽���
	 * @author wWw
	 *
	 */
public class StartGame {
	/**
	 * ������������¼�������󡢶�ʱ������
	 */
	public StartGame() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {	//���ý�����
			JOptionPane.showConfirmDialog(null, "��ȡ���ʧ�ܣ�", "��ʾ", JOptionPane.CLOSED_OPTION);
		}
		MainFrame mainFrame =new MainFrame();	//��ͼ����
		SoundModel soundModel=new SoundModel();	//����ģ�Ͷ���
		GridBlock gridModel=new GridBlock();	//���񷽿����
		TimerControl timerCtrl=new TimerControl(mainFrame,soundModel,gridModel);	//��ʱ�����ƶ���
		new KeyControl(mainFrame,timerCtrl,soundModel,gridModel);	//���̼�������
		new MouseControl(mainFrame, timerCtrl,soundModel,gridModel);	//�������������
	}
	/**
	 * main����
	 * @param args
	 */
	public static void main(String[] args) {
		//����swingUI�߳�
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new StartGame();
			}
		});
	}
}
