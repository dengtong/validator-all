package com.godlike.validator.oss.cache.operator;

import com.godlike.validator.oss.constant.CacheConstant;
import com.godlike.validator.oss.enums.cache.CacheTimeoutEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CacheOperator<V> {

    private static final Logger logger = LoggerFactory.getLogger(CacheOperator.class);
    @Resource
    protected RedisTemplate<String, V> redisTemplate;

    public String getKey(List<Object> keySuffixes) {
        if (keySuffixes == null) {
            throw new IllegalArgumentException("key自定义部分[keySuffixes]不能为null");
        }
        List<Object> keyParts = new ArrayList<>();
        keyParts.add(CacheConstant.KEY_COMPANY_PART);
        keyParts.add(CacheConstant.KEY_DEPARTMENT_PART);
        keyParts.addAll(keySuffixes);
        return editKey(keyParts);
    }

    private String editKey(List<Object> keyParts) {
        StringBuilder key = new StringBuilder();
        if (!CollectionUtils.isEmpty(keyParts)) {
            for (Object keyPart : keyParts) {
                key.append(keyPart).append(CacheConstant.KEY_CONCAT_CHARACTER);
            }
        }
        key.deleteCharAt(key.lastIndexOf(CacheConstant.KEY_CONCAT_CHARACTER));
        return key.toString();
    }

    public final void delete(List<Object> keySuffixes) {
        String key = getKey(keySuffixes);
        setDefaultSerializer();
        redisTemplate.delete(key);
        if (logger.isDebugEnabled()) {
            logger.debug("delete cache success. KeyPattern:{}", key);
        }
    }

    protected final List<V> removeNullObject(final List<V> list) {
        List<V> retList = new ArrayList<>();
        if (CollectionUtils.isEmpty(list)) {
            return retList;
        }
        for (V v : list) {
            if (v != null) {
                retList.add(v);
            }
        }
        return retList;
    }

    /**
     * 设置缓存过期时间,为了减少缓存雪崩的情况，通常在设定的过期时间上增加一个随机时间
     *
     * @param keySuffixes
     * @param cacheTimeout
     * @param withRandom
     * @return
     */
    protected final Boolean expire(List<Object> keySuffixes, final CacheTimeoutEnum cacheTimeout, boolean withRandom) {
        int random = 0;
        if (withRandom) {
            int max = 60000;
            int min = 1000;
            random = (int) (Math.random() * (max - min) + min);
        }
        setDefaultSerializer();
        return redisTemplate.expire(getKey(keySuffixes), cacheTimeout.getUnit().toMillis(cacheTimeout.getTimeout()) + random, TimeUnit.MILLISECONDS);
    }

    private Class<V> getVClass() {
        Class<V> tClass = (Class<V>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return tClass;
    }

    public void setDefaultSerializer() {
        redisTemplate.setDefaultSerializer(new Jackson2JsonRedisSerializer<>(getVClass()));
    }
}
