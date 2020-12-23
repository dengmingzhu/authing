package com.dmz.authing.common.db;

import java.util.Iterator;
import java.util.List;

/**
 * 分页器
 *
 * @author ccc  31/10/2017
 */
public interface Pager<T> {

    /**
     * 下一页
     */
    List<T> nextPage(int limit);

    /**
     * bufferSize = pageSize, 每次查询 bufferSize 大小的数据量, 并缓存起来, 直到没有可获取的数据
     */
    default Iterator<T> iterator(int bufferSize) {
        return new Iterator<T>() {

            private Iterator<T> bufferIterator;

            private boolean notEnded;

            @Override
            public boolean hasNext() {
                refreshIfNeeded();
                return bufferIterator.hasNext();
            }

            @Override
            public T next() {
                refreshIfNeeded();
                return bufferIterator.next();
            }

            private void refreshIfNeeded() {
                if (shouldRefresh()) {
                    bufferIterator = nextIterator(bufferSize);
                    notEnded = bufferIterator.hasNext();
                }
            }

            private boolean shouldRefresh() {
                return bufferIterator == null || (notEnded && !bufferIterator.hasNext());
            }

            Iterator<T> nextIterator(int limit) {
                return nextPage(limit).iterator();
            }

        };
    }
}
