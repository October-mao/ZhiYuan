package com.mno.service.impl;

import com.mno.bean.vo.StudentStuInfoVo;
import com.mno.dao.FactoryDao;
import com.mno.dao.StudentDao;
import com.mno.dao.UserDao;
import com.mno.model.Student;
import com.mno.model.User;
import com.mno.service.StudentService;

public class StudentServiceImpl implements StudentService {
    StudentDao studentDao= FactoryDao.getStudentDao();
    UserDao userDao=FactoryDao.getUserDao();
    @Override
    public Student getOneById(int id) {
        return null;
    }

    @Override
    public StudentStuInfoVo getOneByUserId(int userid) {
        Student student=studentDao.getOneById(userid);
        StudentStuInfoVo studentStuInfoVo=new StudentStuInfoVo();
        studentStuInfoVo.setId(student.getId());
        studentStuInfoVo.setMathScore(student.getMathScore());
        studentStuInfoVo.setEnglishScore(student.getEnglishScore());
        studentStuInfoVo.setMajorScore(student.getMajorScore());
        studentStuInfoVo.setRank(student.getRank());
        studentStuInfoVo.setCounter(student.getCounter());
        studentStuInfoVo.setUserId(student.getUserId());
        studentStuInfoVo.setInsertTime(student.getInsertTime());
        studentStuInfoVo.setUpdateTime(student.getUpdateTime());
        User user=userDao.getOneById(userid);
        studentStuInfoVo.setNickname(user.getNickname());
        return studentStuInfoVo;
    }
}
