/**
 * FileName: UserDao
 * Author:   10418
 * Date:     2020-01-02 8:54
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 楠楠(Nannan)
 */
package com.mno.dao;

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
public interface UserDao {
    User getOneById(int id);

    int insertOne(User user);

    List<User> getListByRole(String role);

    int getCount();

    boolean deleteById(int id);

}
