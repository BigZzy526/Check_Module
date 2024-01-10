package com.zzy.controller;

import com.zzy.pojo.CheckRecord;
import com.zzy.pojo.Result;
import com.zzy.service.CheckService;
import com.zzy.service.ReplyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/reply")
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    @PutMapping("/add")
    public Result addReply(@RequestBody CheckRecord chr) {
        log.info("学生添加扣分申诉: {}", chr);
        replyService.addReply(chr);
        return Result.success();
    }

//    @GetMapping("/{id}")
//    public Result getById(@PathVariable String id){
//        CheckRecord chr = replyService.getById(id);
//        return Result.success(chr);
//    }

    @GetMapping
    public Result getById(@RequestParam String id){
        CheckRecord chr = replyService.getById(id);
        return Result.success(chr);
    }
}
