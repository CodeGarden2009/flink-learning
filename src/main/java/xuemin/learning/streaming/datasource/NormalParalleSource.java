package xuemin.learning.streaming.datasource;

import org.apache.flink.streaming.api.functions.source.ParallelSourceFunction;

public class NormalParalleSource implements ParallelSourceFunction<Long> {


    private boolean isRunning=true;
    private long count=1L;
    /**
     * 主要的方法
     * 启动一个Source
     * 大部分情况下需要在run中实现一个循环
     * @param sourceContext
     * @throws Exception
     */
    @Override
    public void run(SourceContext<Long> sourceContext) throws Exception {
        while(isRunning){
            sourceContext.collect(count);
            count++;
            Thread.sleep(1000);
        }
    }

    /**
     * 页面上执行取消操作时候会调用的方法
     */
    @Override
    public void cancel() {
        isRunning=false;
    }
}
