package com.example.MyBookShopApp.dto.book;

public enum BookFileTypeEnum {

    PDF(".pdf"),
    EPUB(".epub"),
    FB2(".fb2");

    private  final String fileExtensionString;


    BookFileTypeEnum(String fileExtensionString) {
        this.fileExtensionString = fileExtensionString;
    }

    public static String getExtensionStringByTypeId(Integer type_id){
        switch (type_id){
            case 1: return BookFileTypeEnum.PDF.fileExtensionString;
            case 2: return BookFileTypeEnum.EPUB.fileExtensionString;
            case 3: return BookFileTypeEnum.FB2.fileExtensionString;
            default: return "";
        }
    }
}
