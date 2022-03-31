package com.qtx.task;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 任务状态枚举
 *
 * @Author: QTX
 * @Date: 2022/3/23
 */
@AllArgsConstructor
@Getter
public enum TaskState {
    /**
     * 初始化
     */
    INIT("初始化"),
    /**
     * 进行中
     */
    ONGOING("进行中"),
    /**
     * 暂停中
     */
    PAUSED("暂停中"),
    /**
     * 已完成
     */
    FINISHED("已完成"),
    /**
     * 已过期
     */
    EXPIRED("已过期");

    /**
     * 任务状态
     */
    private final String message;
}
