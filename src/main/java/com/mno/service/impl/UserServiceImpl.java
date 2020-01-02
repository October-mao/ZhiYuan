/**
 * FileName: UserServiceImpl
 * Author:   10418
 * Date:     2020-01-02 16:54
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 楠楠(Nannan))
 */
package com.mno.service.impl;

import com.mno.dao.FactoryDao;
import com.mno.dao.UserDao;
import com.mno.model.User;
import com.mno.service.UserService;
import com.mno.util.JwtTokenUtil;

/**
 * DESC〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 10418
 * @create 2020-01-02
 * @since 1.0.0
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = FactoryDao.getUserDao();

    @Override
    public String login(User user) {
        User userT = userDao.getOneByUsername(user.getUsername());
        if (userT != null) {
            if (user.getPassword().equals(userT.getPassword())) {
                return JwtTokenUtil.generateToken(userT);
            }
        }
        return "";
    }

    @Override
    public User getOneById(int id) {
        return userDao.getOneById(id);
    }

}
