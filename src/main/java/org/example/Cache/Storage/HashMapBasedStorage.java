package org.example.Cache.Storage;

import org.example.Cache.Exceptions.NotFoundException;
import org.example.Cache.Exceptions.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage <Key, Value> implements Storage<Key, Value>{

   Map<Key, Value> storage;
   private final Integer capacity;

   public HashMapBasedStorage(Integer capacity){
       this.storage = new HashMap<>();
       this.capacity = capacity;
    }

    //methods : add(), remove(), get(), isStorageFull()
    @Override
    public void add(Key key, Value value) throws StorageFullException {
       if(isStorageFull()) throw new StorageFullException("Storage full of cache");
       storage.put(key, value);

    }

    @Override
    public void remove(Key key) throws NotFoundException {
       if(!storage.containsKey(key)) throw new NotFoundException(key+" Key is not Present in cache");

       storage.remove(key);
    }

    @Override
    public Value get(Key key) throws NotFoundException {
        if(!storage.containsKey(key)) throw new NotFoundException(key+" Key is not Present in cache");
        return storage.get(key);
    }


    public Boolean isStorageFull() {
       return this.storage.size() >= capacity;
    }

    public void display(){
        for(Map.Entry<Key, Value> map : this.storage.entrySet()){
            System.out.println(map.getKey()+"   "+map.getValue());
        }
    }


}
