package com.alex.bunny.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

@Entity
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIgnoreProperties(ignoreUnknown=true)
public class Girl {

    @Id //主键
    @GeneratedValue //自增
    private Integer id;

    private String cupSize;

    @Min(value = 18, message = "未成年少女禁止入内")
    private Integer age;

    public Girl() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
