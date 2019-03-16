package xuemin.learning.streaming.datasource;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.source.RichParallelSourceFunction;

/**
 * 可以在open和close中打开和关闭资源
 */
public class NormalRichParalleSource extends RichParallelSourceFunction<Long> {
    @Override
    public void run(SourceContext<Long> sourceContext) throws Exception {

    }

    @Override
    public void cancel() {

    }

    @Override
    public void open(Configuration parameters) throws Exception {
        super.open(parameters);
    }

    @Override
    public void close() throws Exception {
        super.close();
    }
}
