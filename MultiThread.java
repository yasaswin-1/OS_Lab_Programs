package labexp;
import java.util.*;
class Reservation
{
    int seats_available;
    Reservation(int s)
    {
        seats_available=s;
    }
    void reserve(int seats_required,String p)
    {
        System.out.println("Available seats : "+seats_available);
        if(seats_available>seats_required)
        {
            System.out.println(seats_required+" seats booked successfully for "+p);
            seats_available-=seats_required;
        }
        else
        {
            System.out.println("Sorry only "+seats_available+" are Available\nPress Y to book remaining seats");
            if(new Scanner(System.in).next().charAt(0)=='y')
            {
                System.out.println("Remaining tickets booked successfully by "+p);
                seats_available=0;
            }
        }
    }
}
class Book extends Thread
{
    Reservation r;
    String p;
    int s;
    Book(Reservation r,String p,int s)
    {
        this.r=r;
        this.p=p;
        this.s=s;
    }
    public void run()
    {
        r.reserve(s,p);
    }
}
public class MultiThread
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the total no of Tickets Available");
        Reservation r=new Reservation(sc.nextInt());
        System.out.println("Enter the no of Tickets required by Ram");
        Book a=new Book(r,"Ram",sc.nextInt());
        System.out.println("Enter the no of Tickets required by Sita");
        Book b=new Book(r,"Sita",sc.nextInt());
        a.start();
        b.start();
    }
}