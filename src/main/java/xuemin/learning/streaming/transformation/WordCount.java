package xuemin.learning.streaming.transformation;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.source.RichSourceFunction;

/**
 * 大数据领域的Hello World
 */
public class WordCount {

    static class WordSource extends RichSourceFunction<String> {
        boolean isRunning=false;
        @Override
        public void run(SourceContext<String> ctx) {
            while (isRunning){

            }
        }

        @Override
        public void cancel() {
            isRunning=false;
        }

        @Override
        public void open(Configuration parameters) throws Exception {
            isRunning=true;
        }
    }

    public static void main(String[] args) {

    }
}
