package org.example;

import org.example.Cache.Cache;
import org.example.Cache.EvictionPolicy.LRUEvictionPolicy;
import org.example.Cache.Factories.CacheFactory;
import org.example.Cache.Storage.HashMapBasedStorage;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Cache cache = new CacheFactory<String, Integer>().defaultCache(4);
        System.out.println("=== Testing Cache with Capacity 4 ===\n");
        cache.put("sai",1);
        cache.put("sky",2);
        cache.put("om",3);
        cache.put("bokka",4);
        cache.put("kk",6);
        System.out.println(cache.get("sai"));
        cache.display();
        cache.put("sai",1);
        cache.display();
    }
}