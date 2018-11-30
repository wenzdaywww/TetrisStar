package com.www.gameview;

import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JMenu;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JMenuBar;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import javax.swing.JMenuItem;
import javax.swing.ButtonGroup;
import java.awt.event.KeyEvent;
import javax.swing.JRadioButton;
import java.awt.event.ActionEvent;
import com.www.gamemodel.GridBlock;
import javax.swing.JRadioButtonMenuItem;
	/**
	 * ��������
	 * @author wWw
	 *
	 */
@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	/** @see ��Ϸ�˵�*/
	public JMenu gameMenu;	
	/** @see �����˵�*/
	public JMenu helpMenu;	
	/** @see ��ǩ����*/
	public JLabel labelUp;	
	/** @see �����ǩ*/
	public JLabel labelLeft;	
	/** @see ���±�ǩ*/
	public JLabel labelDown;	
	/** @see �Զ���ģʽ�˵���*/
	public JMenuItem setItem;	
	/** @see �˵���*/
	private JMenuBar menuBar;	
	/** @see ���ұ�ǩ*/
	public JLabel labelRight;	
	/** @see �����˵���*/
	public JMenuItem godItem;	
	/** @see �˳���Ϸ�˵���*/
	public JMenuItem exitItem;	
	/** @see ���ע��˵���*/
	public JMenuItem registerItem;	
	/** @see ������ǩ*/
	private JLabel labelScore; 	
	/** @see ��ǰģʽ��ǩ*/
	private JLabel labelLevel;	
	/** @see ���ڲ˵���*/
	public JMenuItem aboutItem;	
	/** @see �Զ���Ի���*/
	public DiyDialog diyDialog;	
	/** @see �����Ի���*/
	public GodDialog godDialog;	
	/** @see ��ͣ/������ť*/
	public MyButtonUI btnPause;	
	/** @see ��Ϸ˵���˵�ѡ��*/
	public JMenuItem explainItem;
	/** @see ��Ϸ������������*/
	public BlockPanel blockPanel;
	/** @see ���¿�ʼ��ť*/
	public MyButtonUI btnRestart;
	/** @see ������ٰ�ť*/
	public MyButtonUI btnSpeedUp;
	/** @see ��һ�������ǩ*/
	public JLabel labelNextShape;
	/** @see �������*/
	private JPanel infomationPanel;
	/** @see ���ڶԻ���*/
	public AboutDialog aboutDialog;
	/** @see ������ٰ�ť*/
	public MyButtonUI btnSpeedDown;
	/** @see ������*/
	public BackgroupPanel mainPanel;
	/** @see �������鰴ť*/
	public MyButtonUI btnChangeNext;
	/** @see �������ֵ�ѡ��*/
	public JRadioButton radioBtnMusic;
	/** @see ���ע�ᴰ��*/
	public RegisterFrame registerFrame;
	/** @see ��Ϸ˵���Ի���*/
	public ExplainDialog explainDialog;
	/** @see ��Ϣ��ʾ�Ի���*/
	public MessageDialog messageDialog;
	/** @see ����Ԥ������*/
	public NextShowPanel nextShowPanel;
	/** @see ��ť��Ч��ѡ��ť*/
	public JRadioButton radioBtnSounds;
	/** @see ���˳���ģʽ�˵���*/
	public JRadioButtonMenuItem singleSimpleRdbItem;
	/** @see �����м�ģʽ�˵���*/
	public JRadioButtonMenuItem singleMiddleRdbItem;
	/** @see ���˸߼�ģʽ�˵���*/
	public JRadioButtonMenuItem singleSeniorRdbItem;
	/** @see ˫�˳���ģʽ�˵���*/
	public JRadioButtonMenuItem doubleSimpleRdbItem;
	/** @see ˫���м�ģʽ�˵���*/
	public JRadioButtonMenuItem doubleMiddleRdbItem;
	/** @see ˫�˸߼�ģʽ�˵���*/
	public JRadioButtonMenuItem doubleSeniorRdbItem;
	/** @see �����ı�������ɫ*/
	public static final Color FontColor=Color.blue;	
	/** @see �����밴ťʱ��ť����ɫ*/
	private Color fouceColor=new Color(30, 121, 192, 255);
	/** @see ��ť������ʾ����ɫ*/
	private Color normalColor=new Color(30, 121, 192, 120);
	/**
	 * ��ʼ���������������״
	 */
	public MainFrame() {
		initComponent();
	}
	/**
	 * ���õ�ǰ�÷�
	 * @param score ��ǰ�÷�
	 */
	public void setLabelScore(int score){
		labelScore.setText("��   �֣�"+Integer.toString(score));
	}
	/**
	 * ���õ�ǰ�ȼ�
	 * @param level ��ǰ�ȼ�
	 */
	public void setLabelLevel(String level){
		labelLevel.setText("��ǰģʽ��"+level);
	}
	/**
	 * �����������ʼ��
	 */
	private void initComponent(){
		setFocusable(true);
		setVisible(false);
		setTitle("TetrisStar");
		setResizable(false);
		setSize(GridBlock.COL*GridBlock.SIZE+GridBlock.SIZE*8, GridBlock.ROW*GridBlock.SIZE+51);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);	//���ô���رհ�ť�޶���
		setIconImage(Toolkit.getDefaultToolkit().getImage("image/tetris.png"));
		mainPanel=new BackgroupPanel();
		mainPanel.setLayout(null);
		setContentPane(mainPanel);
		//�˵�����ʼ��
		menuBar =new JMenuBar();
		menuBar.setBounds(0, 0, GridBlock.COL*GridBlock.SIZE+GridBlock.SIZE*8, 23);
		mainPanel.add(menuBar);
		gameMenu=new JMenu("��Ϸ��G��");
		gameMenu.setMnemonic(KeyEvent.VK_G);
		gameMenu.setToolTipText("��ݼ���Alt+G");
		menuBar.add(gameMenu);
		//���˲˵�
		JMenu startSingleMenu=new JMenu("��ʼ������Ϸ");
		startSingleMenu.setIcon(new ImageIcon("image/start.png"));
		singleSimpleRdbItem=new JRadioButtonMenuItem("����ģʽ");
		singleSimpleRdbItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));//���ÿ�ݼ�ΪCtrl+S
		singleSimpleRdbItem.setToolTipText("��ģʽ����7�У������ٶ�500ms");
		singleMiddleRdbItem=new JRadioButtonMenuItem("�м�ģʽ");
		singleMiddleRdbItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));//���ÿ�ݼ�ΪCtrl+M
		singleMiddleRdbItem.setToolTipText("��ģʽ����8�У������ٶ�300ms");
		singleSeniorRdbItem=new JRadioButtonMenuItem("�߼�ģʽ");
		singleSeniorRdbItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK));//���ÿ�ݼ�ΪCtrl+H
		singleSeniorRdbItem.setToolTipText("��ģʽ����9�У������ٶ�100ms");
		ButtonGroup buttonGroup=new ButtonGroup();
		buttonGroup.add(singleSimpleRdbItem);
		buttonGroup.add(singleMiddleRdbItem);
		buttonGroup.add(singleSeniorRdbItem);
		startSingleMenu.add(singleSimpleRdbItem);
		startSingleMenu.add(singleMiddleRdbItem);
		startSingleMenu.add(singleSeniorRdbItem);
		gameMenu.add(startSingleMenu);
		//˫�˲˵�
		JMenu startDoubleMenu=new JMenu("��ʼ˫����Ϸ");
		startDoubleMenu.setIcon(new ImageIcon("image/start.png"));
		doubleSimpleRdbItem=new JRadioButtonMenuItem("����ģʽ");
		doubleSimpleRdbItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.SHIFT_MASK));//���ÿ�ݼ�ΪAlt+S
		doubleSimpleRdbItem.setToolTipText("��ģʽ����7�У������ٶ�500ms");
		doubleMiddleRdbItem=new JRadioButtonMenuItem("�м�ģʽ");
		doubleMiddleRdbItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.SHIFT_MASK));//���ÿ�ݼ�ΪAlt+M
		doubleMiddleRdbItem.setToolTipText("��ģʽ����8�У������ٶ�300ms");
		doubleSeniorRdbItem=new JRadioButtonMenuItem("�߼�ģʽ");
		doubleSeniorRdbItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.SHIFT_MASK));//���ÿ�ݼ�ΪAlt+H
		doubleSeniorRdbItem.setToolTipText("��ģʽ����9�У������ٶ�100ms");
		ButtonGroup buttonDoubleGroup=new ButtonGroup();
		buttonDoubleGroup.add(doubleSimpleRdbItem);
		buttonDoubleGroup.add(doubleMiddleRdbItem);
		buttonDoubleGroup.add(doubleSeniorRdbItem);
		startDoubleMenu.add(doubleSimpleRdbItem);
		startDoubleMenu.add(doubleMiddleRdbItem);
		startDoubleMenu.add(doubleSeniorRdbItem);
		gameMenu.add(startDoubleMenu);
		setItem=new JMenuItem("�Զ���ģʽ");
		setItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));//���ÿ�ݼ�ΪCtrl+D
		setItem.setIcon(new ImageIcon("image/set.png"));
		godItem=new JMenuItem("�����");
		godItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));//���ÿ�ݼ�ΪCtrl+G
		godItem.setIcon(new ImageIcon("image/god.png"));
		registerItem=new JMenuItem("���ע��");
		registerItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));//���ÿ�ݼ�ΪCtrl+U
		registerItem.setIcon(new ImageIcon("image/user.png"));
		exitItem=new JMenuItem("�˳�");
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));//���ÿ�ݼ�ΪCtrl+E
		exitItem.setIcon(new ImageIcon("image/exit.png"));
		gameMenu.add(godItem);
		gameMenu.add(registerItem);
		gameMenu.add(setItem);
		gameMenu.add(exitItem);
		helpMenu=new JMenu("������H��");
		helpMenu.setMnemonic(KeyEvent.VK_H);
		helpMenu.setToolTipText("��ݼ���Alt+H");
		aboutItem=new JMenuItem("����");
		aboutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));//���ÿ�ݼ�ΪCtrl+A
		aboutItem.setIcon(new ImageIcon("image/about.png"));
		explainItem=new JMenuItem("��Ϸ˵��");
		explainItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.ALT_MASK));//���ÿ�ݼ�ΪAlt+E
		explainItem.setIcon(new ImageIcon("image/question.png"));
		menuBar.add(helpMenu);
		helpMenu.add(aboutItem);
		helpMenu.add(explainItem);
		//�����������
		blockPanel=new BlockPanel();
		blockPanel.setLocation(0, 23);
		mainPanel.add(blockPanel);
		//��ʾ��Ϣ���
		infomationPanel=new JPanel();
		infomationPanel.setLayout(null);
		infomationPanel.setOpaque(false);
		infomationPanel.setSize(GridBlock.SIZE*9,GridBlock.SIZE*GridBlock.ROW);
		infomationPanel.setLocation(GridBlock.SIZE*GridBlock.COL, 23);
		nextShowPanel=new NextShowPanel();
		nextShowPanel.setLocation(50, 30);
		infomationPanel.add(nextShowPanel);
		mainPanel.add(infomationPanel);
		//�����Ի������
		aboutDialog=new AboutDialog();
		diyDialog=new DiyDialog();
		godDialog=new GodDialog();
		registerFrame=new RegisterFrame();
		messageDialog=new MessageDialog();
		explainDialog=new ExplainDialog();
		//��ǩ���
		labelNextShape = new JLabel("��һ��");
		labelNextShape.setFont(new Font("��Բ", Font.PLAIN, 13));
		labelNextShape.setForeground(FontColor);
		labelNextShape.setBounds(50, 10, 80, 15);
		infomationPanel.add(labelNextShape);
		labelScore = new JLabel("��   �֣�0");
		labelScore.setFont(new Font("��Բ", Font.PLAIN, 15));
		labelScore.setForeground(FontColor);
		labelScore.setBounds(30, 250, 130, 15);
		infomationPanel.add(labelScore);
		labelLevel = new JLabel("��ǰģʽ��");
		labelLevel.setFont(new Font("��Բ", Font.PLAIN, 15));
		labelLevel.setForeground(FontColor);
		labelLevel.setBounds(30, 280, 130, 15);
		infomationPanel.add(labelLevel);
		//�������鰴ť
		btnChangeNext = new MyButtonUI();
		btnChangeNext.setBtnText("�������飨Q��");
		btnChangeNext.setNormalColor(Color.white, 14, 16, normalColor, 200);
		btnChangeNext.setFoucesdColor(fouceColor);
		btnChangeNext.setOpaque(false);
		btnChangeNext.setVisible(false);
		btnChangeNext.setBounds(25, 100, 110, 23);
		btnChangeNext.setFocusable(false);
		infomationPanel.add(btnChangeNext);
		//��ͣ/������ť
		btnPause = new MyButtonUI();
		btnPause.setBtnText("��ͣ���ո�");
		btnPause.setNormalColor(Color.white, 14, 16, normalColor, 200);
		btnPause.setFoucesdColor(fouceColor);
		btnPause.setOpaque(false);
		btnPause.setFocusable(false);
		btnPause.setVisible(false);
		btnPause.setBounds(25, 305, 110, 23);
		infomationPanel.add(btnPause);
		//���¿�ʼ��ť
		btnRestart = new MyButtonUI();
		btnRestart.setBtnText("���¿�ʼ��T��");
		btnRestart.setToolTipText("���¿�ʼ�����õ�ģʽ");
		btnRestart.setNormalColor(Color.white, 14, 16, normalColor, 200);
		btnRestart.setFoucesdColor(fouceColor);
		btnRestart.setOpaque(false);
		btnRestart.setVisible(false);
		btnRestart.setFocusable(false);
		btnRestart.setBounds(25, 338, 110, 23);
		infomationPanel.add(btnRestart);
		//������ٰ�ť
		btnSpeedUp = new MyButtonUI();
		btnSpeedUp.setBtnText("������٣�E��");
		btnSpeedUp.setNormalColor(Color.white, 14, 16, normalColor, 200);
		btnSpeedUp.setFoucesdColor(fouceColor);
		btnSpeedUp.setOpaque(false);
		btnSpeedUp.setVisible(false);
		btnSpeedUp.setFocusable(false);
		btnSpeedUp.setBounds(25, 371, 110, 23);
		infomationPanel.add(btnSpeedUp);
		//������ٰ�ť
		btnSpeedDown = new MyButtonUI();
		btnSpeedDown.setBtnText("������٣�R��");
		btnSpeedDown.setNormalColor(Color.white, 14, 16, normalColor, 200);
		btnSpeedDown.setFoucesdColor(fouceColor);
		btnSpeedDown.setOpaque(false);
		btnSpeedDown.setVisible(false);
		btnSpeedDown.setFocusable(false);
		btnSpeedDown.setBounds(25, 404, 110, 23);
		infomationPanel.add(btnSpeedDown);
		//��Ч��ѡ��ť
		radioBtnSounds=new JRadioButton(new ImageIcon("image/soundson.png"),true);
		radioBtnSounds.setOpaque(false);
		radioBtnSounds.setFocusable(false);
		radioBtnSounds.setSelected(true);
		radioBtnSounds.setBounds(10, 210, 25, 20);
		infomationPanel.add(radioBtnSounds);
		//�������ֵ�ѡ��ť
		radioBtnMusic=new JRadioButton(new ImageIcon("image/musicoff.png"),true);
		radioBtnMusic.setOpaque(false);
		radioBtnMusic.setFocusable(false);
		radioBtnMusic.setSelected(false);
		radioBtnMusic.setBounds(40, 210, 25, 20);
		infomationPanel.add(radioBtnMusic);
		JPanel operationPanel = new JPanel();
		operationPanel.setOpaque(false);
		operationPanel.setLayout(new GridLayout(3, 3));
		operationPanel.setBounds(45, 133, 102, 102);
		//�����ǩ
		labelUp=new JLabel(new ImageIcon("image/up.png"));
		labelDown=new JLabel(new ImageIcon("image/down.png"));
		labelLeft=new JLabel(new ImageIcon("image/left.png"));
		labelRight=new JLabel(new ImageIcon("image/right.png"));
		JLabel label1=new JLabel();
		label1.setOpaque(false);
		JLabel label3=new JLabel();
		label3.setOpaque(false);
		JLabel label5=new JLabel();
		label5.setOpaque(false);
		JLabel label7=new JLabel();
		label7.setOpaque(false);
		JLabel label9=new JLabel();
		label9.setOpaque(false);
		operationPanel.add(label1);
		operationPanel.add(labelUp);
		operationPanel.add(label3);
		operationPanel.add(labelLeft);
		operationPanel.add(label5);
		operationPanel.add(labelRight);
		operationPanel.add(label7);
		operationPanel.add(labelDown);
		operationPanel.add(label9);
		infomationPanel.add(operationPanel);
	}
	/**
	 * �ı䴰���С��������
	 */
	public void changFrame(){
		setSize(GridBlock.COL*GridBlock.SIZE+GridBlock.SIZE*8, GridBlock.ROW*GridBlock.SIZE+51);
		blockPanel.setSize(GridBlock.COL*GridBlock.SIZE, GridBlock.ROW*GridBlock.SIZE);
		menuBar.setBounds(0, 0, GridBlock.COL*GridBlock.SIZE+GridBlock.SIZE*8, 23);
		infomationPanel.setLocation(GridBlock.SIZE*GridBlock.COL, 23);
		this.repaint();
	}
}
