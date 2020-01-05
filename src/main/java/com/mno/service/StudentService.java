package com.mno.service;

import com.mno.model.Student;

public interface StudentService {
    Student getOneById(int id);

    Student getOneByUserId(int userid);
}
