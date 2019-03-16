package xuemin.learning.streaming.datasource;



import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.ArrayList;
import java.util.List;

/**
 * 把Collection集合作为数据源
 */
public class StreamingFromCollection {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env=StreamExecutionEnvironment.getExecutionEnvironment();
        List<Integer> data=new ArrayList<>();

        data.add(10);
        data.add(15);
        data.add(20);

        DataStreamSource<Integer> collectionData=env.fromCollection(data);

       DataStream<Integer> dataStream= collectionData.map(new MapFunction<Integer, Integer>() {
            @Override
            public Integer map(Integer value) throws Exception {
                return value+1;
            }
        });

        dataStream.print().setParallelism(1);
        env.execute();
    }
}
