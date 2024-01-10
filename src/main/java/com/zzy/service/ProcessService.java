package com.zzy.service;

import com.zzy.pojo.CheckRecord;
import com.zzy.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface ProcessService {
    void process(CheckRecord chr);

    CheckRecord getById(Integer id);

    PageBean page(Integer page, Integer pageSize, String dailyPenaltyImageUrl, String studentAppealReason);

    List<CheckRecord> list();

    void process2(CheckRecord chr);

    String getimg(CheckRecord chr);
}
