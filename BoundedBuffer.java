package labexp;
import java.util.*;
class Buffer
{
	private int a;
	private boolean full=false;
	synchronized void put(int x)
	{
		if(full)
		{
			try
			{
				wait();
			}
			catch(InterruptedException e)
			{
				System.out.println(e);
			}			
		}
		a=x;
		System.out.println("Produced : "+x);
		full=true;
		notify();
	}
	synchronized void get()
	{
		if(!full)
		{
			try
			{
				wait();
				Thread.sleep(100);
			}
			catch(InterruptedException e)
			{
				System.out.println(e);
			}
			System.out.println("Consumed : "+a);
			full=false;
			notify();
		}
	}
}
public class BoundedBuffer
{
	public static void main(String[] args) 
	{
		Buffer b=new Buffer();
		Thread Producer=new Thread()
		{
			public void run()
			{
				for(int i=1;i<=10;i++)
					b.put(i);
			}
		};
		Thread Consumer=new Thread()
		{
			public void run()
			{
				for(int i=1;i<=10;i++)
					b.get();
			}
		};
		Consumer.start();
		Producer.start();
	}
}