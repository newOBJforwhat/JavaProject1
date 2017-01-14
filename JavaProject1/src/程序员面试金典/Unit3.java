package 程序员面试金典;

/**
 * 第三章
 */
public class Unit3 {

	public static void main(String[] args) {
		int i = 1;
		while((i&9) != 9){
			System.out.println(i);
			i++;
		}
		
		
	}

}

// 第一题 一个数组三个栈，返回最小值O(1)
class stackMyself {
	private int[] data = new int[30];
	private int stack1 = 0;
	private int stack2 = 10;
	private int stack3 = 20;
	private int minStack1 = 0;

	public stackMyself() {

	}

	// 栈1--
	public int getMin() {
		return minStack1;
	}

	public void pushStack1(int d) {
		if (stack1 < 10) {
			if (stack1 == 0)
				minStack1 = d;
			else {
				if (d < minStack1)
					minStack1 = d;
			}
			data[stack1++] = d;
		} else {
			System.err.println("栈1满了");
		}
	}

	public int popStack1() {
		if (stack1 >= 0)
			return data[--stack1];
		else
			return -1;
	}

	public int getStack1Top() {
		int t = stack1 - 1;
		return data[t];
	}

	// 栈2
	public void pushStack2(int d) {
		if (stack2 < 20)
			data[stack2++] = d;
		else {
			System.err.println("栈2满了");
		}
	}

	public int popStack2() {
		if (stack2 >= 10)
			return data[--stack2];
		else
			return -1;
	}

	public int getStack2Top() {
		int t = stack2 - 1;
		return data[t];
	}

	// 栈3
	public void pushStack3(int d) {
		if (stack3 < 30)
			data[stack3++] = d;
		else {
			System.err.println("栈3满了");
		}
	}

	public int popStack3() {
		if (stack3 >= 20)
			return data[--stack3];
		else
			return -1;
	}

	public int getStack3Top() {
		int t = stack3 - 1;
		return data[t];
	}

}

// 链式栈
class SetOfStack {
	private stackNode first;
	private stackNode current;

	public SetOfStack() {
		first = new stackNode();
		first.setNext(null);
		current = first;
	}

	// 入栈
	public void insertValue(int d) {
		stackNode runner = first;
		while (runner.getNext() != null)
			runner = runner.getNext();
		if (runner.getTop() != runner.getSize() - 1)
			runner.push(d);
		else {
			stackNode newnode = new stackNode();
			runner.setNext(newnode);
			runner = newnode;
			runner.push(d);
			current = runner;
		}
	}

	// 出栈
	public int pop() {
		if (current.getTop() == -1) {
			stackNode runner = first;
			while (runner.getNext() != current)
				runner = runner.getNext();
			current = runner;
			current.setNext(null);
		}
		return current.pop();
	}

	// 打印
	public void printStack() {
		stackNode runner = first;
		while (runner != null) {
			runner.printStack();
			runner = runner.getNext();
		}
	}
}

class stackNode {
	private stackNode next;
	private int[] data;
	private int size = 10;
	private int top = -1;

	public stackNode() {
		data = new int[size];
	}

	public stackNode getNext() {
		return next;
	}

	public int getTop() {
		return top;
	}

	public int getSize() {
		return size;
	}

	public void setNext(stackNode next) {
		this.next = next;
	}

	// 入栈
	public void push(int d) {
		if (top != size - 1)
			data[++top] = d;
		else
			System.err.println("此栈已满");
	}

	// 出栈
	public int pop() {
		if (top != -1)
			return data[top--];
		else
			return -1;
	}

	// 打印栈
	public void printStack() {
		for (int i = 0; i <= top; i++)
			System.out.print(data[i] + " ");
		System.out.println();
	}
}

// 汉诺塔栈
class hanioStack {
	private stackNode Astack;
	private stackNode Bstack;
	private stackNode Cstack;

	public hanioStack() {
		Astack = new stackNode();
		Bstack = new stackNode();
		Cstack = new stackNode();
	}

	public void initA(int[] data) {
		for (int i = 0; i < data.length; i++)
			Astack.push(data[i]);
	}

	public void MoveTo(char A, char C) {
		if (A == 'A' && C == 'C') {
			int data = Astack.pop();
			Cstack.push(data);
		} else if (A == 'A' && C == 'B') {
			int data = Astack.pop();
			Bstack.push(data);
		} else if (A == 'B' && C == 'C') {
			int data = Bstack.pop();
			Cstack.push(data);
		} else if (A == 'B' && C == 'A') {
			int data = Bstack.pop();
			Astack.push(data);
		} else if (A == 'C' && C == 'A') {
			int data = Cstack.pop();
			Astack.push(data);
		} else if (A == 'C' && C == 'B') {
			int data = Cstack.pop();
			Bstack.push(data);
		}
		printStack();
	}

	public void HanioTower(int n, char A, char B, char C) {
		
		if (n == 1)
			MoveTo(A, C);
		else {
			HanioTower(n - 1, A, C, B);
			MoveTo(A, C);
			HanioTower(n - 1, B, A, C);
		}

	}

	public void printStack() {
		System.out.print("A:");
		Astack.printStack();
		System.out.print("B:");
		Bstack.printStack();
		System.out.print("C:");
		Cstack.printStack();
	}
}
class MyQueue{
	private stackNode stack1;
	private stackNode stack2;
	public void inQueue(int data){
		while(stack2.getTop() != -1)
		{
			int d = stack2.pop();
			stack1.push(d);
		}
		stack1.push(data);
	}
	public int outQueue(){
		while(stack1.getTop() != -1)
		{
			int d = stack1.pop();
			stack2.push(d);
		}
		return stack1.pop();
	}
}