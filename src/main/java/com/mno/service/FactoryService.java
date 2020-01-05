/**
 * FileName: FactoryService
 * Author:   10418
 * Date:     2020-01-01 22:12
 * Description: 服务工厂类
 * History:
 * <author>          <time>          <version>          <desc>
 * 楠楠(Nannan))
 */
package com.mno.service;

import com.mno.service.impl.SpecialityServiceImpl;
import com.mno.service.impl.StudentServiceImpl;
import com.mno.service.impl.UserServiceImpl;
import com.mno.service.impl.VoluntaryServiceImpl;

/**
 * DESC〈一句话功能简述〉<br>
 * 〈服务工厂类〉
 *
 * @author 10418
 * @create 2020-01-01
 * @since 1.0.0
 */
public class FactoryService {
    public static UserService getUserService() {
        return new UserServiceImpl();
    }


    public static VoluntaryService getVoluntaryService() {
        return new VoluntaryServiceImpl();
    }
    public static SpecialityService getSpecialityService(){
        return new SpecialityServiceImpl();
    }

    public static StudentService getStudentService(){
        return new StudentServiceImpl();
    }
}
