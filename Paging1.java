import java.util.Scanner;



public class Paging1 {

    public static void main(String[] args) {

        final int MAX = 50;

        int[] page = new int[MAX];

        int n, f, ps, off, pno, choice;

        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter the no of pages in memory: ");

        n = sc.nextInt();

        System.out.print("\nEnter page size: ");

        ps = sc.nextInt();

        System.out.print("\nEnter no of frames: ");

        f = sc.nextInt();

        for (int i = 0; i < n; i++)

            page[i] = -1;

        System.out.println("\nEnter the page table");

        System.out.println("(Enter frame no as -1 if that page is not present in any frame)\n");

        System.out.println("\nPage No\tFrame No\n-------\t-------");

        for (int i = 0; i < n; i++) {

            System.out.print("\n\n" + i + "\t\t");

            page[i] = sc.nextInt();

        }

        do {

            System.out.print("\n\nEnter the logical address (i.e., page no & offset): ");

            pno = sc.nextInt();

            off = sc.nextInt();

            if (page[pno] == -1)

                System.out.println("\n\nThe required page is not available in any of frames");

            else

                System.out.println("\n\nPhysical address (i.e., frame no & offset): " + page[pno] + "," + off);

            System.out.print("\nDo you want to continue (1/0)?: ");

            choice = sc.nextInt();

        } while (choice == 1);



        sc.close();

    }

}