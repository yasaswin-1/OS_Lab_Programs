package labexp;
import java.util.concurrent.Semaphore;
import java.util.*;
class BarberShop {
    private final Semaphore barber;
    private final Semaphore customer;
    private final Semaphore mutex;
    private int numSeats,count=0,c;
   
    public BarberShop(int numSeats,int c) 
    {
        this.numSeats = numSeats;
        barber = new Semaphore(0);
        customer = new Semaphore(0);
        mutex = new Semaphore(1);
        this.c=c;
    }
    synchronized public void barber() 
    {
        while(count<c) 
        {
            try {
                System.out.println("Barber is sleeping");
                customer.acquire(); 
                mutex.acquire();
                numSeats++; 
                barber.release();
                mutex.release();
                // Cut hair
                System.out.print("Barber is cutting hair for ");
                Thread.sleep(2000);
                count++;
            } 
            catch (InterruptedException e)
            {
                System.out.println(e);
            }
        }
        System.out.println("Barber is sleeping");
    }
    public void customer(int customerId) 
    {
        try 
        {
            mutex.acquire();
            if (numSeats > 0) 
            {
                numSeats--;
                System.out.println("Customer " + customerId + " went to the waiting hall");
                customer.release();
                mutex.release();
                barber.acquire();
                // Get a haircut
                System.out.println("Customer " + customerId);
                Thread.sleep(1500);
                System.out.println("Customer " + customerId + " is leaving because haircut is done");
            }
            else 
            {
                mutex.release();
                System.out.println("Customer " + customerId + " is leaving the shop because chairs are full");
                count++;
            }
        } 
        catch (InterruptedException e)
        {
            System.out.println(e);
        }
    }
}
public class BarberProblem 
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no of chairs in Waiting hall");
        int n=sc.nextInt();
        System.out.println("Enter the no of customers");
        int c=sc.nextInt();
        BarberShop barberShop = new BarberShop(n,c);
        Thread barberThread = new Thread()
        {
            public void run()
            {
                barberShop.barber();
            }
        };
        barberThread.start();
        for (int i = 1; i <=c; i++) 
        {
            final int customerId = i;
            Thread customerThread = new Thread()
            {
                public void run()
                {
                    barberShop.customer(customerId);
                }
            };
            customerThread.start();
            try
            {
                Thread.sleep(1000);
            } 
            catch (InterruptedException e)
            {
                System.out.println(e);
            }
        }
    }
}