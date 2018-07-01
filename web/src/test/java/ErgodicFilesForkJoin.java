import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 *
 * forkJoinpool 实现遍历文件夹
 * 形成fork Join的几个部分：
 * 1. 指定好的ForkJoinPool大小
 * 2. 分散任务的方法
 */
public class ErgodicFilesForkJoin extends RecursiveTask {

    File file;
    StringBuilder result = null ;

    public ErgodicFilesForkJoin(File file, StringBuilder result) {
        this.file = file;
        this.result = result;
    }

    /**
     * 分散任务的方法
     */
    @Override
    protected Object compute() {
        System.out.println("this is compute");
        try {
            if (file.isFile()) { // 符合足够小的要求
                result.append(" \n { " + file.getName() + " } ");
            } else {
                result.append(" |--- " + file.getName());
                // 将文件夹中的每一个部分分散成更小的部分
                File[] childFiles = file.listFiles();
                List<ErgodicFilesForkJoin> ergodicFilesForkJoins = new ArrayList<ErgodicFilesForkJoin>();
                List<ForkJoinTask> ForkJoinTasks = new ArrayList<ForkJoinTask>();
                // 每个小部分都要放入一个拆分的任务中
                for (File file : childFiles) {
                    ergodicFilesForkJoins.add(new ErgodicFilesForkJoin(file, new StringBuilder()));
                }
                //            fork拆分好的任务
                for (ErgodicFilesForkJoin e : ergodicFilesForkJoins) {
                    ForkJoinTasks.add(e.fork());
                }
                for (ForkJoinTask forkJoinTask : ForkJoinTasks) {
                    result.append("\n" + forkJoinTask.join());
                }
            }
        } catch (Exception e) {
            return result.append("this file is null or not exists");
        }
        return result;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        File file = new File("I://");
        ErgodicFilesForkJoin ergodicFilesForkJoin = new ErgodicFilesForkJoin(file,new StringBuilder(" \n |--- start ---| \n "));
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask submit = pool.submit(ergodicFilesForkJoin);
        System.out.println(submit.get().toString());
        pool.shutdown();
    }
}
