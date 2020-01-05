package com.mno.service.impl;

import com.mno.dao.FactoryDao;
import com.mno.dao.SpecialityDao;
import com.mno.model.Speciality;
import com.mno.service.SpecialityService;

import java.util.List;

public class SpecialityServiceImpl implements SpecialityService {
    private SpecialityDao specialityDao = FactoryDao.getSpecialityDao();

    @Override
    public List<Speciality> getListByUserId(Integer userId) {
        return specialityDao.getListByUserId(userId);
    }

    @Override
    public List<Speciality> getListById(Integer id) {
        return specialityDao.getListById(id);
    }
}
