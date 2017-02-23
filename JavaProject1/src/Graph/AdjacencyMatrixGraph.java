package Graph;
import java.util.ArrayList;
import java.util.List;

/**
 * 邻接矩阵
 * @author ctk
 *
 */
public class AdjacencyMatrixGraph {
	private int edges ;
	private int[][] weight;
	private List<String> nodes;
	private int vertex;
	public AdjacencyMatrixGraph(int vertex){
		this.vertex = vertex;
		weight = new int[vertex][vertex];
		nodes = new ArrayList<>(vertex);
		edges = 0;
	}
	//获得节点数
	public int getNodes(){
		return nodes.size();
	}
	//获得边数
	public int getEdges(){
		return edges;
	}
	//插入节点
	public boolean insertNode(String name){
		if(nodes.size() == vertex)
			return false;
		nodes.add(name);
		return true;
	}
	//设置权重
	public boolean setWeight(int i,int j,int weight){
		if(i >= vertex || j >= vertex || i < 0 || j < 0)
			return false;
		if(this.weight[i][j] == 0)
			edges++;
		this.weight[i][j] = weight;
		return true;
	}
	//获得i节点
	public String getNode(int i){
		if(i > nodes.size())
			return null;
		else
			return nodes.get(i);
	}
	//获得边权重
	public int getWeight(int i,int j){
		if(i >= vertex || j >= vertex || i < 0 || j < 0)
			return -1;
		else
			return weight[i][j];
	}
	//删除边
	public void deleteEdge(int i,int j){
		if(i >= vertex || j >= vertex || i < 0 || j < 0){
			System.out.println("越界");
			return ;
		}
		weight[i][j] = 0;
	}
	//打印矩阵
	public void printMatrix(){
		for(int i=0;i<weight.length;i++)
		{
			for(int j=0;j<weight[i].length;j++){
				System.out.print(weight[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(5);
		String node1 = "n1";
		String node2 = "n2";
		String node3 = "n3";
		String node4 = "n4";
		graph.insertNode(node1);
		graph.insertNode(node2);
		graph.insertNode(node3);
		graph.insertNode(node4);
		graph.setWeight(0, 1, 2);
		graph.setWeight(0, 2, 5);
		graph.setWeight(2, 3, 8);
		graph.setWeight(3, 0, 7);
		System.out.println("边数："+graph.getEdges());
		System.out.println("节点数："+graph.getNodes());
		graph.printMatrix();
	}
}
