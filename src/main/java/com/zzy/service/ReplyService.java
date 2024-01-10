package com.zzy.service;

import com.zzy.pojo.CheckRecord;

public interface ReplyService {
    void addReply(CheckRecord chr);

    CheckRecord getById(String id);
}
