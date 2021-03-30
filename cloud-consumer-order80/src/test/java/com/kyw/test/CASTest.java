package com.kyw.test;

import javax.sound.midi.Soundbank;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author kyw
 * @version 1.0
 * @date 2021/3/30 14:51
 */
public class CASTest {

    /*public static void main(String[] args) {

        AtomicInteger integer = new AtomicInteger(5);

        System.out.println(integer.compareAndSet(5,2021)+"\t current value= "+integer.get());
        System.out.println(integer.compareAndSet(5,9999)+"\t current value= "+integer.get());


    }*/

    public static void main(String[] args) {
        CASTest spinLockDemo = new CASTest();

        new Thread(()->{
            spinLockDemo.lock();
            //暂停一会线程
            try { TimeUnit.SECONDS.sleep(5); } catch (Exception e) { e.printStackTrace(); }
            spinLockDemo.unlock();
        },"AA").start();

        try { TimeUnit.SECONDS.sleep(1); } catch (Exception e) { e.printStackTrace(); }

        new Thread(()->{
            spinLockDemo.lock();
            try { TimeUnit.SECONDS.sleep(1); } catch (Exception e) { e.printStackTrace(); }
            spinLockDemo.unlock();
        },"BB").start();
    }

    AtomicReference atomicReference = new AtomicReference();

    public void lock(){
        Thread current = Thread.currentThread();
        System.out.println("上锁，当前线程名称："+current.getName()+"come in");
        while (!atomicReference.compareAndSet(null,current)){};
    }

    public void unlock(){
        Thread current = Thread.currentThread();
        atomicReference.compareAndSet(current,null);
        System.out.println("解锁,当前线程名称:"+current.getName()+"\t invoke unlock()");
    }
}
