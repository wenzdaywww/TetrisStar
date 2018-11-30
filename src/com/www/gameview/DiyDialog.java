package com.www.gameview;

import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JDialog;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.SpinnerNumberModel;
import javax.swing.JFormattedTextField;
	/**
	 * �Զ���Ի�����
	 * @author wWw
	 *
	 */
@SuppressWarnings("serial")
public class DiyDialog extends JDialog {
	/**@see �����ٶȻ���*/
	public JSlider slider;	
	/**@see ȷ����ʼ��Ϸ��ť*/
	public MyButtonUI btnOk;	
	/**@see ��Ϸը����ѡ��*/
	public JCheckBox chckbxBoom;	
	/**@see ���ذ�ť*/
	public MyButtonUI btnCancel;	
	/**@see �����Զ����ǰ�ť*/
	public JCheckBox chckbxAutoUp;	
	/**@see ��ʾ�����ٶȵı�ǩ*/
	private JLabel labelShowSpeed;	
	/**@see ����һ��ѡ��ť*/
	public JRadioButton rdbtnStyle1;
	/**@see �������ѡ��ť*/
	public JRadioButton rdbtnStyle2;
	/**@see ��������ѡ��ť*/
	public JRadioButton rdbtnStyle3;
	/**@see ѡ���Զ����ǵ�����*/
	public JSpinner spinnerAutoUpY;	
	/**@see ����ģʽ��ѡ��ť*/
	public JRadioButton rdbtnSimple;
	/**@see �м�ģʽ��ѡ��ť*/
	public JRadioButton rdbtnMiddle;
	/**@see �߼�ģʽ��ѡ��ť*/
	public JRadioButton rdbtnSenior;
	/**@see �����߸�ѡ��*/
	public JCheckBox chckbxHlepLine;
	/**@see ����Ԥ����ѡ��*/
	public JCheckBox chckbxShowNext;
	/**@see ģʽ�Զ�������ѡ��*/
	public JCheckBox chckbxAutoLevel;
	/**@see �����ٶȿ��Ƹ�ѡ��*/
	public JCheckBox chckbxCtrlSpeed;
	/**@see ��Ϸ���������*/
	public JSpinner spinnerPanelCol;
	/**@see ���÷��鸴ѡ��*/
	public JCheckBox chckbxChangeNext;
	/**@see ����������ָ�ѡ��*/
	public JCheckBox chckbxRandomOpen;
	/**@see ����ı临ѡ��*/
	public JCheckBox checkBoxChangeCol;
	/**@see ����������ִ���*/
	public JSpinner spinnerRandomTime;
	/**@see �����밴ť�����ɫ*/
	private Color fouceColor=new Color(75, 209, 238, 255);	
	/**@see ��ť����״̬�ǵ���ɫ*/
	private Color normalColor=new Color(75, 209, 238, 120);	
	/**
	 * ��ʼ���������
	 */
	public DiyDialog() {
		setTitle("�Զ������");
		setSize(450, 350);
		setVisible(false);
		setModal(true);
		setResizable(false);
		setFocusable(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("image/set.png"));
		setLocationRelativeTo(null);
		BackgroupPanel setPane=new BackgroupPanel();
		setContentPane(setPane);
		slider = new JSlider();
		slider.setMinimum(50);
		slider.setMaximum(1000);
		slider.setOpaque(false);
		slider.setFocusable(false);
		slider.setValue(50);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(100);
		slider.setMinorTickSpacing(50);
		slider.setForeground(MainFrame.FontColor);
		slider.setPaintLabels(true);
		slider.setBounds(78, 9, 210, 50);
		getContentPane().add(slider);
		JLabel labelSpeed = new JLabel("�����ٶȣ�");
		labelSpeed.setFont(new Font("��Բ", Font.PLAIN, 12));
		labelSpeed.setForeground(MainFrame.FontColor);
		labelSpeed.setBounds(10, 15, 71, 15);
		getContentPane().add(labelSpeed);
		labelShowSpeed = new JLabel("50");
		labelShowSpeed.setFont(new Font("��Բ", Font.PLAIN, 13));
		labelShowSpeed.setForeground(MainFrame.FontColor);
		labelShowSpeed.setBounds(298, 13, 30, 15);
		getContentPane().add(labelShowSpeed);
		JLabel labelBlockShape = new JLabel("������״��");
		labelBlockShape.setFont(new Font("��Բ", Font.PLAIN, 12));
		labelBlockShape.setForeground(MainFrame.FontColor);
		labelBlockShape.setBounds(10, 59, 71, 15);
		getContentPane().add(labelBlockShape);
		rdbtnSimple = new JRadioButton("����");
		rdbtnSimple.setToolTipText("����������7�ַ���");
		rdbtnSimple.setFont(new Font("��Բ", Font.PLAIN, 12));
		rdbtnSimple.setForeground(MainFrame.FontColor);
		rdbtnSimple.setOpaque(false);
		rdbtnSimple.setFocusable(false);
		rdbtnSimple.setBounds(80, 55, 65, 23);
		getContentPane().add(rdbtnSimple);
		rdbtnMiddle = new JRadioButton("�м�");
		rdbtnMiddle.setToolTipText("�м�������8�ַ���");
		rdbtnMiddle.setFont(new Font("��Բ", Font.PLAIN, 12));
		rdbtnMiddle.setForeground(MainFrame.FontColor);
		rdbtnMiddle.setOpaque(false);
		rdbtnMiddle.setFocusable(false);
		rdbtnMiddle.setBounds(180, 55, 77, 23);
		getContentPane().add(rdbtnMiddle);
		rdbtnSenior = new JRadioButton("�߼�");
		rdbtnSenior.setToolTipText("�߼�������9�ַ���");
		rdbtnSenior.setFont(new Font("��Բ", Font.PLAIN, 12));
		rdbtnSenior.setForeground(MainFrame.FontColor);
		rdbtnSenior.setOpaque(false);
		rdbtnSenior.setFocusable(false);
		rdbtnSenior.setBounds(280, 55, 71, 23);
		getContentPane().add(rdbtnSenior);
		ButtonGroup bGroup=new ButtonGroup();
		bGroup.add(rdbtnSimple);
		bGroup.add(rdbtnMiddle);
		bGroup.add(rdbtnSenior);
		chckbxAutoUp = new JCheckBox("�����Զ�����");
		chckbxAutoUp.setToolTipText("��Ϸ�еײ������Զ�����");
		chckbxAutoUp.setFont(new Font("��Բ", Font.PLAIN, 12));
		chckbxAutoUp.setForeground(MainFrame.FontColor);
		chckbxAutoUp.setOpaque(false);
		chckbxAutoUp.setFocusable(false);
		chckbxAutoUp.setBounds(180, 166, 103, 23);
		getContentPane().add(chckbxAutoUp);
		btnCancel = new MyButtonUI();
		btnCancel.setBtnText("����");
		btnCancel.setNormalColor(MainFrame.FontColor, 32, 16, normalColor, 200);
		btnCancel.setFoucesdColor(fouceColor);
		btnCancel.setOpaque(false);
		btnCancel.setFocusable(false);
		btnCancel.setBounds(330, 280, 93, 23);
		getContentPane().add(btnCancel);
		btnOk = new MyButtonUI();
		btnOk.setBtnText("��ʼ��Ϸ");
		btnOk.setNormalColor(MainFrame.FontColor, 18, 16, normalColor, 200);
		btnOk.setFoucesdColor(fouceColor);
		btnOk.setOpaque(false);
		btnOk.setFocusable(false);
		btnOk.setVisible(false);
		btnOk.setBounds(220, 280, 93, 23);
		getContentPane().add(btnOk);
		chckbxHlepLine = new JCheckBox("������");
		chckbxHlepLine.setToolTipText("��������������");
		chckbxHlepLine.setFont(new Font("��Բ", Font.PLAIN, 12));
		chckbxHlepLine.setForeground(MainFrame.FontColor);
		chckbxHlepLine.setOpaque(false);
		chckbxHlepLine.setFocusable(false);
		chckbxHlepLine.setBounds(80, 90, 77, 23);
		getContentPane().add(chckbxHlepLine);
		JLabel label = new JLabel("����");
		label.setFont(new Font("��Բ", Font.PLAIN, 12));
		label.setForeground(MainFrame.FontColor);
		label.setBounds(328, 13, 30, 15);
		getContentPane().add(label);
		chckbxShowNext = new JCheckBox("����Ԥ��");
		chckbxShowNext.setToolTipText("��ʾ��һ���������״");
		chckbxShowNext.setFont(new Font("��Բ", Font.PLAIN, 12));
		chckbxShowNext.setForeground(MainFrame.FontColor);
		chckbxShowNext.setOpaque(false);
		chckbxShowNext.setSelected(true);
		chckbxShowNext.setFocusable(false);
		chckbxShowNext.setBounds(80, 130, 79, 23);
		getContentPane().add(chckbxShowNext);
		chckbxAutoLevel = new JCheckBox("�Զ�����ģʽ");
		chckbxAutoLevel.setToolTipText("���������������ٶ��Զ����Ӻͼӿ�");
		chckbxAutoLevel.setFont(new Font("��Բ", Font.PLAIN, 12));
		chckbxAutoLevel.setForeground(MainFrame.FontColor);
		chckbxAutoLevel.setOpaque(false);
		chckbxAutoLevel.setFocusable(false);
		chckbxAutoLevel.setBounds(180, 130, 103, 23);
		getContentPane().add(chckbxAutoLevel);
		chckbxChangeNext = new JCheckBox("��������");
		chckbxChangeNext.setToolTipText("���������һ������");
		chckbxChangeNext.setFont(new Font("��Բ", Font.PLAIN, 12));
		chckbxChangeNext.setForeground(MainFrame.FontColor);
		chckbxChangeNext.setFocusable(false);
		chckbxChangeNext.setOpaque(false);
		chckbxChangeNext.setBounds(80, 166, 100, 23);
		getContentPane().add(chckbxChangeNext);
		chckbxCtrlSpeed = new JCheckBox("���������ٶ�");
		chckbxCtrlSpeed.setToolTipText("��ģʽ�Զ������·��������ٶȵĿ���");
		chckbxCtrlSpeed.setFont(new Font("��Բ", Font.PLAIN, 12));
		chckbxCtrlSpeed.setForeground(MainFrame.FontColor);
		chckbxCtrlSpeed.setFocusable(false);
		chckbxCtrlSpeed.setOpaque(false);
		chckbxCtrlSpeed.setBounds(80, 202, 103, 23);
		getContentPane().add(chckbxCtrlSpeed);
		chckbxBoom = new JCheckBox("��Ϸը��");
		chckbxBoom.setToolTipText("��Ϸ���������ը��");
		chckbxBoom.setFont(new Font("��Բ", Font.PLAIN, 12));
		chckbxBoom.setForeground(MainFrame.FontColor);
		chckbxBoom.setOpaque(false);
		chckbxBoom.setFocusable(false);
		chckbxBoom.setBounds(180, 90, 103, 23);
		getContentPane().add(chckbxBoom);
		spinnerAutoUpY = new JSpinner();
		spinnerAutoUpY.setFont(new Font("��Բ", Font.PLAIN, 12));
		spinnerAutoUpY.setOpaque(false);
		spinnerAutoUpY.setToolTipText("����Ҫ�Զ����ǵ�����");
		spinnerAutoUpY.setFocusable(false);
		spinnerAutoUpY.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spinnerAutoUpY.setEditor(new JSpinner.NumberEditor(spinnerAutoUpY, "0"));
		JFormattedTextField textField1 = ((JSpinner.NumberEditor)spinnerAutoUpY.getEditor()).getTextField();
        textField1.setEditable(false);//��ֹ�������빦��
		spinnerAutoUpY.setBounds(285, 166, 35, 22);
		getContentPane().add(spinnerAutoUpY);
		JLabel lblNewLabel_2 = new JLabel("��");
		lblNewLabel_2.setFont(new Font("��Բ", Font.PLAIN, 12));
		lblNewLabel_2.setForeground(MainFrame.FontColor);
		lblNewLabel_2.setBounds(330, 170, 30, 15);
		getContentPane().add(lblNewLabel_2);
		chckbxRandomOpen = new JCheckBox("������ַ���");
		chckbxRandomOpen.setFont(new Font("��Բ", Font.PLAIN, 12));
		chckbxRandomOpen.setForeground(MainFrame.FontColor);
		chckbxRandomOpen.setToolTipText("��������������ַ���");
		chckbxRandomOpen.setOpaque(false);
		chckbxRandomOpen.setFocusable(false);
		chckbxRandomOpen.setBounds(280, 89, 103, 23);
		getContentPane().add(chckbxRandomOpen);
		spinnerRandomTime = new JSpinner();
		spinnerRandomTime.setFont(new Font("��Բ", Font.PLAIN, 12));
		spinnerRandomTime.setForeground(MainFrame.FontColor);
		spinnerRandomTime.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spinnerRandomTime.setEditor(new JSpinner.NumberEditor(spinnerRandomTime, "0"));
		JFormattedTextField textField2 = ((JSpinner.NumberEditor)spinnerRandomTime.getEditor()).getTextField();
        textField2.setEditable(false);//��ֹ�������빦��
		spinnerRandomTime.setBounds(375, 90, 35, 22);
		getContentPane().add(spinnerRandomTime);
		JLabel lblNewLabel_3 = new JLabel("��");
		lblNewLabel_3.setFont(new Font("��Բ", Font.PLAIN, 12));
		lblNewLabel_3.setForeground(MainFrame.FontColor);
		lblNewLabel_3.setBounds(415, 93, 26, 15);
		getContentPane().add(lblNewLabel_3);
		JLabel lblFunction = new JLabel("��������");
		lblFunction.setForeground(MainFrame.FontColor);
		lblFunction.setFont(new Font("��Բ", Font.PLAIN, 12));
		lblFunction.setBounds(10, 93, 54, 15);
		getContentPane().add(lblFunction);
		spinnerPanelCol =new JSpinner();
		spinnerPanelCol.setModel(new SpinnerNumberModel(15, 15, 24, 1)); 
		spinnerPanelCol.setEditor(new JSpinner.NumberEditor(spinnerPanelCol, "0"));
		JFormattedTextField textField3 = ((JSpinner.NumberEditor)spinnerPanelCol.getEditor()).getTextField();
        textField3.setEditable(false);//��ֹ�������빦��
		spinnerPanelCol.setBounds(375, 130, 35, 22);
		setPane.add(spinnerPanelCol); 
		JLabel lblNewLabel_5 = new JLabel("��");
		lblNewLabel_5.setForeground(MainFrame.FontColor);
		lblNewLabel_5.setFont(new Font("��Բ", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(415, 134, 19, 15);
		setPane.add(lblNewLabel_5);
		checkBoxChangeCol = new JCheckBox("��Ϸ�����ȣ�");
		checkBoxChangeCol.setToolTipText("�޸ķ�������������������޸���ɺ���Ϸ�����¿�ʼ");
		checkBoxChangeCol.setOpaque(false);
		checkBoxChangeCol.setForeground(MainFrame.FontColor);
		checkBoxChangeCol.setFont(new Font("��Բ", Font.PLAIN, 12));
		checkBoxChangeCol.setFocusable(false);
		checkBoxChangeCol.setBounds(280, 130, 130, 23);
		setPane.add(checkBoxChangeCol);
		JLabel lblNewLabel = new JLabel("�������⣺");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("��Բ", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 243, 71, 15);
		setPane.add(lblNewLabel);
		ButtonGroup bGroup1=new ButtonGroup();
		rdbtnStyle1 = new JRadioButton("����һ");
		rdbtnStyle1.setFont(new Font("��Բ", Font.PLAIN, 12));
		rdbtnStyle1.setForeground(MainFrame.FontColor);
		rdbtnStyle1.setOpaque(false);
		rdbtnStyle1.setSelected(true);
		rdbtnStyle1.setFocusable(false);
		rdbtnStyle1.setBounds(80, 238, 93, 23);
		setPane.add(rdbtnStyle1);
		rdbtnStyle2 = new JRadioButton("�����");
		rdbtnStyle2.setFont(new Font("��Բ", Font.PLAIN, 12));
		rdbtnStyle2.setForeground(MainFrame.FontColor);
		rdbtnStyle2.setOpaque(false);
		rdbtnStyle2.setFocusable(false);
		rdbtnStyle1.setFocusable(false);
		rdbtnStyle2.setBounds(180, 237, 71, 23);
		setPane.add(rdbtnStyle2);
		rdbtnStyle3 = new JRadioButton("������");
		rdbtnStyle3.setForeground(MainFrame.FontColor);
		rdbtnStyle3.setFont(new Font("��Բ", Font.PLAIN, 12));
		rdbtnStyle3.setOpaque(false);
		rdbtnStyle3.setFocusable(false);
		rdbtnStyle3.setBounds(280, 236, 121, 23);
		setPane.add(rdbtnStyle3);
		bGroup1.add(rdbtnStyle1);
		bGroup1.add(rdbtnStyle2);
		bGroup1.add(rdbtnStyle3);
	}
	/**
	 * ���ñ�ǩ��ʾ������ֵ
	 * @param looptime Ҫ��ʾ�Ķ�ʱ��ִ������
	 */
	public void showLoopTime(int looptime){
		labelShowSpeed.setText(Integer.toString(looptime));
	}
}
