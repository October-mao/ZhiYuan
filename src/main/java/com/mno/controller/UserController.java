/**
 * FileName: UserController
 * Author:   10418
 * Date:     2020-01-02 21:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 楠楠(Nannan))
 */
package com.mno.controller;

import com.mno.bean.JsonResult;
import com.mno.model.User;
import com.mno.service.FactoryService;
import com.mno.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * DESC〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 10418
 * @create 2020-01-02
 * @since 1.0.0
 */
public class UserController extends BaseServlet {
    private UserService userService = FactoryService.getUserService();
    public JsonResult info(HttpServletRequest req, HttpServletResponse resp) {
        Integer userId = (Integer) req.getSession().getAttribute("userId");
        User user = userService.getOneById(userId);
        Map<String, Object> info = new HashMap<>(4);
        info.put("introduction", user.getNickname());
        info.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        info.put("name", user.getUsername());
        info.put("roles", user.getRole());
        return new JsonResult<>(info);
    }
}
