package org.example.Cache.Factories;

import org.example.Cache.Cache;
import org.example.Cache.EvictionPolicy.LRUEvictionPolicy;
import org.example.Cache.Storage.HashMapBasedStorage;

public class CacheFactory <Key, Value>{
    public Cache<Key, Value> defaultCache(Integer capacity){
       return new Cache<Key, Value>(new LRUEvictionPolicy<Key>(), new HashMapBasedStorage<Key, Value>(capacity));
}
}
