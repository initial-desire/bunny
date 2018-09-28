package com.alex.bunny;

import com.alex.bunny.domain.Girl;
import com.alex.bunny.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlTest {

    @Autowired
    private GirlService girlService;

    @Test
    @Transactional
    public void getOne() throws Exception{
        Girl girl = girlService.getInfoById(7);
        Assert.assertEquals(new Integer(28), girl.getAge());
    }

}
