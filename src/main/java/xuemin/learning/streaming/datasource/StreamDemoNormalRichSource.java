package xuemin.learning.streaming.datasource;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class StreamDemoNormalRichSource {
    public static void main(String[] args) throws  Exception{

//        StreamExecutionEnvironment env=StreamExecutionEnvironment.getExecutionEnvironment();


        Configuration conf=new Configuration();
        conf.setLong("interval",2000L);
        //env.getConfig().setGlobalJobParameters(conf);
        StreamExecutionEnvironment env= StreamExecutionEnvironment.createLocalEnvironmentWithWebUI(conf);

        System.out.println(conf.keySet());

        DataStreamSource<Long> collectionData=env.addSource(new NormalRichSource());



        collectionData.map(new MapFunction<Long, Long>() {
            @Override
            public Long map(Long value) throws Exception {
                return value+1;
            }
        }).print();

        env.execute();
    }
}
