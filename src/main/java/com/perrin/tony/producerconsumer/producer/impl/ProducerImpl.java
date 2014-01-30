package com.perrin.tony.producerconsumer.producer.impl;/**
 * Created by tonyperrin on 30/01/2014.
 */

import com.perrin.tony.producerconsumer.producer.Producer;

import java.util.List;
import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 * User: tonyperrin
 * Date: 30/01/2014
 * Time: 07:52
 * To change this template use File | Settings | File Templates.
 */
public class ProducerImpl implements Producer {
    private volatile boolean running;
    private List<String> messageQueue;
    private Object lock;

    public ProducerImpl(List<String> messageQueue, Object lock) {
        this.messageQueue = messageQueue;
        this.lock = lock;
    }

    public boolean startProducer() {

        new Thread(new ProducerRunnable()).start();

        synchronized (ProducerImpl.class) {
            try {
                ProducerImpl.class.wait(); //wait on class object.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public boolean isRunning() {
        return running;
    }

    private static String createMessage() {
        return "Hello world-" + Long.toHexString(System.currentTimeMillis());
    }

    public boolean stopRunning() {
        running = false;
        return running;
    }

    private class ProducerRunnable implements Runnable {
        @Override
        public void run() {
            int count = 0;

            synchronized (ProducerImpl.class) {
                running = true;
                ProducerImpl.class.notify(); //notify class object that we are running.
            }

            while(running) {
                try {
                    Thread.sleep(1000);
                    count++;
                    messageQueue.add(createMessage() + count);

                    synchronized (lock) {
                        lock.notify();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
