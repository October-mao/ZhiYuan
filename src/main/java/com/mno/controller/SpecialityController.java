package com.mno.controller;

import com.mno.bean.JsonResult;
import com.mno.model.Speciality;
import com.mno.service.FactoryService;
import com.mno.service.SpecialityService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SpecialityController extends BaseServlet {
    private SpecialityService specialityService = FactoryService.getSpecialityService();
    public JsonResult info(HttpServletRequest req, HttpServletResponse resp) {
        Integer userId = Integer.parseInt(req.getParameter("userId"));
        List list = specialityService.getListByUserId(userId);
        return new JsonResult<>(list);
    }
}
