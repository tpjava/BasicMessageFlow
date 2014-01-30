package com.perrin.tony.producer.impl;/**
 * Created by tonyperrin on 30/01/2014.
 */

import com.perrin.tony.producerconsumer.producer.impl.ProducerImpl;
import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: tonyperrin
 * Date: 30/01/2014
 * Time: 07:51
 * To change this template use File | Settings | File Templates.
 */
public class ProducerImplTest {
    private List<String> list = new ArrayList<String>();
    @Test
    public void testProducer() {
        ProducerImpl producerImpl = new ProducerImpl(list, new Object());
        Assert.assertNotNull(producerImpl);
    }

    @Test
    public void testStartingProducer() {
        ProducerImpl producerImpl = new ProducerImpl(list, new Object());
        producerImpl.startProducer();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(producerImpl.isRunning());
        producerImpl.stopRunning();
    }

    @Test
    public void testStoppingProducer() {
        ProducerImpl producerImpl = new ProducerImpl(list, new Object());
        producerImpl.startProducer();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(producerImpl.isRunning());
        producerImpl.stopRunning();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertFalse(producerImpl.isRunning());
    }
}
