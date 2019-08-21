package com.godlike.validator.oss.enums.cache;

import java.util.concurrent.TimeUnit;

/**
 * 缓存过期时间配置。需要新的缓存时间时，在此枚举中添加。
 */
public enum CacheTimeoutEnum {
    /**
     * 100毫秒
     */
    MILLISECONDS_100(100L, TimeUnit.MILLISECONDS),
    /**
     * 30秒
     */
    SECONDS_30(30L, TimeUnit.SECONDS),
    /**
     * 5分钟
     */
    MINUTES_5(5L, TimeUnit.MINUTES),
    /**
     * 10分钟
     */
    MINUTES_10(10L, TimeUnit.MINUTES),
    /**
     * 30分钟
     */
    MINUTES_30(30L, TimeUnit.MINUTES),
    /**
     * 1小时
     */
    HOURS_1(1L, TimeUnit.HOURS),
    /**
     * 2小时
     */
    HOURS_2(2L, TimeUnit.HOURS),

    /**
     * 25小时
     */
    HOURS_25(25L, TimeUnit.HOURS),

    /**
     * 26小时
     */
    HOURS_26(26L, TimeUnit.HOURS),

    /**
     * 一天
     */
    DAYS_1(1L, TimeUnit.DAYS);


    private long timeout;
    private TimeUnit unit;

    CacheTimeoutEnum(long timeout, TimeUnit unit) {
        this.timeout = timeout;
        this.unit = unit;
    }

    public long getTimeout() {
        return timeout;
    }

    public TimeUnit getUnit() {
        return unit;
    }

}
