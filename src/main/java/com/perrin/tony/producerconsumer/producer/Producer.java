package com.perrin.tony.producerconsumer.producer;/**
 * Created by tonyperrin on 30/01/2014.
 */

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: tonyperrin
 * Date: 30/01/2014
 * Time: 08:46
 * To change this template use File | Settings | File Templates.
 */
public interface Producer {
    public boolean startProducer();
    public boolean stopRunning();
    public boolean isRunning();
}
