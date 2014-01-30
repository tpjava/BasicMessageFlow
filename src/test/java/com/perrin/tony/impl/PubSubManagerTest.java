package com.perrin.tony.impl;/**
 * Created by tonyperrin on 29/01/2014.
 */

import com.perrin.tony.publisher.impl.PublisherSingleton;
import com.perrin.tony.subscribers.Subscriber;
import com.perrin.tony.subscribers.impl.SubscriberImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by IntelliJ IDEA.
 * User: tonyperrin
 * Date: 29/01/2014
 * Time: 14:41
 * To change this template use File | Settings | File Templates.
 */
public class PubSubManagerTest {
    @Mock
    Subscriber subscriber;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPubSub() {
        PublisherSingleton publisher = PublisherSingleton.getInstance();
        Assert.assertTrue(publisher.addSubscriber(subscriber));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
}
