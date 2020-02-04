package com.vnet.apps.things;

import com.vnet.apps.things.paths.NorthEastPaths;
import com.vnet.apps.things.paths.PathsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/things")
public class Controller {
    @Autowired
    private NorthEastPaths paths;

    @Value("${app.message}")
    private String message;

    @GetMapping(value = "/home")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> home() {
        return new HashMap<String, Object>() {{
            put("message", message);
        }};
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> echo(@PathVariable final String id) {
        return new HashMap<String, Object>() {{
            put("id", id);
            put("ts", System.currentTimeMillis());
        }};
    }

    @GetMapping(value = "/paths", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Object paths(final PathsRequest request) {
        return paths.get(request.getW(), request.getH());
    }

    @GetMapping(value = "/counts", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Object count(final PathsRequest request) {
        return new HashMap<String, Object>() {{
            put("width", request.getW());
            put("height", request.getH());
            put("count", paths.count(request.getW(), request.getH()));
        }};
    }
}
