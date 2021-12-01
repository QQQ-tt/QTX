package com.qtx.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qtx
 */
public class SplitList<T> {
    /**
     * 按照指定数量切割list
     *
     * @param list      被切集合
     * @param groupSize 每组长度
     *
     * @return 被切割集合
     */
    public List<List<T>> splitList(List<T> list, int groupSize) {
        int size = list.size();
        // 减1是防止出现整除导致循环次数多一次
        int num = (size + groupSize - 1) / groupSize;
        List<List<T>> lists = new ArrayList();
        for (int i = 0; i < num; i++) {
            // 开始位置
            int fromIndex = i * groupSize;
            // 结束位置，在最后一次循环会大于集合长度，所以取集合长度本身
            int toIndex = Math.min((i + 1) * groupSize, size);
            lists.add(list.subList(fromIndex, toIndex));
        }
        return lists;
    }
}
