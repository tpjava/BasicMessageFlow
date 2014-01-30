package com.perrin.tony.subscribers.impl;/**
 * Created by tonyperrin on 29/01/2014.
 */

import com.perrin.tony.publisher.Publisher;
import com.perrin.tony.publisher.impl.PublisherSingleton;
import com.perrin.tony.subscribers.Subscriber;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Created by IntelliJ IDEA.
 * User: tonyperrin
 * Date: 29/01/2014
 * Time: 08:46
 * To change this template use File | Settings | File Templates.
 */
public class SubscriberTest {
    @Mock
    private Publisher mockPublisher;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSubscriber() {
        Publisher publisher = PublisherSingleton.getInstance();
        Subscriber subscriber = new SubscriberImpl();
        Assert.assertTrue(publisher.addSubscriber(subscriber));
    }

    @Test
    public void testUnSubscribe() {
        Publisher publisher = PublisherSingleton.getInstance();
        Subscriber subscriber = new SubscriberImpl();
        publisher.addSubscriber(subscriber);
        Assert.assertTrue(publisher.removeSubscriber(subscriber));
    }
}
