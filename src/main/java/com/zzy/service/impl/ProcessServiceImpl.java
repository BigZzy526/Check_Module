package com.zzy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzy.mapper.ProcessMapper;
import com.zzy.mapper.ReplyMapper;
import com.zzy.pojo.CheckRecord;
import com.zzy.pojo.PageBean;
import com.zzy.pojo.Result;
import com.zzy.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProcessServiceImpl implements ProcessService {
    @Autowired
    private ProcessMapper processMapper;

    @Override
    public CheckRecord getById(Integer id) {
        return processMapper.getById(id);
    }

    @Override
    public PageBean page(Integer page, Integer pageSize, String dailyPenaltyImageUrl, String studentAppealReason) {
        //1. 设置分页参数
        PageHelper.startPage(page,pageSize);

        //2. 执行查询
        List<CheckRecord> CheckList = processMapper.list1(dailyPenaltyImageUrl,studentAppealReason);
        Page<CheckRecord> p = (Page<CheckRecord>) CheckList;

        //3. 封装PageBean对象
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    @Override
    public List<CheckRecord> list() {
        return processMapper.list();
    }

    @Override
    public void process(CheckRecord chr){
        processMapper.process(chr);
    }

    @Override
    public void process2(CheckRecord chr){
        processMapper.process2(chr);
    }

    @Override
    public String getimg(CheckRecord chr) {
        Integer id = Integer.valueOf(chr.getStudentNumber());
        return processMapper.getimg(id);
    }
}
