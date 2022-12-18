package com.ttt.app.javafxui.view;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;

@RequiredArgsConstructor
@Component
public class NativeLibsLoader {
    @Value("classpath:/libtdjni.so")
    Resource resourceFile;
    @SneakyThrows
    public void load(){
        String libName = "libtdjni.so"; // The name of the file in resources/ dir
        File tmpDir = Files.createTempDirectory("ttt").toFile();
        tmpDir.deleteOnExit();
        File nativeLibTmpFile = new File(tmpDir, libName);
        nativeLibTmpFile.deleteOnExit();
        try (InputStream in = resourceFile.getInputStream()) {
            Files.copy(in, nativeLibTmpFile.toPath());
        }
        System.load(nativeLibTmpFile.getAbsolutePath());
    }
}
