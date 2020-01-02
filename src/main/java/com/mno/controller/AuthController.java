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

import com.mno.bean.JsonResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        System.out.println("dll");
        return new JsonResult();
    }

}
