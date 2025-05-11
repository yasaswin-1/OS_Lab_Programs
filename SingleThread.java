package labexp;
import java.util.*;
public class SingleThread {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Thread t1=new Thread()
		{
			public void run()
			{
				System.out.println("Enter two numbers to add,subtract and multiply them");
				int m=sc.nextInt();
				int n=sc.nextInt();
				add(m,n);
				subtract(m,n);
				multiply(m,n);
			}
		};
		t1.start();
		sc.close();
	}
	public static void add(int m,int n)
	{
		System.out.println("The sum of "+m+" and "+n+" is "+(m+n));
	}
	public static void subtract(int m,int n)
	{
		System.out.println("The subtraction of "+m+" and "+n+" is "+(m-n));
	}
	public static void multiply(int m,int n)
	{
		System.out.println("The multiplication of "+m+" and "+n+" is "+(m*n));
	}
}