package com.perrin.tony.producerconsumer;/**
 * Created by tonyperrin on 30/01/2014.
 */

import com.perrin.tony.producerconsumer.consumer.Consumer;
import com.perrin.tony.producerconsumer.consumer.ConsumerListener;
import com.perrin.tony.producerconsumer.consumer.impl.ConsumerImpl;
import com.perrin.tony.producerconsumer.consumer.impl.ConsumerListenerImpl;
import com.perrin.tony.producerconsumer.producer.Producer;
import com.perrin.tony.producerconsumer.producer.impl.ProducerImpl;
import com.perrin.tony.publisher.impl.PublisherSingleton;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: tonyperrin
 * Date: 30/01/2014
 * Time: 08:44
 * To change this template use File | Settings | File Templates.
 */
public class ProducerConsumerManagerTest {
    private ProducerConsumerManager producerConsumerManager;
    private PublisherSingleton publisherSingleton;
    private Consumer consumer;
    private Producer producer;

    @Before
    public void testSetUp() {
        producerConsumerManager = new ProducerConsumerManager();
        publisherSingleton = PublisherSingleton.getInstance();
    }

    @Test
    public void testProducerConsumer() {
        Assert.assertNotNull(producerConsumerManager);
    }

    @Test
    public void testStartupProducerConsumerManager() {
        Assert.assertTrue(producerConsumerManager.startup());
    }

    @Test
    public void testAddConsumerListener() {
        Assert.assertTrue(producerConsumerManager.startup());
        Assert.assertTrue(producerConsumerManager.addConsumerListener(new ConsumerListenerImpl(publisherSingleton)));
    }

    @Test
    public void testRemoveConsumerListener() {
        Assert.assertTrue(producerConsumerManager.startup());
        ConsumerListener consumerListener = new ConsumerListenerImpl(publisherSingleton);
        Assert.assertTrue(producerConsumerManager.addConsumerListener(consumerListener));
        Assert.assertTrue(producerConsumerManager.removeConsumerListener(consumerListener));
    }

    @Test
    public void testPublisher() {
        producerConsumerManager.startup();
        PublisherSingleton publisherSingleton = PublisherSingleton.getInstance();
        ConsumerListener consumerListener = new ConsumerListenerImpl(publisherSingleton);
        Assert.assertTrue(producerConsumerManager.addConsumerListener(consumerListener));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @After
    public void testBreakDown() {
        producerConsumerManager = null;
    }
}
