

import java.util.Arrays;
import java.util.Scanner;
 
public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number of tasks : ");
        int n = sc.nextInt();
        int[] tasks = new int[n];
        System.out.println("Enter Number of server  : ");
        int m = sc.nextInt();
        int[] servers = new int[m];
        System.out.println("Enter processing time of tasks : ");
        for (int i = 0; i < n; i++) {
            tasks[i] = sc.nextInt();
        }
        double combination = Math.pow(m, n);
        System.out.println("Total combinations of task assignments: " + combination);
        int min = Integer.MAX_VALUE;

        for(int i=0 ; i<combination ; i++) {
            int temp = i;
            for(int j=0 ; j<n ; j++) {
                int serverIndex = temp % m;
                servers[serverIndex] += tasks[j];
                temp /= m;
            }
            System.out.print("Combination " + (i + 1) + ": ");
            for(int k=0 ; k<m ; k++) {
                System.out.print("Server " + (k + 1) + " total processing time: " + servers[k] + " ");
            }
            int max = Arrays.stream(servers).max().getAsInt();
            min = Math.min(min, max);
            
            System.out.println();
            // Reset servers for the next combination
            for(int k=0 ; k<m ; k++) {
                servers[k] = 0;
            }
        
        }
        sc.close();
        System.out.print(" | Minimum processing time among servers: " + min);
    }
}
