package com.godlike.validator.oss.cache.operator;

import com.godlike.validator.oss.enums.cache.CacheTimeoutEnum;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Component
public class HashCacheOperator<HK, HV> extends CacheOperator<HV> {

    protected Map<HK, HV> entries(final List<Object> keySuffixes) {
        return opsForHash().entries(getKey(keySuffixes));
    }

    protected Long delete(final List<Object> keySuffixes, final Object... hashKeys) {
        return opsForHash().delete(getKey(keySuffixes), hashKeys);
    }

    protected List<HV> multiGet(final List<Object> keySuffixes, final List<HK> hashKeys) {
        List<HV> hvList = opsForHash().multiGet(getKey(keySuffixes), hashKeys);
        Iterator<HV> iterator = hvList.iterator();
        while (iterator.hasNext()) {
            HV hv = iterator.next();
            if (hv == null) {
                iterator.remove();
            }
        }
        return hvList;
    }

    protected HV get(final List<Object> keySuffixes, final HK hashKey) {
        return opsForHash().get(getKey(keySuffixes), hashKey);
    }

    protected void putAll(final List<Object> keySuffixes, Map<HK, HV> entries, final CacheTimeoutEnum cacheTimeout, final boolean withRandom) {
        opsForHash().putAll(getKey(keySuffixes), entries);
        expire(keySuffixes, cacheTimeout, withRandom);
    }

    protected void put(final List<Object> keySuffixes, final HK hashKey, final HV hashValue, final CacheTimeoutEnum cacheTimeout, final boolean withRandom) {
        opsForHash().put(getKey(keySuffixes), hashKey, hashValue);
        expire(keySuffixes, cacheTimeout, withRandom);
    }

    protected Long increment(final List<Object> keyValuesPart, final HK hashKey, final long delta) {
        return opsForHash().increment(getKey(keyValuesPart), hashKey, delta);
    }

    protected Double increment(final List<Object> keyValuesPart, final HK hashKey, final double delta) {
        return opsForHash().increment(getKey(keyValuesPart), hashKey, delta);
    }

    protected Long multiDelete(final List<Object> keyValuesPart, final HK... hashKeys) {
        return opsForHash().delete(getKey(keyValuesPart), hashKeys);
    }

    private HashOperations<String, HK, HV> opsForHash() {
        setDefaultSerializer();
        return redisTemplate.opsForHash();
    }

}
