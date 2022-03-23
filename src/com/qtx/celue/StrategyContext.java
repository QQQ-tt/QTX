package com.qtx.celue;

import java.util.HashMap;
import java.util.Map;

/**
 * 策略上下文，用于管理策略的注册和获取
 *
 * @Author: QTX
 * @Date: 2022/3/23
 */
public class StrategyContext {
    private static final Map<String, Strategy> REGISTER_MAP = new HashMap<>();

    public static void registerStrategy(String name, Strategy strategy) {
        REGISTER_MAP.putIfAbsent(name, strategy);
    }

    public static Strategy getStrategy(String name) {
        return REGISTER_MAP.get(name);
    }

}
