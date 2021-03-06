/**
 * FileName: FactoryDao
 * Author:   10418
 * Date:     2020-01-01 22:19
 * Description: dao工程类
 * History:
 * <author>          <time>          <version>          <desc>
 * 楠楠(Nannan))
 */
package com.mno.dao;

import com.mno.dao.impl.SpecialityDaoImpl;
import com.mno.dao.impl.StudentDaoImpl;
import com.mno.dao.impl.UserDaoImpl;
import com.mno.dao.impl.VoluntaryDaoImpl;

/**
 * DESC〈一句话功能简述〉<br>
 * 〈dao工厂类〉
 *
 * @author 10418
 * @create 2020-01-01
 * @since 1.0.0
 */
public class FactoryDao {
    public static UserDao getUserDao() {
        return new UserDaoImpl();
    }

    public static VoluntaryDao getVoluntaryDao() {
        return new VoluntaryDaoImpl();
    }

    public static SpecialityDao getSpecialityDao() {
        return new SpecialityDaoImpl();
    }
    public static StudentDao getStudentDao(){
        return new StudentDaoImpl();
    }
}
