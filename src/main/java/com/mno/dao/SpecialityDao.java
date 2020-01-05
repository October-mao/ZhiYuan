package com.mno.dao;

import com.mno.model.Speciality;

import java.util.List;

/**
 * DESC〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author mao
 * @create 2020-01-03
 * @since 1.0.0
 */
public interface SpecialityDao {

    List<Speciality> getListByUserId(Integer userId);

    int insertOne(Speciality speciality);

    boolean deleteById(int id);

    boolean updateOne(Speciality speciality);

    List<Speciality> getListById(Integer id);
}
