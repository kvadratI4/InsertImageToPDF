package com.example.imagetopdf_project;

import java.io.*;

import com.itextpdf.io.image.*;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;

public class InsertImagePDF {
    public static void insert(String file_path)  throws IOException, FileNotFoundException, MalformedURLException {
        String currDir = System.getProperty("user.dir");
        String imageSrc =   file_path;
        ImageData data = ImageDataFactory.create(imageSrc);
        Image image1 = new Image(data);
        String path = (int)(Math.random() * 100) + "img" + (int)(Math.random() * 100)  + ".pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        Document document = new Document(pdfDocument);
        document.add(image1);
        document.close();
        System.out.println("File: " + path + " was created and saved in: " + currDir);
    }
}
