package com.perrin.tony.producerconsumer.consumer;/**
 * Created by tonyperrin on 30/01/2014.
 */

/**
 * Created by IntelliJ IDEA.
 * User: tonyperrin
 * Date: 30/01/2014
 * Time: 08:45
 * To change this template use File | Settings | File Templates.
 */
public interface Consumer {
    public boolean startConsumer();
    public boolean stopRunning();
    public boolean isRunning();
    public boolean addListener(ConsumerListener consumerListener);
    public boolean removeListener(ConsumerListener consumerListener);
}
