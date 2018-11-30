package com.www.gameview;

import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
	/**
	 * ���ע�ᴰ����
	 * @author wWw
	 *
	 */
@SuppressWarnings("serial")
public class RegisterFrame extends JFrame{
	/** @see ȡ����ť*/
	public MyButtonUI btnExit;	
	/** @see ע�ᰴť*/
	public MyButtonUI btnRegister;	
	/** @see ע�ᴰ�������*/
	public BackgroupPanel loginPanel;	
	/** @see �����*/
	public JTextField gameUserTextField;	
	/** @see �����밴ťʱ��ť����ɫ*/
	private Color fouceColor=new Color(27, 120, 255, 255);
	/** @see ��ť����״̬�ǵ���ɫ*/
	private Color normalColor=new Color(27, 120, 255, 120);
	/**
	 * �������ʼ��
	 */
	public RegisterFrame() {
		setSize(300, 200);
		setTitle("���ע��");
		setLocationRelativeTo(null);
		setUndecorated(true);
		setVisible(true);
		loginPanel=new BackgroupPanel();
		loginPanel.setVerifyInputWhenFocusTarget(false);
		setContentPane(loginPanel);
		JLabel lblNewLabel = new JLabel("����˹�������ע��");
		lblNewLabel.setFont(new Font("��Բ", Font.PLAIN, 20));
		lblNewLabel.setForeground(MainFrame.FontColor);
		lblNewLabel.setBounds(60, 23, 198, 33);
		getContentPane().add(lblNewLabel);
		JLabel lblNewLabel_1 = new JLabel("��ң�");
		lblNewLabel_1.setFont(new Font("��Բ", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(MainFrame.FontColor);
		lblNewLabel_1.setBounds(10, 80, 60, 33);
		getContentPane().add(lblNewLabel_1);
		gameUserTextField = new JTextField();
		gameUserTextField.setOpaque(false);
		gameUserTextField.setToolTipText("������С��5�����ȵ��ַ�");
		gameUserTextField.setFont(new Font("��Բ", Font.PLAIN, 17));
		gameUserTextField.setBounds(60, 87, 185, 21);
		gameUserTextField.setForeground(MainFrame.FontColor);
		getContentPane().add(gameUserTextField);
		gameUserTextField.setColumns(10);
		btnRegister = new MyButtonUI();
		btnRegister.setBtnText("������Ϸ");
		btnRegister.setNormalColor(Color.white , 25, 16, normalColor, 200);
		btnRegister.setFoucesdColor(fouceColor);
		btnRegister.setBounds(30, 150, 110, 25);
		btnRegister.setOpaque(false);
		getContentPane().add(btnRegister);
		btnExit = new MyButtonUI();
		btnExit.setBtnText("�˳�");
		btnExit.setNormalColor(Color.white , 40, 16, normalColor, 200);
		btnExit.setFoucesdColor(fouceColor);
		btnExit.setOpaque(false);
		btnExit.setBounds(177, 150, 110, 25);
		getContentPane().add(btnExit);
		JLabel lblNewLabel_2 = new JLabel("���Բ�ע�ᣬ���޷��ϴ�����");
		lblNewLabel_2.setForeground(MainFrame.FontColor);
		lblNewLabel_2.setFont(new Font("��Բ", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(59, 118, 185, 15);
		loginPanel.add(lblNewLabel_2);
		setIconImage(Toolkit.getDefaultToolkit().getImage("image/user.png"));
	}
}
