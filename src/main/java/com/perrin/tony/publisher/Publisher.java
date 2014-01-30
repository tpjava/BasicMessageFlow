package com.perrin.tony.publisher;/**
 * Created by tonyperrin on 29/01/2014.
 */

import com.perrin.tony.subscribers.Subscriber;

/**
 * Created by IntelliJ IDEA.
 * User: tonyperrin
 * Date: 29/01/2014
 * Time: 21:24
 * To change this template use File | Settings | File Templates.
 */
public interface Publisher {
    public boolean addSubscriber(Subscriber subscriber);
    public boolean removeSubscriber(Subscriber subscriber);
    public void onMessage(String message);
}
