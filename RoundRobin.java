package labexp;
import java.util.*;
class P{
    int pid,bt,wt,tat,ct,remainingTime,rt;

    P(int pid, int bt) {
        this.pid = pid;
        this.bt = bt;
        this.remainingTime = bt;
    }
}

public class RoundRobin {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of processes");
        int n=sc.nextInt();
        System.out.println("Enter the time quantum");
        int q=sc.nextInt();
        P p[]=new P [n];
        System.out.println("Enter Burst time of each process");
        for (int i=0;i<n;i++)
            p[i]=new P(i+1,sc.nextInt());
        roundRobin(p,q);
        float twt=0,ttat=0;
        for (int i=0;i<n;i++) {
            twt+=p[i].wt;
            ttat+=p[i].tat;
        }
        System.out.println("PID\tBT\tCT\tTAT\tWT\tRT");
        for (int i=0;i<n;i++)
            System.out.println(p[i].pid+"\t"+p[i].bt+"\t"+p[i].ct+"\t"+p[i].tat+"\t"+p[i].wt+"\t"+p[i].rt);
        System.out.println("Average Waiting Time : "+(twt / n));
        System.out.println("Average Turnaround Time : "+(ttat / n));
    }

    static void roundRobin(P p[],int q) 
    {
        int n=p.length,t=0,completed=0;
        while(completed<n)
            for(int i=0;i<n;i++) 
                if(p[i].remainingTime>0) 
                {
                	if(p[i].remainingTime==p[i].bt)
                		p[i].rt=t;
                	if(p[i].remainingTime<=q) 
                    {
                        t+=p[i].remainingTime;
                        p[i].remainingTime=0;
                        p[i].ct=t;
                        p[i].tat=p[i].ct;
                        p[i].wt=p[i].tat-p[i].bt;
                        completed++;
                    } 
                    else
                    {
                        t+=q;
                        p[i].remainingTime-=q;
                    }
                }
    }
}