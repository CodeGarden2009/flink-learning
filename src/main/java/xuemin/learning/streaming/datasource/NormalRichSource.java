package xuemin.learning.streaming.datasource;

import org.apache.flink.api.common.functions.RuntimeContext;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.source.RichSourceFunction;

/**
 * Rich除了还提供open, close, getRuntimeContext
 * 和setRuntimeContext方法，这些功能可用于参数化函数（传递参数），
 * 创建和完成本地状态，访问广播变量以及访问运行时信息以及有关迭代中的信息。
 * 可以想到的一个点就是在启动的时候传递参数进来
 */
public class NormalRichSource extends RichSourceFunction<Long> {
    private long interval;
    private boolean isRunning=false;
    private long count=1;
    @Override
    public void run(SourceContext<Long> ctx) throws Exception {

        while(isRunning){
            ctx.collect(count);
            count++;
            Thread.sleep(interval);
        }
    }

    @Override
    public void cancel() {
        isRunning=false;
    }

    @Override
    public void setRuntimeContext(RuntimeContext t) {
        super.setRuntimeContext(t);

    }

    @Override
    public void open(Configuration parameters) throws Exception {
        super.open(parameters);
        interval =parameters.getLong("interval",1000L);
        System.out.println("interval:"+interval);
        System.out.println(parameters.keySet());
        isRunning=true;
    }
}
