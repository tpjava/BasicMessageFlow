package com.perrin.tony.producerconsumer;/**
 * Created by tonyperrin on 30/01/2014.
 */

import com.perrin.tony.producerconsumer.consumer.Consumer;
import com.perrin.tony.producerconsumer.consumer.ConsumerListener;
import com.perrin.tony.producerconsumer.consumer.impl.ConsumerImpl;
import com.perrin.tony.producerconsumer.producer.Producer;
import com.perrin.tony.producerconsumer.producer.impl.ProducerImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: tonyperrin
 * Date: 30/01/2014
 * Time: 08:50
 * To change this template use File | Settings | File Templates.
 */
public class ProducerConsumerManager {
    private Producer producer;
    private Consumer consumer;
    private Object lock = new Object();
    private List<String> messageQueue = new ArrayList<String>();

    public ProducerConsumerManager() {}

    public boolean startup() {
        consumer = new ConsumerImpl(messageQueue, lock);
        consumer.startConsumer();
        producer = new ProducerImpl(messageQueue, lock);
        producer.startProducer();
        return true;
    }

    public boolean addConsumerListener(ConsumerListener consumerListener) {
        return consumer.addListener(consumerListener);
    }

    public boolean removeConsumerListener(ConsumerListener consumerListener) {
        return consumer.removeListener(consumerListener);
    }
}
