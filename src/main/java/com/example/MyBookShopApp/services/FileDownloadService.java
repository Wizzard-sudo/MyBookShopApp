package com.example.MyBookShopApp.services;

import com.example.MyBookShopApp.dto.FileDownload;
import com.example.MyBookShopApp.repository.FileDownloadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileDownloadService {

    private final FileDownloadRepository fileDownloadRepository;

    @Autowired
    public FileDownloadService(FileDownloadRepository fileDownloadRepository) {
        this.fileDownloadRepository = fileDownloadRepository;
    }

    public FileDownload getFileDownloadById(Integer id){
        return fileDownloadRepository.findById(id).get();
    }
}
