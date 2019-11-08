package com.ebupt.txcy.fenqu.customer;

import java.util.List;

public interface AsyncService {

    /**
     * 执行异步任务
     */
    void executeAsync(List<String> phoneList);
}