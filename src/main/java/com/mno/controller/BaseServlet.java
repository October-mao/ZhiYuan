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
            if ("OPTIONS".equals(req.getMethod())) {
                return;
            }
            // 加载类
            //获取用户传递的请求参数
            String reqMethod = req.getParameter("method");
            if (StringUtils.isNullOrEmpty(reqMethod)) {
                resp.getWriter().print(new ObjectMapper().writeValueAsString(new JsonResult<>(ResultCode.NOT_FOUND)));
                return;
            }
            //通过反射取得类方法
            Class<?> printClass = this.getClass();
            Method method = printClass.getDeclaredMethod(reqMethod, HttpServletRequest.class, HttpServletResponse.class);
            method.setAccessible(true);
            //执行方法
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
