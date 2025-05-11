package labexp;
import java.util.*;
class Process
{
	int pid,at,bt,wt,ct,trt;
	Process(int pid,int at,int bt)
	{
		this.bt=bt;
		this.at=at;
		this.pid=pid;
	}
	
}
public class FCFS {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no of processes");
		int n=sc.nextInt();
		Process p[]=new Process[n];
		System.out.println("Enter Arrival time and Burst time of each process");
		for(int i=0;i<n;i++)
			p[i]=new Process(i+1,sc.nextInt(),sc.nextInt());
		fcfs(p);
		double twt=0,ttrt=0;
		for(int i=0;i<n;i++)
		{
			twt+=p[i].wt;
			ttrt+=p[i].trt;
		}
		System.out.println("PID\tAT\tBT\tCT\tTRT\tWT");
		for(int i=0;i<n;i++)
			System.out.println(p[i].pid+"\t"+p[i].at+"\t"+p[i].bt+"\t"+p[i].ct+"\t"+p[i].trt+"\t"+p[i].wt);
		System.out.println("Average Waiting Time : "+(twt/n));
		System.out.println("Average Turnaround Time : "+(ttrt/n));
	}
	static void fcfs(Process p[])
	{
		for(int i=0;i<p.length-1;i++)
			for(int j=0;j< p.length-i-1;j++)
				if(p[j].at>p[j+1].at)
				{
					Process temp=p[j];
					p[j]=p[j+1];
					p[j+1]=temp;
				}
		p[0].wt=0;
		p[0].ct=p[0].bt+p[0].at;
		p[0].trt=p[0].ct-p[0].at;
		for(int i=1;i<p.length;i++)
		{
			p[i].wt=p[i-1].ct-p[i].at;
			p[i].ct=p[i].at+p[i].bt+p[i].wt;
			p[i].trt=p[i].ct-p[i].at;
		}
	}
}
