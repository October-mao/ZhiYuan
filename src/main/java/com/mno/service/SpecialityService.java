package com.mno.service;

import com.mno.model.Speciality;

import java.util.List;

public interface SpecialityService {
    List<Speciality> getListByUserId(Integer userId);
    List<Speciality> getListById(Integer id);
}
