package labexp;
import java.util.*;
public class BankersAlgorithm {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no of processes");
		int p=sc.nextInt();
		System.out.println("Enter the no of resources");
		int r=sc.nextInt();
		int allocated[][]=new int[p][r];
		System.out.println("Enter the allocated matrix");
		for(int i=0;i<p;i++)
			for(int j=0;j<r;j++)
				allocated[i][j]=sc.nextInt();
		System.out.println("Enter the available matrix");
		int available[]=new int[r];
		for(int i=0;i<r;i++)
				available[i]=sc.nextInt();
		int max[][]=new int[p][r];
		int need[][]=new int[p][r];
		System.out.println("Enter the max matrix");
		for(int i=0;i<p;i++)
			for(int j=0;j<r;j++)
			{	
				max[i][j]=sc.nextInt();
				need[i][j]=max[i][j]-allocated[i][j];
			}
		System.out.println("Generated need matrix :- ");
		for(int i=0;i<p;i++)
		{
			for(int j=0;j<r;j++)
				System.out.print(need[i][j]+"\t");
			System.out.println();
		}
		int safe[]=new int[p];
		int count=0;
		boolean b[]=new boolean[p];
		while(count<p)
		{
			for(int i=0;i<p;i++)
			{	
				boolean f=false;
				if(!b[i])
				{
					for(int j=0;j<r;j++)
						if(need[i][j]>available[j])
						{
							f=true;
							break;
						}
					if(!f)
					{
						safe[count++]=i;
						b[i]=true;
						for(int k=0;k<r;k++)
							available[k]+=allocated[i][k];
					}
				}
			}
		}
		if(count<p)
			System.out.println("The System is Unsafe");
		else
		{
			System.out.print("The Safe Sequence is :- ");
			for(int i=0;i<p;i++)
				System.out.print("P"+safe[i]+" ");
		}
	}
}
