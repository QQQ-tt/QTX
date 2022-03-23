package com.qtx.celue.impl;

import com.qtx.celue.Strategy;
import com.qtx.celue.StrategyContext;

/**
 * @Author: QTX
 * @Date: 2022/3/23
 */
public abstract class AbstractStrategy implements Strategy {
    /**
     * 类注册方法
     */
    public void register() {
        StrategyContext.registerStrategy(getClass().getSimpleName(), this);
    }
}
