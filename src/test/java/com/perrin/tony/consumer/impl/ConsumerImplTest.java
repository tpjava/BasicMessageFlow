package com.perrin.tony.consumer.impl;/**
 * Created by tonyperrin on 30/01/2014.
 */

import com.perrin.tony.producerconsumer.consumer.impl.ConsumerImpl;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
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
public class ConsumerImplTest {
    private List<String> list = new ArrayList<String>();
    private ConsumerImpl consumerImpl;

    @Before
    public void testSetUp() {
        consumerImpl = new ConsumerImpl(list, new Object());
    }

    @Test
    public void testConsumer() {
        Assert.assertNotNull(consumerImpl);
    }

    @Test
    public void testConsumerStartup() {
        consumerImpl.startConsumer();
        Assert.assertTrue(consumerImpl.isRunning());
        consumerImpl.stopRunning();
    }

    @Test
    public void testConsumerStop() {
        consumerImpl.startConsumer();
        consumerImpl.stopRunning();
        Assert.assertFalse(consumerImpl.isRunning());
    }

    @After
    public void testBreakDown() {
        consumerImpl = null;
    }
}
