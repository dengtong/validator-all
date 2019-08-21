package com.godlike.validator.oss.cache.operator;

import com.godlike.validator.oss.enums.cache.CacheTimeoutEnum;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SetCacheOperator<V> extends CacheOperator<V> {

    protected Long remove(final List<Object> keySuffixes, final Object... values) {
        return opsForSet().remove(getKey(keySuffixes), values);
    }

    protected Long add(final List<Object> keySuffixes, final V[] values, final CacheTimeoutEnum cacheTimeout, final boolean withRandom) {
        Long result = opsForSet().add(getKey(keySuffixes), values);
        expire(keySuffixes, cacheTimeout, withRandom);
        return result;
    }

    protected Long size(final List<Object> keySuffixes) {
        return opsForSet().size(getKey(keySuffixes));
    }

    protected V randomMember(List<Object> keySuffixes) {
        return opsForSet().randomMember(getKey(keySuffixes));
    }

    protected List<V> randomMembers(List<Object> keySuffixes, long count) {
        return opsForSet().randomMembers(getKey(keySuffixes), count);
    }

    protected Boolean isMember(List<Object> keySuffixes, Object o) {
        return opsForSet().isMember(getKey(keySuffixes), o);
    }

    private SetOperations<String, V> opsForSet() {
        setDefaultSerializer();
        return redisTemplate.opsForSet();
    }
}
