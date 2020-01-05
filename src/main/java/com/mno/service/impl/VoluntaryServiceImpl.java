/**
 * FileName: VoluntaryServiceImpl
 * Author:   10418
 * Date:     2020-01-05 20:44
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 楠楠(Nannan))
 */
package com.mno.service.impl;

import com.mno.bean.vo.VoluntaryListVo;
import com.mno.dao.FactoryDao;
import com.mno.dao.UserDao;
import com.mno.dao.VoluntaryDao;
import com.mno.model.User;
import com.mno.model.Voluntary;
import com.mno.service.VoluntaryService;

/**
 * DESC〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 10418
 * @create 2020-01-05
 * @since 1.0.0
 */
public class VoluntaryServiceImpl implements VoluntaryService {
    VoluntaryDao voluntaryDao = FactoryDao.getVoluntaryDao();
    UserDao userDao = FactoryDao.getUserDao();
    @Override
    public VoluntaryListVo getListVoByUserId(int userId) {
        Voluntary voluntary = voluntaryDao.getOneByUserId(userId);
        VoluntaryListVo vo=new VoluntaryListVo();
        vo.setId(voluntary.getId());
        vo.setStatus(voluntary.getStatus());
        vo.setUpdateTime(voluntary.getUpdateTime());
        vo.setUserId(userId);
        User user = userDao.getOneById(userId);
        vo.setNickname(user.getNickname());
        return vo;
    }
}
