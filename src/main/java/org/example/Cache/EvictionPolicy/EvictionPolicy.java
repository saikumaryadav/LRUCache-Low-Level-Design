package org.example.Cache.EvictionPolicy;

public interface EvictionPolicy <Key>{
    public void keyAccessed(Key key);
    Key evictKey(Key key);
}
