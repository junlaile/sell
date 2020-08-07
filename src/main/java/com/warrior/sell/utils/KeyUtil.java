package com.warrior.sell.utils;

/**
 * @author jun
 */
public class KeyUtil {

    public static synchronized String  generatorUniqueKey(){
        IdWorker idWorker = new IdWorker();
        long uid = idWorker.nextId();
        return uid+"";
    }
}
