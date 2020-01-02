/**
 * FileName: UserDaoImpl
 * Author:   10418
 * Date:     2020-01-02 9:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 楠楠(Nannan))
 */
package com.mno.dao.impl;

import com.mno.dao.BaseDao;
import com.mno.dao.UserDao;
import com.mno.model.User;

import java.util.List;

/**
 * DESC〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 10418
 * @create 2020-01-02
 * @since 1.0.0
 */
public class UserDaoImpl extends BaseDao<User> implements UserDao {

    @Override
    public User getOneById(int id) {
        User oneData = getOneData("select * from user where id=?", id);
        return oneData;
    }

    @Override
    public int insertOne(User user) {
        iud("insert into user(nickname,username,password,role) values(?,?,?,?)", user.getNickname()
                , user.getUsername(), user.getPassword(), user.getRole()
        );
        return 0;
    }

    @Override
    public List<User> getListByRole(String role) {
        List<User> listData = getListData("select * from user where role=?", role);
        return listData;

    }

    @Override
    public int getCount() {
        Number count = (Number) getOneColumn("select count(*) from user");
        return count.intValue();
    }

    @Override
    public boolean updatePwd(int id, String pwd) {
        int iud = iud("update user set password=? where id=?", pwd, id);
        if (iud > 0) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public boolean deleteById(int id) {
        int iud = iud("delete * from user where id=?", id);
        return iud > 0 ? true:false;
    }

    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        List<User> a = userDao.getListByRole("admin");
        for (User v : a) {
            System.out.println(v.getNickname());
        }
        int count = userDao.getCount();
        System.out.println(count);

    }
}
