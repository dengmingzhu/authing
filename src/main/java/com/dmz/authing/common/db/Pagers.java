package com.dmz.authing.common.db;

import java.util.List;

/**
 * @author ccc  2019-01-07
 */
public class Pagers {
    private Pagers() {
    }

    public static <T> Pager<T> synchronizedPager(Pager<T> pager) {
        return new SynchronizedPager<>(pager);
    }

    private static class SynchronizedPager<T> implements Pager<T> {

        private Pager<T> pager;

        SynchronizedPager(Pager<T> pager) {
            this.pager = pager;
        }

        @Override
        public synchronized List<T> nextPage(int limit) {
            return pager.nextPage(limit);
        }
    }
}
