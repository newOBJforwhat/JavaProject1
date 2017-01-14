package package1;

public class SqrtDemo {
	int index=-1;
	//二分法
	public double sqrt1(double number,double precision){
		double up=(number>1?number:1);
		double down=0;
		double n;
		int time=0;
		while(true){
			n=(down+up)/2;
			if(n*n-number<precision && n*n-number>=0)
				break;
			else if(n*n-number>precision)
				up=n;
			else if(n*n-number<0)
				down=n;
			time++;
			System.out.println(n);
		}
		System.out.println("time="+time);
		return n;
	}
	//牛顿拉复生方法
	public double sqrt2(double number,double precision){
		double k=1.0;
		int time=0;
		while(Math.abs(k*k-number)>precision){
			
			k=(k+number/k)/2;
			time++;
		}
		System.out.println("time="+time);
		return k;
	}
	public void BisectionFind(int a[],int l,int r,int target){
		if(l<r){
			int mid=(l+r)/2;
			if(a[mid]<target)
				BisectionFind(a,mid+1,r,target);
			else if(a[mid]>target)
				BisectionFind(a, l, mid-1, target);
			else
			{
				index=mid;
				return;
			}
			System.out.println("left="+l+" right="+r);
		}
	
		
		
	}
	public static void main(String[] args)
	{
		SqrtDemo sq=new SqrtDemo();
		System.out.println(sq.sqrt2(10, 0.001));
		
		
		
	}

}
