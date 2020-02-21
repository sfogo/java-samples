package com.vnet.apps.words;

import com.vnet.apps.words.pyramid.PyramidFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;

@RestController
@CrossOrigin
@RequestMapping("/words")
public class Controller {
    @Autowired
    private PyramidFinder pyramidFinder;

    @GetMapping(value = "/pyramids/{word}")
    @ResponseStatus(HttpStatus.OK)
    public Object findPyramid(@PathVariable final String word) {
        return pyramidFinder.find(word);
    }

    @ControllerAdvice
    static class PyramidExceptionHandler extends ResponseEntityExceptionHandler {
        @ExceptionHandler(value = RuntimeException.class)
        ResponseEntity<Object> pyramidNotFound(final RuntimeException rte, final WebRequest request) {
            return handleExceptionInternal(rte,
                    new HashMap<String, String>() {{put("error", rte.getMessage());}},
                    new HttpHeaders(), HttpStatus.NOT_FOUND, request);
        }
    }
}
