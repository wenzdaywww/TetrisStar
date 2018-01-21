package com.www.gameview;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JDialog;
	/**
	 * ���ڶԻ�����
	 * @author wWw
	 */
@SuppressWarnings("serial")
public class AboutDialog extends JDialog {
	/**
	 * ���ڶԻ�������ĳ�ʼ��
	 */
	public AboutDialog() {
		setTitle("����");
		setSize(320, 180);
		setVisible(false);
		setModal(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("image/about.png"));
		setLocationRelativeTo(null);
		AboutPanel aboutPane=new AboutPanel();
		setContentPane(aboutPane);
		getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("����˹����");
		lblNewLabel.setFont(new Font("��Բ", Font.PLAIN, 13));
		lblNewLabel.setForeground(MainFrame.FontColor);
		lblNewLabel.setBounds(158, 10, 116, 15);
		getContentPane().add(lblNewLabel);
		JLabel lblNewLabel_1 = new JLabel("�汾:  V1.0");
		lblNewLabel_1.setFont(new Font("��Բ", Font.PLAIN, 13));
		lblNewLabel_1.setForeground(MainFrame.FontColor);
		lblNewLabel_1.setBounds(158, 40, 116, 15);
		getContentPane().add(lblNewLabel_1);
		JLabel lblNewLabel_2 = new JLabel("��Ȩ����:  2016 WWW");
		lblNewLabel_2.setFont(new Font("��Բ", Font.PLAIN, 13));
		lblNewLabel_2.setForeground(MainFrame.FontColor);
		lblNewLabel_2.setBounds(158, 70, 130, 15);
		getContentPane().add(lblNewLabel_2);
		JLabel lblNewLabel_3 = new JLabel("����:  ��ΰ��");
		lblNewLabel_3.setFont(new Font("��Բ", Font.PLAIN, 13));
		lblNewLabel_3.setForeground(MainFrame.FontColor);
		lblNewLabel_3.setBounds(158, 100, 116, 15);
		getContentPane().add(lblNewLabel_3);
	}
	/**
	 * ���ڶԻ�����ͼƬ������
	 * @author wWw
	 *
	 */
	private class AboutPanel extends BackgroupPanel{
		
		public AboutPanel() {
			setLayout(null);
		}
		/**
		 * �ػ�����ͼƬ
		 */
		@Override
		protected void paintComponent(Graphics g) {
			Image image=Toolkit.getDefaultToolkit().getImage(BackgroupPanel.backgroupImage);
			g.drawImage(image, 0, 0, this);
			Image image1=Toolkit.getDefaultToolkit().getImage("image/www.png");
			g.drawImage(image1, 0, 20, this);
		}
	}
}
