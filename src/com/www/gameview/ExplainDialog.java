package com.www.gameview;

import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JTextArea;
	/**
	 * ��Ϸ˵���Ի�����
	 * @author wWw
	 *
	 */
@SuppressWarnings("serial")
public class ExplainDialog extends JDialog {
	/**@see ��Ϸ˵���ı���*/
	private JTextArea textArea;
	/**
	 * ��ʼ���Ի����е����
	 */
	public ExplainDialog() {
		setTitle("��Ϸ˵��");
		setSize(450, 400);
		setVisible(false);
		setModal(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage("image/question.png"));
		BackgroupPanel explainPanel=new BackgroupPanel();
		explainPanel.setLayout(new BorderLayout());
		setContentPane(explainPanel);
		textArea= new JTextArea();
		textArea.setOpaque(false);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("��Բ", Font.PLAIN, 14));
		textArea.setForeground(MainFrame.FontColor);
		textArea.append("��Ϸ����ָ�ϣ�\n"
				+ "1�����ԴӲ˵����ġ���Ϸ����ѡ��/˫����Ϸ��ʼ����Ϸģʽ����һ��ʼ���Զ�����Ϸ������ѡ��ʼ��Ϸ����ǰΪ������Ϸ����������Ϸ�������Զ�����Ϸ������ٿ�ʼ��Ϸ�����Ǹ��ݵ�ǰ����Ϸģʽ��ʼ�µ���Ϸ��\n"
				+ "2����/˫����Ϸ����ģʽ���������7�ֻ������飬������������ʱ��Ϊ500ms��\n"
				+ "3����/˫����Ϸ�м�ģʽ���������7�ֻ�������+���η��飬������������ʱ��Ϊ300ms��\n"
				+ "4����/˫����Ϸ�߼�ģʽ���������7�ֻ�������+���η���+ʮ���η��飬������������ʱ��Ϊ100ms��\n"
				+ "5������ÿ����һ�з�����10�֣�����ը��ʱ����ը�������к��в���20�֡�\n"
				+ "6�������ߣ�������������������ߣ�������Ϸ�����ƶ���\n"
				+ "7����Ϸը����ѡ�к�����Ϸ�н��������ը����ը��������ը�������к��в���20�֡�\n"
				+ "8��������ַ�������������鵽��ײ�ʱ���ڷ�����������ĵײ�10�з�����������ַ��顣"
				+ "9������Ԥ�����Ƿ���ʾ��ʾ��һ�����顣\n"
				+ "10���Զ�����ģʽ�����ݵ�ǰ��Ϸ�����Ӷ�Ӧ�ĵȼ����𣬹��ĸ��ȼ����ֱ�Ϊ��������0-200�����м���200-400�����߼���400-600������̬��>600����ÿ���ȼ�����ÿ����200�ֽ�������һ���ȼ�����̬�ȼ���������͸߼�һ���������ٶ�Ϊ50ms��\n"
				+ "11����Ϸ�����ȸ������ı䷽���������������������ʼ�µ���Ϸ��ֻ�е�����Ϸ�ſ����޸Ŀ�ȣ����Ϊ24��˫����Ϸ�̶�Ϊ25��\n"
				+ "12���������飺����Ԥ��������ʾ�ķ��顣\n"
				+ "13�������Զ����������������鵽��ײ�ʱ���ڷ��������������һ����������ַ��飬�������Ϊ���������������\n"
				+ "14�����������ٶȣ����Ʒ�������������ٶȣ����Լӿ�/�����ٶȡ�\n"
				+ "15���������⣺ѡ����Ϸ���н���ı���ͼƬ��\n"
				+ "16����������ѡ�����������ģʽ���䡣\n"
				+ "17���Զ�����Ϸ��ѡ����˼������ʾ��\n"
				+ "18������ע����Ҳ����ϴ���Ϸ�����������\n"
				+ "19�����ϵ������ڵ�/˫����Ϸ�нԿ����á�\n"
				+ "20����Ϸ�������ⱳ�����Դ��Զ���Ի�����ѡ�񣬻�������Լ���Ҫ��ͼƬ��image�ļ��У�����style1.jpg��style2.jpg��style3.jpgͼƬ���ٴ��Զ�����ѡ�������⡣\n"
				+ "21����Ϸ����İ�ť�迪ʼ��Ϸ�������ʾ��");
		JScrollPane textAreaScrollPane=new JScrollPane(textArea);
		textAreaScrollPane.setOpaque(false);
		textAreaScrollPane.getViewport().setOpaque(false);
		getContentPane().add(textAreaScrollPane, BorderLayout.CENTER);
	}
}
