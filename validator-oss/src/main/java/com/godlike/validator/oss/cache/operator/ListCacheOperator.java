package com.godlike.validator.oss.cache.operator;

import com.godlike.validator.oss.enums.cache.CacheTimeoutEnum;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class ListCacheOperator<V> extends CacheOperator<V> {

    public List<V> range(final List<Object> keySuffixes, final PageRequest pageRequest) {
        List<V> list = opsForList().range(getKey(keySuffixes), pageRequest.getOffset(), pageRequest.getOffset() + pageRequest.getPageSize() - 1);
        if (CollectionUtils.isEmpty(list)) {
            return new ArrayList<>();
        }
        return list;
    }

    public void rightPushAll(final List<Object> keySuffixes, final List<V> values, final CacheTimeoutEnum cacheTimeout, final boolean withRandom) {
        if (CollectionUtils.isEmpty(values)) {
            return;
        }
        opsForList().rightPushAll(getKey(keySuffixes), values);
        expire(keySuffixes, cacheTimeout, withRandom);
    }

    public void leftPush(final List<Object> keySuffixes, final V value, final CacheTimeoutEnum cacheTimeout, final boolean withRandom) {
        opsForList().leftPush(getKey(keySuffixes), value);
        expire(keySuffixes, cacheTimeout, withRandom);
    }

    public List<V> getAll(final List<Object> keySuffixes) {
        return opsForList().range(getKey(keySuffixes), 0, Long.MAX_VALUE);
    }

    private ListOperations<String, V> opsForList() {
        return redisTemplate.opsForList();
    }
}
