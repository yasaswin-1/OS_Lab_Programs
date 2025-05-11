package Exp1;
import java.util.*;
public class Paging
{
	static Scanner sc=new Scanner(System.in);
    static int exponentof2(int a)
    {
        int c=0;
        while(a!=1)
        {
            a=a/2;
            c=c+1;
        }
        return c ;
    }
    public static void main(String args[])
    {
        System.out.println("Enter no of bits in logical address");
        int m=sc.nextInt();
        System.out.println("Enter the page size in bytes");
        int p=sc.nextInt();
        int pageoffset=exponentof2(p);
        System.out.println("Enter no of bits in physical address");
        int n=sc.nextInt();
        int laddrspace=(int)Math.pow(2,m);
        int paddrspace=(int)Math.pow(2,n);
        int pages=laddrspace/p;
        int frames=paddrspace/p;
        int page[]=new int[pages];
        int frame[]=new int[frames];
        table(page,frame);
        System.out.println("Enter the logical address : ");
        int laddr=sc.nextInt();
        System.out.println(physical(laddr,page,p));
    }
    static void table(int page[],int frame[])
    {
        int f,i;
        for(i=0;i<frame.length;i++)
        frame[i]=-1;
        for(i=0;i<page.length;i++)
        {
            System.out.print("Enter frame number for page "+i+": ");
            f=sc.nextInt();
            page[i]=f;
            frame[f]=i;
        }
        System.out.println("Pageno\tFrameno");
        for(i=0;i<page.length;i++)
            System.out.println(i+"\t"+page[i]);
        System.out.println("Frameno\tpageno");
        for(i=0;i<frame.length;i++)
            System.out.println(i+"\t"+frame[i]);
    }
    static int physical(int laddr,int page[],int p)
    {
        int pageno=laddr/p;
        int d=laddr%p;
        int paddrr=page[pageno]*p+d;
        return paddrr;
    }
}
/*
Enter no of bits in logical address
5
Enter the page size in bytes
5
Enter no of bits in physical address
5
Enter frame number for page 0:2
Enter frame number for page 1:3
Enter frame number for page 2:0
Enter frame number for page 3:2
Enter frame number for page 4:1
Enter frame number for page 5:4
Pageno	Frameno
0	2
1	3
2	0
3	2
4	1
5	4
Frameno	pageno
0	2
1	4
2	3
3	1
4	5
5	-1
Enter the logical address : 
4
14
*/