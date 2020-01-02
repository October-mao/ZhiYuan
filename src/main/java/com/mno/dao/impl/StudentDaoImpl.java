package com.mno.dao.impl;

import com.mno.dao.BaseDao;
import com.mno.dao.StudentDao;
import com.mno.model.Student;

public class StudentDaoImpl extends BaseDao<Student> implements StudentDao {
    @Override
    public Student getOneById(int id) {
        Student oneData = getOneData("select * from user where id=?", id);
        return oneData;
    }
}
