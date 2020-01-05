/**
 * FileName: VoluntaryService
 * Author:   10418
 * Date:     2020-01-05 20:44
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 楠楠(Nannan))
 */
package com.mno.service;

import com.mno.bean.vo.VoluntaryListVo;

/**
 * DESC〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 10418
 * @create 2020-01-05
 * @since 1.0.0
 */
public interface VoluntaryService {
    VoluntaryListVo getListVoByUserId(int userId);
}
