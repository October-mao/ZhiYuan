/**
 * FileName: VoluntaryController
 * Author:   10418
 * Date:     2020-01-05 20:48
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 楠楠(Nannan))
 */
package com.mno.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mno.bean.JsonResult;
import com.mno.bean.PageBean;
import com.mno.bean.ResultCode;
import com.mno.bean.vo.VoluntaryListVo;
import com.mno.model.Voluntary;
import com.mno.service.FactoryService;
import com.mno.service.VoluntaryService;
import com.mysql.cj.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * DESC〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 10418
 * @create 2020-01-05
 * @since 1.0.0
 */
public class VoluntaryController extends BaseServlet {
    private VoluntaryService voluntaryService = FactoryService.getVoluntaryService();

    public JsonResult list(HttpServletRequest req, HttpServletResponse resp) {
        Integer userId = (Integer) req.getSession().getAttribute("userId");
        VoluntaryListVo oneByUserId = voluntaryService.getListVoByUserId(userId);
        List<VoluntaryListVo> list = new ArrayList<>();
        list.add(oneByUserId);
        return new JsonResult(new PageBean<>(1, list));
    }

    public JsonResult update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer userId = (Integer) req.getSession().getAttribute("userId");
        String json = new String(req.getInputStream().readAllBytes());
        if (StringUtils.isNullOrEmpty(json)) {
            return new JsonResult(ResultCode.PARAMS_ERROR);
        }
        ObjectMapper om = new ObjectMapper();
        Voluntary voluntary = om.readValue(json, Voluntary.class);
        voluntary.setUserId(userId);
        if (voluntaryService.update(voluntary)) {
            return new JsonResult();
        } else {
            return new JsonResult(ResultCode.VALIDATED_ERROR);
        }

    }

    public JsonResult submit(HttpServletRequest req, HttpServletResponse resp) {
        Integer userId = (Integer) req.getSession().getAttribute("userId");
        if (voluntaryService.submit(userId)) {
            return new JsonResult();
        } else {
            return new JsonResult(ResultCode.UNKNOWN_ERROR);
        }

    }
}
