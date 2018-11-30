package com.www.gameview;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
	/**
	 * ������Ի�����
	 * @author wWw
	 *
	 */
@SuppressWarnings("serial")
public class GodDialog extends JDialog {
	/**@see �߼�ģʽ���һ����ǩ*/
	public JLabel seniorLastUser;	
	/**@see ����ģʽ���һ����ǩ*/
	public JLabel simpleLastUser;	
	/**@see �м�ģʽ���һ����ǩ*/
	public JLabel middleLastUser;	
	/**@see ����ģʽ��һ����ǩ*/
	public JLabel simpleFirstUser;	
	/**@see ����ģʽ��������ǩ*/
	public JLabel simpleThirdUser;	
	/**@see �м�ģʽ��һ����ǩ*/
	public JLabel middleFirstUser;		
	/**@see �м�ģʽ��������ǩ*/
	public JLabel middleThirdUser;	
	/**@see �߼�ģʽ��һ����ǩ*/
	public JLabel seniorFirstUser;	
	/**@see �߼�ģʽ��������ǩ*/
	public JLabel seniorThirdUser;	
	/**@see �м�ģʽ�ڶ�����ǩ*/
	public JLabel middleSecondUser;	
	/**@see ����ģʽ�ڶ�����ǩ*/
	public JLabel simpleSecondUser;	
	/**@see �߼�ģʽ�ڶ�����ǩ*/
	public JLabel seniorSecondUser;	
	/**@see ��̬ģʽ���һ����ǩ*/
	public JLabel nonhumanLastUser;	
	/**@see �м�����ҷ�����ʾ�ı�*/
	public JTextArea middleTextArea;
	/**@see �߼�����ҷ�����ʾ�ı�*/
	public JTextArea seniorTextArea;
	/**@see ��������ҷ�����ʾ�ı�*/
	public JTextArea simpleTextArea;
	/**@see ��̬ģʽ��������ǩ*/
	public JLabel nonhumanThirdUser;
	/**@see ��̬ģʽ��һ����ǩ*/
	public JLabel nonhumanFirstUser;
	/**@see ��̬ģʽ�ڶ�����ǩ*/
	public JLabel nonhumanSecondUser;
	/**@see ��̬����ҷ�����ʾ�ı�*/
	public JTextArea nonhumanTextArea;
	/**
	 * ��ʼ�������
	 */
	public GodDialog() {
		setTitle("�����");
		setSize(480, 300);
		setVisible(false);
		setModal(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage("image/god.png"));
		BackgroupPanel godPanel=new BackgroupPanel();
		godPanel.setLayout(new BorderLayout());
		JTabbedPane tabbedPane=new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFocusable(false);
		tabbedPane.setOpaque(false);
		//�����������ʼ��
		BackgroupPanel simpleGodPanel=new BackgroupPanel();
		simpleGodPanel.setLayout(null);
		simpleFirstUser=new JLabel("��һ��");
		simpleFirstUser.setFont(new Font("��Բ", Font.PLAIN, 15));
		simpleFirstUser.setForeground(MainFrame.FontColor);
		simpleFirstUser.setBounds(90, 5, 100, 20);
		simpleGodPanel.add(simpleFirstUser);
		simpleSecondUser=new JLabel("�ڶ���");
		simpleSecondUser.setFont(new Font("��Բ", Font.PLAIN, 15));
		simpleSecondUser.setForeground(MainFrame.FontColor);
		simpleSecondUser.setBounds(5, 28, 100, 20);
		simpleGodPanel.add(simpleSecondUser);
		simpleThirdUser=new JLabel("������");
		simpleThirdUser.setFont(new Font("��Բ", Font.PLAIN, 15));
		simpleThirdUser.setForeground(MainFrame.FontColor);
		simpleThirdUser.setBounds(130, 33, 80, 20);
		simpleGodPanel.add(simpleThirdUser);
		simpleLastUser=new JLabel("���һ��");
		simpleLastUser.setFont(new Font("��Բ", Font.PLAIN, 15));
		simpleLastUser.setForeground(MainFrame.FontColor);
		simpleLastUser.setBounds(85, 207, 80, 20);
		simpleGodPanel.add(simpleLastUser);
		RankPanel simpleRankPanel=new RankPanel();
		simpleRankPanel.setOpaque(false);
		simpleRankPanel.setBounds(0, 0, 200, 240);
		simpleGodPanel.add(simpleRankPanel);
		simpleTextArea=new JTextArea();
		simpleTextArea.setBounds(230, 0, 240, 243);
		simpleTextArea.setOpaque(false);
		simpleTextArea.setEditable(false);
		simpleTextArea.setFont(new Font("��Բ", Font.PLAIN, 15));
		simpleTextArea.setForeground(MainFrame.FontColor);
		JScrollPane simpleScrollPane=new JScrollPane(simpleTextArea);
		simpleScrollPane.setBounds(230, 0, 240, 243);
		simpleScrollPane.setOpaque(false);
		simpleScrollPane.getViewport().setOpaque(false);
		simpleGodPanel.add(simpleScrollPane);
		//�м��������ʼ��
		BackgroupPanel middleGodPanel=new BackgroupPanel();
		middleGodPanel.setLayout(null);
		middleFirstUser=new JLabel("��һ��");
		middleFirstUser.setFont(new Font("��Բ", Font.PLAIN, 15));
		middleFirstUser.setForeground(MainFrame.FontColor);
		middleFirstUser.setBounds(90, 5, 100, 20);
		middleGodPanel.add(middleFirstUser);
		middleSecondUser=new JLabel("�ڶ���");
		middleSecondUser.setFont(new Font("��Բ", Font.PLAIN, 15));
		middleSecondUser.setForeground(MainFrame.FontColor);
		middleSecondUser.setBounds(5, 28, 100, 20);
		middleGodPanel.add(middleSecondUser);
		middleThirdUser=new JLabel("������");
		middleThirdUser.setFont(new Font("��Բ", Font.PLAIN, 15));
		middleThirdUser.setForeground(MainFrame.FontColor);
		middleThirdUser.setBounds(130, 33, 80, 20);
		middleGodPanel.add(middleThirdUser);
		middleLastUser=new JLabel("���һ��");
		middleLastUser.setFont(new Font("��Բ", Font.PLAIN, 15));
		middleLastUser.setForeground(MainFrame.FontColor);
		middleLastUser.setBounds(85, 207, 80, 20);
		middleGodPanel.add(middleLastUser);
		RankPanel middleRankPanel=new RankPanel();
		middleRankPanel.setOpaque(false);
		middleRankPanel.setBounds(0, 0, 200, 240);
		middleGodPanel.add(middleRankPanel);
		middleTextArea=new JTextArea();
		middleTextArea.setBounds(230, 0, 240, 243);
		middleTextArea.setOpaque(false);
		middleTextArea.setEditable(false);
		middleTextArea.setFont(new Font("��Բ", Font.PLAIN, 15));
		middleTextArea.setForeground(MainFrame.FontColor);
		JScrollPane middleScrollPane=new JScrollPane(middleTextArea);
		middleScrollPane.setBounds(230, 0, 240, 243);
		middleScrollPane.setOpaque(false);
		middleScrollPane.getViewport().setOpaque(false);
		middleGodPanel.add(middleScrollPane);
		//�߼��������ʼ��
		BackgroupPanel seniorGodPanel=new BackgroupPanel();
		seniorGodPanel.setLayout(null);
		seniorFirstUser=new JLabel("��һ��");
		seniorFirstUser.setFont(new Font("��Բ", Font.PLAIN, 15));
		seniorFirstUser.setForeground(MainFrame.FontColor);
		seniorFirstUser.setBounds(90, 5, 100, 20);
		seniorGodPanel.add(seniorFirstUser);
		seniorSecondUser=new JLabel("�ڶ���");
		seniorSecondUser.setFont(new Font("��Բ", Font.PLAIN, 15));
		seniorSecondUser.setForeground(MainFrame.FontColor);
		seniorSecondUser.setBounds(5, 28, 100, 20);
		seniorGodPanel.add(seniorSecondUser);
		seniorThirdUser=new JLabel("������");
		seniorThirdUser.setFont(new Font("��Բ", Font.PLAIN, 15));
		seniorThirdUser.setForeground(MainFrame.FontColor);
		seniorThirdUser.setBounds(130, 33, 80, 20);
		seniorGodPanel.add(seniorThirdUser);
		seniorLastUser=new JLabel("���һ��");
		seniorLastUser.setFont(new Font("��Բ", Font.PLAIN, 15));
		seniorLastUser.setForeground(MainFrame.FontColor);
		seniorLastUser.setBounds(85, 207, 100, 20);
		seniorGodPanel.add(seniorLastUser);
		RankPanel seniorRankPanel=new RankPanel();
		seniorRankPanel.setOpaque(false);
		seniorRankPanel.setBounds(0, 0, 200, 240);
		seniorGodPanel.add(seniorRankPanel);
		seniorTextArea=new JTextArea();
		seniorTextArea.setBounds(230, 0, 240, 243);
		seniorTextArea.setOpaque(false);
		seniorTextArea.setEditable(false);
		seniorTextArea.setFont(new Font("��Բ", Font.PLAIN, 15));
		seniorTextArea.setForeground(MainFrame.FontColor);
		JScrollPane senioeScrollPane=new JScrollPane(seniorTextArea);
		senioeScrollPane.setBounds(230, 0, 240, 243);
		senioeScrollPane.setOpaque(false);
		senioeScrollPane.getViewport().setOpaque(false);
		seniorGodPanel.add(senioeScrollPane);
		//��̬�������ʼ��
		BackgroupPanel nonhumanGodPanel=new BackgroupPanel();
		nonhumanGodPanel.setLayout(null);
		nonhumanFirstUser=new JLabel("��һ��");
		nonhumanFirstUser.setFont(new Font("��Բ", Font.PLAIN, 15));
		nonhumanFirstUser.setForeground(MainFrame.FontColor);
		nonhumanFirstUser.setBounds(90, 5, 100, 20);
		nonhumanGodPanel.add(nonhumanFirstUser);
		nonhumanSecondUser=new JLabel("�ڶ���");
		nonhumanSecondUser.setFont(new Font("��Բ", Font.PLAIN, 15));
		nonhumanSecondUser.setForeground(MainFrame.FontColor);
		nonhumanSecondUser.setBounds(5, 28, 100, 20);
		nonhumanGodPanel.add(nonhumanSecondUser);
		nonhumanThirdUser=new JLabel("������");
		nonhumanThirdUser.setFont(new Font("��Բ", Font.PLAIN, 15));
		nonhumanThirdUser.setForeground(MainFrame.FontColor);
		nonhumanThirdUser.setBounds(130, 33, 80, 20);
		nonhumanGodPanel.add(nonhumanThirdUser);
		nonhumanLastUser=new JLabel("���һ��");
		nonhumanLastUser.setFont(new Font("��Բ", Font.PLAIN, 15));
		nonhumanLastUser.setForeground(MainFrame.FontColor);
		nonhumanLastUser.setBounds(85, 207, 80, 20);
		nonhumanGodPanel.add(nonhumanLastUser);
		RankPanel nonhumanRankPanel=new RankPanel();
		nonhumanRankPanel.setOpaque(false);
		nonhumanRankPanel.setBounds(0, 0, 200, 240);
		nonhumanGodPanel.add(nonhumanRankPanel);
		nonhumanTextArea=new JTextArea();
		nonhumanTextArea.setBounds(230, 0, 240, 243);
		nonhumanTextArea.setOpaque(false);
		nonhumanTextArea.setEditable(false);
		nonhumanTextArea.setFont(new Font("��Բ", Font.PLAIN, 15));
		nonhumanTextArea.setForeground(MainFrame.FontColor);
		JScrollPane nonhumanScrollPane=new JScrollPane(nonhumanTextArea);
		nonhumanScrollPane.setBounds(230, 0, 240, 243);
		nonhumanScrollPane.setOpaque(false);
		nonhumanScrollPane.getViewport().setOpaque(false);
		nonhumanGodPanel.add(nonhumanScrollPane);
		tabbedPane.add("������",simpleGodPanel);
		tabbedPane.add("�м���",middleGodPanel);
		tabbedPane.add("�߼���",seniorGodPanel);
		tabbedPane.add("��̬��",nonhumanGodPanel);
		godPanel.add(tabbedPane,BorderLayout.CENTER);
		setContentPane(godPanel);
	}
	/**
	 * ���콱̨ͼƬ����������
	 * @author wWw
	 *
	 */
	private class RankPanel extends JPanel{
		@Override
		protected void paintComponent(Graphics g) {
			Image image=Toolkit.getDefaultToolkit().getImage("image/rank.png");
			g.drawImage(image, 0, 0, this);
		}
	}
}
