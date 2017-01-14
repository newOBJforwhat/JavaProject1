package tree;



/**
 * 二叉排序树
 * 
 * @author MacBook
 *
 */
public class tree1 {
	private treeNode root;

	public treeNode getRoot() {
		return root;
	}

	public void insertNode(treeNode n) {
		treeNode parent = root;
		treeNode son = root;
		if (root == null) {
			root = n;
			return;
		}
		while (son != null) {
			parent = son;
			if (n.getData() > son.getData())
				son = son.getRight();
			else
				son = son.getLeft();
		}
		if (parent.getData() > n.getData())
			parent.setLeft(n);
		else
			parent.setRight(n);
	}

	// 前序遍历
	public void print1(treeNode n) {
		if (n != null) {
			System.out.println(n.getData());
			print1(n.getLeft());
			print1(n.getRight());

		}
	}

	// 中序遍历
	public void print2(treeNode n) {
		if (n != null) {
			print2(n.getLeft());
			System.out.println(n.getData());
			print2(n.getRight());
		}
	}

	// 后序遍历
	public void print3(treeNode n) {
		if (n != null) {
			print3(n.getLeft());
			print3(n.getRight());
			System.out.println(n.getData());
		}
	}

	// 层序遍历
	public void print4(treeNode n) {
		queue queue = new queue();
		queueNode qNode = new queueNode();
		qNode.setData(n);
		queue.InQueue(qNode);

		while (!queue.isEmtpy()) {
			queueNode node = queue.OutQueue();
			treeNode temp = (treeNode) node.getData();
			System.out.println(temp.getData());
			if (temp.getLeft() != null) {
				queueNode inData = new queueNode();
				inData.setData(temp.getLeft());
				queue.InQueue(inData);
			}
			if (temp.getRight() != null) {
				queueNode inData = new queueNode();
				inData.setData(temp.getRight());
				queue.InQueue(inData);
			}

		}

	}

	// 获得树的深度
	public int getDepth(treeNode n) {
		if (n == null)
			return 0;
		else {
			int left = getDepth(n.getLeft());
			int right = getDepth(n.getRight());
			return (left > right) ? (left + 1) : (right + 1);
		}
	}

	// 转换成双向链表
	public treeNode ConverseToList(treeNode root, treeNode listend) {
		if (root == null)
			return listend;
		treeNode current = root;
		if (current.getLeft() != null)
			listend = ConverseToList(current.getLeft(), listend);
		current.setLeft(listend);
		if (listend != null)
			listend.setRight(current);
		listend = current;
		if (current.getRight() != null)
			listend = ConverseToList(current.getRight(), listend);
		return listend;
	}
	//返回第k层的节点数目
	public int getNumbers(treeNode root,int k){
		if(k == 0 || root == null)
			return 0;
		if(k == 1)
			return 1;
		else{
			int left = getNumbers(root.getLeft(),k-1);
			int right = getNumbers(root.getRight(), k-1);
			return left + right;
		}
		
			
	}
	//返回叶子节点的数目
	public int getSonNumbers(treeNode root){
		if(root == null)
			return 0;
		else if(root.getLeft() == null && root.getRight() == null)
			return 1;
		else{
			int left = getSonNumbers(root.getLeft());
			int right = getSonNumbers(root.getRight());
			return left + right;
		}
	}
	//判断树是否平衡
	public boolean isAVL(treeNode root){
		int left = depth(root.getLeft());
		int right = depth(root.getRight());
		System.out.println("left="+left+" right="+right);
		if(Math.abs(left-right)>1)
			return false;
		else
			return true;
	}
	public int depth(treeNode root){
		if(root == null)
			return 0;
		else{
			int left = depth(root.getLeft());
			int right = depth(root.getRight());
			return (left>right)?(left+1):(right+1);
		}
	}
	//反转二叉树 
	public void reverseTree(treeNode root){
		if(root == null)
			return ;
		treeNode left = root.getLeft();
		treeNode right = root.getRight();
		root.setLeft(right);
		root.setRight(left);
		reverseTree(root.getLeft());
		reverseTree(root.getRight());
	}
	//求两个节点的最早公共父节点
	public treeNode findFather(treeNode root,treeNode n1,treeNode n2){
		treeNode current = root;
		while(true){
			boolean n1Left = findNode(current.getLeft(),n1);
			boolean n1right = findNode(current.getRight(), n1);
			boolean n2Left = findNode(current.getLeft(),n2);
			boolean n2right = findNode(current.getRight(), n2);
			if(n1Left && n2Left)
				current = current.getLeft();
			else if(n1right && n2right)
				current = current.getRight();
			else {
				break;
			}
		}
		return current;
	}
	//寻找节点
	public boolean findNode(treeNode root,treeNode node){
		if(root == node){
			return true;
		}else if(root == null || node == null)
			return false;
		boolean found = findNode(root.getLeft(),node);
		if(!found)
			found = findNode(root.getRight(),node);
		return found;
		
	}
	public static void main(String[] args) {
		tree1 t = new tree1();
		treeNode n1 = new treeNode();
		n1.setData(7);
		treeNode n2 = new treeNode();
		n2.setData(5);
		treeNode n3 = new treeNode();
		n3.setData(9);
		treeNode n4 = new treeNode();
		n4.setData(3);
		treeNode n5 = new treeNode();
		n5.setData(6);
		treeNode n6 = new treeNode();
		n6.setData(11);
		treeNode n7 = new treeNode();
		n7.setData(8);
		t.insertNode(n1);
		t.insertNode(n2);
		t.insertNode(n3);
		t.insertNode(n4);
		t.insertNode(n5);
		t.insertNode(n6);
		t.insertNode(n7);
		treeNode father = t.findFather(t.getRoot(), n4, n7);
		System.out.println(father.getData());
	}
}

class treeNode {
	private int data;
	private treeNode left;
	private treeNode right;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public treeNode getLeft() {
		return left;
	}

	public void setLeft(treeNode left) {
		this.left = left;
	}

	public treeNode getRight() {
		return right;
	}

	public void setRight(treeNode right) {
		this.right = right;
	}

}

// 队列
class queue {
	private queueNode first;
	private queueNode end;

	public queue() {
		first = end = null;
	}

	// 如队列
	public void InQueue(queueNode n) {
		if (first == null && end == null)
			first = end = n;
		else {
			end.setNext(n);
			n.setNext(null);
			end = n;
		}
	}

	// 出队列
	public queueNode OutQueue() {
		if (first == null && end == null)
			return null;
		else if (first == end && first != null && end != null) {
			queueNode p = first;
			first = end = null;
			return p;
		} else {
			queueNode p = first;
			first = first.getNext();
			return p;
		}

	}

	// 打印数据结构
	public void printQueue() {
		queueNode pNode = first;
		while (pNode != null) {
			System.out.print(pNode.getData() + " ");
			pNode = pNode.getNext();
		}
		System.out.println();
	}

	// 是否为空
	public boolean isEmtpy() {
		if (first == null && end == null)
			return true;
		else
			return false;
	}
}

// 队列节点
class queueNode {
	private queueNode next;
	private Object data;

	public queueNode getNext() {
		return next;
	}

	public void setNext(queueNode next) {
		this.next = next;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}