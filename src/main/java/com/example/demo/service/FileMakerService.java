package com.example.demo.service;

import com.example.demo.models.FileMaker;
import com.example.demo.repository.FileMakerRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@Service
public class FileMakerService {
    private final FileMakerRepository fileMakerRepository;

//    @Value("${upload.folder}")
    private String uri;

    public FileMakerService(FileMakerRepository fileMakerRepository) {
        this.fileMakerRepository = fileMakerRepository;
    }

    private String getExt(String fileName) {
        String ext = null;
        if (fileName != null && !fileName.isEmpty()) {
            int dot = fileName.lastIndexOf('.');
            if (dot > 0 && dot <= fileName.length() - 2) {
                ext = fileName.substring(dot + 1);
            }
        }
        return ext;
    }

    @Transactional(readOnly = true)
    public FileMaker getOne(Integer id){
        return fileMakerRepository.findByDeletedFalseAndId(id);
    }

    public Integer save(MultipartFile multipartFile) {
        FileMaker fileMaker = new FileMaker();
//        fileMaker.setCategoryId(id);
        fileMaker.setName(multipartFile.getOriginalFilename());
        fileMaker.setExtension(getExt(multipartFile.getOriginalFilename()));
        fileMaker.setFileSize(multipartFile.getSize());
        fileMaker.setContentType(multipartFile.getContentType());
        fileMakerRepository.save(fileMaker);

        Date now = new Date();
        File uploadFolder = new File(String.format("%s/upload_folder/%d/%d/%d", this.uri, now.getYear() + 1970,
                now.getMonth() + 1, now.getDate()));
        if (!uploadFolder.exists() && uploadFolder.mkdirs()) {
            System.out.println("yes");
        }
        fileMaker.setUploadPath(String.format("%s/upload_folder/%d/%d/%d/%s.%s", this.uri, now.getYear() + 1970,
                now.getMonth() + 1, now.getDate(), fileMaker.getId(), fileMaker.getExtension()));
        fileMakerRepository.save(fileMaker);
        uploadFolder = uploadFolder.getAbsoluteFile();
        File file = new File(uploadFolder,String.format("%s.%s",fileMaker.getId(),fileMaker.getExtension()));
        try {
            multipartFile.transferTo(file);
        } catch (IOException e){
            e.printStackTrace();
        }
        return fileMaker.getId();
    }
}
