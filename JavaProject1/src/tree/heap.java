package tree;

import JDBCConectionPools.account;

/**
 * 最大堆最小堆
 * @author MacBook
 *
 */
public class heap {
	private int[] maxHeap;
	private int[] minHeap;
	private int maxSize = 11;
	private int capacity = 0;
	public heap(){
		maxHeap = new int[maxSize];
		minHeap = new int[maxSize];
	}
	//添加最大堆
	public void InsertMaxHeap(int data){
		int index = capacity;
		if(capacity != maxSize -1)
			maxHeap[capacity++] = data;
		else
			maxHeap[capacity] = data;
		while(index != 0 && maxHeap[index/2] < data){
			swap(index/2, index,maxHeap);
			index = index/2;
		}
		
	}
	//添加最小堆
	public void InsertMinHeap(int data){
		int index = capacity;
		if(capacity != maxSize -1)
			minHeap[capacity++] = data;
		else
			minHeap[capacity] = data;
		while(index != 0 && minHeap[index/2] > data){
			swap(index/2, index,minHeap);
			index = index/2;
		}
	}
	//交换两数
	public void swap(int i,int j,int[] a){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	//获取最大
	public int getMax(){
		return maxHeap[1];
	}
	public void printMin(){
		for(int a:minHeap)
			System.out.print(a+" ");
		System.out.println();
	}
	public void printMax(){
		for(int a:maxHeap)
			System.out.print(a+" ");
		System.out.println();
	}
	public static void main(String[] args) {
		heap h = new heap();
		int a[] = {23,51,32,87,123,78,12,13,78,24};
		for(int d:a)
			h.InsertMinHeap(d);
		h.printMin();
	}
}
