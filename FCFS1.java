import java.util.Scanner;

public class FCFS1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of processes: ");
        int numProcesses = scanner.nextInt();
        
        int[] burstTime = new int[numProcesses];
        int[] waitingTime = new int[numProcesses];
        int[] turnaroundTime = new int[numProcesses];
        
        // Input burst times
        for (int i = 0; i < numProcesses; i++) {
            System.out.print("Enter burst time for process " + (i + 1) + ": ");
            burstTime[i] = scanner.nextInt();
        }
        
        // Calculate waiting time for each process
        waitingTime[0] = 0; // first process doesn't wait
        for (int i = 1; i < numProcesses; i++) {
            waitingTime[i] = waitingTime[i - 1] + burstTime[i - 1];
        }
        
        // Calculate turnaround time for each process
        for (int i = 0; i < numProcesses; i++) {
            turnaroundTime[i] = waitingTime[i] + burstTime[i];
        }
        
        // Calculate total waiting time and total turnaround time
        int totalWaitingTime = 0, totalTurnaroundTime = 0;
        for (int i = 0; i < numProcesses; i++) {
            totalWaitingTime += waitingTime[i];
            totalTurnaroundTime += turnaroundTime[i];
        }
        
        // Display the results
        System.out.println("\nProcess\tBurst Time\tWaiting Time\tTurnaround Time");
        for (int i = 0; i < numProcesses; i++) {
            System.out.println((i + 1) + "\t\t" + burstTime[i] + "\t\t" + waitingTime[i] + "\t\t" + turnaroundTime[i]);
        }
        
        System.out.println("\nAverage waiting time: " + (float)totalWaitingTime / numProcesses);
        System.out.println("Average turnaround time: " + (float)totalTurnaroundTime / numProcesses);
        
        // Closing the scanner
        scanner.close();
    }
}