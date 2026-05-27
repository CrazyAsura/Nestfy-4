package com.example.backend.module.config;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class SingletonRegistry {
    private static SingletonRegistry instance;
    private static Map<String, Object> map;

    private SingletonRegistry() {
        map = new HashMap<>();
    }

    public static SingletonRegistry getInstance(){
        if( instance == null){
            instance = new SingletonRegistry();
        }
        return instance;
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(String key) {
        return (T) map.get(key);
    }

    public static <T> void put(String key, T value) {
        map.put(key, value);
    }

    public static void clear() {
        map.clear();
    }

    public static void remove(String key) {
        map.remove(key);
    }

    public static void replace(String key, Object value) {
        map.replace(key, value);
    }

    public static void replaceAll(BiFunction<? super String, ? super Object, ?> function) {
        map.replaceAll(function);
    }

    public static void putIfAbsent(String key, Object value) {
        map.putIfAbsent(key, value);
    }

    
}
