package QQ界面.src.frame;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
/**
 * 聊天界面
 * @author MacBook
 *
 */
import javax.swing.JTextArea;
public class ChatFrame extends JFrame{
	//聊天窗体组件
	private JTextArea msgArea = null;
	private JScrollPane jsp = null;
	private JTextArea sendArea = null;
	private JPanel friendMsg = null;
	private JButton send = null;
	public ChatFrame(){
		//聊天窗体默认属性
		this.setSize(400,550);
		this.setLocation(200, 100);
		this.setDefaultCloseOperation(3);
		this.setResizable(false);
		this.setLayout(null);
		//设置滚动条自动出现
		jsp = new JScrollPane(msgArea);
		jsp.setVerticalScrollBarPolicy(                
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		msgArea = new JTextArea();
		jsp.setBounds(5, 5, 260, 340);
		msgArea.setEnabled(false);
	

		
		sendArea = new JTextArea();
		sendArea.setBounds(5, 380, 260, 100);
		friendMsg = new JPanel();
		friendMsg.setBackground(Color.red);
		friendMsg.setBounds(270, 5, 120, 340);
		send = new JButton("发送信息");
		send.setBounds(5, 480, 120, 30);
		
		this.add(jsp);
		this.add(sendArea);
		this.add(friendMsg);
		this.add(send);
		
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new ChatFrame();
	}
}
