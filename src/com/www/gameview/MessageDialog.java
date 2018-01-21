package com.www.gameview;

import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JDialog;
	/**
	 * ��Ϣ��ʾ����
	 * @author wWw
	 *
	 */
@SuppressWarnings("serial")
public class MessageDialog extends JDialog {
	/** @see ȷ����ť*/
	public MyButtonUI btnOk;	
	/** @see ��Ϣ��ǩ*/
	public JLabel labelMessage;	
	/** @see ȡ����ť*/
	public MyButtonUI btnCancel;	
	/** @see �����밴ťʱ��ť����ɫ*/
	private Color fouceColor=new Color(75, 209, 238, 255);	
	/** @see ��ť����״̬�ǵ���ɫ*/
	private Color normalColor=new Color(75, 209, 238, 120);	
	/**
	 * ��ʼ�������
	 */
	public MessageDialog() {
		setSize(300, 120);
		setVisible(false);
		setModal(true);
		setTitle("�˳���ʾ");
		setIconImage(Toolkit.getDefaultToolkit().getImage("image/message.png"));
		setLocationRelativeTo(null);
		BackgroupPanel uploadPanel=new BackgroupPanel();
		labelMessage=new JLabel();
		labelMessage.setFont(new Font("��Բ", Font.PLAIN, 15));
		labelMessage.setForeground(MainFrame.FontColor);
		labelMessage.setText("ȷ���˳�������");
		labelMessage.setBounds(15, 12, 250, 25);
		uploadPanel.add(labelMessage);
		btnOk=new MyButtonUI();
		btnOk.setBounds(90, 50, 80, 25);;
		btnOk.setBtnText("ȷ��");
		btnOk.setOpaque(false);
		btnOk.setNormalColor(Color.white, 25, 16, normalColor, 100);
		btnOk.setFoucesdColor(fouceColor);
		uploadPanel.add(btnOk);
		btnCancel=new MyButtonUI();
		btnCancel.setBounds(190, 50, 80, 25);;
		btnCancel.setBtnText("ȡ��");
		btnCancel.setOpaque(false);
		btnCancel.setNormalColor(Color.white, 25, 16, normalColor, 100);
		btnCancel.setFoucesdColor(fouceColor);
		uploadPanel.add(btnCancel);
		setContentPane(uploadPanel);
	}
}
