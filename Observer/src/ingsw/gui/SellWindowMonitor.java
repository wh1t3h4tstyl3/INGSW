package ingsw.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;

import ingsw.observer.Observer;
import ingsw.observer.Subject;
import ingsw.state.DispatchManager;

public class SellWindowMonitor extends JFrame implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DispatchManager dispatch;
	private JLabel animation;
	private JLabel label;
	public SellWindowMonitor(DispatchManager dispatch) {
		this.dispatch = dispatch;
		this.dispatch.subscribeObserver(this);
		initWindow();
	}
	
	private void initWindow() {
		setResizable(false);
		setTitle("Products Selled");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		label = new JLabel(dispatch.getStateName());
		if(Toolkit.getDefaultToolkit().getScreenSize().width < 1025)
			label.setFont(new Font("Consolas", Font.PLAIN, 35));
		else
			label.setFont(new Font("Consolas", Font.PLAIN, 75));
		animation = label;
		add(animation);
	}

	@Override
	public void update(Subject subject) {
		if (subject == dispatch) {
			java.util.Timer t = new java.util.Timer();
			Point p  = this.getLocation();
			Dimension d  = this.getSize();
			
			animation = new JLabel(dispatch.getIcon());
			getContentPane().removeAll();
			getContentPane().add(animation);
			
			setExtendedState(MAXIMIZED_BOTH);
			
			t.schedule(new TimerTask() {
				@Override
				public void run() {
					setVisible(false);
					setSize(d);
					setLocation(p);
					label.setText(dispatch.getStateName());
					animation = label;
					getContentPane().removeAll();
					getContentPane().add(animation);
					setVisible(true);
				}
			},dispatch.getElaborationTime());			
		}
	}
	
	@Override
	public void setVisible(boolean b) {
		if(!b) dispatch.unSubscribeObserver(this);
		else
			dispatch.subscribeObserver(this);
		super.setVisible(b);
	}
}
