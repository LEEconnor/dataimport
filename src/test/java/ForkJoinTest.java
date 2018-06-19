import EDU.oswego.cs.dl.util.concurrent.FJTask;
import EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup;

public class ForkJoinTest extends FJTask {

    static final int threshold = 13;
    volatile int number; // arg/result

    ForkJoinTest(int n) {
        number = n;
    }

    int getAnswer() {
        if (!isDone())
            throw new IllegalStateException();
        return number;
    }


    public void run() {
        int n = number;
        // 如果满足 直接执行
        if (n <= threshold) // granularity ctl
            number = seqForkJoinTest(n);
        else { // 如果不满足 大问题
            // 分别构造每个小部分
            ForkJoinTest f1 = new ForkJoinTest(n - 1);
            ForkJoinTest f2 = new ForkJoinTest(n - 2);
            // 执行每个小部分
            coInvoke(f1, f2);
            // 合并结果
            number = f1.number + f2.number;
        }
    }


    public static void main(String[] args) {
        try {
            int groupSize = 2; // for example
            // 给定线程数量
            FJTaskRunnerGroup group = new FJTaskRunnerGroup(groupSize);
            ForkJoinTest f = new ForkJoinTest(35); // for example
            group.invoke(f);
            int result = f.getAnswer();
            System.out.println("Answer: " + result);
        } catch (InterruptedException ex) {

        }

    }


    int seqForkJoinTest(int n) {
        if (n <= 1) return n;
        else return seqForkJoinTest(n - 1) + seqForkJoinTest(n - 2);
    }

}

