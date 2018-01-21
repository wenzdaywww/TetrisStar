package com.www.gamemodel;

import java.io.File;
import java.applet.Applet;
import java.applet.AudioClip;
import javax.swing.JOptionPane;
import java.net.MalformedURLException;
	/**
	 * ��Ƶ������
	 * @author wWw
	 *
	 */
public class SoundModel{
	/**@see ը����Ƶ����*/
	public AudioClip bombSound;		
	/**@see ��ת��Ƶ����*/
	public AudioClip rotateSound;	
	/**@see ��ť��Ƶ����*/
	public AudioClip buttonSound;	
	/**@see ��Ϸ������Ƶ����*/
	public AudioClip gameOverSound;	
	/**@see ���鵽����Ƶ����*/
	public AudioClip cantMoveSound;	
	/**@see �������ֶ���*/
	public AudioClip backgroupMusic;	
	/**@see ����������Ƶ����*/
	public AudioClip blockDisappearSound;	
	/**
	 * ����������Ƶ����
	 */
	public SoundModel() {
		bombSound();
		rotateSound();
		buttonSound();
		cantMoveSound();
		backgroupMusic();
		gameOverSounds();
		blockDisappearSound();
	}
	/**
	 * ��������
	 */
	private void backgroupMusic() {
		try {
			File stepUrl=new File("sounds/backgroupmusic.wav");
			backgroupMusic=Applet.newAudioClip(stepUrl.toURI().toURL());	//�Ӹ��� URL ����ȡ��Ƶ������
		} catch (MalformedURLException e) {
			JOptionPane.showConfirmDialog(null, "�Ҳ���step.wav", "��ʾ", JOptionPane.CLOSED_OPTION);
		}
	}
	/**
	 * ���鵽��ײ���Ч
	 */
	private void cantMoveSound() {
		try {
			File stepUrl=new File("sounds/cantmove.wav");
			cantMoveSound=Applet.newAudioClip(stepUrl.toURI().toURL());	//�Ӹ��� URL ����ȡ��Ƶ������
		} catch (MalformedURLException e) {
			JOptionPane.showConfirmDialog(null, "�Ҳ���backgroupmusic.wav", "��ʾ", JOptionPane.CLOSED_OPTION);
		}
	}
	/**
	 * ����������Ч
	 */
	private void blockDisappearSound() {
		try {
			File stepUrl=new File("sounds/blockdisappear.wav");
			blockDisappearSound=Applet.newAudioClip(stepUrl.toURI().toURL());	//�Ӹ��� URL ����ȡ��Ƶ������
		} catch (MalformedURLException e) {
			JOptionPane.showConfirmDialog(null, "blockdisappear.wav", "��ʾ", JOptionPane.CLOSED_OPTION);
		}
	}
	/**
	 * ������ת��Ч
	 */
	private void rotateSound() {
		try {
			File stepUrl=new File("sounds/rotate.wav");
			rotateSound=Applet.newAudioClip(stepUrl.toURI().toURL());	//�Ӹ��� URL ����ȡ��Ƶ������
		} catch (MalformedURLException e) {
			JOptionPane.showConfirmDialog(null, "�Ҳ���rotate.wav", "��ʾ", JOptionPane.CLOSED_OPTION);
		}
	}
	/**
	 * ��Ϸ������Ч
	 */
	private void gameOverSounds() {
		try {
			File stepUrl=new File("sounds/ko.wav");
			gameOverSound=Applet.newAudioClip(stepUrl.toURI().toURL());	//�Ӹ��� URL ����ȡ��Ƶ������
		} catch (MalformedURLException e) {
			JOptionPane.showConfirmDialog(null, "�Ҳ���ko.wav", "��ʾ", JOptionPane.CLOSED_OPTION);
		}
	}
	/**
	 * �����밴ť��Ч
	 */
	private void buttonSound() {
		try {
			File stepUrl=new File("sounds/button.wav");
			buttonSound=Applet.newAudioClip(stepUrl.toURI().toURL());	//�Ӹ��� URL ����ȡ��Ƶ������
		} catch (MalformedURLException e) {
			JOptionPane.showConfirmDialog(null, "�Ҳ���button.wav", "��ʾ", JOptionPane.CLOSED_OPTION);
		}
	}
	/**
	 * ը����Ч
	 */
	private void bombSound() {
		try {
			File stepUrl=new File("sounds/bomb.wav");
			bombSound=Applet.newAudioClip(stepUrl.toURI().toURL());	//�Ӹ��� URL ����ȡ��Ƶ������
		} catch (MalformedURLException e) {
			JOptionPane.showConfirmDialog(null, "�Ҳ���bomb.wav", "��ʾ", JOptionPane.CLOSED_OPTION);
		}
	}
}
