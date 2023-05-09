package com.brxj.base.sequence;

/**
 * 雪花算法类
 *
 * @author qianrui
 */
public final class SnowFlake {

    /** 起始时间戳 */
    private final static long START_TIMESTAMP = 1514736000000L;

    /** 序列号占用位数 */
    private final static long SEQUENCE_BIT = 12L;

    /** 机器标识占用位数 */
    private final static long MACHINE_BIT = 5L;

    /** 数据中心占用位数 */
    private final static long DATA_CENTER_BIT = 5L;

    /** 序列号最大值 */
    private final static long MAX_SEQUENCE = ~(-1L << SEQUENCE_BIT);

    /** 机器标识最大值 */
    private final static long MAX_MACHINE_NUM = ~(-1L << MACHINE_BIT);

    /** 数据中心最大值 */
    private final static long MAX_DATA_CENTER_NUM = ~(-1L << DATA_CENTER_BIT);

    /** 机器标识向左位移 */
    private final static long MACHINE_LEFT = SEQUENCE_BIT;

    /** 数据中心向左位移 */
    private final static long DATA_CENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;

    /** 时间戳向左位移 */
    private final static long TIMESTAMP_LEFT = DATA_CENTER_LEFT + DATA_CENTER_BIT;

    /** 数据中心 id */
    private final long dataCenterId;

    /** 机器标识 id */
    private final long machineId;

    /** 序列号 */
    private long sequence = 0L;

    /** 上一次时间戳 */
    private long lastTimeStamp = -1L;

    public SnowFlake(long dataCenterId, long machineId) {
        if (dataCenterId > MAX_DATA_CENTER_NUM || dataCenterId < 0L) {
            throw new IllegalArgumentException("数据中心 id 不能大于 MAX_DATA_CENTER_NUM 或者小于0!");
        }

        if (machineId > MAX_MACHINE_NUM || machineId < 0L) {
            throw new IllegalArgumentException("机器标识 id 不能大于 MAX_MACHINE_NUM 或者小于0!");
        }

        this.dataCenterId = dataCenterId;
        this.machineId = machineId;
    }

    /**
     * 生成 id
     *
     * @return id
     */
    public synchronized long nextId() {
        var currTimeStamp = getNewTimeStamp();
        if (currTimeStamp < lastTimeStamp) {
            throw new RuntimeException("时钟倒退, 拒绝生成 id");
        }

        if (currTimeStamp == lastTimeStamp) {
            sequence = (sequence + 1) & MAX_SEQUENCE;
            if (sequence == 0L) {
                currTimeStamp = getNextMill();
            }
        } else {
            sequence = 0L;
        }

        lastTimeStamp = currTimeStamp;

        return (currTimeStamp - START_TIMESTAMP) << TIMESTAMP_LEFT
                | dataCenterId << DATA_CENTER_LEFT
                | machineId << MACHINE_LEFT
                | sequence;
    }

    private long getNextMill() {
        var mill = getNewTimeStamp();
        while (mill <= lastTimeStamp) {
            mill = getNewTimeStamp();
        }
        return mill;
    }

    private long getNewTimeStamp() {
        return System.currentTimeMillis();
    }
}
