/**
 * FileName: BeanUtil
 * Author:   10418
 * Date:     2020-01-02 9:02
 * Description: 反射操作Bea
 * History:
 * <author>          <time>          <version>          <desc>
 * 楠楠(Nannan))
 */
package com.mno.util;

import java.lang.reflect.Field;

/**
 * DESC〈一句话功能简述〉<br>
 * 〈反射操作Bean〉
 *
 * @author 10418
 * @create 2020-01-02
 * @since 1.0.0
 */
public class BeanUtil {
    public static void setProperty(Object bean, String name, Object value) {
        try {
            Field field = bean.getClass().getDeclaredField(name);
            field.setAccessible(true);
            field.set(bean, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
