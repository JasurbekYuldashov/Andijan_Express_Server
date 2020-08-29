package com.example.demo.controller;

import com.example.demo.models.FileMaker;
import com.example.demo.service.FileMakerService;
import org.apache.catalina.webresources.FileResource;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.core.io.FileUrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

@RestController
@RequestMapping("/file")
@CrossOrigin
public class FileMakerController {
    private final FileMakerService fileMakerService;

//    private String uri="C:/Users/JJK  YO'LDASHEV/Desktop/demo";
    private String uri="C:/Users/Public/Desktop/demo";
    public FileMakerController(FileMakerService fileMakerService) {
        this.fileMakerService = fileMakerService;
    }

    @GetMapping("get/{id}")
    public ResponseEntity getOne(@PathVariable Integer id) throws IOException {
        FileMaker fileMaker = fileMakerService.getOne(id);
        System.out.println(String.format("%s/%s",uri,fileMaker.getUploadPath()));
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,"inline; fileName=\""+ URLEncoder.encode(fileMaker.getName()))
                .contentType(MediaType.parseMediaType(fileMaker.getContentType()))
                .contentLength(fileMaker.getFileSize())
                .body(new FileUrlResource(String.format("%s/%s",uri,fileMaker.getUploadPath())));
    }

    @PostMapping("/upload")
    public ResponseEntity save(@RequestParam("file")MultipartFile multipartFile){
        Integer id =fileMakerService.save(multipartFile);
        return ResponseEntity.ok(id);
    }
}
