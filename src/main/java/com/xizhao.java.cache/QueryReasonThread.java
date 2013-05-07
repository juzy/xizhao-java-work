package com.xizhao.java.cache;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 * <p> Date: 13-5-6 Time: ÏÂÎç4:15 </p>
 *
 * @author xizhao.xsz
 */
public class QueryReasonThread implements Runnable {
    @Override
    public void run() {
        PunishReasonDAO punishReasonDAO = new CachePunishReasonDAO();
        Map<Object, Object> reasonMap = null;
        try {
            reasonMap = punishReasonDAO.getReasons();

        } catch (CacheException e) {
            e.printStackTrace();
        }
        System.out.println("QueryReasonThread[" + Thread.currentThread().getId() + "][" + Thread.currentThread().getName() + "].We get reasons are" + reasonMap);
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("the start value of count:" + CachePunishReasonDAO.getSetCount());
        ExecutorService exec = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            exec.execute(new QueryReasonThread());
            // new Thread(new QueryReasonThread()).start();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("the end value of couunt:" + CachePunishReasonDAO.getSetCount());

    }
}
