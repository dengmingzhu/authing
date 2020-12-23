package com.dmz.authing.common.db;



import java.util.Collections;
import java.util.List;
import org.springframework.util.CollectionUtils;

/**
 * 根据主键进行分页, 用主键分页在数据量较大时会比 limit 快.
 *
 * @author ccc  2019-05-13
 */
public abstract class IdPager<T extends IdAccessor> implements Pager<T> {

    private Long lastId = -1L;

    private boolean lastIdFetched = false;

    protected Long getLastId() {
        lastIdFetched = true;
        return lastId;
    }

    @Override
    public List<T> nextPage(int limit) {
        if (lastId == null) {
            throw new IllegalStateException("分页已结束!");
        }
        List<T> list = fetchNext(limit);
        // 检查在分页查询时是否调用了 getLastId() 来辅助分页
        if (!lastIdFetched) {
            throw new IllegalStateException("lastId 未在分页操作中使用!");
        }
        lastIdFetched = false;
        if (CollectionUtils.isEmpty(list)) {
            lastId = null;
            return Collections.emptyList();
        }
        if (list.size() > limit) {
            throw new IllegalStateException("limit 未在分页操作中使用!");
        }
        lastId = list.stream()
                .map(IdAccessor::getId)
                .map(Number::longValue)
                .max(Long::compareTo)
                .orElse(null);
        return list;
    }

    public abstract List<T> fetchNext(int limit);

}
