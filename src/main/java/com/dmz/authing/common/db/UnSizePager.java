package com.dmz.authing.common.db;

import java.util.Iterator;
import java.util.List;

/**
 * 分页器
 * 不需要指定条数
 * 用在请求外部接口时返回条数固定的情况
 * Created by zcd on 2020/10/22
 * @author zcd
 */
public interface UnSizePager<T> extends Pager<T> {
    /**
     * 下一页
     * @return 数据
     */
    List<T> nextPage();

    /**
     * 下一页
     * @param limit 限制
     * @return 数据
     */
    @Override
    default List<T> nextPage(int limit) {
        throw new IllegalStateException("unSizePager无法使用");
    }

    /**
     * 迭代器
     * @return 迭代器
     */
    default Iterator<T> iterator() {
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
                    bufferIterator = nextIterator();
                    notEnded = bufferIterator.hasNext();
                }
            }

            private boolean shouldRefresh() {
                return bufferIterator == null || (notEnded && !bufferIterator.hasNext());
            }

            Iterator<T> nextIterator() {
                return nextPage().iterator();
            }

        };
    }
}
