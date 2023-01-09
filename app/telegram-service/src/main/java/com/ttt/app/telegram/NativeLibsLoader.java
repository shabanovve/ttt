package com.ttt.app.telegram;

import com.ttt.app.telegram.resource.LibResource;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

@RequiredArgsConstructor
@Component
public class NativeLibsLoader {

    private final LibResource libResource;

    public void load() {
        libResource.getResoureContext().entrySet().stream()
                .forEach(entry -> {
                            String libName = entry.getKey();
                            System.out.print("Loading lib with name " + libName);
                            try {
                                File nativeLibTmpFile = createTmpFile(
                                        libName,
                                        libResource.getResoureContext().get(libName)
                                );
                                System.load(nativeLibTmpFile.getAbsolutePath());
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                );
    }

    private File createTmpFile(String libName, Resource resourceFile) throws IOException {
        File tmpDir = Files.createTempDirectory("ttt").toFile();
        tmpDir.deleteOnExit();
        File nativeLibTmpFile = new File(tmpDir, libName);
        nativeLibTmpFile.deleteOnExit();
        try (InputStream in = resourceFile.getInputStream()) {
            Files.copy(in, nativeLibTmpFile.toPath());
        }
        return nativeLibTmpFile;
    }
}
