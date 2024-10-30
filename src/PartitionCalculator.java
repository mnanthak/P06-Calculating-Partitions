
public class PartitionCalculator {

    // public static int numOfPartitions(int N) {
    //     int numOfPartitions = 0;
    //     Partition p = new Partition(N);
    //     for (int i = 0; i < N; i++) {
    //         numOfPartitions += numOfSuperPartitions(createBasePartition(N, i + 1));
    //     }
    //     return numOfPartitions;
    // }

    // private static int numOfSuperPartitions(Partition p) {
    //     if (p.length() == 2) {
    //         return 1;
    //     }
    //     p = compressPartition(p, 1);
    //     return 1 + numOfSuperPartitions(p);
    // }

    // private static Partition compressPartition(Partition p, int index) {
    //     int lastNum = p.getNumAt(p.length() - 1);
    //     int secondNum = p.getNumAt(index);
    //     p.removeLast();
    //     p.addNumber(secondNum + lastNum);
    //     p.swapNumbers(p.length() - 1, index);
    //     p.removeLast();
    //     return p;
    // }

    // private static Partition createBasePartition(int N, int n) {
    //     Partition p = new Partition(N);
    //     p.addNumber(n);
    //     for (int i = 0; i < (N - n); i++) {
    //         p.addNumber(1);
    //     }
    //     return p;
    // }

    public static int numOfPartitions(int N) {
        Partition p = new Partition(N);
        return 1 + numOfSplits(p, N, N / 2);
    }

    private static int numOfSplits(Partition p, int leadingNum, boolean twoNumbers) {
        if (leadingNum == 1) {
            return 1;
        }
        if (twoNumbers) {
            if (p.getN() - leadingNum > leadingNum) {
                return 0 + numOfSplits(p, leadingNum, true);
            }
            else {
                p.reset();
                p.addNumber(leadingNum);
                p.addNumber(p.getN() - leadingNum);
                return 1 + numOfSplits(p, --leadingNum, true);
            }
        }
        
        return 1 + numOfSplits(p, leadingNum, false);
    }
}
