package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    /** @author  Cao Yuxin
     * Timing the getLast method of SLList
      */
    public static void timeGetLast() {
        int[] nArray ={1000, 2000,4000, 8000, 16000, 32000, 64000, 128000};
        AList<Integer> Ns = new AList<Integer>();
        AList<Double> times = new AList<Double>();
        AList<Integer> opCounts = new AList<>();
        for (int n : nArray) {
            Ns.addLast(n);
            opCounts.addLast(1000);
        }
        for (int i : nArray) {
            SLList<Integer> sll = new SLList<>();
            for (int j = 0; j < i; j++) {
                sll.addLast(j);
            }
            Stopwatch sw = new Stopwatch();
            // do getLast() for 1000 times
            for (int j = 0; j < 1000; j++){
                sll.getLast();
            }
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);
        }
        printTimingTable(Ns, times, opCounts);
    }

}
