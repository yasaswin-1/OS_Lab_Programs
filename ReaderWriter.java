package labexp;
import java.util.*;
import java.util.concurrent.Semaphore;
class Memory
{
	int rdcnt=0;
	Semaphore wrt,mutex;
	Memory()
	{
		wrt=new Semaphore(1);
		mutex=new Semaphore(1);
	}
	void writer()
	{
		try
		{
			wrt.acquire();
			System.out.println(Thread.currentThread().getName()+" is Writing");
			//Performs write operation
			Thread.sleep(1500);
			System.out.println(Thread.currentThread().getName()+" Completed Writing");
			wrt.release();		
		}
		catch(InterruptedException e){
			System.out.println(e);
		}
	}
	void reader()
	{
		try
		{
			mutex.acquire();
			rdcnt++;
			if(rdcnt==1)
			wrt.acquire();
			mutex.release();
			System.out.println(Thread.currentThread().getName()+" is Reading");
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName()+" finished Reading");
			mutex.acquire();
			rdcnt--;
			if(rdcnt==0)
				wrt.release();
			mutex.release();
		}
		catch(InterruptedException e)
		{
			System.out.println(e);
		}
	}
}
public class ReaderWriter {
	public static void main(String[] args) throws InterruptedException
	{
		Scanner sc=new Scanner(System.in);
		Memory m=new Memory();
		System.out.println("Enter the no of readers and writers");
		int r=sc.nextInt(),w=sc.nextInt();
		for(int i=1;i<=w;i++)
		{
			Thread Writer=new Thread("Process"+i)
			{
				public void run()
				{
					m.writer();
				}
			};
			Writer.start();
		}
		for(int i=w+1;i<=r+w;i++)
		{
			Thread Reader=new Thread("Process"+i)
			{
				public void run()
				{
					m.reader();
				}
			};
			Reader.start();
		}
			Thread.sleep(500);
	}
}
