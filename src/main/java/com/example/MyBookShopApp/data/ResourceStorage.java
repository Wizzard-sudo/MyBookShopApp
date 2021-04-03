package com.example.MyBookShopApp.data;

import com.example.MyBookShopApp.dto.book.BookFile;
import com.example.MyBookShopApp.repository.book.BookFileRepository;
import com.example.MyBookShopApp.services.book.BookFileService;
import liquibase.util.file.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

@Service
public class ResourceStorage {

    @Value("${upload.path}")
    String uploadPath;

    @Value("${download.path}")
    String downloadPath;

    private final BookFileService bookFileService;

    @Autowired
    public ResourceStorage(BookFileService bookFileService) {
        this.bookFileService = bookFileService;
    }

    public String saveNewBookImage(MultipartFile file, String slug) throws IOException {

        String resourceURI = null;
        if(!file.isEmpty()){
            if(!new File(uploadPath).exists()){
                Files.createDirectories(Paths.get(uploadPath));
                Logger.getLogger(this.getClass().getSimpleName()).info("created image folder: " + uploadPath);
            }

            String fileName = slug + "." + FilenameUtils.getExtension(file.getOriginalFilename());
            Path path = Paths.get(uploadPath, fileName);
            resourceURI = "/book-covers/" + fileName;
            file.transferTo(path);
            Logger.getLogger(this.getClass().getSimpleName()).info(fileName + " uploaded OK!");
        }
        return resourceURI;
    }

    public Path getBookFilePath(String hash) {
        BookFile bookFile = bookFileService.getBookFileByHash(hash);
        return Paths.get(bookFile.getPath());
    }

    public MediaType getBookFileMime(String hash) {
        BookFile bookFile = bookFileService.getBookFileByHash(hash);
        String mimeType = URLConnection.guessContentTypeFromName(Paths.get(bookFile.getPath()).getFileName().toString());
        if (mimeType != null){
            return MediaType.parseMediaType(mimeType);
        }else {
            return MediaType.APPLICATION_OCTET_STREAM;
        }
    }

    public byte[] getBookFileByteArray(String hash) throws IOException {
        BookFile bookFile = bookFileService.getBookFileByHash(hash);
        Path path = Paths.get(downloadPath, bookFile.getPath());
        return Files.readAllBytes(path);
    }
}
