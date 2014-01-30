package com.perrin.tony.producerconsumer.consumer.impl;/**
 * Created by tonyperrin on 30/01/2014.
 */

import com.perrin.tony.producerconsumer.consumer.ConsumerListener;
import com.perrin.tony.publisher.impl.PublisherSingleton;

/**
 * Created by IntelliJ IDEA.
 * User: tonyperrin
 * Date: 30/01/2014
 * Time: 16:10
 * To change this template use File | Settings | File Templates.
 */
public class ConsumerListenerImpl implements ConsumerListener {
    private PublisherSingleton publisherSingleton;

    public ConsumerListenerImpl(PublisherSingleton publisherSingleton) {
        this.publisherSingleton = publisherSingleton;
    }

    @Override
    public void onMessage(String message) {
        publisherSingleton.onMessage(message);
    }
}
