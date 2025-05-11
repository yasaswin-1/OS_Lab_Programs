package labexp;
import java.util.*;
class Process3
{
	int pid,bt,wt,ct,trt;
	Process3(int pid,int bt)
	{
		this.bt=bt;
		this.pid=pid;
	}
}
public class SJF {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no of processes");
		int n=sc.nextInt();
		Process3 p[]=new Process3[n];
		System.out.println("Enter Burst time of each process");
		for(int i=0;i<n;i++)
			p[i]=new Process3(i+1,sc.nextInt());
		sjf(p);
		double twt=0,ttrt=0;
		for(int i=0;i<n;i++)
		{
			twt+=p[i].wt;
			ttrt+=p[i].trt;
		}
		System.out.println("PID\tBT\tCT\tTRT\tWT");
		for(int i=0;i<n;i++)
			System.out.println(p[i].pid+"\t"+p[i].bt+"\t"+p[i].ct+"\t"+p[i].trt+"\t"+p[i].wt);
		System.out.println("Average Waiting Time : "+(twt/n));
		System.out.println("Average Turnaround Time : "+(ttrt/n));
	}
	static void sjf(Process3 p[])
	{
		for(int i=0;i<p.length-1;i++)
			for(int j=0;j< p.length-i-1;j++)
				if(p[j].bt>p[j+1].bt)
				{
					Process3 temp=p[j];
					p[j]=p[j+1];
					p[j+1]=temp;
				}
		p[0].wt=0;
		p[0].ct=p[0].bt;
		p[0].trt=p[0].ct;
		for(int i=1;i<p.length;i++)
		{
			p[i].wt=p[i-1].ct;
			p[i].ct=p[i].bt+p[i].wt;
			p[i].trt=p[i].ct;
		}
	}
}
/*
Enter the no of processes
4
Enter Burst time of each process
21
3
6
2
PID	BT	CT	TRT	WT
4	2	2	2	0
2	3	5	5	2
3	6	11	11	5
1	21	32	32	11
Average Waiting Time : 4.5
Average Turnaround Time : 12.5
*/