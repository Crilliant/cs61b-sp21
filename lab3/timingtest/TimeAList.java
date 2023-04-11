package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        // %12.3 : 宽度为12个字符，右对齐，小数点后三位。
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
        timeAListConstruction();
    }

    /** @author Cao Yuxin
        Timing the addLast() of AList
     */
    public static void timeAListConstruction() {
        int[] Ns ={1000, 2000,4000, 8000, 16000, 32000, 64000, 128000};
        AList<Integer> NsAlist = new AList<Integer>();
        AList<Double> times = new AList<Double>();
        for (int k : Ns) {
            var aList = new AList<Integer>();
            Stopwatch sw = new Stopwatch();
            for (int j = 0; j < k; j++) {
                aList.addLast(1);
            }
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);
        }
        for (int n : Ns) {
            NsAlist.addLast(n);
        }
        printTimingTable(NsAlist, times, NsAlist);

    }
}
