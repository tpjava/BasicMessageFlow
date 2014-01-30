package com.perrin.tony.publisher;/**
 * Created by tonyperrin on 29/01/2014.
 */

import com.perrin.tony.publisher.impl.PublisherSingleton;
import com.perrin.tony.subscribers.Subscriber;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: tonyperrin
 * Date: 29/01/2014
 * Time: 08:39
 * To change this template use File | Settings | File Templates.
 */
public class PublisherSingletonTest {
    @Mock
    private Publisher mockPublisher;
    @Mock
    private Subscriber mockSubscriber;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPublisher() {
        Publisher publisher = PublisherSingleton.getInstance();
        Assert.assertNotNull(publisher);
    }

    @Test
    public void testPublisherOnMessage() {
        //Mockito.doReturn("hello world").when(mockPublisher).onMessage("hello world");
    }
}
