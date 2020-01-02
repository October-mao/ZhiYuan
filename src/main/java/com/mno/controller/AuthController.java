/**
 * FileName: AuthController
 * Author:   10418
 * Date:     2020-01-02 15:38
 * Description: 登录登出控制器
 * History:
 * <author>          <time>          <version>          <desc>
 * 楠楠(Nannan))
 */
package com.mno.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mno.bean.JsonResult;
import com.mno.bean.ResultCode;
import com.mno.model.User;
import com.mno.service.FactoryService;
import com.mno.service.UserService;
import com.mysql.cj.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * DESC〈一句话功能简述〉<br>
 * 〈登录登出控制器〉
 *
 * @author 10418
 * @create 2020-01-02
 * @since 1.0.0
 */
public class AuthController extends BaseServlet {
    public JsonResult login(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String json = new String(req.getInputStream().readAllBytes());
            if (StringUtils.isNullOrEmpty(json)) {
                return new JsonResult(ResultCode.PARAMS_ERROR);
            }
            ObjectMapper om = new ObjectMapper();
            User user = om.readValue(json, User.class);
            UserService userService = FactoryService.getUserService();
            String token = userService.login(user);
            if (StringUtils.isNullOrEmpty(token)) {
                return new JsonResult(ResultCode.INVALID_AUTH);
            } else {
                return new JsonResult(token);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JsonResult();
    }

}
