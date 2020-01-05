package com.mno.service;

import com.mno.bean.vo.StudentStuInfoVo;
import com.mno.model.Student;

public interface StudentService {
    Student getOneById(int id);

    StudentStuInfoVo getOneByUserId(int userid);
}
