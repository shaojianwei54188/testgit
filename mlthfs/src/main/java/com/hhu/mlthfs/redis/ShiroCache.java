package com.hhu.mlthfs.redis;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 实现cache共享
 *
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class ShiroCache<k,v> implements Cache<k,v> {

    private static final String REDIS_SHIRO_CACHE = "mlthfs-shiro-cache:";
    private String cacheKey;
    private RedisTemplate<k,v> redisTemplate;
    private long globExpire=30;



    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ShiroCache(String name,RedisTemplate client){
        this.cacheKey=REDIS_SHIRO_CACHE+name+":";
        this.redisTemplate=client;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ShiroCache(String name, RedisTemplate client,long globExpire) {
        this.cacheKey = REDIS_SHIRO_CACHE+":"+ name + ":";
        this.redisTemplate = client;
        this.globExpire=globExpire;
    }

    @Override
    public v get(k key) throws CacheException {
        redisTemplate.boundValueOps(getCacheKey(key)).expire(globExpire, TimeUnit.MINUTES);
        return redisTemplate.boundValueOps(getCacheKey(key)).get();
    }

    @Override
    public v put(k key, v value) throws CacheException {
        v old = get(key);
        redisTemplate.boundValueOps(getCacheKey(key)).set(value);
        return old;
    }

    @Override
    public v remove(k key) throws CacheException {
        v old = get(key);
        redisTemplate.delete(getCacheKey(key));
        return old;
    }

    @Override
    public void clear() throws CacheException {
        redisTemplate.delete(keys());
    }

    @Override
    public int size() {
        return keys().size();
    }

    @Override
    public Set<k> keys() {
        return redisTemplate.keys(getCacheKey("*"));
    }

    @Override
    public Collection<v> values() {
        Set<k> set = keys();
        List<v> list = new ArrayList<>();
        for (k s : set) {
            list.add(get(s));
        }
        return list;
    }

    private k getCacheKey(Object k) {
        return (k) (this.cacheKey + k);
    }

}
