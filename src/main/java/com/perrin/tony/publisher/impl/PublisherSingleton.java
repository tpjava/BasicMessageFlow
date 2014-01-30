package com.perrin.tony.publisher.impl;/**
 * Created by tonyperrin on 29/01/2014.
 */

import com.perrin.tony.publisher.Publisher;
import com.perrin.tony.subscribers.Subscriber;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: tonyperrin
 * Date: 29/01/2014
 * Time: 08:42
 * To change this template use File | Settings | File Templates.
 */
public class PublisherSingleton implements Publisher {
    private static PublisherSingleton instance;
    private static List<Subscriber> subscriberList = new ArrayList<Subscriber>();
    private static boolean isRunning = false;

    private PublisherSingleton() {
        //disable instantiation from default constructor forcing singleton getInstance();
    }

    public static PublisherSingleton getInstance() {
        if (instance == null) {
            synchronized (PublisherSingleton.class) {
                if (instance == null) {
                    instance = new PublisherSingleton();
                }
            }
        }
        return instance;
    }

    public void init() {
        System.out.println("Init has been called.");
    }

    public boolean isProcessing() {
        return isRunning;
    }

    @Override
    public boolean addSubscriber(Subscriber subscriber) {
        return subscriberList.add(subscriber);
    }

    @Override
    public boolean removeSubscriber(Subscriber subscriber) {
        return subscriberList.remove(subscriber);
    }

    public void onMessage(String message) {
        updateSubscribers(message);
    }

    public void updateSubscribers(String message) {
        for(Subscriber subscriber : subscriberList) {
            subscriber.onMessage(message);
        }
    }
}
