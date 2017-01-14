package 程序员面试金典;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Unit1 {

	//题目1.1---o(n2)
	public boolean StringSearch1(String s){
		boolean same=false;
		char[] chSet=new char[s.length()];
		s.getChars(0, s.length(), chSet, 0);
		for(int i=0;i<chSet.length;i++)
		{
			boolean bSignal=false;
			for(int j=0;j<chSet.length;j++)
			{
				if(j!=i)
					if(chSet[i]==chSet[j])
					{
						same=true;
						bSignal=true;
						break;
					}
				
			}
			if(bSignal)
				break;
		}
		
		return same;
	}
	//题目1.1 map o(n)
	public boolean StringSearch2(String s)
	{
		boolean same=false;
		Map<Character, Boolean> map=new HashMap<Character, Boolean>();
		for(int i=0;i<s.length();i++)
		{
			if(map.get(s.charAt(i))==null)
				map.put(s.charAt(i), true);
			else
			{
				same=true;
				break;
			}
		}
		
		return same;
	}
	//题目1.1 自建数组map映射--特殊字符除外
	//A-Z 65-90 a-z 97-122
	public boolean StringSearch3(String s)
	{
		boolean same=false;
		byte[] map =new byte[52];
		for(int i=0;i<map.length;i++)
			map[i]=0;
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);
			int code=(int)c;
			if(code<=90 && code>=65)
			{
				if(map[code-65]==1)
				{
					same=true;
					break;
				}else
					map[code-65]=1;
			}else if(code >=97 && code <=122)
			{
				if(map[code-97+26]==1){
					same=true;
					break;
				}else
					map[code-97+26]=1;
			}
			
		}
		return same;
	}
	//题目1.2 利用系统api反转
	public String StringReserve1(String s) throws UnsupportedEncodingException
	{
		int length=s.length();
		byte[] b1=s.getBytes();
		byte[] b2=new byte[length];
		for(int i=0;i<length;i++){
			b2[i]=b1[length-i-1];
			
		}
		String reS=new String(b2,"utf-8");
		return reS;
	}
	//重排字符串 --无论如何重排 字符串各元素相加是定值
	public boolean reSort(String s1,String s2){
		boolean enable=false;
		int s1Count=0;
		int s2Count=0;
		if(s1.length()!=s2.length())
			return enable;
		else{
			for(int i=0;i<s1.length();i++)
			{
				s1Count+=(int)s1.charAt(i);
				s2Count+=(int)s2.charAt(i);
				
			}
			if(s1Count==s2Count)
				enable=true;
				
		}
		
		return enable;
	}
	//替换字符串中的空格--空格编码 32
	public String replace(String s){
		String reS="";
		StringBuffer sbuild=new StringBuffer();
		int i=0;
		while(i<s.length()){
			char c=s.charAt(i);
			if(c!=' ')
				sbuild.append(c);
			else{
				sbuild.append("%20");
			}
			i++;
		}

		reS=sbuild.toString();
		
		return reS;
	}
	//题目1.5 压缩字符串
	public String presure(String s){
		String respon="";

		char mark=s.charAt(0);
		int count=1;
		int len=s.length();
		int i=1;
		while(i!=len-1){
			if(s.charAt(i)==mark)
				count++;
			else {
				StringBuilder sbuild=new StringBuilder();
				sbuild.append(respon);
				if(count>=2){										
					sbuild.append(mark+""+count);
				}
				else{
					sbuild.append(mark);
				}
				respon=sbuild.toString().trim();
				mark=s.charAt(i);
				count=1;
			}
			i++;
			if (i == (len - 1)) {
				System.out.println("执行了");
				boolean isEnd = false;
				if (s.charAt(i) == mark) {
					count++;
					isEnd = true;
				}

				StringBuilder sbuild = new StringBuilder();
				sbuild.append(respon);
				if (count >= 2) {
					sbuild.append(mark + "" + count);
				} else {
					sbuild.append(mark);
				}
				respon = sbuild.toString().trim();
				if (!isEnd) {
					respon += s.charAt(i);
				}

			}
			
			System.out.println(i+" "+s.charAt(i));
		}
		if(respon.length()>=s.length())
			respon=s;
		return respon;
	}
	//题目6 翻转图像
	public void rotate(int [][] matrix,int n){
		for(int layer=0;layer<n/2;layer++){
			int start=layer;
			int end=n-1-layer;
			for(int i=start;i<end;i++){
				int offset=i-start;
				int top=matrix[start][i];
				
				matrix[start][i]=matrix[end-offset][start];
				matrix[end-offset][start]=matrix[end][end-offset];
				matrix[end][end-offset]=matrix[i][end];
				matrix[i][end]=top;
				
				
			}			
		}		
	}
	//题目7 清0行列
	public void transTozero(int matrix[][]){
		ArrayList<point> al=new ArrayList<point>();
		for(int i=0;i<matrix.length;i++)
			for(int j=0;j<matrix[i].length;j++)
				if(matrix[i][j]==0)
					al.add(new point(i,j));
		for(int i=0;i<al.size();i++){
			point p=al.get(i);
			for(int j=0;j<matrix.length;j++){
				matrix[j][p.getY()]=0;
			}
			for(int j=0;j<matrix[p.getX()].length;j++){
				matrix[p.getX()][j]=0;
			}
		}
	}
	//主函数
	public static void main(String[] args) {
		Unit1 u1=new Unit1();
		int matrix[][]=
			{{1,2,3,4}
			,{5,6,7,8}
			,{9,10,11,12}
			,{13,14,15,16}};
		for(int[] a:matrix)
		{
			for(int c:a)
				System.out.print(c+" ");	
			System.out.println();
		}
		u1.transTozero(matrix);
		for(int[] a:matrix)
		{
			for(int c:a)
				System.out.print(c+" ");	
			System.out.println();
		}
	}
	
	//题目1测试
	public void Test1()
	{
		Unit1 u1=new Unit1();
		String toCheck="Hello";
		boolean t=u1.StringSearch3(toCheck);
		System.out.println("has the same character? "+t);
	}
	//题目二测试
	public void Test2(){
		Unit1 u2=new Unit1();
		String toCheck="Hello";
		try {
			System.out.println(u2.StringReserve1(toCheck));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}

}
class point{
	int x;
	int y;
	public point(int x,int y){
		this.x=x;
		this.y=y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
}