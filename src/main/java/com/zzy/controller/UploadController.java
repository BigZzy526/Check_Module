package com.zzy.controller;

import com.zzy.pojo.CheckRecord;
import com.zzy.pojo.Result;
import com.zzy.service.CheckService;
import com.zzy.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
public class UploadController {

    @Autowired
    private AliOSSUtils aliOSSUtils;
    @Autowired
    private CheckService checkService;

    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {

        //调用阿里云OSS工具类进行文件上传
        String url = aliOSSUtils.upload(image);

        return Result.success(url);
    }

}
