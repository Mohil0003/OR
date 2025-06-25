public class Least_Cost {

    public static void main(String[] args) {
        int[][] cost = { { 12, 10, 12, 13 },
                { 7, 11, 8, 14 },
                { 6, 16, 11, 7 } };

        int[] supply = { 500, 300, 200 };
        int[] demand = { 180, 150, 350, 320 };

        int[][] alloc = new int[3][4];

        while (true) {

            int minCost = Integer.MAX_VALUE;
            int minI = -1, minJ = -1;

            for (int i = 0; i < supply.length; i++) {
                if (supply[i] == 0) {
                    continue;
                }
                for (int j = 0; j < demand.length; j++) {
                    if (demand[j] == 0){
                        continue;
                    }
                    if (cost[i][j] < minCost) {
                        minCost = cost[i][j];
                        minI = i;
                        minJ = j;
                    }
                }
            }
            if (minI == -1 || minJ == -1)
                break;

            int allocQty = Math.min(supply[minI], demand[minJ]);
            alloc[minI][minJ] = allocQty;
            supply[minI] -= allocQty;
            demand[minJ] -= allocQty;
        }

        System.out.println("Allocation Matrix:");
        for (int i = 0; i < alloc.length; i++) {
            for (int j = 0; j < alloc[i].length; j++) {
                System.out.print(alloc[i][j] + "\t");
            }
            System.out.println();
        }

        int totalCost = 0;
        for (int i = 0; i < alloc.length; i++) {
            for (int j = 0; j < alloc[i].length; j++) {
                totalCost += alloc[i][j] * cost[i][j];
            }
        }
        System.out.println("Total Transportation Cost: " + totalCost);
    }
}