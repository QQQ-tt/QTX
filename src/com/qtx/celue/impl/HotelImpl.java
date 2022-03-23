package com.qtx.celue.impl;

/**
 * @Author: QTX
 * @Date: 2022/3/23
 */
public class HotelImpl extends AbstractStrategy {

    private static final HotelImpl instance = new HotelImpl();

    private HotelImpl() {
        register();
    }

    public static HotelImpl getInstance() {
        return instance;
    }

    @Override
    public void issue(Object... params) {

    }
}
