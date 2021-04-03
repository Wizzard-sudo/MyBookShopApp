package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.ResourceStorage;
import com.example.MyBookShopApp.dto.book.Book;
import com.example.MyBookShopApp.dto.book.BooksPageDto;
import com.example.MyBookShopApp.services.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.sql.Date;
import java.util.List;
import java.util.logging.Logger;

//the controller responsible for working with books
@Controller
@RequestMapping("/books")
public class BooksController {

    private final BookService bookService;
    private final ResourceStorage storage;

    @Autowired
    public BooksController(BookService bookService, ResourceStorage storage) {
        this.bookService = bookService;
        this.storage = storage;
    }

    @ModelAttribute("newsBooks")
    public List<Book> newsBooks() {
        return bookService.getPageOfNewsBooks(0, 20).getContent();
    }

    @ModelAttribute("popularBooks")
    public List<Book> popularBooks() {
        return bookService.getPageOfPopularBooks(0, 20).getContent();
    }

    //return page with news books
    @GetMapping("/recent")
    public String recentPage() {
        return "books/recent";
    }

    //return page with popular books
    @GetMapping("/popular")
    public String popularPage() {
        return "books/popular";
    }

    @GetMapping("/{slug}")
    public String bookPage(@PathVariable("slug") String slug, Model model){
        Book book = bookService.getBookBySlug(slug);
        Logger.getAnonymousLogger().info(book.toString());
        model.addAttribute("slugBook", book);
        return "/books/slug";
    }

    @PostMapping("/{slug}/img/save")
    public String saveNewBookImage(@RequestParam("file")MultipartFile file, @PathVariable("slug") String slug) throws IOException {

        String savePath = storage.saveNewBookImage(file, slug);
        Book booToUpdate = bookService.getBookBySlug(slug);
        booToUpdate.setImage(savePath);
        bookService.saveBook(booToUpdate);
        return ("redirect:/books/" + slug);
    }

    @GetMapping("/download/{hash}")
    public ResponseEntity<ByteArrayResource> bookFile(@PathVariable("hash") String hash) throws IOException {
        Path path = storage.getBookFilePath(hash);
        Logger.getLogger(this.getClass().getSimpleName()).info("book file path: " + path);

        MediaType mediaType = storage.getBookFileMime(hash);
        Logger.getLogger(this.getClass().getSimpleName()).info("book file mime: " + mediaType);

        byte[] data = storage.getBookFileByteArray(hash);
        Logger.getLogger(this.getClass().getSimpleName()).info("book file data length: " + data.length);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + path.getFileName().toString())
                .contentType(mediaType)
                .contentLength(data.length)
                .body(new ByteArrayResource(data));
    }
}
