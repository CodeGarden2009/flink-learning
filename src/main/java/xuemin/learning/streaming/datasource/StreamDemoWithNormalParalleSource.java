package xuemin.learning.streaming.datasource;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;


public class StreamDemoWithNormalParalleSource {
    public static void main(String[] args) throws Exception {

        StreamExecutionEnvironment env=StreamExecutionEnvironment.getExecutionEnvironment();

        DataStreamSource<Long> longDataStreamSource = env.addSource(new NormalParalleSource()).setParallelism(2);

        DataStream<Long> dataStream= longDataStreamSource.map(new MapFunction<Long, Long>() {
            @Override
            public Long map(Long value) {
                System.out.println("接收到的数据为:"+value);
                return value;
            }
        });

        //每3秒统计一次数据
        SingleOutputStreamOperator<Long> sumDs = dataStream.timeWindowAll(Time.seconds(3)).sum(0);
        sumDs.print().setParallelism(2);
        env.execute();
    }
}
