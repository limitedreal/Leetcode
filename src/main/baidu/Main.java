package main.baidu;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.*;

public class Main {
    public List<Object> processTask(List<Object> list) throws ExecutionException, InterruptedException {
        List<Object> results=new ArrayList<>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(50, 100, new PriorityQueue<Object>(),);
        List<Future> futureList=new ArrayList<>();
        for (Object o : list) {
            Future future=threadPoolExecutor.execute(new Callable<Object>((obj)->{
                Object taskResult=new Object();
                //ProcessTask(obj);
                return "taskResult";
            }));
            futureList.add(future);
        }
        for (Future future : futureList) {
            results.add(future.get());
        }
        return results;
        // hadoop spark 大数据的管理平台 主要语言：Java、GoLang
        // 三面 这周或者下周
        //
        //1. 进程
        //2. 线程
    }

}
