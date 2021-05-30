package com.liugddx.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>@ClassName Apple</p>
 * <p>@description TODO</p>
 *
 * @author Ethan.liu
 * @version 1.0
 * @date 2021/5/30 16:38
 */
public class Apple implements Runnable{
    private int num=50;
    final ReentrantLock lock = new ReentrantLock();

    public void run() {
        try {
            lock.lock();
            for(int i=0;i<50;i++){
                {
                    //同步代码块
                    //——————————————————————————————————————————————
                    if(num>0){
                        try {
                            //导致一个资源信息被多个用户同时拿到
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()+"吃了编号为"+num+"的苹果");
                        num--;
                        //——————————————————————————————————————————————————
                    }
                }
            }
        }finally {
            lock.unlock();
        }

    }

}
