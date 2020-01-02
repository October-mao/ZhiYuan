/**
 * FileName: UserService
 * Author:   10418
 * Date:     2020-01-02 16:53
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 楠楠(Nannan))
 */
package com.mno.service;

import com.mno.model.User;

/**
 * DESC〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 10418
 * @create 2020-01-02
 * @since 1.0.0
 */
public interface UserService {
    String login(User user);
    User getOneById(int id);
}
