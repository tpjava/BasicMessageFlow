package com.perrin.tony;/**
 * Created by tonyperrin on 30/01/2014.
 */

import com.perrin.tony.producerconsumer.ProducerConsumerManager;
import com.perrin.tony.producerconsumer.consumer.Consumer;
import com.perrin.tony.producerconsumer.consumer.ConsumerListener;
import com.perrin.tony.producerconsumer.consumer.impl.ConsumerImpl;
import com.perrin.tony.producerconsumer.consumer.impl.ConsumerListenerImpl;
import com.perrin.tony.publisher.impl.PublisherSingleton;
import com.perrin.tony.subscribers.Subscriber;
import com.perrin.tony.subscribers.impl.SubscriberImpl;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: tonyperrin
 * Date: 30/01/2014
 * Time: 17:30
 * To change this template use File | Settings | File Templates.
 */
public class MainClass {
    public static void main(String[] args ) {
        //Start up ProducerConsumer.
        ProducerConsumerManager producerConsumerManager = new ProducerConsumerManager();
        producerConsumerManager.startup();

        //Get Publisher and add listener.
        PublisherSingleton publisherSingleton = PublisherSingleton.getInstance();
        ConsumerListener consumerListener = new ConsumerListenerImpl(publisherSingleton);
        producerConsumerManager.addConsumerListener(consumerListener);

        //Add subscribers
        Subscriber subscriber = new SubscriberImpl();
        publisherSingleton.addSubscriber(subscriber);
        Subscriber subscriber2 = new SubscriberImpl();
        publisherSingleton.addSubscriber(subscriber2);
    }
}
