/**
 * FileName: BaseServlet
 * Author:   10418
 * Date:     2020-01-02 15:47
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 楠楠(Nannan))
 */
package com.mno.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mno.bean.JsonResult;
import com.mno.bean.ResultCode;
import com.mysql.cj.util.StringUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * DESC〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 10418
 * @create 2020-01-02
 * @since 1.0.0
 */
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        try {
            // 加载类
            //设置请求编码格式
            req.setCharacterEncoding("utf-8");
            //设置响应编码格式
            resp.setContentType("application/json;charset=UTF-8");
            //获取用户传递的请求参数
            String opType = req.getParameter("type");
            if (StringUtils.isNullOrEmpty(opType)) {
                resp.getWriter().print(new ObjectMapper().writeValueAsString(new JsonResult<>(ResultCode.NOT_FOUND)));
                return;
            }
            Class<?> printClass = this.getClass();
            ;
            Method method = printClass.getDeclaredMethod(opType, HttpServletRequest.class, HttpServletResponse.class);
            //设置方法的访问权限
            method.setAccessible(true);
            Object invoke = method.invoke(this, req, resp);
            ObjectMapper om = new ObjectMapper();
            resp.getWriter().print(om.writeValueAsString(invoke));
        } catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | IOException e) {
            e.printStackTrace();
            try {
                resp.getWriter().print(new ObjectMapper().writeValueAsString(new JsonResult<>(ResultCode.NOT_FOUND)));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }


    }
}
