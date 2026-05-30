package com.example.backend.module.config;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

public class SingletonRegistry {
    private static volatile SingletonRegistry instance;
    private final Map<String, Object> map;

    private SingletonRegistry() {
        map = new ConcurrentHashMap<>();
    }

    public static SingletonRegistry getInstance() {
        if (instance == null) {
            synchronized (SingletonRegistry.class) {
                if (instance == null) {
                    instance = new SingletonRegistry();
                }
            }
        }
        return instance;
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(String key) {
        return (T) getInstance().map.get(key);
    }

    public static <T> void put(String key, T value) {
        getInstance().map.put(key, value);
    }

    public static void clear() {
        getInstance().map.clear();
    }

    public static void remove(String key) {
        getInstance().map.remove(key);
    }

    public static void replace(String key, Object value) {
        getInstance().map.replace(key, value);
    }

    public static void replaceAll(BiFunction<? super String, ? super Object, ?> function) {
        getInstance().map.replaceAll(function);
    }

    public static void putIfAbsent(String key, Object value) {
        getInstance().map.putIfAbsent(key, value);
    }
}
