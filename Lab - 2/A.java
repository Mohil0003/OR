
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1, x2;
        int z;

        int maxZ = 0;
        for (x1 = 0; x1 <= 4; x1 += 1) {
            for (x2 = 0; x2 <= 4; x2 += 1) {
                if (x1 + x2 <= 4) {
                    z = 3 * x1 + 2 * x2;
                    if (z > maxZ) {
                        maxZ = z;
                    }
                }
            }
        }

        System.out.println("Maximum value of z: " + maxZ);
    }
}
