
import java.util.Scanner;

public class Duplicate{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length Array :");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            System.out.println("Enter element " + (i + 1) + ":");
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(arr[i] == arr[j]) {
                    arr[j] = -1; // Mark duplicate as -1
                }
            }
        }

       for(int i = 0 ; i < n ; i++){
           System.out.print(arr[i] + " ");
       }
    }
}