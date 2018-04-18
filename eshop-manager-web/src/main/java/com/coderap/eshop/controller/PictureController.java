package com.coderap.eshop.controller;

import com.coderap.eshop.common.utils.FastDFSClient;
import com.coderap.eshop.common.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: eshop-parent
 * @description: 图片上传控制器
 * @author: Lennon Chin
 * @create: 2018/04/18 00:51:16
 */
@Controller
public class PictureController {

    @Value("${IMAGE_SERVER_BASE_URL}")
    private String IMAGE_SERVER_BASE_URL;

    @RequestMapping(value = "/pic/upload", produces = MediaType.TEXT_HTML_VALUE + ";charset=utf-8")
    @ResponseBody
    public String uploadImage(MultipartFile uploadFile) {

        try {
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:config/FastDFSClient.conf");
            String originalFilename = uploadFile.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            String fileUrl = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
            Map result = new HashMap();
            result.put("error", 0);
            result.put("url", this.IMAGE_SERVER_BASE_URL + fileUrl);
            return JsonUtils.objectToJson(result);
        } catch (Exception e) {
            Map result = new HashMap();
            result.put("error", 1);
            result.put("message", "上传失败");
            return JsonUtils.objectToJson(result);
        }
    }
}
