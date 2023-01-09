package com.ttt.app.telegram.resource;


import org.springframework.core.io.Resource;

import java.util.LinkedHashMap;

public interface LibResource {
    LinkedHashMap<String, Resource> getResoureContext();
}
