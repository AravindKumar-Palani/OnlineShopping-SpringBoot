package com.eshop.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Component
public class CommonUtil {

    public File getFileFromResource(String fileLocation) throws IOException {

        Resource resource = new ClassPathResource(fileLocation);
        InputStream input = resource.getInputStream();
        File file = resource.getFile();

        return file;
    }
}
