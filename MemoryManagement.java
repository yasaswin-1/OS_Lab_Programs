package labexp;
import java.util.*;
class Memory1{
	int id,size,p,psize;
	Memory1(int id,int size)
	{
		this.id=id;
		this.size=size;
		this.p=0;
	}
}
class Process1{
	int id,size;
	Process1(int id,int size)
	{
		this.id=id;
		this.size=size;
	}
}
public class MemoryManagement {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no of free blocks");
		int n=sc.nextInt();
		Memory1 m[]=new Memory1[n];
		int fc=n;
		System.out.println("Enter the size of each block");
		for(int i=0;i<n;i++)
			m[i]=new Memory1(i+1,sc.nextInt());
		System.out.println("Enter the no of processes");
		int p=sc.nextInt();
		System.out.println("Enter the size of each process");
		ArrayList<Process1> a=new ArrayList<Process1>();
		for(int i=0;i<p;i++)
			a.add(new Process1(i+1,sc.nextInt()));
		for(int i=0;i<n-1;i++)
			for(int j=0;j<n-i-1;j++)
				if(m[j].size>m[j+1].size)
				{
					Memory1 t=m[j];
					m[j]=m[j+1];
					m[j+1]=t;
				}
		for(int i=0;i<p;i++)
		{
			Process1 x=a.get(i);
			for(int j=0;j<n;j++)
				if(x.size<=m[j].size)
					if(m[j].p==0)
					{
						m[j].p=x.id;
						m[j].psize=x.size;
						a.remove(i);
						i--;p--;fc--;
						break;
					}
		}
		if(!a.isEmpty())
			System.out.println("Fragmentation occured");
		else
		{
			System.out.println("The allocation is :- \nBlock\tPID\tSize");
			for(int i=0;i<n;i++)
				if(m[i].p!=0)
				System.out.println(m[i].id+"\t"+m[i].p+"\t"+m[i].psize);
			if(fc>0)
			{
				System.out.print("The available free blocks are:- ");
				for(int i=0;i<n;i++)
					if(m[i].p==0)
						System.out.print("Block "+m[i].id+" ");
			}
		}
	}
}