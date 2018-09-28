package com.alex.bunny.controller;

import com.alex.bunny.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Value("${cupSize}")
    private String cupSize;

    @Value("${age}")
    private Integer age;

    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = "/hello/{id}", method = RequestMethod.GET)
//    @GetMapping(value = "/hi")
    public String say(@PathVariable("id") Integer id,
                      @RequestParam("index") Integer index){
//        return "cupSize is :" +cupSize + ". And age is:"+age;
//        return girlProperties.getCupSize();
        return "id:" + id + "index:" + index;
    }
}
