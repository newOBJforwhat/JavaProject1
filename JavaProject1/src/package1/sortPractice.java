package package1;

public class sortPractice {
	public void classicSort(int a[]){
		for(int i=0;i<a.length;i++)
			for(int j=i;j<a.length;j++)
			{
				if(a[i]>a[j])
				{
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		
		
	}
	public int Partition(int a[],int p,int r){
		int start=p;
		int end=r;
		int x=a[p];
		
		while(start<end){
			while(start<end && a[end]>=x)
				end--;
			if(start<end)
				a[start++]=a[end];

			System.out.println();
			while(start<end && a[start]<=x)
				start++;
			if(start<end)
				a[end--]=a[start];

		}
		a[start]=x;
		return start;
	}
	public void quickSort(int a[],int i,int j){
		if(i<j){
			int p=Partition(a, i, j);
			quickSort(a, i, p-1);
			quickSort(a, p+1, j);
		}
		
	}
	
	public void MergeSort(int a[],int b[],int start,int end){
		if(start<end)
		{
			int mid=(start+end)/2;
			MergeSort(a,b,start,mid);
			MergeSort(a,b,mid+1,end);
			merge(a,b,start,mid,end);
			
		}
		
	}
	public void merge(int a[],int b[],int start,int mid,int end){
		int i=start;
		int j=mid+1;
		int k=start;
		while(i<=mid && j<=end){
			if(a[i]<=a[j])
				b[k++]=a[i++];
			else
				b[k++]=a[j++];
			
		}

		
		while(i<=mid)
			b[k++]=a[i++];
		while(j<=end)
			b[k++]=a[j++];
		
		for(i=start;i<=end;i++)
			a[i]=b[i];
		
		
	}
	public static void main(String[] args) {
		int a[] ={6,3,4,8,11,2};
		new sortPractice().Partition(a,0,5);
	}

}
