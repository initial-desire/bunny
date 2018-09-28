package com.alex.bunny.repository;

import com.alex.bunny.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl, Integer> {

    //通过年龄查询girl
    public List<Girl> findByAge(Integer age);

}
