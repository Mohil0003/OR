public class VogelsApproximation {

    static final int ROW = 3;
    static final int COL = 4;

    public static void main(String[] args) {
        int[][] cost = {
            {12, 10, 12, 13},
            {7, 11, 8, 14},
            {6, 16, 11, 7}
        };

        int[] supply = {500, 300, 200};
        int[] demand = {180, 150, 350, 320};

        int[][] allocation = new int[ROW][COL];
        boolean[] rowDone = new boolean[ROW];
        boolean[] colDone = new boolean[COL];

        int totalCost = 0;

        int totalSupply = 0, totalDemand = 0;
        for (int s : supply) totalSupply += s;
        for (int d : demand) totalDemand += d;

        if (totalSupply != totalDemand) {
            System.out.println("Unbalanced problem: Total supply ≠ Total demand.");
            return;
        }

        while (true) {
            int[] rowPenalty = calculatePenalty(cost, rowDone, colDone, true);
            int[] colPenalty = calculatePenalty(cost, rowDone, colDone, false);

            int maxPenalty = -1, isRow = 1, index = -1;

            for (int i = 0; i < ROW; i++) {
                if (!rowDone[i] && rowPenalty[i] > maxPenalty) {
                    maxPenalty = rowPenalty[i];
                    isRow = 1;
                    index = i;
                }
            }

            for (int i = 0; i < COL; i++) {
                if (!colDone[i] && colPenalty[i] > maxPenalty) {
                    maxPenalty = colPenalty[i];
                    isRow = 0;
                    index = i;
                }
            }

            if (index == -1) break;

            int minCost = Integer.MAX_VALUE;
            int r = -1, c = -1;

            if (isRow == 1) {
                r = index;
                for (int j = 0; j < COL; j++) {
                    if (!colDone[j] && cost[r][j] < minCost) {
                        minCost = cost[r][j];
                        c = j;
                    }
                }
            } else {
                c = index;
                for (int i = 0; i < ROW; i++) {
                    if (!rowDone[i] && cost[i][c] < minCost) {
                        minCost = cost[i][c];
                        r = i;
                    }
                }
            }

            int alloc = Math.min(supply[r], demand[c]);
            allocation[r][c] = alloc;
            totalCost += alloc * cost[r][c];

            supply[r] -= alloc;
            demand[c] -= alloc;

            if (supply[r] == 0) rowDone[r] = true;
            if (demand[c] == 0) colDone[c] = true;
        }

        // Print allocation matrix
        System.out.println("\nAllocation Matrix:");
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                System.out.printf("%4d ", allocation[i][j]);
            }
            System.out.println();
        }

        System.out.println("\nTotal Transportation Cost = " + totalCost);
    }

    static int[] calculatePenalty(int[][] cost, boolean[] rowDone, boolean[] colDone, boolean isRow) {
        int size = isRow ? ROW : COL;
        int[] penalty = new int[size];

        for (int i = 0; i < size; i++) {
            if ((isRow && rowDone[i]) || (!isRow && colDone[i])) {
                penalty[i] = -1;
                continue;
            }

            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

            for (int j = 0; j < (isRow ? COL : ROW); j++) {
                int value = isRow ? cost[i][j] : cost[j][i];

                if ((isRow && colDone[j]) || (!isRow && rowDone[j]))
                    continue;

                if (value < min1) {
                    min2 = min1;
                    min1 = value;
                } else if (value < min2) {
                    min2 = value;
                }
            }

            penalty[i] = min2 - min1;
        }

        return penalty;
    }
}
