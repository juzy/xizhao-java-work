package com.xizhao.java.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * <p> Date: 13-5-6 Time: обнГ2:10 </p>
 *
 * @author xizhao.xsz
 */
public interface PunishReasonDAO {

    Map<Object, Object> getReasons() throws CacheException;
}
