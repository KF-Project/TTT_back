package com.kf.ttt.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kf.ttt.entity.Num;

@Mapper
public interface NumRepository {
    public List<Num> numToKor();
}
