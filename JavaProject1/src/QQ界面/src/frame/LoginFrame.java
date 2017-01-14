package QQ界面.src.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
/**
 * 登录界面类
 * @author MacBook
 *
 */

public class LoginFrame extends JFrame{
	//logo区控件
	private JPanel logoPanel;
	//页面控件
	private JLabel loginlabel = null;
	private JLabel passwordlabel = null;
	private JTextField logintext = null;
	private JPasswordField passwordtext = null;
	private JLabel findpassword = null;
	private JButton loginbtn = null;
	private JButton registerbtn = null;
	
	private JRadioButton rememberPsw = null;
	private JRadioButton autoLogin = null;
	//背景面板
	private BackgroundPanel bgp;
	public LoginFrame(){
		//设置默认窗体属性
		this.setTitle("EQ聊天工具登录界面");
		this.setSize(400,300);
		this.setDefaultCloseOperation(3);
		this.setLayout(null);
		this.setLocation(400,300);
		//添加背景
		ImageIcon img = new ImageIcon("./src/QQ界面/res/0.jpg");
        bgp=new BackgroundPanel(img.getImage());  
        bgp.setBounds(0,0,400,300); 
        bgp.setLayout(null);
        //logo面板
        
        //中心面板
        loginlabel = new JLabel("用户名：");
        loginlabel.setBounds(20, 40, 60, 25);
        passwordlabel = new JLabel("密码：");
        passwordlabel.setBounds(20, 80, 60, 25);
        logintext = new JTextField(15);
        logintext.setBounds(80, 40, 180, 25);
        passwordtext = new JPasswordField(15);
        passwordtext.setBounds(80, 80, 180, 25);
        findpassword = new JLabel("找回密码");
        findpassword.setBounds(270, 80, 180, 25);
        loginbtn = new JButton("登录");
        loginbtn.setBounds(75, 140, 100, 30);
        registerbtn = new JButton("注册");
        registerbtn.setBounds(200, 140, 100, 30);
        rememberPsw = new JRadioButton("记住密码");
        rememberPsw.setFont(new Font("Arial",Font.PLAIN,12));
        rememberPsw.setBounds(90, 115, 80, 20);
        autoLogin = new JRadioButton("自动登录");
        autoLogin.setFont(new Font("Arial",Font.PLAIN,12));
        autoLogin.setBounds(190, 115, 80, 20);
        bgp.add(loginlabel);
        bgp.add(logintext);
        bgp.add(passwordlabel);
        bgp.add(passwordtext);
        bgp.add(findpassword);
        bgp.add(loginbtn);
        bgp.add(registerbtn);
        bgp.add(rememberPsw);
        bgp.add(autoLogin);
        
        this.add(bgp);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		LoginFrame lg = new LoginFrame();
		
	}
}
//背景面板
class BackgroundPanel extends JPanel  
{  
    Image im; 
    public BackgroundPanel(Image im)  
    {  
        this.im = im;
        this.setOpaque(true);  
    }  
    public void paintComponent(Graphics g)  
    {  
        super.paintComponents(g);  
        g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);  
          
    }   
}  