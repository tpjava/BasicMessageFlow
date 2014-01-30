package com.perrin.tony.subscribers;/**
 * Created by tonyperrin on 29/01/2014.
 */

import com.perrin.tony.subscribers.impl.SubscriptionListener;

/**
 * Created by IntelliJ IDEA.
 * User: tonyperrin
 * Date: 29/01/2014
 * Time: 08:48
 * To change this template use File | Settings | File Templates.
 */
public interface Subscriber {
    public void onMessage(String message);
}
