package com.zzy.service.impl;

import com.zzy.mapper.ReplyMapper;
import com.zzy.pojo.CheckRecord;
import com.zzy.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiecImpl implements ReplyService {
    @Autowired
    private ReplyMapper replyMapper;

    @Override
    public void addReply(CheckRecord chr) {
        replyMapper.addReply(chr);
    }

    @Override
    public CheckRecord getById(String id) {
        return replyMapper.getById(id);
    }



}
