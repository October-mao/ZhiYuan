package com.mno.controller;

import com.mno.bean.JsonResult;
import com.mno.model.Student;
import com.mno.service.FactoryService;
import com.mno.service.StudentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentController extends BaseServlet {
    StudentService studentService= FactoryService.getStudentService();
    public JsonResult stuInfo(HttpServletRequest req, HttpServletResponse resp){
        Integer userId = (Integer) req.getSession().getAttribute("userId");
        Student student=studentService.getOneByUserId(userId);
        return new JsonResult(student);
    }
}
