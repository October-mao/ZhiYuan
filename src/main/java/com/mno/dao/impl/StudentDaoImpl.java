package com.mno.dao.impl;

import com.mno.dao.BaseDao;
import com.mno.dao.StudentDao;
import com.mno.model.Student;

/**
 * DESC〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 10418
 * @create 2020-01-02
 * @since 1.0.0
 */
public class StudentDaoImpl extends BaseDao<Student> implements StudentDao {
    @Override
    public Student getOneById(int id) {
        Student oneData = getOneData("select * from user where id=?", id);
        return oneData;
    }
}
