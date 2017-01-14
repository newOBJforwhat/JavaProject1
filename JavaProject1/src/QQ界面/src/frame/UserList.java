package QQ界面.src.frame;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * 聊天用户列表
 * @author MacBook
 *
 */
public class UserList extends JFrame implements MouseListener{
	private JLabel list = null;
	private int listLen = 0;
	private JPanel userPanel = null;
	private JScrollPane jsp1 = null;
	
	private JLabel room = null;
	private JPanel roomList = null;
	private JScrollPane jsp2 = null;
	private int roomLen = 0;
	public UserList(int listLen,int roomLen ){
		this.listLen = listLen;
		this.roomLen = roomLen;
		this.setSize(250,550);
		this.setLayout(null);
		this.setDefaultCloseOperation(3);
		
		list = new JLabel("在线用户列表");
		list.setBounds(80, 10, 100, 30);
		userPanel = new JPanel();
		//userPanel.setBounds(40, 40, 150, 270);
		userPanel.setBackground(Color.white);
		userPanel.setLayout(new GridLayout(listLen, 1,4,4));
		for(int i=0;i<5;i++)
		{
			JLabel j = new JLabel(i+"",new ImageIcon("src/QQ界面/res/boy.png"),JLabel.LEFT);
			userPanel.add(j);
			j.addMouseListener(this);
		}
		jsp1 = new JScrollPane(userPanel);
		jsp1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jsp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jsp1.setBounds(40, 40, 150, 270);
		
		room = new JLabel("聊天室");
		room.setBounds(90, 310, 100, 20);
		roomList = new JPanel();
		roomList.setLayout(new GridLayout(roomLen, 1));
		roomList.setBackground(Color.white);
		jsp2 = new JScrollPane(roomList);
		jsp2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jsp2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jsp2.setBounds(40, 335, 150, 150);
		this.add(list);
		this.add(jsp1);
		this.add(room);
		this.add(jsp2);
		this.setVisible(true);
	} 
	public static void main(String[] args) {
		new UserList(30,5);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel jl = (JLabel)e.getSource();
		jl.setForeground(Color.red);
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel jl = (JLabel)e.getSource();
		jl.setForeground(Color.BLACK);
	}
}
