package com.qtx.celue;

/**
 * @Author: QTX
 * @Date: 2022/3/23
 */
public interface Strategy {
    /**
     * 策略接口
     *
     * @param params 不定量参数
     */
    void issue(Object... params);
}
