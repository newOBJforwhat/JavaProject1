package 程序员面试金典;
/**
 * 第四章
 * @author ctk
 *
 */
public class Unit4 {
	public static void main(String[] args) {
		TreeNode root = new TreeNode();
		TreeNode n1 = new TreeNode();
		TreeNode n2 = new TreeNode();
		TreeNode n3 = new TreeNode();
		TreeNode n4 = new TreeNode();
		TreeNode n5 = new TreeNode();
		TreeNode n6 = new TreeNode();
		TreeNode n7 = new TreeNode();
		root.setData(1);
		root.setLeft(n1);
		root.setRight(n2);
		n1.setLeft(n3);
		n1.setRight(n4);
		n2.setLeft(n5);
		n2.setRight(n6);
		n3.setLeft(n7);
		
		Unit4 test = new Unit4();
		System.out.println(test.checkHeight(root));
		
	}
	//树是否平衡
	public int checkHeight(TreeNode root){
		if(root == null){
			return 0;
		}
		int leftHeight = checkHeight(root.getLeft());
		if(leftHeight == -1)
			return -1;
		int rightHeight = checkHeight(root.getRight());
		if(rightHeight == -1)
			return -1;
		int height = leftHeight - rightHeight;
		if(Math.abs(height) > 1)
			return -1;
		else
			return Math.max(leftHeight, rightHeight)+1;
	}
	
}
class TreeNode{
	private int data;
	private TreeNode left;
	private TreeNode right;
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public TreeNode getLeft() {
		return left;
	}
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	public TreeNode getRight() {
		return right;
	}
	public void setRight(TreeNode right) {
		this.right = right;
	}
}
