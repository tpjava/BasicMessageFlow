package com.perrin.tony.producerconsumer.consumer.impl;/**
 * Created by tonyperrin on 30/01/2014.
 */

import com.perrin.tony.producerconsumer.consumer.Consumer;
import com.perrin.tony.producerconsumer.consumer.ConsumerListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: tonyperrin
 * Date: 30/01/2014
 * Time: 08:09
 * To change this template use File | Settings | File Templates.
 */
public class ConsumerImpl implements Consumer {
    private List<String> messageQueue;
    private List<ConsumerListener> consumerListeners = new ArrayList<ConsumerListener>();
    private volatile boolean running;
    private Object lock;

    public ConsumerImpl(List<String> messageQueue, Object lock) {
        this.messageQueue = messageQueue;
        this.lock = lock;
    }

    public boolean startConsumer() {
        new Thread(new ConsumerRunnable()).start();

        synchronized (ConsumerImpl.class) {
            try {
                ConsumerImpl.class.wait(); //wait on class object
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public boolean addListener(ConsumerListener consumerListener) {
        return consumerListeners.add(consumerListener);
    }

    public boolean removeListener(ConsumerListener consumerListener) {
        return consumerListeners.remove(consumerListener);
    }

    private void receiveMessage(String message) {
        for(ConsumerListener consumerListener : consumerListeners) {
            consumerListener.onMessage(message);
        }
    }

    public boolean isRunning() {
        return running;
    }

    public boolean stopRunning() {
        running = false;
        return running;
    }

    private class ConsumerRunnable implements Runnable {
        @Override
        public void run() {
            synchronized (ConsumerImpl.class) {
                running = true;
                ConsumerImpl.class.notify(); //notify class object that we are running.
            }

            while(running) {
                try {
                    synchronized (lock) {
                        while(messageQueue.size() == 0)
                            lock.wait();
                    }
                    receiveMessage(messageQueue.remove(0));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
