package com.perrin.tony.subscribers.impl;/**
 * Created by tonyperrin on 29/01/2014.
 */

import com.perrin.tony.publisher.Publisher;
import com.perrin.tony.subscribers.Subscriber;

/**
 * Created by IntelliJ IDEA.
 * User: tonyperrin
 * Date: 29/01/2014
 * Time: 08:49
 * To change this template use File | Settings | File Templates.
 */
public class SubscriberImpl implements Subscriber {

    public SubscriberImpl() {}

    @Override
    public void onMessage(String message) {
        System.out.println("Subscriber Received message." + message);
    }
}
