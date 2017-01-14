package 程序员面试金典;

import java.util.ArrayList;
import java.util.HashMap;

public class Unit2 {
	//删除未排序链表重复节点1 缓冲区版
	public void DelRepeated1(LinkedList list){
		HashMap<Integer,Boolean> buffer=new HashMap<Integer,Boolean>();
		Node p=list.getfirst();
		while(p!=null){
			System.out.println("data="+p.getData());
			if(buffer.get(p.getData())==null){
				buffer.put(p.getData(), true);
			}
			else
			{
				list.deleteNode(p);	
				while(true){
					if(buffer.get(p.getData())!=null)
						list.deleteNode(p);
					else
						break;
				}
			}
			
			p=p.getNext();
		}
	}
	//删除未排序俩表重复节点2 无缓冲区
	public void DelRepeated2(LinkedList list) {
		Node p = list.getfirst();
		Node q = list.getfirst().getNext();
		while(p!=null){
			q = p.getNext();
			while(q!=null){
				if(p.getData()==q.getData())
					list.deleteNormal(q);
				q=q.getNext();
			}
				p = p.getNext();

		}
		
	}
	//寻找倒数第k个节点
	public Node findNK(LinkedList list,int k){
		if(k<=0)
		{
			System.out.println("k should be upper than 0");
			return null;
		}
		int n=0;
		Node p=list.getfirst();
		while(p!=null)
		{
			n++;
			p=p.getNext();
		}
		int result=n-k;
		if(n-k<0)
		{
			System.out.println("index out of range");
			return null;
		}
		p=list.getfirst();
		while(result!=0){
			p=p.getNext();
			result--;
		}
		return p;
	}
	//双端链表分割
	public void DivideLink(DoubleLink dl,int element){
		DoubleNode tail=dl.getEnd().getPre();
		DoubleNode first=dl.getFirst();
		first.setData(element);
		int start=1;
		int end=dl.getLength();
		int x=element;
		while(start<end){
			while(start<end && tail.getData()>=x)
			{
				end--;
				tail=tail.getPre();
			}
			if(start<end){
				start++;
				first.setData(tail.getData());
				first=first.getNext();
			}	
			while(start<end && first.getData()<=x)
			{
				start++;
				first=first.getNext();
			}
			if(start<end){
				tail.setData(first.getData());
				end--;
				tail=tail.getPre();

			}
		}
		first.setData(x);
	}
	//链表加法
	public LinkedList ListAdd1(LinkedList list1,LinkedList list2){
		Node current1=list1.getfirst();
		Node current2=list2.getfirst();
		LinkedList result=new LinkedList();
		int carry=0;
		int count;
		result.setfirst(new Node(-1));
		while(current1 != null && current2 != null){
			
			count=carry+current1.getData()+current2.getData();
			carry=count/10;
			count=count%10;
			Node reNode=new Node(count);
			result.addNode(reNode);
			current1=current1.getNext();
			current2=current2.getNext();
		}
		while(current1 != null){
			Node reNode=new Node(current1.getData()+carry);
			result.addNode(reNode);
			current1=current1.getNext();
			carry=0;
		}
		while(current2 != null){
			Node reNode=new Node(current2.getData()+carry);
			result.addNode(reNode);
			current1=current2.getNext();
			carry=0;
		}
		if(carry!=0){
			Node reNode=new Node(carry);
			result.addNode(reNode);
		}
		return result;
	}
	
	public LinkedList ListAdd2(LinkedList list1, LinkedList list2) {
		int number1 = 0;
		int number2 = 0;
		Node f1 = list1.getfirst();
		Node f2 = list2.getfirst();
		LinkedList result = new LinkedList();
		while (f1 != null) {
			number1 = number1 * 10 + f1.getData();
			f1 = f1.getNext();
		}
		while (f2 != null) {
			number2 = number2 * 10 + f2.getData();
			f2 = f2.getNext();
		}
		int count = number1 + number2;
		int rank=1;
		int temp=count;
		while(temp>10)
		{
			temp=temp/10;
			rank=rank*10;
		}
		temp=count;
		while (rank != 0) {
			result.addNode(new Node(temp/rank));
			temp%=rank;
			rank/=10;
		}

		return result;
	}
	//链表查环
	public Node findCircle(LinkedList list){
		HashMap<Node,Boolean> map=new HashMap<Node,Boolean>();
		Node p=list.getfirst();
		while(true){
			if(map.get(p)==null)
				map.put(p, true);
			else
				break;
			System.out.println(p.getData());
			p=p.getNext();
		}
		return p;
	}
	//回文检测
	public <T> boolean LinkedPalindrome(ArrayList<T> list){
		boolean isPalindrome=true;
		ArrayList<T> stack=new ArrayList<T>();
		int i=-1;
		int isEven=list.size()%2;
		int mid=list.size()/2;
		System.out.println("mid="+mid);
		for(int j=0;j<list.size();j++){
			T data=list.get(j);
			if(j<mid)
			{
				stack.add(data);
				i++;
			}
			else {
				if (isEven == 0) {
					if(data==stack.get(i))
						{
							i--;
							continue;
						}else
						{
							isPalindrome=false;
							break;
						}
				}else if(isEven == 1){
					if(j==mid)
						continue;
					else{
						if(data==stack.get(i))
						{
							i--;
							continue;
						}else{
							isPalindrome=false;
							break;
						}
						
					}
						
				}
			}
			System.out.println("j="+data+" i="+stack.get(i));
		}
		
		return isPalindrome;
	}
	//单链表测试
	public void Test1(){
		LinkedList linkedlist=new LinkedList();
		Node n1=new Node(1);
		Node n2=new Node(2);
		Node n3=new Node(3);
		Node n4=new Node(1);
		linkedlist.setfirst(n1);
		linkedlist.addNode(n2);
		linkedlist.addNode(n3);
		linkedlist.addNode(n4);
		for(int i=2;i<=6;i++){
			Node n=new Node(i);
			linkedlist.addNode(n);
		}
		Node nn=new Node(6);
		linkedlist.addNode(nn);
		linkedlist.printList();
		Unit2 u=new Unit2();
		System.out.println(u.findNK(linkedlist, 6).getData());
	}
	//双端链表测试
	public void Test2(){
		DoubleLink dlink=new DoubleLink();
		int data[]={12,23,87,35,9,1,3,53,5,7};
		for(int i=0;i<data.length;i++)
		{
			DoubleNode n=new DoubleNode(data[i]);
			dlink.InsertNode(n);
		}
		dlink.printLink();
		System.out.println(dlink.getLength());
		Unit2 u=new Unit2();
		u.DivideLink(dlink, 9);
		System.out.print(dlink.getFirst().getData()+" ");
		dlink.printLink();
	}
	public static void main(String[] args) {
		String s="aabbaa";
		ArrayList<Character> al=new ArrayList<Character>();
		for(int i=0;i<s.length();i++)
			al.add(s.charAt(i));
		Unit2 u=new Unit2();
		boolean b=u.LinkedPalindrome(al);
		System.out.println(b);
	}

}
class LinkedList{
	private Node first;

	public Node getfirst() {
		return first;
	}

	public void setfirst(Node first) {
		this.first = first;
	}
	//按值搜寻第一个等于目标的节点
	public Node findNode(int target){
		if(first==null){
			System.out.println("initialise the first");
			return null;
		}
		Node p=first;
		while(p.getData()!=target && p!=null)
			p=p.getNext();
		return p;
	}
	public Node findPreNode(Node target){
		if(first==null){
			System.out.println("initialise the first");
			return null;
		}
		Node p=first;
		while(p.getNext()!=target)
			p=p.getNext();
		return p;
	}
	//返回链表下标查找
	public int IndexOfNode(int target){
		int index=1;
		if(first==null){
			System.out.println("initialise the first");
			return -1;
		}
		Node p=first;
		while(p.getData()!=target)
		{
			index++;
			p=p.getNext();
			if(p==null)
			{
				index=-1;
				break;
			}
		}
		return index;
	}
	//在末尾添加节点
	public void addNode(Node add){
		if(first==null){
			first=add;
			add.setNext(null);
			return;
		}
		Node p=first;
		while(p.getNext()!=null)
			p=p.getNext();
		p.setNext(add);
		add.setNext(null);
	}
	//头插法生成链表
	public void headAdd(Node node){
		if(first == null){
			first=node;
			node.setNext(null);
		}else{
			node.setNext(first);
			first=node;
		}
	}
	//删除节点--须指定链表中的节点
	public void deleteNode(Node toDel){
		if(first==null){
			System.out.println("initialise the first");
			return ;
		}
		Node p=toDel.getNext();
		if(p!=null)
		{
			toDel.setNext(p.getNext());		
			toDel.setData(p.getData());
			p.setNext(null);
		}else{
			deleteEndNode(toDel);
		}
	}
	//删除末尾
	public void deleteEndNode(Node toDel){
		Node p=first;
		while(p.getNext()!=toDel && p!=null)
			p=p.getNext();
		
		p.setNext(null);
		
		
	}
	//常规删除
	public void deleteNormal(Node toDel){
		Node p=findPreNode(toDel);
		p.setNext(toDel.getNext());
		toDel.setNext(null);
	}
	//修改一个节点的值
	public void update(Node target,int value){
		if(first==null){
			System.out.println("initialise the first");
			return ;
		}
		target.setData(value);
	}
	public void printList(){
		if(first==null){
			System.out.println("initialise the first");
			return ;
		}
		Node p=first;
		while(p!=null){
			System.out.print(p.getData()+" ");
			p=p.getNext();
		}
		System.out.println();
	}
}
class Node{
	private Node next;
	private int data;
	public Node(){
		
	}
	public Node(int data){	
		this.data=data;
	}
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
}
class DoubleLink{
	DoubleNode first;
	DoubleNode end;
	DoubleNode current;
	int length=0;
	//初始化空双端链表
	public DoubleLink(){
		first=new DoubleNode();
		end=new DoubleNode();
		first.setNext(end);
		end.setNext(first);
		first.setPre(end);
		end.setPre(first);
		current=first;
	}
	public int getLength(){
		return length;
	}
	public DoubleNode getFirst() {
		return first;
	}
	public void setFirst(DoubleNode first) {
		this.first = first;
	}
	public DoubleNode getEnd() {
		return end;
	}
	public void setEnd(DoubleNode end) {
		this.end = end;
	}
	public void InsertNode(DoubleNode node){
		current.setNext(node);
		node.setPre(current);
		current=node;
		end.setPre(node);
		node.setNext(end);
		length++;
	}
	public void RemoveNode(DoubleNode toDel){
		DoubleNode p = toDel.getPre();
		DoubleNode q = toDel.getNext();
		p.setNext(q);
		q.setPre(p);
		toDel.setPre(null);
		toDel.setNext(null);
//		if (toDel != first && toDel != end) {
//			p.setNext(q);
//			q.setPre(p);
//		}else if(toDel == first){
//			first=q;
//			p.setNext(q);
//			q.setPre(p);		
//		}else if(toDel == end){
//			end=p;
//			p.setNext(q);
//			q.setPre(p);
//		}
		length--;
	}
	public void UpdateNode(DoubleNode toUpdate,int data){
		toUpdate.setData(data);
	}
	public DoubleNode SearchNode(int data){
		DoubleNode p=first.getNext();
		while(p.getData()!=data && p!=end)
			p=p.getNext();
		if(p==end)
			p=null;
		return p;
	}
	public int IndexOfNode(DoubleNode search){
		int index=0;
		DoubleNode p=first;			
		while(p!=end && p!=search){
			p=p.getNext();
			index++;
		}
		if(p==end)
			index=-1;
		return index;	
	}
	public void printLink(){
		DoubleNode p=first.getNext();
		while(true){
			if(p==end)
				break;
			System.out.print(p.getData() + " ");
			p = p.getNext();

		}
		System.out.println();
	}
}
class DoubleNode{
	private int data;
	private DoubleNode pre;
	private DoubleNode next;
	public DoubleNode(){
		
	}
	public DoubleNode(int data){
		this.data=data;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}

	public DoubleNode getPre() {
		return pre;
	}
	public void setPre(DoubleNode pre) {
		this.pre = pre;
	}
	public DoubleNode getNext() {
		return next;
	}
	public void setNext(DoubleNode next) {
		this.next = next;
	}
	
}