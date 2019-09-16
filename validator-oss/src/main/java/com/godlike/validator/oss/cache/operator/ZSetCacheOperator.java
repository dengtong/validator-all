package com.godlike.validator.oss.cache.operator;

import com.godlike.validator.oss.enums.cache.CacheTimeoutEnum;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class ZSetCacheOperator<V> extends CacheOperator<V> {

    protected Long remove(final List<Object> keySuffixes, final Object... values) {
        return opsForZSet().remove(getKey(keySuffixes), values);
    }

    protected Long removeRange(final List<Object> keySuffixes, final PageRequest pageRequest) {
        return opsForZSet().removeRange(getKey(keySuffixes), pageRequest.getOffset(), pageRequest.getOffset() + pageRequest.getPageSize() - 1);
    }

    protected Boolean add(final List<Object> keySuffixes, final V value, final double score, final CacheTimeoutEnum cacheTimeout, final boolean withRandom) {
        Boolean result = opsForZSet().add(getKey(keySuffixes), value, score);
        expire(keySuffixes, cacheTimeout, withRandom);
        return result;
    }

    protected Long add(final List<Object> keySuffixes, final Set<TypedTuple<V>> tuples, final CacheTimeoutEnum cacheTimeout, final boolean withRandom) {
        Long result = opsForZSet().add(getKey(keySuffixes), tuples);
        expire(keySuffixes, cacheTimeout, withRandom);
        return result;
    }

    protected Long zCard(final List<Object> keySuffixes) {
        return opsForZSet().zCard(getKey(keySuffixes));
    }

    protected List<V> range(final List<Object> keySuffixes, final PageRequest pageRequest) {
        Set<V> range = opsForZSet().range(getKey(keySuffixes), pageRequest.getOffset(), pageRequest.getOffset() + pageRequest.getPageSize() - 1);
        return set2List(range);
    }

    protected List<V> reverseRange(final List<Object> keySuffixes, final PageRequest pageRequest) {
        Set<V> reverseRange = opsForZSet().reverseRange(getKey(keySuffixes), pageRequest.getOffset(), pageRequest.getOffset() + pageRequest.getPageSize() - 1);
        return set2List(reverseRange);
    }


    protected List<V> rangeByScore(final List<Object> keySuffixes, final double min, final double max) {
        Set<V> rangeByScore = opsForZSet().rangeByScore(getKey(keySuffixes), min, max);
        return set2List(rangeByScore);
    }


    protected List<V> reverseRangeByScore(final List<Object> keySuffixes, double min, double max, final PageRequest pageRequest) {
        Set<V> reverseRangeByScore = opsForZSet().reverseRangeByScore(getKey(keySuffixes), min, max, pageRequest.getOffset(), pageRequest.getPageSize());
        return set2List(reverseRangeByScore);
    }


    private List<V> set2List(Set<V> reverseRange) {
        List<V> list = new ArrayList<>();
        if (CollectionUtils.isEmpty(reverseRange)) {
            return list;
        }
        for (V v : reverseRange) {
            list.add(v);
        }
        return list;
    }

    private ZSetOperations<String, V> opsForZSet() {
        return redisTemplate.opsForZSet();
    }
}
