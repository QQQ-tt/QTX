package com.qtx.celue.impl;

/**
 * @Author: QTX
 * @Date: 2022/3/23
 */
public class WuaiMaiImpl extends AbstractStrategy {

    private static final WuaiMaiImpl instance = new WuaiMaiImpl();

    private WuaiMaiImpl() {
        register();
    }

    public static WuaiMaiImpl getInstance() {
        return instance;
    }

    @Override
    public void issue(Object... params) {

    }
}
