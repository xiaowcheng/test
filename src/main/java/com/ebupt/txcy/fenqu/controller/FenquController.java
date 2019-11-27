package com.ebupt.txcy.fenqu.controller;

import com.ebupt.txcy.fenqu.customer.AsyncService;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;

import java.util.*;
import java.util.concurrent.Executor;


@Component
@EnableKafka
public class FenquController{

    private static final Logger logger = LoggerFactory.getLogger(FenquController.class);
    
    @Autowired
    private AsyncService asyncService;
    
    @Value("${kafka.BOOTSTRAP_SERVERS_CONFIG}")
    private  String BOOTSTRAP_SERVERS_CONFIG;
    
    @Value("${kafka.GROUP_ID_CONFIG}")
    private  String GROUP_ID_CONFIG;
    
    @Value("${kafka.ENABLE_AUTO_COMMIT_CONFIG}")
    private  String ENABLE_AUTO_COMMIT_CONFIG;
    
    @Value("${kafka.AUTO_COMMIT_INTERVAL_MS_CONFIG}")
    private  String AUTO_COMMIT_INTERVAL_MS_CONFIG;
    
    @Value("${kafka.Topic}")
    private  String Topic;
    
    @Value("${kafka.AUTO_OFFSET_RESET_CONFIG}")
    private  String AUTO_OFFSET_RESET_CONFIG;
    
    @Value("${kafka.MAX_POLL_RECORDS_CONFIG}")
    private int MAX_POLL_RECORDS_CONFIG;
    
    @Value("${kafka.SESSION_TIMEOUT_MS_CONFIG}")
    private int SESSION_TIMEOUT_MS_CONFIG;
    
    @Value("${kafka.REQUEST_TIMEOUT_MS_CONFIG}")
    private int REQUEST_TIMEOUT_MS_CONFIG;
    
    
    
    
    @Bean
    public Map<String, Object> consumerConfigs() {
        Map<String, Object> props = new HashMap();
        props.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID_CONFIG);// 监听的队列的组
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, ENABLE_AUTO_COMMIT_CONFIG); // 提交方式
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, AUTO_OFFSET_RESET_CONFIG );// 消费的offset
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS_CONFIG);// kafka的地址和端口
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, MAX_POLL_RECORDS_CONFIG);// 一次消费的最大数据量    
        props.put(ConsumerConfig.REQUEST_TIMEOUT_MS_CONFIG, REQUEST_TIMEOUT_MS_CONFIG);
        props.put(ConsumerConfig.REQUEST_TIMEOUT_MS_CONFIG, REQUEST_TIMEOUT_MS_CONFIG);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return props;
    }
    
    @Bean
    public KafkaListenerContainerFactory<?> batchFactory() {
        ConcurrentKafkaListenerContainerFactory<Integer, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(consumerConfigs()));
        factory.setBatchListener(true); // 设置批量消费方式
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);
        return factory;
    }
    
    
    
    // 批量监听
    @KafkaListener(topics = "${kafka.Topic}", containerFactory = "batchFactory")
    public void kafkaListenBatch(List<ConsumerRecord<?, String>> records, Acknowledgment ack){
        logger.info("records.size:"+String.valueOf(records.size()));
        List<String> phoneList = new ArrayList<>(MAX_POLL_RECORDS_CONFIG);
        for (ConsumerRecord<?, String> record : records){
//            logger.info("批量监听------:"+record.value());
            phoneList.add(record.value());
            ack.acknowledge();//手动提交偏移量            
        }
        asyncService.executeAsync(phoneList);
    }
    // 单条监听
//    @KafkaListener(topics = "SysPerfSend", containerFactory = "batchFactory")
//    public void kafkaListenOne(ConsumerRecord<?, String> record){
//        logger.info(record.value());
//    }
    
}
