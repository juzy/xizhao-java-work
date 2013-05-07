package com.xizhao.java.init;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * <p> Date: 13-4-27 Time: 上午9:24 </p>
 *
 * @author xizhao.xsz
 */
public class CachingEnumResolver {
    private static final CachingEnumResolver SINGLE_ENUM_RESOLVER = new CachingEnumResolver();
    private static Map CODE_MAP_CACHE;
    static {
        System.out.println("in method static") ;
        if(null==CODE_MAP_CACHE){
                 System.out.println("CODE_MAP_CACHE is null.In static method ");
                 CODE_MAP_CACHE = new HashMap();
             }
        CODE_MAP_CACHE.put("0","北京");
    }
    private CachingEnumResolver(){
        System.out.println("in method CachingEnumResolver") ;
        initEnums();
    }
    private static void initEnums(){
        System.out.println("in method initEnums") ;
        if(null==CODE_MAP_CACHE){
            System.out.println("CODE_MAP_CACHE is null.In static method initEnums");
            CODE_MAP_CACHE = new HashMap();
        }
        CODE_MAP_CACHE.put("1","北京");
        CODE_MAP_CACHE.put("2","上海");
    }
    public Map getCache(){
        System.out.println("in method getCache") ;
        return Collections.unmodifiableMap(CODE_MAP_CACHE);
    }
    public static CachingEnumResolver getSingleEnumResolver()
    {
        System.out.println("in method getSingleEnumResolver") ;
        return SINGLE_ENUM_RESOLVER;
    }
    public static void main(String [] args){
       System.out.println(CachingEnumResolver.getSingleEnumResolver().getCache());
    }

}
