package com.example.testweb.controller;

import com.example.testweb.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {
    @PostMapping("/upload")
    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
        System.out.println(username + " " + age + " " +image);
        String imageFile = image.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String lastof = imageFile.substring(imageFile.lastIndexOf("."));
        image.transferTo(new File("C:\\Users\\31793\\Desktop\\testweb\\src\\main\\resources\\"
                + uuid + lastof));
        return Result.success();
    }
}
