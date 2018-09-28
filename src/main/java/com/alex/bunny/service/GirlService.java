package com.alex.bunny.service;

import com.alex.bunny.domain.Girl;
import com.alex.bunny.enums.ResultEnum;
import com.alex.bunny.exception.GirlException;
import com.alex.bunny.repository.GirlRepository;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTow(){
        Girl girlA = new Girl();
        girlA.setCupSize("B");
        girlA.setAge(19);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("D");
        girlB.setAge(28);
        girlRepository.save(girlB);
    }

    public Girl getInfoById(Integer id) throws Exception{
        Girl girl = girlRepository.getOne(id);
        Integer age = girl.getAge();
        if (age < 10){
            throw new GirlException(ResultEnum.PRIMAYY_SCHOOL);
        }else if (age > 10 && age < 16) {
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }

        return girl;

    }

}
