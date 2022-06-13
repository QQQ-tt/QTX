package com.qtx.task;

import lombok.Getter;

@Getter
public enum TaskState {
    /** 初始化 */
    INIT("初始化"),
    /** 进行中 */
    ONGOING("进行中"),
    /** 暂停中 */
    PAUSED("暂停中"),
    /** 已完成 */
    FINISHED("已完成"),
    /** 已过期 */
    EXPIRED("已过期");

    /** 任务状态 */
    private final String message;

    TaskState(String message) {
        this.message = message;
    }
}
