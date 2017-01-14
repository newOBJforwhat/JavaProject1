package package1;


/*
 * 第三章练习
 */
public class test3 {
	public static void main(String args[]){
		
	}
}
//数组栈
class stack1Impl{
	private Object[] data;
	private int size=10;
	private int top=-1;
	public stack1Impl(){
		data = new Object[size];
	}
	//入栈
	public void push(Object obj){
		if(top!=9)
		{
			data[++top]=obj;
			System.out.println("压栈成功!");
		}else
			System.out.println("栈已满!");
	}
	//出栈
	public Object pop(){
		if(top==-1)
		{
			System.out.println("空栈，无元素出栈!");
			return null;
		}
		Object obj=data[top--];
		return obj;
	}
	//返回栈顶元素
	public Object topElement(){
		return data[top];
	}
	//返回元素容量
	public int getCapacity(){
		return top+1;
	}
	//是否满
	public boolean isFull(){
		return top == (size-1);
	}
	
}
//链式栈
class Node{
	Object data;
	Node next;
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
}
//链式栈
class stack2Impl{
	private Node first;
	private int capacity=0;
	public stack2Impl(){
		first=new Node();
		first.setNext(null);;
	}
	public Node getFirst() {
		return first;
	}
	public int getCapacity() {
		return capacity;
	}
	public void push(Object obj){
		Node n=first.getNext();
		Node p=new Node();
		p.setData(obj);
		first.setNext(p);
		p.setNext(n);
		capacity++;
		System.out.println("入栈成功！");
	}
	public boolean isEmpty(){
		return capacity == 0;
	}
	public Object getTop(){
		return first.getNext().getData();
	}
	public Node pop() {
		Node p=null;
		if (capacity != 0) {
			p = first.getNext();
			first.setNext(p.getNext());
			p.setNext(null);
			System.out.println("出栈成功");
		}
		return p;
	}
	
}
//数组队列
class Queue1{
	private Object data[];
	private int size=10;
	private int capacity=0;
	private int pre=0;
	private int rar=0;
	public Queue1(){
		data = new Object[size];
	}
	//入队
	public void in(Object obj){
		if(capacity == size)
		{
			System.out.println("队列已满!");
			return;
		}else{
			data[rar++]=obj;
			capacity++;
			System.out.println("入队成功！");
		}
	}
	//出队
	public Object out(){
		if(capacity == 0)
		{
			System.out.println("队列已空!");
			return null;
		}else{
			Object obj=data[pre++];
			capacity--;
			return obj;
		}
	}
}