package com.alex.bunny.controller;

import com.alex.bunny.domain.Result;
import com.alex.bunny.repository.GirlRepository;
import com.alex.bunny.domain.Girl;
import com.alex.bunny.service.GirlService;
import com.alex.bunny.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        return girlRepository.findAll();
    }

    @GetMapping(value = "/findByAge/{age}")
    public List<Girl> findByAge(@PathVariable(value = "age") Integer age){
        return girlRepository.findByAge(age);
    }

    @GetMapping(value = "insertTwo")
    public void insertTow(){
        girlService.insertTow();
    }

    @PostMapping(value = "insertGirl")
    public Girl insertGirl(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        return girlRepository.save(girl);
    }

    @PostMapping(value = "getInfoById/{id}")
    public Result getInfoById(@PathVariable("id") Integer id) throws Exception{
        return ResultUtil.success(girlService.getInfoById(id));
    }

}
