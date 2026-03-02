package org.example.Cache.EvictionPolicy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key> {

    //map + doubly linked List
    private LinkedList<Key> dll;
    private Map<Key, Boolean> mapper;

    public LRUEvictionPolicy(){
        this.dll = new LinkedList<>();
        this.mapper = new HashMap<>();

    }
    @Override
    public void keyAccessed(Key key) {
        //first remove from it place and add it into the front
        if(mapper.containsKey(key)){
            dll.remove(key);
            dll.addLast(key);
        }else{
            dll.addLast(key);
            mapper.put(key, true);
        }

    }

    @Override
    public Key evictKey(Key key)
    {

        if(dll.isEmpty()){
            return null;
        }
        Key evictedkey = dll.removeFirst();
        dll.addLast(key);
    return  evictedkey;
    }
}
