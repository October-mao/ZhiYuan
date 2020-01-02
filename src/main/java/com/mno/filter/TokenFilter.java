/**
 * FileName: TokenFilter
 * Author:   10418
 * Date:     2020-01-02 18:33
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 楠楠(Nannan))
 */
package com.mno.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mno.bean.JsonResult;
import com.mno.bean.ResultCode;
import com.mno.service.FactoryService;
import com.mno.util.JwtTokenUtil;
import com.mysql.cj.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * DESC〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 10418
 * @create 2020-01-02
 * @since 1.0.0
 */
public class TokenFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        //设置跨域
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "*");

        //放行auth路径的访问
        if ("/auth".equals(request.getServletPath())) {
            super.doFilter(request, response, chain);
        } else {
            //取出token
            String token = request.getHeader("Authorization");
            if (StringUtils.isNullOrEmpty(token)) {
                response.getWriter().write(new ObjectMapper().writeValueAsString(new JsonResult<>(ResultCode.INVALID_AUTH)));
                return;
            } else {
                token = token.substring("Bearer ".length());
            }
            //验证token
            if (!JwtTokenUtil.isTokenExpired(token)) {
                Integer userId = JwtTokenUtil.getUserIdFromToken(token);
                if (userId == null) {
                    response.getWriter().write(new ObjectMapper().writeValueAsString(new JsonResult<>(ResultCode.INVALID_AUTH)));
                    return;
                }
                String role = FactoryService.getUserService().getOneById(userId).getRole();

                //设置每个controller的权限
                if ("/user".equals(request.getServletPath())) {
                    if (!"admin".equals(role) && !"student".equals(role) && !"school".equals(role)) {
                        response.getWriter().write(new ObjectMapper().writeValueAsString(new JsonResult<>(ResultCode.NO_AUTH)));
                        return;
                    }
                }

                request.getSession().setAttribute("userId", userId);
                super.doFilter(request, response, chain);
            } else {
                response.getWriter().write(new ObjectMapper().writeValueAsString(new JsonResult<>(ResultCode.INVALID_AUTH)));
            }
        }

    }
}
