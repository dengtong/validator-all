package com.godlike.validator.oss.cache.operator;


import com.godlike.validator.oss.enums.cache.CacheTimeoutEnum;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class ValueCacheOperator extends CacheOperator<String> {

    protected String get(List<Object> keySuffixes) {
        return opsForValue().get(getKey(keySuffixes));
    }

    protected List<String> multiGet(List<List<Object>> keySuffixesList) {
        List<String> keys = new ArrayList<>();
        for (List<Object> keySuffixes : keySuffixesList) {
            keys.add(getKey(keySuffixes));
        }
        return removeNullObject(opsForValue().multiGet(keys));
    }

    protected Boolean setIfAbsent(final List<Object> keySuffixes, final String value, final CacheTimeoutEnum cacheTimeout, final boolean withRandom) {
        if (value == null) {
            return false;
        }
        int random = 0;
        if (withRandom) {
            int max = 60000;
            int min = 1000;
            random = (int) (Math.random() * (max - min) + min);
        }
        return opsForValue().setIfAbsent(getKey(keySuffixes), value, cacheTimeout.getUnit().toMillis(cacheTimeout.getTimeout()) + random, TimeUnit.MILLISECONDS);
    }


    protected void set(final List<Object> keySuffixes, final String value, final CacheTimeoutEnum cacheTimeout, final boolean withRandom) {
        if (value == null) {
            return;
        }
        int random = 0;
        if (withRandom) {
            int max = 60000;
            int min = 1000;
            random = (int) (Math.random() * (max - min) + min);
        }
        opsForValue().set(getKey(keySuffixes), value, cacheTimeout.getUnit().toMillis(cacheTimeout.getTimeout()) + random, TimeUnit.MILLISECONDS);
    }

    protected Long increment(final List<Object> keySuffixes, final long delta) {
        Long result = opsForValue().increment(getKey(keySuffixes), delta);
        return result;
    }

    protected Double increment(final List<Object> keySuffixes, final double delta) {
        Double result = opsForValue().increment(getKey(keySuffixes), delta);
        return result;
    }

    private ValueOperations<String, String> opsForValue() {
        return redisTemplate.opsForValue();
    }
}
