package com.ttt.app.view;

import lombok.SneakyThrows;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;

public class NativeLibsLoader {
    @SneakyThrows
    public void load(){
        String libName = "libtdjni.so"; // The name of the file in resources/ dir
        URL url = NativeLibsLoader.class.getResource("/" + libName);
        File tmpDir = Files.createTempDirectory("ttt").toFile();
        tmpDir.deleteOnExit();
        File nativeLibTmpFile = new File(tmpDir, libName);
        nativeLibTmpFile.deleteOnExit();
        try (InputStream in = url.openStream()) {
            Files.copy(in, nativeLibTmpFile.toPath());
        }
        System.load(nativeLibTmpFile.getAbsolutePath());
    }
}
