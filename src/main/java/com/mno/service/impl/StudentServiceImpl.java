package com.mno.service.impl;

import com.mno.dao.FactoryDao;
import com.mno.dao.StudentDao;
import com.mno.model.Student;
import com.mno.service.StudentService;

public class StudentServiceImpl implements StudentService {
    StudentDao studentDao= FactoryDao.getStudentDao();

    @Override
    public Student getOneById(int id) {
        return null;
    }

    @Override
    public Student getOneByUserId(int userid) {
        return studentDao.getOneByUserId(userid);
    }
}
