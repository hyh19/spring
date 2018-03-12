package com.smart.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

public class FileSourceExample {

    public static void main(String[] args) {

        try {
            String filePath = "E:\\Git\\spring\\spring4x-demos\\chapter4\\src\\main\\resources\\conf\\file1.txt";
            WritableResource resource1 = new PathResource(filePath);
            System.out.println("res1: " + resource1.getFilename());

            OutputStream outputStream = resource1.getOutputStream();
            outputStream.write((new Date()).toString().getBytes());
            outputStream.close();

            InputStream inputStream = resource1.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i;
            while ((i = inputStream.read()) != -1) {
                byteArrayOutputStream.write(i);
            }
            System.out.println(byteArrayOutputStream.toString());

            Resource resource2 = new ClassPathResource("conf/file1.txt");
            System.out.println("resource2: " + resource2.getFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
