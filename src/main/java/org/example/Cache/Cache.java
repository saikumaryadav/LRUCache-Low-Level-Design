package org.example.Cache;

import org.example.Cache.EvictionPolicy.EvictionPolicy;
import org.example.Cache.Exceptions.NotFoundException;
import org.example.Cache.Exceptions.StorageFullException;
import org.example.Cache.Storage.Storage;

import java.util.Map;

public class Cache<Key, Value> {
    private final EvictionPolicy<Key> evictionPolicy;
    private final Storage<Key, Value> storage;

    public Cache(EvictionPolicy<Key> evictionPolicy, Storage<Key, Value> storage){
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    //cache contains put and get methods

    // For put method
    //-> if full we have to evict then add new key, value pair
    // if key is already exist then i have to update the value
    public void put(Key key, Value value){
        try{
        this.storage.add(key, value);
        this.evictionPolicy.keyAccessed(key);
            System.out.println("test");
        } catch (StorageFullException e){
            System.out.println("storage full im removing evict key");
            Key evictedKey = evictionPolicy.evictKey(key);
            System.out.println("evicted key is :: "+evictedKey);
            this.storage.remove(evictedKey);
            put(key, value);
        }

    }

    public Value get(Key key){
        try {
            Value value = this.storage.get(key);
            this.evictionPolicy.keyAccessed(key);
            return value;
        }catch(NotFoundException e){
            System.out.println("key is not present in cache  ");
            return null;
        }

    }
    public void display(){
       this.storage.display();
    }


}
