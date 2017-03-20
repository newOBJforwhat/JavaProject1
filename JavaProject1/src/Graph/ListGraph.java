package Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 邻接表实现的图
 * @author ctk
 *
 */
public class ListGraph {
	private List<GraphNode> gNodes ;
	private int vertex ;
	private int edges ;
	public ListGraph(int vertex){
		this.vertex = vertex ;
		gNodes = new ArrayList<>(vertex);
		for(int i=0;i<vertex;i++)
		{
			GraphNode gnode = new GraphNode();
			gnode.setNodeIndex(i);
			gnode.setNext(null);
			gNodes.add(gnode);
		}
	}
	//添加边
	public void addEdge(int i,int j,int weight){
		if(i >= vertex || j >= vertex || i < 0 || j < 0)
		{
			System.out.println("输入的i和j超过范围");
			return;
		}
		GraphNode gnode = gNodes.get(i);
		boolean isAlter = false;
		while(gnode.getNext() != null)
		{
			if(gnode.getNodeIndex() == j)
			{
				gnode.setData(weight);
				isAlter = true;
				break;
			}
			gnode = gnode.getNext();
		}
		if(i == j){
			gnode.setData(weight);
			isAlter = true;
		}
		if(!isAlter){
			GraphNode edgeNode = new GraphNode();
			edgeNode.setData(weight);
			edgeNode.setNodeIndex(j);
			edgeNode.setNext(null);
			gnode.setNext(edgeNode);
		}
	}
	//生成邻接矩阵
	public int[][] getMartix(){
		int[][] martix = new int[vertex][vertex];
		GraphNode temp = null;
		for(int i=0;i<gNodes.size();i++){
			temp = gNodes.get(i);
			while(temp != null){
				martix[i][temp.getNodeIndex()] = temp.getData();
				temp = temp.getNext();
			}
		}
		return martix;
	}
	//获得某边
	public int getEdge(int i,int j){
		int weight = 0;
		if(i >= vertex || j >= vertex || i < 0 || j < 0)
		{
			System.out.println("输入的i和j超过范围");
			return weight;
		}
		GraphNode temp = gNodes.get(i);
		while(temp != null){
			if(temp.getNodeIndex() == j){
				weight = temp.getData();
				break;
			}
			temp = temp.getNext();
		}
		return weight;
	}
	public int getVertex() {
		return vertex;
	}
	public int getEdges() {
		return edges;
	}
	
	public static void main(String[] args) {
		ListGraph graph = new ListGraph(5);
		graph.addEdge(0, 1, 2);
		graph.addEdge(0, 2, 3);
		graph.addEdge(1, 1, 4);
		graph.addEdge(2, 3, 6);
		int[][] martix = graph.getMartix();
		for(int i =0;i<martix.length;i++){
			for(int j=0;j<martix[i].length;j++)
				System.out.print(martix[i][j]+" ");
			System.out.println();
		}
		System.out.println("获取边<1,1> :"+graph.getEdge(1, 1));
	}
}
//节点类
class GraphNode{
	private int nodeIndex;
	private int data;
	private GraphNode next;
	
	public int getNodeIndex() {
		return nodeIndex;
	}
	public void setNodeIndex(int nodeIndex) {
		this.nodeIndex = nodeIndex;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public GraphNode getNext() {
		return next;
	}
	public void setNext(GraphNode next) {
		this.next = next;
	}
}
