package com.ttt.app.telegram.resource;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

@Component
@Conditional(OnLinuxCondition.class)
public class LinuxLibResource implements LibResource {
    @Value("classpath:/libtdjni.so")
    private Resource libtdjniResoure;

    public LinkedHashMap<String, Resource> getResoureContext() {
        LinkedHashMap<String, Resource> map = new LinkedHashMap<>();
        map.put("libtdjni.so", libtdjniResoure);
        return map;
    }
}
