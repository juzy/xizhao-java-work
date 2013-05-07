package com.xizhao.java.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * <p> Date: 13-5-6 Time: ����2:26 </p>
 * <p>��������</p>
 * <br/>1.��γ�ʼ��
 * <br/>2.��һ��ʱ����������.��֤���еĻ�������ͬһ������ʱ�䣿
 * <br/>3.�ж�̨��������α�֤һ��
 * <br/>4.��������
 *
 * @author xizhao.xsz
 */
public class CachePunishReasonDAO implements PunishReasonDAO {
    private static Map<Object, Object> CAHCE_PUNISH_REASON_MAP;
    private static long DEATH_TIME;
    private static int SET_COUNT=0;
    public static int getSetCount()
    {
               return SET_COUNT;
    }
    static {
        System.out.println("1.in CachePunishReasonDAO static.-----------begin-----------");
        init();
        System.out.println("1.in CachePunishReasonDAO deathTime"+DEATH_TIME);
        System.out.println("1.in CachePunishReasonDAO static.-----------end-----------");

    }
    private static void init(){
        if(null==CAHCE_PUNISH_REASON_MAP){
            CAHCE_PUNISH_REASON_MAP = new HashMap<Object,Object>();
        }
        CAHCE_PUNISH_REASON_MAP.put((long) (Math.random() * 100), "����");
        DEATH_TIME = System.currentTimeMillis() + 1000 *10 + (long) (Math.random() * 1000 * 3);
        SET_COUNT++;
    }


    private void resetCacheValues() {
        System.out.println("2.in CachePunishReasonDAO setCacheValues.-----------begin-----------");
        init();
        System.out.println("2.in CachePunishReasonDAO setCacheValues.-----------end-----------");
    }

    private void clear() {
        System.out.println("3.in CachePunishReasonDAO clear.-----------begin-----------");
        if (null != CAHCE_PUNISH_REASON_MAP && !CAHCE_PUNISH_REASON_MAP.isEmpty()) {
            CAHCE_PUNISH_REASON_MAP.clear();
        }
        System.out.println("3.in CachePunishReasonDAO clear.-----------end-----------");
    }

    @Override
    public Map<Object, Object> getReasons() throws CacheException {
        if (null == CAHCE_PUNISH_REASON_MAP) {
            throw new CacheException("cachePunishReasonMap is null");
        }
        if (CAHCE_PUNISH_REASON_MAP.isEmpty()) {
            throw new CacheException("cachePunishReasonMap is empty");
        }
       if(System.currentTimeMillis()>=DEATH_TIME){
            this.clear();
            this.resetCacheValues();
        }
        return CAHCE_PUNISH_REASON_MAP;
    }
}
