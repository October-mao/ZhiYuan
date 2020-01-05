/**
 * FileName: VoluntaryDaoImpl
 * Author:   10418
 * Date:     2020-01-05 20:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 楠楠(Nannan))
 */
package com.mno.dao.impl;

import com.mno.dao.BaseDao;
import com.mno.dao.VoluntaryDao;
import com.mno.model.Voluntary;

/**
 * DESC〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 10418
 * @create 2020-01-05
 * @since 1.0.0
 */
public class VoluntaryDaoImpl extends BaseDao<Voluntary> implements VoluntaryDao {
    @Override
    public Voluntary getOneByUserId(int userId) {
        Voluntary oneData = getOneData("select * from voluntary where userId=?", userId);
        return oneData;

    }
}
