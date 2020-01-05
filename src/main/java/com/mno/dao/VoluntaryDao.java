/**
 * FileName: VoluntaryDao
 * Author:   10418
 * Date:     2020-01-05 20:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 楠楠(Nannan)
 */
package com.mno.dao;

import com.mno.model.Voluntary;

/**
 * DESC〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 10418
 * @create 2020-01-05
 * @since 1.0.0
 */
public interface VoluntaryDao {
    Voluntary getOneByUserId(int userId);

    boolean insertOne(Voluntary voluntary);

    boolean updateOne(Voluntary voluntary);

    boolean submit(int userId);
}
