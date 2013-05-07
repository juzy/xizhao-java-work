package com.xizhao.java.cache;

import java.io.Serializable;

/**
 * <p>
 * <p> Date: 13-5-6 Time: обнГ2:12 </p>
 *
 * @author xizhao.xsz
 */
public class CacheException extends Exception {
    private static final long serialVersionUID = 8127639676942996581L;

    public CacheException() {
        super();
    }
    public CacheException(String msg){
        super(msg);
    }
}
